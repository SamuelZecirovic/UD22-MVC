package controller;

import model.dto.Cientificos;
import model.service.CientificosServ;
import view.VentanaBuscarCientificos;
import view.VentanaPrincipal;
import view.VentanaRegistroCientificos;

public class CientificosController {
	
	private CientificosServ cientificosServ;
	private Asignado_AController asignado_aController;
	private VentanaPrincipal miVentanaPrincipal;
	private VentanaRegistroCientificos miVentanaRegistroCientificos;
	private VentanaBuscarCientificos miVentanaBuscarCientificos;
	
	//Metodos getter Setters de vistas
	public VentanaPrincipal getMiVentanaPrincipal() {
		return miVentanaPrincipal;
	}
	
	public void setMiVentanaPrincipal(VentanaPrincipal miVentanaPrincipal) {
		this.miVentanaPrincipal = miVentanaPrincipal;
	}
	
	public VentanaRegistroCientificos getMiVentanaRegistroCientificos() {
		return miVentanaRegistroCientificos;
	}
	
	public void setMiVentanaRegistroCientificos(VentanaRegistroCientificos miVentanaRegistro) {
		this.miVentanaRegistroCientificos = miVentanaRegistro;
	}
	
	public VentanaBuscarCientificos getMiVentanaBuscarCientificos() {
		return miVentanaBuscarCientificos;
	}
	
	public void setMiVentanaBuscarCientificos(VentanaBuscarCientificos miVentanaBuscarCientificos) {
		this.miVentanaBuscarCientificos = miVentanaBuscarCientificos;
	}
	
	public CientificosServ getCientificosServ() {
		return cientificosServ;
	}
	
	public void setCientificosServ(CientificosServ cientificosServ) {
		this.cientificosServ = cientificosServ;
	}
	
	//Hace visible las vistas de Consulta y Registro
	public void mostrarVentanaRegistroCientificos() {
		miVentanaRegistroCientificos.setVisible(true);
	}
	
	public void mostrarVentanaConsultaCientificos() {
		miVentanaBuscarCientificos.setVisible(true);
	}
	
	//Validación de datos de las vistas y llamadas a los metodos CRUD
	public void registrarCientificos(Cientificos miCientificos) {
		cientificosServ.validarRegistro(miCientificos, asignado_aController.getMiVentanaAsignar_A());
	}
	
	public Cientificos buscarCientificos(String codigoCientificos) {
		return cientificosServ.validarConsulta(codigoCientificos);
	}
	
	public void modificarCientificos(Cientificos miCientificos) {
		cientificosServ.validarModificacion(miCientificos);
	}
	
	public void eliminarCientificos(String codigo) {
		cientificosServ.validarEliminacion(codigo, asignado_aController.getMiVentanaAsignar_A());
	}

	public void setAsignado_AController(Asignado_AController asignado_aController) {
		this.asignado_aController = asignado_aController;
	}
}
