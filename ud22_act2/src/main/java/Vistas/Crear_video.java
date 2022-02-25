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

public class Crear_video extends JFrame {

	private JPanel contentPane;
	private JTextField id;
	private JTextField titulo;
	private JTextField director;
	private JTextField id2;

	/**
	 * Create the frame.
	 */
	public Crear_video() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 208);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Videos");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(143, 11, 47, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Id:");
		lblNewLabel_1.setBounds(10, 46, 47, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Titulo:");
		lblNewLabel_2.setBounds(10, 71, 47, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Director:");
		lblNewLabel_3.setBounds(10, 96, 47, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Cliente_id:");
		lblNewLabel_4.setBounds(10, 121, 62, 14);
		contentPane.add(lblNewLabel_4);
		
		id = new JTextField();
		id.setBounds(71, 43, 96, 20);
		contentPane.add(id);
		id.setColumns(10);
		
		titulo = new JTextField();
		titulo.setBounds(71, 68, 96, 20);
		contentPane.add(titulo);
		titulo.setColumns(10);
		
		director = new JTextField();
		director.setBounds(71, 93, 96, 20);
		contentPane.add(director);
		director.setColumns(10);
		
		id2 = new JTextField();
		id2.setBounds(71, 118, 96, 20);
		contentPane.add(id2);
		id2.setColumns(10);
		
		JButton crear = new JButton("Crear");
		crear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ID = Integer.parseInt(id.getText());
				int ID2 = Integer.parseInt(id2.getText());
				Controlador.crearVideos(ID, titulo.getText(), director.getText(), ID2);
			}
		});
		crear.setBounds(222, 36, 81, 34);
		contentPane.add(crear);
		
		JButton editar = new JButton("Editar");
		editar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ID = Integer.parseInt(id.getText());
				int ID2 = Integer.parseInt(id2.getText());
				Controlador.editarVideos(ID, titulo.getText(), director.getText(), ID2);
			}
		});
		editar.setBounds(222, 76, 81, 34);
		contentPane.add(editar);
		
		JButton btnNewButton_Crear_2 = new JButton("Eliminar");
		btnNewButton_Crear_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ID = Integer.parseInt(id.getText());
				Controlador.eliminarVideo(ID);
			}
		});
		btnNewButton_Crear_2.setBounds(222, 118, 81, 34);
		contentPane.add(btnNewButton_Crear_2);
	}

}
