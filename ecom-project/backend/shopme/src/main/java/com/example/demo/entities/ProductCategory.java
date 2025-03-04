package com.example.demo.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="product_category")


public class ProductCategory {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	@Column(name="category_name")
	private String categoryName;
	@OneToMany(mappedBy="category",cascade=CascadeType.ALL)
	private Set<Product> products;
	public ProductCategory() {
		
	}
	public ProductCategory(String categoryName) {
		
		this.categoryName = categoryName;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
		
	}
	
	public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	@Override
	public String toString() {
		return "ProductCategory [id=" + id + ", categoryName=" + categoryName + ", products=" + products + "]";
	}
	
	
	
	

}
