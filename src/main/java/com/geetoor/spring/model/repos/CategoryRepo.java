package com.geetoor.spring.model.repos;

import com.geetoor.spring.model.entity.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepo extends CrudRepository<Category, Long> {
}
