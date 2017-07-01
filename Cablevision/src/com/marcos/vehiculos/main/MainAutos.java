package com.marcos.vehiculos.main;

import com.marcos.vehiculos.Coupe;
import com.marcos.vehiculos.Familiar;
import com.marcos.vehiculos.Sedan;
import com.marcos.vehiculos.caracteristicas.AireAcondicionado;
import com.marcos.vehiculos.caracteristicas.Frenos;
import com.marcos.vehiculos.caracteristicas.Llantas;
import com.marcos.vehiculos.caracteristicas.Techo;
import com.marcos.vehiculos.interfaces.IAuto;

public class MainAutos {

	
	
	public static void main(String[] args) {
		
		IAuto auto = new Familiar();
		System.out.println("Descripcion: " + auto.getDescripcion());
		System.out.println("Precio Final: " + auto.getPrecio());
		
		auto = new Coupe();
		auto=new Techo(auto);
		auto=new AireAcondicionado(auto);
		auto=new Llantas(auto);
		auto=new Frenos(auto);
		
		System.out.println("Descripcion: " + auto.getDescripcion());
		System.out.println("Precio Final: " + auto.getPrecio());
		
		auto = new Sedan();
		auto=new AireAcondicionado(auto);
		auto=new Llantas(auto);
		System.out.println("Descripcion: " + auto.getDescripcion());
		System.out.println("Precio Final: " + auto.getPrecio());

	}
}
