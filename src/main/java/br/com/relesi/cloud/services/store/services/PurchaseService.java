package br.com.relesi.cloud.services.store.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.relesi.cloud.services.store.dto.InfoProviderDTO;
import br.com.relesi.cloud.services.store.dto.PurchaseDTO;

@Service
public class PurchaseService {
	
	@Autowired
	private RestTemplate client;

	public void accomplishPurchase(PurchaseDTO purchase) {

		
		ResponseEntity<InfoProviderDTO> exchange =	
				client.exchange("http://provider/info/" + purchase.getAddress().getState(), 
				HttpMethod.GET, null,InfoProviderDTO.class);
		
		System.out.println(exchange.getBody().getAddress());
	}

}
