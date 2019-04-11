package application;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
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
		try {
			organizer.loadFIle();
			organizer.generateList(10);
			System.out.println((organizer.getFligths()));
			this.showTable();
		} catch (IOException e) {
		}
	}
	
	public void generatorButton() {
		organizer.generateList(Integer.parseInt(listTextField.getText()));
		this.showTable();
	}
	
	public void sortByName() {
	}
	
	public void sortByDate() {
	}
	
	public void sortBySerialNumber() {
	}
	
	public void sortByHour() {
	}
	
	
	public void showTable() {

		ObservableList<Flight[]> data = null;
		data.add(organizer.getShowfligths());

		tableOfFlights.setEditable(true);
		tableOfFlights.setMinWidth(390);

		TableColumn airplanecol = new TableColumn("Airplane");
		airplanecol.setCellValueFactory(new PropertyValueFactory<Flight, String>("flightname"));
		airplanecol.setMinWidth(140);
		
		TableColumn airlinecol = new TableColumn("Airline");
		airlinecol.setCellValueFactory(new PropertyValueFactory<Flight, String>("airline"));
		airlinecol.setMinWidth(140);
		
		TableColumn destinatnionColo = new TableColumn("Destination");
		destinatnionColo.setCellValueFactory(new PropertyValueFactory<Flight, String>("destination"));
		destinatnionColo.setMinWidth(100);
		
		TableColumn serialNumberCol = new TableColumn("Serial Code");
		serialNumberCol.setCellValueFactory(new PropertyValueFactory<Flight, String>("serialNumber"));
		serialNumberCol.setMinWidth(100);

		TableColumn hourCol = new TableColumn("Flight Hour");
		hourCol.setCellValueFactory(new PropertyValueFactory<Flight, String>("hour"));
		hourCol.setMinWidth(100);
		
		TableColumn dateCol = new TableColumn("Date");
		dateCol.setCellValueFactory(new PropertyValueFactory<Flight, String>("date"));
		dateCol.setMinWidth(100);
		
		TableColumn gateCol = new TableColumn("Gate");
		gateCol.setCellValueFactory(new PropertyValueFactory<Flight, String>("gate"));
		gateCol.setMinWidth(100);
		
		tableOfFlights.setItems(data);
		tableOfFlights.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		tableOfFlights.getColumns().addAll(airplanecol, airlinecol, destinatnionColo,serialNumberCol,hourCol,dateCol,gateCol);
		
	}


}
