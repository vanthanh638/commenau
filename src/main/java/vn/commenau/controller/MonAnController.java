package vn.commenau.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import vn.commenau.model.LoaiMonAn;
import vn.commenau.model.MonAn;
import vn.commenau.model.NoiTro;
import vn.commenau.service.LoaiMonAnService;
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
	private LoaiMonAnService loaiMonAnService;

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
	
	@RequestMapping(value="/loai-mon-an/{idnoitro}")
	public List<MonAn> findByLoaiMonAn(@PathVariable("idnoitro") int idloai){
		LoaiMonAn loaiMonAn = loaiMonAnService.findById(idloai);
		return monAnService.finByLoaiMonAn(loaiMonAn);
	}

	// add
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public MonAn add(@RequestBody MonAn monAn) {
		System.out.println("Loai Mon" + monAn.getLoaimonan().getName());
		System.out.println("Noi tro ID : " + monAn.getNoitro().getId());
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

}
