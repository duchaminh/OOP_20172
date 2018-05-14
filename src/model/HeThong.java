package model;

import control.DAO;
import java.util.ArrayList;
import view.AdminView;
import view.LoginView;
import view.SinhVienNCView;
import view.SinhVienTCView;

/**
 *
 * @author hai
 */
public final class HeThong {// HeThong quản lý sinh viên (giống như hệ thống của 1 trường đại học ngoài đời thật)

	 /**
	  * CÁC THUỘC TÍNH + PHƯƠNG THỨC LÀ STATIC BỞI: khi khởi tạo 1 đối tượng của
	  * hệ thống, cần thông qua 1 đối tượng của class DAO để kết nối, thêm, sửa,
	  * xóa CSDL -> cần gọi các hàm của hethong thông qua tên class (vì DAO không
	  * thể sử dụng các hàm của HeThong thông qua đối tượng)
	  */
	 //list cac class chua du lieu cua hethong
	 private static ArrayList<Admin> listAdmin;//done
	 private static ArrayList<ChuongTrinhHoc> listChuongTrinhHoc;
	 private static ArrayList<DangKyHocPhan> listDangKyHocPhan;
	 private static ArrayList<HocKyHeThong> listHocKyHeThong;
	 private static ArrayList<HocKySinhVien> listHocKySinhVien;
	 private static ArrayList<HocPhan> listHocPhan;
	 private static ArrayList<KetQuaHocPhan> listKetQuaHocPhan;
	 private static ArrayList<LopMo> listLopMo;
	 private static ArrayList<LopSinhVien> listLopSinhVien;
	 private static ArrayList<NganhHoc> listNganhHoc;
	 private static ArrayList<SinhVien> listSinhVien;

	 //cac view cua he thong (giao dien de tuong tac voi user)
	 private static LoginView loginView;
	 private static AdminView adminView;
	 private static SinhVienTCView sinhVienTCView;
	 private static SinhVienNCView sinhVienNCView;


	 /*====================== CONSTRUCTORs ========================*/
	 public HeThong() {
		  DAO dao = new DAO();//ket noi voi CSDL

		  /**
		   * ======================= import databse: nhờ dao + database khởi tạo
		   * các đối tượng cho hệ thống================= CÁCH IMPORT DATABASE ->
		   * CÁC ĐỐI TƯỢNG CỦA HỆ THỐNG 1/ Đọc từ database, lưu vô đối tượng toàn
		   * bộ các cột, mà, cột đó ứng với dữ liệu không phải là kết tập của đối
		   * tượng 2/ Nếu đối tượng đang đọc là 1 thuộc tính kết tập của đối tượng
		   * khác -> tìm đối tượng đó, add đối tượng đang đọc vào đối tướng kết
		   * tập đó 3/ Đối với sự kết tập lẫn nhau (mối quan hệ n-n), đọc các bảng
		   * của liên kết n-n -> thêm lẫn nhau vô thuộc tính kết tập của 2 đối kết
		   * tập lẫn nhau đó
		   */
		  /**
		   * THỨ TỰ ĐỌC DỮ LIỆU, KHỞI TẠO ĐỐI TƯỢNG: 1/ Đọc các đối tượng kết tập
		   * to nhất (các đối tượng mà nó kết tập đối tượng khác) 2/ Đọc các mức
		   * nhỏ hơn
		   */
		  // thu tu khoi tao doi tuong
		  listAdmin = dao.getListAdmin();

		  listHocKyHeThong = dao.getListHocKyHeThong();
		  listLopMo = dao.getListLopMo();
		  listDangKyHocPhan = dao.getListDangKyHocPhan();

		  listNganhHoc = dao.getListNganhHoc();
		  listChuongTrinhHoc = dao.getListChuongTrinhHoc();
		  listLopSinhVien = dao.getListLopSinhVien();
		  listHocPhan = dao.getListHocPhan();

		  listSinhVien = dao.getListSinhVien();
		  listHocKySinhVien = dao.getListHocKySinhVien();
		  listKetQuaHocPhan = dao.getListKetQuaHocPhan();

		  //cap nhat du lieu tu cac bang lien ket n-n
		  dao.hocPhanTCLaDieuKienHocPhanTC();
		  dao.hocKySinhVienBaoGomLopMo();
		  dao.hocKySinhVienBaoGomHocPhan();
		  dao.chuongTrinhHocBaoGomHocPhan();

		  //khoi tao loginView dau tien, cac userView khoi tao sau khi dang nhap
		  this.initLoginSession();
	 }

	 /*========================= GETTERs SETTERs : static -> co the goi tu class khac  ==============================================*/
	 public static ArrayList<Admin> getListAdmin() {
		  return listAdmin;
	 }

