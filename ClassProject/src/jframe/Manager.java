package jframe;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import gui.Inventory;
import materials.HarvestableBlock;
import math.GenerateWorld;
import references.Reference;


public class Manager extends JLayeredPane{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1063684247186289486L;


	
	
	private char currentChar;
	
	private World world = new World();
	private ProgressBar pb;



	public Manager()
	{
	
	     
		
			//this.setSize(Reference.JFRAMEWIDTH,Reference.JFRAMEHEIGHT);
			
			this.setFocusable(true);
			pb = new ProgressBar(100, 100, 100, 20, 100);
			this.setBounds(0, 0, Reference.JFRAMEWIDTH, Reference.JFRAMEHEIGHT);
			//pb.setBounds(x, y, width, height);
			world.setBounds(0, 0, Reference.JFRAMEWIDTH, Reference.JFRAMEHEIGHT);
			this.add(world,1);
	        this.add(pb, 0);
	    
	        
	        
			
	}
	public void ThreadOperation()
	{
		
	}
	
	
	public World getWorld()
	{
		return this.world;
	}
	
	
	

	/**
	 * paints the graphics
	 * @param g
	 */
	/*public void paint(Graphics g)
	{
		//System.out.println("painted 1");
		
			
			
		//	g.drawImage(offscreen,  0 - x,  0 - y, null);
		//	System.out.println("painted");

	}*/
	//public void repaint()
	//{
	//	
	//}
	
	
	
	/*@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(world.getGraphics());
		super.paintComponent(pb.getGraphics());
		//world.repaint();
			
		//System.out.println("painted");
	}*/
	
	
	
	/**
	 * returns the current character that is being pressed down
	 * @return
	 */
	public char getCurrentChar()
	{
		return this.currentChar;
	}
	
	/**
	 * repaints the screen
	 */
	
	
/*	public void repaint()
	{
		//this.getGraphics().drawImage(offscreen, 0 - x, 0 - y, null);
		this.getGraphics().fillRect(240, 240, 10, 10);
		//this.getGraphics().translate(x + 250, y + 250);
		//offscreen.getGraphics().translate(x + 250, y + 250);
		System.out.println(x);
		//this.getGraphics().translate(x, y);
		this.getGraphics().setClip(x, y, 500, 500);
		
		
		//System.out.println(x);
		//System.out.println(y);

	}
	*/
	/**
	 * checks the key that is being typed and changes the x and y coordinates accordingly 
	 */
	
	

	
}
