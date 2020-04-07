package com.example.tradex.Models;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ExchangeInfo{

	@SerializedName("rateLimits")
	private List<RateLimitsItem> rateLimits;

	@SerializedName("exchangeFilters")
	private List<Object> exchangeFilters;

	@SerializedName("timezone")
	private String timezone;

	@SerializedName("serverTime")
	private long serverTime;

	@SerializedName("symbols")
	private List<SymbolsItem> symbols;

	public void setRateLimits(List<RateLimitsItem> rateLimits){
		this.rateLimits = rateLimits;
	}

	public List<RateLimitsItem> getRateLimits(){
		return rateLimits;
	}

	public void setExchangeFilters(List<Object> exchangeFilters){
		this.exchangeFilters = exchangeFilters;
	}

	public List<Object> getExchangeFilters(){
		return exchangeFilters;
	}

	public void setTimezone(String timezone){
		this.timezone = timezone;
	}

	public String getTimezone(){
		return timezone;
	}

	public void setServerTime(long serverTime){
		this.serverTime = serverTime;
	}

	public long getServerTime(){
		return serverTime;
	}

	public void setSymbols(List<SymbolsItem> symbols){
		this.symbols = symbols;
	}

	public List<SymbolsItem> getSymbols(){
		return symbols;
	}

	@Override
 	public String toString(){
		return 
			"ExchangeInfo{" + 
			"rateLimits = '" + rateLimits + '\'' + 
			",exchangeFilters = '" + exchangeFilters + '\'' + 
			",timezone = '" + timezone + '\'' + 
			",serverTime = '" + serverTime + '\'' + 
			",symbols = '" + symbols + '\'' + 
			"}";
		}
}