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
	private Manager manager;
	public ContentPane()
	{
		manager = new Manager();
		manager.setBounds(0, 0, Reference.JFRAMEWIDTH, Reference.JFRAMEHEIGHT);
		manager.setBackground(Color.BLACK);
		this.add(manager);
	}
	
	public Manager getManager()
	{
		return this.manager;
	}
	public void paint(Graphics g)
	{
		
	}
	
	public void repaint()
	{
		
	}
}
