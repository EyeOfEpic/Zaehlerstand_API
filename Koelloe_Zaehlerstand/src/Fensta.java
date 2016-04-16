import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.Font;
import java.awt.Insets;


public class Fensta {

	public JFrame frame;
	public JTextField wasser;
	private JButton btnLoad;
	private JButton plusWas;
	private JButton minusWas;
	private JButton plusStrom;
	private JButton minusStrom;
	private JLabel lblSchritte;
	private JRadioButton radioButton;
	private JRadioButton radioButton_1;
	private final ButtonGroup buttonGroup = new ButtonGroup();
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

	DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
	Calendar cal = Calendar.getInstance();
	public String inhaltDate = dateFormat.format(cal.getTime());
	public int laenge1 ;
	public int laenge2 ;
	private JLabel lblWasser;
	private JLabel lblStrom;
	private JTextField strom;
	public int zustand = 0;
	public JTextField JFDate;
	public File Datei = new File("/Users/Felix Raab/Desktop/Schule/Eclipse/Koelloe_Zaehlerstand/test.txt");
	HashMap<String, String> Date = new HashMap<String, String>();
	public double schritt;
	public String inhaltWasser = "0";
	public String inhaltStrom = "0";
	private JButton btnWriteToFile;



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
		frame.setResizable(false);
		frame.setFont(new Font("Dialog", Font.PLAIN, 10));
		try {
			open();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		frame.setBounds(100, 100, 375, 331);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		wasser = new JTextField();
		wasser.setBounds(7, 50, 91, 20);
		wasser.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				zustand = 1;
			}
		});
		wasser.setText(inhaltWasser);
		wasser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inhaltWasser = wasser.getText();
				inhaltStrom = strom.getText();
				System.out.println(inhaltWasser);
				System.out.println(inhaltStrom);
			}
		});
		frame.getContentPane().setLayout(null);

		JFDate = new JTextField();
		JFDate.setBounds(7, 7, 91, 20);
		frame.getContentPane().add(JFDate);
		JFDate.setColumns(10);
		JFDate.setText(inhaltDate);

		lblWasser = new JLabel("Wasser");
		lblWasser.setBounds(7, 31, 91, 14);
		frame.getContentPane().add(lblWasser);
		frame.getContentPane().add(wasser);
		wasser.setColumns(10);

		button = new JButton("7");
		button.setMargin(new Insets(0,0,0,0));
		button.setBounds(199, 49, 39, 23);
		button.addActionListener(new ZahlListener());

		plusWas = new JButton("+");
		plusWas.setBounds(102, 49, 41, 23);
		plusWas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				double temp = Double.parseDouble(wasser.getText()) + schritt;
				temp = Math.round(temp*100)/100.0; 
				inhaltWasser = Double.toString(temp);
				wasser.setText(inhaltWasser);
			}
		});
		frame.getContentPane().add(plusWas);

		minusWas = new JButton("-");
		minusWas.setBounds(147, 49, 37, 23);
		minusWas.setMargin(new Insets(0,0,0,0));
		minusWas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double temp = Double.parseDouble(wasser.getText()) - schritt;
				temp = Math.round(temp*100)/100.0; 
				inhaltWasser = Double.toString(temp);
				wasser.setText(inhaltWasser);
			}
		});
		frame.getContentPane().add(minusWas);
		frame.getContentPane().add(button);

		button_1 = new JButton("8");
		button_1.setBounds(244, 49, 39, 23);
		button_1.setMargin(new Insets(0,0,0,0));
		button_1.addActionListener(new ZahlListener());
		frame.getContentPane().add(button_1);

		button_2 = new JButton("9");
		button_2.setBounds(289, 49, 39, 23);
		button_2.setMargin(new Insets(0,0,0,0));
		button_2.addActionListener(new ZahlListener());
		frame.getContentPane().add(button_2);

		button_3 = new JButton("4");
		button_3.setBounds(199, 76, 39, 23);
		button_3.setMargin(new Insets(0,0,0,0));
		button_3.addActionListener(new ZahlListener());

		lblStrom = new JLabel("Strom");
		lblStrom.setBounds(7, 80, 91, 14);
		frame.getContentPane().add(lblStrom);
		frame.getContentPane().add(button_3);

		button_4 = new JButton("5");
		button_4.setBounds(244, 76, 39, 23);
		button_4.setMargin(new Insets(0,0,0,0));
		button_4.addActionListener(new ZahlListener());
		frame.getContentPane().add(button_4);

		button_5 = new JButton("6");
		button_5.setBounds(289, 76, 39, 23);
		button_5.setMargin(new Insets(0,0,0,0));
		button_5.addActionListener(new ZahlListener());
		frame.getContentPane().add(button_5);

		button_6 = new JButton("1");
		button_6.setBounds(199, 103, 39, 23);
		button_6.setMargin(new Insets(0,0,0,0));
		button_6.addActionListener(new ZahlListener());

		strom = new JTextField();
		strom.setBounds(7, 104, 91, 20);
		strom.setText(inhaltStrom);
		strom.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				zustand = 2;
			}
		});
		strom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inhaltWasser = wasser.getText();
				inhaltStrom = strom.getText();
				System.out.println(inhaltWasser);
				System.out.println(inhaltStrom);
			}
		});
		frame.getContentPane().add(strom);
		strom.setColumns(10);

		plusStrom = new JButton("+");
		plusStrom.setBounds(102, 103, 41, 23);
		plusStrom.setMargin(new Insets(0,0,0,0));
		plusStrom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double temp = Double.parseDouble(strom.getText()) + schritt;
				temp = Math.round(temp*100)/100.0; 
				inhaltStrom = Double.toString(temp);
				strom.setText(inhaltStrom);
			}
		});
		frame.getContentPane().add(plusStrom);

		minusStrom = new JButton("-");
		minusStrom.setBounds(147, 103, 37, 23);
		minusStrom.setMargin(new Insets(0,0,0,0));
		minusStrom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double temp = Double.parseDouble(strom.getText()) - schritt;
				temp = Math.round(temp*100)/100.0; 
				inhaltStrom = Double.toString(temp);
				strom.setText(inhaltStrom);
			}
		});
		frame.getContentPane().add(minusStrom);
		frame.getContentPane().add(button_6);

		button_7 = new JButton("2");
		button_7.setBounds(244, 103, 39, 23);
		button_7.setMargin(new Insets(0,0,0,0));
		button_7.addActionListener(new ZahlListener());
		frame.getContentPane().add(button_7);

		button_8 = new JButton("3");
		button_8.setBounds(289, 103, 39, 23);
		button_8.setMargin(new Insets(0,0,0,0));
		button_8.addActionListener(new ZahlListener());
		frame.getContentPane().add(button_8);

		button_9 = new JButton("0");
		button_9.setBounds(244, 130, 39, 23);
		button_9.setMargin(new Insets(0,0,0,0));
		button_9.addActionListener(new ZahlListener());
		frame.getContentPane().add(button_9);

		button_10 = new JButton(".");
		button_10.setBounds(289, 130, 39, 23);
		button_10.setMargin(new Insets(0,0,0,0));
		button_10.addActionListener(new KommaListener());
		frame.getContentPane().add(button_10);

		JButton btnSave = new JButton("Save");
		btnSave.setBounds(72, 188, 57, 23);
		btnSave.setMargin(new Insets(0,0,0,0));
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					save();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		btnLoad = new JButton("Load");
		btnLoad.setBounds(7, 188, 55, 23);
		btnLoad.setMargin(new Insets(0,0,0,0));
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					load();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		frame.getContentPane().add(btnLoad);
		frame.getContentPane().add(btnSave);

		lblSchritte = new JLabel("Schritte:");
		lblSchritte.setBounds(172, 192, 66, 14);
		frame.getContentPane().add(lblSchritte);

		radioButton = new JRadioButton("1.0");
		radioButton.setMargin(new Insets(0,0,0,0));
		radioButton.setBounds(242, 188, 41, 23);
		radioButton.setEnabled(true);
		radioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				schritt = 1;
			}
		});
		buttonGroup.add(radioButton);
		frame.getContentPane().add(radioButton);
		radioButton_1 = new JRadioButton("0.1");
		radioButton_1.setBounds(287, 188, 41, 23);
		radioButton_1.setMargin(new Insets(0,0,0,0));
		radioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				schritt = 0.1;
			}
		});
		buttonGroup.add(radioButton_1);
		frame.getContentPane().add(radioButton_1);
		
		btnWriteToFile = new JButton("Write to File");
		btnWriteToFile.setBounds(7, 240, 122, 23);
		btnWriteToFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		frame.getContentPane().add(btnWriteToFile);
	}
	/**
	 * ActionListener
	 */
	class ZahlListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			JButton btn = (JButton) e.getSource();
			switch (zustand)
			{
			case 1: inhaltWasser = wasser.getText();
			inhaltWasser += btn.getText();
			wasser.setText(inhaltWasser); break;
			case 2: inhaltStrom = strom.getText();
			inhaltStrom += btn.getText();
			strom.setText(inhaltStrom); break;
			}
		}
	}
	class KommaListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			switch (zustand)
			{
			case 1: if (inhaltWasser.contains(".")) JOptionPane.showMessageDialog(null, "Die Zahl enthält bereits ein Komma!");
			else{
				inhaltWasser = wasser.getText();
				inhaltWasser += ".";
				wasser.setText(inhaltWasser); 
			}break;


			case 2:	if (inhaltStrom.contains(".")) JOptionPane.showMessageDialog(null, "Die Zahl enthält bereits ein Komma!");
			else{
				inhaltStrom = strom.getText();
				inhaltStrom += ".";
				strom.setText(inhaltStrom);
			}break;

			}
		}

	}
	public void open() throws IOException
	{
		FileReader fr = new FileReader(Datei.getAbsoluteFile());
		BufferedReader br = new BufferedReader (fr);
		String temp = br.readLine();
		br.close();
		if(temp != null)
		{
			String[] packs = temp.split(";");
			for (String pack : packs)
			{
				String[] items = pack.split(":"); 
				String key = items[0];
				String value = items[1];
				String[] strowa = value.split("-");
				String water = strowa[1];
				String power = strowa[0];
				DateObject tempob = new DateObject(key, water, power);
				Date.put(key, tempob.getData());
				System.out.println("Geladener Wert: "+ key);
			} 
		}
	}
	public void close () throws IOException
	{
		try {
			StringBuilder builder = new StringBuilder();

			for (String t : Date.keySet())
			{
				builder.append(t+":"+Date.get(t)+";");
			}

			FileWriter fw = new FileWriter(Datei.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter (fw);
			bw.write(builder.toString());
			bw.newLine();
			bw.close();
			System.out.println("Schreiben erfolgreich!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Ups! Beim speicher ist ein fehler passiert!");
		}

	}
	public void save() throws IOException
	{
		inhaltWasser = wasser.getText();
		try { 
			Double.parseDouble(inhaltWasser);
		} catch (NumberFormatException e) {
			e.getCause();
			JOptionPane.showMessageDialog(null,"Input ist keine Zahl.");
		}
		inhaltStrom = strom.getText();
		try { 
			Double.parseDouble(inhaltStrom);
		} catch (NumberFormatException e) {
			e.getCause();
			JOptionPane.showMessageDialog(null,"Input ist keine Zahl.");
		}
		inhaltDate = JFDate.getText();
		
		DateObject daob = new DateObject (inhaltDate, inhaltWasser, inhaltStrom);
		Date.put(JFDate.getText(), daob.getData());

		System.out.println(inhaltWasser);
		System.out.println(inhaltStrom);
	}
	public void load() throws IOException
	{
		inhaltDate = JFDate.getText();
		String tempdate = Date.get(JFDate.getText());
		if(tempdate != null)
		{
			String[] tmp = tempdate.split("-");
			wasser.setText(tmp[1]);
			strom.setText(tmp[0]);
		}
		else JOptionPane.showMessageDialog(null, "Nothing to load!"); 
	}

}
