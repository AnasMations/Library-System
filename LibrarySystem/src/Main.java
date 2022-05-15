import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		controller c = new controller();
		Scanner sc = new Scanner(System.in);
		
		do {
		System.out.println("----- Log in -----");
		System.out.println("1 to login as Admin \n"
						 + "2 to login as Librarian");
		
		System.out.print("Enter your choice: ");
		String choice = sc.nextLine();
		
		if(choice.equals("1")) {
			System.out.print("Enter name: ");
			String name = sc.nextLine();
			System.out.print("Enter Password: ");
			String password = sc.nextLine();
			if(c.adminLogin(name, password)) {
				System.out.println("---- Welcome, "+name+"! ----");
				adminView();
				c.readCSV();
			}
		}
		else if(choice.equals("2")) {
			System.out.print("Enter name: ");
			String name = sc.nextLine();
			System.out.print("Enter Password: ");
			String password = sc.nextLine();
			if(c.librarianLogin(name, password)) {
				System.out.println("---- Welcome, "+name+"! ----");
				librarianView();
				c.readCSV();
			}
		}else {
			System.out.println("Please enter valid input!");
		}
	}while(true);
	}
	
	public static void adminView() {
		System.out.println("1) Add Student");
		System.out.println("2) Remove Student");
		System.out.println("3) Add Librarian");
		System.out.println("4) Remove Librarian");
		System.out.println("5) Add Admin");
		System.out.println("6) Remove Admin");
		System.out.println("0) Save and Log out\n");
		
		controller c = new controller();
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter your choice: ");
		String choice = sc.nextLine();
		
		int id, mobilenumber;
		String name, birthday, email, password;
		do {
			switch(choice) {
			case "1":
				System.out.print("Enter ID: ");
				try {
					id = Integer.parseInt(sc.nextLine());
				} catch(NumberFormatException e) {
					System.out.println("Please enter an Integer value!");
					break;
				}
				
				System.out.print("Enter Name: ");
				name = sc.nextLine();
				
				System.out.print("Enter Birthday: ");
				birthday = sc.nextLine();
				
				System.out.print("Enter Email: ");
				email = sc.nextLine();
				
				System.out.print("Enter Mobile number: ");
				try {
					mobilenumber = Integer.parseInt(sc.nextLine());
				} catch(NumberFormatException e) {
					System.out.println("Please enter an Integer value!");
					break;
				}
				
				c.addStudent(id, name, birthday, email, mobilenumber);
				break;
			case "2":
				System.out.print("Enter ID: ");
				try {
					id = Integer.parseInt(sc.nextLine());
				} catch(NumberFormatException e) {
					System.out.println("Please enter an Integer value!");
					break;
				}
				c.removeStudent(id);
				break;
			case "3":
				System.out.print("Enter ID: ");
				try {
					id = Integer.parseInt(sc.nextLine());
				} catch(NumberFormatException e) {
					System.out.println("Please enter an Integer value!");
					break;
				}
				
				System.out.print("Enter Name: ");
				name = sc.nextLine();
				
				System.out.print("Enter Password: ");
				password = sc.nextLine();
				
				c.addLibrarian(id, name, password);
				break;
			case "4":
				System.out.print("Enter ID: ");
				try {
					id = Integer.parseInt(sc.nextLine());
				} catch(NumberFormatException e) {
					System.out.println("Please enter an Integer value!");
					break;
				}
				c.removeLibrarian(0);
				break;
			case "5":
				System.out.print("Enter ID: ");
				try {
					id = Integer.parseInt(sc.nextLine());
				} catch(NumberFormatException e) {
					System.out.println("Please enter an Integer value!");
					break;
				}
				
				System.out.print("Enter Name: ");
				name = sc.nextLine();
				
				System.out.print("Enter Password: ");
				password = sc.nextLine();
				
				c.addAdmin(id, name, password);
				break;
			case "6":
				System.out.print("Enter ID: ");
				try {
					id = Integer.parseInt(sc.nextLine());
				} catch(NumberFormatException e) {
					System.out.println("Please enter an Integer value!");
					break;
				}
				c.removeAdmin(0);
				break;
			default:
				System.out.println("Please enter valid input!");
				break;
			}
			System.out.print("\nEnter your choice: ");
			choice = sc.nextLine();
		}while(!choice.equals("0"));
		c.saveCSV();
		System.out.println("Logged out...\n");
	}
	
	public static void librarianView() {
		System.out.println("1) Add Book");
		System.out.println("2) Delete Book");
		System.out.println("3) Issue Book");
		System.out.println("4) Return Book");
		System.out.println("5) View Books");
		System.out.println("6) View Issued Books");
		System.out.println("7) Search for Book");
		System.out.println("0) Save and Log out\n");
		
		controller c = new controller();
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter your choice: ");
		String choice = sc.nextLine();
		
		int id, bookId, studentId, availableQuantity, issuedQuantity;
		String name, authorName, email, password;
		do {
			switch(choice) {
			case "1":
				System.out.print("Enter book ID: ");
				try {
					bookId = Integer.parseInt(sc.nextLine());
				} catch(NumberFormatException e) {
					System.out.println("Please enter an Integer value!");
					break;
				}
				
				System.out.print("Enter book name: ");
				name = sc.nextLine();
				
				System.out.print("Enter author name: ");
				authorName = sc.nextLine();
				
				System.out.print("Enter available quantity: ");
				try {
					availableQuantity = Integer.parseInt(sc.nextLine());
					if(availableQuantity < 0) {
						System.out.println("Please enter a positive value!");
						break;
					}
				} catch(NumberFormatException e) {
					System.out.println("Please enter an Integer value!");
					break;
				}
				
				System.out.print("Enter issued quantity: ");
				try {
					issuedQuantity = Integer.parseInt(sc.nextLine());
					if(issuedQuantity < 0) {
						System.out.println("Please enter a positive value!");
						break;
					}
				} catch(NumberFormatException e) {
					System.out.println("Please enter an Integer value!");
					break;
				}
				c.addBook(bookId, name, authorName, availableQuantity, issuedQuantity);
				break;
			case "2":
				System.out.print("Enter book ID: ");
				try {
					id = Integer.parseInt(sc.nextLine());
				} catch(NumberFormatException e) {
					System.out.println("Please enter an Integer value!");
					break;
				}
				c.removeBook(id);
				break;
			case "3":
				System.out.print("Enter book ID: ");
				try {
					bookId = Integer.parseInt(sc.nextLine());
				} catch(NumberFormatException e) {
					System.out.println("Please enter an Integer value!");
					break;
				}
				
				System.out.print("Enter student ID: ");
				try {
					studentId = Integer.parseInt(sc.nextLine());
				} catch(NumberFormatException e) {
					System.out.println("Please enter an Integer value!");
					break;
				}
				c.issueBook(bookId, studentId);
				break;
			case "4":
				System.out.print("Enter procedure ID: ");
				try {
					id = Integer.parseInt(sc.nextLine());
				} catch(NumberFormatException e) {
					System.out.println("Please enter an Integer value!");
					break;
				}
				c.returnBook(id);
				break;
			case "5":
				c.viewBooks();
				break;
			case "6":
				c.viewIssuedBooks();
				break;
			case "7":
				System.out.print("Enter book ID / Name: ");
				name = sc.nextLine();
				c.searchBook(name);
				break;
			default:
				System.out.println("Please enter valid input!");
				break;
			}
			System.out.print("\nEnter your choice: ");
			choice = sc.nextLine();
		}while(!choice.equals("0"));
		c.saveCSV();
		System.out.println("Logged out...\n");
	}
}
