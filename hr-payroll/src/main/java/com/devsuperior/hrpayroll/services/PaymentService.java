package com.devsuperior.hrpayroll.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.devsuperior.hrpayroll.entities.Payment;
import com.devsuperior.hrpayroll.entities.Worker;

@Service
public class PaymentService {
	
	// recuperar valor de atributo declarado
	// no arquivo application.properties
	@Value("${hr-worker.host}")
	private String workerHost;
	
	@Autowired
	private RestTemplate restTemplate;

	/**
	 * metodo responsável por devolver o pagamento do trabalhador
	 * 
	 * @param workerId
	 * @param days
	 * @return
	 */
	public Payment getPayment(long workerId, int days) {
		
		// preparando parametros da requisição
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("id", Long.toString(workerId));
		
		// realizando requisição com rest template
		// {id} sera mapeado com a chave id no Map
		// uriVariables
		Worker worker = restTemplate.getForObject(workerHost + "/workers/{id}", 
				Worker.class, uriVariables);
		
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
		
	}
	
}
