package com.njust.domain;


/**
 * Userinfo entity. @author MyEclipse Persistence Tools
 */

public class Tradeinfo implements java.io.Serializable {

	// Fields
	private int traderecordid;
	private String username;
	private String tradename;
	private float tradeamount;
	private String tradetime;
	// Constructors

	/** default constructor */
	public Tradeinfo() {
	}

	public Tradeinfo(int traderecordid, String username, String tradename,
			float tradeamount, String tradetime) {
		super();
		this.traderecordid = traderecordid;
		this.username = username;
		this.tradename = tradename;
		this.tradeamount = tradeamount;
		this.tradetime = tradetime;
	}

	public int getTraderecordid() {
		return traderecordid;
	}

	public void setTraderecordid(int traderecordid) {
		this.traderecordid = traderecordid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTradename() {
		return tradename;
	}

	public void setTradename(String tradename) {
		this.tradename = tradename;
	}

	public float getTradeamount() {
		return tradeamount;
	}

	public void setTradeamount(float tradeamount) {
		this.tradeamount = tradeamount;
	}

	public String getTradetime() {
		return tradetime;
	}

	public void setTradetime(String tradetime) {
		this.tradetime = tradetime;
	}

}