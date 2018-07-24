package com.itmuch.cloud.fileupload.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class UserController {

	@PostMapping("/upload")
	@ResponseBody
	public String handlerFileUpload(@RequestParam(value="file", required=true) MultipartFile file) throws IOException {
		
		byte[] bytes = file.getBytes();
		File fileToSave = new File(file.getOriginalFilename());
		FileCopyUtils.copy(bytes, fileToSave);
		
		return fileToSave.getAbsolutePath();
	}
	
}
