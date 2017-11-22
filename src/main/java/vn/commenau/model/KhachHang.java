package vn.commenau.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="khachhang")
public class KhachHang {
	@Id
	private int id;
	private String email;
	private String matkhau;
	private String fullname;
	private String diachi;
	private String sodienthoai;
	
	@OneToMany(targetEntity=DonHang.class, mappedBy="khachhang")
	@JsonBackReference
	private Set<DonHang> donHangs;
	
	public KhachHang() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public KhachHang(int id, String email, String matkhau, String fullname, String diachi, String sodienthoai) {
		super();
		this.id = id;
		this.email = email;
		this.matkhau = matkhau;
		this.fullname = fullname;
		this.diachi = diachi;
		this.sodienthoai = sodienthoai;
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
	
	
}
