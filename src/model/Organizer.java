package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Organizer {
	
	public final static String PATH ="./data/FligthsRegister.txt";
	
	private ArrayList <Flight> fligths;
	private Flight [] showfligths;
	
	public Organizer () {
		fligths = new ArrayList<Flight>();
	}
	public void loadFIle() throws IOException {
		FileReader r = new FileReader(PATH);
		BufferedReader b = new BufferedReader(r);
		String  f = null ;
		while(b.readLine()!= null) {
			f=b.readLine();
				fligths.add(new Flight(f,"Ramdom",fligths.size(),0, Date.dateTurning()));
				//fligths.add(new Flight(f[0],f[1],Integer.parseInt(f[2]),Integer.parseInt(f[3]),Integer.parseInt(f[4]),Date.dateTurning(f[5])));
		}
	}
	public void generateList(int r) {
		showfligths = new Flight[r]; 
		for (int i=0;i<showfligths.length-1;i++) {
			showfligths[i] = fligths.get(i);
		}
	}
}
