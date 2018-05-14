package control;

import java.sql.*;
import java.util.ArrayList;
import model.*;
import view.*;


/*@author hai*/
/**
 * desciption:dung cho HeThongView,
 * DAOView + HeThongView giong nhu DAO + HeThong,
 * nhung co them chuc nang hien thi ra cac Frame/table de tien check xem import databse -> hethong chinh xac chua
 */
public class DAOView {//

	 /*=================== ATTRIBUTEs ==================================*/
	 private Connection conn;//ket noi

	 /*=================== CONSTRUCTORs ================================*/
	 public DAOView() {//ham khoi tao connector, giup ket noi JAVA - SQLServer
		  //moi lan khoi tao DAOView (new DAOView) -> 1 lan ket noi
		  try {
				Class.forName("com.mysql.cj.jdbc.Driver");
                                conn = DriverManager.getConnection("jdbc:mysql://localhost/quanlisv1", "root","");
                               // con = DriverManager.getConnection("jdbc:mysql://localhost/quanlisv1", "root","");
				System.out.println("Ket noi toi MySQL thanh cong!!");
		  } catch (ClassNotFoundException | SQLException e) {
		  }
	 }

	 /*====================== GET DATAs ===========================================*/
	 public ArrayList<Admin> getListAdmin() {//doc cac ban ghi tu database, tra ve 1 ArrayList
		  ArrayList<Admin> listAdmin = new ArrayList<>();// ArrayList de luu cac doi tuong
		  String sql = "SELECT * FROM admin";//cau lenh truy van
                  
                  try {
				Class.forName("com.mysql.cj.jdbc.Driver");
                                conn = DriverManager.getConnection("jdbc:mysql://localhost/quanlisv1", "root","");
                               // con = DriverManager.getConnection("jdbc:mysql://localhost/quanlisv1", "root","");
				System.out.println("Ket noi toi MySQL thanh cong!!");
		  } catch (ClassNotFoundException | SQLException e) {
		  }
                  
		  try {
				PreparedStatement ps = conn.prepareStatement(sql);//thuc thi cau lenh truy van
				ResultSet rs = ps.executeQuery();//rs luu cac gia tri duoc query ve tu database
				//neu chi truy van - query - thi dung rs.executeQuery

				while (rs.next()) {//doc den het cac ban ghi o bang
					 Admin a = new Admin();
					 a.setAdminID(rs.getString("adminID"));
					 a.setHoTen(rs.getString("hoTen"));
					 a.setUsername(rs.getString("username"));
					 a.setPassword(rs.getString("password"));

					 listAdmin.add(a);//them a vo danhSachAdmin
				}
		  } catch (SQLException e) {
		  }

		  return listAdmin;//return ArrayList danhSachAdmin duoc doc tu database
	 }

	 public ArrayList<ChuongTrinhHoc> getListChuongTrinhHoc() {//doc cac ban ghi tu database, tra ve 1 ArrayList
		  ArrayList<ChuongTrinhHoc> listChuongTrinhHoc = new ArrayList<>();// ArrayList de luu cac doi tuong
		  String sql = "SELECT * FROM chuongtrinhhoc";//cau lenh truy van

		  try {
				PreparedStatement ps = conn.prepareStatement(sql);//thuc thi cau lenh truy van
				ResultSet rs = ps.executeQuery();//rs luu cac gia tri duoc query ve tu database
				//neu chi truy van - query - thi dung rs.executeQuery

				while (rs.next()) {//doc den het cac ban ghi o bang
					 ChuongTrinhHoc a = new ChuongTrinhHoc();

					 a.setMaChuongTrinhHoc(rs.getString("maChuongTrinhHoc"));
					 a.setTenChuongTrinhHoc(rs.getString("tenChuongTrinhHoc"));
					 a.setMaNganhHoc(rs.getString("maNganhHoc"));

					 listChuongTrinhHoc.add(a);//them a vo list

					 //add chuongTrinhHoc a vo list chuongTrinhHoc cua nganh tuong ung
					 HeThongView.findNganhHoc(a.getMaNganhHoc()).getChuongTrinhHoc().add(a);

				}
		  } catch (SQLException e) {
		  }

		  return listChuongTrinhHoc;//return ArrayList danhSachAdmin duoc doc tu database
	 }

