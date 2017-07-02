package com.marcos.cablevision.entities;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnore;

@XmlRootElement
@Entity
@Table(name = "Automovil")
public class Automovil implements IEntity {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String nombre;

	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "AutomovilDetalle", joinColumns = @JoinColumn(name = "tipoCaracteristica") )
	@Column(name = "detalle")
	@JsonIgnore
	private Set<String> listaOpcionales = new HashSet<>();
	private Integer precioTotal = Integer.valueOf(0);

	public Integer getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(Integer precioTotal) {
		this.precioTotal = precioTotal;
	}

	public Automovil() {
	}

	public Automovil(String nombre, Set<String> opcionales) {
		this.nombre = nombre;
		this.listaOpcionales = opcionales;
	}

	public Automovil(String nombre) {
		this.nombre = nombre;
	}

	public Automovil(long id, String nombre, Set<String> listaOpcionales) {
		this.id = id;
		this.nombre = nombre;
		this.listaOpcionales = listaOpcionales;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<String> getListaOpcionales() {
		return listaOpcionales;
	}

	public void setListaOpcionales(Set<String> listaOpcionales) {
		this.listaOpcionales = listaOpcionales;
	}

	public void removeCaracteristica(String caracteristica) {
		try {
			this.listaOpcionales.remove(caracteristica);
		} catch (Exception ex) {
		}
	}
	
	public void addCaracteristica(String caracteristica) {
		try {
			this.listaOpcionales.add(caracteristica);
		} catch (Exception ex) {
		}

	}


	@Override
	public String toString() {
		return "Automovil [id=" + id + ", nombre=" + nombre + ", listaOpcionales=" + listaOpcionales + ", precioTotal="
				+ precioTotal + "]";
	}

}
