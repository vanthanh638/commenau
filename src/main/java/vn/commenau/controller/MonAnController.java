package vn.commenau.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import vn.commenau.model.FileInfo;
import vn.commenau.model.MonAn;
import vn.commenau.model.NoiTro;
import vn.commenau.service.MonAnService;
import vn.commenau.service.NoiTroService;

@RestController
@RequestMapping("api/mon-an")
public class MonAnController {
	@Autowired
	private MonAnService monAnService;
	
	@Autowired
	private NoiTroService noiTroService;
	
	@Autowired
	private ServletContext context;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<MonAn> getAll() {
		return (List<MonAn>) monAnService.findAll();
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public MonAn findById(@PathVariable("id") int id) {
		return monAnService.findById(id);
	}
	
	// find by idnoitro
	@RequestMapping(value="noitro/{id}", method = RequestMethod.GET)
	public List<MonAn> findByIdNoiTro(@PathVariable("id") int idnoitro){
		NoiTro noitro = noiTroService.findById(idnoitro);
		return monAnService.findByIdNoiTro(noitro);
	}

	// add
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public MonAn add(@RequestBody MonAn monAn) {
		monAnService.save(monAn);
		return monAn;
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public MonAn update(@RequestBody MonAn monAn) {
		MonAn obj = monAnService.findById(monAn.getId());
		if (obj != null) {
			monAnService.save(monAn);
			return monAn;
		}
		return monAn;
	}

	// delete Item
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") int id) {
		MonAn obj = monAnService.findById(id);
		if (obj == null) {
			return;
		}
		monAnService.delete(id);
	}

	// upload file example
	@RequestMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, method = RequestMethod.POST)
	public ResponseEntity<FileInfo> upload(@RequestPart("file") MultipartFile inputFile,
			HttpServletRequest request) {
		System.out.println("File: " + inputFile.getOriginalFilename());
		FileInfo fileInfo = new FileInfo();
		HttpHeaders headers = new HttpHeaders();
//		return inputFile.getOriginalFilename();
		if (!"".equals(inputFile.getOriginalFilename())) {
			String dirPath = context.getRealPath("/files");
			File dir = new File(dirPath);
			
			if (!dir.exists()){
				dir.mkdir();
			}
			
			String filename = inputFile.getOriginalFilename();
			String filePath = dirPath + File.separator + filename;
			
			try {
				inputFile.transferTo(new File(filePath));
				fileInfo.setFileName(filePath);
				fileInfo.setFileSize(inputFile.getSize());
				return new ResponseEntity<FileInfo>(fileInfo, headers, HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<FileInfo>(HttpStatus.BAD_REQUEST);
			}
		} else {
			return new ResponseEntity<FileInfo>(HttpStatus.BAD_REQUEST);
		}
	}
}
