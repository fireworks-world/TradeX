package com.example.tradex;

import android.os.Bundle;

import androidx.core.app.Person;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class TradeXHomeView extends Fragment {
    private RecyclerView recyclerView;
    private AdapterCardView madaptor;
    private Context context;
    private SwipeRefreshLayout Refresh;
    private OkHttpClient client;
    private ArrayList<String> baseAsset= new ArrayList<String>();
    private ArrayList<String> quoteAsset= new ArrayList<String>();
    private ArrayList<String> price=new ArrayList<>();



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.fragment_trade_x_home_view, null);

        context =v.getContext().getApplicationContext();
        Refresh = v.findViewById(R.id.Refresh);
        recyclerView = v.findViewById(R.id.HomeRecyclerView);
        client = new OkHttpClient();
        start();
        Refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                retrofit2.Call<ExchangeInfo> call=Retroclient.getInstance().getApi().getData();
                call.enqueue(new Callback<ExchangeInfo>() {
                    @Override
                    public void onResponse(Call<ExchangeInfo> call, Response<ExchangeInfo> response) {
                        ExchangeInfo exchangeInfo=response.body();
                        List<SymbolsItem> symbolsItemList=exchangeInfo.getSymbols();
                        for (int i=0;i<symbolsItemList.size();i++)
                        {
                            baseAsset.add(symbolsItemList.get(i).getBaseAsset());
                            quoteAsset.add(symbolsItemList.get(i).getQuoteAsset());
                        }
                        madaptor = new AdapterCardView(baseAsset,quoteAsset,price,context);
                        recyclerView = recyclerView.findViewById(R.id.HomeRecyclerView);
                        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                        recyclerView.setItemAnimator(new DefaultItemAnimator());
                        recyclerView.setHasFixedSize(true);
                        recyclerView.setAdapter(madaptor);
                        Refresh.setRefreshing(false);

                    }

                    @Override
                    public void onFailure(Call<ExchangeInfo> call, Throwable t) {
                        Log.e("tag","msgs  "+t.fillInStackTrace());
                    }
                });
            }
        });
        retrofit2.Call<ExchangeInfo> call=Retroclient.getInstance().getApi().getData();
        call.enqueue(new Callback<ExchangeInfo>() {
            @Override
            public void onResponse(Call<ExchangeInfo> call, Response<ExchangeInfo> response) {
                ExchangeInfo exchangeInfo=response.body();
                List<SymbolsItem> symbolsItemList=exchangeInfo.getSymbols();
                for (int i=0;i<symbolsItemList.size();i++)
                {
                    baseAsset.add(symbolsItemList.get(i).getBaseAsset());
                    quoteAsset.add(symbolsItemList.get(i).getQuoteAsset());
                }

                madaptor = new AdapterCardView(baseAsset,quoteAsset,price,context);
                recyclerView = recyclerView.findViewById(R.id.HomeRecyclerView);
                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerView.setHasFixedSize(true);
                recyclerView.setAdapter(madaptor);
            }

            @Override
            public void onFailure(Call<ExchangeInfo> call, Throwable t) {
                Log.e("tag","msgs  "+t.fillInStackTrace());
            }
        });

        return v;
    }
    private void start() {
        Request request = new Request.Builder().url("wss://stream.binance.com:9443/ws/btcusdt@miniTicker/ethusdt@miniTicker").build();
        EchoWebSocketListener listener = new EchoWebSocketListener();
        WebSocket ws = client.newWebSocket(request, listener);
        client.dispatcher().executorService().shutdown();
    }
    private final class EchoWebSocketListener extends WebSocketListener {
        private static final int NORMAL_CLOSURE_STATUS = 1000;
        @Override
        public void onOpen(WebSocket webSocket, okhttp3.Response response) {
        }
        @Override
        public void onMessage(WebSocket webSocket, String text) {
            Log.e("data",text);
            try {
                //output(new JSONObject(text));
                Gson gson = new GsonBuilder().create();
                com.example.tradex.Response p = gson.fromJson(text, com.example.tradex.Response.class);
                price.add(p.getO());
                price.add(p.getC());


            } catch (Throwable t) {
                Log.e("My App", t.getMessage());
            }

        }
        @Override
        public void onMessage(WebSocket webSocket, ByteString bytes) {
            Log.d("bytes",bytes.toString());
        }
        @Override
        public void onClosing(WebSocket webSocket, int code, String reason) {
            webSocket.close(NORMAL_CLOSURE_STATUS, null);
            Log.d("close",reason);
        }
        @Override
        public void onFailure(WebSocket webSocket, Throwable t, okhttp3.Response response) {
            Log.d("Error",t.getMessage());
        }

        }
    }

