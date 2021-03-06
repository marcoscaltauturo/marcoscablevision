package com.marcos.vehiculos.caracteristicas;

import com.marcos.vehiculos.AutoCaracteristicas;
import com.marcos.vehiculos.constantes.VehiculoConstantes;
import com.marcos.vehiculos.interfaces.IAuto;

public class Llantas extends AutoCaracteristicas{

	public Llantas(IAuto auto) {
		super(auto);
	}

	@Override
	public String getDescripcion() {
		return getAuto().getDescripcion() + " + " + VehiculoConstantes.CARACTERISTICA_LLANTAS;
	}

	@Override
	public int getPrecio() {
		return getAuto().getPrecio()+VehiculoConstantes.PRECIO_LLANTAS;
	}

}
