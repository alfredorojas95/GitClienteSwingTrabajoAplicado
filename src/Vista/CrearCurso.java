package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;

import java.awt.Font;
import java.rmi.RemoteException;

import serviciocurso.ServicioCursoProxy;

public class CrearCurso extends JFrame {

	private JPanel contentPane;
	private JTextField textnombre;
	private JTextField textcodigo;
	private JTextField textrutjefe;
	private JTextField textrutprof;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrearCurso frame = new CrearCurso();
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
	public CrearCurso() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 535, 427);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textnombre = new JTextField();
		textnombre.setBounds(164, 91, 266, 20);
		contentPane.add(textnombre);
		textnombre.setColumns(10);
		
		JLabel rescrear = new JLabel("");
		rescrear.setBounds(164, 156, 266, 20);
		contentPane.add(rescrear);
		
		JButton btnCrearCurso = new JButton("Crear Curso");
		btnCrearCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String noCur = textnombre.getText();
				
					
					ServicioCursoProxy crear = new ServicioCursoProxy();
					try {
						if (textnombre.getText().trim().length()!=0){
							String resultado = crear.crearCurso(noCur, "135749802");
							rescrear.setText(resultado);
						} else {
							rescrear.setText("No se puedo crear el curso");
						}
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
			}
		});
		btnCrearCurso.setBounds(164, 122, 126, 23);
		contentPane.add(btnCrearCurso);
		
		
		
		JLabel lblCrearCursoY = new JLabel("Crear curso y asignar profesor");
		lblCrearCursoY.setFont(new Font("Comic Sans MS", Font.ITALIC, 14));
		lblCrearCursoY.setBounds(136, 52, 234, 30);
		contentPane.add(lblCrearCursoY);
		
		JLabel lblDirector = new JLabel("Director");
		lblDirector.setFont(new Font("Comic Sans MS", Font.ITALIC, 22));
		lblDirector.setBounds(197, 11, 126, 30);
		contentPane.add(lblDirector);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(38, 94, 85, 14);
		contentPane.add(lblNombre);
		
		JLabel label = new JLabel("C\u00F3digo:");
		label.setBounds(38, 190, 85, 14);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Rut Profesor:");
		label_1.setBounds(10, 221, 113, 14);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Rut Adm:");
		label_2.setBounds(20, 252, 103, 14);
		contentPane.add(label_2);
		
		textcodigo = new JTextField();
		textcodigo.setColumns(10);
		textcodigo.setBounds(164, 187, 266, 20);
		contentPane.add(textcodigo);
		
		textrutjefe = new JTextField();
		textrutjefe.setColumns(10);
		textrutjefe.setBounds(164, 249, 266, 20);
		contentPane.add(textrutjefe);
		
		textrutprof = new JTextField();
		textrutprof.setColumns(10);
		textrutprof.setBounds(164, 218, 266, 20);
		contentPane.add(textrutprof);
		
		JLabel resAsignar = new JLabel("");
		resAsignar.setBounds(164, 310, 266, 20);
		contentPane.add(resAsignar);
		
		JButton button = new JButton("Asignar Profesor");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String cod = textcodigo.getText();
				String rutProfe = textrutprof.getText();
				String rutJefeAdm = textrutjefe.getText();
				
				ServicioCursoProxy asignar = new ServicioCursoProxy();
				try {
					if ((textcodigo.getText().trim().length()!=0)&&(textrutprof.getText().trim().length()!=0)
							&&(textrutjefe.getText().trim().length()!=0)){
						int id = Integer.parseInt(cod);
						String resultado = asignar.asignarProfesor(id, rutProfe, rutJefeAdm);
						resAsignar.setText(resultado);
					} else {
						resAsignar.setText("No se pudo asignar el profesor");
					}
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		button.setBounds(164, 280, 173, 23);
		contentPane.add(button);
		
		
		
		JButton btnVolverAlMen = new JButton("Volver al Men\u00FA");
		btnVolverAlMen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu b = new Menu();
				b.setLocationRelativeTo(null);
				b.setVisible(true);
				setVisible(false);
			}
		});
		btnVolverAlMen.setBounds(205, 341, 126, 23);
		contentPane.add(btnVolverAlMen);
	}
}
