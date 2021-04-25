package br.com.relesi.cloud.services.store.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.relesi.cloud.services.store.model.Purchase;

@Repository
public interface PurchaseRepository extends CrudRepository<Purchase, Long> {

}
