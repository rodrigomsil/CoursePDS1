package com.iftm.PDS1.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.Length;

import com.iftm.PDS1.entities.Product;

public class ProductCategoriesDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotEmpty(message = "can't be empty")
	@Length(min = 3, max = 80, message = "Length must be between 3 and 80")
	private String nome;
	
	@NotEmpty(message = "can't be empty")
	@Length(min = 8, message = "Length must be more than 80")
	private String description;
	
	@Positive
	private Double price;
	
	private String imgUrl;
	
	List<CategoryDTO> categories = new ArrayList<>();
	
	public ProductCategoriesDTO() {
		
	}

	public ProductCategoriesDTO(String nome, String description, Double price, String imgUrl) {
		this.nome = nome;
		this.description = description;
		this.price = price;
		this.imgUrl = imgUrl;
	}
	
	public ProductCategoriesDTO(Product entity) {
		setNome(entity.getNome());
		setDescription(entity.getDescription());
		setPrice(entity.getPrice());
		setImgUrl(entity.getImgUrl());
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public List<CategoryDTO> getCategories() {
		return categories;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public Product toEntity() {
		return new Product(null, nome, description, price, imgUrl);
	}
	
	
}
