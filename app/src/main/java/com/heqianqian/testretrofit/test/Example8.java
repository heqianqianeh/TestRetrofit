package com.heqianqian.testretrofit.test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.heqianqian.testretrofit.converter.StringConverterFactory;
import com.heqianqian.testretrofit.interfaces.BlogService2;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Example8
 * 自定义Converter
 * Created by heqianqian on 2017/3/26.
 */
public class Example8 {
    public static void main(String[] args) {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd hh:mm:ss")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:4567/")
                .addConverterFactory(StringConverterFactory.getInstance())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        BlogService2 blogService2 = retrofit.create(BlogService2.class);
        Call<String> call = blogService2.getBlog2(2);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                System.out.println(response.body());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
