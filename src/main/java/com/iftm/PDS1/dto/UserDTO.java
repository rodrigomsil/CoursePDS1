package com.iftm.PDS1.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.iftm.PDS1.entities.User;
import com.iftm.PDS1.services.validation.UserUpdateValid;

@UserUpdateValid
public class UserDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	
	@NotEmpty(message = "can't be empty")
	@Length(min = 5, max = 80, message = "Length must be between 5 and 80")
	private String nome;
	
	@NotEmpty(message = "can't be empty")
	@Email
	private String email;
	
	@NotEmpty(message = "can't be empty")
	@Length(min = 8, max = 20, message = "Length must be between 8 and 20")
	private String phone;
	
	public UserDTO() {
		
	}

	public UserDTO(Long id, String nome, String email, String phone) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.phone = phone;
	}
	
	public UserDTO(User entity) {
		this.id = entity.getId();
		this.nome = entity.getNome();
		this.email = entity.getEmail();
		this.phone = entity.getPhone();
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
	
	public User toEntity() {
		return new User(id, nome, email, phone, null);
	}
	
	
}
