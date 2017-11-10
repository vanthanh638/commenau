package vn.commenau.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.commenau.model.NoiTro;
import vn.commenau.repository.NoiTroRepository;

@Service
public class NoiTroService {

	@Autowired
	private NoiTroRepository noiTroRepository;
	
	// find all NoiTro
	public Iterable<NoiTro> findAll(){
		return noiTroRepository.findAll();
	}
	
	// find by id 
	public NoiTro findById(int id) {
		return noiTroRepository.findOne(id);
	}
	
	// update noitro
	public void save(NoiTro noiTro) {
		noiTroRepository.save(noiTro);
	}
	
	// delete 
	public void delete(int id) {
		noiTroRepository.delete(id);
	}
	
	public NoiTro findByEmail(String email) {
		NoiTro noiTro = noiTroRepository.findByEmail(email);
		if (noiTro != null) {
			System.out.println(noiTro.getEmail());
		} else {
			System.out.println("Noitro null");
		}
		return noiTro;
	}
}
