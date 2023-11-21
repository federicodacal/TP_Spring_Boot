package com.example.tp_java.dto;

import java.util.List;

public class AutorDTO {
	
	private Long id;
	private String nombre;
	private String apellido;
	private String paisDeOrigen;
	private List<LibroDTO> libros;
	
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
	
	public List<LibroDTO> getLibros() {
		return libros;
	}
	public void setLibros(List<LibroDTO> libros) {
		this.libros = libros;
	}
	
	
}
