package com.stephanie.spring.service;

import java.io.IOException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.stephanie.spring.dao.FileDao;
import com.stephanie.spring.entity.UploadFile;
import com.stephanie.spring.utility.SaveFileContent;

@Service
public class FileServiceImp implements FileService {
	
	@Autowired
	FileDao fileDAO;

	@Override
	@Transactional
	public UploadFile saveFile(MultipartFile mFile, UploadFile file) throws IllegalStateException, IOException {
		// TODO Auto-generated method stub
		SaveFileContent.storeFileContent(mFile, file);
		return fileDAO.save(file);
		
	}

	@Override
	@Transactional
	public UploadFile getFile(Integer id) {
		// TODO Auto-generated method stub
		return fileDAO.getFile(id);
	}

	@Override
	public List<UploadFile> getAllFiles() {
		// TODO Auto-generated method stub
		return fileDAO.getAll();
	}
	
	
}
