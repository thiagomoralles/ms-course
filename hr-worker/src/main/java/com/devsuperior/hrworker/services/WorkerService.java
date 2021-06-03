package com.devsuperior.hrworker.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.hrworker.entities.Worker;
import com.devsuperior.hrworker.repositories.WorkerRepository;

@Service
public class WorkerService implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private WorkerRepository workerRepository;
	
	public List<Worker> findAll() {
		return workerRepository.findAll();
	}
	
	public Worker findById(Long id) {
		return workerRepository.findById(id).get();
	}
}
