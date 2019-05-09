package noapplet;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

public class Ball extends NoApplet {
	
	 private Color color = Color.white;
	    private int radius = 20;
	    private int x, y;
	    private int dx = -2, dy = -4;
	        
	    private Image image;
	    private Graphics offScreen;
	    private Dimension dim;
}
