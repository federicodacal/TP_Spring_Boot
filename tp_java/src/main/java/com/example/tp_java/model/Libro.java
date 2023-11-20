package com.example.tp_java.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Libro {
	
	@NotNull
	private Long id;
	
	@NotBlank
	private String titulo;
	
	@NotBlank
	private String genero;
	
	@NotBlank
	private Autor autor;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public Autor getAutor() {
		return autor;
	}
	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	
	
}
