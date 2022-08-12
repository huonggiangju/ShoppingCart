package com.example.demo.Product;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.demo.Category.Category;
import com.example.demo.ProductDetail.ProductDetail;

@Entity
@Table
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length=100, nullable = false, unique=true)
	private String name;
	
	private float price;
	private String description;
	private String imageName;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

//	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
//	private List<ProductDetail> details = new ArrayList<>();
	
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	
//	public List<ProductDetail> getDetails() {
//		return details;
//	}
//
//	public void setDetails(List<ProductDetail> details) {
//		this.details = details;
//	}
//
//	public void addDetail(String name, String value) {
//		this.details.add(new ProductDetail(name, value, this));
//	}
//	
//	public void setDetail(Integer id, String name, String value) {
//		this.details.add(new ProductDetail(id, name, value, this));
//	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	
	
}
