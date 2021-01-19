package com.example.auction.auction;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface AuctionRepository extends CrudRepository<Auction, String>{

	@Override
	public List<Auction> findAll();
}
