package view;

import control.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import model.*;

/**
 *
 * @author hai
 */
public final class HeThongView extends javax.swing.JFrame {

	 //list cac class cua hethong
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

	 //model de hien thi list tuong ung
	 DefaultTableModel modelAdmin;//hien thi table admin
	 DefaultTableModel modelChuongTrinhHoc;//hien thi table admin
	 DefaultTableModel modelDangKyHocPhan;//hien thi table admin
	 DefaultTableModel modelHocKyHeThong;//hien thi table admin
	 DefaultTableModel modelHocKySinhVien;//hien thi table admin
	 DefaultTableModel modelHocPhan;//hien thi table admin
	 DefaultTableModel modelKetQuaHocPhan;//hien thi table admin
	 DefaultTableModel modelLopMo;//hien thi table admin
	 DefaultTableModel modelLopSinhVien;//hien thi table admin
	 DefaultTableModel modelNganhHoc;//hien thi table admin
	 DefaultTableModel modelSinhVien;//hien thi table admin

	 /*====================== CONSTRUCTOR ========================*/
	 public HeThongView() {
		  initComponents();
		  this.setLocationRelativeTo(null);//frame xuat hien o giua screen

		  DAOView dao = new DAOView();//ket noi voi CSDL//===============dung DAOView

		  //done - 1 : load du lieu tu database -> toan bo doi tuong cua chuong trinh (chua khoi tao cac property ket tao)
		  //2 : khoi tao cac property ket tap p moi quan he KET TAP
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
		  
		  /*===================== hien thi de check ket qua load vo CT ===============================================*/
		  //hien thi de check ket qua load vo CT
		  modelAdmin = (DefaultTableModel) jTableAdmin.getModel();//model de hien thi danhSachSinhVien
		  modelChuongTrinhHoc = (DefaultTableModel) jTableChuongTrinhHoc.getModel();//model de hien thi danhSachSinhVien
		  modelDangKyHocPhan = (DefaultTableModel) jTableDangKyHocPhan.getModel();//model de hien thi danhSachSinhVien
		  modelHocKyHeThong = (DefaultTableModel) jTableHocKyHeThong.getModel();//model de hien thi danhSachSinhVien
		  modelHocKySinhVien = (DefaultTableModel) jTableHocKySinhVien.getModel();//model de hien thi danhSachSinhVien
		  modelHocPhan = (DefaultTableModel) jTableHocPhan.getModel();//model de hien thi danhSachSinhVien
		  modelKetQuaHocPhan = (DefaultTableModel) jTableKetQuaHocPhan.getModel();//model de hien thi danhSachSinhVien
		  modelLopMo = (DefaultTableModel) jTableLopMo.getModel();//model de hien thi danhSachSinhVien
		  modelLopSinhVien = (DefaultTableModel) jTableLopSinhVien.getModel();//model de hien thi danhSachSinhVien
		  modelNganhHoc = (DefaultTableModel) jTableNganhHoc.getModel();//model de hien thi danhSachSinhVien
		  modelSinhVien = (DefaultTableModel) jTableSinhVien.getModel();//model de hien thi danhSachSinhVien

		  displayListAdmin();//hien thi cac ban ghi da doc duoc tu CSDL
		  displayListChuongTrinhHoc();//hien thi cac ban ghi da doc duoc tu CSDL
		  displayListDangKyHocPhan();//hien thi cac ban ghi da doc duoc tu CSDL
		  displayListHocKyHeThong();//hien thi cac ban ghi da doc duoc tu CSDL
		  displayListHocKySinhVien();//hien thi cac ban ghi da doc duoc tu CSDL
		  displayListHocPhan();//hien thi cac ban ghi da doc duoc tu CSDL
		  displayListKetQuaHocPhan();//hien thi cac ban ghi da doc duoc tu CSDL
		  displayListLopMo();//hien thi cac ban ghi da doc duoc tu CSDL
		  displayListLopSinhVien();//hien thi cac ban ghi da doc duoc tu CSDL
		  displayListNganhHoc();//hien thi cac ban ghi da doc duoc tu CSDL
		  displayListSinhVien();//hien thi cac ban ghi da doc duoc tu CSDL

	 }

	 /*========================= DISPLAY TABLEs ==============================================*/
	 public void displayListAdmin() { //hien thi toan bo danhSachSinhVien khi vua doc du lieu tu database ve
		  listAdmin.forEach((a) -> {
				//hien thi toan bo du lieu doc duoc tu database
				modelAdmin.addRow(new Object[]{
					 a.getAdminID(), a.getHoTen(), a.getUsername(), a.getPassword()
				});

		  });
	 }

