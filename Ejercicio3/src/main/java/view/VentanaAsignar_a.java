package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import controller.Asignado_AController;
import model.dao.CientificosDao;
import model.dao.ProyectoDao;
import model.dto.Asignado_A;

public class VentanaAsignar_a extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	private Asignado_AController asignar_aController;
	private JLabel lblTitulo;
	private JComboBox<Object> txtDniCientifico, txtProyecto;
	private JLabel dniCientifico, proyecto;
	private JButton btnGuardar, btnCancelar;
	
	public VentanaAsignar_a() {

		btnGuardar = new JButton();
		btnGuardar.setBounds(110, 220, 120, 25);
		btnGuardar.setText("Registrar");
		
		btnCancelar = new JButton();
		btnCancelar.setBounds(250, 220, 120, 25);
		btnCancelar.setText("Cancelar");

		lblTitulo = new JLabel();
		lblTitulo.setText("ASIGNAR CIENTIFICO A PROYECTO");
		lblTitulo.setBounds(47, 22, 380, 30);
		lblTitulo.setFont(new java.awt.Font("Verdana", 1, 18));
		
		dniCientifico = new JLabel();
		dniCientifico.setText("DNI Cientifico");
		dniCientifico.setBounds(110, 79, 103, 25);
		getContentPane().add(dniCientifico);
		
		proyecto = new JLabel();
		proyecto.setText("Codigo Proyecto");
		proyecto.setBounds(110, 135, 103, 25);
		getContentPane().add(proyecto);
		
		txtDniCientifico = new JComboBox<Object>();
		txtDniCientifico.setBounds(218, 79, 140, 25);
		txtDniCientifico.setModel(new DefaultComboBoxModel<Object>((new CientificosDao()).recogerDnisCientificos()));
		getContentPane().add(txtDniCientifico);
		
		txtProyecto = new JComboBox<Object>();
		txtProyecto.setBounds(218, 135, 140, 25);
		txtProyecto.setModel(new DefaultComboBoxModel<Object>((new ProyectoDao()).recogerIdsProyectos()));
		getContentPane().add(txtProyecto);
		
		btnGuardar.addActionListener(this);
		btnCancelar.addActionListener(this);
		getContentPane().add(btnCancelar);
		getContentPane().add(btnGuardar);
		getContentPane().add(lblTitulo);
		
		limpiar();
		
		setSize(480, 300);
		setTitle("Patron de Diseño/MVC");
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);

	}


	private void limpiar() {
		if(txtDniCientifico.getItemCount() > 0) {
			txtDniCientifico.setSelectedIndex(0);
		}
		if(txtProyecto.getItemCount() > 0) {
			txtProyecto.setSelectedIndex(0);
		}
	}
	
	public void setCoordinador(Asignado_AController asignar_aController) {
		this.asignar_aController = asignar_aController;
	}


	public JComboBox<Object> getTextDniCientifico() {
		return txtDniCientifico;
	}

	public JComboBox<Object> getTextProyecto() {
		return txtProyecto;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnGuardar) {
			try {				
				Asignado_A miAsignado_A = new Asignado_A();
				miAsignado_A.setCientifico("" + txtDniCientifico.getSelectedItem());
				miAsignado_A.setProyecto("" + txtProyecto.getSelectedItem());
				asignar_aController.asignarCientificoProyecto(miAsignado_A);	
			} 
			catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Error al ingresar datos", "Error",JOptionPane.ERROR_MESSAGE);
				System.out.println(ex);
			}
		}
		
		if (e.getSource() == btnCancelar) {
			this.dispose();
		}
	}
}
