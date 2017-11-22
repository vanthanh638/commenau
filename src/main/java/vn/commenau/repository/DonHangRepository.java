package vn.commenau.repository;

import org.springframework.data.repository.CrudRepository;

import vn.commenau.model.DonHang;
import vn.commenau.model.KhachHang;

public interface DonHangRepository extends CrudRepository<DonHang, Integer> {

}
