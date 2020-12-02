package com.iftm.PDS1.dto;

import java.io.Serializable;

import com.iftm.PDS1.entities.User;

public class UserInsertDTO  implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private String email;
	private String phone;
	private String password;
	
	public UserInsertDTO() {
		
	}

	public UserInsertDTO(Long id, String nome, String email, String phone, String password) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.phone = phone;
		this.password = password;
	}
	
	public UserInsertDTO(User entity) {
		this.id = entity.getId();
		this.nome = entity.getNome();
		this.email = entity.getEmail();
		this.phone = entity.getPhone();
		this.password = entity.getPassword();
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public User toEntity() {
		return new User(id, nome, email, phone, password);
	}
}
