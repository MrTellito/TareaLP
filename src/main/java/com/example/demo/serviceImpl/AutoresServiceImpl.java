package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.AutoresEntity;
import com.example.demo.repository.AutoresRepository;
import com.example.demo.service.AutoresService;

@Service
public class AutoresServiceImpl implements AutoresService{

	
	@Autowired
	private AutoresRepository autoresRepository;
	
	@Override
	public AutoresEntity create(AutoresEntity post) {
		// TODO Auto-generated method stub
		return autoresRepository.save(post);
	}

	@Override
	public AutoresEntity update(AutoresEntity post) {
		// TODO Auto-generated method stub
		return autoresRepository.save(post);
	}

	@Override
	public void delete(Long idautor) {
		// TODO Auto-generated method stub
		autoresRepository.deleteById(idautor);
		
	}

	@Override
	public AutoresEntity read(Long idautor) {
		// TODO Auto-generated method stub
		return autoresRepository.findById(idautor).get();
	}

	@Override
	public List<AutoresEntity> readAll() {
		// TODO Auto-generated method stub
		return autoresRepository.findAll();
	}
	

}
