package com.synechron.enbdaccountcrud.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.synechron.enbdaccountcrud.model.Account;

@Repository
public interface AccountRepository extends MongoRepository<Account, Integer> {

}
