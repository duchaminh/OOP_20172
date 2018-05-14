package model;

import java.util.ArrayList;

/*@author hai*/
/**
 * desciption:
 */
public class NganhHoc {

	 /*=================== ATTRIBUTEs ==================================*/
	 private String maNganhHoc;
	 private String tenNganhHoc;
	 
	 private ArrayList<ChuongTrinhHoc> chuongTrinhHoc;

	 /*=================== CONSTRUCTORs ================================*/
	 public NganhHoc() {
		  chuongTrinhHoc = new ArrayList<>();
	 }

	 public NganhHoc(String maNganhHoc, String tenNganhHoc, ArrayList<ChuongTrinhHoc> chuongTrinhHoc) {
		  this.maNganhHoc = maNganhHoc;
		  this.tenNganhHoc = tenNganhHoc;
		  this.chuongTrinhHoc = chuongTrinhHoc;
	 }

	 /*=================== GETTTERs & SETTERs  ============================*/
	 public String getMaNganhHoc() {
		  return maNganhHoc;
	 }

	 public void setMaNganhHoc(String maNganhHoc) {
		  this.maNganhHoc = maNganhHoc;
	 }

	 public String getTenNganhHoc() {
		  return tenNganhHoc;
	 }

	 public void setTenNganhHoc(String tenNganhHoc) {
		  this.tenNganhHoc = tenNganhHoc;
	 }

	 public ArrayList<ChuongTrinhHoc> getChuongTrinhHoc() {
		  return chuongTrinhHoc;
	 }

	 public void setChuongTrinhHoc(ArrayList<ChuongTrinhHoc> chuongTrinhHoc) {
		  this.chuongTrinhHoc = chuongTrinhHoc;
	 }
	 /*=================== OTHER METHODs  ===============================*/

}//class NganhHoc
