package com.marcos.cablevision.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.marcos.cablevision.entities.IEntity;

public abstract class AbstractDAO {
	protected Session sesion;
	protected Transaction tx;

	public long save(IEntity entity) throws HibernateException {
		long id = 0;
		try {
			obtenerConexion();
			id = (Long) sesion.save(entity);
			tx.commit();
		} catch (HibernateException he) {
			callRollback(he);
			throw he;
		} finally {
			sesion.close();
		}

		return id;
	}

	public void update(IEntity entity) throws HibernateException {
		try {
			obtenerConexion();
			sesion.update(entity);
			tx.commit();
		} catch (HibernateException he) {
			callRollback(he);
			throw he;
		} finally {
			sesion.close();
		}
	}

	public void delete(IEntity entity) throws HibernateException {
		try {
			obtenerConexion();
			sesion.delete(entity);
			tx.commit();
		} catch (HibernateException he) {
			callRollback(he);
			throw he;
		} finally {
			sesion.close();
		}
	}

	public abstract IEntity getById(long id) throws HibernateException;

	protected void obtenerConexion() throws HibernateException {
		sesion = DBConnection.getSessionFactory().openSession();
		tx = sesion.beginTransaction();
	}

	protected void callRollback(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("Ocurrió un error en la capa de acceso a datos", he);
	}

}
