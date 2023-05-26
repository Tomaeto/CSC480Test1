package gui;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.Random;

public enum SolarSystemStarEnum {
//	Sun, Mercury, Venus, Earth, Mars, Jupiter, Neptune, Saturn, Uranus, Pluto, Moon, Asteroid;
	SUN		(1.989e+30, 6.960e8),
    MERCURY (3.303e+23, 2.4397e6),
    VENUS   (4.869e+24, 6.0518e6),
    EARTH   (5.976e+24, 6.37814e6),
    MARS    (6.421e+23, 3.3972e6),
    JUPITER (1.9e+27,   7.1492e7),
    NEPTUNE (1.024e+26, 2.4746e7),
    SATURN  (5.688e+26, 6.0268e7),
    URANUS  (8.686e+25, 2.5559e7),
    PLUTO	(1.2e+22, 1.185e6),
    MOON	(7.346e+22, 1.736e6),
    ASTEROID(1.0e+5, 1.0e2);
	
    private final double mass;   // in kilograms
    private final double radius; // in meters
    SolarSystemStarEnum(double mass, double radius) {
        this.mass = mass;
        this.radius = radius;
    }
    
    public double mass() { 
    	return mass; 
    }
    
    public double radius() { 
    	return radius; 
    }
     
    public String description() throws FileNotFoundException {
    	StarDescAccessor sde = new StarDescAccessor();
    	return sde.getDescription(this);
}
    
    public static SolarSystemStarEnum randomChooseStar() {
    	Random r = new Random(System.currentTimeMillis());
    	int index = r.nextInt(SolarSystemStarEnum.values().length);
    	return SolarSystemStarEnum.values()[index];
    }
}
