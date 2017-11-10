package vn.commenau.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.commenau.model.KhachHang;
import vn.commenau.repository.KhachHangRepository;

@Service
public class KhachHangService {

	@Autowired
	private KhachHangRepository khachHangRepository;
	
	// find all NoiTro
	public Iterable<KhachHang> findAll(){
		return khachHangRepository.findAll();
	}
	
	// find by id 
	public KhachHang findById(int id) {
		return khachHangRepository.findOne(id);
	}
	
	// update noitro
	public void save(KhachHang khachHang) {
		khachHangRepository.save(khachHang);
	}
	
	// delete 
	public void delete(int id) {
		khachHangRepository.delete(id);
	}
}
