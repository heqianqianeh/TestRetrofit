package com.heqianqian.testretrofit.converter;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 * StringConverterFactory
 * Created by heqianqian on 2017/3/26.
 */
public class StringConverterFactory extends Converter.Factory {

    private static StringConverterFactory instance;

    private StringConverterFactory() {
    }

    public static StringConverterFactory getInstance(){
        if (instance == null){
            instance = new StringConverterFactory();
        }
        return instance;
    }

    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        if (type == String.class){
            return StringConverter.getInstance();
        }
        return null;
    }
}
