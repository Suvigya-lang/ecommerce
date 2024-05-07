package com.example.demo.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	@ManyToOne
	@JoinColumn(name="category_id",nullable=false)
	ProductCategory category;
	@Column(name="active")
	private boolean active;
	@Column(name="units_in_stock")
	private int unitsInStock;
	@Column(name="name")
	private String name;
	@Column(name="sku")
	private String sku;
	@Column(name="description")
	private String description;
	@Column(name="image_url")
	private String imageUrl;
	@Column(name="date_created")
	private Date dateCreated;
	@Column(name="last_updated")
	private Date lastUpdated;
	@Column(name="unit_price")
	private BigDecimal unitPrice;
	public Product() {
		
	}
	public Product(long id, ProductCategory category, boolean active, int unitsInStock, String name, String sku,
			String description, String imageUrl, Date dateCreated, Date lastUpdated, BigDecimal unitPrice) {
		super();
		this.id = id;
		this.category = category;
		this.active = active;
		this.unitsInStock = unitsInStock;
		this.name = name;
		this.sku = sku;
		this.description = description;
		this.imageUrl = imageUrl;
		this.dateCreated = dateCreated;
		this.lastUpdated = lastUpdated;
		this.unitPrice = unitPrice;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public ProductCategory getCategory() {
		return category;
	}
	public void setCategory(ProductCategory category) {
		this.category = category;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public int getUnitsInStock() {
		return unitsInStock;
	}
	public void setUnitsInStock(int unitsInStock) {
		this.unitsInStock = unitsInStock;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	public Date getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	public BigDecimal getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", category=" + category + ", active=" + active + ", unitsInStock=" + unitsInStock
				+ ", name=" + name + ", sku=" + sku + ", description=" + description + ", imageUrl=" + imageUrl
				+ ", dateCreated=" + dateCreated + ", lastUpdated=" + lastUpdated + ", unitPrice=" + unitPrice + "]";
	}
	
}
	
