package vn.commenau.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import vn.commenau.model.NoiTro;


//@Repository
public interface NoiTroRepository extends JpaRepository<NoiTro, Integer>{
	
	@Query("select n from NoiTro n where n.email = ?1")
	NoiTro findByEmail( String email);
}
