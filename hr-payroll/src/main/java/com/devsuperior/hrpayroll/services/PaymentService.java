package com.devsuperior.hrpayroll.services;

import org.springframework.stereotype.Service;

import com.devsuperior.hrpayroll.entities.Payment;

@Service
public class PaymentService {

	/**
	 * metodo responsável por devolver o pagamento do trabalhador
	 * 
	 * @param workerId
	 * @param days
	 * @return
	 */
	public Payment getPayment(long workerId, int days) {
		return new Payment("Bob", 200.0, days);
	}
	
}
