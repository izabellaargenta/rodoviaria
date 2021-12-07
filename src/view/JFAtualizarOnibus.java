package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.bean.Onibus;
import model.dao.OnibusDAO;

import javax.swing.JLabel;

public class JFAtualizarOnibus extends JFrame {

	private JPanel contentPane;
	private JTextField txtPrefixo;
	private JTextField txtOrigem;
	private JTextField txtDestino;
	private JTextField txtS;
	private JTextField txtC;
	private static int id;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFAtualizarOnibus frame = new JFAtualizarOnibus(id);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param id 
	 */
	public JFAtualizarOnibus(int id) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		OnibusDAO odao = new OnibusDAO();
		Onibus o = odao.read(id);
		
		JLabel lblIDE = new JLabel("ID:");
		lblIDE.setBounds(312, 11, 46, 14);
		contentPane.add(lblIDE);
		
		final JLabel lblIde;
		lblIde = new JLabel("New label");
		lblIde.setBounds(357, 11, 46, 14);
		contentPane.add(lblIde);
		JLabel lblNewLabel = new JLabel("Alterar Onibus");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 11, 383, 21);
		contentPane.add(lblNewLabel);
		
		JLabel lblId = new JLabel("Identificação do Ônibus:");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblId.setBounds(10, 43, 192, 32);
		contentPane.add(lblId);
		
		txtPrefixo = new JTextField();
		txtPrefixo.setBounds(201, 50, 223, 21);
		contentPane.add(txtPrefixo);
		txtPrefixo.setColumns(10);
		
		JLabel lblOrigem = new JLabel("Origem");
		lblOrigem.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblOrigem.setBounds(10, 86, 50, 21);
		contentPane.add(lblOrigem);
		
		txtOrigem = new JTextField();
		txtOrigem.setBounds(59, 86, 132, 20);
		contentPane.add(txtOrigem);
		txtOrigem.setColumns(10);
		
		JLabel lblHorarioSaida = new JLabel("Horário Saída");
		lblHorarioSaida.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblHorarioSaida.setBounds(10, 118, 93, 21);
		contentPane.add(lblHorarioSaida);
		
		JLabel lblDestino = new JLabel("Destino:");
		lblDestino.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDestino.setBounds(201, 86, 62, 21);
		contentPane.add(lblDestino);
		
		txtDestino = new JTextField();
		txtDestino.setBounds(265, 86, 159, 21);
		contentPane.add(txtDestino);
		txtDestino.setColumns(10);
		
		JLabel lblHorarioChegada = new JLabel("Horário Chegada:");
		lblHorarioChegada.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblHorarioChegada.setBounds(201, 118, 119, 21);
		contentPane.add(lblHorarioChegada);
		
		txtS = new JTextField();
		txtS.setBounds(102, 119, 86, 20);
		contentPane.add(txtS);
		txtS.setColumns(10);
		
		txtC = new JTextField();
		txtC.setBounds(318, 119, 86, 20);
		contentPane.add(txtC);
		txtC.setColumns(10);
	
		lblIde.setText(String.valueOf(o.getIdOnibus()));
	txtOrigem.setText(o.getOrigem());
	txtDestino.setText(o.getDestino());
	txtC.setText(o.getHorario_c());
	txtS.setText(o.getHorario_s());
	txtPrefixo.setText(String.valueOf(o.getPrefixo()));
	
	
	
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Onibus o = new Onibus();
				OnibusDAO dao = new OnibusDAO();
				o.setIdOnibus(Integer.parseInt(lblIde.getText()));
				o.setPrefixo(Integer.parseInt(txtPrefixo.getText()));
				o.setOrigem(txtOrigem.getText());
				o.setDestino(txtDestino.getText());
				o.setHorario_c(txtC.getText());
				o.setHorario_s(txtS.getText());
				dao.update(o);
				
			}
		});
	
		btnAlterar.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		btnAlterar.setBounds(10, 217, 119, 22);
		contentPane.add(btnAlterar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtPrefixo.setText(null);
				txtOrigem.setText(null);
				txtDestino.setText(null);
				txtC.setText(null);
				txtS.setText(null);
			}
		});
		btnLimpar.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		btnLimpar.setBounds(171, 217, 108, 22);
		contentPane.add(btnLimpar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		btnCancelar.setBounds(307, 217, 117, 23);
		contentPane.add(btnCancelar);
		
	
	}

	}

