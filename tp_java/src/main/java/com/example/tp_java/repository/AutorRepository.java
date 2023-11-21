package com.example.tp_java.repository;

import org.springframework.stereotype.Repository;

import com.example.tp_java.model.Autor;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


@Repository
public interface AutorRepository extends CrudRepository<Autor, Long> {

	List<Autor>findAllByPaisDeOrigen(String pais);
	
	@Query("select a from Autor a "
			+ "inner join a.libros l "
			+ "where a.apellido =:lastname "
			+ "and l.genero =:genre")
	List<Autor> buscarPorApellidoYGenero(String lastname, String genre);
	
	@Query(nativeQuery = true, value = "select * from sys_autor a " 
			+ "inner join sys_libro l " 
			+ "where l.autor_id = a.autor_id "
			+ "and l.libro_anio =:year")
	List<Autor> buscarPorAnioLibro(Integer year);
	
	
}
