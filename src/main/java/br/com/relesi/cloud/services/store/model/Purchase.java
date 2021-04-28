package br.com.relesi.cloud.services.store.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Purchase {

	@Id
	private Long orderDemand;
	private Integer preparation;
	private String destinationAddress;

	private LocalDate dateForDelivery;
	private Long voucher;

	public Long getOrderDemand() {
		return orderDemand;
	}

	public void setOrderDemand(Long orderDemand) {
		this.orderDemand = orderDemand;
	}

	public Integer getPreparation() {
		return preparation;
	}

	public void setPreparation(Integer preparation) {
		this.preparation = preparation;
	}

	public String getDestinationAddress() {
		return destinationAddress;
	}

	public void setDestinationAddress(String destinationAddress) {
		this.destinationAddress = destinationAddress;
	}

	public LocalDate getDateForDelivery() {
		return dateForDelivery;
	}

	public void setDateForDelivery(LocalDate dateForDelivery) {
		this.dateForDelivery = dateForDelivery;
	}

	public Long getVoucher() {
		return voucher;
	}

	public void setVoucher(Long voucher) {
		this.voucher = voucher;
	}

}
