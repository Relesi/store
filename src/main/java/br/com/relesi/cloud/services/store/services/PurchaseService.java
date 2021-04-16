package br.com.relesi.cloud.services.store.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.relesi.cloud.services.store.client.ProviderClient;
import br.com.relesi.cloud.services.store.dto.InfoProviderDTO;
import br.com.relesi.cloud.services.store.dto.PurchaseDTO;

@Service
public class PurchaseService {

	@Autowired
	private ProviderClient providerClient;

	public void accomplishPurchase(PurchaseDTO purchase) {

		InfoProviderDTO info = providerClient.getInfoToState(purchase.getAddress().getState());
		
		
		System.out.println(info.getAddress());
	}

}
