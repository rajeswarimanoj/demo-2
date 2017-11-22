package com.upload.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upload.demo.repo.UploadRepository;

@Service
public class UploadService {
	@Autowired
	UploadRepository uploadRepository;
	
    public DocumentMetadata save(Files file) {
		uploadRepository.insert(file); 
        return file.getMetadata();
    }

}
