package br.com.relesi.cloud.services.store.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class PurchaseDTO {
	
	@JsonIgnore
	private Long purchaseId;

	private List<PurchaseItemsDTO> items;
	private AddressDTO address;

	public List<PurchaseItemsDTO> getItems() {
		return items;
	}

	public void setItems(List<PurchaseItemsDTO> items) {
		this.items = items;
	}

	public AddressDTO getAddress() {
		return address;
	}

	public void setAddress(AddressDTO address) {
		this.address = address;
	}

	public Long getPurchaseId() {
		return purchaseId;
	}

	public void setPurchaseId(Long purchaseId) {
		this.purchaseId = purchaseId;
	}
	
	

}
