package com.heqianqian.testretrofit.interfaces;

import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

/**
 * BlogService
 * Created by heqianqian on 2017/3/26.
 */
public interface BlogService {

    /*===========Base============*/

    @GET("blog/{id}")
    Call<ResponseBody> getBlog1(@Path("id") int id);

     /*===========HTTP============*/

    /**
     * method 表示请求的方法，区分大小写
     * path表示路径
     * hasBody表示是否有请求体
     */
    @HTTP(method = "GET", path = "blog/{id}", hasBody = false)
    Call<ResponseBody> getBlog2(@Path("id") int id);

     /*===========标记类============*/

    /**
     * {@link FormUrlEncoded} 表明是一个表单格式的请求（Content-Type:application/x-www-form-urlencoded）
     * <code>Field("username")</code> 表示将后面的 <code>String name</code> 中name的取值作为 username 的值
     */
    @POST("/form")
    @FormUrlEncoded
    Call<ResponseBody> testFormUrlEncoded1(@Field("username") String username,
                                           @Field("age") int age);

    /**
     * map的key作为表单的键
     */
    @POST("/form")
    @FormUrlEncoded
    Call<ResponseBody> testFormUrlEncoded2(@FieldMap Map<String,Object> map);

    /**
     * {@link Part} 后面支持三种类型，{@link RequestBody}、{@link okhttp3.MultipartBody.Part} 、任意类型
     * 除 {@link okhttp3.MultipartBody.Part} 以外，其它类型都必须带上表单字段({@link okhttp3.MultipartBody.Part} 中已经包含了表单字段的信息)，
     */
    @POST("/form")
    @Multipart
    Call<ResponseBody> testFileUpload1(@Part("name") RequestBody name, @Part("age") RequestBody age, @Part MultipartBody.Part file);

    /**
     * PartMap 注解支持一个Map作为参数，支持 {@link RequestBody } 类型，
     * 如果有其它的类型，会被{@link retrofit2.Converter}转换，如后面会介绍的 使用{@link com.google.gson.Gson} 的 {@link retrofit2.converter.gson.GsonRequestBodyConverter}
     * 所以{@link MultipartBody.Part} 就不适用了,所以文件只能用<b> @Part MultipartBody.Part </b>
     */
    @POST("/form")
    @Multipart
    Call<ResponseBody> testFileUpload2(@PartMap Map<String, RequestBody> args, @Part MultipartBody.Part file);

    @POST("/form")
    @Multipart
    Call<ResponseBody> testFileUpload3(@PartMap Map<String, RequestBody> args);

    /*===========参数类============*/

    /* Header && Headers*/
    @GET("/headers?showAll=true")
    @Headers({"CustomHeader1: customHeaderValue1", "CustomHeader2: customHeaderValue2"})
    Call<ResponseBody> testHeader(@Header("CustomHeader3") String CustomHeader3);

    /*Query、QueryMap、Url*/
    /**
     * 当GET、POST...HTTP等方法中没有设置Url时，则必须使用 {@link Url}提供
     * 对于Query和QueryMap，如果不是String（或Map的第二个泛型参数不是String）时
     * 会被默认会调用toString转换成String类型
     * Url支持的类型有 okhttp3.HttpUrl, String, java.net.URI, android.net.Uri
     * {@link retrofit2.http.QueryMap} 用法和{@link retrofit2.http.FieldMap} 用法一样，不再说明
     */
    @GET
    Call<ResponseBody> testUrlAndQuery(@Url String url, @Query("showAll") boolean showAll);
}
