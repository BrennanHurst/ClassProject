package jframe;

import javax.swing.JFrame;

import references.Reference;

public class JFrameStart extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2559895613322769476L;
	//private 
	private World world;
	
	public JFrameStart()
	{
		this.setup();
	}
	
/*	public ContentPane getContentPane()
	{
		return this.cp;
	}*/
	/**
	 * Sets up the dimensions of the Jframe
	 * @since V 0.1
	 */
	private void setup()
	{
		world = new World();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle(Reference.VERSION);
		this.setResizable(true);
		//Define and set standardized content panes
		
		//this.setContentPane(cp = new ContentPane());
		this.add(world);
		this.setVisible(true); 
		this.pack();
		this.setSize(Reference.JFRAMEWIDTH, Reference.JFRAMEHEIGHT);
		//this.cp.getManager().
		world.Start();

	}
	
	public World getWorld()
	{
		return this.world;
	}
}
