package br.com.relesi.cloud.services.store.dto;

import java.time.LocalDate;

public class InfoDeliveryDTO {

	private Long orderId;

	private LocalDate dateForDelivery;

	private String originAddress;

	private String destinationAddress;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public LocalDate getDateForDelivery() {
		return dateForDelivery;
	}

	public void setDateForDelivery(LocalDate dateForDelivery) {
		this.dateForDelivery = dateForDelivery;
	}

	public String getOriginAddress() {
		return originAddress;
	}

	public void setOriginAddress(String originAddress) {
		this.originAddress = originAddress;
	}

	public String getDestinationAddress() {			
		return destinationAddress;
	}

	public void setDestinationAddress(String destinationAddress) {
		this.destinationAddress = destinationAddress;
	}

}
