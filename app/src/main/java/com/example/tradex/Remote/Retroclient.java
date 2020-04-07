package com.example.tradex.Remote;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class Retroclient {
    private static  final String BASE_URL="https://api.binance.com";
    public static Call<ResponseBody> getInstance;
    private static Retroclient mInstance;
    private  Retrofit retrofit;
    public static endpoints postService=null;
    private Retroclient(){
       // Log.e("tag","fail 1");
        retrofit=new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }


    public static synchronized Retroclient getInstance(){
        if (mInstance==null){
            //Log.e("tag","fail  2");
            mInstance=new Retroclient();
        }
        return mInstance;
    }
    public endpoints getApi(){
       // Log.e("tag","fail...3");
        return retrofit.create(endpoints.class);
    }
}
