package com.example.auction.auction;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

public class AuctionService {

	@Autowired
	private AuctionRepository auctionRepo;
	
	public Optional<Auction> getAuctionById(String auctionID){
		Optional<Auction> auction = auctionRepo.findById(auctionID);
		return auction;
	}






}
