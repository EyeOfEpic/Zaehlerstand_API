import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class Fensta {

	public JFrame frame;
	public JTextField wasser;
	public String inhaltWasser = "0";
	public String inhaltStrom = "0";
	DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
	Calendar cal = Calendar.getInstance();
	public String inhaltDate = dateFormat.format(cal.getTime());
	public int laenge1 ;
	public int laenge2 ;
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
	private JLabel lblWasser;
	private JLabel lblStrom;
	private JTextField strom;
	public int zustand = 0;
	public JTextField JFDate;
	public File Datei = new File("/Users/Felix Raab/Desktop/Schule/Eclipse/Koelloe_Zaehlerstand/test.txt");
	HashMap<String, String> Date = new HashMap<String, String>();

	private JButton btnLoad;



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
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent arg0) {
				try {
					close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		try {
			open();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		frame.setBounds(100, 100, 300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[grow][][][][][][][][grow]", "[][][][][][][][]"));


		wasser = new JTextField();
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

		JFDate = new JTextField();
		frame.getContentPane().add(JFDate, "cell 0 0,growx");
		JFDate.setColumns(10);
		JFDate.setText(inhaltDate);

		lblWasser = new JLabel("Wasser");
		frame.getContentPane().add(lblWasser, "cell 0 1");
		frame.getContentPane().add(wasser, "cell 0 2,growx");
		wasser.setColumns(10);

		button = new JButton("7");
		button.addActionListener(new ZahlListener());
		frame.getContentPane().add(button, "cell 2 2");

		button_1 = new JButton("8");
		button_1.addActionListener(new ZahlListener());
		frame.getContentPane().add(button_1, "cell 3 2");

		button_2 = new JButton("9");
		button_2.addActionListener(new ZahlListener());
		frame.getContentPane().add(button_2, "cell 4 2");

		button_3 = new JButton("4");
		button_3.addActionListener(new ZahlListener());

		lblStrom = new JLabel("Strom");
		frame.getContentPane().add(lblStrom, "cell 0 3");
		frame.getContentPane().add(button_3, "cell 2 3");

		button_4 = new JButton("5");
		button_4.addActionListener(new ZahlListener());
		frame.getContentPane().add(button_4, "cell 3 3");

		button_5 = new JButton("6");
		button_5.addActionListener(new ZahlListener());
		frame.getContentPane().add(button_5, "cell 4 3");

		button_6 = new JButton("1");
		button_6.addActionListener(new ZahlListener());

		strom = new JTextField();
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
		frame.getContentPane().add(strom, "cell 0 4,growx");
		strom.setColumns(10);
		frame.getContentPane().add(button_6, "cell 2 4");

		button_7 = new JButton("2");
		button_7.addActionListener(new ZahlListener());
		frame.getContentPane().add(button_7, "cell 3 4");

		button_8 = new JButton("3");
		button_8.addActionListener(new ZahlListener());
		frame.getContentPane().add(button_8, "cell 4 4");

		button_9 = new JButton("0");
		button_9.addActionListener(new ZahlListener());
		frame.getContentPane().add(button_9, "cell 3 5");

		button_10 = new JButton(".");
		button_10.addActionListener(new KommaListener());
		frame.getContentPane().add(button_10, "cell 4 5");

		JButton btnSave = new JButton("Save");
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
		frame.getContentPane().add(btnLoad, "cell 0 6,alignx center");
		frame.getContentPane().add(btnSave, "cell 0 7,alignx center,aligny baseline");
	}
	/**
	 * ActionListener
	 */
	class ZahlListener implements ActionListener
	{

		@Override
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

	}
	public void save() throws IOException
	{
		inhaltWasser = wasser.getText();
		inhaltStrom = strom.getText();
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
		String[] tmp = tempdate.split("-");
		wasser.setText(tmp[1]);
		strom.setText(tmp[0]);
	}

}
