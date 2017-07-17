package com.heqianqian.testretrofit.call;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import retrofit2.CallAdapter;
import retrofit2.Retrofit;

import static com.google.gson.internal.$Gson$Types.getRawType;

/**
 * CustomCallAdapterFactory
 * Created by heqianqian on 2017/3/26.
 */
public class CustomCallAdapterFactory extends CallAdapter.Factory{

    public static final CustomCallAdapterFactory INSTANCE = new CustomCallAdapterFactory();


    @Override
    public CallAdapter<?> get(Type returnType, Annotation[] annotations, Retrofit retrofit) {
        //获取原始类型
        Class<?> rawType = getRawType(returnType);
        //返回值必须是CustomCall并且带有泛型
        if (rawType == CustomCall.class && returnType instanceof ParameterizedType){
            Type callReturnType = getParameterUpperBound(0, (ParameterizedType) returnType);
            return new CustomCallAdapter(callReturnType);
        }
        return null;
    }
}
