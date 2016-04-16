import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.text.*;
import java.util.*;
import java.awt.*;

public class Fensta {

	private JFrame frame;
	private JTextField wasser;
	private JTextField strom;
	private JTextField JFDate;
	private JButton b0;
	private JButton b1;
	private JButton b2;
	private JButton b3;
	private JButton b4;
	private JButton b5;
	private JButton b6;
	private JButton b7;
	private JButton b8;
	private JButton b9;
	private JButton bkomma;
	private JButton btnLoad;
	private JButton btnSave;
	private JButton plusWas;
	private JButton minusWas;
	private JButton plusStrom;
	private JButton minusStrom;
	private JButton btnWriteToFile;
	private JLabel lblSchritte;
	private JLabel lblWasser;
	private JLabel lblStrom;
	private JRadioButton schritt1;
	private JRadioButton schritt01;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
	Calendar cal = Calendar.getInstance();
	private String inhaltDate = dateFormat.format(cal.getTime());
	private int zustand = 0;
	private File Datei = new File("Datenbank.txt");
	private HashMap<String, String> Date = new HashMap<String, String>();
	private double schritt = 1.0;
	private String inhaltWasser = "0";
	private String inhaltStrom = "0";

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
	public Fensta() throws IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() throws IOException {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setFont(new Font("Dialog", Font.PLAIN, 10));
		frame.setBounds(100, 100, 317, 241);
		frame.getContentPane().setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		open();
/**
 * Buttons
 */
		b1 = new JButton("1");
		b1.setBounds(160, 104, 39, 23);
		b1.setMargin(new Insets(0,0,0,0));
		b1.addActionListener(new ZahlListener());
		frame.getContentPane().add(b1);

		b2 = new JButton("2");
		b2.setBounds(205, 104, 39, 23);
		b2.setMargin(new Insets(0,0,0,0));
		b2.addActionListener(new ZahlListener());
		frame.getContentPane().add(b2);

		b3 = new JButton("3");
		b3.setBounds(250, 104, 39, 23);
		b3.setMargin(new Insets(0,0,0,0));
		b3.addActionListener(new ZahlListener());
		frame.getContentPane().add(b3);

		b4 = new JButton("4");
		b4.setBounds(160, 77, 39, 23);
		b4.setMargin(new Insets(0,0,0,0));
		b4.addActionListener(new ZahlListener());
		frame.getContentPane().add(b4);


		b5 = new JButton("5");
		b5.setBounds(205, 77, 39, 23);
		b5.setMargin(new Insets(0,0,0,0));
		b5.addActionListener(new ZahlListener());
		frame.getContentPane().add(b5);

		b6 = new JButton("6");
		b6.setBounds(250, 77, 39, 23);
		b6.setMargin(new Insets(0,0,0,0));
		b6.addActionListener(new ZahlListener());
		frame.getContentPane().add(b6);

		b7 = new JButton("7");
		b7.setMargin(new Insets(0,0,0,0));
		b7.setBounds(160, 50, 39, 23);
		b7.addActionListener(new ZahlListener());
		frame.getContentPane().add(b7);

		b8 = new JButton("8");
		b8.setBounds(205, 50, 39, 23);
		b8.setMargin(new Insets(0,0,0,0));
		b8.addActionListener(new ZahlListener());
		frame.getContentPane().add(b8);

		b9 = new JButton("9");
		b9.setBounds(250, 50, 39, 23);
		b9.setMargin(new Insets(0,0,0,0));
		b9.addActionListener(new ZahlListener());
		frame.getContentPane().add(b9);

		b0 = new JButton("0");
		b0.setBounds(205, 131, 39, 23);
		b0.setMargin(new Insets(0,0,0,0));
		b0.addActionListener(new ZahlListener());
		frame.getContentPane().add(b0);

		bkomma = new JButton(".");
		bkomma.setBounds(250, 131, 39, 23);
		bkomma.setMargin(new Insets(0,0,0,0));
		bkomma.addActionListener(new KommaListener());
		frame.getContentPane().add(bkomma);

		plusWas = new JButton("\u02C4");
		plusWas.setFont(new Font("Tahoma", Font.PLAIN, 10));
		plusWas.setBounds(104, 50, 35, 10);
		plusWas.setMargin(new Insets(0,0,0,0));
		plusWas.addActionListener(new plusWasListener());
		frame.getContentPane().add(plusWas);

		minusWas = new JButton("\u02C5");
		minusWas.setFont(new Font("Tahoma", Font.PLAIN, 10));
		minusWas.setBounds(104, 60, 35, 10);
		minusWas.setMargin(new Insets(0,0,0,0));
		minusWas.addActionListener(new minusWasListener());
		frame.getContentPane().add(minusWas);

		plusStrom = new JButton("\u02C4");
		plusStrom.setFont(new Font("Tahoma", Font.PLAIN, 10));
		plusStrom.setBounds(104, 104, 35, 10);
		plusStrom.setMargin(new Insets(0,0,0,0));
		plusStrom.addActionListener(new plusStromListener());
		frame.getContentPane().add(plusStrom);

		minusStrom = new JButton("\u02C5");
		minusStrom.setFont(new Font("Tahoma", Font.PLAIN, 10));
		minusStrom.setBounds(104, 114, 35, 10);
		minusStrom.setMargin(new Insets(0,0,0,0));
		minusStrom.addActionListener(new minusStromListener());
		frame.getContentPane().add(minusStrom);

		btnSave = new JButton("Save");
		btnSave.setBounds(82, 135, 57, 23);
		btnSave.setMargin(new Insets(0,0,0,0));
		btnSave.addActionListener(new saveListener());
		frame.getContentPane().add(btnSave);

		btnLoad = new JButton("Load");
		btnLoad.setBounds(17, 135, 55, 23);
		btnLoad.setMargin(new Insets(0,0,0,0));
		btnLoad.addActionListener(new loadListener());
		frame.getContentPane().add(btnLoad);

		btnWriteToFile = new JButton("Write to File");
		btnWriteToFile.setBounds(17, 169, 122, 23);
		btnWriteToFile.addActionListener(new fileListener());
		frame.getContentPane().add(btnWriteToFile);
/**
 * Labels
*/
		lblWasser = new JLabel("Wasser");
		lblWasser.setBounds(7, 31, 91, 14);
		frame.getContentPane().add(lblWasser);

		lblStrom = new JLabel("Strom");
		lblStrom.setBounds(7, 80, 91, 14);
		frame.getContentPane().add(lblStrom);

		lblSchritte = new JLabel("Schritt:");
		lblSchritte.setBounds(149, 173, 66, 14);
		frame.getContentPane().add(lblSchritte);
/**
 * TextFields
 */
		wasser = new JTextField();
		wasser.addMouseListener(new WasserMouseListener());
		wasser.setBounds(7, 50, 91, 20);
		wasser.addFocusListener(new wasserFocus());
		wasser.setText(inhaltWasser);
		frame.getContentPane().add(wasser);

		strom = new JTextField();
		strom.addMouseListener(new StromMouseListener());
		strom.setBounds(7, 104, 91, 20);
		strom.setText(inhaltStrom);
		strom.addFocusListener(new stromFocus());
		frame.getContentPane().add(strom);

		JFDate = new JTextField();
		JFDate.setBounds(7, 7, 91, 20);
		JFDate.setColumns(10);
		JFDate.setText(inhaltDate);
		frame.getContentPane().add(JFDate);
		/**
		 * RadioButtons
		 */
		schritt1 = new JRadioButton("1.0");
		schritt1.setMargin(new Insets(0,0,0,0));
		schritt1.setBounds(219, 169, 41, 23);
		schritt1.doClick();
		schritt1.addActionListener(new RadioListener());
		buttonGroup.add(schritt1);
		frame.getContentPane().add(schritt1);

		schritt01 = new JRadioButton("0.1");
		schritt01.setBounds(264, 169, 41, 23);
		schritt01.setMargin(new Insets(0,0,0,0));
		schritt01.addActionListener(new RadioListener());
		buttonGroup.add(schritt01);
		frame.getContentPane().add(schritt01);
	}
	
