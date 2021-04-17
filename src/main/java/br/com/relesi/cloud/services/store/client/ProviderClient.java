package br.com.relesi.cloud.services.store.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.relesi.cloud.services.store.dto.InfoOrderDto;
import br.com.relesi.cloud.services.store.dto.InfoProviderDTO;
import br.com.relesi.cloud.services.store.dto.PurchaseItemsDTO;

@FeignClient("provider")
public interface ProviderClient {

	@RequestMapping("/info/{state}")
	InfoProviderDTO getInfoToState(@PathVariable String state);

	@RequestMapping(method=RequestMethod.POST, value ="/orderDemand")
	InfoOrderDto placeOrder(List<PurchaseItemsDTO> items);
}
