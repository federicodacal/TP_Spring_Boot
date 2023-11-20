package com.example.tp_java.controller;

import java.util.ArrayList;
import java.util.List;

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

import com.example.tp_java.model.Autor;

@RestController
@RequestMapping("/api")
public class AutorController {

	@GetMapping("/autores")
	public ResponseEntity<?> traerAutores() {
		List<Autor> autores = new ArrayList<Autor>();
		
		Autor a1 = new Autor();
		Autor a2 = new Autor();
		Autor a3 = new Autor();
		
		try {
			a1.setId(1L);
			a1.setApellido("Poe");
			a1.setNombre("Edgar");
			a1.setPaisDeOrigen("USA");
				
			a2.setId(2L);
			a2.setApellido("Goethe");
			a2.setNombre("J. W.");
			a2.setPaisDeOrigen("Alemania");
			
			a3.setId(3L);
			a3.setApellido("Tolstoy");
			a3.setNombre("Leon");
			a3.setPaisDeOrigen("Rusia");
			
			autores.add(a1);
			autores.add(a2);
			autores.add(a3);
			
			return new ResponseEntity<List<Autor>>(autores, HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/autor/{id}")
	public ResponseEntity<?> traerAutor(@PathVariable Long id) {
		try {
			return new ResponseEntity<String>("Hola", HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<String>("Autor no encontrado con id " + id, HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/autor")
	public ResponseEntity<?> agregarAutor(@RequestBody @Validated Autor a) {
		try {
			return new ResponseEntity<String>("Hola", HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/autor/{id}")
	public void modificarAutor() {
		
	}
	
	@DeleteMapping("/autor")
	public void eliminarAutor() {
		
	}
	
}
