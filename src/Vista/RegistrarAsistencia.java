package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import servicioprofesor.ServicioProfesorProxy;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.rmi.RemoteException;

public class RegistrarAsistencia extends JFrame {

	private JPanel contentPane;
	private JTextField textEst;
	private JTextField textAsistencia;
	private JTextField textCodigo;
	private JTextField textProf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrarAsistencia frame = new RegistrarAsistencia();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RegistrarAsistencia() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 576, 398);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.add(panel, BorderLayout.CENTER);
		
		JLabel label = new JLabel("Profesor");
		label.setFont(new Font("Comic Sans MS", Font.ITALIC, 22));
		label.setBounds(231, 30, 142, 32);
		panel.add(label);
		
		JLabel label_1 = new JLabel("Registrar asistencia del estudiante en curso");
		label_1.setFont(new Font("Comic Sans MS", Font.ITALIC, 14));
		label_1.setBounds(136, 73, 340, 32);
		panel.add(label_1);
		
		textEst = new JTextField();
		textEst.setColumns(10);
		textEst.setBounds(231, 116, 255, 20);
		panel.add(textEst);
		
		textAsistencia = new JTextField();
		textAsistencia.setColumns(10);
		textAsistencia.setBounds(231, 148, 255, 20);
		panel.add(textAsistencia);
		
		textCodigo = new JTextField();
		textCodigo.setColumns(10);
		textCodigo.setBounds(231, 179, 255, 20);
		panel.add(textCodigo);
		
		textProf = new JTextField();
		textProf.setColumns(10);
		textProf.setBounds(231, 210, 255, 20);
		panel.add(textProf);
		
		JLabel labelResultado = new JLabel("");
		labelResultado.setBounds(101, 275, 385, 20);
		panel.add(labelResultado);
		
		JButton button = new JButton("Registrar Asistencia");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String rutEs = textEst.getText(); 
				String nota = textAsistencia.getText();
				String cod = textCodigo.getText();
				String rutProfe = textProf.getText();
				
				
				ServicioProfesorProxy asignarAsistencia = new ServicioProfesorProxy();
				
				String resultado;
				try {
					if ((textEst.getText().trim().length()!=0)&&(textAsistencia.getText().trim().length()!=0)
							&&(textCodigo.getText().trim().length()!=0)&&(textProf.getText().trim().length()!=0)){
						
						int id = Integer.parseInt(cod);
						resultado = asignarAsistencia.registrarAsistencia(rutEs, id, nota, rutProfe);
						labelResultado.setText(resultado);
					} else {
						labelResultado.setText("Debe llenar todos los campos");
					}
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button.setBounds(231, 241, 156, 23);
		panel.add(button);
		

		
		JButton button_1 = new JButton("Volver al Men\u00FA");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu b = new Menu();
				b.setLocationRelativeTo(null);
				b.setVisible(true);
				setVisible(false);
			}
		});
		button_1.setBounds(195, 306, 135, 23);
		panel.add(button_1);
		
		JLabel label_3 = new JLabel("Rut estudiante: ");
		label_3.setBounds(42, 119, 119, 14);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("Asistencia:");
		label_4.setBounds(42, 151, 119, 14);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("C\u00F3digo curso: ");
		label_5.setBounds(42, 182, 119, 14);
		panel.add(label_5);
		
		JLabel label_6 = new JLabel("Rut profesor: ");
		label_6.setBounds(42, 213, 119, 14);
		panel.add(label_6);
	}

}
