package com.devsuperior.hrpayroll.services;

import java.io.Serializable;

import org.springframework.stereotype.Service;

import com.devsuperior.hrpayroll.entities.Payment;

@Service
public class PaymentService implements Serializable {
	private static final long serialVersionUID = 1L;

	public Payment getPayment(long workerId, int days) {
		return new Payment("Bob", 200.0, days);
	}
}
