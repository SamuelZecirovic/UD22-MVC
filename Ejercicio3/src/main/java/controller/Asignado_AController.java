package controller;

import model.dto.Asignado_A;
import model.service.Asignado_AServ;
import view.VentanaAsignar_a;
import view.VentanaPrincipal;

public class Asignado_AController {
	
	private Asignado_AServ asignado_aServ;
	private VentanaPrincipal miVentanaPrincipal;
	private VentanaAsignar_a miVentanaAsignar_A;
	
	public String test = "test";
	
	//Metodos getter Setters de vistas
	public VentanaPrincipal getMiVentanaPrincipal() {
		return miVentanaPrincipal;
	}
	
	public void setMiVentanaPrincipal(VentanaPrincipal miVentanaPrincipal) {
		this.miVentanaPrincipal = miVentanaPrincipal;
	}
	
	public Asignado_AServ getAsignado_aServ() {
		return asignado_aServ;
	}

	public void setAsignado_aServ(Asignado_AServ asignado_aServ) {
		this.asignado_aServ = asignado_aServ;
	}

	public VentanaAsignar_a getMiVentanaAsignar_A() {
		return miVentanaAsignar_A;
	}

	public void setMiVentanaAsignar_A(VentanaAsignar_a miVentanaAsignar_A) {
		this.miVentanaAsignar_A = miVentanaAsignar_A;
	}

	//Da visibilidad a las vistas Consulta y Registro
	public void mostrarVentanaAsignarCientificos() {
		miVentanaAsignar_A.setVisible(true);
	}
	
	//Validación de datos de las vistas y llamadas a los metodos CRUD
	public void asignarCientificoProyecto(Asignado_A miAsignado_A) {
		asignado_aServ.validarAsignacion(miAsignado_A);
	}
}
