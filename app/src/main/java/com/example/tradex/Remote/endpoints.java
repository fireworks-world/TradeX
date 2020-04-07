package com.example.tradex.Remote;


import com.example.tradex.Models.ExchangeInfo;

import retrofit2.Call;
import retrofit2.http.GET;

public interface endpoints {


    @GET("/api/v3/exchangeInfo")
    Call<ExchangeInfo> getData();
}
