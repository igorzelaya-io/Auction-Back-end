package com.example.auction.user;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.auction.auction.Auction;
import com.example.auction.bids.Bid;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table(name = "users")
@JsonSerialize
public class User {

	@JsonProperty
	@Id
	@Column(name = "userID", nullable = false)
	private String userID;
	
	@JsonProperty
	@Column(name = "userName", nullable = false)
	private String userName;
	
	@JsonProperty
	@Column(name = "userMoney", nullable = false)
	private double userMoney;
	
	@JsonProperty
	@Column(name= "userStatus", nullable = false)
	private UserStatus userStatus;
	
	@JsonProperty
	@Column(name = "userEmail", nullable = true)
	private String userEmail;
	
	@JsonProperty
	@Column(name = "userBirthDate", nullable = false)
	private LocalDate userBirthDate;
	
	@JsonProperty
	@OneToMany(mappedBy = "auctionUser")
	private List<Auction> userAuctions;
	
	@JsonProperty
	@OneToMany(mappedBy = "bidUser")
	private List<Bid> userBids;
	
	public User() {
		super();
		this.userID = UUID.randomUUID().toString();
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public double getUserMoney() {
		return userMoney;
	}

	public void setUserMoney(double userMoney) {
		this.userMoney = userMoney;
	}

	public UserStatus getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(UserStatus userStatus) {
		this.userStatus = userStatus;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public LocalDate getUserBirthDate() {
		return userBirthDate;
	}

	public void setUserBirthDate(LocalDate userBirthDate) {
		this.userBirthDate = userBirthDate;
	}

	public List<Auction> getUserAuctions() {
		return userAuctions;
	}

	public void setUserAuctions(List<Auction> userAuctions) {
		this.userAuctions = userAuctions;
	}

	public List<Bid> getUserBids() {
		return userBids;
	}

	public void setUserBids(List<Bid> userBids) {
		this.userBids = userBids;
	}

}