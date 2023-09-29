package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.EditorialesEntity;
import com.example.demo.repository.EditorialesRepository;
import com.example.demo.service.EditorialesService;

@Service
public class EditorialesServiceImpl implements EditorialesService{

	
	@Autowired
	private EditorialesRepository editorialesRepository;
	
	@Override
	public EditorialesEntity create(EditorialesEntity post) {
		// TODO Auto-generated method stub
		return editorialesRepository.save(post);
	}

	@Override
	public EditorialesEntity update(EditorialesEntity post) {
		// TODO Auto-generated method stub
		return editorialesRepository.save(post);
	}

	@Override
	public void delete(Long ideditoriales) {
		// TODO Auto-generated method stub
		editorialesRepository.deleteById(ideditoriales);
		
	}

	@Override
	public EditorialesEntity read(Long ideditoriales) {
		// TODO Auto-generated method stub
		return editorialesRepository.findById(ideditoriales).get();
	}

	@Override
	public List<EditorialesEntity> readAll() {
		// TODO Auto-generated method stub
		return editorialesRepository.findAll();
	}
	

}
