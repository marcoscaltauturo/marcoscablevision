package com.marcos.vehiculos;

import com.marcos.vehiculos.constantes.VehiculoConstantes;

public class Sedan extends Auto{

	@Override
	public String getDescripcion() {
		return "Auto Sedan";
	}

	@Override
	public int getPrecio() {
		return VehiculoConstantes.PRECIO_BASICO_SEDAN;
	}

}
