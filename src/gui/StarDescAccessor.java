package gui;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StarDescAccessor {
	String[] descs = new String[12];
	
	public StarDescAccessor () throws FileNotFoundException {
		File descText = new File("data/desc/starDesc");
		Scanner descReader = new Scanner(descText);
		
		int i = 0;
		while (descReader.hasNextLine())
		{
			descs[i] = descReader.nextLine();
			i++;
		}
		descReader.close();
	}
	
	public String getDescription(SolarSystemStarEnum ssse)
	{
		int index = 0;
		switch (ssse) {
    	case SUN:
    		index = 0;
    		break;
    	case MERCURY:
    		index = 1;
    		break;
    	case VENUS:
    		index = 2;
    		break;
    	case EARTH:
    		index = 3;
    		break;
    	case MARS:
    		index = 4;
    		break;
    	case JUPITER:
    		index = 5;
    		break;
    	case NEPTUNE:
    		index = 6;
    		break;
    	case SATURN:
    		index = 7;
    		break;
    	case URANUS:
    		index = 8;
    		break;
    	case PLUTO:
    		index = 9;
    		break;
    	case MOON:
    		index = 10;
    		break;
    	case ASTEROID:
    		index = 11;
    		break;
		}
		
		return descs[index];
	}
}