	 public void displayListChuongTrinhHoc() { //hien thi toan bo danhSachSinhVien khi vua doc du lieu tu database ve
		  listChuongTrinhHoc.forEach((a) -> {
				//hien thi toan bo du lieu duoc duoc tu database
				modelChuongTrinhHoc.addRow(new Object[]{
					 a.getMaChuongTrinhHoc(), a.getTenChuongTrinhHoc(), a.getHocPhan().size(), a.getLopSinhVien().size(),
					 a.getMaNganhHoc()
				});
		  });

	 }

	 public void displayListDangKyHocPhan() { //hien thi toan bo danhSachSinhVien khi vua doc du lieu tu database ve
		  listDangKyHocPhan.forEach((a) -> {
				//hien thi toan bo du lieu duoc duoc tu database
				modelDangKyHocPhan.addRow(new Object[]{
					 a.getMaHocKyHeThong(), a.getMaHocPhan(), a.getSoLuongSinhVienDangKy()
				});
		  });

	 }

	 public void displayListHocKyHeThong() { //hien thi toan bo danhSachSinhVien khi vua doc du lieu tu database ve
		  listHocKyHeThong.forEach((a) -> {
				//hien thi toan bo du lieu duoc duoc tu database
				modelHocKyHeThong.addRow(new Object[]{
					 a.getMaHocKyHeThong(), a.getBatDauDangKyHocPhan(), a.getBatDauDangKyLopMo(), a.getBatDauHocKy(), a.getKetThucHocKy(),
					 a.getDangKyHocPhan().size(), a.getLopMo().size()
				});
		  });

	 }

	 public void displayListHocKySinhVien() { //hien thi toan bo danhSachSinhVien khi vua doc du lieu tu database ve
		  listHocKySinhVien.forEach((a) -> {
				//hien thi toan bo du lieu duoc duoc tu database
				modelHocKySinhVien.addRow(new Object[]{
					 a.getMssv(), a.getMaHocKyHeThong(), a.getMaHocPhanDangKy().size(), a.getMaLopMoDangKy().size()
				});
		  });

	 }

	 public void displayListHocPhan() { //hien thi toan bo danhSachSinhVien khi vua doc du lieu tu database ve
		  listHocPhan.forEach((a) -> {//hien thi toan bo du lieu duoc duoc tu database
				if (a instanceof HocPhanTC) {//neu la hoc phan tc
					 modelHocPhan.addRow(new Object[]{
						  a.getMaHocPhan(), a.getTenHocPhan(), a.getTrongSoGiuaKy(), a.getTrongSoCuoiKy(), a.getMaChuongTrinhHoc().size(),
						  ((HocPhanTC) a).getMaHocPhanTCDieuKien().size(), ""
					 });
				} else {
					 modelHocPhan.addRow(new Object[]{
						  a.getMaHocPhan(), a.getTenHocPhan(), a.getTrongSoGiuaKy(), a.getTrongSoCuoiKy(), a.getMaChuongTrinhHoc().size(),
						  "", ((HocPhanNC) a).getSttHocKy()
					 });
				}
		  });

	 }

	 public void displayListKetQuaHocPhan() { //hien thi toan bo danhSachSinhVien khi vua doc du lieu tu database ve
		  listKetQuaHocPhan.forEach((a) -> {
				//hien thi toan bo du lieu duoc duoc tu database
				modelKetQuaHocPhan.addRow(new Object[]{
					 a.getMssv(), a.getMaHocPhan(), a.getMaHocKyHeThong(), a.getDiemGiuaKy(), a.getDiemCuoiKy(), a.getDiemHocPhan(), a.getKetQua()
				});
		  });

	 }

	 public void displayListLopMo() { //hien thi toan bo danhSachSinhVien khi vua doc du lieu tu database ve
		  listLopMo.forEach((a) -> {
				//hien thi toan bo du lieu duoc duoc tu database
				modelLopMo.addRow(new Object[]{
					 a.getMaLopMo(), a.getMaHocPhan(), a.getMaHocKyHeThong(), a.getSoLuongSinhVienToiDa(), a.getSinhVien().size()
				});
		  });

	 }

	 public void displayListLopSinhVien() { //hien thi toan bo danhSachSinhVien khi vua doc du lieu tu database ve
		  listLopSinhVien.forEach((a) -> {
				//hien thi toan bo du lieu duoc duoc tu database
				modelLopSinhVien.addRow(new Object[]{
					 a.getMaLopSinhVien(), a.getNamNhapHoc(), a.getSinhVien().size(), a.getMaChuongTrinhHoc()
				});
		  });

	 }

