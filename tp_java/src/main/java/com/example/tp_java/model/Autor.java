package com.example.tp_java.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Autor {
	
	@NotNull
	private Long id;
	
	@NotBlank
	private String nombre;
	
	@NotBlank
	private String apellido;
	
	@NotBlank
	private String paisDeOrigen;
	
	//private Libros;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getPaisDeOrigen() {
		return paisDeOrigen;
	}
	public void setPaisDeOrigen(String paisDeOrigen) {
		this.paisDeOrigen = paisDeOrigen;
	}
	@Override
	public String toString() {
		return "Autor [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", paisDeOrigen=" + paisDeOrigen
				+ "]";
	}

	
	
}
