package application;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.Flight;
import model.Organizer;

public class FlightOrganizerController implements Initializable{
	
	private Organizer organizer;


    @FXML
    private TableView<Flight[]> tableOfFlights;

    @FXML
    private ComboBox<String> searchBox;

    @FXML
    private ComboBox<String> sortBox;

    @FXML
    private TextField listTextField;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		organizer = new Organizer();
	}
	
	public void generatorButton() {
	}
	
	public void sortByName() {
	}
	
	public void sortByDate() {
	}
	
	public void sortBySerialNumber() {
	}
	
	public void sortByHour() {
	}
	

}
