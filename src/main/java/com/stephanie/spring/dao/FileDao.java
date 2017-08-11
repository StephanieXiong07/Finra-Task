package com.stephanie.spring.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.stephanie.spring.entity.UploadFile;


public interface FileDao {
	
	public UploadFile save(UploadFile f);
	
	public UploadFile getFile(Integer id);
	
	public List<UploadFile> getAll();
}
