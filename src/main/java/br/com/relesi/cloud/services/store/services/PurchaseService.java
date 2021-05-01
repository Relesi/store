package br.com.relesi.cloud.services.store.services;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import br.com.relesi.cloud.services.store.client.CarrierClient;
import br.com.relesi.cloud.services.store.client.ProviderClient;
import br.com.relesi.cloud.services.store.dto.InfoDeliveryDTO;
import br.com.relesi.cloud.services.store.dto.InfoOrderDto;
import br.com.relesi.cloud.services.store.dto.InfoProviderDTO;
import br.com.relesi.cloud.services.store.dto.PurchaseDTO;
import br.com.relesi.cloud.services.store.dto.VoucherDTO;
import br.com.relesi.cloud.services.store.model.Purchase;
import br.com.relesi.cloud.services.store.model.PurchaseState;
import br.com.relesi.cloud.services.store.repository.PurchaseRepository;

@Service
public class PurchaseService {

	@Autowired
	private CarrierClient carrierClient;

	@Autowired
	private PurchaseRepository purchseRepository;

	@Autowired
	private ProviderClient providerClient;

	@HystrixCommand(threadPoolKey = "getByIdThreadPool")
	public Purchase getById(Long id) {

		return purchseRepository.findById(id).orElse(new Purchase());
	}

	@HystrixCommand(fallbackMethod = "accomplishPurchaseFallback", threadPoolKey = "accomplishPurchaseThreadPool")
	public Purchase accomplishPurchase(PurchaseDTO purchase) {

		Purchase purchaseSave = new Purchase();
		purchaseSave.setState(PurchaseState.RECEIVED);
		purchaseSave.setDestinationAddress(purchase.getAddress().toString());
		purchseRepository.save(purchaseSave);
		purchase.setPurchaseId(purchaseSave.getId());
		
		
		InfoProviderDTO info = providerClient.getInfoToState(purchase.getAddress().getState());
		InfoOrderDto order = providerClient.placeOrder(purchase.getItems());
		purchaseSave.setState(PurchaseState.ORDER_PLACED);
		purchaseSave.setOrderDemand(order.getId());
		purchaseSave.setPreparation(order.getPreparation());
		purchseRepository.save(purchaseSave);

		if (1==1)throw new RuntimeException(); 
		
		

		InfoDeliveryDTO deliveryDto = new InfoDeliveryDTO();
		deliveryDto.setOrderId(order.getId());
		deliveryDto.setDateForDelivery(LocalDate.now().plusDays(order.getPreparation()));
		deliveryDto.setOriginAddress(info.getAddress());
		deliveryDto.setDestinationAddress(purchase.getAddress().toString());
		VoucherDTO voucher = carrierClient.reservationDelivery(deliveryDto);

		purchaseSave.setState(PurchaseState.RESERVATION_DELIVERED);
		purchaseSave.setDateForDelivery(voucher.getDeliveryScheduled());
		purchaseSave.setVoucher(voucher.getNumber());
		purchseRepository.save(purchaseSave);

		return purchaseSave;
		
	}

	public Purchase accomplishPurchaseFallback(PurchaseDTO purchase) {
		if (purchase.getPurchaseId() != null) {
			return purchseRepository.findById(purchase.getPurchaseId()).get();
		}
		
		
		Purchase purchaseFallback = new Purchase();
		purchaseFallback.setDestinationAddress(purchase.getAddress().toString());
		return purchaseFallback;

	}

}
