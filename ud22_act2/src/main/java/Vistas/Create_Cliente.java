package Vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Controlador;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Create_Cliente extends JFrame {

	private JPanel contentPane;
	private JTextField id;
	private JTextField nombre;
	private JTextField apellido;
	private JTextField direccion;
	private JTextField dni;
	private JTextField fecha;

	/**
	 * Create the frame.
	 */
	public Create_Cliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 386, 260);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cliente");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(136, 11, 58, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Id:");
		lblNewLabel_1.setBounds(10, 40, 47, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre:");
		lblNewLabel_2.setBounds(10, 65, 47, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Apellido:");
		lblNewLabel_3.setBounds(10, 90, 47, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Direccion:");
		lblNewLabel_4.setBounds(10, 115, 58, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("DNI:");
		lblNewLabel_5.setBounds(10, 140, 47, 14);
		contentPane.add(lblNewLabel_5);
		
		id = new JTextField();
		id.setBounds(67, 37, 96, 20);
		contentPane.add(id);
		id.setColumns(10);
		
		nombre = new JTextField();
		nombre.setBounds(67, 62, 96, 20);
		contentPane.add(nombre);
		nombre.setColumns(10);
		
		apellido = new JTextField();
		apellido.setBounds(67, 87, 96, 20);
		contentPane.add(apellido);
		apellido.setColumns(10);
		
		direccion = new JTextField();
		direccion.setBounds(67, 112, 96, 20);
		contentPane.add(direccion);
		direccion.setColumns(10);
		
		dni = new JTextField();
		dni.setBounds(67, 137, 96, 20);
		contentPane.add(dni);
		dni.setColumns(10);
		
		JButton Crear = new JButton("Crear");
		Crear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ID = Integer.parseInt(id.getText());
				Controlador.crearCliente(ID,nombre.getText(),apellido.getText(),direccion.getText(),dni.getText(),fecha.getText());
			}
		});
		Crear.setBounds(249, 36, 89, 43);
		contentPane.add(Crear);
		
		fecha = new JTextField();
		fecha.setBounds(67, 166, 96, 20);
		contentPane.add(fecha);
		fecha.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Fecha");
		lblNewLabel_6.setBounds(10, 169, 47, 14);
		contentPane.add(lblNewLabel_6);
		
		JButton Editar = new JButton("Editar");
		Editar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ID = Integer.parseInt(id.getText());
				Controlador.editarCliente(ID,nombre.getText(),apellido.getText(),direccion.getText(),dni.getText(),fecha.getText());
			}
		});
		Editar.setBounds(249, 90, 89, 43);
		contentPane.add(Editar);
		
		JButton Eliminar = new JButton("Eliminar");
		Eliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ID = Integer.parseInt(id.getText());
				Controlador.eliminarCliente(ID);
			}
		});
		Eliminar.setBounds(249, 140, 89, 43);
		contentPane.add(Eliminar);
		
		JLabel lblNewLabel_7 = new JLabel("(yyyy-mm-dd)");
		lblNewLabel_7.setBounds(165, 164, 101, 25);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("(12345678)");
		lblNewLabel_8.setBounds(167, 140, 71, 14);
		contentPane.add(lblNewLabel_8);
	}
}
