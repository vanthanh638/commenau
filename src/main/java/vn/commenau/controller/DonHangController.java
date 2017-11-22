package vn.commenau.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import vn.commenau.model.DonHang;
import vn.commenau.service.DonHangService;

@RestController
@RequestMapping("api/don-hang")
public class DonHangController {

	@Autowired
	private DonHangService donHangService;
	
	// get all
	@RequestMapping(value="", method=RequestMethod.GET)
	public List<DonHang> getList(){
		return (List<DonHang>) donHangService.findAll();
	}
	
	// get by id donhang
	@RequestMapping(value="{id}", method=RequestMethod.GET)
	public DonHang getByIdDonHang(@PathVariable("id") int id) {
		return donHangService.findById(id);
	}
	
	// add
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public DonHang add(@RequestBody DonHang donHang) {
		donHangService.save(donHang);
		return donHang;
	}
	
	// add
	@RequestMapping(value="/update", method=RequestMethod.PUT)
	public DonHang update(@RequestBody DonHang donHang) {
		if (donHangService.findById(donHang.getId()) != null) {
			donHangService.save(donHang);
			return donHang;
		}
		return donHang;
	}
}
