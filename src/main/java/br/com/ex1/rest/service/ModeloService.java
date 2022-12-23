package br.com.ex1.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ex1.rest.entity.Modelo;
import br.com.ex1.rest.repository.ModeloRepository;

@Service
public class ModeloService {
	
	@Autowired
	private ModeloRepository repository;
	
	public List<Modelo> findAll(){
		return repository.findAll();
	}
	
	public Modelo findById(Long id) {
		return repository.findById(id).get();
	}
	
	public Modelo save(Modelo modelo) {
		return repository.save(modelo);
	}
	
	public Modelo update(Modelo modelo) {
		var entity = findById(modelo.getId());
		
		entity.setNome(modelo.getNome());
		entity.setAno(modelo.getAno());
		
		return repository.save(entity);
	}
	
	public void delete(Long id) {
		var entity = findById(id);
		repository.delete(entity);
	}

}
