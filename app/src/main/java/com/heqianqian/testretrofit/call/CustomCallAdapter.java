package com.heqianqian.testretrofit.call;

import java.lang.reflect.Type;

import retrofit2.Call;
import retrofit2.CallAdapter;

/**
 * CustomCallAdapter
 * Created by heqianqian on 2017/3/26.
 */
public class CustomCallAdapter implements CallAdapter<CustomCall<?>>{

    private final Type responseType;

    public CustomCallAdapter(Type responseType) {
        this.responseType = responseType;
    }

    @Override
    public Type responseType() {
        return responseType;
    }

    @Override
    public <R> CustomCall<R> adapt(Call<R> call) {
        return new CustomCall<>(call);
    }

}
