package br.com.relesi.cloud.services.store.dto;

import java.util.List;

public class PurchaseDTO {

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

}
