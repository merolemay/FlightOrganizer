package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Organizer {
	
	public final static String PATH_PLANENAMES ="./data/planenames.txt";
	public final static String PATH_AIRLINES ="./data/airlinesnames.txt";
	public final static String PATH_CITYESDESTINATIONS ="./data/destinationsname.txt";
	
	private ArrayList <Flight> fligths;
	private Flight [] showfligths;
	
	public Organizer () {
		fligths = new ArrayList<Flight>();
	}
	
	public Flight[] getShowfligths() {
		return showfligths;
	}
	public ArrayList<Flight> getFligths() {
		return fligths;
	}
	public void loadFIle() throws IOException {
		FileReader x = new FileReader(PATH_PLANENAMES);
		FileReader y = new FileReader( PATH_AIRLINES);
		FileReader z = new FileReader(PATH_CITYESDESTINATIONS);
		BufferedReader a = new BufferedReader(x);
		BufferedReader b = new BufferedReader(y);
		BufferedReader c = new BufferedReader(z);
		String  f = "";
		String m ="";
		String q="";
		while(a.readLine()!= null && b.readLine()!= null && c.readLine()!= null) {
			f=a.readLine();
			m=b.readLine();
			q=c.readLine();
			fligths.add(new Flight(f,m,fligths.size()+1, q));
		}
		a.close();
		b.close();
		c.close();
	}
	public Flight[] generateList(int r) {
		showfligths = new Flight[r]; 
		for (int i=0;i<showfligths.length-1;i++) {
			showfligths[i] = fligths.get(i);
		}
		return showfligths;
	}
	
	public static void InsercionAirplaneNames(Flight[] vector) {
	      for (int i=1; i < vector.length; i++) {
	         Flight aux = vector[i];
	         int j;
	         for (j=i-1; j >=0 && vector[j].compareTo(aux)>1; j--){
	              vector[j+1] = vector[j];
	          }
	         vector[j+1] = aux;
	      }
	   }
	
	public static void Seleccion(Flight[]matrix){
        int i, k, p, limit = matrix.length-1;
		Flight buffer;
        for(k = 0; k < limit; k++){
            p = k;
            for(i = k+1; i <= limit; i++){
                if(true ) 
                	p = i;
                if(p != k){
                    buffer = matrix[p];
                    matrix[p] = matrix[k];
                    matrix[k] = buffer;
                }
            }
        }
    }
	public static void burbuja(int[]matrix){
        int temp;
        for(int i=1;i < matrix.length;i++){
            for (int j=0 ; j < matrix.length- 1; j++){
                if (matrix[j] > matrix[j+1]){
                    temp = matrix[j];
                    matrix[j] = matrix[j+1];
                    matrix[j+1] = temp;
                }
            }
        }
    }
}