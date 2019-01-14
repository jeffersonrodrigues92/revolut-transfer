package com.transfer.demo.rest.service;


import javax.enterprise.context.RequestScoped;

@RequestScoped
public class TransferService {

	public String hello() {
		return "Hello friends";
	}
	
}
