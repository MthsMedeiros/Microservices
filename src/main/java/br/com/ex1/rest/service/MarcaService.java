package br.com.ex1.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ex1.rest.entity.Marca;
import br.com.ex1.rest.repository.MarcaRepository;

@Service
public class MarcaService {
	
	
	@Autowired
	private MarcaRepository repository;
	
	public List<Marca> findAll(){
		return repository.findAll();
	}
	
	public Marca findById(Long id) {
		return repository.findById(id).get();
	}
	
	public Marca save(Marca marca) {
		return repository.save(marca);
	}
	
	public Marca update(Marca marca) {
		var entity = findById(marca.getId());
		
		entity.setNome(marca.getNome());
		entity.setModelos(marca.getModelos());
		
		return repository.save(entity);
	}
	
	public void delete(Long id) {
		var entity = findById(id);
		repository.delete(entity);
	}

}
