package com.example.tp_java.controller;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tp_java.dto.AutorMapper;
import com.example.tp_java.dto.LibroDTO;
import com.example.tp_java.model.Autor;
import com.example.tp_java.model.Libro;
import com.example.tp_java.dto.AutorDTO;
import com.example.tp_java.repository.AutorRepository;

@RestController
@RequestMapping("/api")
public class AutorController {
	
	@Autowired
	AutorRepository autorRepository; // Singleton de la entidad para no generar múltiples objetos
	
	@Autowired
	AutorMapper autorMapper;

	@GetMapping("/autores")
	public ResponseEntity<?> traerAutores() {
			
		try {
			
			List<Autor> autores = new ArrayList<>();
			
			autores = (List<Autor>) autorRepository.findAll();
			
			return new ResponseEntity<List<AutorDTO>>(autorMapper.lstEntityToLstDto(autores), HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/autor/{id}")
	public ResponseEntity<?> traerAutor(@PathVariable Long id) {
		try {
			
			Optional<Autor> aOpt = autorRepository.findById(id);
			
			if(aOpt.isPresent()) {
				return new ResponseEntity<AutorDTO>(autorMapper.entityToDto(aOpt.get()), HttpStatus.OK);
			}
			else {
				return new ResponseEntity<String>("Autor no encontrado con id " + id, HttpStatus.NOT_FOUND);
			}
			
		}
		catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/autor")
	public ResponseEntity<?> agregarAutor(@RequestBody @Validated Autor a) {
		try {
			
			System.out.println(a.toString());
			
			for(Libro l : a.getLibros()) {
				l.setAutor(a);
			}
			
			autorRepository.save(a);
			
			return new ResponseEntity<String>("Autor agregado", HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/autor")
	public ResponseEntity<?> modificarAutor(@RequestBody @Validated AutorDTO a) {
		try {
			
			System.out.println(a.toString());
			
			Optional<Autor> aOpt = autorRepository.findById(a.getId());
			
			if(aOpt.isPresent()) {
				
				autorRepository.save(autorMapper.dtoToEntity(a));
				
				return new ResponseEntity<String>("Autor modificado", HttpStatus.OK);
			}
			else {
				return new ResponseEntity<String>("Autor no encontrado con id " + a.getId(), HttpStatus.NOT_FOUND);
			}
		}
		catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/autor")
	public ResponseEntity<?> eliminarAutor(@RequestBody @Validated AutorDTO a) {
		try {
			
			System.out.println(a.toString());
			
			Optional<Autor> aOpt = autorRepository.findById(a.getId());
			
			if(aOpt.isPresent()) {
				
				autorRepository.deleteById(a.getId());
				
				return new ResponseEntity<String>("Autor eliminado", HttpStatus.OK);
			}
			else {
				return new ResponseEntity<String>("Autor no encontrado con id " + a.getId(), HttpStatus.NOT_FOUND);
			}
		}
		catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/autores/{pais}")
	public ResponseEntity<?> obtenerAutoresPorPais(@PathVariable String pais) {
		
		if(pais == null) {
			return new ResponseEntity<String>("Falta parametro pais", HttpStatus.NOT_FOUND);
		}
		try { 
			
			List<Autor> entities = autorRepository.findAllByPaisDeOrigen(pais); 
			
			return new ResponseEntity<List<AutorDTO>>(autorMapper.lstEntityToLstDto(entities), HttpStatus.OK);

		}
		catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/autorApellido/{lastname}")
	public ResponseEntity<?> obtenerPorApellidoYGeneroNovela(@PathVariable String lastname) {
		if(lastname == null) {
			return new ResponseEntity<String>("Falta parametro lastname", HttpStatus.NOT_FOUND);
		}
		try {
			
			String genre = "Novela";
			
			List<Autor> entities = autorRepository.buscarPorApellidoYGenero(lastname, genre); 
			
			return new ResponseEntity<List<AutorDTO>>(autorMapper.lstEntityToLstDto(entities), HttpStatus.OK);

		}
		catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/anio/{year}")
	public ResponseEntity<?> obtenerPorAnioLibro(@PathVariable Integer year) {
		if(year == null) {
			return new ResponseEntity<String>("Falta parametro lastname", HttpStatus.NOT_FOUND);
		}
		try {
			
			List<Autor> entities = autorRepository.buscarPorAnioLibro(year); 
			
			return new ResponseEntity<List<AutorDTO>>(autorMapper.lstEntityToLstDto(entities), HttpStatus.OK);

		}
		catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}
