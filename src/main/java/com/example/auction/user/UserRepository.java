package com.example.auction.user;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, String>{

	public List<User> findAll();

	public Optional<User> findUserByName(String userName);
}
