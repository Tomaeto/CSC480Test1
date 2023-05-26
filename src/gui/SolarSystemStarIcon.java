package gui;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class SolarSystemStarIcon implements Icon {
	
	private SolarSystemStarEnum starCode;
	private int width = 240, height = 245, top, left;
	private Image solarPicture = new ImageIcon(
			"data/images/solarsystem.jpg").getImage();
	private double ratio = 1;

	public SolarSystemStarIcon(SolarSystemStarEnum starCode) {
		this.starCode = starCode;
	    setValues();
	}

	private void setValues() {
		int row = starCode.ordinal() / 4;
		int col = starCode.ordinal() % 4;
		top = 20 + row * height;
		left = 35 + col * width;
		ratio = Math.log10(starCode.radius())/15;
	}
	
	double getRatio() {
		return ratio;
	}

	public int getIconHeight() {
		// TODO Auto-generated method stub
		return (int)(height * ratio);
	}

	public int getIconWidth() {
		// TODO Auto-generated method stub
		return (int)(width * ratio);
	}

	public void paintIcon(Component c, Graphics g, int x, int y) {
	    g.drawImage(solarPicture, x, y, x+(int)(width * ratio), 
	    		y+(int)(height * ratio), 
	    		left, top, left + width, top + height, null);
	}

	public void setRatio(double d) {
		ratio = d;
	}

}
