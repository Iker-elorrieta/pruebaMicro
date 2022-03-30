package com.microser;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
public class Producto {

	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private int id;
	 
	
	@Column(nullable = false)
	@NotNull
	@Size(min =3, max=250)
	private String nombre;
	
	public Producto() //Me ha obligado a crear este constructor
	 {}
}
