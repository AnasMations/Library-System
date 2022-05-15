package csvTables;

public class Librarian implements TableObj{
	private int librarianId;
	private String librarianName;
	private String librarianPassword;
	
	//Constructor
	public Librarian(int librarianId, String librarianName, String librarianPassword) {
		this.setId(librarianId);
		this.setName(librarianName);
		this.setPassword(librarianPassword);
	}
	
    public String toString() {
        return this.getId()
        		+","+this.getName()
        		+","+this.getPassword();
    }
	
	//General
	public void setId(int n) {
		this.librarianId = n;
	}
	public int getId() {
		return this.librarianId;
	}
	
	public void setName(String s) {
		this.librarianName = s;
	}
	public String getName() {
		return this.librarianName;
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
		this.librarianPassword = s;
	}
	public String getPassword() {
		return this.librarianPassword;
	}
	
}
