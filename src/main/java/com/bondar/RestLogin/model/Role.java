package com.bondar.RestLogin.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity @Component
@Table(name="Roles")
public class Role implements Serializable {
	
	private static final long serialVersionUID = -4386160458649101911L;
	
	@Id
	private Long id;
	private String role;
	
	@ManyToMany(mappedBy="roles")
	private List<User> user;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
}
