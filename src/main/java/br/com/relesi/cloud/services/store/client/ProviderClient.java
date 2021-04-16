package br.com.relesi.cloud.services.store.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.relesi.cloud.services.store.dto.InfoProviderDTO;

@FeignClient("provider")
public interface ProviderClient {

	@RequestMapping("/info/{state}")
	InfoProviderDTO getInfoToState(@PathVariable String state);
}
