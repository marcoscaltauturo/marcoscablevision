package com.marcos.vehiculos.caracteristicas;

import com.marcos.vehiculos.AutoCaracteristicas;
import com.marcos.vehiculos.constantes.VehiculoConstantes;
import com.marcos.vehiculos.interfaces.IAuto;

public class AireAcondicionado extends AutoCaracteristicas{

	public AireAcondicionado(IAuto auto) {
		super(auto);
	}

	@Override
	public String getDescripcion() {
		return getAuto().getDescripcion() + " + " + VehiculoConstantes.CARACTERISTICA_AIRE;
	}

	@Override
	public int getPrecio() {
		return getAuto().getPrecio()+VehiculoConstantes.PRECIO_AIRE;
	}

}
