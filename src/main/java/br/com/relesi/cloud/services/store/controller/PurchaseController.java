package br.com.relesi.cloud.services.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.relesi.cloud.services.store.dto.PurchaseDTO;
import br.com.relesi.cloud.services.store.model.Purchase;
import br.com.relesi.cloud.services.store.services.PurchaseService;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {
	
	@Autowired
	private PurchaseService purchaseService;
	
	@RequestMapping(method = RequestMethod.POST)
	public Purchase accomplishPurchase(@RequestBody PurchaseDTO purchase) {
		return purchaseService.accomplishPurchase(purchase);
	}

}
