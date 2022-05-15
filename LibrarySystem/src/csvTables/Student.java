package csvTables;

public class Student implements TableObj{
	private int studentId;
	private String studentName;
	private String studentBirthday;
	private String studentEmail;
	private int mobileNumber;
	
	//Constructor
	public Student(int studentId, String studentName, String studentBirthday, String studentEmail, int mobileNumber) {
		this.setId(studentId);
		this.setName(studentName);
		this.setBirthday(studentBirthday);
		this.setEmail(studentEmail);
		this.setMobileNumber(mobileNumber);
	}
	
    public String toString() {
        return this.getId()
        		+","+this.getName()
        		+","+this.getBirthday()
        		+","+this.getEmail()
        		+","+this.getMobileNumber();
    }
	
	//General
	public void setId(int n) {
		this.studentId = n;
	}
	public int getId() {
		return this.studentId;
	}
	
	public void setName(String s) {
		this.studentName = s;
	}
	public String getName() {
		return this.studentName;
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
	public void setBirthday(String s) {
		this.studentBirthday = s;
	}
	public String getBirthday() {
		return this.studentBirthday;
	}
	
	public void setEmail(String s) {
		this.studentEmail = s;
	}
	public String getEmail() {
		return this.studentEmail;
	}
	
	public void setMobileNumber(int n) {
		this.mobileNumber = n;
	}
	public int getMobileNumber() {
		return this.mobileNumber;
	}
	
	//Librarian and Admin
	public void setPassword(String s) {}
	public String getPassword() {return null;}
	

}
