package com.littlebank.repository;

import org.springframework.data.repository.CrudRepository;

import com.littlebank.model.ATM;

public interface AtmRepository extends CrudRepository<ATM, Integer> {

}
