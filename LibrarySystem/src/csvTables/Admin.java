package csvTables;

public class Admin implements TableObj{
	private int adminId;
	private String adminName;
	private String adminPassword;
	
	//Constructor
	public Admin(int adminId, String adminName, String adminPassword) {
		this.setId(adminId);
		this.setName(adminName);
		this.setPassword(adminPassword);
	}
	
    public String toString() {
        return this.getId()
        		+","+this.getName()
        		+","+this.getPassword();
    }
	
	//General
	public void setId(int n) {
		this.adminId = n;
	}
	public int getId() {
		return this.adminId;
	}
	
	public void setName(String s) {
		this.adminName = s;
	}
	public String getName() {
		return this.adminName;
	}
	
	//Book
	public void setAuthorName(String s) {}
	public String getAuthorName() {return null;}
	
	public void setAvailableQuantity(int n) {}
	public int getAvailableQuantity() {return 0;}
	
	public void setIssuedQuantity(int n) {}
	public int getIssuedQuantity() {return 0;}
	
	//Issued Book
	public void setBookId(int n) {}
	public int getBookId() {return 0;}
	
	public void setStudentId(int n) {}
	public int getStudentId() {return 0;}
	
	public void setReturned(Boolean b) {}
	public Boolean getReturned() {return null;}
	
	//Student
	public void setBirthday(String s) {}
	public String getBirthday() {return null;}
	
	public void setEmail(String s) {}
	public String getEmail() {return null;}
	
	public void setMobileNumber(int n) {}
	public int getMobileNumber() {return 0;}
	
	//Librarian and Admin
	public void setPassword(String s) {
		this.adminPassword = s;
	}
	public String getPassword() {
		return this.adminPassword;
	}
	
}
