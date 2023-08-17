package com.kyung2am.hmstagram.common;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public class FileManger {
	
	public static final String FILE_UPLODA_PATH = "D:\\kyung2am\\springProject\\upload\\hmstagram";
	
	private static Logger logger = LoggerFactory.getLogger(FileManger.class);
	
	public static String saveFile(int userId, MultipartFile file) {
		if(file == null) {
			logger.error("saveFile :: 파일이 없음");
			return null;
		}
		
		String directoryName = "/" + userId + "_" + System.currentTimeMillis() + "/";
		
		String directoryPath = FILE_UPLODA_PATH + directoryName;
		
		File directory = new File(directoryPath);
		
		if(!directory.mkdir()) {
			logger.error("saveFile :: 디렉토리 생성 에러" + directoryPath);
			return null;
		}
		
		String filePath = null;
		try {
			byte[] bytes = file.getBytes();
			
			filePath = directoryPath + file.getOriginalFilename();
			
			Path path = Paths.get(filePath);
			
			Files.write(path, bytes);
			
		} catch (IOException e) {
			
			logger.error("ssaveFile :: 파일 저장 에러 경로 - " + filePath);
			
			e.printStackTrace();
			return null;
		}
		
		return "/images" + directoryName + file.getOriginalFilename();
		
	}

	public static boolean removeFile(String FilePath) {
		
		//null 일수가 없긴한데 일단 체크는 함.
		if(FilePath == null) {
			return false;
		}
		
		String fullFillPath = FILE_UPLODA_PATH + FilePath.replace("/images", "");
		
		Path path = Paths.get(fullFillPath);
		
		if(Files.exists(path)){
			try {
				Files.delete(path);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
				return false;
			}
		}
		
		path = path.getParent();
		
		if(Files.exists(path)) {
			try {
				Files.delete(path);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}
		return true;
	}
	
}
