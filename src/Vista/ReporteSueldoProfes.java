package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.google.gson.Gson;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.rmi.RemoteException;

import serviciosueldo.ServicioSueldoProxy;;

public class ReporteSueldoProfes extends JFrame {

	private JPanel contentPane;
	private JTextField textRutProf;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReporteSueldoProfes frame = new ReporteSueldoProfes();
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
	public ReporteSueldoProfes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 628, 473);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblDirector = new JLabel("Director");
		lblDirector.setFont(new Font("Comic Sans MS", Font.ITALIC, 22));
		
		JLabel lblReporteSueldosProfesor = new JLabel("Reporte sueldos profesor");
		lblReporteSueldosProfesor.setFont(new Font("Comic Sans MS", Font.ITALIC, 15));
		
		JLabel lblRutProfesor = new JLabel("Rut profesor:");
		
		textRutProf = new JTextField();
		textRutProf.setColumns(10);
		
		JButton btnVolverAlMen = new JButton("Volver al Men\u00FA");
		btnVolverAlMen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu b = new Menu();
				b.setLocationRelativeTo(null);
				b.setVisible(true);
				setVisible(false);
			}
		});
		
		JButton btnVer = new JButton("Ver");
		btnVer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				visible();
				
				String rutProf = textRutProf.getText();
				ServicioSueldoProxy sueldos = new ServicioSueldoProxy();
				
				String[][] matriz;
				Gson gson = new Gson();
				String jsonMorosos;
				try {
					jsonMorosos = sueldos.consSueldoProf(rutProf);
					if(jsonMorosos!=null){
						matriz = gson.fromJson(jsonMorosos, String[][].class);
						Object [] fila = new Object[5]; fila[0] = "unal";
						
						for (int i = 0; i < matriz.length; i++) {
						fila[0] = matriz[i][0];
						fila[1] = matriz[i][1];
						fila[2] = matriz[i][2];
						fila[3] = matriz[i][3];
						fila[4] = matriz[i][4];

					
						((DefaultTableModel) table.getModel()).addRow(fila);
					}
						
					}else {
						JOptionPane.showMessageDialog(null, "Profesor no se encuentra o no registra sueldos");
				}
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(240)
					.addComponent(lblDirector, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(239, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(195)
							.addComponent(lblReporteSueldosProfesor, GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(89)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 450, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblRutProfesor, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(textRutProf)
									.addGap(18)
									.addComponent(btnVer, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)))))
					.addGap(63))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(256, Short.MAX_VALUE)
					.addComponent(btnVolverAlMen)
					.addGap(243))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(21)
					.addComponent(lblDirector, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblReporteSueldosProfesor, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addGap(21)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRutProfesor)
						.addComponent(textRutProf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnVer))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE)
					.addGap(36)
					.addComponent(btnVolverAlMen)
					.addContainerGap(109, Short.MAX_VALUE))
		);
		
		table = new JTable();
		visible();
		
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
	}

	public void visible(){
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Apellido", "Mes", "Cant. cursos", "Monto", "Estado pago"
				}
			));
	}
}
