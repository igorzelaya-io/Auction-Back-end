package com.example.auction.auction;

import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.auction.bids.Bid;
import com.example.auction.product.Product;
import com.example.auction.user.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table(name = "auctions")
@JsonSerialize
public class Auction {

	@JsonProperty
	@Id
	@Column(name = "auctionID", nullable = false)
	private String auctionID;
	
	@JsonProperty
	@Column(name = "auctionName", nullable = false)
	private String auctionName;
	
	@JsonProperty
	@ManyToOne
	@JoinColumn(name = "userID")
	private User auctionUser;
	
	@JsonProperty
	@OneToMany(mappedBy="bidAuction")
	private List<Bid> auctionBids;
	
	@ManyToOne
	@JoinColumn(name = "productID")
	private Product auctionProduct;

	public Auction() {
		super();
		this.auctionID = UUID.randomUUID().toString();
	}

	public Auction(String auctionName, User auctionUser, List<Bid> auctionBids, Product auctionProduct) {
		super();
		this.auctionName = auctionName;
		this.auctionUser = auctionUser;
		this.auctionBids = auctionBids;
		this.auctionProduct = auctionProduct;
	}

	public String getAuctionID() {
		return auctionID;
	}

	public void setAuctionID(String auctionID) {
		this.auctionID = auctionID;
	}

	public String getAuctionName() {
		return auctionName;
	}

	public void setAuctionName(String auctionName) {
		this.auctionName = auctionName;
	}

	public User getAuctionUser() {
		return auctionUser;
	}

	public void setAuctionUser(User auctionUser) {
		this.auctionUser = auctionUser;
	}

	public List<Bid> getAuctionBids() {
		return auctionBids;
	}

	public void setAuctionBids(List<Bid> auctionBids) {
		this.auctionBids = auctionBids;
	}

	public Product getAuctionProduct() {
		return auctionProduct;
	}

	public void setAuctionProduct(Product auctionProduct) {
		this.auctionProduct = auctionProduct;
	}

	

}
