package jframe;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;

import references.Reference;

public class ContentPane extends Container{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1873954675198355591L;

	public ContentPane()
	{
		BaseCanvas baseCanvas = new BaseCanvas();
		baseCanvas.setBounds(0, 0, Reference.JFRAMEWIDTH, Reference.JFRAMEHEIGHT);
		baseCanvas.setBackground(Color.BLACK);
		this.add(baseCanvas);
	}
	public void paint(Graphics g)
	{
		
	}
	
	public void repaint()
	{
		
	}
}