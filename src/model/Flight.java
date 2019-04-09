package model;

public class Flight {
	
	private String flightname,airline;
	private int serialNuber;
	private int hour;
	private Date date;
	
	public Flight(String flightname, String airline, int serialNuber, int hour, Date date) {
		this.flightname = flightname;
		this.airline = airline;
		this.serialNuber = serialNuber;
		hour = (int)(Math.random()* 12)+1;
		date = Date.dateTurning();
	}

	public String getFlightname() {
		return flightname;
	}

	public String getAirline() {
		return airline;
	}

	public int getSerialNuber() {
		return serialNuber;
	}

	public int getHour() {
		return hour;
	}

	public Date getDate() {
		return date;
	}
	
	
	

}
