package vn.commenau.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.commenau.model.LoaiMonAn;
import vn.commenau.repository.LoaiMonAnRepository;

@Service
public class LoaiMonAnService {

	@Autowired
	private LoaiMonAnRepository loaiMonAnRepository;
	
	// find all NoiTro
	public Iterable<LoaiMonAn> findAll(){
		return loaiMonAnRepository.findAll();
	}
	
	// find by id 
	public LoaiMonAn findById(int id) {
		return loaiMonAnRepository.findOne(id);
	}
	
	// update noitro
	public void save(LoaiMonAn loaiMonAn) {
		loaiMonAnRepository.save(loaiMonAn);
	}
	
	// delete 
	public void delete(int id) {
		loaiMonAnRepository.delete(id);
	}
}
