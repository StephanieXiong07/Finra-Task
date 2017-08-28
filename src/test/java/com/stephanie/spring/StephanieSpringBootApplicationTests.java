package com.stephanie.spring;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.stephanie.spring.controller.FileController;
import com.stephanie.spring.dao.FileDao;
import com.stephanie.spring.entity.UploadFile;
import com.stephanie.spring.exception.InvalidInputException;
import com.stephanie.spring.service.FileService;
import com.stephanie.spring.service.FileServiceImp;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StephanieSpringBootApplicationTests {
	
	@Mock
	FileDao fileDAO;
	
	@InjectMocks
	FileServiceImp fileService;
	
	
	
	@Mock
	FileService fileServiceMock;
	
	@InjectMocks
	FileController fileController;
	
	
	private UploadFile uf = new UploadFile();
	private Integer fileID = 100;
	private String fileName = "test.txt";
	private String fileLoc = "testLoc";
	private Date uploadTime = new Date();
	
	private List<UploadFile> testRes = new ArrayList<>();
	
	
	@Before
	public void initTest() {
		
		uf.setFileID(fileID);
		uf.setFileName(fileName);
		uf.setUploadTime(uploadTime);
		uf.setFileLoc(fileLoc);
		
		testRes.add(uf);
		
	}
	
	
	@Test
	public void testGetFile() {
		
		when(fileDAO.getFile(fileID)).thenReturn(uf);
		
		assertEquals(fileService.getFile(fileID).toString(), uf.toString());
		
	}
	
//	@Test(expected = Exception.class)
//	public void testSaveFile() {
//		
//		when(saveContent.storeFileContent(mf, uf)).thenThrow(new Exception());
//		
//		
//	}
	
	@Test
	public void testGetAll() {
		
		when(fileDAO.getAll()).thenReturn(testRes);
		
		assertTrue(fileService.getAllFiles().size() == 1 && fileService.getAllFiles().get(0).toString().equals(testRes.get(0).toString()));
		
	}
	
	
	
	//If service return null, then controller needs to throw InvalidInputException
	
	@Test(expected = InvalidInputException.class)
	public void testGetFileInfoController() throws InvalidInputException {
		
		when(fileServiceMock.getFile(fileID)).thenReturn(null);
		
		fileController.getFileInfo(fileID);
		
	}

}
