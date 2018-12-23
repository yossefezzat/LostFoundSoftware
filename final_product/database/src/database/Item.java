package database;

import java.util.ArrayList;

public class Item {

	private Integer id;
	private String description;
	private String location;
	private ArrayList<String> listofquestions;
	private String image;
	private String date;
	private String Answers;

	Item() {

	}

	Item(Integer id, String d, String l, ArrayList<String> l_of_qes, String image, String date) {

		this.id = id;
		this.description = d;
		this.location = l;
		this.listofquestions = l_of_qes;
		this.image = image;
		this.date = date;

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public ArrayList<String> getListofquestions() {
		return listofquestions;
	}

	public void setListofquestions(ArrayList<String> listofquestions) {
		this.listofquestions = listofquestions;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getAnswers() {
		return Answers;
	}

	public void setAnswers(String answers) {
		Answers = answers;
	}
}
