package com.example.tp_java.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "sys_autor")
public class Autor implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5374740289681984600L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "autor_id")
	private Long id;
	
	@NotBlank
	@Column(name = "autor_nombre")
	private String nombre;
	
	@NotBlank
	@Column(name = "autor_apellido")
	private String apellido;
	
	@NotBlank
	@Column(name = "autor_pais_de_origen")
	private String paisDeOrigen;
	
	@OneToMany(mappedBy = "autor", cascade = CascadeType.ALL)
	private List<Libro> libros;
	
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
	public List<Libro> getLibros() {
		return libros;
	}
	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}
	@Override
	public String toString() {
		return "Autor [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", paisDeOrigen=" + paisDeOrigen
				+ "]";
	}

	
	
}
