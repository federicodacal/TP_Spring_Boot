package com.example.tp_java.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "sys_libro")
public class Libro implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5507846524323098272L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "libro_id")
	private Long id;
	
	@NotBlank
	@Column(name = "libro_titulo")
	private String titulo;
	
	@NotBlank
	@Column(name = "libro_genero")
	private String genero;
	
	@NotNull
	@Min(1600)
	@Max(2100)
	@Column(name = "libro_anio")
	private Integer anio;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "autor_id")
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
	public Integer getAnio() {
		return anio;
	}
	public void setAnio(Integer anio) {
		this.anio = anio;
	}
	public Autor getAutor() {
		return autor;
	}
	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	
	
}
