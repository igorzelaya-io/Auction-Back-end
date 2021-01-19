package com.example.auction.product;

import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.auction.auction.Auction;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
@Entity
@Table(name = "products")
public class Product {

	@JsonProperty
	@Id
	@Column(name = "productID", nullable = false)
	private String productID;
	
	@JsonProperty
	@Column(name = "productName", nullable = false)
	private double productName;
	
	@JsonProperty
	@Column(name = "productStatus", nullable = false)
	private ProductStatus productStatus;
	
	@JsonProperty
	@Column(name = "productDescription")
	private String productDescription;
	
	@JsonProperty
	@OneToMany(mappedBy = "auctionProduct")
	private List<Auction> productAuctions;
	
	public Product() {
		super();
		this.productID = UUID.randomUUID().toString();
	}

	public Product(double productName, ProductStatus productStatus, String productDescription,
			List<Auction> productAuctions) {
		super();
		this.productName = productName;
		this.productStatus = productStatus;
		this.productDescription = productDescription;
		this.productAuctions = productAuctions;
	}

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public double getProductName() {
		return productName;
	}

	public void setProductName(double productName) {
		this.productName = productName;
	}

	public ProductStatus getProductStatus() {
		return productStatus;
	}

	public void setProductStatus(ProductStatus productStatus) {
		this.productStatus = productStatus;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public List<Auction> getProductAuctions() {
		return productAuctions;
	}

	public void setProductAuctions(List<Auction> productAuctions) {
		this.productAuctions = productAuctions;
	}

}
