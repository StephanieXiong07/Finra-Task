package com.stephanie.spring.utility;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.stephanie.spring.entity.UploadFile;

public class SaveFileContent {
	
	public static void storeFileContent(MultipartFile mFile, UploadFile f) throws IllegalStateException, IOException {
		 mFile.transferTo(new File(f.getFileLoc()));
	}
}
