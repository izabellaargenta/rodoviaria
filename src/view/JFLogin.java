package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JRadioButton;

public class JFLogin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFLogin frame = new JFLogin();
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
	public JFLogin() {
		setTitle("SisRodovi\u00E1ria - Tela de Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SisRodovi\u00E1ria - Bem Vindo!");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(10, 11, 414, 17);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Informe suas credenciais de acesso.");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 65, 414, 17);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Usu\u00E1rio:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(10, 105, 57, 19);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(77, 104, 347, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Senha:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(10, 142, 57, 19);
		contentPane.add(lblNewLabel_3);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(77, 141, 347, 20);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("Acessar");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(67, 182, 142, 27);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBounds(275, 222, 133, 26);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Recuperar senha");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_2.setBounds(252, 182, 172, 27);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Cadastrar-se");
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_3.setBounds(67, 222, 142, 26);
		contentPane.add(btnNewButton_3);
	}
}
