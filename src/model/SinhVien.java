package model;

import java.util.ArrayList;

/*@author hai*/
/**
 * desciption:
 */
public class SinhVien extends User{

	 /*=================== ATTRIBUTEs ==================================*/
	 private String mssv;
	 private String hoTen;
	 private String username;
	 private String password;
	 private String trangThai;
	 private String bangTotNghiep;

	 private String maLopSinhVien;
	 private String maChuongTrinhHoc;
	 private String maNganhHoc;

	 private ArrayList<KetQuaHocPhan> bangDiem;
	 private ArrayList<HocKySinhVien> hocKySinhVien;

	 /*=================== CONSTRUCTORs ================================*/
	 public SinhVien() {
		  bangDiem = new ArrayList<>();
		  hocKySinhVien = new ArrayList();
	 }

	 public SinhVien(String mssv, String hoTen, String username, String password, String trangThai, String bangTotNghiep, String maLopSinhVien, String maChuongTrinhHoc, String maNganhHoc, ArrayList<KetQuaHocPhan> bangDiem, ArrayList<HocKySinhVien> hocKySinhVien) {
		  this.mssv = mssv;
		  this.hoTen = hoTen;
		  this.username = username;
		  this.password = password;
		  this.trangThai = trangThai;
		  this.bangTotNghiep = bangTotNghiep;
		  this.maLopSinhVien = maLopSinhVien;
		  this.maChuongTrinhHoc = maChuongTrinhHoc;
		  this.maNganhHoc = maNganhHoc;
		  this.bangDiem = bangDiem;
		  this.hocKySinhVien = hocKySinhVien;
	 }



	 /*=================== GETTTERs & SETTERs  ============================*/
	 public String getMssv() {
		  return mssv;
	 }

	 public void setMssv(String mssv) {
		  this.mssv = mssv;
	 }

	 public String getHoTen() {
		  return hoTen;
	 }

	 public void setHoTen(String hoTen) {
		  this.hoTen = hoTen;
	 }

	 public String getUsername() {
		  return username;
	 }

	 public void setUsername(String username) {
		  this.username = username;
	 }

	 public String getPassword() {
		  return password;
	 }

	 public void setPassword(String password) {
		  this.password = password;
	 }

	 public String getTrangThai() {
		  return trangThai;
	 }

	 public void setTrangThai(String trangThai) {
		  this.trangThai = trangThai;
	 }

	 public String getBangTotNghiep() {
		  return bangTotNghiep;
	 }

	 public void setBangTotNghiep(String bangTotNghiep) {
		  this.bangTotNghiep = bangTotNghiep;
	 }

	 public ArrayList<KetQuaHocPhan> getBangDiem() {
		  return bangDiem;
	 }

	 public void setBangDiem(ArrayList<KetQuaHocPhan> bangDiem) {
		  this.bangDiem = bangDiem;
	 }

	 public ArrayList<HocKySinhVien> getHocKySinhVien() {
		  return hocKySinhVien;
	 }

	 public void setHocKySinhVien(ArrayList<HocKySinhVien> hocKySinhVien) {
		  this.hocKySinhVien = hocKySinhVien;
	 }

	 public String getMaLopSinhVien() {
		  return maLopSinhVien;
	 }

	 public void setMaLopSinhVien(String maLopSinhVien) {
		  this.maLopSinhVien = maLopSinhVien;
	 }

	 /*=================== OTHER METHODs  ===============================*/

	 public String getMaChuongTrinhHoc() {
		  return maChuongTrinhHoc;
	 }

	 public void setMaChuongTrinhHoc(String maChuongTrinhHoc) {
		  this.maChuongTrinhHoc = maChuongTrinhHoc;
	 }

	 public String getMaNganhHoc() {
		  return maNganhHoc;
	 }

	 public void setMaNganhHoc(String maNganhHoc) {
		  this.maNganhHoc = maNganhHoc;
	 }
         
         
            

}//class SinhVien
