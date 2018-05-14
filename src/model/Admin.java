package model;
/*@author hai*/
/**
*desciption:
*/
public class Admin extends  User{
/*=================== ATTRIBUTEs ==================================*/
	private String adminID;
	private String hoTen;
	private String username;
	private String password;
/*=================== CONSTRUCTORs ================================*/

	public Admin() {
	}
	
	public Admin(String adminID, String hoTen, String username, String password) {
		this.adminID = adminID;
		this.hoTen = hoTen;
		this.username = username;
		this.password = password;
	}
/*=================== GETTTERs & SETTERs  ============================*/
	

	public String getAdminID() {
		return adminID;
	}

	public void setAdminID(String adminID) {
		this.adminID = adminID;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

/*=================== OTHER METHODs  ===============================*/


}//class Admin
