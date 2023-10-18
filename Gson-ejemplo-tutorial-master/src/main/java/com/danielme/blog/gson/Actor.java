package com.danielme.blog.gson;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import com.google.gson.annotations.Since;
import com.google.gson.annotations.Until;




    



public class Actor
{
	
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	@Since(1.0)
	private String nombre;
	
	@Until(2.0)
	private Calendar fechaNacimiento;

	private String name;

	//Use @SerializedName to map the JSON attribute to the Java field
    
	@SerializedName("gender")
    private String sexCode;
	
	public Actor()
	{
		super();	
	}

	public Actor(String nombre, Calendar fechaNacimiento, String sexCode)
	{
		super();
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.sexCode = sexCode;
	}
	
	@Override
	public String toString()
	{
		return nombre + " (" + sdf.format(fechaNacimiento.getTime()) + ")"; 
	}
	

}