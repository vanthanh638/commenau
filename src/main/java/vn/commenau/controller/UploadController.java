package vn.commenau.controller;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import vn.commenau.lib.RenameFileUtils;
import vn.commenau.model.FileInfo;

@RestController
public class UploadController {
	@Autowired
	private ServletContext context;
	
	@RequestMapping(value = "api/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, method = RequestMethod.POST)
	public ResponseEntity<FileInfo> upload(@RequestPart("file") MultipartFile inputFile,
			HttpServletRequest request) {
		
		FileInfo fileInfo = new FileInfo();
		
		HttpHeaders headers = new HttpHeaders();
//		return inputFile.getOriginalFilename();
		if (!"".equals(inputFile.getOriginalFilename())) {
			String dirPath = context.getRealPath("/files");
			System.out.println("Dirpath: " + dirPath);
			File dir = new File(dirPath);
			
			if (!dir.exists()){
				dir.mkdir();
			}
			
			String filename = RenameFileUtils.renameFile(inputFile.getOriginalFilename());
			String filePath = dirPath + File.separator + filename;

			try {
				inputFile.transferTo(new File(filePath));
				fileInfo.setFileName(filename);
				fileInfo.setFileSize(inputFile.getSize());
				System.out.println("File: " + filePath);
				return new ResponseEntity<FileInfo>(fileInfo, headers, HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<FileInfo>(HttpStatus.BAD_REQUEST);
			}
		} else {
			return new ResponseEntity<FileInfo>(HttpStatus.BAD_REQUEST);
		}
	}
}
