package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 921, 489);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDirector = new JLabel("Director");
		lblDirector.setFont(new Font("Comic Sans MS", Font.ITALIC, 20));
		lblDirector.setBounds(61, 137, 104, 34);
		contentPane.add(lblDirector);
		
		JLabel label = new JLabel("Secretaria");
		label.setFont(new Font("Comic Sans MS", Font.ITALIC, 20));
		label.setBounds(233, 137, 104, 34);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Administraci\u00F3n");
		label_1.setFont(new Font("Comic Sans MS", Font.ITALIC, 20));
		label_1.setBounds(375, 137, 153, 34);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Profesor");
		label_2.setFont(new Font("Comic Sans MS", Font.ITALIC, 20));
		label_2.setBounds(590, 137, 104, 34);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("Apoderado");
		label_3.setFont(new Font("Comic Sans MS", Font.ITALIC, 20));
		label_3.setBounds(757, 137, 104, 34);
		contentPane.add(label_3);
		
		JButton btnMorososMatrcula = new JButton("Morosos Matr\u00EDcula");
		btnMorososMatrcula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MorososMatricula JFrame = new MorososMatricula();
				JFrame.setLocationRelativeTo(null);
				JFrame.setVisible(true);
				setVisible(false);
			}
		});
		btnMorososMatrcula.setBounds(23, 182, 166, 23);
		contentPane.add(btnMorososMatrcula);
		
		JButton button = new JButton("Morosos Mensualidad");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MorososMensualidad JFrame = new MorososMensualidad();
				JFrame.setLocationRelativeTo(null);
				JFrame.setVisible(true);
				setVisible(false);
			}
		});
		button.setBounds(23, 216, 166, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Cons. Pago");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReporteSueldoProfes JFrame = new ReporteSueldoProfes();
				JFrame.setLocationRelativeTo(null);
				JFrame.setVisible(true);
				setVisible(false);
			}
		});
		button_1.setBounds(23, 250, 166, 23);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("Desactivar Curso");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DesactivarCurso JFrame = new DesactivarCurso();
				JFrame.setLocationRelativeTo(null);
				JFrame.setVisible(true);
				setVisible(false);
			}
		});
		button_2.setBounds(23, 283, 166, 23);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("Balance I/G");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BalanceIngresoGasto JFrame = new BalanceIngresoGasto();
				JFrame.setLocationRelativeTo(null);
				JFrame.setVisible(true);
				setVisible(false);
			}
		});
		button_3.setBounds(23, 317, 166, 23);
		contentPane.add(button_3);
		
		JButton button_4 = new JButton("Registrar Matr\u00EDcula");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarMatricula JFrame = new RegistrarMatricula();
				JFrame.setLocationRelativeTo(null);
				JFrame.setVisible(true);
				setVisible(false);
			}
		});
		button_4.setBounds(199, 182, 166, 23);
		contentPane.add(button_4);
		
		JButton button_5 = new JButton("Registrar Mensualidad");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarMensualidad JFrame = new RegistrarMensualidad();
				JFrame.setLocationRelativeTo(null);
				JFrame.setVisible(true);
				setVisible(false);
			}
		});
		button_5.setBounds(199, 216, 166, 23);
		contentPane.add(button_5);
		
		JButton button_6 = new JButton("Reg. Sueldo Prof.");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarSueldoProfe JFrame = new RegistrarSueldoProfe();
				JFrame.setLocationRelativeTo(null);
				JFrame.setVisible(true);
				setVisible(false);
			}
		});
		button_6.setBounds(375, 182, 166, 23);
		contentPane.add(button_6);
		
		JButton button_7 = new JButton("Crear Curso");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearCurso JFrame = new CrearCurso();
				JFrame.setLocationRelativeTo(null);
				JFrame.setVisible(true);
				setVisible(false);
			}
		});
		button_7.setBounds(375, 216, 166, 23);
		contentPane.add(button_7);
		
		JButton button_8 = new JButton("Inscribir Estudiante");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InscribirAlumno JFrame = new InscribirAlumno();
				JFrame.setLocationRelativeTo(null);
				JFrame.setVisible(true);
				setVisible(false);
			}
		});
		button_8.setBounds(551, 182, 166, 23);
		contentPane.add(button_8);
		
		JButton button_9 = new JButton("Reg. Promedio");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarNota JFrame = new RegistrarNota();
				JFrame.setLocationRelativeTo(null);
				JFrame.setVisible(true);
				setVisible(false);
			}
		});
		button_9.setBounds(551, 216, 166, 23);
		contentPane.add(button_9);
		
		JButton button_10 = new JButton("Ver Situaci\u00F3n Est.");
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VerSituacionEstudiante JFrame = new VerSituacionEstudiante();
				JFrame.setLocationRelativeTo(null);
				JFrame.setVisible(true);
				setVisible(false);
			}
		});
		button_10.setBounds(727, 182, 166, 23);
		contentPane.add(button_10);
		
		JButton button_11 = new JButton("Reg. Asistencia");
		button_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarAsistencia JFrame = new RegistrarAsistencia();
				JFrame.setLocationRelativeTo(null);
				JFrame.setVisible(true);
				setVisible(false);
			}
		});
		button_11.setBounds(551, 250, 166, 23);
		contentPane.add(button_11);
	}
}
