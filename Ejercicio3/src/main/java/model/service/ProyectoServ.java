package model.service;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

import controller.ProyectoController;
import model.dao.ProyectoDao;
import model.dto.Proyecto;
import view.VentanaAsignar_a;

public class ProyectoServ {

	private ProyectoController proyectoController; 
	public static boolean consultaProyecto=false;
	public static boolean modificaProyecto=false;
	
	//Vinculación con el controlador principal
	public void setproyectoController(ProyectoController proyectoController) {
		this.setController(proyectoController);		
	}

	//Validación de datos de registro antes de pasarlos al DAO
	public void validarRegistro(Proyecto miProyecto, VentanaAsignar_a ventanaAsignar_a) {
		
		ProyectoDao miProyectoDao;
		
		if (miProyecto.getId().length() == 4) {
			miProyectoDao = new ProyectoDao();
			miProyectoDao.registrarProyecto(miProyecto);						
			ventanaAsignar_a.getTextProyecto().setModel(new DefaultComboBoxModel<Object>((new ProyectoDao()).recogerIdsProyectos()));	
		} else {
			JOptionPane.showMessageDialog(null, "El codigo del proyecto debe ser de 4 digitos", "Advertencia", JOptionPane.WARNING_MESSAGE);
		}
	}
	
	//Validación de datos de consulta antes de pasarlos al DAO
	public Proyecto validarConsulta(String codigoProyecto) {
		
		ProyectoDao miProyectoDao;
		
		try {
			String codigo = codigoProyecto;	
			if (codigo.length() == 4) {
				miProyectoDao = new ProyectoDao();
				consultaProyecto=true;
				return miProyectoDao.buscarProyecto(codigo);						
			} else {
				JOptionPane.showMessageDialog(null, "El codigo del proyecto debe ser de 4 digitos", "Advertencia", JOptionPane.WARNING_MESSAGE);
				consultaProyecto=false;
			}
		}
		catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Tienes que ingresar un dato numérico", "Error", JOptionPane.ERROR_MESSAGE);
			consultaProyecto=false;
		} 
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ha surgido un error", "Error", JOptionPane.ERROR_MESSAGE);
			consultaProyecto=false;
		}	
		return null;
	}

	//Validación de datos de modificación antes de pasarlos al DAO
	public void validarModificacion(Proyecto miProyecto) {
		
		ProyectoDao miProyectoDao;
		
		if (miProyecto.getNombre().length() > 5) {
			miProyectoDao = new ProyectoDao();
			miProyectoDao.modificarProyecto(miProyecto);	
			modificaProyecto = true;
		} else {
			JOptionPane.showMessageDialog(null, "El nombre de los proyecto debe ser mayor a 5 digitos", "Advertencia", JOptionPane.WARNING_MESSAGE);
			modificaProyecto = false;
		}
	}

	//Validación de datos de eliminación antes de pasarlos al DAO
	public void validarEliminacion(String codigo, VentanaAsignar_a ventanaAsignar_a) {
		ProyectoDao miProyectoDao = new ProyectoDao();
		miProyectoDao.eliminarProyecto(codigo);
		ventanaAsignar_a.getTextProyecto().setModel(new DefaultComboBoxModel<Object>((new ProyectoDao()).recogerIdsProyectos()));	
	}
	
	public ProyectoController getProyectoController() {
		return proyectoController;
	}

	public void setController(ProyectoController proyectoController) {
		this.proyectoController = proyectoController;
	}
}
