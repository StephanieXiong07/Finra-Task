package com.stephanie.spring.utility;

import java.io.File;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import com.stephanie.spring.entity.UploadFile;

public class FileMetaDataUtility {
	
	static final String LOC_PATH = "files/";
	
	public static UploadFile convertToMetaData(MultipartFile f) {
		
		UploadFile fileData = new UploadFile();
		
		fileData.setFileName(f.getOriginalFilename());
		fileData.setFileLoc((new File(LOC_PATH)).getAbsolutePath() + "/" + f.getOriginalFilename());
		fileData.setUploadTime(new Date());
		
		return fileData;
	}
	
}
