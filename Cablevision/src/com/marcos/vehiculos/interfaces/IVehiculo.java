package com.marcos.vehiculos.interfaces;

public interface IVehiculo {

	public void addTechoCorredizo(String caracteristica,Integer precio);
	public void addAireAcondicionado(String caracteristica,Integer precio);
	public void addSistemaFrenos(String caracteristica,Integer precio);
	public void addAirbag(String caracteristica,Integer precio);
	public void addLlantasAleacion(String caracteristica,Integer precio);
	public void addCaracteristica(String caracteristica,Integer precio);
	public void mostrarCaracteristicas();
	public void calcularValor(); 
	
}
