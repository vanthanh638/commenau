package vn.commenau.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import vn.commenau.model.LoaiMonAn;

public interface LoaiMonAnRepository extends CrudRepository<LoaiMonAn, Integer> {

//	@Query("select * from LoaiMonAn Order By TenMonAn like %'?'%")
//	LoaiMonAn findbyName(String name) ;

}
