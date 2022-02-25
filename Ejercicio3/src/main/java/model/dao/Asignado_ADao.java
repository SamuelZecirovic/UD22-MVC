package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import model.conexion.Conexion;
import model.dto.Asignado_A;

public class Asignado_ADao {
	
	public void asignarCientificoProyecto(Asignado_A miAsignado) {

		Conexion conexion = new Conexion();
		
		try {
			boolean existe = false;
			String sql= "SELECT * FROM Asignado_A where Cientifico = ? ";
			PreparedStatement consulta = conexion.getConnection().prepareStatement(sql);
			consulta.setString(1, miAsignado.getCientifico());
			ResultSet resultado = consulta.executeQuery();
			
			while(resultado.next()) {
				existe=true;
			}

			resultado.close();
			String sql2;
			
			if(!existe) {
				Statement st = conexion.getConnection().createStatement();
				sql2 = "INSERT INTO Asignado_A VALUES ('" + miAsignado.getCientifico() + "', '" + miAsignado.getProyecto() + "');";
				st.executeUpdate(sql2);
				st.close();
			} else {
				sql2 = "UPDATE Asignado_A SET Cientifico = ? , Proyecto = ? WHERE Cientifico = ? ";
				PreparedStatement stat = conexion.getConnection().prepareStatement(sql2);
				stat.setString(1, miAsignado.getCientifico());
				stat.setString(2, miAsignado.getProyecto());
				stat.setString(3, miAsignado.getCientifico());
				stat.executeUpdate();
			}
			
			JOptionPane.showMessageDialog(null, "Se asignó correctamente", "Información", JOptionPane.INFORMATION_MESSAGE);
			System.out.println(sql2);
			conexion.desconectar();
		} 
		catch (SQLException e) {
            System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "No se registró");
		}
	}
}