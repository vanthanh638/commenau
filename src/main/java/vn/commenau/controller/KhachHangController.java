package vn.commenau.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import vn.commenau.model.KhachHang;
import vn.commenau.service.KhachHangService;

@RestController
@RequestMapping("api/khach-hang")
public class KhachHangController {
	@Autowired
	private KhachHangService khachHangService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<KhachHang> getAll() {
		return (List<KhachHang>) khachHangService.findAll();
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public KhachHang findById(@PathVariable("id") int id) {
		return khachHangService.findById(id);
	}

	// add
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public KhachHang add(@RequestBody KhachHang khachHang) {
		khachHangService.save(khachHang);
		return khachHang;
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public KhachHang update(@RequestBody KhachHang khachHang) {
		KhachHang obj = khachHangService.findById(khachHang.getId());
		if (obj != null) {
			khachHangService.save(khachHang);
			return khachHang;
		}
		return khachHang;
	}

	// delete Item
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") int id) {
		KhachHang obj = khachHangService.findById(id);
		if (obj == null) {
			return;
		}
		khachHangService.delete(id);
		System.out.println("Delete id: " + id);
	}
}
