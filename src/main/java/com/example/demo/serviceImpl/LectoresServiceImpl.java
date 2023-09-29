package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.LectoresEntity;
import com.example.demo.repository.LectoresRepository;
import com.example.demo.service.LectoresService;

@Service
public class LectoresServiceImpl implements LectoresService{

	
	@Autowired
	private LectoresRepository lectoresRepository;
	
	@Override
	public LectoresEntity create(LectoresEntity post) {
		// TODO Auto-generated method stub
		return lectoresRepository.save(post);
	}

	@Override
	public LectoresEntity update(LectoresEntity post) {
		// TODO Auto-generated method stub
		return lectoresRepository.save(post);
	}

	@Override
	public void delete(Long DNILector) {
		// TODO Auto-generated method stub
		lectoresRepository.deleteById(DNILector);
		
	}

	@Override
	public LectoresEntity read(Long DNILector) {
		// TODO Auto-generated method stub
		return lectoresRepository.findById(DNILector).get();
	}

	@Override
	public List<LectoresEntity> readAll() {
		// TODO Auto-generated method stub
		return lectoresRepository.findAll();
	}
	

}
