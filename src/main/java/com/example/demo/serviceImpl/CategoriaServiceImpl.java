package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.CategoriaEntity;
import com.example.demo.repository.CategoriaRepository;
import com.example.demo.service.CategoriaService;

@Service
public class CategoriaServiceImpl implements CategoriaService{

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Override
	public CategoriaEntity create(CategoriaEntity post) {
		// TODO Auto-generated method stub
		return categoriaRepository.save(post);
	}

	@Override
	public CategoriaEntity update(CategoriaEntity post) {
		// TODO Auto-generated method stub
		return categoriaRepository.save(post);
	}

	@Override
	public void delete(Long idcategoria) {
		// TODO Auto-generated method stub
		categoriaRepository.deleteById(idcategoria);
		
	}

	@Override
	public CategoriaEntity read(Long idcategoria) {
		// TODO Auto-generated method stub
		return categoriaRepository.findById(idcategoria).get();
	}

	@Override
	public List<CategoriaEntity> readAll() {
		// TODO Auto-generated method stub
		return categoriaRepository.findAll();
	}
	
}