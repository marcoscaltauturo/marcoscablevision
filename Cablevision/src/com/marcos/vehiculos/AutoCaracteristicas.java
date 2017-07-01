package com.marcos.vehiculos;

import com.marcos.vehiculos.interfaces.IAuto;

public abstract class AutoCaracteristicas implements IAuto{
	
	private IAuto auto;
	
	public AutoCaracteristicas(IAuto auto){
		this.setAuto(auto);
	}
	public IAuto getAuto() {
		return auto;
	}
	public void setAuto(IAuto auto) {
		this.auto = auto;
	}

}
