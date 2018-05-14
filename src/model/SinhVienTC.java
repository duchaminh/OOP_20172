package model;

import java.util.ArrayList;

/*@author hai*/
/**
 * desciption:
 */
public class SinhVienTC extends SinhVien {

	 public SinhVienTC() {
	 }

	 public SinhVienTC(String mssv, String hoTen, String username, String password, String trangThai, String bangTotNghiep, String maLopSinhVien, String maLopChuongTrinhHoc, String maLopNganhHoc, ArrayList<KetQuaHocPhan> bangDiem, ArrayList<HocKySinhVien> hocKySinhVien) {
		  super(mssv, hoTen, username, password, trangThai, bangTotNghiep, maLopSinhVien, maLopChuongTrinhHoc, maLopNganhHoc, bangDiem, hocKySinhVien);
	 }


	 /*=================== ATTRIBUTEs ==================================*/

 /*=================== CONSTRUCTORs ================================*/


	 /*=================== GETTTERs & SETTERs  ============================*/

 /*=================== OTHER METHODs  ===============================*/
}//class SinhVienTC
