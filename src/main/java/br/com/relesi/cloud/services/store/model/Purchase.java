package br.com.relesi.cloud.services.store.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Purchase implements Serializable {

	private static final long serialVersionUID = 8841683791965183708L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long orderDemand;

	private Integer preparation;
	private String destinationAddress;
	private LocalDate dateForDelivery;
	private Long voucher;

	@Enumerated(EnumType.STRING)
	private PurchaseState state;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public PurchaseState getState() {
		return state;
	}

	public void setState(PurchaseState state) {
		this.state = state;
	}

}
