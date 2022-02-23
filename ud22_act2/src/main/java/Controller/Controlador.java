package Controller;

import java.awt.EventQueue;

import javax.swing.JOptionPane;

import Model.Modelo;
import Vistas.Crear_video;
import Vistas.Create_Cliente;
import Vistas.Seleccion;

public class Controlador {

	public static void ventanaseleccion() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Seleccion frame = new Seleccion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void ventanacrearCliente(String tabla) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Create_Cliente frame = new Create_Cliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void ventanacrearVideo(String tabla) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Crear_video frame = new Crear_video();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void setdatos() {
		
    	Modelo.openConnection();
		Modelo.deleteDB();
		Modelo.createDB();
		Modelo.createTableCliente();
		Modelo.createTableVideos();
		Modelo.insertDataCliente();
		Modelo.insertCliente(100,"nombre100","apellido100","direccion100","10011111","2100-10-10");
		Modelo.insertDataVideos();
		Modelo.insertVideos(100,"titulo100","director100",100);
		//Modelo.UpdateDataClientes(100, "nombre101","apellido100","direccion100","10011111","2100-10-10");
		//Modelo.UpdateDataVideos(100, "t100","d100" , 1);
		//Modelo.getValuesCliente();
		//Modelo.getValuesvideos();
		Modelo.closeConnection();
	}
	
	public static void getdatos(String tabla) {

		switch (tabla) {
		case "cliente":
				Modelo.openConnection();
				Modelo.getValuesCliente();
				Modelo.closeConnection();
			break;
			
		case "videos":
				Modelo.openConnection();
				Modelo.getValuesvideos();
				Modelo.closeConnection();
			break;

		default:
				JOptionPane.showMessageDialog(null, "la tabla no existe");
			break;
		}
		
	}
	
	public static void nextvista(String tabla) {

		switch (tabla) {
		case "cliente":
				ventanacrearCliente(tabla);
			break;
			
		case "videos":
				ventanacrearVideo(tabla);
			break;

		default:
				JOptionPane.showMessageDialog(null, "la tabla no existe");
			break;
		}
		
	}
	
	public static void crearCliente(int id,String nombre,String apellido,String direccion,String dni,String fecha) {
		Modelo.openConnection();
		Modelo.insertCliente(id,nombre,apellido,direccion,dni,fecha);
		Modelo.closeConnection();
	}
	
	public static void crearVideos(int id,String titulo,String director,int id2) {
		Modelo.openConnection();
		Modelo.insertVideos(id,titulo,director,id2);
		Modelo.closeConnection();
	}
	
	public static void editarCliente(int id,String nombre,String apellido,String direccion,String dni,String fecha) {
		Modelo.openConnection();
		Modelo.UpdateDataClientes(id,nombre,apellido,direccion,dni,fecha);
		Modelo.closeConnection();
	}
	
	public static void editarVideos(int id,String titulo,String director,int id2) {
		Modelo.openConnection();
		Modelo.UpdateDataVideos(id,titulo,director,id2);
		Modelo.closeConnection();
	}
	
	public static void eliminarCliente(int id) {
		Modelo.openConnection();
		Modelo.deleteRecord("cliente",id);
		Modelo.closeConnection();
	}
	
	public static void eliminarVideo(int id) {
		Modelo.openConnection();
		Modelo.deleteRecord("videos",id);
		Modelo.closeConnection();
	}
	
	
}
