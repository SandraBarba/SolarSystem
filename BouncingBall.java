package noapplet;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.Timer;
import java.math.*;

import noapplet.NoApplet;

/** 
 * Sample NoApplet showing a ball moving inside a rectangular box.
 * See Section 5.5.3 on pages 195-197.
 */
@SuppressWarnings("serial")

public class BouncingBall extends NoApplet {

    private Color sun = Color.YELLOW;
    private int radius = 40;
    private int x, y;
    private int dx = -2, dy = -4;
   
        
    private Color earth = Color.BLUE;
    private int radius2 = 10;
    private int x2, y2;
    private int dx2 = -2, dy2 = -4;
    
    private Color mars = Color.RED;
    private int radius3 = 10;
    private int x3, y3;
    private int dx3 = -2, dy3 = -4;
    
    private Image image;
    private Graphics offScreen;
    private Dimension dim;
    
    private Timer timer;
    private int delay = 10;
    
    
    @Override
    public void init() { 
    	String param = getParameter("delay");
    	if (param != null) {
    		delay = Integer.parseInt(param);
    	}
    	dim = getSize();
        x = 200;
        y = 200;
        timer = new Timer(delay, e -> repaint());
        
        dim = getSize();
        x2 = 100;
        y2 = 100;
        timer = new Timer(delay, e -> repaint());
        
        dim = getSize();
        x3 = 100;
        y3 = 100;
        timer = new Timer(delay, e -> repaint());
        
    }
    @Override
    public void update(Graphics g) {
    	// create an off-screen image and its grapchics
    	if (image == null) {
    		image = createImage(dim.width, dim.height);
    		offScreen = image.getGraphics();
    	}
    	// fill the background
    	offScreen.setColor(Color.BLACK);
    	offScreen.fillRect(0, 0, dim.width, dim.height);
    	
    	// adjust the position of the ball
     	if (x2 < radius || x2 > dim.height - radius ) {
    		x2 = radius * (int) Math.cos(45);
     		dx2 = -dx2;
        }
    	if (y2 < radius || y2 > dim.height - radius) {
    		y2 = radius * (int) Math.sin(45);
    		dy2 = -dy2;
        }
    	x2 += dx2;
    	y2 += dy2;
        
    	 //draw the ball and dump the off-screen image
    	offScreen.setColor(sun);
    	offScreen.fillOval(x - radius, y - radius, radius * 2, radius * 2);
    	g.drawImage(image, 0,  0,  this);
    	
    	offScreen.setColor(earth);
    	offScreen.fillOval(x2 - radius2, y - radius2, radius2 * 2, radius2 * 2);
    	g.drawImage(image, 0,  0,  this);
    	
    	offScreen.setColor(mars);
    	offScreen.fillOval(x3 - radius3, y3 - radius3, radius3 * 2, radius3 * 2);
    	g.drawImage(image, 0,  0,  this);
    }
    
    @Override
    public void paintComponent(Graphics g) { 
        update(g); 
    }

    /** Start the animation. */
    @Override
    public void start() {
        timer.start();
    }

    /** Stop the animation. */
    @Override
    public void stop() {
        timer.stop();
    }
    
    public static void main(String[] args) {
    	new BouncingBall().run();
    }
    
}