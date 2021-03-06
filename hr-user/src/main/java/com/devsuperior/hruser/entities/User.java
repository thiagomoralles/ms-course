package com.devsuperior.hruser.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@Column(unique = true)
	private String email;
	
	@EqualsAndHashCode.Exclude
	private String password;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "tb_user_role",
			joinColumns = {@JoinColumn(name="user_id")}, 
			inverseJoinColumns = {@JoinColumn(name="role_id")}
	)
	private Set<Role> roles;
}
