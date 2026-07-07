package com.study.ecommerce.services;

import java.io.InputStream;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {

	String uploadImage(MultipartFile file,String path);  //THIS IS FOR UPLOAD
	InputStream getResource(String path,String name);    //THIS IS FOR READ,IF YOU WANT TO WRITE USE OUTPUTSTREAM
}
