package com.study.ecommerce.services.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.study.ecommerce.services.FileService;

@Service
public class FileServiceImpl  implements FileService {

	@Override
	public String uploadImage(MultipartFile file, String path) {
	  
	String fileName = file.getOriginalFilename();
	
	String extension = fileName.substring(fileName.lastIndexOf('.'));  //TO GET THE EXTENSION
	
//   457fhe-4345jf-ffej34.png
	String newFileName=UUID.randomUUID().toString()+extension;
	
	File folder = new File(path);
	
	//TO CREATE FOLDER IF NOT EXISTS
	if(!folder.exists())
	{
		folder.mkdirs();       
	}
	
	try {
		Files.copy(file.getInputStream(),Paths.get(path,newFileName));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return newFileName;
	}

	@Override
	public InputStream getResource(String path, String name) {
		
		String fileName=path+File.separator+name;
		FileInputStream inputStream=null;
		
		try {
			inputStream=new FileInputStream(fileName);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return inputStream;
	}

}
