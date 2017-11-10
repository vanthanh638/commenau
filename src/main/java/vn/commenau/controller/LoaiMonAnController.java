package vn.commenau.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import vn.commenau.model.LoaiMonAn;
import vn.commenau.repository.LoaiMonAnRepository;
import vn.commenau.service.LoaiMonAnService;

@RestController
@RequestMapping("api/loai-mon-an")
public class LoaiMonAnController {
	@Autowired
	private LoaiMonAnService loaiMonAnService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<LoaiMonAn> getAll() {
		return (List<LoaiMonAn>) loaiMonAnService.findAll();
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public LoaiMonAn findById(@PathVariable("id") int id) {
		return loaiMonAnService.findById(id);
	}

	// add
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public LoaiMonAn add(@RequestBody LoaiMonAn loaiMonAn) {
		System.out.println(loaiMonAn.getName());
		loaiMonAnService.save(loaiMonAn);
		return loaiMonAn;
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public LoaiMonAn update(@RequestBody LoaiMonAn loaiMonAn) {
		LoaiMonAn obj = loaiMonAnService.findById(loaiMonAn.getId());
		if (obj != null) {
			loaiMonAnService.save(loaiMonAn);
			return loaiMonAn;
		}
		return loaiMonAn;
	}
	@RequestMapping(value = "{name}", method = RequestMethod.GET )
	public LoaiMonAn findbyName(@PathVariable("Name") String Name ){
		return LoaiMonAnRepository.findbyName(Name);
	}

	// delete Item
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") int id) {
		LoaiMonAn obj = loaiMonAnService.findById(id);
		if (obj == null) {
			return;
		}
		loaiMonAnService.delete(id);
		System.out.println("Delete id: " + id);
	}
}
