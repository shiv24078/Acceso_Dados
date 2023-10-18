package com.danielme.blog.gson;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Date;
import java.text.SimpleDateFormat;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Pelicula
{
	@Expose
	@SerializedName("p-titulo")
	private String titulo;
	
	@Expose
	@SerializedName("p-año")
	private short year;
	
	@SerializedName("p-direccion")
	private String directores;
	
	@SerializedName("p-duracion-minutos")
	private short duracion;
	
	private List<Actor> interpretes;

    private Date created_at;
	
	public Pelicula()
	{
		super();
	}

	public Pelicula(String titulo, short year, String directores, short duration, List<Actor> interpretes, Date created_at)
	{
		super();
		this.titulo = titulo;
		this.year = year;
		this.directores = directores;
		this.duracion = duration;
		this.interpretes = interpretes;
		this.created_at = created_at;
	}


	
	@Override
	public String toString()
	{
		String s = titulo +" (" + year + ")" + " de " + directores + ", " + duracion + " minutos. Interpretada por ";
		boolean first = true;
		for (Actor actor : interpretes)
		{
			if (first)
			{
				first = false;
			}
			else
			{
				s+=", ";
			}
			s+=actor.toString();
			
		}
		return s;		
	}
	
	// Getters y setters
	public String getTitulo()
	{
		return titulo;
	}
	public void setTitulo(String titulo)
	{
		this.titulo = titulo;
	}
	public Date getCreated_at()
	{
		return created_at;
	}
	public void setCreated_at(Date created_at)
	{
		this.created_at = created_at;
	}
}