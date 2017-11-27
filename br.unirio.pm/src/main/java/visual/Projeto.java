package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import controle.ControleProjeto;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Projeto extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Projeto frame = new Projeto();
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
	public Projeto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSelecioneOArquivo = new JLabel("Selecione o arquivo PDF");
		lblSelecioneOArquivo.setBounds(34, 52, 149, 14);
		contentPane.add(lblSelecioneOArquivo);
		
		JButton btnSelecionarArquivo = new JButton("Selecionar arquivo");
		btnSelecionarArquivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				final JFileChooser fileChooser = new JFileChooser();
				fileChooser.setFileFilter(new FileNameExtensionFilter("PDF Documents", "pdf"));
				
				int retorno = fileChooser.showOpenDialog(contentPane);
				
				if (retorno == JFileChooser.APPROVE_OPTION) {
					new ControleProjeto(fileChooser.getSelectedFile().getPath());
					
				}
				
			}
		});
		btnSelecionarArquivo.setBounds(34, 91, 121, 23);
		contentPane.add(btnSelecionarArquivo);
	}
}
