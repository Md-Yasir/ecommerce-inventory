package com.finoculus.finoculus.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.finoculus.finoculus.entity.CategoryT;

@Repository
public interface CategoryRepo extends CrudRepository<CategoryT, Integer> {

}
