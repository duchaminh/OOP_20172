package model;

import java.util.ArrayList;

/*@author hai*/
/**
 * desciption:
 */
public class HocPhanNC extends HocPhan {

	 /*=================== ATTRIBUTEs ==================================*/
	 private int sttHocKy;

	 /*=================== CONSTRUCTORs ================================*/

	 public HocPhanNC() {
	 }


	 public HocPhanNC(int sttHocKy, String maHocPhan, String tenHocPhan, float trongSoGiuaKy, float trongSoCuioiKy, ArrayList<String> maChuongTrinhHoc) {
		  super(maHocPhan, tenHocPhan, trongSoGiuaKy, trongSoCuioiKy, maChuongTrinhHoc);
		  this.sttHocKy = sttHocKy;
	 }



	 /*=================== GETTTERs & SETTERs  ============================*/

	 public int getSttHocKy() {
		  return sttHocKy;
	 }

	 public void setSttHocKy(int sttHocKy) {
		  this.sttHocKy = sttHocKy;
	 }

	 /*=================== OTHER METHODs  ===============================*/
}//class HocPhanNC