	 public void displayListNganhHoc() { //hien thi toan bo danhSachSinhVien khi vua doc du lieu tu database ve
		  listNganhHoc.forEach((a) -> {
				//hien thi toan bo du lieu duoc duoc tu database
				modelNganhHoc.addRow(new Object[]{
					 a.getMaNganhHoc(), a.getTenNganhHoc(), a.getChuongTrinhHoc().size()
				});
		  });

	 }

	 public void displayListSinhVien() { //hien thi toan bo danhSachSinhVien khi vua doc du lieu tu database ve
		  listSinhVien.forEach((a) -> {
				//hien thi toan bo du lieu duoc duoc tu database
				if (a instanceof SinhVienTC) {
					 modelSinhVien.addRow(new Object[]{
						  a.getMssv(), a.getHoTen(), a.getMaLopSinhVien(), a.getMaChuongTrinhHoc(), a.getMaNganhHoc(),
						  a.getUsername(), a.getPassword(), a.getTrangThai(), a.getBangTotNghiep(),
						  a.getBangDiem().size(), a.getHocKySinhVien().size()

					 });
				} else {
					 modelSinhVien.addRow(new Object[]{
						  a.getMssv(), a.getHoTen(), a.getMaLopSinhVien(), a.getMaChuongTrinhHoc(), a.getMaNganhHoc(),
						  a.getUsername(), a.getPassword(), a.getTrangThai(), a.getBangTotNghiep(),
						  a.getBangDiem().size(), a.getHocKySinhVien().size()

					 });
				}
		  });

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

	 //findDangKyHocPhan
	 /**
	  * This method is called from within the constructor to initialize the form.
	  * WARNING: Do NOT modify this code. The content of this method is always
	  * regenerated by the Form Editor.
	  */
	 @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane = new javax.swing.JTabbedPane();
        jPanelAdmin = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableAdmin = new javax.swing.JTable();
        jPanelChuongTrinhHoc = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableChuongTrinhHoc = new javax.swing.JTable();
        jPanelDangKyHocPhan = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTableDangKyHocPhan = new javax.swing.JTable();
        jPanelHocKyHeThong = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTableHocKyHeThong = new javax.swing.JTable();
        jPanelHocKySinhVien = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        jTableHocKySinhVien = new javax.swing.JTable();
        jPanelHocPhan = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTableHocPhan = new javax.swing.JTable();
        jPanelKetQuaHocPhan = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTableKetQuaHocPhan = new javax.swing.JTable();
        jPanelLopMo = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        jTableLopMo = new javax.swing.JTable();
        jPanelLopSinhVien = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTableLopSinhVien = new javax.swing.JTable();
        jPanelNganhHoc = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableNganhHoc = new javax.swing.JTable();
        jPanelSinhVien = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableSinhVien = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTableAdmin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "adminID", "hoTen", "username", "passqword"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableAdmin);

