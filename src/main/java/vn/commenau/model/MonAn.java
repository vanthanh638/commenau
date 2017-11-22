package vn.commenau.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="monan")
public class MonAn {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String tenmonan;
	private String mota;
	private String chitiet;
	private float gia;
	private String hinhanh;
	private int rate;
	private String nguyenlieu;
	
	@ManyToOne
	@JoinColumn(name="idloaimonan")
	private LoaiMonAn loaimonan;
	
	@ManyToOne
	@JoinColumn(name="idnoitro")
	private NoiTro noitro;

	public MonAn() {
		super();
	}

	public MonAn(int id, String tenmonan, String mota, String chitiet, float gia, String hinhanh, int rate,
			String nguyenlieu, LoaiMonAn loaimonan, NoiTro noitro) {
		super();
		this.id = id;
		this.tenmonan = tenmonan;
		this.mota = mota;
		this.chitiet = chitiet;
		this.gia = gia;
		this.hinhanh = hinhanh;
		this.rate = rate;
		this.nguyenlieu = nguyenlieu;
		this.loaimonan = loaimonan;
		this.noitro = noitro;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getTenmonan() {
		return tenmonan;
	}


	public void setTenmonan(String tenmonan) {
		this.tenmonan = tenmonan;
	}


	public String getMota() {
		return mota;
	}


	public void setMota(String mota) {
		this.mota = mota;
	}


	public String getChitiet() {
		return chitiet;
	}


	public void setChitiet(String chitiet) {
		this.chitiet = chitiet;
	}


	public float getGia() {
		return gia;
	}

	public void setGia(float gia) {
		this.gia = gia;
	}

	public LoaiMonAn getLoaimonan() {
		return loaimonan;
	}

	public void setLoaimonan(LoaiMonAn loaimonan) {
		this.loaimonan = loaimonan;
	}

	public String getHinhanh() {
		return hinhanh;
	}

	public void setHinhanh(String hinhanh) {
		this.hinhanh = hinhanh;
	}

	public NoiTro getNoitro() {
		return noitro;
	}

	public void setNoitro(NoiTro noiTro) {
		this.noitro = noiTro;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public String getNguyenlieu() {
		return nguyenlieu;
	}

	public void setNguyenlieu(String nguyenlieu) {
		this.nguyenlieu = nguyenlieu;
	}


}
