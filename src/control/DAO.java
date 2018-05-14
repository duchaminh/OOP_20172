package control;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.*;


/*@author hai*/
/**
 * desciption:
 */
public class DAO {

	 /*=================== ATTRIBUTEs ==================================*/
    	 private Connection conn;//ket noi
	 /*=================== CONSTRUCTORs ================================*/
	 public DAO() {//ham khoi tao connector, giup ket noi JAVA - SQLServer
		  //moi lan khoi tao DAO (new DAO) -> 1 lan ket noi
		  try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/quanlisv1", "root","");
        }catch(ClassNotFoundException | SQLException e){
            System.out.print(e.getMessage());
        }
	 }

	 /*====================== GET DATAs ===========================================*/
	 public ArrayList<Admin> getListAdmin() {//doc cac ban ghi tu database, tra ve 1 ArrayList
		  ArrayList<Admin> listAdmin = new ArrayList<>();// ArrayList de luu cac doi tuong
		  String sql = "SELECT * FROM admin";//cau lenh truy van

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
		  } catch (Exception e) {
				e.printStackTrace();
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
					 HeThong.findNganhHoc(a.getMaNganhHoc()).getChuongTrinhHoc().add(a);

				}
		  } catch (Exception e) {
				e.printStackTrace();
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
					 HeThong.findChuongTrinhHoc(rs.getString("maChuongTrinhHoc")).getHocPhan()
								.add(HeThong.findHocPhan(rs.getString("maHocPhan")));
					 //add maChuongTrinhHoc vo hocPhan
					 HeThong.findHocPhan(rs.getString("maHocPhan")).getMaChuongTrinhHoc()
								.add(rs.getString("maChuongTrinhHoc"));
				}

		  } catch (Exception e) {

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

					 HeThong.findHocKyHeThong(a.getMaHocKyHeThong()).getDangKyHocPhan().add(a);
				}
		  } catch (Exception e) {
				e.printStackTrace();
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
		  } catch (Exception e) {
				e.printStackTrace();
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
					 HeThong.findSinhVien(a.getMssv()).getHocKySinhVien().add(a);
				}
		  } catch (Exception e) {
				e.printStackTrace();
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
					 HeThong.findHocKySinhVien(rs.getString("mssv"), rs.getString("maHocKyHeThong"))
								.getMaLopMoDangKy().add(rs.getString("maLopMo"));
					 //add sinhVien vo lopMo
					 HeThong.findLopMo(rs.getString("maLopMo")).getSinhVien()
								.add(HeThong.findSinhVien(rs.getString("mssv")));
				}

		  } catch (Exception e) {

		  }
	 }

	 public void hocKySinhVienBaoGomHocPhan() {
		  String sql = "SELECT * FROM hockysinhvien_baogom_hocphan";
		  try {
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();

				while (rs.next()) {//doc den het cac ban ghi cua bang
					 //add maHocPhan vo hocKySinhVien
					 HeThong.findHocKySinhVien(rs.getString("mssv"), rs.getString("maHocKyHeThong"))
								.getMaHocPhanDangKy().add(rs.getString("maHocPhan"));
					 // DangKYHocPhan ++
					 HeThong.findDangKyHocPhan(rs.getString("maHocPhan"), rs.getString("maHocKyHeThong"))
								.setSoLuongSinhVienDangKy((HeThong.findDangKyHocPhan(rs.getString("maHocPhan"), rs.getString("maHocKyHeThong"))).getSoLuongSinhVienDangKy() + 1);
				}

		  } catch (Exception e) {

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
				e.printStackTrace();
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
					 ((HocPhanTC) HeThong.findHocPhan(rs.getString("maHocPhanTC")))
								.getMaHocPhanTCDieuKien().add(rs.getString("maHocPhanTCDieuKien"));
				}

		  } catch (Exception e) {
				e.printStackTrace();
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

					 HeThong.findSinhVien(a.getMssv()).getBangDiem().add(a);
				}
		  } catch (Exception e) {
				e.printStackTrace();
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

					 HeThong.findHocKyHeThong(a.getMaHocKyHeThong()).getLopMo().add(a);
				}
		  } catch (Exception e) {
				e.printStackTrace();
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

					 HeThong.findChuongTrinhHoc(a.getMaChuongTrinhHoc()).getLopSinhVien().add(a);
				}
		  } catch (Exception e) {
				e.printStackTrace();
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
		  } catch (Exception e) {
				e.printStackTrace();
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

						  HeThong.findLopSinhVien(a.getMaLopSinhVien()).getSinhVien().add(a);
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
						  HeThong.findLopSinhVien(a.getMaLopSinhVien()).getSinhVien().add(a);

					 }

				}
		  } catch (Exception e) {
				e.printStackTrace();
		  }

		  return listSinhVien;//return ArrayList danhSachAdmin duoc doc tu database
	 }
         
        public void fillStudentJtable(JTable table, String valueToSearch){
            
            
       // int i = 0;
           // Connection conn = MyConnection.getConnection();
            PreparedStatement ps;
            try {
                ps = conn.prepareStatement("select *from sinhvien where concat(hoTen,mssv,username) like ?");
                ps.setString(1,"%"+valueToSearch+"%");

                ResultSet rs = ps.executeQuery();
                DefaultTableModel model =(DefaultTableModel)table.getModel();
                Object[] row;

                while(rs.next()){
                    row = new Object[9];
                    //row[0] = rs.getInt(1);
                    row[0] = rs.getString(1);
                    row[1] = rs.getString(2);
                    row[2] = rs.getString(3);
                    row[3] = rs.getString(4);
                    row[4] = rs.getString(6);
                    row[5] = rs.getString(7);
                    row[6] = rs.getString(8);
                    row[7] = rs.getString(9);
                    row[8] = rs.getString(10);
                    //row[9] = rs.getString(11);
                    model.addRow(row);
                }

                } 
            catch (SQLException ex) {
                Logger.getLogger(SinhVien.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
        
           public void fillCourseJtable(JTable table, String valueToSearch){
       // int i = 0;
           // Connection conn = MyConnection.getConnection();
            PreparedStatement ps;
            try {
                ps = conn.prepareStatement("select *from hocphan where concat(maHocPhan,tenHocPhan,heHocPhan) like ?");
                ps.setString(1,"%"+valueToSearch+"%");

                ResultSet rs = ps.executeQuery();
                DefaultTableModel model =(DefaultTableModel)table.getModel();
                Object[] row;

                while(rs.next()){
                    row = new Object[6];
                    row[0] = rs.getString(1);
                    row[1] = rs.getString(2);
                    row[2] = rs.getString(3);
                    row[3] = rs.getString(4);
                    row[4] = rs.getString(5);
                    row[5] = rs.getString(6);
                    model.addRow(row);
                }

                } 
            catch (SQLException ex) {
                Logger.getLogger(SinhVien.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
        
        public boolean insertDeleteUpdateStudent(char operation,Integer id, String heSinhVien, String mssv, String hoTen, String username, String password, String maNganhHoc , String maChuongTrinhHoc,String maLopSinhVien, String trangThaiHocTap, String hocki  ){
           // Connection conn = MyConnection.getConnection();
            PreparedStatement ps;
            
            if(operation == 'i'){
                try {
                    ps =  conn.prepareStatement("insert into sinhvien(heSinhVien,mssv,hoTen,username, password, maNganhHoc, maChuongTrinhHoc,maLopSinhVien,trangThai,bangTotNghiep) values(?,?,?,?,?,?,?,?,?,?)");
                    ps.setString(1, heSinhVien);
                    ps.setString(2, mssv);
                    ps.setString(3, hoTen);
                    ps.setString(4, username);
                    ps.setString(5, password);
                    ps.setString(6, maNganhHoc);
                    ps.setString(7, maChuongTrinhHoc);
                    ps.setString(8, maLopSinhVien);
                    ps.setString(9,trangThaiHocTap );
                    ps.setString(10,hocki);
                    
                    if(ps.executeUpdate() > 0){
                        JOptionPane.showMessageDialog(null,"new student added"); 
                        return true;
                       // this.insertHocKySinhVien(mssv, hocki);
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Can't insert student");  
                        return false;
                    }
                    
                } catch (SQLException ex) {
                    Logger.getLogger(SinhVien.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }   
            if(operation == 'u'){
                try {
                    ps =  conn.prepareStatement("update sinhvien set heSinhVien=?,hoTen=?,username=?, password=?, maNganhHoc=?, maChuongTrinhHoc=?,maLopSinhVien=?,trangThai=?,bangTotNghiep=? where mssv = ?");
                    ps.setString(1, heSinhVien);
                    //ps.setString(2, mssv);
                    ps.setString(2, hoTen);
                    ps.setString(3, username);
                    ps.setString(4, password);
                    ps.setString(5, maNganhHoc);
                    ps.setString(6, maChuongTrinhHoc);
                    ps.setString(7, maLopSinhVien);
                    ps.setString(8,trangThaiHocTap );
                    ps.setString(9,hocki);
                    ps.setString(10,mssv);
                    if(ps.executeUpdate() > 0){
                        JOptionPane.showMessageDialog(null,"data student updated");  
                        return true;
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Can't update student");  
                        return false;
                    }
                    
                } catch (SQLException ex) {
                    Logger.getLogger(SinhVien.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            } 
            if(operation == 'd'){
                try {
                    ps =  conn.prepareStatement("delete from sinhvien where mssv = ?");
                    ps.setString(1, mssv);
                    if(ps.executeUpdate() > 0){
                        JOptionPane.showMessageDialog(null,"data student deleted");  
                        return true;
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Can't delete student");  
                        return false;
                    }
                    
                } catch (SQLException ex) {
                    Logger.getLogger(SinhVien.class.getName()).log(Level.SEVERE, null, ex);
                }
               
            } 
            return true;
    }
        public void insertHocKySinhVien(String mssv,String maHocKyHeThong){
            PreparedStatement ps;
             try {
                 ps=conn.prepareStatement("insert into hockysinhvien(mssv,maHocKyHeThong) values(?,?)");
                 ps.setString(1, mssv);
                 ps.setString(2, maHocKyHeThong);
                 ps.executeUpdate();
                         } 
             catch (SQLException ex) {
                 Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
             }
            
            
        }
        public void insertDeleteUpdateCourse(char operation, String maHocPhan, String tenHocPhan, Float trongSoGiuaKy, Float trongSoCuoiKy, String heHocPhan, String sttHocKy){
            PreparedStatement ps;
            if(operation == 'i'){
                try {
                    ps =  conn.prepareStatement("insert into hocphan(maHocPhan,tenHocPhan,trongSoGiuaKy,trongSoCuoiKy,heHocPhan,sttHocKy) values(?,?,?,?,?,?)");
                    ps.setString(1, maHocPhan);
                    ps.setString(2, tenHocPhan);
                    ps.setFloat(3, trongSoGiuaKy);
                    ps.setFloat(4, trongSoCuoiKy);
                    ps.setString(5,heHocPhan);
                    ps.setString(6, sttHocKy);
                    
                    
                    if(ps.executeUpdate() > 0){
                        JOptionPane.showMessageDialog(null,"new course added");  
                        //this.insertHocKySinhVien(mssv, );
                    }
                    else
                        JOptionPane.showMessageDialog(null,"Can't insert course");  
                    
                } catch (SQLException ex) {
                    Logger.getLogger(HocPhan.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }   
            if(operation == 'u'){
                try {
                    ps =  conn.prepareStatement("update hocphan set tenHocPhan=?,trongSoGiuaKy=?, trongSoCuoiKy=?, heHocPhan=?, sttHocKy=? where maHocPhan = ?");
                    ps.setString(6, maHocPhan);
                    ps.setString(1, tenHocPhan);
                    ps.setFloat(2, trongSoGiuaKy);
                    ps.setFloat(3, trongSoCuoiKy);
                    ps.setString(4,heHocPhan);
                    ps.setString(5, sttHocKy);
                    if(ps.executeUpdate() > 0){
                        JOptionPane.showMessageDialog(null,"data course updated");  
                    }
                    else
                        JOptionPane.showMessageDialog(null,"Can't update course");  
                    
                } catch (SQLException ex) {
                    Logger.getLogger(HocPhan.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            } 
            if(operation == 'd'){
                try {
                    ps =  conn.prepareStatement("delete from hocphan where maHocPhan = ?");
                    ps.setString(1, maHocPhan);
                    if(ps.executeUpdate() > 0){
                        JOptionPane.showMessageDialog(null,"data course deleted");  
                    }
                    else
                        JOptionPane.showMessageDialog(null,"Can't delete student");  
                    
                } catch (SQLException ex) {
                    Logger.getLogger(HocPhan.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            } 
    }
        
        public boolean isCourseExist(String maHocPhan){
            boolean isExist = false;
            PreparedStatement ps;
            String sql = "select * from hocphan where maHocPhan like ? ";
             try {
                 ps = conn.prepareStatement(sql);
                 ps.setString(1,maHocPhan);
                 ResultSet rs = ps.executeQuery();
                 
                 if(rs.next()){
                     isExist =  true;
                 }
                 
             } catch (SQLException ex) {
                 Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
             }
             return isExist;
        }
    
    
            

	 /*====================== UPDATE DATAs ===========================================*/
 /*====================== ADD DATAs ===========================================*/

 /*================== MAIN ==========================================*/
	 public static void main(String[] args) {
		  new DAO();

	 }

    public void updateSiSoLopSinhVien(String maLopSinhVien, int size) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       PreparedStatement ps;
             try {
                 ps = conn.prepareStatement("update lopsinhvien set siSo=? where maLopSinhVien=?");
                 ps.setString(1,String.valueOf(size+1));
                 ps.setString(2, maLopSinhVien);
                 ps.executeUpdate();
             } catch (SQLException ex) {
                 Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
             }
    }
}//class DAO