	 public void chuongTrinhHocBaoGomHocPhan() {
		  String sql = "SELECT * FROM chuongtrinhhoc_baogom_hocphan";
		  try {
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();

				while (rs.next()) {//doc den het cac ban ghi cua bang
					 //add hocPhan vo chuongTrinhHoc
					 HeThongView.findChuongTrinhHoc(rs.getString("maChuongTrinhHoc")).getHocPhan()
								.add(HeThongView.findHocPhan(rs.getString("maHocPhan")));
					 //add maChuongTrinhHoc vo hocPhan
					 HeThongView.findHocPhan(rs.getString("maHocPhan")).getMaChuongTrinhHoc()
								.add(rs.getString("maChuongTrinhHoc"));
				}

		  } catch (SQLException e) {

		  }
	 }

	 public ArrayList<DangKyHocPhan> getListDangKyHocPhan() {//doc cac ban ghi tu database, tra ve 1 ArrayList
		  ArrayList<DangKyHocPhan> listDangKyHocPhan = new ArrayList<>();// ArrayList de luu cac doi tuong
		  String sql = "SELECT * FROM dangkyhocphan";//cau lenh truy van

		  try {
				PreparedStatement ps = conn.prepareStatement(sql);//thuc thi cau lenh truy van
				ResultSet rs = ps.executeQuery();//rs luu cac gia tri duoc query ve tu database
				//neu chi truy van - query - thi dung rs.executeQuery

				while (rs.next()) {//doc den het cac ban ghi o bang
					 DangKyHocPhan a = new DangKyHocPhan();

					 a.setMaHocPhan(rs.getString("maHocPhan"));
					 a.setMaHocKyHeThong(rs.getString("maHocKyHeThong"));

					 listDangKyHocPhan.add(a);//them a vo danhSachAdmin

					 HeThongView.findHocKyHeThong(a.getMaHocKyHeThong()).getDangKyHocPhan().add(a);
				}
		  } catch (SQLException e) {
		  }

		  return listDangKyHocPhan;//return ArrayList danhSachAdmin duoc doc tu database
	 }

	 public ArrayList<HocKyHeThong> getListHocKyHeThong() {//doc cac ban ghi tu database, tra ve 1 ArrayList
		  ArrayList<HocKyHeThong> listHocKyHeThong = new ArrayList<>();// ArrayList de luu cac doi tuong
		  String sql = "SELECT * FROM hockyhethong";//cau lenh truy van

		  try {
				PreparedStatement ps = conn.prepareStatement(sql);//thuc thi cau lenh truy van
				ResultSet rs = ps.executeQuery();//rs luu cac gia tri duoc query ve tu database
				//neu chi truy van - query - thi dung rs.executeQuery

				while (rs.next()) {//doc den het cac ban ghi o bang
					 HocKyHeThong a = new HocKyHeThong();
					 a.setMaHocKyHeThong(rs.getString("maHocKyHeThong"));
					 a.setBatDauDangKyHocPhan(rs.getDate("batDauDangKyHocPhan"));
					 a.setBatDauDangKyLopMo(rs.getDate("batDauDangKyLopMo"));
					 a.setBatDauHocKy(rs.getDate("batDauHocKy"));
					 a.setKetThucHocKy(rs.getDate("ketThucHocKy"));

					 listHocKyHeThong.add(a);//them a vo danhSachAdmin
				}
		  } catch (SQLException e) {
		  }

		  return listHocKyHeThong;//return ArrayList danhSachAdmin duoc doc tu database
	 }

	 public ArrayList<HocKySinhVien> getListHocKySinhVien() {//doc cac ban ghi tu database, tra ve 1 ArrayList
		  ArrayList<HocKySinhVien> listHocKySinhVien = new ArrayList<>();// ArrayList de luu cac doi tuong
		  String sql = "SELECT * FROM hockysinhvien";//cau lenh truy van

		  try {
				PreparedStatement ps = conn.prepareStatement(sql);//thuc thi cau lenh truy van
				ResultSet rs = ps.executeQuery();//rs luu cac gia tri duoc query ve tu database
				//neu chi truy van - query - thi dung rs.executeQuery

				while (rs.next()) {//doc den het cac ban ghi o bang
					 HocKySinhVien a = new HocKySinhVien();

					 a.setMaHocKyHeThong(rs.getString("maHocKyHeThong"));
					 a.setMssv(rs.getString("mssv"));

					 listHocKySinhVien.add(a);//them a vo danhSachAdmin
					 HeThongView.findSinhVien(a.getMssv()).getHocKySinhVien().add(a);
				}
		  } catch (SQLException e) {
		  }

		  return listHocKySinhVien;//return ArrayList danhSachAdmin duoc doc tu database
	 }

