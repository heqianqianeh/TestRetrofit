package com.heqianqian.testretrofit.test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.heqianqian.testretrofit.entity.Blog;
import com.heqianqian.testretrofit.entity.Result;
import com.heqianqian.testretrofit.interfaces.BlogService2;

import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Example6
 * 测试Gson与Converter
 * Created by heqianqian on 2017/3/26.
 */
public class Example6 {
    public static void main(String[] args) {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd hh:mm:ss")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:4567/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        BlogService2 blogService2 = retrofit.create(BlogService2.class);
        Call<Result<Blog>> call = blogService2.getBlog(2);
        call.enqueue(new Callback<Result<Blog>>() {
            @Override
            public void onResponse(Call<Result<Blog>> call, Response<Result<Blog>> response) {
                Result<Blog> result = response.body();
                System.out.println(result);
            }

            @Override
            public void onFailure(Call<Result<Blog>> call, Throwable t) {
                t.printStackTrace();
            }
        });



        Blog blog = new Blog();
        blog.content = "新建的Blog";
        blog.title = "测试";
        blog.author = "怪盗kidou";
        call = blogService2.postBlog(blog);
        call.enqueue(new Callback<Result<Blog>>() {
            @Override
            public void onResponse(Call<Result<Blog>> call, Response<Result<Blog>> response) {
                Result<Blog> result = response.body();
                System.out.println(result);
            }

            @Override
            public void onFailure(Call<Result<Blog>> call, Throwable t) {
                t.printStackTrace();
            }
        });

    }
}
