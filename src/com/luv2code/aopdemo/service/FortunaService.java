package com.luv2code.aopdemo.service;

import java.util.concurrent.TimeUnit;

import javax.management.RuntimeErrorException;

import org.springframework.stereotype.Component;

@Component
public class FortunaService {
	
	public String getFortuna() {
		
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "Too much traffic!!!!";
	}

	public String getFortuna(Boolean tripWire) {
		
		if(tripWire) {
			throw new RuntimeException( "Major accident! highway is closed");
		}
		
		return getFortuna();
	}
}
