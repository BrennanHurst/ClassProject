package jframe;

import java.awt.Canvas;
import java.awt.Graphics;

import references.Reference;

public class BaseCanvas extends Canvas{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1063684247186289486L;

	public BaseCanvas()
	{
		//this.setBackground(Color.BLACK);
		this.setSize(Reference.JFRAMEWIDTH,Reference.JFRAMEHEIGHT);
	}
	
	public void paint(Graphics g)
	{
		this.repaint();
	}
	
	public void repaint()
	{
		
	}
}
