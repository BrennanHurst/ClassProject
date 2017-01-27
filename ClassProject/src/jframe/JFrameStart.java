package jframe;

import java.awt.Color;

import javax.swing.JFrame;

import references.Reference;

public class JFrameStart extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2559895613322769476L;
	
	
	public JFrameStart()
	{
		this.setup();
	}
	
	
	
	/**
	 * Sets up the dimensions of the Jframe
	 * @since V 0.1
	 */
	private void setup()
	{
		this.setSize(Reference.JFRAMEWIDTH, Reference.JFRAMEHEIGHT);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//Define and set standardized content panes
		this.setContentPane(new ContentPane());
		
		this.setVisible(true); 
	}
}
