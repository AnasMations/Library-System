package csvTables;

public class IssuedBook implements TableObj{
	private int procedureId;
	private int bookId;
	private int studentId;
	private boolean returned;
	
	//Constructor
	public IssuedBook(int procedureId, int bookId, int studentId, boolean returned) {
		this.setId(procedureId);
		this.setBookId(bookId);
		this.setStudentId(studentId);
		this.setReturned(returned);
	}
	
    public String toString() {
        return this.getId()
        		+","+this.getBookId()
        		+","+this.getStudentId()
        		+","+this.getReturned();
    }
	
	//General
	public void setId(int n) {
		this.procedureId = n;
	}
	public int getId() {
		return this.procedureId;
	}
	
	public void setName(String s) {}
	public String getName() {return null;}
	
	//Book
	public void setAuthorName(String s) {}
	public String getAuthorName() {return null;}
	
	public void setAvailableQuantity(int n) {}
	public int getAvailableQuantity() {return 0;}
	
	public void setIssuedQuantity(int n) {}
	public int getIssuedQuantity() {return 0;}
	
	//Issued Book
	public void setBookId(int n) {
		this.bookId = n;
	}
	public int getBookId() {
		return this.bookId;
	}
	
	public void setStudentId(int n) {
		this.studentId = n;
	}
	public int getStudentId() {
		return this.studentId;
	}
	
	public void setReturned(Boolean b) {
		this.returned = b;
	}
	public Boolean getReturned() {
		return this.returned;
	}
	
	//Student
	public void setBirthday(String s) {}
	public String getBirthday() {return null;}
	
	public void setEmail(String s) {}
	public String getEmail() {return null;}
	
	public void setMobileNumber(int n) {}
	public int getMobileNumber() {return 0;}
	
	//Librarian and Admin
	public void setPassword(String s) {}
	public String getPassword() {return null;}
}
