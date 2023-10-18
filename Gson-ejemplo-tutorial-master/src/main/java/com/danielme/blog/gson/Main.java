package com.danielme.blog.gson;


import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * 
 * @author danielme.com
 * 
 */
public class Main
{
	
	
	public static void main(String[] args) 
	{	
		Actor tomhanks = new Actor("Tom Hanks", new GregorianCalendar(1956, 8, 9), "M");
		Actor halleberry = new Actor("Halle Berry", new GregorianCalendar(1966, 7, 14), "F");
		List<Actor> actores1 = new LinkedList<Actor>();
		actores1.add(tomhanks);
		actores1.add(halleberry);
		Pelicula pelicula1 = new Pelicula("El atlas de las nubes", (short) 2012, "Lana Wachowski, Tom Tykwer, Andy Wachowski", (short) 172, actores1, new GregorianCalendar(2012, 10, 26).getTime());
		
		Actor jesse = new Actor("Jesse Eisenberg", new GregorianCalendar(1983, 9, 5), "M");
		Actor andrew = new Actor("Andrew Garfield", new GregorianCalendar(1983, 7, 20), "M");
		List<Actor> actores2 = new LinkedList<Actor>();
		actores2.add(jesse);
		actores2.add(andrew);
		Pelicula pelicula2 = new Pelicula("La red social", (short) 2010, "David Fincher", (short) 120, actores2, new GregorianCalendar(2010, 10, 26).getTime());
		
		List<Pelicula> peliculas = new LinkedList<Pelicula>();
		peliculas.add(pelicula1);
		peliculas.add(pelicula2);
		
		GsonBuilder gsonBuilder = new GsonBuilder().serializeNulls().setPrettyPrinting();
		gsonBuilder.registerTypeAdapter(GregorianCalendar.class, new CalendarJsonSerializer());
		gsonBuilder.registerTypeAdapter(Calendar.class, new CalendarJsonSerializer());
		Gson gson = gsonBuilder.setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").create();
		
		
		String jsonString = gson.toJson(peliculas);

		//Save json string to file without using FileWriter or Files.write
		try {
			Files.write(Paths.get("peliculas.json"), jsonString.getBytes(StandardCharsets.UTF_8));
		} catch (IOException e) {
			e.printStackTrace();
		}
		

		System.out.println(jsonString);




		
		 
	    Pelicula[] peliculasJSON = gson.fromJson(jsonString, Pelicula[].class);	    
	    
	    for(Pelicula pelicula: peliculasJSON)
	    {
	    	System.out.println(pelicula.toString());
	    }		
  		
	}	

}