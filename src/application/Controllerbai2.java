package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;

public class Controllerbai2 implements Initializable {
    @FXML
    private ComboBox<String> comboB;

	 private Connection connect;
	 private PreparedStatement prepare;
	 private ResultSet result;
	 
	 public void combobox() throws ClassNotFoundException {
		 String selectAllData ="SELECT * FROM combobox";
	     connect = database.connectDb();
	  try {
		prepare = connect.prepareStatement(selectAllData);
		result = prepare.executeQuery();
		
		
		ObservableList  listData =FXCollections.observableArrayList();
		
		while(result.next()) {
		String item = result.getString("name");
		listData.add(item);
		}
		
		comboB.setItems(listData);
		

	} catch (Exception e) {
	   e.printStackTrace();
	}
	 }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		try {
			combobox();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
