package com.marcos.cablevision.main;

import com.marcos.cablevision.dao.DBConnection;
import com.marcos.cablevision.dao.PrecioDAO;
import com.marcos.cablevision.entities.Automovil;
import com.marcos.cablevision.entities.Precio;
import com.marcos.cablevision.utils.AutomovilUtil;

public class TestMain {
	public static void main(String[] args) {
		TestMain testMain = new TestMain();
		testMain.addPrecios();
		AutomovilUtil automovilUtil= new AutomovilUtil();
		Automovil nuevoAuto=new Automovil("COUPE");
		nuevoAuto.getListaOpcionales().add("TC");
		automovilUtil.crearAuto(nuevoAuto);
		
		nuevoAuto=new Automovil("COUPE");
		nuevoAuto.getListaOpcionales().add("LL");
		automovilUtil.crearAuto(nuevoAuto);
		for (String precio : nuevoAuto.getListaOpcionales()) {
			System.out.println(precio);
		}

		for(Automovil auto: automovilUtil.listarAutomoviles()){
			System.out.println(auto);
		}
		
		nuevoAuto=automovilUtil.obtenerAutoPorId(1);
		nuevoAuto.getListaOpcionales().remove("TC");
		nuevoAuto.getListaOpcionales().add("AA");
		for (String precio : nuevoAuto.getListaOpcionales()) {
			System.out.println(precio);
		}
		automovilUtil.updateAuto(nuevoAuto);
		for(Automovil auto: automovilUtil.listarAutomoviles()){
			System.out.println(auto);
		}
		
		DBConnection.getSessionFactory().close();
	}

	private void addPrecios() {
		Precio precioSedan = new Precio("SEDAN", 230000);
		Precio precioFamiliar = new Precio("FAMILIAR", 245000);
		Precio precioCoupe = new Precio("COUPE", 270000);
		Precio precioTC = new Precio("TC", 12000);
		Precio precioAA = new Precio("AA", 20000);
		Precio precioABS = new Precio("ABS", 14000);
		Precio precioAB = new Precio("AB", 7000);
		Precio precioLL = new Precio("LL", 12000);

		PrecioDAO precioDAO = new PrecioDAO();
		precioDAO.savePrecio(precioSedan);
		precioDAO.savePrecio(precioFamiliar);
		precioDAO.savePrecio(precioCoupe);
		precioDAO.savePrecio(precioTC);
		precioDAO.savePrecio(precioAA);
		precioDAO.savePrecio(precioABS);
		precioDAO.savePrecio(precioAB);
		precioDAO.savePrecio(precioLL);
	}
}