	/**
	 * ActionListener (Spezielle)
	 */
	class ZahlListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			JButton btn = (JButton) e.getSource();
			switch (zustand)
			{
			case 1:	inhaltWasser = wasser.getText();
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

		public void actionPerformed(ActionEvent e) {
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
	/**
	 * ActionListener für die GUI
	 * @author Felix
	 *
	 */
	private class WasserMouseListener extends MouseAdapter {
		public void mouseClicked(MouseEvent arg0) {
			wasser.setText(null);
		}
	}

	private class StromMouseListener extends MouseAdapter {
		public void mouseClicked(MouseEvent arg0) {
			strom.setText(null);
		}
	}

	private class plusWasListener implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0) {
			double temp = Double.parseDouble(wasser.getText()) + schritt;
			temp = Math.round(temp*100)/100.0; 
			inhaltWasser = Double.toString(temp);
			wasser.setText(inhaltWasser);
		}
	}

	private class minusWasListener implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0) {
			double temp = Double.parseDouble(wasser.getText()) - schritt;
			temp = Math.round(temp*100)/100.0; 
			inhaltWasser = Double.toString(temp);
			wasser.setText(inhaltWasser);
		}
	}

	private class plusStromListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			double temp = Double.parseDouble(strom.getText()) + schritt;
			temp = Math.round(temp*100)/100.0; 
			inhaltStrom = Double.toString(temp);
			strom.setText(inhaltStrom);
		}
	}

	private class minusStromListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			double temp = Double.parseDouble(strom.getText()) - schritt;
			temp = Math.round(temp*100)/100.0; 
			inhaltStrom = Double.toString(temp);
			strom.setText(inhaltStrom);
		}
	}

	private class saveListener implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0) {
			try {
				save();
			} catch (IOException e) {
				System.out.println("Irgendetwas lief beim Speichern schief!");				}
		}
	}

	private class loadListener implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0) {
			try {
				load();
			} catch (IOException e) {
				System.out.println("Irgendetwas lief beim Laden schief!");
			}
		}
	}

	private class fileListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			try {
				close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	private class wasserFocus implements FocusListener
	{
		public void focusGained(FocusEvent arg0) {
			zustand = 1;
		}
		public void focusLost(FocusEvent arg0) {
		}
	}

	private class stromFocus implements FocusListener
	{
		public void focusGained(FocusEvent arg0) {
			zustand = 2;
		}
		public void focusLost(FocusEvent arg0) {
		}
	}

	private class RadioListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			JRadioButton rbtn = (JRadioButton) e.getSource();
			schritt = Double.parseDouble(rbtn.getText());
		}
	}
	/**
	 * Methoden für Speichern/Laden von File, bzw von HashMap
	 * @throws IOException
	 */
	public void open() throws IOException
	{
		try {
			FileReader fr;
			fr = new FileReader(Datei.getAbsoluteFile());
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
		} catch (FileNotFoundException e) {
			System.out.println("Datenbank.txt konnte nicht gefunden werden.. Erstelle sie neu..");
			Datei.createNewFile();
			System.out.println("Datenbank.txt erfolgreich erstellt!");
			open();
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
			System.out.println("Ups! Beim speicher ist ein fehler passiert!");
		}
	}
	public void save() throws IOException
	{
		try {
			inhaltWasser = wasser.getText();
			Double.parseDouble(inhaltWasser);
			inhaltStrom = strom.getText();
			Double.parseDouble(inhaltStrom);
			inhaltDate = JFDate.getText();

			DateObject daob = new DateObject (inhaltDate, inhaltWasser, inhaltStrom);
			Date.put(JFDate.getText(), daob.getData());
			System.out.println(inhaltWasser);
			System.out.println(inhaltStrom);
		} catch (NumberFormatException e) {JOptionPane.showMessageDialog(null,"Input ist keine Zahl.");}
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