	 public static void setListAdmin(ArrayList<Admin> listAdmin) {
		  HeThong.listAdmin = listAdmin;
	 }

	 public static ArrayList<ChuongTrinhHoc> getListChuongTrinhHoc() {
		  return listChuongTrinhHoc;
	 }

	 public static void setListChuongTrinhHoc(ArrayList<ChuongTrinhHoc> listChuongTrinhHoc) {
		  HeThong.listChuongTrinhHoc = listChuongTrinhHoc;
	 }

	 public static ArrayList<DangKyHocPhan> getListDangKyHocPhan() {
		  return listDangKyHocPhan;
	 }

	 public static void setListDangKyHocPhan(ArrayList<DangKyHocPhan> listDangKyHocPhan) {
		  HeThong.listDangKyHocPhan = listDangKyHocPhan;
	 }

	 public static ArrayList<HocKyHeThong> getListHocKyHeThong() {
		  return listHocKyHeThong;
	 }

	 public static void setListHocKyHeThong(ArrayList<HocKyHeThong> listHocKyHeThong) {
		  HeThong.listHocKyHeThong = listHocKyHeThong;
	 }

	 public static ArrayList<HocKySinhVien> getListHocKySinhVien() {
		  return listHocKySinhVien;
	 }

	 public static void setListHocKySinhVien(ArrayList<HocKySinhVien> listHocKySinhVien) {
		  HeThong.listHocKySinhVien = listHocKySinhVien;
	 }

	 public static ArrayList<HocPhan> getListHocPhan() {
		  return listHocPhan;
	 }

	 public static void setListHocPhan(ArrayList<HocPhan> listHocPhan) {
		  HeThong.listHocPhan = listHocPhan;
	 }

	 public static ArrayList<KetQuaHocPhan> getListKetQuaHocPhan() {
		  return listKetQuaHocPhan;
	 }

	 public static void setListKetQuaHocPhan(ArrayList<KetQuaHocPhan> listKetQuaHocPhan) {
		  HeThong.listKetQuaHocPhan = listKetQuaHocPhan;
	 }

	 public static ArrayList<LopMo> getListLopMo() {
		  return listLopMo;
	 }

	 public static void setListLopMo(ArrayList<LopMo> listLopMo) {
		  HeThong.listLopMo = listLopMo;
	 }

	 public static ArrayList<LopSinhVien> getListLopSinhVien() {
		  return listLopSinhVien;
	 }

	 public static void setListLopSinhVien(ArrayList<LopSinhVien> listLopSinhVien) {
		  HeThong.listLopSinhVien = listLopSinhVien;
	 }

	 public static ArrayList<NganhHoc> getListNganhHoc() {
		  return listNganhHoc;
	 }

	 public static void setListNganhHoc(ArrayList<NganhHoc> listNganhHoc) {
		  HeThong.listNganhHoc = listNganhHoc;
	 }

	 public static ArrayList<SinhVien> getListSinhVien() {
		  return listSinhVien;
	 }

	 public static void setListSinhVien(ArrayList<SinhVien> listSinhVien) {
		  HeThong.listSinhVien = listSinhVien;
	 }

	 public static LoginView getLoginView() {
		  return loginView;
	 }

	 public static void setLoginView(LoginView loginView) {
		  HeThong.loginView = loginView;
	 }

	 public static AdminView getAdminView() {
		  return adminView;
	 }

	 public static void setAdminView(AdminView adminView) {
		  HeThong.adminView = adminView;
	 }

	 public static SinhVienTCView getSinhVienTCView() {
		  return sinhVienTCView;
	 }

	 public static void setSinhVienTCView(SinhVienTCView sinhVienTCView) {
		  HeThong.sinhVienTCView = sinhVienTCView;
	 }

	 public static SinhVienNCView getSinhVienNCView() {
		  return sinhVienNCView;
	 }

	 public static void setSinhVienNCView(SinhVienNCView sinhVienNCView) {
		  HeThong.sinhVienNCView = sinhVienNCView;
	 }

	 /*========================= SEARCH OBJECTS  ==============================================*/
	 public static Admin findAdmin(String ma) {//tim NganhHoc theo ma, tra ve 1 NganhHoc (TC/NC)
		  for (Admin a : listAdmin) {
				if (a.getAdminID().equals(ma)) {
					 return a;
				}
		  }
		  return null;//khong tim thay
	 }

	 public static ChuongTrinhHoc findChuongTrinhHoc(String ma) {//tim NganhHoc theo ma, tra ve 1 NganhHoc (TC/NC)
		  for (ChuongTrinhHoc a : listChuongTrinhHoc) {
				if (a.getMaChuongTrinhHoc().equals(ma)) {
					 return a;
				}
		  }
		  return null;//khong tim thay
	 }

