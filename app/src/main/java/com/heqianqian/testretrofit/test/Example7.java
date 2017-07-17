package com.heqianqian.testretrofit.test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.heqianqian.testretrofit.entity.Blog;
import com.heqianqian.testretrofit.entity.Result;
import com.heqianqian.testretrofit.interfaces.BlogService2;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observer;
import rx.schedulers.Schedulers;

/**
 * Example7
 * 测试Rxjava和Converter
 * Created by heqianqian on 2017/3/26.
 */

public class Example7 {
    public static void main(String[] args) {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd hh:mm:ss")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:4567/")
                .addConverterFactory(GsonConverterFactory.create(gson)) //Call泛型支持
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create()) //替换Call
                .build();

        BlogService2 blogService2 = retrofit.create(BlogService2.class);
        blogService2.getBlogs(1)
                .observeOn(Schedulers.io())
                .subscribe(new Observer<Result<List<Blog>>>() {
                    @Override
                    public void onCompleted() {
                        System.out.println("onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(Result<List<Blog>> listResult) {
                        System.out.println(listResult);
                    }
                });
    }
}
