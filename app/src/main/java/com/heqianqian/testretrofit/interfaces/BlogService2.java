package com.heqianqian.testretrofit.interfaces;

import com.heqianqian.testretrofit.call.CustomCall;
import com.heqianqian.testretrofit.entity.Blog;
import com.heqianqian.testretrofit.entity.Result;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * BlogService2
 * Created by heqianqian on 2017/3/26.
 */
public interface BlogService2 {

    @GET("blog/{id}")
    CustomCall<String> getBlog3(@Path("id") int id);

    @GET("blog/{id}")
    Call<String> getBlog2(@Path("id") int id);

    @GET("blog/{id}")
    Call<Result<Blog>> getBlog(@Path("id") int id);

    @POST("blog")
    Call<Result<Blog>> postBlog(@Body Blog blog);

    @GET("/blog")
    Observable<Result<List<Blog>>> getBlogs(@Query("page") int page);
}
