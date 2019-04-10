package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Organizer {
	
	public final static String PATH_PLANENAMES ="./data/FligthsRegister.txt";
	public final static String PATH_AIRLINES ="./data/FligthsRegister.txt";
	public final static String PATH_CITYESDESTINATIONS ="./data/FligthsRegister.txt";
	
	private ArrayList <Flight> fligths;
	private Flight [] showfligths;
	
	public Organizer () {
		fligths = new ArrayList<Flight>();
	}
	public void loadFIle() throws IOException {
		FileReader r = new FileReader(PATH_PLANENAMES);
		BufferedReader b = new BufferedReader(r);
		String  f = null ;
		while(b.readLine()!= null) {
			f=b.readLine();
				fligths.add(new Flight(f,"Ramdom",fligths.size()+1, f));
		}
		b.close();
	}
	public void generateList(int r) {
		showfligths = new Flight[r]; 
		for (int i=0;i<showfligths.length-1;i++) {
			showfligths[i] = fligths.get(i);
		}
	}
	
	public static void Insercion (Flight[] vector) {
	      for (int i=1; i < vector.length; i++) {
	         Flight aux = vector[i];
	         int j;
	         for (j=i-1; j >=0 && (Integer.parseInt(vector[j].getFlightname()) ) > (Integer.parseInt(aux.getFlightname())); j--){
	              vector[j+1] = vector[j];
	          }
	         vector[j+1] = aux;
	      }
	   }
	
	public static void Seleccion(int[]matrix){
        int i, j, k, p, buffer, limit = matrix.length-1;
        for(k = 0; k < limit; k++){
            p = k;
            for(i = k+1; i <= limit; i++){
                if(matrix[i] < matrix[p]) p = i;
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