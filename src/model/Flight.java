package model;

import java.util.Comparator;

public class Flight implements Comparable <Flight>,Comparator<Flight> {
	
	private String flightname,airline, destination,hour,serialNumber,gate;
	private  Date date;
	
	
	public Flight(String flightname, String airline, int sj, String destination) {
		this.flightname = flightname;
		this.airline = airline;
		this.destination=destination;
		serialNumber = "B0F0"+sj;
		hour = setARamdonHour();
		date = Date.dateTurning();
		gate = "Gate:"+(int)(Math.random()* 6)+1;
	}

	public String getFlightname() {
		return flightname;
	}

	public String getAirline() {
		return airline;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public String getHour() {
		return hour;
	}

	public Date getDate() {
		return date;
	}
	public String getDestination() {
		return destination;
	}
	
	public String setARamdonHour() {
		int n=0;
		String ramdonhour="";
		n= (int)(Math.random()* 24)+1;
		if (n<12)
			ramdonhour = n+":AM";
		else if(n>12) {
			n-=12;
			ramdonhour = n+":PM";
		}
		return ramdonhour;	
	}

	@Override
	public int compare(Flight f1, Flight f2) {
		int r=0;
		if(f1.getSerialNumber()==f2.getSerialNumber())
			r=0;
		else if(f1.getSerialNumber().compareToIgnoreCase( f2.getSerialNumber())>1)
			r=1;
		else
			r=-1;
		
		return r;
	}
	public String toString() {
		String msj="Plane Name:"+flightname+" Aerline:"+airline+" Serialnumber:"+serialNumber+"\n";
		return msj;	
	}
	@Override
	public int compareTo(Flight o) {
		return o.getFlightname().compareTo(flightname);
	}

	public String getGate() {
		return gate;
	}
}
