package csvTables;

public class Book implements TableObj{
	private int id;
	private String bookName;
	private String authorName;
	private int availableQuantity;
	private int issuedQuantity;
	
	//Constructor
	public Book(int id, String bookName, String authorName, int availableQuantity, int issuedQuantity){
		this.setId(id);
		this.setName(bookName);
		this.setAuthorName(authorName);
		this.setAvailableQuantity(availableQuantity);
		this.setIssuedQuantity(issuedQuantity);
	}
	
    public String toString() {
        return this.getId()
        		+","+this.getName()
        		+","+this.getAuthorName()
        		+","+this.getAvailableQuantity()
        		+","+this.getIssuedQuantity();
    }
	
	//General
	public void setId(int n) {
		this.id = n;
	}
	public int getId() {
		return this.id;
	}
	
	public void setName(String s) {
		this.bookName = s;
	}
	public String getName() {
		return this.bookName;
	}
	
	//Book
	public void setAuthorName(String s) {
		this.authorName = s;
	}
	public String getAuthorName() {
		return this.authorName;
	}
	
	public void setAvailableQuantity(int n) {
		this.availableQuantity = n;
	}
	public int getAvailableQuantity() {
		return this.availableQuantity;
	}
	
	public void setIssuedQuantity(int n) {
		this.issuedQuantity = n;
	}
	public int getIssuedQuantity() {
		return this.issuedQuantity;
	}
	
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
	public void setPassword(String s) {}
	public String getPassword() {return null;}
}
