package com.marcos.cablevision.dao;

import java.util.List;

import org.hibernate.HibernateException;

import com.marcos.cablevision.entities.Automovil;
import com.marcos.cablevision.entities.IEntity;


public class AutomovilDAO extends AbstractDAO{

	@SuppressWarnings("unchecked")
	public List<Automovil> listarAutomoviles() throws HibernateException {
		List<Automovil> listaAutos= null;

		try {
			obtenerConexion();
			listaAutos = sesion.createQuery("from Automovil").list();
		} finally {
			sesion.close();
		}

		return listaAutos;
	}

	@Override
	public IEntity getById(long id) throws HibernateException {
		Automovil entity = null;
		try {
			obtenerConexion();
			entity = (Automovil) sesion.get(Automovil.class, id);
		} finally {
			sesion.close();
		}
		return entity;

	}



}
