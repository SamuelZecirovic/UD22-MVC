package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.CientificosController;
import model.dto.Cientificos;

public class VentanaRegistroCientificos extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	private CientificosController cientificosController;
	private JLabel lblTitulo;
	private JTextField txtNombre, txtDni;
	private JLabel nombre, dni;
	private JButton btnGuardar, btnCancelar;
	
	public VentanaRegistroCientificos() {

		btnGuardar = new JButton();
		btnGuardar.setBounds(110, 220, 120, 25);
		btnGuardar.setText("Registrar");
		
		btnCancelar = new JButton();
		btnCancelar.setBounds(250, 220, 120, 25);
		btnCancelar.setText("Cancelar");

		lblTitulo = new JLabel();
		lblTitulo.setText("REGISTRO DE CIENTIFICOS");
		lblTitulo.setBounds(120, 20, 380, 30);
		lblTitulo.setFont(new java.awt.Font("Verdana", 1, 18));
		
		dni = new JLabel();
		dni.setText("DNI");
		dni.setBounds(120, 84, 52, 25);
		getContentPane().add(dni);
		
		nombre = new JLabel();
		nombre.setText("Nombre");
		nombre.setBounds(120, 121, 80, 25);
		getContentPane().add(nombre);
		
		txtDni = new JTextField();
		txtDni.setText("");
		txtDni.setBounds(182, 84, 160, 25);
		getContentPane().add(txtDni);
		
		txtNombre=new JTextField();
		txtNombre.setBounds(182, 121, 160, 25);
		getContentPane().add(txtNombre);
		
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
		txtDni.setText("");
		txtNombre.setText("");
	}
	
	public void setCoordinador(CientificosController cientificosController) {
		this.cientificosController=cientificosController;
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == btnGuardar) {
			try {				
				Cientificos miCientificos=new Cientificos();
				miCientificos.setDni(txtDni.getText());
				miCientificos.setNomApels(txtNombre.getText());
				cientificosController.registrarCientificos(miCientificos);	
			} 
			catch (Exception ex) {
				JOptionPane.showMessageDialog(null,"Error al ingresar datos", "Error",JOptionPane.ERROR_MESSAGE);
				System.out.println(ex);
			}
		}
		if (e.getSource() == btnCancelar) {
			this.dispose();
		}
	}
}

