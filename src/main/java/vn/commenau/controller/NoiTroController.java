package vn.commenau.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import vn.commenau.model.NoiTro;
import vn.commenau.service.NoiTroService;

@RestController
@RequestMapping("api/noi-tro")
public class NoiTroController {
	@Autowired
	private NoiTroService noiTroService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<NoiTro> getAll() {
		return (List<NoiTro>) noiTroService.findAll();
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public NoiTro findById(@PathVariable("id") int id) {
		return noiTroService.findById(id);
	}
	
	@RequestMapping(value = "email/{email}", method = RequestMethod.GET)
	public NoiTro findByEmail(@PathVariable("email") String email) {
		email = email + ".com";
		System.out.println("Email:" + email + "0");
		NoiTro noiTro = null;
		noiTro = noiTroService.findByEmail(email);
//		if (noiTro != null) {
//			System.out.println(noiTro.getEmail());
//		} else {
//			System.out.println("Noitro null");
//		}
		
		return noiTro;
	}

	// add
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public NoiTro add(@RequestBody NoiTro noiTro) {
		noiTroService.save(noiTro);
		return noiTro;
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public NoiTro update(@RequestBody NoiTro noiTro) {
		NoiTro obj = noiTroService.findById(noiTro.getId());
		if (obj != null) {
			noiTroService.save(noiTro);
			return noiTro;
		}
		return noiTro;
	}

	// delete Item
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") int id) {
		NoiTro obj = noiTroService.findById(id);
		if (obj == null) {
			return;
		}
		noiTroService.delete(id);
		System.out.println("Delete id: " + id);
	}
}
