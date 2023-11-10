package com.kanikakohli.horoscopeexamp;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    public static final String BASE_URL="https://jaddu12.000webhostapp.com/";
    public static Retrofit retrofit=null;

    public static Retrofit getRetrofit(){
        if (retrofit==null)
        {
            retrofit=new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;

    }
}
