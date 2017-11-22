package vn.commenau.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="chitietdonhang")
public class ChiTietDonHang {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="idmonan")
	private MonAn monAn;
	
	private int soluong;
	
	@ManyToOne
	@JoinColumn(name="iddonhang")
	@JsonIgnore
	private DonHang donhang;

	public ChiTietDonHang() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ChiTietDonHang(int id, MonAn monAn, int soluong, DonHang donHang) {
		super();
		this.id = id;
		this.monAn = monAn;
		this.soluong = soluong;
		this.donhang = donHang;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public MonAn getMonAn() {
		return monAn;
	}

	public void setMonAn(MonAn monAn) {
		this.monAn = monAn;
	}

	public int getSoluong() {
		return soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

	public DonHang getDonhang() {
		return donhang;
	}

	public void setDonhang(DonHang donHang) {
		this.donhang = donHang;
	}
	
	
}
