package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.ProyectoController;
import model.dto.Proyecto;

public class VentanaRegistroProyecto extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	private ProyectoController proyectoController;
	private JLabel lblTitulo;
	private JTextField txtCod, txtTitle, txtHoras;
	private JLabel cod, title, horas;
	private JButton btnGuardar, btnCancelar;
	
	public VentanaRegistroProyecto() {

		btnGuardar = new JButton();
		btnGuardar.setBounds(110, 220, 120, 25);
		btnGuardar.setText("Registrar");
		
		btnCancelar = new JButton();
		btnCancelar.setBounds(250, 220, 120, 25);
		btnCancelar.setText("Cancelar");

		lblTitulo = new JLabel();
		lblTitulo.setText("REGISTRO DE PROYECTO");
		lblTitulo.setBounds(120, 20, 380, 30);
		lblTitulo.setFont(new java.awt.Font("Verdana", 1, 18));

		cod = new JLabel();
		cod.setText("Codigo");
		cod.setBounds(138, 79, 80, 25);
		getContentPane().add(cod);
		
		title = new JLabel();
		title.setText("Nombre");
		title.setBounds(138, 119, 80, 25);
		getContentPane().add(title);
		
		horas = new JLabel();
		horas.setText("Horas");
		horas.setBounds(138, 155, 80, 25);
		getContentPane().add(horas);
		
		txtCod=new JTextField();
		txtCod.setBounds(198, 79, 80, 25);
		getContentPane().add(txtCod);
		
		txtTitle = new JTextField();
		txtTitle.setBounds(198, 119, 130, 25);
		getContentPane().add(txtTitle);
		
		txtHoras = new JTextField();
		txtHoras.setBounds(198, 155, 140, 25);
		getContentPane().add(txtHoras);
		
		btnGuardar.addActionListener(this);
		btnCancelar.addActionListener(this);
		getContentPane().add(btnCancelar);
		getContentPane().add(btnGuardar);
		getContentPane().add(lblTitulo);
		
		limpiar();
		
		setSize(480, 300);
		setTitle("Patron de Diseño MVC");
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);
	}

	private void limpiar() {
		txtCod.setText("");
		txtTitle.setText("");
		txtHoras.setText("");
	}

	public void setCoordinador(ProyectoController proyectoController) {
		this.proyectoController=proyectoController;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnGuardar) {
			try {				
				Proyecto miProyecto = new Proyecto();
				miProyecto.setId(txtCod.getText());
				miProyecto.setNombre(txtTitle.getText());
				miProyecto.setHoras(Integer.parseInt(txtHoras.getText()));
				proyectoController.registrarProyecto(miProyecto);	
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
