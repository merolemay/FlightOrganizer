package application;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import model.Organizer;

public class FlightOrganizerController implements Initializable{
	private Organizer organizer;
	
    @FXML
    private TextField listTextField;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		organizer = new Organizer();
	}
	
	public void generatorButton() {
		try {
		int m = Integer.parseInt(listTextField.getText());
		organizer.generateList(m);
		} catch(NumberFormatException e) {
		JOptionPane.showMessageDialog(null, "You need to write a NUMBER");
		}
	}
	

}
