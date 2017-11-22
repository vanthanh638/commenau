package vn.commenau.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.commenau.model.ChiTietDonHang;
import vn.commenau.model.LoaiMonAn;
import vn.commenau.repository.DonHangRepository;

@Service
public class ChiTietDonHangService {

	@Autowired
	public ChiTietDonHangService chiTietDonHangRepository;

	// find all NoiTro
	public Iterable<ChiTietDonHang> findAll() {
		return chiTietDonHangRepository.findAll();
	}

	// find by id
	public ChiTietDonHang findById(int id) {
		return chiTietDonHangRepository.findById(id);
	}

	// save
	public void save(ChiTietDonHang chiTietDonHang) {
		chiTietDonHangRepository.save(chiTietDonHang);
	}

	// delete
	public void delete(int id) {
		chiTietDonHangRepository.delete(id);
	}
}
