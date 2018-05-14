package model;

import java.util.ArrayList;

/*@author hai*/
/**
 * desciption:
 */
public class LopSinhVien {

	 /*=================== ATTRIBUTEs ==================================*/
	 private String maLopSinhVien;
	 private int namNhapHoc;
	 private String maChuongTrinhHoc;
	 
	 private ArrayList<SinhVien> sinhVien;

	 /*=================== CONSTRUCTORs ================================*/
	 public LopSinhVien() {
		  sinhVien = new ArrayList<>();
	 }

	 public LopSinhVien(String maLopSinhVien, int namNhapHoc, ArrayList<SinhVien> sinhVien, String maChuongTrinhHoc) {
		  this.maLopSinhVien = maLopSinhVien;
		  this.namNhapHoc = namNhapHoc;
		  this.sinhVien = sinhVien;
		  this.maChuongTrinhHoc = maChuongTrinhHoc;
	 }



	 /*=================== GETTTERs & SETTERs  ============================*/

	 public String getMaLopSinhVien() {
		  return maLopSinhVien;
	 }

	 public void setMaLopSinhVien(String maLopSinhVien) {
		  this.maLopSinhVien = maLopSinhVien;
	 }

	 public int getNamNhapHoc() {
		  return namNhapHoc;
	 }

	 public void setNamNhapHoc(int namNhapHoc) {
		  this.namNhapHoc = namNhapHoc;
	 }

	 public ArrayList<SinhVien> getSinhVien() {
		  return sinhVien;
	 }

	 public void setSinhVien(ArrayList<SinhVien> sinhVien) {
		  this.sinhVien = sinhVien;
	 }

	 /*=================== OTHER METHODs  ===============================*/

	 public String getMaChuongTrinhHoc() {
		  return maChuongTrinhHoc;
	 }

	 public void setMaChuongTrinhHoc(String maChuongTrinhHoc) {
		  this.maChuongTrinhHoc = maChuongTrinhHoc;
	 }


}//class LopSinhVien
