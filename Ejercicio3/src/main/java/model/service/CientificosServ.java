package model.service;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

import controller.CientificosController;
import model.dao.CientificosDao;
import model.dto.Cientificos;
import view.VentanaAsignar_a;

public class CientificosServ {

	private CientificosController cientificosController; 
	public static boolean consultaCientificos=false;
	public static boolean modificaCientificos=false;
	
	//Vinculación con el controlador principal
	public void setcientificosController(CientificosController cientificosController) {
		this.setController(cientificosController);		
	}

	//Validación de datos de registro antes de pasarlos al DAO
	public void validarRegistro(Cientificos miCientificos, VentanaAsignar_a ventanaAsignar_a) {
		
		CientificosDao miCientificosDao;
		
		if (miCientificos.getDni().length() == 9) {
			miCientificosDao = new CientificosDao();
			miCientificosDao.registrarCientificos(miCientificos);		
			ventanaAsignar_a.getTextDniCientifico().setModel(new DefaultComboBoxModel<Object>((new CientificosDao()).recogerDnisCientificos()));		
		} else {
			JOptionPane.showMessageDialog(null, "El dni de los cientificos deben ser de 9 digitos", "Advertencia", JOptionPane.WARNING_MESSAGE);
		}
	}
	
	//Validación de datos de consulta antes de pasarlos al DAO
	public Cientificos validarConsulta(String dniCientificos) {
		
		CientificosDao miCientificosDao;
		
		try {
			String dni = dniCientificos;	
			if (dni.length() == 9) {
				miCientificosDao = new CientificosDao();
				consultaCientificos = true;
				return miCientificosDao.buscarCientificos(dni);						
			} else {
				JOptionPane.showMessageDialog(null, "El dni del cientificos debe ser de 9 digitos", "Advertencia", JOptionPane.WARNING_MESSAGE);
				consultaCientificos=false;
			}
			
		}
		catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Tienes que ingresar un dato numérico", "Error", JOptionPane.ERROR_MESSAGE);
			consultaCientificos=false;
		} 
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ha surgido un error", "Error", JOptionPane.ERROR_MESSAGE);
			consultaCientificos=false;
		}		
		return null;
	}

	//Validación de datos de modificación antes de pasarlos al DAO
	public void validarModificacion(Cientificos miCientificos) {
		
		CientificosDao miCientificosDao;
		
		if (miCientificos.getNomApels().length() > 2) {
			miCientificosDao = new CientificosDao();
			miCientificosDao.modificarCientificos(miCientificos);	
			modificaCientificos = true;
		} else {
			JOptionPane.showMessageDialog(null, "El nombre de los cientificos debe ser mayor a 2 letras", "Advertencia", JOptionPane.WARNING_MESSAGE);
			modificaCientificos=false;
		}
	}

	//Validación de datos de eliminación antes de pasarlos al DAO
	public void validarEliminacion(String codigo, VentanaAsignar_a ventanaAsignar_a) {
		CientificosDao miCientificosDao = new CientificosDao();
		miCientificosDao.eliminarCientificos(codigo);
		ventanaAsignar_a.getTextDniCientifico().setModel(new DefaultComboBoxModel<Object>((new CientificosDao()).recogerDnisCientificos()));
	}

	public CientificosController getCientificosController() {
		return cientificosController;
	}

	public void setController(CientificosController cientificosController) {
		this.cientificosController = cientificosController;
	}
}