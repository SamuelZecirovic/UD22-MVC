package controller;

import model.dto.Proyecto;
import model.service.ProyectoServ;
import view.VentanaBuscarProyecto;
import view.VentanaPrincipal;
import view.VentanaRegistroProyecto;

public class ProyectoController {
	
	private ProyectoServ proyectoServ;
	private Asignado_AController asignado_aController;
	private VentanaPrincipal miVentanaPrincipal;
	private VentanaRegistroProyecto miVentanaRegistroProyecto;
	private VentanaBuscarProyecto miVentanaBuscarProyecto;
	
	//Metodos getter Setters de vistas
	public VentanaPrincipal getMiVentanaPrincipal() {
		return miVentanaPrincipal;
	}
	
	public void setMiVentanaPrincipal(VentanaPrincipal miVentanaPrincipal) {
		this.miVentanaPrincipal = miVentanaPrincipal;
	}
	
	public VentanaRegistroProyecto getMiVentanaRegistroProyecto() {
		return miVentanaRegistroProyecto;
	}
	
	public void setMiVentanaRegistroProyecto(VentanaRegistroProyecto miVentanaRegistro) {
		this.miVentanaRegistroProyecto = miVentanaRegistro;
	}
	
	public VentanaBuscarProyecto getMiVentanaBuscarProyecto() {
		return miVentanaBuscarProyecto;
	}
	
	public void setMiVentanaBuscarProyecto(VentanaBuscarProyecto miVentanaBuscarProyecto) {
		this.miVentanaBuscarProyecto = miVentanaBuscarProyecto;
	}
	
	public ProyectoServ getProyectoServ() {
		return proyectoServ;
	}
	
	public void setProyectoServ(ProyectoServ proyectoServ) {
		this.proyectoServ = proyectoServ;
	}
	
	//Hace visible las vistas de Consulta y Registro
	public void mostrarVentanaRegistroProyecto() {
		miVentanaRegistroProyecto.setVisible(true);
	}
	
	public void mostrarVentanaConsultaProyecto() {
		miVentanaBuscarProyecto.setVisible(true);
	}
	
	//Validación de datos de las vistas y llamadas a los metodos CRUD
	public void registrarProyecto(Proyecto miProyecto) {
		proyectoServ.validarRegistro(miProyecto, asignado_aController.getMiVentanaAsignar_A());
	}
	
	public Proyecto buscarProyecto(String codigoProyecto) {
		return proyectoServ.validarConsulta(codigoProyecto);
	}
	
	public void modificarProyecto(Proyecto miProyecto) {
		proyectoServ.validarModificacion(miProyecto);
	}
	
	public void eliminarProyecto(String codigo) {
		proyectoServ.validarEliminacion(codigo, asignado_aController.getMiVentanaAsignar_A());
	}
	
	public void setAsignado_AController(Asignado_AController asignado_aController) {
		this.asignado_aController = asignado_aController;
	}
}
