package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.bean.Onibus;
import model.dao.OnibusDAO;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JFCadastrarOnibus extends JFrame {

	private JPanel contentPane;
	private JTextField txtIdOnibus;
	private JTextField txtOrigem;
	private JTextField txtDestino;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFCadastrarOnibus frame = new JFCadastrarOnibus();
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
	public JFCadastrarOnibus() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cadastrar Onibus");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 11, 383, 21);
		contentPane.add(lblNewLabel);
		
		JLabel lblId = new JLabel("Identifica\u00E7\u00E3o do \u00D4nibus:");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblId.setBounds(10, 43, 192, 32);
		contentPane.add(lblId);
		
		txtIdOnibus = new JTextField();
		txtIdOnibus.setBounds(201, 50, 223, 21);
		contentPane.add(txtIdOnibus);
		txtIdOnibus.setColumns(10);
		
		JLabel lblOrigem = new JLabel("Origem");
		lblOrigem.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblOrigem.setBounds(10, 86, 50, 21);
		contentPane.add(lblOrigem);
		
		txtOrigem = new JTextField();
		txtOrigem.setBounds(59, 86, 132, 20);
		contentPane.add(txtOrigem);
		txtOrigem.setColumns(10);
		
		JLabel lblHorarioSaida = new JLabel("Hor\u00E1rio Sa\u00EDda");
		lblHorarioSaida.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblHorarioSaida.setBounds(10, 118, 93, 21);
		contentPane.add(lblHorarioSaida);
		
		final JSpinner spnS = new JSpinner();
		spnS.setBounds(102, 119, 89, 20);
		contentPane.add(spnS);
		
		JLabel lblDestino = new JLabel("Destino:");
		lblDestino.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDestino.setBounds(201, 86, 62, 21);
		contentPane.add(lblDestino);
		
		txtDestino = new JTextField();
		txtDestino.setBounds(265, 86, 159, 21);
		contentPane.add(txtDestino);
		txtDestino.setColumns(10);
		
		JLabel lblHorarioChegada = new JLabel("Hor\u00E1rio Chegada:");
		lblHorarioChegada.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblHorarioChegada.setBounds(201, 118, 119, 21);
		contentPane.add(lblHorarioChegada);
		
		final JSpinner spnC = new JSpinner();
		spnC.setBounds(321, 119, 103, 20);
		contentPane.add(spnC);
		
		JLabel txtTipo = new JLabel("Tipo \u00D4nibus:");
		txtTipo.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtTipo.setBounds(10, 165, 119, 21);
		contentPane.add(txtTipo);
		
		final JRadioButton rdbConvencional = new JRadioButton("Convencional");
		rdbConvencional.setBounds(102, 165, 109, 23);
		contentPane.add(rdbConvencional);
		
		final JRadioButton rdbExecutivo = new JRadioButton("Executivo");
		rdbExecutivo.setBounds(207, 165, 125, 23);
		contentPane.add(rdbExecutivo);
		
		ButtonGroup Tipo_onibus = new ButtonGroup();
		Tipo_onibus.add(rdbConvencional);
		Tipo_onibus.add(rdbExecutivo);
		
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Onibus o = new Onibus();
				OnibusDAO dao = new OnibusDAO();
				
				o.setIdOnibus(txtIdOnibus.getText());
				o.setOrigem(txtOrigem.getText());
				o.setDestino(txtDestino.getText());
				
				dao.create(o);
				
				
				
			}
			
		});
		btnCadastrar.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		btnCadastrar.setBounds(10, 217, 119, 22);
		contentPane.add(btnCadastrar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		btnLimpar.setBounds(171, 217, 108, 22);
		contentPane.add(btnLimpar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		btnCancelar.setBounds(307, 217, 117, 23);
		contentPane.add(btnCancelar);
	}
}
