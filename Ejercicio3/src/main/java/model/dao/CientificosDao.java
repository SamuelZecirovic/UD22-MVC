package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.conexion.Conexion;
import model.dto.Cientificos;

public class CientificosDao {
	
	public void registrarCientificos(Cientificos miCientificos) {
		
		Conexion conexion = new Conexion();
		
		try {
			Statement stat = conexion.getConnection().createStatement();
			String sql= "INSERT INTO Cientificos VALUES ('" + miCientificos.getDni() + "', '" + miCientificos.getNomApels() + "');";
			stat.executeUpdate(sql);
			JOptionPane.showMessageDialog(null, "Se ha registrado correctamente", "Información", JOptionPane.INFORMATION_MESSAGE);
			System.out.println(sql);
			stat.close();
			conexion.desconectar();
		} 
		catch (SQLException e) {
            System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "No se registró");
		}
	}

	public Cientificos buscarCientificos(String dni) {
		
		Conexion conexion = new Conexion();
		Cientificos cientificos = new Cientificos();
		boolean existe = false;
		
		try {
			String sql= "SELECT * FROM Cientificos where DNI = ? ";
			PreparedStatement consulta = conexion.getConnection().prepareStatement(sql);
			consulta.setString(1, dni);
			ResultSet resultado = consulta.executeQuery();
			
			while(resultado.next()) {
				existe=true;
				cientificos.setDni(resultado.getString("DNI"));
				cientificos.setNomApels(resultado.getString("NomApels"));
			 }
			
			resultado.close();
			conexion.desconectar();
			System.out.println(sql);		
		} 
		catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "No se ha conectado");
			System.out.println(e);
		}
		
		if (existe) {
			return cientificos;
		}
		else return null;				
	}

	public void modificarCientificos(Cientificos miCientificos) {
		
		Conexion conexion = new Conexion();
		
		try {
			String consulta = "UPDATE Cientificos SET DNI = ? , NomApels = ? WHERE DNI = ? ";
			PreparedStatement stat = conexion.getConnection().prepareStatement(consulta);
			stat.setString(1, miCientificos.getDni());
			stat.setString(2, miCientificos.getNomApels());
			stat.setString(3, miCientificos.getDni());
			stat.executeUpdate();
            JOptionPane.showMessageDialog(null, " Se ha modificado correctamente ", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
            System.out.println(consulta);
        }
		catch(SQLException e){
			System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error al modificar", "Error", JOptionPane.ERROR_MESSAGE);
        }
	}

	public void eliminarCientificos(String codigo) {
		
		Conexion conexion = new Conexion();
		
		try {
			String sql= "DELETE FROM Cientificos WHERE DNI = '" + codigo + "'";
			Statement stat = conexion.getConnection().createStatement();
			stat.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, " Se ha eliminado correctamente", "Información", JOptionPane.INFORMATION_MESSAGE);
            System.out.println(sql);
            stat.close();
			conexion.desconectar();
		} 
		catch (SQLException e) {
            System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "No se eliminó");
		}
	}

	public Object[] recogerDnisCientificos() {
		Conexion conexion = new Conexion();
		ArrayList<String> arraylist = new ArrayList<String>();
		
		try {
			String sql = "SELECT DNI FROM Cientificos";
			PreparedStatement consulta = conexion.getConnection().prepareStatement(sql);
			ResultSet resultado = consulta.executeQuery();
			
			while(resultado.next()) {
				arraylist.add(resultado.getString("DNI"));
			}
			
			resultado.close();
			conexion.desconectar();	
		} 
		catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error, no se conectó");
			System.out.println(e);
		}
		return arraylist.toArray();
	}
}