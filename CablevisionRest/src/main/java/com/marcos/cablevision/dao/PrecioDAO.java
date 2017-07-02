package com.marcos.cablevision.dao;

import org.hibernate.HibernateException;

import com.marcos.cablevision.entities.IEntity;
import com.marcos.cablevision.entities.Precio;

public class PrecioDAO extends AbstractDAO {
	@Override
	public IEntity getById(long id) throws HibernateException {
		Precio entity = null;
		try {
			obtenerConexion();
			entity = (Precio) sesion.get(Precio.class, id);
		} finally {
			sesion.close();
		}
		return entity;
	}

	public Integer getPrecio(String precio) throws HibernateException {
		Precio entity = null;
		try {
			obtenerConexion();
			entity = (Precio) sesion.get(Precio.class, precio);
		} finally {
			sesion.close();
		}
		return entity != null ? entity.getPrecio() : Integer.valueOf(0);
	}
	
	public Precio getPrecioObject(String precio) throws HibernateException {
		Precio entity = null;
		try {
			obtenerConexion();
			entity = (Precio) sesion.get(Precio.class, precio);
		} finally {
			sesion.close();
		}
		return entity!=null?entity:new Precio("ValorDefecto",0);
	}
	public String savePrecio(IEntity entity) throws HibernateException {
		String id = "";
		try {
			obtenerConexion();
			id = (String) sesion.save(entity);
			tx.commit();
		} catch (HibernateException he) {
			callRollback(he);
			throw he;
		} finally {
			sesion.close();
		}

		return id;
	}


}