        javax.swing.GroupLayout jPanelAdminLayout = new javax.swing.GroupLayout(jPanelAdmin);
        jPanelAdmin.setLayout(jPanelAdminLayout);
        jPanelAdminLayout.setHorizontalGroup(
            jPanelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1048, Short.MAX_VALUE)
        );
        jPanelAdminLayout.setVerticalGroup(
            jPanelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
        );

        jTabbedPane.addTab("Admin", jPanelAdmin);

        jTableChuongTrinhHoc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "maChuongTrinhHoc", "tenChuongTrinhHoc", "soHocPhanPhaiHoc", "soLopSinhVien", "maNganhHoc"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(jTableChuongTrinhHoc);

        javax.swing.GroupLayout jPanelChuongTrinhHocLayout = new javax.swing.GroupLayout(jPanelChuongTrinhHoc);
        jPanelChuongTrinhHoc.setLayout(jPanelChuongTrinhHocLayout);
        jPanelChuongTrinhHocLayout.setHorizontalGroup(
            jPanelChuongTrinhHocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 1048, Short.MAX_VALUE)
        );
        jPanelChuongTrinhHocLayout.setVerticalGroup(
            jPanelChuongTrinhHocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
        );

        jTabbedPane.addTab("ChuongTrinhHoc", jPanelChuongTrinhHoc);

        jTableDangKyHocPhan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "maHocKyHeThong", "maHocPhan", "soLuongSinhVienDangKy"
            }
        ));
        jScrollPane9.setViewportView(jTableDangKyHocPhan);

        javax.swing.GroupLayout jPanelDangKyHocPhanLayout = new javax.swing.GroupLayout(jPanelDangKyHocPhan);
        jPanelDangKyHocPhan.setLayout(jPanelDangKyHocPhanLayout);
        jPanelDangKyHocPhanLayout.setHorizontalGroup(
            jPanelDangKyHocPhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 1048, Short.MAX_VALUE)
        );
        jPanelDangKyHocPhanLayout.setVerticalGroup(
            jPanelDangKyHocPhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
        );

        jTabbedPane.addTab("DangKyHocPhan", jPanelDangKyHocPhan);

        jTableHocKyHeThong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "maHocKyHeThong", "batDauDangKyHocPhan", "batDauDangKyLop", "batDauHocKy", "ketThucHocKy", "soLuongDangKyHocPhan", "soLuongLopMo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane7.setViewportView(jTableHocKyHeThong);

        javax.swing.GroupLayout jPanelHocKyHeThongLayout = new javax.swing.GroupLayout(jPanelHocKyHeThong);
        jPanelHocKyHeThong.setLayout(jPanelHocKyHeThongLayout);
        jPanelHocKyHeThongLayout.setHorizontalGroup(
            jPanelHocKyHeThongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 1048, Short.MAX_VALUE)
        );
        jPanelHocKyHeThongLayout.setVerticalGroup(
            jPanelHocKyHeThongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
        );

        jTabbedPane.addTab("HocKyHeThong", jPanelHocKyHeThong);

        jTableHocKySinhVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MSSV", "maHocKyHeThong", "soHocPhanDangKy", "soLopDangKy"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane10.setViewportView(jTableHocKySinhVien);

        javax.swing.GroupLayout jPanelHocKySinhVienLayout = new javax.swing.GroupLayout(jPanelHocKySinhVien);
        jPanelHocKySinhVien.setLayout(jPanelHocKySinhVienLayout);
        jPanelHocKySinhVienLayout.setHorizontalGroup(
            jPanelHocKySinhVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 1048, Short.MAX_VALUE)
        );
        jPanelHocKySinhVienLayout.setVerticalGroup(
            jPanelHocKySinhVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
        );

        jTabbedPane.addTab("HocKySinhVien", jPanelHocKySinhVien);

        jTableHocPhan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "maHocPhan", "tenHocPhan", "trongSoGiuaKy", "trongSoCuoiKy", "soLuongChuongTrinhHocNamTrong", "soHocPhanTCDieuKien", "sttHocKyNC"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(jTableHocPhan);

        javax.swing.GroupLayout jPanelHocPhanLayout = new javax.swing.GroupLayout(jPanelHocPhan);
        jPanelHocPhan.setLayout(jPanelHocPhanLayout);
        jPanelHocPhanLayout.setHorizontalGroup(
            jPanelHocPhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 1048, Short.MAX_VALUE)
        );
        jPanelHocPhanLayout.setVerticalGroup(
            jPanelHocPhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
        );

        jTabbedPane.addTab("HocPhan", jPanelHocPhan);

        jTableKetQuaHocPhan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MSSV", "maHocPhan", "maHocKyHeThong", "diemGiuaKy", "diemCuoiKy", "diemHocPhan", "ketQua"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane8.setViewportView(jTableKetQuaHocPhan);

        javax.swing.GroupLayout jPanelKetQuaHocPhanLayout = new javax.swing.GroupLayout(jPanelKetQuaHocPhan);
        jPanelKetQuaHocPhan.setLayout(jPanelKetQuaHocPhanLayout);
        jPanelKetQuaHocPhanLayout.setHorizontalGroup(
            jPanelKetQuaHocPhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 1048, Short.MAX_VALUE)
        );
        jPanelKetQuaHocPhanLayout.setVerticalGroup(
            jPanelKetQuaHocPhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
        );

        jTabbedPane.addTab("KetQuaHocPhan", jPanelKetQuaHocPhan);

        jTableLopMo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "maLopMo", "maHocPhan", "maHocKyHeThong", "soLuongSinhVienToiDa", "siSo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane11.setViewportView(jTableLopMo);

        javax.swing.GroupLayout jPanelLopMoLayout = new javax.swing.GroupLayout(jPanelLopMo);
        jPanelLopMo.setLayout(jPanelLopMoLayout);
        jPanelLopMoLayout.setHorizontalGroup(
            jPanelLopMoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 1048, Short.MAX_VALUE)
        );
        jPanelLopMoLayout.setVerticalGroup(
            jPanelLopMoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
        );

        jTabbedPane.addTab("LopMo", jPanelLopMo);

        jTableLopSinhVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "maLopSinhVien", "namNhapHoc", "siSo", "machuongTrinhHoc"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(jTableLopSinhVien);

        javax.swing.GroupLayout jPanelLopSinhVienLayout = new javax.swing.GroupLayout(jPanelLopSinhVien);
        jPanelLopSinhVien.setLayout(jPanelLopSinhVienLayout);
        jPanelLopSinhVienLayout.setHorizontalGroup(
            jPanelLopSinhVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 1048, Short.MAX_VALUE)
        );
        jPanelLopSinhVienLayout.setVerticalGroup(
            jPanelLopSinhVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
        );

        jTabbedPane.addTab("LopSinhVien", jPanelLopSinhVien);

        jTableNganhHoc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "maNganhHoc", "tenNganhHoc", "soLuongChuongTrinhHoc"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTableNganhHoc);

        javax.swing.GroupLayout jPanelNganhHocLayout = new javax.swing.GroupLayout(jPanelNganhHoc);
        jPanelNganhHoc.setLayout(jPanelNganhHocLayout);
        jPanelNganhHocLayout.setHorizontalGroup(
            jPanelNganhHocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1048, Short.MAX_VALUE)
        );
        jPanelNganhHocLayout.setVerticalGroup(
            jPanelNganhHocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
        );

        jTabbedPane.addTab("NganhHoc", jPanelNganhHoc);

        jTableSinhVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MSSV", "hoTen", "maLopSinhVien", "maChuongTrinhHoc", "maNganhHoc", "username", "password", "trangthaihoctap", "bangtotnghiep", "soLuongKetQuaHocPhan", "soLuongHocKySinhvien"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTableSinhVien);

        javax.swing.GroupLayout jPanelSinhVienLayout = new javax.swing.GroupLayout(jPanelSinhVien);
        jPanelSinhVien.setLayout(jPanelSinhVienLayout);
        jPanelSinhVienLayout.setHorizontalGroup(
            jPanelSinhVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1048, Short.MAX_VALUE)
        );
        jPanelSinhVienLayout.setVerticalGroup(
            jPanelSinhVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
        );

        jTabbedPane.addTab("SinhVien", jPanelSinhVien);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

	 /*======================== MAIN ==============================*/
	 public static void main(String args[]) {
		  /* Set the Nimbus look and feel */
		  //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
		  /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
		   */
		  try {
				for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
					 if ("Nimbus".equals(info.getName())) {
						  javax.swing.UIManager.setLookAndFeel(info.getClassName());
						  break;
					 }
				}
		  } catch (ClassNotFoundException ex) {
				java.util.logging.Logger.getLogger(HeThongView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		  } catch (InstantiationException ex) {
				java.util.logging.Logger.getLogger(HeThongView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		  } catch (IllegalAccessException ex) {
				java.util.logging.Logger.getLogger(HeThongView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		  } catch (javax.swing.UnsupportedLookAndFeelException ex) {
				java.util.logging.Logger.getLogger(HeThongView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		  }
		  //</editor-fold>
		  //</editor-fold>
		  //</editor-fold>
		  //</editor-fold>

		  /* Create and display the form */
//		  java.awt.EventQueue.invokeLater(new Runnable() {
//				public void run() {
//					 new HeThongView().setVisible(true);
//				}
//		  });
		  HeThongView hethong = new HeThongView();
		  hethong.setVisible(true);

	 }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanelAdmin;
    private javax.swing.JPanel jPanelChuongTrinhHoc;
    private javax.swing.JPanel jPanelDangKyHocPhan;
    private javax.swing.JPanel jPanelHocKyHeThong;
    private javax.swing.JPanel jPanelHocKySinhVien;
    private javax.swing.JPanel jPanelHocPhan;
    private javax.swing.JPanel jPanelKetQuaHocPhan;
    private javax.swing.JPanel jPanelLopMo;
    private javax.swing.JPanel jPanelLopSinhVien;
    private javax.swing.JPanel jPanelNganhHoc;
    private javax.swing.JPanel jPanelSinhVien;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane;
    private javax.swing.JTable jTableAdmin;
    private javax.swing.JTable jTableChuongTrinhHoc;
    private javax.swing.JTable jTableDangKyHocPhan;
    private javax.swing.JTable jTableHocKyHeThong;
    private javax.swing.JTable jTableHocKySinhVien;
    private javax.swing.JTable jTableHocPhan;
    private javax.swing.JTable jTableKetQuaHocPhan;
    private javax.swing.JTable jTableLopMo;
    private javax.swing.JTable jTableLopSinhVien;
    private javax.swing.JTable jTableNganhHoc;
    private javax.swing.JTable jTableSinhVien;
    // End of variables declaration//GEN-END:variables
}
