package vn.commenau.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="noitro")
public class NoiTro {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column
	private String email;
	private String matkhau;
	private String fullname;
	private int gioitinh;
	private String diachi;
	private String sodienthoai;
	private int somon;
	private int soluotquantam;
	
	@OneToMany(targetEntity=MonAn.class, mappedBy="noitro")
	@JsonIgnore
	private Set<MonAn> monAns;
	
	@OneToMany(targetEntity=DonHang.class, mappedBy="noitro")
	@JsonBackReference
	private Set<DonHang> donHangs;
	
	public NoiTro() {
		super();
	}

	public NoiTro(int id, String email, String matkhau, String fullname, int gioitinh, String diachi,
			String sodienthoai, int somon, int soluotquantam, Set<MonAn> monAns) {
		super();
		this.id = id;
		this.email = email;
		this.matkhau = matkhau;
		this.fullname = fullname;
		this.gioitinh = gioitinh;
		this.diachi = diachi;
		this.sodienthoai = sodienthoai;
		this.somon = somon;
		this.soluotquantam = soluotquantam;
		this.monAns = monAns;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMatkhau() {
		return matkhau;
	}

	public void setMatkhau(String matkhau) {
		this.matkhau = matkhau;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public String getSodienthoai() {
		return sodienthoai;
	}

	public void setSodienthoai(String sodienthoai) {
		this.sodienthoai = sodienthoai;
	}

	public Set<MonAn> getMonAns() {
		return monAns;
	}

	public void setMonAns(Set<MonAn> monAns) {
		this.monAns = monAns;
	}

	public int getGioitinh() {
		return gioitinh;
	}

	public void setGioitinh(int gioitinh) {
		this.gioitinh = gioitinh;
	}

	public int getSomon() {
		return somon;
	}

	public void setSomon(int somon) {
		this.somon = somon;
	}

	public int getSoluotquantam() {
		return soluotquantam;
	}

	public void setSoluotquantam(int soluotquantam) {
		this.soluotquantam = soluotquantam;
	}
	
	

}
