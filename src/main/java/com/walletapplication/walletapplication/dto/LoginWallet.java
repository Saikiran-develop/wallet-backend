package com.walletapplication.walletapplication.dto;

public class LoginWallet {
	private Integer id;
	private String password;
	public LoginWallet() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "LoginWallet [id=" + id + ", password=" + password + "]";
	}
	
}
