package br.com.relesi.cloud.services.store.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.relesi.cloud.services.store.dto.InfoDeliveryDTO;
import br.com.relesi.cloud.services.store.dto.VoucherDTO;

@FeignClient("carrier")
public interface CarrierClient {

	@RequestMapping(path = "/delivery", method = RequestMethod.POST)
	public VoucherDTO reservationDelivery(InfoDeliveryDTO deliveryDTO);
}
