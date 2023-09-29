package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.AlquileresEntity;
import com.example.demo.repository.AlquileresRepository;
import com.example.demo.service.AlquileresService;

@Service
public class AlquileresServiceImpl implements AlquileresService{

	
	@Autowired
	private AlquileresRepository alquileresRepository;
	
	@Override
	public AlquileresEntity create(AlquileresEntity post) {
		// TODO Auto-generated method stub
		return alquileresRepository.save(post);
	}

	@Override
	public AlquileresEntity update(AlquileresEntity post) {
		// TODO Auto-generated method stub
		return alquileresRepository.save(post);
	}

	@Override
	public void delete(Long idalquileres) {
		// TODO Auto-generated method stub
		alquileresRepository.deleteById(idalquileres);

	}

	@Override
	public AlquileresEntity read(Long idalquileres) {
		// TODO Auto-generated method stub
		return alquileresRepository.findById(idalquileres).get();
	}

	@Override
	public List<AlquileresEntity> readAll() {
		// TODO Auto-generated method stub
		return alquileresRepository.findAll();
	}
	

}
