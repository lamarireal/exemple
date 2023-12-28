package first1;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GestionPrimos extends JFrame {

	private static final long serialVersionUID = 20231122L;
	private JPanel contentPane;
	private JTextField txtNumero;
	private JPanel panelCabecera;
	private JLabel lblNumero;
	private JButton btnInsertar;
	private JButton btnBorrar;
	private JButton btnLimpiar;

	private JPanel panelPie;
	private JLabel lblTotalNumeros;
	private JLabel lblTotalNumerosValor;
	private JLabel lblMedia;
	private JLabel lblMediaValor;

	private JPanel panelCentral;
	private JPanel panelPrimos;
	private JLabel lblPrimos;
	private JList<Integer> lstPrimos;
	private DefaultListModel<Integer> dlmPrimos;
	private JPanel panelNoPrimos;
	private JLabel lblNoPrimos;
	private JList<Integer> lstNoPrimos;
	private DefaultListModel<Integer> dlmNoPrimos;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionPrimos frame = new GestionPrimos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public GestionPrimos() {
		setTitle("Examen1 - Txema De Miguel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 344);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		panelCabecera = new JPanel();
		contentPane.add(panelCabecera, BorderLayout.NORTH);

		lblNumero = new JLabel("Número");
		panelCabecera.add(lblNumero);

		txtNumero = new JTextField();
		txtNumero.setHorizontalAlignment(SwingConstants.RIGHT);
		txtNumero.setText("");
		panelCabecera.add(txtNumero);
		txtNumero.setColumns(10);

		btnInsertar = new JButton("Insertar");
		panelCabecera.add(btnInsertar);
		btnInsertar.addActionListener(new ActionListener() {
			
			@Override
		    public void actionPerformed(ActionEvent e) {
		        
		            int numero = Integer.parseInt(txtNumero.getText());

		            if (isPrimo(numero)) {
		                dlmPrimos.addElement(numero);
		            } else {
		                dlmNoPrimos.addElement(numero);
		            }

		            updateStats();
		         
		    }
		});

		btnBorrar = new JButton("Borrar");
		panelCabecera.add(btnBorrar);
		btnBorrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				txtNumero.setText("");
			}
			
		});

		btnLimpiar = new JButton("Limpiar");
		panelCabecera.add(btnLimpiar);
		btnLimpiar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				txtNumero.setText("");
				lblTotalNumerosValor.setText("");
		        lblMediaValor.setText("");
				dlmPrimos.removeAllElements();
			    dlmNoPrimos.removeAllElements();
			    
				
			}
		});

		panelCentral = new JPanel();
		contentPane.add(panelCentral, BorderLayout.CENTER);
		panelCentral.setLayout(new BorderLayout(0, 0));

		panelPrimos = new JPanel();
		panelCentral.add(panelPrimos, BorderLayout.WEST);
		panelPrimos.setLayout(new BorderLayout(0, 0));

		dlmPrimos = new DefaultListModel<Integer>();

		lstPrimos = new JList<Integer>();

		lstPrimos.setModel(dlmPrimos);
		panelPrimos.add(lstPrimos, BorderLayout.CENTER);

		lblPrimos = new JLabel("Numeros Primos");
		lblPrimos.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPrimos.setHorizontalAlignment(SwingConstants.CENTER);
		panelPrimos.add(lblPrimos, BorderLayout.NORTH);

		panelNoPrimos = new JPanel();
		panelCentral.add(panelNoPrimos, BorderLayout.EAST);
		panelNoPrimos.setLayout(new BorderLayout(0, 0));

		lblNoPrimos = new JLabel("Números No Primos");
		lblNoPrimos.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNoPrimos.setHorizontalAlignment(SwingConstants.CENTER);
		panelNoPrimos.add(lblNoPrimos, BorderLayout.NORTH);

		dlmNoPrimos = new DefaultListModel<Integer>();

		lstNoPrimos = new JList<Integer>();

		lstNoPrimos.setModel(dlmNoPrimos);
		panelNoPrimos.add(lstNoPrimos, BorderLayout.CENTER);

		panelPie = new JPanel();
		contentPane.add(panelPie, BorderLayout.SOUTH);

		lblTotalNumeros = new JLabel("Total Numeros:");
		panelPie.add(lblTotalNumeros);

		lblTotalNumerosValor = new JLabel("");
		lblTotalNumerosValor.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTotalNumerosValor.setHorizontalAlignment(SwingConstants.RIGHT);
		panelPie.add(lblTotalNumerosValor);

		lblMedia = new JLabel("Media:");
		panelPie.add(lblMedia);

		lblMediaValor = new JLabel("");
		lblMediaValor.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMediaValor.setHorizontalAlignment(SwingConstants.RIGHT);
		panelPie.add(lblMediaValor);
	}
	private boolean isPrimo(int num) {
	    if (num < 2) {
	        return false;
	    }
	    for (int i = 2; i <= Math.sqrt(num); i++) {
	        if (num % i == 0) {
	            return false;
	        }
	    }
	    return true;
	}
	private void updateStats() {
	    int totalPrimos = dlmPrimos.size();
	    int totalNoPrimos = dlmNoPrimos.size();
	    int totalNumeros = totalPrimos + totalNoPrimos;
	    
	    lblTotalNumerosValor.setText(Integer.toString(totalNumeros));
	    double mediaTotal = 0;

	    lblMediaValor.setText(String.format("%.2f", mediaTotal));
	}

}
