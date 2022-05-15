import csvTables.Book;
import csvTables.CSV;
import csvTables.IssuedBook;
import csvTables.Student;
import csvTables.Librarian;
import csvTables.Admin;
import csvTables.Table;

public class controller{
	private Table booksTable = new Table();
	private Table issuedBooksTable = new Table();
	private Table studentsTable = new Table();
	private Table librariansTable = new Table();
	private Table adminsTable = new Table();
	
	private CSV csv = new CSV(booksTable, issuedBooksTable, studentsTable, librariansTable, adminsTable);
	
	public controller() {
		this.readCSV(); //import all existing csv files to the table arrays
	}
	
	public void saveCSV() {
		this.csv.saveCSV(); 
	}
	
	public void readCSV() {
		this.csv.readCSV();
	}
	
	public boolean adminLogin(String name, String password) {
		if(this.adminsTable.nameDoesExist(name)) {
			if(password.equals(this.adminsTable.getTable().get(this.adminsTable.searchIndex(name)).getPassword())) {
				return true;
			}else {
				System.out.println("Wrong password!");
				return false;
			}
		}else if(name.equals("ADMIN") && password.equals("ADMIN")) { // Default admin
			return true;
		}
		else {
			System.out.println("This name is not found!");
			return false;
		}
	}
	
	public boolean librarianLogin(String name, String password) {
		if(this.librariansTable.nameDoesExist(name)) {
			if(password.equals(this.librariansTable.getTable().get(this.librariansTable.searchIndex(name)).getPassword())) {
				return true;
			}else {
				System.out.println("Wrong password!");
				return false;
			}
		}else {
			System.out.println("This name is not found!");
			return false;
		}
	}
	
	// Admin view
	public void addStudent(int studentId, String studentName, String studentBirthday, String studentEmail, int studentMobileNumber) {
		if(this.studentsTable.idDoesExist(studentId)) {
			System.out.println("This ID does already exist in the table!");
		}else {
			Student newstudent = new Student(studentId, studentName, studentBirthday, studentEmail, studentMobileNumber);
			this.studentsTable.add(newstudent);
			System.out.println("Student "+studentName+" has been added successfully.");
		}
	}
	public void removeStudent(int studentID) {
		if(this.studentsTable.idDoesExist(studentID)) {
			this.studentsTable.remove(studentID);
			System.out.println("Student has been removed.");
		}else {
			System.out.println("This ID does not exist in the table!");
		}
	}
	
	public void addLibrarian(int librarianId, String librarianName, String librarianPassword) {
		if(this.librariansTable.idDoesExist(librarianId)) {
			System.out.println("This ID does already exist in the table!");
		}else {
			Librarian newlibrarian = new Librarian(librarianId, librarianName, librarianPassword);
			this.librariansTable.add(newlibrarian);
			System.out.println("Librarian "+librarianName+" has been added successfully.");
		}
	}
	public void removeLibrarian(int librarianId) {
		if(this.librariansTable.idDoesExist(librarianId)) {
			this.librariansTable.remove(librarianId);
			System.out.println("Librarian has been removed.");
		}else {
			System.out.println("This ID does not exist in the table!");
		}
	}
	
	public void addAdmin(int adminId, String adminName, String adminPassword) {
		if(this.adminsTable.idDoesExist(adminId)) {
			System.out.println("This ID does already exist in the table!");
		}else {
			Admin newadmin = new Admin(adminId, adminName, adminPassword);
			this.adminsTable.add(newadmin);
			System.out.println("Admin "+adminName+" has been added successfully.");
		}
	}
	public void removeAdmin(int adminId) {
		if(this.adminsTable.idDoesExist(adminId)) {
			this.adminsTable.remove(adminId);
			System.out.println("Admin has been removed.");
		}else {
			System.out.println("This ID does not exist in the table!");
		}
	}
	
	// Librarian view
	public void addBook(int bookId, String bookName, String authorName, int availableQuantity, int issuedQuantity){
		if(this.booksTable.idDoesExist(bookId)) {
			System.out.println("This ID does already exist in the table!");
		}else {
			Book newbook = new Book(bookId, bookName, authorName, availableQuantity, issuedQuantity);
			this.booksTable.add(newbook);
			System.out.println("Book "+bookName+" has been added successfully.");
		}

	}
	public void removeBook(int bookId) {
		if(this.booksTable.idDoesExist(bookId)) {
			this.booksTable.remove(bookId);
			System.out.println("Book has been removed.");
		}else {
			System.out.println("This ID does not exist in the table!");
		}
	}
	
	public void issueBook(int bookId, int studentId) {
		if(this.booksTable.idDoesExist(bookId) && this.studentsTable.idDoesExist(studentId)) {
			Book tempBook = (Book) this.booksTable.getTable().get(this.booksTable.searchIndex(bookId));
			if(tempBook.getAvailableQuantity()>0) {
				// decrease available quantity in bookTable and increase issued quantity
				tempBook.setAvailableQuantity(tempBook.getAvailableQuantity()-1);
				tempBook.setIssuedQuantity(tempBook.getIssuedQuantity()+1);
				int procedureId=0;
				while(this.issuedBooksTable.idDoesExist(procedureId)) {
					procedureId++;
				}
				IssuedBook newissuedbook = new IssuedBook(procedureId, bookId, studentId, false);
				this.issuedBooksTable.add(newissuedbook);
				System.out.println("Book has been issued successfully.");
			}else {
				System.out.println("Cannot Issue this book!");
			}

		}else {
			System.out.println("Please recheck the IDs eneterd!");
		}

	}
	public void returnBook(int procedureId) {
		if(this.issuedBooksTable.idDoesExist(procedureId)) {
			IssuedBook tempIssuedBook = (IssuedBook) this.issuedBooksTable.getTable().get(this.issuedBooksTable.searchIndex(procedureId));
			Book tempBook = (Book) this.booksTable.getTable().get(this.booksTable.searchIndex(tempIssuedBook.getBookId()));
			
			if(tempBook.getIssuedQuantity()>0 && tempIssuedBook.getReturned()==false) {
				// mark book as returned
				tempIssuedBook.setReturned(true);
				
				// increase available quantity in bookTable and decrease issued quantity
				tempBook.setAvailableQuantity(tempBook.getAvailableQuantity()+1);
				tempBook.setIssuedQuantity(tempBook.getIssuedQuantity()-1);
				System.out.println("Book has been returned successfully.");
			}else {
				System.out.println("Cannot return this book!");
			}

		}else {
			System.out.println("Please recheck the entered ID!");
		}
	}
	
	//TODO
	public void viewBooks() {
		this.booksTable.viewAll();
	}
	public void viewIssuedBooks() {
		this.issuedBooksTable.viewAll();
	}
	
	public void searchBook(String name) {
		try {
			int id = Integer.parseInt(name);
			if(this.booksTable.idDoesExist(id)) {
				System.out.println(this.booksTable.getTable().get(this.booksTable.searchIndex(id)).toString());
			}else {
				System.out.println("This book does not exist!");
			}
		} catch(NumberFormatException e) {
			if(this.booksTable.nameDoesExist(name)) {
				System.out.println(this.booksTable.getTable().get(this.booksTable.searchIndex(name)).toString());
			}else {
				System.out.println("This book does not exist!");
			}
		}
	}
}
