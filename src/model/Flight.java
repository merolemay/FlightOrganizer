package model;

import java.util.Comparator;

public class Flight implements Comparable <Flight>,Comparator<Flight> {
	
	private String flightname,airline, destination;
	private int serialNumber;
	private int hour;
	private Date date;
	
	public Flight(String flightname, String airline, int serialNumber, String destination) {
		this.flightname = flightname;
		this.airline = airline;
		this.destination=destination;
		this.serialNumber = serialNumber;
		hour = (int)(Math.random()* 12)+1;
		date = Date.dateTurning();
	}

	public String getFlightname() {
		return flightname;
	}

	public String getAirline() {
		return airline;
	}

	public int getSerialNumber() {
		return serialNumber;
	}

	public int getHour() {
		return hour;
	}

	public Date getDate() {
		return date;
	}
	public String getDestination() {
		return destination;
	}

	@Override
	public int compare(Flight f1, Flight f2) {
		int r=0;
		if(f1.getHour()==f2.getHour())
			r=0;
		else if(f1.getHour()>f2.getHour())
			r=1;
		else
			r=-1;
		
		return r;
	}

	@Override
	public int compareTo(Flight o) {
		return o.getSerialNumber()-serialNumber;
	}
}
