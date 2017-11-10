package vn.commenau.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.commenau.model.MonAn;
import vn.commenau.model.NoiTro;
import vn.commenau.repository.MonAnRepository;

@Service
public class MonAnService {

	@Autowired
	private MonAnRepository monAnRepository;
	
	// find all NoiTro
	public Iterable<MonAn> findAll(){
		return monAnRepository.findAll();
	}
	
	// find by id 
	public MonAn findById(int id) {
		return monAnRepository.findOne(id);
	}
	
	// find by idnoitro
	public List<MonAn> findByIdNoiTro(NoiTro noitro){
		return monAnRepository.findByIdNoiTro(noitro);
	}
	
	// update noitro
	public void save(MonAn monAn) {
		monAnRepository.save(monAn);
	}
	
	// delete 
	public void delete(int id) {
		monAnRepository.delete(id);
	}
}
