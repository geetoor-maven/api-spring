package com.geetoor.spring.model.repos;

import com.geetoor.spring.model.entity.Supplier;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SupplierRepo extends CrudRepository<Supplier, Long> {

    Supplier findByEmail(String email);

    List<Supplier> findByNameContains(String name);

    List<Supplier> findByNameStartingWith(String prefix);
}
