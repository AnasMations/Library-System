package csvTables;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class CSV {
	private Table booksTable = new Table();
	private Table issuedBooksTable = new Table();
	private Table studentsTable = new Table();
	private Table librariansTable = new Table();
	private Table adminsTable = new Table();
	
	public CSV(Table booksTable, Table issuedBooksTable, Table studentsTable, Table librariansTable, Table adminsTable) {
		this.booksTable = booksTable;
		this.issuedBooksTable = issuedBooksTable;
		this.studentsTable = studentsTable;
		this.librariansTable = librariansTable;
		this.adminsTable = adminsTable;
	}

	//Saves all ArrayList data in the CSV file
	public void saveCSV() {
		this.saveBooksCSV();
		this.saveIssuedBooksCSV();
		this.saveStudentsCSV();
		this.saveLibrariansCSV();
		this.saveAdminsCSV();
		System.out.println("CSV Saved!");
	}
	
	private void saveBooksCSV() {
		try (PrintWriter writer = new PrintWriter("Books.csv")) {
			
			StringBuilder sb = new StringBuilder();
			sb.append("Id,Book Name,Author Name,Available Quantity,Issued Quantity\n");
			sb.append(booksTable.printAll());
			writer.write(sb.toString());

		    } catch (FileNotFoundException e) {
		    System.out.println(e.getMessage());
		    }
	}
	
	private void saveIssuedBooksCSV() {
		try (PrintWriter writer = new PrintWriter("Issued Books.csv")) {
			
			StringBuilder sb = new StringBuilder();
			sb.append("Procedure Id,Book Id,Student Id,Returned\n");
			sb.append(issuedBooksTable.printAll());
			writer.write(sb.toString());

		    } catch (FileNotFoundException e) {
		    System.out.println(e.getMessage());
		    }
	}
	
	private void saveStudentsCSV() {
		try (PrintWriter writer = new PrintWriter("Students.csv")) {
			
			StringBuilder sb = new StringBuilder();
			sb.append("Student Id,Student Name,Student Birthday,Student Email,Student Mobile number\n");
			sb.append(studentsTable.printAll());
			writer.write(sb.toString());

		    } catch (FileNotFoundException e) {
		    System.out.println(e.getMessage());
		    }
	}
	
	private void saveLibrariansCSV() {
		try (PrintWriter writer = new PrintWriter("Librarians.csv")) {
			
			StringBuilder sb = new StringBuilder();
			sb.append("Librarian Id,Librarian Name,Librarian Password\n");
			sb.append(librariansTable.printAll());
			writer.write(sb.toString());

		    } catch (FileNotFoundException e) {
		    System.out.println(e.getMessage());
		    }
	}
	
	private void saveAdminsCSV() {
		try (PrintWriter writer = new PrintWriter("Admins.csv")) {
			
			StringBuilder sb = new StringBuilder();
			sb.append("Admins Id,Admins Name,Admins Password\n");
//			Admin defaultAdmin = new Admin(404, "ADMIN", "ADMIN");
//			adminsTable.add(defaultAdmin);
			sb.append(adminsTable.printAll());
			writer.write(sb.toString());

		    } catch (FileNotFoundException e) {
		    System.out.println(e.getMessage());
		    }
		
	}
	
	
	public void readCSV() {
		this.readBooksCSV();
		this.readIssuedBooksCSV();
		this.readStudentsCSV();
		this.readLibrariansCSV();
		this.readAdminsCSV();
	}
	
	// Reading from csv files to ArrayLists
	private void readBooksCSV() {
		String path = "Books.csv";
		String line = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			br.readLine(); // Skip the first row
			while((line = br.readLine()) != null) {
				String[] column = line.split(",");
				
				Book book = new Book(Integer.parseInt(column[0]), column[1], column[2], Integer.parseInt(column[3]), Integer.parseInt(column[4]));
				booksTable.add(book);
			}
			
		} catch (FileNotFoundException e) {
			this.saveBooksCSV();
			//e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void readIssuedBooksCSV() {
		String path = "Issued Books.csv";
		String line = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			br.readLine(); // Skip the first row
			while((line = br.readLine()) != null) {
				String[] column = line.split(",");
				
				IssuedBook issuedBook = new IssuedBook(Integer.parseInt(column[0]), Integer.parseInt(column[1]), Integer.parseInt(column[2]), Boolean.parseBoolean(column[3]));
				issuedBooksTable.add(issuedBook);
			}
			
		} catch (FileNotFoundException e) {
			this.saveIssuedBooksCSV();
			//e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void readStudentsCSV() {
		String path = "Students.csv";
		String line = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			br.readLine(); // Skip the first row
			while((line = br.readLine()) != null) {
				String[] column = line.split(",");
				
				Student student = new Student(Integer.parseInt(column[0]), column[1], column[2], column[3], Integer.parseInt(column[4]));
				studentsTable.add(student);
			}
			
		} catch (FileNotFoundException e) {
			this.saveStudentsCSV();
			//e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void readLibrariansCSV() {
		String path = "Librarians.csv";
		String line = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			br.readLine(); // Skip the first row
			while((line = br.readLine()) != null) {
				String[] column = line.split(",");
				
				Librarian librarian = new Librarian(Integer.parseInt(column[0]), column[1], column[2]);
				librariansTable.add(librarian);
			}
			
		} catch (FileNotFoundException e) {
			this.saveLibrariansCSV();
			//e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void readAdminsCSV() {
		String path = "Admins.csv";
		String line = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			br.readLine(); // Skip the first row
//			br.readLine(); // Skip default admin row
			while((line = br.readLine()) != null) {
				String[] column = line.split(",");
				
				Admin admin = new Admin(Integer.parseInt(column[0]), column[1], column[2]);
				adminsTable.add(admin);
			}
			
		} catch (FileNotFoundException e) {
			this.saveAdminsCSV();
			//e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
