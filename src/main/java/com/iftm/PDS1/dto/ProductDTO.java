package com.iftm.PDS1.dto;

import com.iftm.PDS1.entities.Product;

public class ProductDTO {

	private Long id;
	private String nome;
	private String description;
	private Double price;
	private String imgUrl;
	
	public ProductDTO() {
		
	}

	public ProductDTO(Long id, String nome, String description, Double price, String imgUrl) {
		super();
		this.id = id;
		this.nome = nome;
		this.description = description;
		this.price = price;
		this.imgUrl = imgUrl;
	}
	
	public ProductDTO(Product entity) {
		this.id = entity.getId();
		this.nome = entity.getNome();
		this.description = entity.getDescription();
		this.price = entity.getPrice();
		this.imgUrl = entity.getImgUrl();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	
	public  Product toEntity() {
		return new Product(id, nome, description, price, imgUrl);
	}
	
}
