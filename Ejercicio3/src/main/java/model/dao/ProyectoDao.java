package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.conexion.Conexion;
import model.dto.Proyecto;

public class ProyectoDao {

	
	public void registrarProyecto(Proyecto miProyecto) {
		Conexion conexion = new Conexion();
		
		try {
			Statement stat = conexion.getConnection().createStatement();
			String sql= "INSERT INTO Proyecto VALUES ('" + miProyecto.getId() + "', '" + miProyecto.getNombre() +
					"', '" + miProyecto.getHoras() + "');";
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

	public Proyecto buscarProyecto(String codigo) {
		Conexion conexion = new Conexion();
		Proyecto proyecto = new Proyecto();
		boolean existe = false;
		
		try {
			String sql= "SELECT * FROM Proyecto where id = ? ";
			PreparedStatement consulta = conexion.getConnection().prepareStatement(sql);
			consulta.setString(1, codigo);
			ResultSet resultado = consulta.executeQuery();
			
			while(resultado.next()) {
				existe = true;
				proyecto.setId(resultado.getString("Id"));
				proyecto.setNombre(resultado.getString("Nombre"));
				proyecto.setHoras(resultado.getInt("Horas"));
			}
			
			resultado.close();
			conexion.desconectar();
			System.out.println(sql);		
		} 
		catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error, no se conectó");
			System.out.println(e);
		}
		
		if (existe) {
			return proyecto;
		}
		else return null;				
	}

	public void modificarProyecto(Proyecto miProyecto) {
		
		Conexion conexion = new Conexion();
		
		try {
			String consulta = "UPDATE Proyecto SET Id = ? , Nombre = ? , Horas = ? WHERE Id = ? ";
			PreparedStatement stat = conexion.getConnection().prepareStatement(consulta);
			stat.setString(1, miProyecto.getId());
			stat.setString(2, miProyecto.getNombre());
			stat.setInt(3, miProyecto.getHoras());
			stat.setString(4, miProyecto.getId());
			stat.executeUpdate();
            JOptionPane.showMessageDialog(null, " Se ha modificado correctamente", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
            System.out.println(consulta);
        }
		catch(SQLException e) {
			System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error al modificar", "Error", JOptionPane.ERROR_MESSAGE);
        }
	}

	public void eliminarProyecto(String codigo) {
		Conexion conexion = new Conexion();
		
		try {
			String sql= "DELETE FROM Proyecto WHERE id = '" + codigo + "'";
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

	public Object[] recogerIdsProyectos() {
		Conexion conexion = new Conexion();
		ArrayList<String> arraylist = new ArrayList<String>();
		
		try {
			String sql = "SELECT Id FROM Proyecto";
			PreparedStatement consulta = conexion.getConnection().prepareStatement(sql);
			ResultSet resultado = consulta.executeQuery();
			
			while(resultado.next()) {
				arraylist.add(resultado.getString("Id"));
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