package com.devsuperior.hrpayroll.services;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.devsuperior.hrpayroll.entities.Payment;
import com.devsuperior.hrpayroll.entities.Worker;
import com.devsuperior.hrpayroll.feignclients.WorkerFeignClient;

@Service
public class PaymentService implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	WorkerFeignClient workerFeignClient;
	
	public Payment getPayment(long workerId, int days) {
//		Map<String, String> uriVariables = new HashMap<>();
//		uriVariables.put("id", String.valueOf(workerId));
//		Worker worker = restTemplate.getForObject(workerHost+"/workers/{id}", Worker.class, uriVariables);
		Worker worker = workerFeignClient.findById(workerId).getBody();
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}
}
