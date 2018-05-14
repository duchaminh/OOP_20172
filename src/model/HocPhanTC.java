package model;

import java.util.ArrayList;

/*@author hai*/
/**
 * desciption:
 */
public class HocPhanTC extends HocPhan {

	 /*=================== ATTRIBUTEs ==================================*/
	 private ArrayList<String> maHocPhanTCDieuKien;

	 /*=================== CONSTRUCTORs ================================*/
	 public HocPhanTC() {
		  maHocPhanTCDieuKien = new ArrayList<>();
	 }

	 public HocPhanTC(String maHocPhan, String tenHocPhan, float trongSoGiuaKy, float trongSoCuoiKy, ArrayList<String> maChuongTrinhHoc) {
		  super(maHocPhan, tenHocPhan, trongSoGiuaKy, trongSoCuoiKy, maChuongTrinhHoc);
		  maHocPhanTCDieuKien = new ArrayList<>();

	 }

	 public HocPhanTC(ArrayList<String> maHocPhanTCDieuKien) {
		  this.maHocPhanTCDieuKien = maHocPhanTCDieuKien;
	 }

	 public HocPhanTC(ArrayList<String> maHocPhanTCDieuKien, String maHocPhan, String tenHocPhan, float trongSoGiuaKy, float trongSoCuoiKy, ArrayList<String> maChuongTrinhHoc) {
		  super(maHocPhan, tenHocPhan, trongSoGiuaKy, trongSoCuoiKy, maChuongTrinhHoc);
		  this.maHocPhanTCDieuKien = maHocPhanTCDieuKien;
	 }

	 /*=================== GETTTERs & SETTERs  ============================*/
	 public ArrayList<String> getMaHocPhanTCDieuKien() {
		  return maHocPhanTCDieuKien;
	 }

	 public void setMaHocPhanTCDieuKien(ArrayList<String> maHocPhanTCDieuKien) {
		  this.maHocPhanTCDieuKien = maHocPhanTCDieuKien;
	 }

}//class HocPhanTC
