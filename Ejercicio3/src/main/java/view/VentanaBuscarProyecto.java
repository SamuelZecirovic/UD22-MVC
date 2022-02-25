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
import model.service.ProyectoServ;

public class VentanaBuscarProyecto extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private ProyectoController proyectoController;
	private JLabel lblTitulo;
	private JTextField txtCod, txtNombre, txtHoras;
	private JLabel cod, nombre, horas;
	private JButton btnGuardar, btnCancelar, btnBuscar, btnModificar, btnEliminar;
	
	public VentanaBuscarProyecto() {

		btnGuardar = new JButton();
		btnGuardar.setBounds(50, 220, 120, 25);
		btnGuardar.setText("Guardar");
		
		btnCancelar = new JButton();
		btnCancelar.setBounds(190, 250, 120, 25);
		btnCancelar.setText("Cancelar");
		
		btnBuscar = new JButton();
		btnBuscar.setBounds(170, 80, 50, 25);
		btnBuscar.setText("Ok");
		
		btnEliminar = new JButton();
		btnEliminar.setBounds(330, 220, 120, 25);
		btnEliminar.setText("Eliminar");
		
		btnModificar = new JButton();
		btnModificar.setBounds(190, 220, 120, 25);
		btnModificar.setText("Modificar");

		lblTitulo = new JLabel();
		lblTitulo.setText("ADMINISTRAR PROYECTOS");
		lblTitulo.setBounds(80, 21, 313, 30);
		lblTitulo.setFont(new java.awt.Font("Verdana", 1, 18));

		cod = new JLabel();
		cod.setText("Codigo");
		cod.setBounds(20, 80, 80, 25);
		getContentPane().add(cod);
		
		nombre = new JLabel();
		nombre.setText("Nombre");
		nombre.setBounds(250, 80, 80, 25);
		getContentPane().add(nombre);
		
		horas = new JLabel();
		horas.setText("Horas");
		horas.setBounds(98, 126, 80, 25);
		getContentPane().add(horas);
		
		txtCod=new JTextField();
		txtCod.setBounds(80, 80, 80, 25);
		getContentPane().add(txtCod);
		
		txtNombre=new JTextField();
		txtNombre.setBounds(310, 80, 140, 25);
		getContentPane().add(txtNombre);
		
		txtHoras = new JTextField();
		txtHoras.setBounds(158, 126, 190, 25);
		getContentPane().add(txtHoras);
		
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

	public void setCoordinador(ProyectoController proyectoController) {
		this.proyectoController=proyectoController;
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource()==btnGuardar) {
			
			try {
				
				Proyecto miProyecto=new Proyecto();
				miProyecto.setId(txtCod.getText());
				miProyecto.setNombre(txtNombre.getText());
				miProyecto.setHoras(Integer.parseInt(txtHoras.getText()));
				proyectoController.modificarProyecto(miProyecto);
				if (ProyectoServ.modificaProyecto == true) {
					habilita(true, false, false, true, false, false, false);
				}
			} 
			catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "Error al ingresar datos", "Error",JOptionPane.ERROR_MESSAGE);
			}
		}
		
		if (e.getSource()==btnBuscar) {
			Proyecto miProyecto = proyectoController.buscarProyecto(txtCod.getText());
			if (miProyecto != null) {
				muestraProyecto(miProyecto);
			}
			else if(ProyectoServ.consultaProyecto == true) {
				JOptionPane.showMessageDialog(null, "La proyecto no Existe","Advertencia",JOptionPane.WARNING_MESSAGE);
			}
		}
		
		if (e.getSource() == btnModificar) {
			habilita(false, true, true, false, true, false, false);
		}
		
		if (e.getSource() == btnEliminar) {
			if (!txtCod.getText().equals("")) {
				int respuesta = JOptionPane.showConfirmDialog(this, "Quieres eliminar Proyecto?", "Confirmación", JOptionPane.YES_NO_OPTION);
				if (respuesta == JOptionPane.YES_NO_OPTION) {
					proyectoController.eliminarProyecto(txtCod.getText());
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

	private void muestraProyecto(Proyecto miProyecto) {
		txtNombre.setText(miProyecto.getNombre());
		txtHoras.setText(miProyecto.getHoras()+"");
		habilita(true, false, false, true, false, true, true);
	}

	public void limpiar() {
		txtCod.setText("");
		txtNombre.setText("");
		txtHoras.setText("");
		habilita(true, false, false, true, false, false, false);
	}

	public void habilita(boolean codigo, boolean nombre, boolean horas, boolean bBuscar, boolean bGuardar, boolean bModificar, boolean bEliminar) {
		txtCod.setEditable(codigo);
		txtNombre.setEditable(nombre);
		txtHoras.setEditable(horas);
		btnBuscar.setEnabled(bBuscar);
		btnGuardar.setEnabled(bGuardar);
		btnModificar.setEnabled(bModificar);
		btnEliminar.setEnabled(bEliminar);
	}
}