	 public void hocKySinhVienBaoGomLopMo() {
		  String sql = "SELECT * FROM hockysinhvien_baogom_lopmo";
		  try {
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();

				while (rs.next()) {//doc den het cac ban ghi cua bang
					 //add maLopMo vo hocKySinhVien
					 HeThongView.findHocKySinhVien(rs.getString("mssv"), rs.getString("maHocKyHeThong"))
								.getMaLopMoDangKy().add(rs.getString("maLopMo"));
					 //add sinhVien vo lopMo
					 HeThongView.findLopMo(rs.getString("maLopMo")).getSinhVien()
								.add(HeThongView.findSinhVien(rs.getString("mssv")));
				}

		  } catch (SQLException e) {

		  }
	 }

	 public void hocKySinhVienBaoGomHocPhan() {
		  String sql = "SELECT * FROM hockysinhvien_baogom_hocphan";
		  try {
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();

				while (rs.next()) {//doc den het cac ban ghi cua bang
					 //add maHocPhan vo hocKySinhVien
					 HeThongView.findHocKySinhVien(rs.getString("mssv"), rs.getString("maHocKyHeThong"))
								.getMaHocPhanDangKy().add(rs.getString("maHocPhan"));
					 // DangKYHocPhan ++
					 HeThongView.findDangKyHocPhan(rs.getString("maHocPhan"), rs.getString("maHocKyHeThong"))
								.setSoLuongSinhVienDangKy((HeThongView.findDangKyHocPhan(rs.getString("maHocPhan"), rs.getString("maHocKyHeThong"))).getSoLuongSinhVienDangKy() + 1);
				}

		  } catch (SQLException e) {

		  }
	 }

	 public ArrayList<HocPhan> getListHocPhan() {//doc cac ban ghi tu database, tra ve 1 ArrayList
		  ArrayList<HocPhan> listHocPhan = new ArrayList<>();// ArrayList de luu cac doi tuong
		  String sql = "SELECT * FROM hocphan";//cau lenh truy van

		  try {
				PreparedStatement ps = conn.prepareStatement(sql);//thuc thi cau lenh truy van
				ResultSet rs = ps.executeQuery();//rs luu cac gia tri duoc query ve tu database
				//neu chi truy van - query - thi dung rs.executeQuery

				while (rs.next()) {//doc den het cac ban ghi o bang
					 if (rs.getString("heHocPhan").equals("TC")) {//neu la hoc phan TC
						  HocPhanTC a = new HocPhanTC();

						  a.setMaHocPhan(rs.getString("maHocPhan"));
						  a.setTenHocPhan(rs.getString("tenHocPhan"));
						  a.setTrongSoGiuaKy(rs.getFloat("trongSoGiuaKy"));
						  a.setTrongSoCuoiKy(rs.getFloat("trongSoCuoiKy"));

						  listHocPhan.add(((HocPhan) a));//them a vo list

					 } else {//neu rs la hoc phan nc
						  HocPhanNC a = new HocPhanNC();

						  a.setMaHocPhan(rs.getString("maHocPhan"));
						  a.setTenHocPhan(rs.getString("tenHocPhan"));
						  a.setTrongSoGiuaKy(rs.getFloat("trongSoGiuaKy"));
						  a.setTrongSoCuoiKy(rs.getFloat("trongSoCuoiKy"));
						  a.setSttHocKy(rs.getInt("sttHocKy"));

						  listHocPhan.add((HocPhan) a);//them a vo list
					 }

				}
		  } catch (SQLException e) {
		  }

		  return listHocPhan;//return ArrayList danhSachAdmin duoc doc tu database
	 }

