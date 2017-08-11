package com.stephanie.spring.service;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.stephanie.spring.entity.UploadFile;


public interface FileService {

	public UploadFile saveFile(MultipartFile mFile, UploadFile file) throws IllegalStateException, IOException;
	
	public UploadFile getFile(Integer id);
	
	public List<UploadFile> getAllFiles();
	
}
