package main;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import gui.*;

//Adrian Faircloth
//10-16-22
//CSC480 Test 4 Main
//Main class for Solar System Panel program

public class SolarSystemStarPanel extends JPanel {
	public List<JButton> stars = new ArrayList<JButton>();
	public JLabel westImage = new JLabel();
	public SolarSystemStarGui gui = new SolarSystemStarGui();
	
	/**
	 * Constructor for Star Panel, builds UI for program
	 */
	public SolarSystemStarPanel() {
		setLayout(new BorderLayout());
		createUI();
	}

	/**
	 * Creates UI elements for program
	 * Adds Icon, "control panel" with button for each Star, Image of Star, 3-element panel from Workshop 4
	 */
	private void createUI() {		
		JLabel solarSystemLabel = new JLabel(new ImageIcon(
				"data/images/order-of-planets-in-the-solar-system.jpg"));
		add(solarSystemLabel, BorderLayout.CENTER);
		
		//Building control panel of buttons that display info of star
		JPanel controlPanel = new JPanel();
		SolarSystemStarIcon icon;
	    JButton btn;
		for (SolarSystemStarEnum e : SolarSystemStarEnum.values()) {
			icon = new SolarSystemStarIcon(e);
			//System.out.println(e.toString() + ": " + icon.getRatio()); 
			btn = new JButton(icon);
			btn.addActionListener(event -> {
				setWestImage(e);
				try {
					gui.setStarInfo(e);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			});
			btn.setHorizontalAlignment(SwingConstants.CENTER);
			stars.add(btn);
			controlPanel.add(btn);
		}
		add(controlPanel, BorderLayout.SOUTH);
		
		//Adding image of star to western border
		setWestImage(SolarSystemStarEnum.NEPTUNE);
		
		//Adding 3-element panel (data, info, choice button) to eastern border
		add(buildEastPanel(), BorderLayout.EAST);
		
		//Adding timer to timeout after 1 minute of inactivity
		Timer t1 = new Timer();
		t1.schedule(new TimerTask() {
			@Override
			public void run() {
				gui.stopTimer();
				setWestImage(gui.getStar());
				try {
					gui.setStarInfo(null);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				t1.cancel();
			}
		}, 60000);
	}
	
	/**
	 * Builds 3-element panel (data table, info text, choice button) from Workshop 4 for eastern border
	 * Adds ActionListener to choice button for setting text and western image
	 * @return panel the 3-element panel
	 */
	public JPanel buildEastPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.add(gui.buildStarTable());
		panel.add(gui.buildStarInfo());
		
		ActionListener choiceListener = event -> {
			gui.stopTimer();
			try {
				gui.setStarInfo(null);
				SolarSystemStarEnum ssse = gui.getStar();
				setWestImage(ssse);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		};
		panel.add(gui.buildChoicePanel(choiceListener));
		return panel;
	}

	/**
	 * Sets the image on western border to image of given star
	 * @param ssse Enum of star to set image for
	 */
	public void setWestImage(SolarSystemStarEnum ssse) {
		westImage.setIcon(new SolarSystemStarIcon(ssse));
		add(westImage, BorderLayout.WEST);
		
	}
	
	/**
	 * Main function of program
	 * Puts Star Panel into a JFrame with an ImageIcon and title
	 */
	public static void main(String[] args) {
		JFrame solarSystemFrame = new JFrame("Solar System Stars");
		solarSystemFrame.setIconImage(new ImageIcon(
				"data/images/writeicon.png").getImage());
		SolarSystemStarPanel schP = new SolarSystemStarPanel();
		solarSystemFrame.add(schP, BorderLayout.CENTER);

		solarSystemFrame.pack();
		solarSystemFrame.setVisible(true);
		solarSystemFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