	 public void hocPhanTCLaDieuKienHocPhanTC() {//khoi tao list hocPhanDieuKien cho HocPhanTC
		  String sql = "SELECT * FROM hocphantc_ladieukien_hocphantc";

		  try {
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();

				while (rs.next()) {//doc den het cac ban ghi cua bang
					 //tim hocPhanTC chua hocPhanTCDieuKien
					 //bang hocPhanTClaDieuKienHocPhanTC chi chua cac key cua hocPhanTC
					 ((HocPhanTC) HeThongView.findHocPhan(rs.getString("maHocPhanTC")))
								.getMaHocPhanTCDieuKien().add(rs.getString("maHocPhanTCDieuKien"));
				}

		  } catch (SQLException e) {
		  }
	 }

	 public ArrayList<KetQuaHocPhan> getListKetQuaHocPhan() {//doc cac ban ghi tu database, tra ve 1 ArrayList
		  ArrayList<KetQuaHocPhan> listKetQuaHocPhan = new ArrayList<>();// ArrayList de luu cac doi tuong
		  String sql = "SELECT * FROM ketquahocphan";//cau lenh truy van

		  try {
				PreparedStatement ps = conn.prepareStatement(sql);//thuc thi cau lenh truy van
				ResultSet rs = ps.executeQuery();//rs luu cac gia tri duoc query ve tu database
				//neu chi truy van - query - thi dung rs.executeQuery

				while (rs.next()) {//doc den het cac ban ghi o bang
					 KetQuaHocPhan a = new KetQuaHocPhan();

					 a.setMssv(rs.getString("mssv"));
					 a.setMaHocPhan(rs.getString("maHocPhan"));
					 a.setMaHocKyHeThong(rs.getString("maHocKyHeThong"));
					 a.setDiemGiuaKy(rs.getFloat("diemGiuaKy"));
					 a.setDiemCuoiKy(rs.getFloat("diemCuoiKy"));
					 a.setDiemHocPhan(rs.getFloat("diemHocPhan"));
					 a.setKetQua(rs.getString("ketQua"));

					 listKetQuaHocPhan.add(a);//them a vo danhSachAdmin

					 HeThongView.findSinhVien(a.getMssv()).getBangDiem().add(a);
				}
		  } catch (SQLException e) {
		  }

		  return listKetQuaHocPhan;//return ArrayList danhSachAdmin duoc doc tu database
	 }

	 public ArrayList<LopMo> getListLopMo() {//doc cac ban ghi tu database, tra ve 1 ArrayList
		  ArrayList<LopMo> listLopMo = new ArrayList<>();// ArrayList de luu cac doi tuong
		  String sql = "SELECT * FROM lopmo";//cau lenh truy van

		  try {
				PreparedStatement ps = conn.prepareStatement(sql);//thuc thi cau lenh truy van
				ResultSet rs = ps.executeQuery();//rs luu cac gia tri duoc query ve tu database
				//neu chi truy van - query - thi dung rs.executeQuery

				while (rs.next()) {//doc den het cac ban ghi o bang
					 LopMo a = new LopMo();

					 a.setMaLopMo(rs.getString("maLopMo"));
					 a.setMaHocPhan(rs.getString("maHocPhan"));
					 a.setMaHocKyHeThong(rs.getString("maHocKyHeThong"));
					 a.setSoLuongSinhVienToiDa(rs.getInt("soLuongSinhVienToiDa"));

					 listLopMo.add(a);//them a vo danhSachAdmin

					 HeThongView.findHocKyHeThong(a.getMaHocKyHeThong()).getLopMo().add(a);
				}
		  } catch (SQLException e) {
		  }

		  return listLopMo;//return ArrayList danhSachAdmin duoc doc tu database
	 }

	 public ArrayList<LopSinhVien> getListLopSinhVien() {//doc cac ban ghi tu database, tra ve 1 ArrayList
		  ArrayList<LopSinhVien> listLopSinhVien = new ArrayList<>();// ArrayList de luu cac doi tuong
		  String sql = "SELECT * FROM lopsinhvien";//cau lenh truy van

		  try {
				PreparedStatement ps = conn.prepareStatement(sql);//thuc thi cau lenh truy van
				ResultSet rs = ps.executeQuery();//rs luu cac gia tri duoc query ve tu database
				//neu chi truy van - query - thi dung rs.executeQuery

				while (rs.next()) {//doc den het cac ban ghi o bang
					 LopSinhVien a = new LopSinhVien();

					 a.setMaLopSinhVien(rs.getString("maLopSinhVien"));
					 a.setMaChuongTrinhHoc(rs.getString("maChuongTrinhHoc"));
					 a.setNamNhapHoc(rs.getInt("namNhapHoc"));

					 listLopSinhVien.add(a);//them a vo danhSachAdmin

					 HeThongView.findChuongTrinhHoc(a.getMaChuongTrinhHoc()).getLopSinhVien().add(a);
				}
		  } catch (SQLException e) {
		  }

		  return listLopSinhVien;//return ArrayList danhSachAdmin duoc doc tu database
	 }

