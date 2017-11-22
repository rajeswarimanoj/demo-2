package com.upload.demo.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.upload.demo.service.Files;
import com.upload.demo.service.DocumentMetadata;
import com.upload.demo.service.UploadService;

@RestController
public class FileUploadController {
	
	private static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);
	
	@Autowired
	UploadService uploadService;
	
	@RequestMapping(value = "/fileupload", method = RequestMethod.POST)
	public @ResponseBody DocumentMetadata handleFileUpload(
            @RequestParam(value="file", required=true) MultipartFile file 
           ) {
	 try {
         Files document = new Files(file.getBytes(), file.getOriginalFilename());
         uploadService.save(document);
         return document.getMetadata();
     } 
     catch (Exception e) {
    	 logger.error("Error while uploading.", e);
         throw new RuntimeException(e);
     } 

    }
}
