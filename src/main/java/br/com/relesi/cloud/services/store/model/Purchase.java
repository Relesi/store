package br.com.relesi.cloud.services.store.model;

public class Purchase {

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
