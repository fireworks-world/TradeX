package com.example.tradex;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;

public interface endpoints {


    @GET("/api/v3/exchangeInfo")
    Call<ExchangeInfo> getData();
}
