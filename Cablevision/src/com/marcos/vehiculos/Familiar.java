package com.marcos.vehiculos;

import com.marcos.vehiculos.constantes.VehiculoConstantes;

public class Familiar extends Auto{

	@Override
	public String getDescripcion() {
		return "Auto Familiar";
	}

	@Override
	public int getPrecio() {
		return VehiculoConstantes.PRECIO_BASICO_FAMILIAR;
	}
}
