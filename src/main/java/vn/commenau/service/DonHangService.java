package vn.commenau.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.commenau.model.ChiTietDonHang;
import vn.commenau.model.DonHang;
import vn.commenau.repository.DonHangRepository;

@Service
public class DonHangService{

	@Autowired
	public DonHangRepository donHangRepository;
	
	public Iterable<DonHang> findAll() {
		return donHangRepository.findAll();
	}

	// find by id
	public DonHang findById(int id) {
		return donHangRepository.findOne(id);
	}
	
	// save
	public void save(DonHang donHang) {
		donHangRepository.save(donHang);
	}
	
	// delete
	public void delete(int id) {
		donHangRepository.delete(id);
	}
}
