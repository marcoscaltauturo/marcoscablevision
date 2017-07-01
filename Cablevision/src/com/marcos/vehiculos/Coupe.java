package com.marcos.vehiculos;

import com.marcos.vehiculos.constantes.VehiculoConstantes;

public class Coupe extends Auto{

	@Override
	public String getDescripcion() {
		return "Auto Coupe";
	}

	@Override
	public int getPrecio() {
		return VehiculoConstantes.PRECIO_BASICO_COUPE;
	}
}
