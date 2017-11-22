package vn.commenau.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import vn.commenau.model.LoaiMonAn;
import vn.commenau.model.MonAn;
import vn.commenau.model.NoiTro;

public interface MonAnRepository extends CrudRepository<MonAn, Integer>{

	@Query("select ma from MonAn ma where ma.noitro = ?1")
	List<MonAn> findByIdNoiTro(NoiTro noitro);

	@Query("select ma from MonAn ma where ma.loaimonan = ?1")
	List<MonAn> findByLoaiMonAn(LoaiMonAn loaimonan);
}
