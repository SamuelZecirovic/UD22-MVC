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
import model.service.CientificosServ;

public class VentanaBuscarCientificos extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private CientificosController cientificosController;
	private JLabel lblTitulo;
	private JTextField txtNombre, txtDni;
	private JLabel nombre, dni;
	private JButton btnGuardar, btnCancelar, btnBuscar, btnModificar, btnEliminar;
	
	public VentanaBuscarCientificos() {

		btnGuardar = new JButton();
		btnGuardar.setBounds(50, 220, 120, 25);
		btnGuardar.setText("Guardar");
		
		btnCancelar = new JButton();
		btnCancelar.setBounds(190, 250, 120, 25);
		btnCancelar.setText("Cancelar");
		
		btnBuscar = new JButton();
		btnBuscar.setBounds(314, 97, 50, 25);
		btnBuscar.setText("Ok");
		
		btnEliminar = new JButton();
		btnEliminar.setBounds(330, 220, 120, 25);
		btnEliminar.setText("Eliminar");
		
		btnModificar = new JButton();
		btnModificar.setBounds(190, 220, 120, 25);
		btnModificar.setText("Modificar");

		lblTitulo = new JLabel();
		lblTitulo.setText("ADMINISTRAR CIENTIFICOS");
		lblTitulo.setBounds(80, 25, 319, 30);
		lblTitulo.setFont(new java.awt.Font("Verdana", 1, 18));
		
		dni = new JLabel();
		dni.setText("DNI");
		dni.setBounds(85, 97, 40, 25);
		getContentPane().add(dni);
		
		nombre = new JLabel();
		nombre.setText("Nombre");
		nombre.setBounds(85, 137, 80, 25);
		getContentPane().add(nombre);
		
		txtDni = new JTextField();
		txtDni.setText("");
		txtDni.setEditable(false);
		txtDni.setBounds(145, 97, 140, 25);
		getContentPane().add(txtDni);
		
		txtNombre=new JTextField();
		txtNombre.setBounds(145, 137, 219, 25);
		getContentPane().add(txtNombre);
		
		btnModificar.addActionListener(this);
		btnEliminar.addActionListener(this);
		btnBuscar.addActionListener(this);
		btnGuardar.addActionListener(this);
		btnCancelar.addActionListener(this);

		getContentPane().add(btnCancelar);
		getContentPane().add(btnBuscar);
		getContentPane().add(btnModificar);
		getContentPane().add(btnEliminar);
		getContentPane().add(btnGuardar);
		getContentPane().add(lblTitulo);
		
		limpiar();
				
		setSize(480, 320);
		setTitle("Patron de Diseño/MVC");
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);
	}
	public void setCoordinador(CientificosController cientificosController) {
		this.cientificosController=cientificosController;
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource()==btnGuardar) {
			
			try {
				
				Cientificos miCientificos=new Cientificos();
				miCientificos.setDni(txtDni.getText());
				miCientificos.setNomApels(txtNombre.getText());
				cientificosController.modificarCientificos(miCientificos);
				
				if (CientificosServ.modificaCientificos==true) {
					habilita(true, false, true, false, true, true);	
				}
			} 
			
			catch (Exception e2) {
				JOptionPane.showMessageDialog(null,"Error en el Ingreso de Datos","Error",JOptionPane.ERROR_MESSAGE);
			}
		}
		
		if (e.getSource()==btnBuscar) {
			Cientificos miCientificos=cientificosController.buscarCientificos(txtDni.getText());
			if (miCientificos!=null) {
				muestraCientificos(miCientificos);
			}
			else if(CientificosServ.consultaCientificos==true) {
				JOptionPane.showMessageDialog(null, "La cientificos no Existe","Advertencia",JOptionPane.WARNING_MESSAGE);
			}
		}
		
		if (e.getSource()==btnModificar) {
			habilita(false, true, false, true, false, false);
		}
		
		if (e.getSource()==btnEliminar) {
			if (!txtDni.getText().equals("")) {
				int respuesta = JOptionPane.showConfirmDialog(this, "Quieres eliminar Cientificos?", "Confirmación", JOptionPane.YES_NO_OPTION);
				
				if (respuesta == JOptionPane.YES_NO_OPTION) {
					cientificosController.eliminarCientificos(txtDni.getText());
					limpiar();
				}
			} else {
				JOptionPane.showMessageDialog(null, "Ingrese un numero de documento", "Información",JOptionPane.WARNING_MESSAGE);
			}
		}
		
		if (e.getSource() == btnCancelar) {
			this.dispose();
		}
	}

	private void muestraCientificos(Cientificos miCientificos) {
		txtNombre.setText(miCientificos.getNomApels());
		habilita(true, false, true, false, true, true);
	}

	public void limpiar() {
		txtNombre.setText("");
		txtDni.setText("");
		habilita(true, false, true, false, false, false);
	}

	public void habilita(boolean dni, boolean nombre, boolean bBuscar, boolean bGuardar, boolean bModificar, boolean bEliminar) {
		txtDni.setEditable(dni);
		txtNombre.setEditable(nombre);
		btnBuscar.setEnabled(bBuscar);
		btnGuardar.setEnabled(bGuardar);
		btnModificar.setEnabled(bModificar);
		btnEliminar.setEnabled(bEliminar);
	}
}

