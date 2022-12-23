package br.com.ex1.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ex1.rest.entity.Modelo;
import br.com.ex1.rest.service.ModeloService;

@RestController
@RequestMapping(value = "/modelo")
public class ModeloController {

	
	@Autowired
	private ModeloService service;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Modelo> findAll(){
		return service.findAll();
	}
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Modelo findById(@PathVariable(value = "id") Long id) {
		return service.findById(id);
	}
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Modelo> save(@RequestBody Modelo modelo){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(modelo));
	}
	
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Modelo update(@RequestBody Modelo modelo){
		return service.save(modelo);
	}
	
	public ResponseEntity<?> delete(Long id) {
		service.delete(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
