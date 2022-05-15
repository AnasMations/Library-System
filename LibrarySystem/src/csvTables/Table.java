package csvTables;
import java.util.ArrayList;

public class Table {
	
	private ArrayList<TableObj> table = new ArrayList<TableObj>();
	
	public ArrayList<TableObj> getTable(){
		return table;
	}
	
	public void add(TableObj otherObject) {
		// Add obj to ArrayList
		table.add(otherObject);
	}
	public void remove(int id) {
		// Delete obj from ArrayList using id
		table.remove(this.searchIndex(id));
		
	}
	public void viewAll() {
		// view all ArrayList in CLI
		int i=0;
		StringBuilder sb = new StringBuilder();
		while(i<table.size()) {
			sb.append(table.get(i).toString().replaceAll(",", " | "));
			sb.append("\n");
			i+=1;
		}
		System.out.println(sb);
	}
	
	public StringBuilder printAll() {
		// Print all ArrayList in CSV format
		int i=0;
		StringBuilder sb = new StringBuilder();
		while(i<table.size()) {
			sb.append(table.get(i).toString());
			sb.append("\n");
			i+=1;
		}
		return sb;
	}
	
	public int searchIndex(String name) {
		// Search for the index of specific obj using Name
		int i=0;
		while(i<table.size()) {
			if(name.equals(table.get(i).getName())) {
				break;
			}
			i+=1;
		}
		return i;
	}
	
	public int searchIndex(int id) {
		// Search for the index of specific obj using Id
		int i=0;
		while(i<table.size()) {
			if(id == table.get(i).getId()) {
				break;
			}
			i+=1;
		}
		return i;
	}
	
	public boolean idDoesExist(int id) {
		int i=0;
		while(i<table.size()) {
			if(id == table.get(i).getId()) {
				return true;
			}
			i+=1;
		}
		return false;
	}
	
	public boolean nameDoesExist(String name) {
		int i=0;
		while(i<table.size()) {
			if(name.equals(table.get(i).getName())) {
				return true;
			}
			i+=1;
		}
		return false;
	}
}