	 public static DangKyHocPhan findDangKyHocPhan(String maHocPhan, String maHocKyHeThong) {//tim NganhHoc theo ma, tra ve 1 NganhHoc (TC/NC)
		  for (DangKyHocPhan a : listDangKyHocPhan) {
				if (a.getMaHocPhan().equals(maHocPhan) && (a.getMaHocKyHeThong()).equals(maHocKyHeThong)) {
					 return a;
				}
		  }
		  return null;//khong tim thay
	 }

	 public static HocKyHeThong findHocKyHeThong(String ma) {//tim NganhHoc theo ma, tra ve 1 NganhHoc (TC/NC)
		  for (HocKyHeThong a : listHocKyHeThong) {
				if (a.getMaHocKyHeThong().equals(ma)) {
					 return a;
				}
		  }
		  return null;//khong tim thay
	 }

	 public static HocKySinhVien findHocKySinhVien(String mssv, String maHocKyHeThong) {//tim NganhHoc theo ma, tra ve 1 NganhHoc (TC/NC)
		  for (HocKySinhVien a : listHocKySinhVien) {
				if (a.getMssv().equals(mssv) && (a.getMaHocKyHeThong()).equals(maHocKyHeThong)) {
					 return a;
				}
		  }
		  return null;//khong tim thay
	 }

	 public static HocPhan findHocPhan(String ma) {//tim NganhHoc theo ma, tra ve 1 NganhHoc (TC/NC)
		  for (HocPhan a : listHocPhan) {
				if (a.getMaHocPhan().equals(ma)) {
					 return a;
				}
		  }
		  return null;//khong tim thay
	 }

	 public static KetQuaHocPhan findKetQuaHocPhan(String mssv, String maHocPhan, String maHocKyHeThong) {//tim NganhHoc theo ma, tra ve 1 NganhHoc (TC/NC)
		  for (KetQuaHocPhan a : listKetQuaHocPhan) {
				if (a.getMssv().equals(mssv) && (a.getMaHocPhan().equals(maHocPhan)) && (a.getMaHocKyHeThong().equals(maHocKyHeThong))) {
					 return a;
				}
		  }
		  return null;//khong tim thay
	 }

	 public static LopMo findLopMo(String ma) {//tim NganhHoc theo ma, tra ve 1 NganhHoc (TC/NC)
		  for (LopMo a : listLopMo) {
				if (a.getMaLopMo().equals(ma)) {
					 return a;
				}
		  }
		  return null;//khong tim thay
	 }

	 public static LopSinhVien findLopSinhVien(String ma) {//tim NganhHoc theo ma, tra ve 1 NganhHoc (TC/NC)
		  for (LopSinhVien a : listLopSinhVien) {
				if (a.getMaLopSinhVien().equals(ma)) {
					 return a;
				}
		  }
		  return null;//khong tim thay
	 }

	 public static NganhHoc findNganhHoc(String ma) {//tim NganhHoc theo ma, tra ve 1 NganhHoc (TC/NC)
		  for (NganhHoc a : listNganhHoc) {
				if (a.getMaNganhHoc().equals(ma)) {
					 return a;
				}
		  }
		  return null;//khong tim thay
	 }

	 public static SinhVien findSinhVien(String ma) {//tim NganhHoc theo ma, tra ve 1 NganhHoc (TC/NC)
		  for (SinhVien a : listSinhVien) {
				if (a.getMssv().equals(ma)) {
					 return a;
				}
		  }
		  return null;//khong tim thay
	 }

	 /*=========================  OTHER METHODs : khoi tao cac phien lam viecs  ==============================================*/
	 public static void initLoginSession() {//khoi tao phien dang nhap
		  LoginView loginView = new LoginView();
		  loginView.setVisible(true);
	 }

	 public static void initUserSession(User user) {//khoi tao phien lam viec cho user (svtc/svnc/admin)
		  if (user instanceof SinhVienTC) {
				SinhVienTCView sinhVienTCView = new SinhVienTCView(((SinhVienTC) user).getMssv());//khoi tao loginView
				sinhVienTCView.setVisible(true);
		  } else if (user instanceof SinhVienNC) {
				SinhVienNCView sinhVienNCView = new SinhVienNCView(((SinhVienNC) user).getMssv());//khoi tao loginView
				sinhVienNCView.setVisible(true);
		  }else if(user instanceof Admin){
				AdminView adminView = new AdminView( ((Admin) user).getAdminID());
				adminView.setVisible(true);
                                adminView.pack();
                                adminView.setLocationRelativeTo(null);
                              //  AdminView.
                                AdminView.jLabel_admin.setText("Welcome<"+((Admin) user).getUsername()+">");
                                adminView.displaySinhVien();
                                
                                
		  }

	 }
	 
}//class HeThong
