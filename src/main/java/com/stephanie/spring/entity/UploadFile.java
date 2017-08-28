package com.stephanie.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "fileTable")
public class UploadFile implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 242347598567683510L;
	
	
	@Id
	@Column(name = "file_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer fileID;
	
	public Integer getFileID() {
		return fileID;
	}
	public void setFileID(Integer fileID) {
		this.fileID = fileID;
	}

	@Column(name = "file_name")
	private String fileName;
	
	@Column(name = "file_path")
	private String fileLoc;
	
	@Column(name = "upload_time")
	private Date uploadTime;
	
	
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	
	public String getFileLoc() {
		return fileLoc;
	}
	public void setFileLoc(String fileLoc) {
		this.fileLoc = fileLoc;
	}
	
	
	public Date getUploadTime() {
		return uploadTime;
	}
	public void setUploadTime(Date uploadTime) {
		this.uploadTime = uploadTime;
	}
	
	@Override
	public String toString() {
		return "File [fileID=" + fileID + ", fileName=" + fileName + ", fileLoc=" + fileLoc + ", uploadTime="
				+ uploadTime + "]";
	}

}
