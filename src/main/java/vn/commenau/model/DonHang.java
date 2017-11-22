package vn.commenau.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name="donhang")
public class DonHang {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private Date thoigian;
	
	@ManyToOne
	@JoinColumn(name="idkhachhang")
	private KhachHang khachhang;
	
	@ManyToOne
	@JoinColumn(name="idnoitro")
	private NoiTro noitro;
	
	@OneToMany(targetEntity=ChiTietDonHang.class, mappedBy="donhang")
//	@JsonBackReference
	private Set<ChiTietDonHang> chitietdonhangs;

	public DonHang() {
		super();
		// TODO Auto-generated constructor stub
	}


	public DonHang(int id, Date thoigian, KhachHang khachhang, NoiTro noitro, Set<ChiTietDonHang> chitietdonhangs) {
		super();
		this.id = id;
		this.thoigian = thoigian;
		this.khachhang = khachhang;
		this.noitro = noitro;
		this.chitietdonhangs = chitietdonhangs;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getThoigian() {
		return thoigian;
	}

	public void setThoigian(Date thoigian) {
		this.thoigian = thoigian;
	}

	public KhachHang getKhachhang() {
		return khachhang;
	}

	public void setKhachhang(KhachHang khachhang) {
		this.khachhang = khachhang;
	}

	public NoiTro getNoitro() {
		return noitro;
	}

	public void setNoitro(NoiTro noitro) {
		this.noitro = noitro;
	}

	public Set<ChiTietDonHang> getChitietdonhangs() {
		return chitietdonhangs;
	}

	public void setChitietdonhangs(Set<ChiTietDonHang> chitietdonhangs) {
		this.chitietdonhangs = chitietdonhangs;
	}
	
	
}
