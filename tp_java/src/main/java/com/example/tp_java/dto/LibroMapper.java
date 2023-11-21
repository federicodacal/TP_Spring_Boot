package com.example.tp_java.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.tp_java.model.Libro;

@Component
public class LibroMapper {
	
	public Libro dtoToEntity(LibroDTO dto) {
		Libro entity = new Libro();
				
		entity.setId(dto.getId());
		entity.setTitulo(dto.getTitulo());
		entity.setGenero(dto.getGenero());
		entity.setAnio(dto.getAnio());
		
		return entity;
	}
	
	public LibroDTO entityToDto(Libro entity) {
		
		LibroDTO dto = new LibroDTO();
				
		dto.setId(entity.getId());
		dto.setTitulo(entity.getTitulo());
		dto.setGenero(entity.getGenero());
		dto.setAnio(entity.getAnio());
		
		return dto;
	}
	
	public List<LibroDTO> lstEntityToLstDto(List<Libro> entity) {
		List<LibroDTO> dto = new ArrayList<>();
		
		for(Libro e : entity) {
			dto.add(this.entityToDto(e));
		}
		
		return dto;
	}
	
	public List<Libro> lstDtoToLstEntity(List<LibroDTO> dto) {
		List<Libro> entity = new ArrayList<>();
		
		for(LibroDTO d : dto) {
			entity.add(this.dtoToEntity(d));
		}
		
		return entity;
	}
}
