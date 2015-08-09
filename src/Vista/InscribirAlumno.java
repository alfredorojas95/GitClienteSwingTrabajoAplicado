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

import serviciocurso.ServicioCursoProxy;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.rmi.RemoteException;

public class InscribirAlumno extends JFrame {

	private JPanel contentPane;
	private JTextField textCod;
	private JTextField textEst;
	private JTextField textProf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InscribirAlumno frame = new InscribirAlumno();
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
	public InscribirAlumno() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 468, 361);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.add(panel, BorderLayout.CENTER);
		
		JLabel label = new JLabel("Director");
		label.setFont(new Font("Comic Sans MS", Font.ITALIC, 22));
		label.setBounds(162, 11, 162, 41);
		panel.add(label);
		
		JLabel label_1 = new JLabel("Inscribir Estudiante en curso");
		label_1.setFont(new Font("Comic Sans MS", Font.ITALIC, 16));
		label_1.setBounds(101, 52, 259, 23);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("C\u00F3digo curso:");
		label_2.setBounds(52, 120, 98, 14);
		panel.add(label_2);
		
		textCod = new JTextField();
		textCod.setColumns(10);
		textCod.setBounds(160, 117, 183, 20);
		panel.add(textCod);
		
		textEst = new JTextField();
		textEst.setColumns(10);
		textEst.setBounds(162, 148, 183, 20);
		panel.add(textEst);
		
		JLabel labelResultado = new JLabel("");
		labelResultado.setBounds(30, 244, 384, 20);
		panel.add(labelResultado);
		
		JButton button_1 = new JButton("Inscribir");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String cod = textCod.getText();
				String rutEs = textEst.getText();
				String rutProf = textProf.getText();
				
				ServicioCursoProxy inscribir = new ServicioCursoProxy();
				try {
					if ((textCod.getText().trim().length()!=0)&&(textEst.getText().trim().length()!=0)&&(textProf.getText().trim().length()!=0)){
						int id = Integer.parseInt(cod);
						String resultado = inscribir.inscribirEstudiantes(id, rutEs, rutProf);
						labelResultado.setText(resultado);
					} else {
						labelResultado.setText("Debe llenar el todos los campo");
					}
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button_1.setBounds(162, 210, 113, 23);
		panel.add(button_1);
		
		JButton button_2 = new JButton("Volver al Men\u00FA");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu b = new Menu();
				b.setLocationRelativeTo(null);
				b.setVisible(true);
				setVisible(false);
			}
		});
		button_2.setBounds(136, 275, 151, 23);
		panel.add(button_2);
		
		textProf = new JTextField();
		textProf.setColumns(10);
		textProf.setBounds(162, 179, 183, 20);
		panel.add(textProf);
		
		JLabel label_3 = new JLabel("Rut estudiante:");
		label_3.setBounds(52, 151, 100, 14);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("Rut profesor:");
		label_4.setBounds(52, 182, 78, 14);
		panel.add(label_4);
	}
}
