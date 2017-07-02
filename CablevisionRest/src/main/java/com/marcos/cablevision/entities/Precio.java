package com.marcos.cablevision.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement()
@Entity
@Table(name="Precio")
public class Precio implements IEntity{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "tipoCaracteristica",unique=true,columnDefinition="VARCHAR(64)")
	private String tipoCaracteristica;
	
	private Integer precio;

	public Precio(){}
	public Precio(String nombre, Integer precio) {
		this.tipoCaracteristica = nombre;
		this.precio = precio;
	}
	public Precio(String nombre) {
		this.tipoCaracteristica = nombre;
		this.precio=Integer.valueOf(0);
	}

	public String getTipoCaracteristica() {
		return tipoCaracteristica;
	}

	public void setTipoCaracteristica(String tipoCaracteristica) {
		this.tipoCaracteristica = tipoCaracteristica;
	}

	public Integer getPrecio() {
		return precio;
	}

	public void setPrecio(Integer precio) {
		this.precio = precio;
	}
	@Override
	public String toString() {
		return "Precio [tipoCaracteristica=" + tipoCaracteristica + ", precio=" + precio + "]";
	}

}
