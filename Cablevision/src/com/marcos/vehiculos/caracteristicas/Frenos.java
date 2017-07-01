package com.marcos.vehiculos.caracteristicas;

import com.marcos.vehiculos.AutoCaracteristicas;
import com.marcos.vehiculos.constantes.VehiculoConstantes;
import com.marcos.vehiculos.interfaces.IAuto;

public class Frenos extends AutoCaracteristicas{

	public Frenos(IAuto auto) {
		super(auto);
	}

	@Override
	public String getDescripcion() {
		return getAuto().getDescripcion() + " + " + VehiculoConstantes.CARACTERISTICA_FRENOS;
	}

	@Override
	public int getPrecio() {
		return getAuto().getPrecio()+VehiculoConstantes.PRECIO_FRENOS;
	}

}
