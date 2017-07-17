package com.heqianqian.testretrofit.test;

import com.heqianqian.testretrofit.interfaces.BlogService;
import com.heqianqian.testretrofit.utils.ResponseBodyPrinter;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;

/**
 * Example2
 * 测试HTTP类注解
 * Created by heqianqian on 2017/3/26.
 */
public class Example2 {
    public static void main(String[] args) {
        Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl("http://localhost:4567/")
                            .build();
        BlogService blogService = retrofit.create(BlogService.class);
        Call<ResponseBody> responseBodyCall = blogService.getBlog1(1);
        ResponseBodyPrinter.printResponseBody(responseBodyCall);
    }
}
