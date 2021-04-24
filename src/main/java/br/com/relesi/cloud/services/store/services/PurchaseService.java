package br.com.relesi.cloud.services.store.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.relesi.cloud.services.store.client.ProviderClient;
import br.com.relesi.cloud.services.store.dto.InfoOrderDto;
import br.com.relesi.cloud.services.store.dto.InfoProviderDTO;
import br.com.relesi.cloud.services.store.dto.PurchaseDTO;
import br.com.relesi.cloud.services.store.model.Purchase;

@Service
public class PurchaseService {

	private static final Logger LOG = LoggerFactory.getLogger(PurchaseService.class);

	@Autowired
	private ProviderClient providerClient;

	@HystrixCommand(fallbackMethod = "accomplishPurchaseFallback")
	public Purchase accomplishPurchase(PurchaseDTO purchase) {

		final String state = purchase.getAddress().getState();

		LOG.info("Seeking provider information by {}", state);
		InfoProviderDTO info = providerClient.getInfoToState(purchase.getAddress().getState());

		LOG.info("Placing order");
		InfoOrderDto infoOrder = providerClient.placeOrder(purchase.getItems());

		Purchase purchaseSave = new Purchase();
		purchaseSave.setOrderDemand(infoOrder.getId());
		purchaseSave.setPreparation(infoOrder.getPreparation());
		purchaseSave.setDestinationAddress(info.getAddress().toString());

		// System.out.println(info.getAddress());0

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return purchaseSave;
	}

	public Purchase accomplishPurchaseFallback(PurchaseDTO purchase) {

		Purchase purchaseFallback = new Purchase();
		purchaseFallback.setDestinationAddress(purchase.getAddress().toString());
		return purchaseFallback;

	}

}
