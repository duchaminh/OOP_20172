package model;

import java.util.ArrayList;

/*@author hai*/
/**
 * desciption:
 */
public class ChuongTrinhHoc {

	 /*=================== ATTRIBUTEs ==================================*/
	 private String maChuongTrinhHoc;
	 private String tenChuongTrinhHoc;
	 
	 private String maNganhHoc;
	 
	 private ArrayList<LopSinhVien> lopSinhVien;
	 private ArrayList<HocPhan> hocPhan;

	 /*=================== CONSTRUCTORs ================================*/

	 public ChuongTrinhHoc() {
		  lopSinhVien  = new ArrayList<>();
		  hocPhan  = new ArrayList<>();
	 }

	 public ChuongTrinhHoc(String maChuongTrinhHoc, String tenChuongTrinhHoc, String maNganhHoc, ArrayList<LopSinhVien> lopSinhVien, ArrayList<HocPhan> hocPhan) {
		  this.maChuongTrinhHoc = maChuongTrinhHoc;
		  this.tenChuongTrinhHoc = tenChuongTrinhHoc;
		  this.maNganhHoc = maNganhHoc;
		  this.lopSinhVien = lopSinhVien;
		  this.hocPhan = hocPhan;
	 }



	 /*=================== GETTTERs & SETTERs  ============================*/
	 public String getMaChuongTrinhHoc() {
		  return maChuongTrinhHoc;
	 }

	 public void setMaChuongTrinhHoc(String maChuongTrinhHoc) {
		  this.maChuongTrinhHoc = maChuongTrinhHoc;
	 }

	 public String getTenChuongTrinhHoc() {
		  return tenChuongTrinhHoc;
	 }

	 public void setTenChuongTrinhHoc(String tenChuongTrinhHoc) {
		  this.tenChuongTrinhHoc = tenChuongTrinhHoc;
	 }

	 public ArrayList<LopSinhVien> getLopSinhVien() {
		  return lopSinhVien;
	 }

	 public void setLopSinhVien(ArrayList<LopSinhVien> lopSinhVien) {
		  this.lopSinhVien = lopSinhVien;
	 }

	 public ArrayList<HocPhan> getHocPhan() {
		  return hocPhan;
	 }

	 public void setHocPhan(ArrayList<HocPhan> hocPhan) {
		  this.hocPhan = hocPhan;
	 }

	 /*=================== OTHER METHODs  ===============================*/

	 public String getMaNganhHoc() {
		  return maNganhHoc;
	 }

	 public void setMaNganhHoc(String maNganhHoc) {
		  this.maNganhHoc = maNganhHoc;
	 }
}//class ChuongTrinhHoc
