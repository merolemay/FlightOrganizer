package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Flight;
import model.Organizer;

public class FlightOrganizerController implements Initializable{

	private Organizer organizer;

    @FXML
    private TableView<Flight> tableOfFlights;

    @FXML
    private TextField listTextField;



	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		organizer = new Organizer();
		try {
			organizer.loadFile();
			showTable();
		} catch (IOException e) {
		}
		

		
	}
	
	public void generatorButton(ActionEvent a) {
		try {
		organizer.generateList(Integer.parseInt(listTextField.getText()));
		this.refreshTable();
		} catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null,"Only numbers please.");
		}
	}
	
	public void sortByPlaneName(ActionEvent e) {
		organizer.sortByPlane();
		this.refreshTable();
	}
	
	public void sortByDate() {
		organizer.sortByDate(organizer.getShowfligths());
		this.refreshTable();
	}
	public void sortByHour(ActionEvent e) {
		organizer.sortByHour(organizer.getShowfligths());
		this.refreshTable();
	}
	
	public void eraseList(ActionEvent a){
		tableOfFlights.getItems().clear();
	}
	
	public void sortBySerialNumber(ActionEvent a) {
		organizer.sortByserialNumber(organizer.getShowfligths());
		this.refreshTable();
	}
	
	public void sortByAirline(ActionEvent a) {
		organizer.sortByAirline(organizer.getShowfligths());
		this.refreshTable();
	}
	public void sortBygate(ActionEvent a) {

	}
	public void sortByDestinaition(ActionEvent a) {
	
	}
	
	
	public void refreshTable() {
		tableOfFlights.getItems().clear();
		ObservableList<Flight> data = FXCollections.observableArrayList(organizer.getShowfligths());
		tableOfFlights.setItems(data);
	}
	
	
	@SuppressWarnings("unchecked")
	public void showTable() {

		ObservableList<Flight> data = FXCollections.observableArrayList(organizer.getShowfligths());

		

		TableColumn<Flight, String> airplanecol = new TableColumn<Flight, String>("Airplane");
		airplanecol.setCellValueFactory(new PropertyValueFactory<Flight, String>("flightname"));
		airplanecol.setMinWidth(140);
		
		TableColumn<Flight, String> airlinecol = new TableColumn<Flight, String>("Airline");
		airlinecol.setCellValueFactory(new PropertyValueFactory<Flight, String>("airline"));
		airlinecol.setMinWidth(140);
		
		TableColumn<Flight, String> destinatnionColo = new TableColumn<Flight, String>("Destination");
		destinatnionColo.setCellValueFactory(new PropertyValueFactory<Flight, String>("destination"));
		destinatnionColo.setMinWidth(100);
		
		TableColumn<Flight, String> serialNumberCol = new TableColumn<Flight, String>("Serial Code");
		serialNumberCol.setCellValueFactory(new PropertyValueFactory<Flight, String>("serialNumber"));
		serialNumberCol.setMinWidth(100);

		TableColumn<Flight, String> hourCol = new TableColumn<Flight, String>("Flight Hour");
		hourCol.setCellValueFactory(new PropertyValueFactory<Flight, String>("hour"));
		hourCol.setMinWidth(100);
		
		TableColumn<Flight, String> dateCol = new TableColumn<Flight, String>("Date");
		dateCol.setCellValueFactory(new PropertyValueFactory<Flight, String>("date"));
		dateCol.setMinWidth(100);
		
		TableColumn<Flight, String> gateCol = new TableColumn<Flight, String>("Gate");
		gateCol.setCellValueFactory(new PropertyValueFactory<Flight, String>("gate"));
		gateCol.setMinWidth(100);
		
		tableOfFlights.setItems(data);
		tableOfFlights.getColumns().addAll(airplanecol, airlinecol, destinatnionColo,serialNumberCol,hourCol,dateCol,gateCol);
		
	}
}
