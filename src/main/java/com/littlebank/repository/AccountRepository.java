package com.littlebank.repository;

import org.springframework.data.repository.CrudRepository;

import com.littlebank.model.Account;  

public interface AccountRepository extends CrudRepository<Account, Integer> {

}
