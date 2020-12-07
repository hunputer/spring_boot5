package com.iu.sb5.util;

import java.io.File;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileManager {

	public String saveFileCopy(MultipartFile multipartFile, File file) throws Exception{
		String fileName = null;
		
		//중복되지 않는 파일 명 생성
		fileName = UUID.randomUUID().toString()+"_"+multipartFile.getOriginalFilename();
		
		file = new File(file, fileName);
		
		FileCopyUtils.copy(multipartFile.getBytes(), file);
		
		return fileName;
	}
}
