package com.stephanie.spring.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import com.stephanie.spring.entity.UploadFile;
import com.stephanie.spring.exception.InvalidInputException;
import com.stephanie.spring.service.FileService;
import com.stephanie.spring.utility.FileMetaDataUtility;

@RestController
public class FileController {

	@Autowired
	FileService fileService;
	
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public UploadFile uploadFile(MultipartFile file) throws IllegalStateException, IOException{
		
		UploadFile f = FileMetaDataUtility.convertToMetaData(file);
		
		return fileService.saveFile(file, f);
		
	}
	
	@RequestMapping(value = "/fileInfo/{id}", method = RequestMethod.GET)
	public UploadFile getFileInfo(@PathVariable Integer id) throws InvalidInputException {
		
		if (fileService.getFile(id) == null) throw new InvalidInputException("No Existing File...");
		else return fileService.getFile(id);
		
	}
	
	@RequestMapping(value = "/fileInfo", method = RequestMethod.GET)
	public List<UploadFile> getAllFiles() {
		
		return fileService.getAllFiles();
		
	}
	
	
	@ExceptionHandler(value = InvalidInputException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public String showError(InvalidInputException e) {
		return e.getMessage();
	}
	
	
	
}
