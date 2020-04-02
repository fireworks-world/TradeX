package com.example.tradex;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class SymbolsItem{

	@SerializedName("symbol")
	private String symbol;

	@SerializedName("quoteOrderQtyMarketAllowed")
	private boolean quoteOrderQtyMarketAllowed;

	@SerializedName("baseAsset")
	private String baseAsset;

	@SerializedName("filters")
	private List<FiltersItem> filters;

	@SerializedName("baseAssetPrecision")
	private int baseAssetPrecision;

	@SerializedName("isSpotTradingAllowed")
	private boolean isSpotTradingAllowed;

	@SerializedName("quoteCommissionPrecision")
	private int quoteCommissionPrecision;

	@SerializedName("ocoAllowed")
	private boolean ocoAllowed;

	@SerializedName("quotePrecision")
	private int quotePrecision;

	@SerializedName("orderTypes")
	private List<String> orderTypes;

	@SerializedName("icebergAllowed")
	private boolean icebergAllowed;

	@SerializedName("isMarginTradingAllowed")
	private boolean isMarginTradingAllowed;

	@SerializedName("quoteAsset")
	private String quoteAsset;

	@SerializedName("baseCommissionPrecision")
	private int baseCommissionPrecision;

	@SerializedName("status")
	private String status;

	public void setSymbol(String symbol){
		this.symbol = symbol;
	}

	public String getSymbol(){
		return symbol;
	}

	public void setQuoteOrderQtyMarketAllowed(boolean quoteOrderQtyMarketAllowed){
		this.quoteOrderQtyMarketAllowed = quoteOrderQtyMarketAllowed;
	}

	public boolean isQuoteOrderQtyMarketAllowed(){
		return quoteOrderQtyMarketAllowed;
	}

	public void setBaseAsset(String baseAsset){
		this.baseAsset = baseAsset;
	}

	public String getBaseAsset(){
		return baseAsset;
	}

	public void setFilters(List<FiltersItem> filters){
		this.filters = filters;
	}

	public List<FiltersItem> getFilters(){
		return filters;
	}

	public void setBaseAssetPrecision(int baseAssetPrecision){
		this.baseAssetPrecision = baseAssetPrecision;
	}

	public int getBaseAssetPrecision(){
		return baseAssetPrecision;
	}

	public void setIsSpotTradingAllowed(boolean isSpotTradingAllowed){
		this.isSpotTradingAllowed = isSpotTradingAllowed;
	}

	public boolean isIsSpotTradingAllowed(){
		return isSpotTradingAllowed;
	}

	public void setQuoteCommissionPrecision(int quoteCommissionPrecision){
		this.quoteCommissionPrecision = quoteCommissionPrecision;
	}

	public int getQuoteCommissionPrecision(){
		return quoteCommissionPrecision;
	}

	public void setOcoAllowed(boolean ocoAllowed){
		this.ocoAllowed = ocoAllowed;
	}

	public boolean isOcoAllowed(){
		return ocoAllowed;
	}

	public void setQuotePrecision(int quotePrecision){
		this.quotePrecision = quotePrecision;
	}

	public int getQuotePrecision(){
		return quotePrecision;
	}

	public void setOrderTypes(List<String> orderTypes){
		this.orderTypes = orderTypes;
	}

	public List<String> getOrderTypes(){
		return orderTypes;
	}

	public void setIcebergAllowed(boolean icebergAllowed){
		this.icebergAllowed = icebergAllowed;
	}

	public boolean isIcebergAllowed(){
		return icebergAllowed;
	}

	public void setIsMarginTradingAllowed(boolean isMarginTradingAllowed){
		this.isMarginTradingAllowed = isMarginTradingAllowed;
	}

	public boolean isIsMarginTradingAllowed(){
		return isMarginTradingAllowed;
	}

	public void setQuoteAsset(String quoteAsset){
		this.quoteAsset = quoteAsset;
	}

	public String getQuoteAsset(){
		return quoteAsset;
	}

	public void setBaseCommissionPrecision(int baseCommissionPrecision){
		this.baseCommissionPrecision = baseCommissionPrecision;
	}

	public int getBaseCommissionPrecision(){
		return baseCommissionPrecision;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"SymbolsItem{" + 
			"symbol = '" + symbol + '\'' + 
			",quoteOrderQtyMarketAllowed = '" + quoteOrderQtyMarketAllowed + '\'' + 
			",baseAsset = '" + baseAsset + '\'' + 
			",filters = '" + filters + '\'' + 
			",baseAssetPrecision = '" + baseAssetPrecision + '\'' + 
			",isSpotTradingAllowed = '" + isSpotTradingAllowed + '\'' + 
			",quoteCommissionPrecision = '" + quoteCommissionPrecision + '\'' + 
			",ocoAllowed = '" + ocoAllowed + '\'' + 
			",quotePrecision = '" + quotePrecision + '\'' + 
			",orderTypes = '" + orderTypes + '\'' + 
			",icebergAllowed = '" + icebergAllowed + '\'' + 
			",isMarginTradingAllowed = '" + isMarginTradingAllowed + '\'' + 
			",quoteAsset = '" + quoteAsset + '\'' + 
			",baseCommissionPrecision = '" + baseCommissionPrecision + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}