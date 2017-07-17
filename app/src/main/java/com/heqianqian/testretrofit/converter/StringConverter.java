package com.heqianqian.testretrofit.converter;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * StringConverter
 * Created by heqianqian on 2017/3/26.
 */
public class StringConverter implements Converter<ResponseBody,String> {

    private static StringConverter instance;


    private StringConverter() {
    }

    public static StringConverter getInstance(){
        if (instance == null){
            instance = new StringConverter();
        }
        return instance;
    }

    @Override
    public String convert(ResponseBody value) throws IOException {
        return value.string();
    }
}
