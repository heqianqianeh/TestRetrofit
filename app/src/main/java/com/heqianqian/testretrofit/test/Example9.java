package com.heqianqian.testretrofit.test;

import com.heqianqian.testretrofit.call.CustomCall;
import com.heqianqian.testretrofit.call.CustomCallAdapterFactory;
import com.heqianqian.testretrofit.converter.StringConverterFactory;
import com.heqianqian.testretrofit.interfaces.BlogService;
import com.heqianqian.testretrofit.interfaces.BlogService2;

import java.io.IOException;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Example9
 * 自定义CallAdapter
 * Created by heqianqian on 2017/3/26.
 */

public class Example9 {
    public static void main(String[] args) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:4567/")
                .addConverterFactory(StringConverterFactory.getInstance())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(CustomCallAdapterFactory.INSTANCE)
                .build();

        BlogService2 service = retrofit.create(BlogService2.class);
        CustomCall<String> call = service.getBlog3(2);
        try {
            String result = call.get();
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
