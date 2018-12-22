package database;

import java.sql.SQLException;
import java.util.ArrayList;

public class Controller{
	
	SQL sql = new SQL();
	
	public Integer getUserID(User user) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		
		sql.opendatabase();
		
		
		user.setId(sql.SearchUserbyEmail_Pw(user.getEmail() , user.getPassword()));
		
		sql.closedatabase();
		
		return user.getId();
		
	}

	public boolean login(String Email, String Password) {
		
		Boolean validate= false;
		
		try {
			sql.opendatabase();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			
		try {
			 validate = sql.SearchUser(Email, Password);
			 
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		if( validate == true) {
			return true;
		}
		else {
			return false;
		}

	}

	public boolean SignUp(String Email , String Password , String FirstName , String LastName ) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		sql.opendatabase();
		
		sql.CreateUser(Email, Password, FirstName, LastName);
		
		sql.closedatabase();
		
		return true;

	}
	
	public void logout() {
		try {
			sql.closedatabase();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
	public ArrayList<Item> Search(String des) throws SQLException{
		ArrayList<Item> items = sql.SearchItems(des);
		return items ; 
		
	}
	
	public void Posting(Item t) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		String list_Q = "";
		for(int i=0 ; i< t.getListofquestions().size() ; i++) {
			if(i != t.getListofquestions().size() -1)
				list_Q += t.getListofquestions().get(i) + "/";
			else
				list_Q += t.getListofquestions().get(i);
		}
		
		sql.opendatabase();
		
		sql.CreateItem(list_Q , t.getImage(), t.getDescription(), t.getLocation(), t.getDate() , t.getAnswers());
		
		sql.closedatabase();
	}
	
	public Item ChooseItem(Integer id) {
		
		/*  Choose from Table in the GUI  :)  */
		
		return null;
	}
	
	public void showdetails(Item t) {
		
		/*   In the GUI show the Details of this Item    */
		
	}
	
	public boolean CheckAnswers(Item item , String ans1 , String ans2 , String ans3) {
		
		String Temp = ans1 + "/" + ans2 + "/" + ans3 ; 
		System.out.println(Temp + "\n");
		System.out.println(item.getAnswers());
		if(item.getAnswers().equals(Temp))
			return true;
		
		return false;
		
	}
	
	public boolean ValidateLogin() {
		
		/*     */
		
		return false;
		
	}
	

}
