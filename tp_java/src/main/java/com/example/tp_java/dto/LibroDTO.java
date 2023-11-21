package com.example.tp_java.dto;

public class LibroDTO {
	
	private Long id;
	private String titulo;
	private String genero;
	private Integer anio;
	private AutorDTO autor;
	
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
	public Integer getAnio() {
		return anio;
	}
	public void setAnio(Integer anio) {
		this.anio = anio;
	}
	
	public AutorDTO getAutor() {
		return autor;
	}
	public void setAutor(AutorDTO autor) {
		this.autor = autor;
	}
	
	
}
