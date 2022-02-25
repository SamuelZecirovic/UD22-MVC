package model.service;

import javax.swing.JOptionPane;

import controller.Asignado_AController;
import model.dao.Asignado_ADao;
import model.dto.Asignado_A;

public class Asignado_AServ {

	private Asignado_AController asignado_aController; 
	public static boolean assignarAsignado_a = false;
	
	//Vinculación con el controlador principal
	public void setasignado_aController(Asignado_AController asignado_aController) {
		this.setController(asignado_aController);		
	}

	//Validación de datos de consulta antes de pasarlos al DAO
	public void validarAsignacion(Asignado_A miAsignado_A) {
		
		Asignado_ADao miAsignado_ADao;
		
		try {
			miAsignado_ADao = new Asignado_ADao();
			assignarAsignado_a = true;
			miAsignado_ADao.asignarCientificoProyecto(miAsignado_A);		
		}
		catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Tienes que ingresar un dato numérico", "Error", JOptionPane.ERROR_MESSAGE);
			assignarAsignado_a = false;
		} 
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ha surgido un error", "Error", JOptionPane.ERROR_MESSAGE);
			assignarAsignado_a = false;
		}
	}

	public Asignado_AController getAsignado_aController() {
		return asignado_aController;
	}

	public void setController(Asignado_AController asignado_aController) {
		this.asignado_aController = asignado_aController;
	}
}