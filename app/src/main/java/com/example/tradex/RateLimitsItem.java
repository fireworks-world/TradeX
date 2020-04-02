package com.example.tradex;

import com.google.gson.annotations.SerializedName;

public class RateLimitsItem{

	@SerializedName("intervalNum")
	private int intervalNum;

	@SerializedName("limit")
	private int limit;

	@SerializedName("interval")
	private String interval;

	@SerializedName("rateLimitType")
	private String rateLimitType;

	public void setIntervalNum(int intervalNum){
		this.intervalNum = intervalNum;
	}

	public int getIntervalNum(){
		return intervalNum;
	}

	public void setLimit(int limit){
		this.limit = limit;
	}

	public int getLimit(){
		return limit;
	}

	public void setInterval(String interval){
		this.interval = interval;
	}

	public String getInterval(){
		return interval;
	}

	public void setRateLimitType(String rateLimitType){
		this.rateLimitType = rateLimitType;
	}

	public String getRateLimitType(){
		return rateLimitType;
	}

	@Override
 	public String toString(){
		return 
			"RateLimitsItem{" + 
			"intervalNum = '" + intervalNum + '\'' + 
			",limit = '" + limit + '\'' + 
			",interval = '" + interval + '\'' + 
			",rateLimitType = '" + rateLimitType + '\'' + 
			"}";
		}
}