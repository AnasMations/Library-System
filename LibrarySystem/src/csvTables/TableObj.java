package csvTables;

public interface TableObj {
	//General
	public abstract void setId(int n);
	public abstract void setName(String s);
	
	public abstract int getId();
	public abstract String getName();
	
	//Books
	public abstract void setAuthorName(String s);
	public abstract void setAvailableQuantity(int n);
	public abstract void setIssuedQuantity(int n);
	
	public abstract String getAuthorName();
	public abstract int getAvailableQuantity();
	public abstract int getIssuedQuantity();
	
	//Issued Books
	public abstract void setBookId(int n);
	public abstract void setStudentId(int n);
	public abstract void setReturned(Boolean b);
	
	public abstract int getBookId();
	public abstract int getStudentId();
	public abstract Boolean getReturned();
	
	//Students
	public abstract void setBirthday(String s);
	public abstract void setEmail(String s);
	public abstract void setMobileNumber(int n);
	
	public abstract String getBirthday();
	public abstract String getEmail();
	public abstract int getMobileNumber();
	
	//Librarians and Admins
	public abstract void setPassword(String s);
	
	public abstract String getPassword();
	
}
