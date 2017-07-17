package com.heqianqian.testretrofit.call;

import java.io.IOException;

import retrofit2.Call;

/**
 * CustomCall
 * Created by heqianqian on 2017/3/26.
 */
public class CustomCall<R> {
    public final Call<R> call;


    public CustomCall(Call<R> call) {
        this.call = call;
    }

    public R get() throws IOException {
        return call.execute().body();
    }
}
