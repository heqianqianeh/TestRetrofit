package com.heqianqian.testretrofit.test;

import com.heqianqian.testretrofit.interfaces.BlogService;
import com.heqianqian.testretrofit.utils.ResponseBodyPrinter;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;

/**
 * Example5
 * 测试Query、QueryMap、Url注解
 * Created by heqianqian on 2017/3/26.
 */

public class Example5 {
    public static void main(String[] args) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:4567/")
                .build();

        BlogService service = retrofit.create(BlogService.class);

        //演示 @Headers 和 @Header
        Call<ResponseBody> call1 = service.testUrlAndQuery("headers",false);
        ResponseBodyPrinter.printResponseBody(call1);
    }
}
