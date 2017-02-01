package jframe;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.Timer;

import references.Reference;
import utility.LoadImages;

public class BaseCanvas extends Canvas implements KeyListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1063684247186289486L;

	//Timer time = new Timer(75, this);
	private int x,y;
	private int speed = 5;
	private int maxBound;
	private int worldSize = 50;
	private char currentChar;
	
	private LoadImages li = new LoadImages();
	private BufferedImage grass, wall;
	private Image offscreen;

	public BaseCanvas()
	{
		this.setSize(Reference.JFRAMEWIDTH,Reference.JFRAMEHEIGHT);
		
			grass = li.getSubImg(1, 1);
			wall = li.getSubImg(1, 2);
			//time.start();
			x = 0; y = 0;
			this.addKeyListener(this);
			maxBound = 64 * worldSize - 1;
			
	}
	
	public void paint(Graphics g)
	{
		
		Graphics offgc;
		offscreen = createImage(maxBound, maxBound);
		offgc = offscreen.getGraphics();
		
			for(int i = 0; i < worldSize; i++)
			{
				for(int q = 0; q < worldSize; q++)
				{
					offgc.drawImage(grass,i * 64,q * 64,64,64, null );

				}
				
			}
			g.drawImage(offscreen, 0 - x, 0 - y, null);

		//	offset++;
		
					
	//	this.repaint(0, 0, 500, 500);
	}
	
	public int getX()
	{
		return this.x;
	}
	
	public int getY()
	{
		return this.y;
	}
	
	public void setX(int x)
	{
		this.x = x;
	}
	public void setY(int y)
	{
		this.y = y;
	}
	
	public char getCurrentChar()
	{
		return this.currentChar;
	}
	
	public void repaint()
	{
		this.getGraphics().drawImage(offscreen, 0 - x, 0 - y, null);

	}
	
	public void checkDirection()
	{
		if(currentChar == 'A' && x > 0) this.x -= speed; 
		if(currentChar == 'D' && x < ((maxBound - speed) - Reference.JFRAMEWIDTH)) this.x += speed; 
		if(currentChar == 'W' && y > 0) this.y -= speed; 
		if(currentChar == 'S' && y < ((maxBound - speed) - Reference.JFRAMEHEIGHT)) this.y += speed;
		this.repaint();

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyChar() == 'A') this.currentChar = 'A'; 
		if(e.getKeyChar() == 'D') this.currentChar = 'D'; 
		if(e.getKeyChar() == 'W') this.currentChar = 'W';
		if(e.getKeyChar() == 'S') this.currentChar = 'S';
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyChar() == currentChar){
		this.currentChar = Character.MIN_VALUE;
		}
	}
}
