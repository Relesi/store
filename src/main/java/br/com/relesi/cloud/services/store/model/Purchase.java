package br.com.relesi.cloud.services.store.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Purchase {

	@Id
	private Long orderDemand;
	private Integer preparation;
	private String destinationAddress;

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

}
