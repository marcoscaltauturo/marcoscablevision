package com.marcos.cablevision.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.marcos.cablevision.entities.Automovil;
import com.marcos.cablevision.utils.AutomovilUtil;

@Path("/cablevision")
public class AutoServices {

	private AutomovilUtil automovilUtil = new AutomovilUtil();

	@GET
	@Path("/getAutoById/{idAuto}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAutoByID(@PathParam("param") long idAuto) {
		Automovil auto = automovilUtil.obtenerAutoPorId(idAuto);
		if (auto != null) {
			return Response.status(200).entity(auto).build();
		}
		return Response.status(500).entity("Auto no encontrado").build();
	}
	
	@GET
	@Path("/listarAutos")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarAutos() {
		List<Automovil> listaAutos = automovilUtil.listaDeAutos();
		if (listaAutos != null && listaAutos.size()>0) {
			return Response.status(200).entity(listaAutos).build();
		}
		return Response.status(500).entity("No Hay Autos").build();
	}
	
	@POST
	@Path("/actualizarAuto")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateAuto(Automovil auto) {
		if(auto!=null && auto.getId()>0){
			Automovil nuevoAuto = automovilUtil.obtenerAutoPorId(auto.getId());
			if (nuevoAuto != null) {
				return Response.status(200).entity(auto).build();
			}
			return Response.status(500).entity("Auto no guardado").build();	
		}else{
			return Response.status(Status.BAD_REQUEST).entity("Parametros Invalidos").build();
			
		}
	}
	
	@POST
	@Path("/crearAuto")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response crearAuto(Automovil auto) {
		if(auto!=null && auto.getId()>0){
			long idNuevoAuto = automovilUtil.crearAuto(auto);
			Automovil nuevoAuto = automovilUtil.obtenerAutoPorId(idNuevoAuto);
			if (nuevoAuto != null) {
				return Response.status(200).entity(nuevoAuto).build();
			}
			return Response.status(500).entity("Auto no guardado").build();	
		}else{
			return Response.status(Status.BAD_REQUEST).entity("Parametros Invalidos").build();
		}
	}
	
	@GET
	@Path("/eliminarAutoById/{idAuto}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response eliminarAutoByID(@PathParam("param") long idAuto) {
		Automovil auto = automovilUtil.obtenerAutoPorId(idAuto);
		if (auto != null) {
			automovilUtil.eliminarAuto(auto);
			return Response.status(200).entity(auto).build();
		}
		return Response.status(500).entity("Auto no encontrado").build();
	}


}
