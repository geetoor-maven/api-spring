package com.geetoor.spring.model.repos;

import com.geetoor.spring.model.entity.Supplier;
import org.springframework.data.repository.CrudRepository;

public interface SupplierRepo extends CrudRepository<Supplier, Long> {
}
