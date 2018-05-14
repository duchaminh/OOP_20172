package model;

/*@author hai*/
/**
 * desciption:
 */
public class DangKyHocPhan {

	 /*=================== ATTRIBUTEs ==================================*/
	 private String maHocPhan;
	 private String maHocKyHeThong;
	 
	 private int soLuongSinhVienDangKy;

	 /*=================== CONSTRUCTORs ================================*/
	 public DangKyHocPhan() {
	 }

	 public DangKyHocPhan(String maHocPhan, String maHocKyHeThong, int soLuongSinhVienDangKy) {
		  this.maHocPhan = maHocPhan;
		  this.maHocKyHeThong = maHocKyHeThong;
		  this.soLuongSinhVienDangKy = soLuongSinhVienDangKy;
	 }


	 /*=================== GETTTERs & SETTERs  ============================*/
	 public String getMaHocPhan() {
		  return maHocPhan;
	 }

	 public void setMaHocPhan(String maHocPhan) {
		  this.maHocPhan = maHocPhan;
	 }

	 public int getSoLuongSinhVienDangKy() {
		  return soLuongSinhVienDangKy;
	 }

	 public void setSoLuongSinhVienDangKy(int soLuongSinhVienDangKy) {
		  this.soLuongSinhVienDangKy = soLuongSinhVienDangKy;
	 }
	 
	 

	 /*=================== OTHER METHODs  ===============================*/

	 public String getMaHocKyHeThong() {
		  return maHocKyHeThong;
	 }

	 public void setMaHocKyHeThong(String maHocKyHeThong) {
		  this.maHocKyHeThong = maHocKyHeThong;
	 }
}//class DangKyHocPhan
