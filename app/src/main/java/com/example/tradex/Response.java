package com.example.tradex;

import com.google.gson.annotations.SerializedName;

public class Response{

	@SerializedName("q")
	private String Q;

	@SerializedName("s")
	private String S;

	@SerializedName("c")
	private String C;

	@SerializedName("e")
	private String E;

	@SerializedName("E")
	private long e;

	@SerializedName("v")
	private String V;

	@SerializedName("h")
	private String H;

	@SerializedName("l")
	private String L;

	@SerializedName("o")
	private String O;

	public void setQ(String Q){
		this.Q = Q;
	}

	public String getQ(){
		return Q;
	}

	public void setS(String S){
		this.S = S;
	}

	public String getS(){
		return S;
	}

	public void setC(String C){
		this.C = C;
	}

	public String getC(){
		return C;
	}

	public void setE(String E){
		this.E = E;
	}



	public void setE(long E){
		this.e = Long.parseLong(String.valueOf(E));
	}

	public long getE(){
		return Long.parseLong(E);
	}

	public void setV(String V){
		this.V = V;
	}

	public String getV(){
		return V;
	}

	public void setH(String H){
		this.H = H;
	}

	public String getH(){
		return H;
	}

	public void setL(String L){
		this.L = L;
	}

	public String getL(){
		return L;
	}

	public void setO(String O){
		this.O = O;
	}

	public String getO(){
		return O;
	}

	@Override
 	public String toString(){
		return 
			"Response{" + 
			"q = '" + Q + '\'' + 
			",s = '" + S + '\'' + 
			",c = '" + C + '\'' + 
			",e = '" + E + '\'' + 
			",E = '" + E + '\'' + 
			",v = '" + V + '\'' + 
			",h = '" + H + '\'' + 
			",l = '" + L + '\'' + 
			",o = '" + O + '\'' + 
			"}";
		}
}