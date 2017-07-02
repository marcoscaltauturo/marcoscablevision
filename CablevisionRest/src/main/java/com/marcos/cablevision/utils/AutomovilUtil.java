package com.marcos.cablevision.utils;

import java.util.List;

import org.hibernate.HibernateException;

import com.marcos.cablevision.dao.AutomovilDAO;
import com.marcos.cablevision.dao.PrecioDAO;
import com.marcos.cablevision.entities.Automovil;

public class AutomovilUtil {

	private AutomovilDAO automovilDAO;
	private PrecioDAO precioDAO;

	public AutomovilUtil() {
		this.automovilDAO = new AutomovilDAO();
		this.precioDAO = new PrecioDAO();
	}

	public List<Automovil> listarAutomoviles() {
		List<Automovil> automovilList = automovilDAO.listarAutomoviles();
		return automovilList;
	}

	public List<Automovil> listaDeAutos() {
		return automovilDAO.listarAutomoviles();
	}

	public Automovil calcularPrecioAutomovil(Automovil auto) {
		Integer valorTotal = Integer.valueOf(0);
//		auto=fixCaracteristicas(auto);
		for (String caracteristica : auto.getListaOpcionales()) {
			valorTotal += this.precioDAO.getPrecio(caracteristica);
		}
		auto.setPrecioTotal(valorTotal);
		return auto;
	}

//	private Automovil fixCaracteristicas(Automovil auto) {
//		Set<String> auxSet=new HashSet<>();
//		Integer valorCaracteristica=Integer.valueOf(0);
//		for (String caracteristica : auto.getListaOpcionales()) {
//			valorCaracteristica=this.precioDAO.getPrecio(caracteristica);
//			if (valorCaracteristica==0){
//				caracteristica=this.precioDAO.getPrecioObject(caracteristica.getTipoCaracteristica());
//				auxSet.add(caracteristica);
//			}else{
//				auxSet.add(caracteristica);
//			}
//		}
//		auto.setListaOpcionales(auxSet);
//		return auto;
//
//	}

	public long crearAuto(Automovil auto) {
		auto.getListaOpcionales().add(auto.getNombre());
		auto=calcularPrecioAutomovil((auto));
		System.out.println("--------->" + auto);
		long idAuto = this.automovilDAO.save(auto);
		Automovil nuevoAuto = (Automovil) this.automovilDAO.getById(idAuto);
		System.out.println("Auto agregado: " + nuevoAuto.toString());
		return idAuto;
	}

	public Automovil obtenerAutoPorId(long idAuto) {
		Automovil nuevoAuto = null;
		try {
			nuevoAuto = (Automovil) this.automovilDAO.getById(idAuto);
		} catch (HibernateException he) {
			System.err.println("Error Recuperando Auto por ID");
		} catch (Exception ex) {
			System.err.println("Error Generico Recuperando Auto por ID");
		}
		return nuevoAuto;
	}

	public void updateAuto(Automovil auto) {
		auto=calcularPrecioAutomovil((auto));
		this.automovilDAO.update(auto);
	}

}
