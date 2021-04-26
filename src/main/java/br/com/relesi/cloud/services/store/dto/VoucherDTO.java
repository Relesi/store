package br.com.relesi.cloud.services.store.dto;

import java.time.LocalDate;

public class VoucherDTO {

	private Long number;

	private LocalDate deliveryScheduled;

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	public LocalDate getDeliveryScheduled() {
		return deliveryScheduled;
	}

	public void setDeliveryScheduled(LocalDate deliveryScheduled) {
		this.deliveryScheduled = deliveryScheduled;
	}

}
