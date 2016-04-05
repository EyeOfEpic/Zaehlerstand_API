import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Fensta {

	public JFrame frame;
	public JTextField textField;
	public String inhalt = "TEST";
	public JButton button;
	public JButton button_1;
	public JButton button_2;
	public JButton button_3;
	public JButton button_4;
	public JButton button_5;
	public JButton button_6;
	public JButton button_7;
	public JButton button_8;
	public JButton button_9;
	private JButton button_10;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fensta window = new Fensta();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Fensta() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[][][][][][][][][grow]", "[][][][][][][]"));
		
		textField = new JTextField();
		textField.setText(inhalt);
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inhalt = textField.getText();
				System.out.println(inhalt);
			}
		});
		frame.getContentPane().add(textField, "cell 0 1,growx");
		textField.setColumns(10);
		
		JButton btnBesttigen = new JButton("Best\u00E4tigen");
		btnBesttigen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				inhalt = textField.getText();
				System.out.println(inhalt);
			}
		});
		
		button = new JButton("7");
		button.addActionListener(new ZahlListener());
		frame.getContentPane().add(button, "cell 2 1");
		
		button_1 = new JButton("8");
		button_1.addActionListener(new ZahlListener());
		frame.getContentPane().add(button_1, "cell 3 1");
		
		button_2 = new JButton("9");
		button_2.addActionListener(new ZahlListener());
		frame.getContentPane().add(button_2, "cell 4 1");
		frame.getContentPane().add(btnBesttigen, "cell 0 2,alignx center");
		
		button_3 = new JButton("4");
		button_3.addActionListener(new ZahlListener());
		frame.getContentPane().add(button_3, "cell 2 2");
		
		button_4 = new JButton("5");
		button_4.addActionListener(new ZahlListener());
		frame.getContentPane().add(button_4, "cell 3 2");
		
		button_5 = new JButton("6");
		button_5.addActionListener(new ZahlListener());
		frame.getContentPane().add(button_5, "cell 4 2");
		
		button_6 = new JButton("1");
		button_6.addActionListener(new ZahlListener());
		frame.getContentPane().add(button_6, "cell 2 3");
		
		button_7 = new JButton("2");
		button_7.addActionListener(new ZahlListener());
		frame.getContentPane().add(button_7, "cell 3 3");
		
		button_8 = new JButton("3");
		button_8.addActionListener(new ZahlListener());
		frame.getContentPane().add(button_8, "cell 4 3");
		
		button_9 = new JButton("0");
		button_9.addActionListener(new ZahlListener());
		frame.getContentPane().add(button_9, "cell 3 4");
		
		button_10 = new JButton(".");
		button_10.addActionListener(new ZahlListener());
		frame.getContentPane().add(button_10, "cell 4 4");
	}
	/**
	 * ActionListener
	 */
	class ZahlListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton btn = (JButton) e.getSource();
			inhalt = textField.getText();
			inhalt = inhalt + btn.getText();
			textField.setText(inhalt);			
		}
		
	}

}
