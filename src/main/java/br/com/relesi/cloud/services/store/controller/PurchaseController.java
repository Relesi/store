package br.com.relesi.cloud.services.store.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.relesi.cloud.services.store.dto.PurchaseDTO;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {
	
	@RequestMapping(method = RequestMethod.POST)
	public void accomplishPurchase(@RequestBody PurchaseDTO purchase) {
		
	}

}
