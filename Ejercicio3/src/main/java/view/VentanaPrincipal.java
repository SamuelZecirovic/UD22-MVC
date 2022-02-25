package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import controller.Asignado_AController;
import controller.CientificosController;
import controller.ProyectoController;

public class VentanaPrincipal extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	private ProyectoController proyectoController;
	private Asignado_AController asignado_aController;
	private CientificosController cientificosController;
	private JButton btnRegistrarCientificoss, btnBuscarCientificoss, btnBuscarProyecto, btnRegistrarProyecto, btnAsignar;

	public VentanaPrincipal() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		btnRegistrarCientificoss = new JButton();
		btnRegistrarCientificoss.setBounds(66, 75, 154, 25);
		btnRegistrarCientificoss.setText("Registrar Cientificos");
		
		btnBuscarCientificoss = new JButton();
		btnBuscarCientificoss.setBounds(240, 75, 154, 25);
		btnBuscarCientificoss.setText("Buscar Cientificos");
		
		btnRegistrarProyecto = new JButton();
		btnRegistrarProyecto.setText("Registrar Proyecto");
		btnRegistrarProyecto.setBounds(66, 200, 154, 25);
		
		btnBuscarProyecto = new JButton();
		btnBuscarProyecto.setText("Buscar Proyecto");
		btnBuscarProyecto.setBounds(240, 200, 154, 25);
		
		btnAsignar = new JButton();
		btnAsignar.setText("Asignar Proyecto a Cientifico");
		btnAsignar.setBounds(135, 140, 200, 25);

		btnRegistrarCientificoss.addActionListener(this);
		btnBuscarCientificoss.addActionListener(this);
		btnRegistrarProyecto.addActionListener(this);
		btnBuscarProyecto.addActionListener(this);
		btnAsignar.addActionListener(this);
		
		getContentPane().add(btnBuscarCientificoss);
		getContentPane().add(btnRegistrarCientificoss);
		getContentPane().add(btnBuscarProyecto);
		getContentPane().add(btnRegistrarProyecto);
		getContentPane().add(btnAsignar);
	
		setSize(480, 350);
		setTitle("Patron de Diseño MVC");
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);
	}

	public void setCoordinadores(CientificosController cientificosController, ProyectoController proyectoController, Asignado_AController asignado_aController)  {
		this.cientificosController = cientificosController;
		this.proyectoController = proyectoController;
		this.asignado_aController = asignado_aController;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnRegistrarCientificoss) {
			cientificosController.mostrarVentanaRegistroCientificos();			
		}
		else if (e.getSource() == btnBuscarCientificoss) {
			cientificosController.mostrarVentanaConsultaCientificos();			
		}
		else if (e.getSource() == btnRegistrarProyecto) {
			proyectoController.mostrarVentanaRegistroProyecto();			
		}
		else if (e.getSource() == btnBuscarProyecto) {
			proyectoController.mostrarVentanaConsultaProyecto();			
		}
		else if (e.getSource() == btnAsignar) {
			asignado_aController.mostrarVentanaAsignarCientificos();	
		}
	}
}
