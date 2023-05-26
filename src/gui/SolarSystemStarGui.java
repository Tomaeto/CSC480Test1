package gui;

import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;

//Adrian Faircloth
//10-11-22
//CSC480 Test 4 GUI
//GUI elements for 3-element panel for Solar System Panel program (Updated version of Workshop 4 class)

public class SolarSystemStarGui {
	private JTextArea starInfo = new JTextArea(10,40);
	public JTextField textField = new JTextField(10);
	private Timer t;
	
	/**
	 * Constructs a Panel with a JTextField cycling through stars randomly
	 * and JButton for choosing star in TextField
	 * On JButton press, updates starInfo w/ star's description
	 * @param listener ActionListener for JButton
	 * @return choicePanel Panel w/ JTextField and JButton
	 */
	public JPanel buildChoicePanel(ActionListener listener) {
		JPanel choicePanel = new JPanel();
		
		textField.setText("SATURN");

		ActionListener tListener = event -> {
			String nextStar = SolarSystemStarEnum.randomChooseStar().toString();
			textField.setText(nextStar.toString());
			
		};
	
		final int DELAY = 1000;
		t = new Timer(DELAY, tListener);
		t.start();
		

		JButton choiceButton = new JButton("Choose This Star");
		choiceButton.addActionListener(listener);	

		choicePanel.add(textField);
		choicePanel.add(choiceButton);
		return choicePanel;
	}
	
	/**
	 * Builds initial JTextArea for star description w/ text wrap and default text
	 * @return starInfo JTextArea for star description
	 */
	public JTextArea buildStarInfo() {
		starInfo.setLineWrap(true);
		starInfo.setText("Choose a star!");
		
		return starInfo;
	}

	/**
	 * Updates starInfo w/ description of star taken from choicePanel's textField
	 * Called on JButton press in choicePanel
	 * @throws FileNotFoundException 
	 */
	public void setStarInfo(SolarSystemStarEnum ssse) throws FileNotFoundException {
		if (ssse == null)
			ssse = getStar();
		starInfo.setText(ssse.description());
	}
	
	/**
	 * Stops Timer t, stopping random cycling of Star names in choicePanel
	 */
	public void stopTimer() {
		t.stop();
	}
	
	/**
	 * Returns SolarSystemStarEnum entry for Star chosen in choicePanel
	 * @return e SolarSystemStarEnum entry
	 */
	public SolarSystemStarEnum getStar() {
		String starName = textField.getText();
		for (SolarSystemStarEnum e: SolarSystemStarEnum.values())
		{
			if (e.name().trim().equals(starName.trim()))
				return e;
		}
		return null;
	}
	
	/**
	 * Builds JTable w/ data for each star (name, mass, radius)
	 * @return table JTable w/ star data
	 */
	public JTable buildStarTable() {
		JTable table;
		String[] columns = {"Star Name", "Mass (kg)", "Radius (m)"};
		String[][] data = loadData();
		table = new JTable(data, columns);
		table.setBounds(30,40,200,300);
		return table;
	}
	
	/**
	 * Loads data (name, mass, radius) for stars from SolarSystemStarEnum into 2D array
	 * for buildStarTable()
	 * @return starData 2D String array w/ data for stars
	 */
	public String[][] loadData() {
		String[][] starData = new String[12][3];
		int i = 0;
		for (SolarSystemStarEnum e: SolarSystemStarEnum.values())
		{
			String[] thisStarData = {e.name(), String.valueOf(e.mass()), String.valueOf(e.radius())};
			starData[i] = thisStarData;
			i++;
		}
		return starData;
	}





}