package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SQL {

	public Connection con;

	public void opendatabase()
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/softwareproject", "root", "root");
	}

	public void closedatabase() throws SQLException {
		con.close();
	}

	public Boolean CreateUser(String Email, String Password, String FirstName, String LastName) throws SQLException {

		String sql = "INSERT INTO user (Email , Password , FirstName , LastName) VALUES (?,?,?,?) ";

		PreparedStatement statement = con.prepareStatement(sql);
		statement.setString(1, Email);
		statement.setString(2, Password);
		statement.setString(3, FirstName);
		statement.setString(4, LastName);
		statement.executeUpdate();

		return true;

	}

	public Boolean SearchUser(String Em, String Pw) throws SQLException {

		// String query1 = "select Email from user ";
		String query2 = "SELECT Password FROM user WHERE Email=" + "'" + Em + "'";

		PreparedStatement statement2 = con.prepareStatement(query2);

		ResultSet result = null;

		result = statement2.executeQuery(query2);

		String pww = "pass";
		while (result.next()) {
			pww = result.getString("Password");
		}

		if (result.equals(null)) {
			return false;
		} else if (pww.equals(Pw))
			return true;
		else {
			return false;
		}

	}

	public Integer SearchUserbyEmail_Pw(String Em, String Pw) throws SQLException {

		// String query1 = "select Email from user ";
		String query2 = "SELECT id FROM user WHERE Email=" + "'" + Em + "'" + "AND Password =" + Pw;

		PreparedStatement statement2 = con.prepareStatement(query2);

		ResultSet result = null;

		result = statement2.executeQuery(query2);

		Integer id = null;
		while (result.next()) {
			id = result.getInt("id");
		}

		return id;
	}

	public ArrayList<Item> SearchItems(String description) throws SQLException {

		ArrayList<Item> items = new ArrayList<Item>();

		String query2 = "SELECT * FROM Item WHERE description=" + "'" + description + "'";

		PreparedStatement statement2 = con.prepareStatement(query2);

		ResultSet result = null;

		result = statement2.executeQuery(query2);

		String list = "";

		while (result.next()) {
			Item it = new Item();
			ArrayList<String> temp = new ArrayList<String>();
			it.setDescription(result.getString("description"));
			it.setDate(result.getString("date"));
			it.setId(Integer.parseInt(result.getString("id")));
			it.setImage(result.getString("image"));
			it.setLocation(result.getString("location"));
			it.setAnswers(result.getString("Answers"));
			list = result.getString("listofquestions");
			String[] questions = list.split("/");
			for (int j = 0; j < questions.length; j++) {
				temp.add(questions[j]);
			}

			it.setListofquestions(temp);
			items.add(it);
		}

		for (int i = 0; i < items.size(); i++) {
			System.out.println(
					items.get(i).getId() + "  " + items.get(i).getDescription() + "  " + items.get(i).getImage() + "  "
							+ items.get(i).getLocation() + "  " + items.get(i).getDate() + "  ");
		}

		return items;

	}

	public Boolean CreateItem(String list_Q, String image, String description, String location, String date,
			String Answers) throws SQLException {

		String sql = "INSERT INTO Item (listofquestions , location , description , date , image , Answers) VALUES (?,?,?,?,?,?) ";

		PreparedStatement statement = con.prepareStatement(sql);
		statement.setString(1, list_Q);
		statement.setString(2, location);
		statement.setString(3, description);
		statement.setString(4, date);
		statement.setString(5, image);
		statement.setString(6, Answers);
		statement.executeUpdate();

		return true;

	}

	public Item select_item(Integer id) throws SQLException {

		Item it = new Item();

		String query2 = "SELECT * FROM Item WHERE id =" + String.valueOf(id);

		PreparedStatement statement2 = con.prepareStatement(query2);

		ResultSet result = null;
		result = statement2.executeQuery(query2);

		while (result.next()) {
			it.setDescription(result.getString("description"));
			it.setDate(result.getString("date"));
			it.setId(Integer.parseInt(result.getString("id")));
			it.setImage(result.getString("image"));
			it.setLocation(result.getString("location"));
		}

		System.out.println(it.getId() + "  " + it.getDescription() + "  " + it.getImage() + "  " + it.getLocation()
				+ "  " + it.getDate() + "  ");

		return it;

	}

}
