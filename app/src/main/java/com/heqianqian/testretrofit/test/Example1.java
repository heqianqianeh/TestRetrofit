package com.heqianqian.testretrofit.test;

import com.heqianqian.testretrofit.interfaces.BlogService;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Example1
 * 基本用法
 * Created by heqianqian on 2017/3/26.
 */
public class Example1 {

    public static void main(String[] args) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:4567/")
                .build();
        BlogService blogService = retrofit.create(BlogService.class);
        Call<ResponseBody> call = blogService.getBlog1(2);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try{
                    System.out.printf(response.body().string());
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
