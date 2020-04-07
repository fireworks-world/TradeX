package com.example.tradex.Models;

import com.google.gson.annotations.SerializedName;

public class FiltersItem{

	@SerializedName("filterType")
	private String filterType;

	@SerializedName("maxNumAlgoOrders")
	private int maxNumAlgoOrders;

	@SerializedName("stepSize")
	private String stepSize;

	@SerializedName("maxQty")
	private String maxQty;

	@SerializedName("minQty")
	private String minQty;

	@SerializedName("limit")
	private int limit;

	@SerializedName("minNotional")
	private String minNotional;

	@SerializedName("avgPriceMins")
	private int avgPriceMins;

	@SerializedName("applyToMarket")
	private boolean applyToMarket;

	@SerializedName("multiplierDown")
	private String multiplierDown;

	@SerializedName("multiplierUp")
	private String multiplierUp;

	@SerializedName("minPrice")
	private String minPrice;

	@SerializedName("maxPrice")
	private String maxPrice;

	@SerializedName("tickSize")
	private String tickSize;

	public void setFilterType(String filterType){
		this.filterType = filterType;
	}

	public String getFilterType(){
		return filterType;
	}

	public void setMaxNumAlgoOrders(int maxNumAlgoOrders){
		this.maxNumAlgoOrders = maxNumAlgoOrders;
	}

	public int getMaxNumAlgoOrders(){
		return maxNumAlgoOrders;
	}

	public void setStepSize(String stepSize){
		this.stepSize = stepSize;
	}

	public String getStepSize(){
		return stepSize;
	}

	public void setMaxQty(String maxQty){
		this.maxQty = maxQty;
	}

	public String getMaxQty(){
		return maxQty;
	}

	public void setMinQty(String minQty){
		this.minQty = minQty;
	}

	public String getMinQty(){
		return minQty;
	}

	public void setLimit(int limit){
		this.limit = limit;
	}

	public int getLimit(){
		return limit;
	}

	public void setMinNotional(String minNotional){
		this.minNotional = minNotional;
	}

	public String getMinNotional(){
		return minNotional;
	}

	public void setAvgPriceMins(int avgPriceMins){
		this.avgPriceMins = avgPriceMins;
	}

	public int getAvgPriceMins(){
		return avgPriceMins;
	}

	public void setApplyToMarket(boolean applyToMarket){
		this.applyToMarket = applyToMarket;
	}

	public boolean isApplyToMarket(){
		return applyToMarket;
	}

	public void setMultiplierDown(String multiplierDown){
		this.multiplierDown = multiplierDown;
	}

	public String getMultiplierDown(){
		return multiplierDown;
	}

	public void setMultiplierUp(String multiplierUp){
		this.multiplierUp = multiplierUp;
	}

	public String getMultiplierUp(){
		return multiplierUp;
	}

	public void setMinPrice(String minPrice){
		this.minPrice = minPrice;
	}

	public String getMinPrice(){
		return minPrice;
	}

	public void setMaxPrice(String maxPrice){
		this.maxPrice = maxPrice;
	}

	public String getMaxPrice(){
		return maxPrice;
	}

	public void setTickSize(String tickSize){
		this.tickSize = tickSize;
	}

	public String getTickSize(){
		return tickSize;
	}

	@Override
 	public String toString(){
		return 
			"FiltersItem{" + 
			"filterType = '" + filterType + '\'' + 
			",maxNumAlgoOrders = '" + maxNumAlgoOrders + '\'' + 
			",stepSize = '" + stepSize + '\'' + 
			",maxQty = '" + maxQty + '\'' + 
			",minQty = '" + minQty + '\'' + 
			",limit = '" + limit + '\'' + 
			",minNotional = '" + minNotional + '\'' + 
			",avgPriceMins = '" + avgPriceMins + '\'' + 
			",applyToMarket = '" + applyToMarket + '\'' + 
			",multiplierDown = '" + multiplierDown + '\'' + 
			",multiplierUp = '" + multiplierUp + '\'' + 
			",minPrice = '" + minPrice + '\'' + 
			",maxPrice = '" + maxPrice + '\'' + 
			",tickSize = '" + tickSize + '\'' + 
			"}";
		}
}