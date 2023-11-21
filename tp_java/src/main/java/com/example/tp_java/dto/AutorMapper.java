package com.example.tp_java.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.tp_java.model.Autor;

@Component
public class AutorMapper {
	
	@Autowired
	LibroMapper lMapper;

	public Autor dtoToEntity(AutorDTO dto) {
		Autor entity = new Autor();
		
		entity.setId(dto.getId());
		entity.setApellido(dto.getApellido());
		entity.setNombre(dto.getNombre());
		entity.setPaisDeOrigen(dto.getPaisDeOrigen());
		entity.setLibros(lMapper.lstDtoToLstEntity(dto.getLibros()));
		
		return entity;
	}
	
	public AutorDTO entityToDto(Autor entity) {
		AutorDTO dto = new AutorDTO();
		
		dto.setId(entity.getId());
		dto.setApellido(entity.getApellido());
		dto.setNombre(entity.getNombre());
		dto.setPaisDeOrigen(entity.getPaisDeOrigen());
		dto.setLibros(lMapper.lstEntityToLstDto(entity.getLibros()));
		
		return dto;
	}
	
	public List<AutorDTO> lstEntityToLstDto(List<Autor> entity) {
		List<AutorDTO> dto = new ArrayList<>();
		
		for(Autor e : entity) {
			dto.add(this.entityToDto(e));
		}
		
		return dto;
	}
}
