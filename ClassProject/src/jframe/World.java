package jframe;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


import materials.HarvestableBlock;
import math.GenerateWorld;
import references.Reference;

public class World extends Canvas implements KeyListener{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean updateImage = true;
	private boolean isOnResource = false;
	private Image offscreen;
	private GenerateWorld gw;
	private int maxBound;
	private int worldSize = 64;
	private Graphics offgc;
	private int x,y;
	private int speed = 1;
	private char currentChar;
	private Font paintFont;
	
	public World()
	{
        this.addKeyListener(this);
		x = 0; y = 0;
		
		maxBound = 64 * worldSize - 1;
		gw = new GenerateWorld(worldSize);
		offscreen = gw.getWorldImage();
		paintFont = new Font("Arial", Font.PLAIN, 15);
        setFont(paintFont);
        getFontMetrics(paintFont);
        //this.setSize(Reference.JFRAMEWIDTH, Reference.JFRAMEHEIGHT);
        //this.repaint();
	}
	
	
	public void paint(Graphics g)
	{
		//checkDirection();
		if(this.updateImage){
			offscreen = createImage(maxBound, maxBound);
			offgc = offscreen.getGraphics();
			
			
				for(int y = 0; y < worldSize; y++)
				{
					for(int x = 0; x < worldSize; x++)
					{
						for(int i = 0; i < gw.getWTG().getBlocks().size(); i++)
						{
							if(gw.getWorldGrid()[y][x] == gw.getWTG().getBlocks().get(i).getID())
							{
								offgc.drawImage(gw.getWTG().getBlocks().get(i).getBI(), x * 64, y * 64, 64, 64, null);
							}
						}
					}
					
				}
				this.updateImage = false;
			}
			
			
			
			g.drawImage(offscreen, 0 - x, 0 - y, null);
	 
				g.setColor(Color.WHITE);
				g.fillRect(240, 240, 10, 10);
				//System.out.println(x);
				//System.out.println(y);
				
				
				if(isOnResource)
				{
					g.drawString("[F]", 237,  270);
				}
		
	}
	
	
	public void checkDirection()
	{
		//TODO CURRENTLY BUGGED WITH COLLISION DETECTION
		if(currentChar == 'A' && x > 0 - 240 && !this.gw.getWTG().getBlockHandler().getBlockFromID(this.gw.getWorldGrid()[( y + 240) / 64][(x + 239) / 64]).getBarrier() && !this.gw.getWTG().getBlockHandler().getBlockFromID(this.gw.getWorldGrid()[( y + 250) / 64][(x + 239) / 64]).getBarrier()){
			this.x -= speed; 
			this.repaint();
		}
		if(currentChar == 'D' && x < ((maxBound - speed) - Reference.JFRAMEWIDTH) + 250 && !this.gw.getWTG().getBlockHandler().getBlockFromID(this.gw.getWorldGrid()[( y + 250) / 64][(x + 251) / 64]).getBarrier() && !this.gw.getWTG().getBlockHandler().getBlockFromID(this.gw.getWorldGrid()[( y + 240) / 64][(x + 251) / 64]).getBarrier()){
			this.x += speed; 
			this.repaint();
		}
		if(currentChar == 'W' && y > 0 - 240 && !this.gw.getWTG().getBlockHandler().getBlockFromID(this.gw.getWorldGrid()[( y + 239) / 64][(x + 240) / 64]).getBarrier() && !this.gw.getWTG().getBlockHandler().getBlockFromID(this.gw.getWorldGrid()[( y + 239) / 64][(x + 250) / 64]).getBarrier()){
			this.y -= speed; 
			this.repaint();
			}
		if(currentChar == 'S' && y < ((maxBound - speed) - Reference.JFRAMEHEIGHT) + 250 && !this.gw.getWTG().getBlockHandler().getBlockFromID(this.gw.getWorldGrid()[( y + 241) / 64][(x + 250) / 64]).getBarrier() && !this.gw.getWTG().getBlockHandler().getBlockFromID(this.gw.getWorldGrid()[( y + 251) / 64][(x + 240) / 64]).getBarrier()){
			this.y += speed;
			this.repaint();
			//this.repaint();
		}
		if(gw.getWTG().getBlockHandler().getBlockFromID(gw.getWorldGrid()[(y + 240) / 64][(x + 240) / 64]).getClass() == HarvestableBlock.class)
		{
			this.isOnResource = true;
			if(this.currentChar == 'F')
			{
				gw.getWorldGrid()[(y + 240) / 64][(x + 240) / 64] = 1;
				offgc.drawImage( gw.getWTG().getBlockHandler().getBlockFromID(1).getBI(), ((x + 240) / 64) * 64, ((y + 240) / 64) * 64, 64, 64, null);

				this.repaint();
			}
		}
		else this.isOnResource = false;
	//this.validate();
		//this.updateUI();
		
	}
	/**
	 * returns the x coordinate
	 * @return
	 */
	public int getX()
	{
		return this.x;
	}
	
	/**
	 * returns the y coordinate
	 * @return
	 */
	public int getY()
	{
		return this.y;
	}
	
	/**
	 * sets the x coordinate
	 * @param x
	 */
	public void setX(int x)
	{
		this.x = x;
	}
	
	/**
	 * Sets the y coordinate
	 */
	public void setY(int y)
	{
		this.y = y;
	}
	
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		/*if(e.getKeyChar() == 'A') this.currentChar = 'A'; 
		if(e.getKeyChar() == 'D') this.currentChar = 'D'; 
		if(e.getKeyChar() == 'W') this.currentChar = 'W';
		if(e.getKeyChar() == 'S') this.currentChar = 'S';
		System.out.println("current char logged" + this.currentChar);*/
		this.currentChar = e.getKeyChar();
		//this.repaint();
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyChar() == currentChar){
		this.currentChar = Character.MIN_VALUE;
		}
	}

}
