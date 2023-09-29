package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.AlquileresEntity;

public interface AlquileresService {
	AlquileresEntity create(AlquileresEntity post);
	AlquileresEntity update(AlquileresEntity post);
	void delete(Long id);
	AlquileresEntity read(Long id);
	List<AlquileresEntity> readAll();
}
