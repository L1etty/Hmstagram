package com.kyung2am.hmstagram.common;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.web.multipart.MultipartFile;

public class FileManger {
	
	public static final String FILE_UPLODA_PATH = "D:\\kyung2am\\springProject\\upload\\hmstagram";
	
	public static String saveFile(int userId, MultipartFile file) {
		
		String directoryName = "/" + userId + "_" +System.currentTimeMillis() + "/";
		
		String directoryPath = FILE_UPLODA_PATH + directoryName;
		
		File directory = new File(directoryPath);
		
		if(directory.mkdir()) {
			return null;
		}
		
		try {
			byte[] bytes = file.getBytes();
			
			String filePath = directoryPath + file.getOriginalFilename();
			
			Path path = Paths.get(filePath);
			
			Files.write(path, bytes);
			
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		
		return "/images" + directoryName + file.getOriginalFilename();
		
	}

	
}
