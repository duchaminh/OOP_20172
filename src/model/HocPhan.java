package model;

import java.util.ArrayList;

/*@author hai*/
/**
 * desciption:
 */
public class HocPhan {

	 /*=================== ATTRIBUTEs ==================================*/
	 private String maHocPhan;
	 private String tenHocPhan;
	 private float trongSoGiuaKy;
	 private float trongSoCuoiKy;
	 
	 private ArrayList<String> maChuongTrinhHoc;

	 /*=================== CONSTRUCTORs ================================*/

	 public HocPhan() {
		  maChuongTrinhHoc = new ArrayList<>();
	 }

	 public HocPhan(String maHocPhan, String tenHocPhan, float trongSoGiuaKy, float trongSoCuoiKy, ArrayList<String> maChuongTrinhHoc) {
		  this.maHocPhan = maHocPhan;
		  this.tenHocPhan = tenHocPhan;
		  this.trongSoGiuaKy = trongSoGiuaKy;
		  this.trongSoCuoiKy = trongSoCuoiKy;
		  this.maChuongTrinhHoc = maChuongTrinhHoc;
	 }


	 /*=================== GETTTERs & SETTERs  ============================*/

	 public String getMaHocPhan() {
		  return maHocPhan;
	 }

	 public void setMaHocPhan(String maHocPhan) {
		  this.maHocPhan = maHocPhan;
	 }

	 public String getTenHocPhan() {
		  return tenHocPhan;
	 }

	 public void setTenHocPhan(String tenHocPhan) {
		  this.tenHocPhan = tenHocPhan;
	 }

	 public float getTrongSoGiuaKy() {
		  return trongSoGiuaKy;
	 }

	 public void setTrongSoGiuaKy(float trongSoGiuaKy) {
		  this.trongSoGiuaKy = trongSoGiuaKy;
	 }

	 public float getTrongSoCuoiKy() {
		  return trongSoCuoiKy;
	 }

	 public void setTrongSoCuoiKy(float trongSoCuoiKy) {
		  this.trongSoCuoiKy = trongSoCuoiKy;
	 }

	 /*=================== OTHER METHODs  ===============================*/

	 public ArrayList<String> getMaChuongTrinhHoc() {
		  return maChuongTrinhHoc;
	 }

	 public void setMaChuongTrinhHoc(ArrayList<String> maChuongTrinhHoc) {
		  this.maChuongTrinhHoc = maChuongTrinhHoc;
	 }
}//class HocPhan
