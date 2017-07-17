package com.heqianqian.testretrofit.test;

import com.heqianqian.testretrofit.interfaces.BlogService;
import com.heqianqian.testretrofit.utils.ResponseBodyPrinter;

import java.util.HashMap;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.Streaming;

/**
 * Example3
 * 测试标记类注解
 * {@link FormUrlEncoded, Multipart , Streaming}
 * Created by heqianqian on 2017/3/26.
 */
public class Example3 {
    public static void main(String[] args) {
        Retrofit retrofit = new Retrofit.Builder()
                                .baseUrl("http://localhost:4567/")
                                .build();
        BlogService blogService = retrofit.create(BlogService.class);

        //test @Field and @FormUrlEncoded
        Call<ResponseBody> responseBodyCall = blogService.testFormUrlEncoded1("怪盗kidou",24);
        ResponseBodyPrinter.printResponseBody(responseBodyCall);

        //test @FieldMap and @FormUrlEncoded
        Map<String,Object> map = new HashMap<>();
        map.put("name","怪盗kidou");
        map.put("age",24);
        responseBodyCall = blogService.testFormUrlEncoded2(map);
        ResponseBodyPrinter.printResponseBody(responseBodyCall);

        MediaType textType = MediaType.parse("text/plain");
        RequestBody name = RequestBody.create(textType,"怪盗kidou");
        RequestBody age = RequestBody.create(textType,"24");
        RequestBody file = RequestBody.create(MediaType.parse("application/octet-stream"), "这里是模拟文件的内容");

        //test @Multipart and @Part
        MultipartBody.Part filePart = MultipartBody.Part.createFormData("file", "test.txt", file);;
        responseBodyCall = blogService.testFileUpload1(name,age,filePart);
        ResponseBodyPrinter.printResponseBody(responseBodyCall);

        //test @MultiPart and @PartMap
        Map<String,RequestBody> map1 = new HashMap<>();
        map1.put("name",name);
        map1.put("age",age);
        responseBodyCall = blogService.testFileUpload2(map1,filePart);
        ResponseBodyPrinter.printResponseBody(responseBodyCall);

        //test
        map1.put("file\"; filename=\"test.txt",file);
        responseBodyCall = blogService.testFileUpload3(map1);
        ResponseBodyPrinter.printResponseBody(responseBodyCall);
    }
}
