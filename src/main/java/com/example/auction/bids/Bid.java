package com.example.auction.bids;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.auction.auction.Auction;
import com.example.auction.user.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@JsonSerialize
@Table(name = "bids")
public class Bid {

	@JsonProperty
	@Id
	@Column(name = "bidID", nullable = false)
	private String bidID;
	
	@JsonProperty
	@Column(name = "bidAmount")
	private double bidAmount;
	
	@JsonProperty
	@ManyToOne
	@JoinColumn(name = "userID")
	private User bidUser;

	@JsonProperty
	@ManyToOne
	@JoinColumn(name = "auctionID")
	private Auction bidAuction;

	@JsonProperty
	@Column(name = "bidTime")
	private LocalDateTime bidTime; 

	public Bid() {
		super();
		this.bidID = UUID.randomUUID().toString();
	}

	public Bid(double bidAmount, User bidUser, Auction bidAuction, LocalDateTime bidTime) {
		super();
		this.bidAmount = bidAmount;
		this.bidUser = bidUser;
		this.bidAuction = bidAuction;
		this.bidTime = bidTime;
	}

	public String getBidID() {
		return bidID;
	}

	public void setBidID(String bidID) {
		this.bidID = bidID;
	}

	public double getBidAmount() {
		return bidAmount;
	}

	public void setBidAmount(double bidAmount) {
		this.bidAmount = bidAmount;
	}

	public User getBidUser() {
		return bidUser;
	}

	public void setBidUser(User bidUser) {
		this.bidUser = bidUser;
	}

	public Auction getBidAuction() {
		return bidAuction;
	}

	public void setBidAuction(Auction bidAuction) {
		this.bidAuction = bidAuction;
	}

	public LocalDateTime getBidTime() {
		return bidTime;
	}

	public void setBidTime(LocalDateTime bidTime) {
		this.bidTime = bidTime;
	}
	
}