	 public ArrayList<NganhHoc> getListNganhHoc() {//doc cac ban ghi tu database, tra ve 1 ArrayList
		  ArrayList<NganhHoc> listNganhHoc = new ArrayList<>();// ArrayList de luu cac doi tuong
		  String sql = "SELECT * FROM nganhhoc";//cau lenh truy van

		  try {
				PreparedStatement ps = conn.prepareStatement(sql);//thuc thi cau lenh truy van
				ResultSet rs = ps.executeQuery();//rs luu cac gia tri duoc query ve tu database
				//neu chi truy van - query - thi dung rs.executeQuery

				while (rs.next()) {//doc den het cac ban ghi o bang
					 NganhHoc a = new NganhHoc();

					 a.setMaNganhHoc(rs.getString("maNganhHoc"));
					 a.setTenNganhHoc(rs.getString("tenNganhHoc"));

					 listNganhHoc.add(a);//them a vo danhSachAdmin
				}
		  } catch (SQLException e) {
		  }

		  return listNganhHoc;//return ArrayList danhSachAdmin duoc doc tu database
	 }

	 public ArrayList<SinhVien> getListSinhVien() {//doc cac ban ghi tu database, tra ve 1 ArrayList
		  ArrayList<SinhVien> listSinhVien = new ArrayList<>();// ArrayList de luu cac doi tuong
		  String sql = "SELECT * FROM sinhvien";//cau lenh truy van

		  try {
				PreparedStatement ps = conn.prepareStatement(sql);//thuc thi cau lenh truy van
				ResultSet rs = ps.executeQuery();//rs luu cac gia tri duoc query ve tu database
				//neu chi truy van - query - thi dung rs.executeQuery

				while (rs.next()) {//doc den het cac ban ghi o bang
					 if (rs.getString("heSinhvien").equals("TC")) {
						  SinhVienTC a = new SinhVienTC();

						  a.setMssv(rs.getString("mssv"));
						  a.setHoTen(rs.getString("hoTen"));
						  a.setUsername(rs.getString("username"));
						  a.setPassword(rs.getString("password"));
						  a.setTrangThai(rs.getString("trangThai"));
						  a.setBangTotNghiep(rs.getString("bangTotNghiep"));
						  a.setMaLopSinhVien(rs.getString("maLopSinhVien"));
						  a.setMaChuongTrinhHoc(rs.getString("maChuongTrinhHoc"));
						  a.setMaNganhHoc(rs.getString("maNganhHoc"));

						  listSinhVien.add(a);//them a vo danhSachAdmin

						  HeThongView.findLopSinhVien(a.getMaLopSinhVien()).getSinhVien().add(a);
					 } else {
						  SinhVienNC a = new SinhVienNC();

						  a.setMssv(rs.getString("mssv"));
						  a.setHoTen(rs.getString("hoTen"));
						  a.setUsername(rs.getString("username"));
						  a.setPassword(rs.getString("password"));
						  a.setTrangThai(rs.getString("trangThai"));
						  a.setBangTotNghiep(rs.getString("bangTotNghiep"));
						  a.setMaLopSinhVien(rs.getString("maLopSinhVien"));
						  a.setMaChuongTrinhHoc(rs.getString("maChuongTrinhHoc"));
						  a.setMaNganhHoc(rs.getString("maNganhHoc"));

						  listSinhVien.add(a);//them a vo list
						  HeThongView.findLopSinhVien(a.getMaLopSinhVien()).getSinhVien().add(a);

					 }

				}
		  } catch (SQLException e) {
		  }

		  return listSinhVien;//return ArrayList danhSachAdmin duoc doc tu database
	 }

	 /*====================== UPDATE DATAs ===========================================*/
 /*====================== ADD DATAs ===========================================*/

 /*================== MAIN ==========================================*/
	 public static void main(String[] args) {
             DAOView daoView = new DAOView();

	 }
}//class DAOView
