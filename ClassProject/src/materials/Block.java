package materials;

import java.awt.image.BufferedImage;

public class Block {

	private int occurence;
	private int ID;
	private boolean isBarrier;
	private BufferedImage BI;
	private String name;
	
	public Block()
	{
		this.occurence = Integer.MIN_VALUE;
		this.ID = Integer.MIN_VALUE;
		this.isBarrier = false;
		this.BI = null;
		this.name = null;
	}
	public Block(int occurence, int ID, String name,BufferedImage BI, boolean isBarrier)
	{
		this.occurence = occurence;
		this.ID = ID;
		this.BI = BI;
		this.name = name;
		this.isBarrier = isBarrier;
	}
	
	
	/**
	 * returns the value of the occurence of this material
	 * @return
	 */
	public int getOccurence()
	{
	
		return this.occurence;
	}
	
	/**
	 * returns the buffered image of the material
	 * @return
	 */
	public BufferedImage getBI()
	{
		return this.BI;
	}
	
	/**
	 * returns the ID of the material
	 * @return
	 */
	public int getID()
	{
		return this.ID;
	}
	/**
	 * returns the name of the Material
	 * @return
	 */
	public String getName()
	{
		return name;
	}
	/**
	 * returns true if this material is a barrier
	 * @return
	 */
	public boolean getBarrier()
	{
		return this.isBarrier;
	}
	
	/**
	 * used to set the property of this item being a barrier
	 * @param isBarrier
	 */
	public void setBarrier(boolean isBarrier)
	{
		this.isBarrier = isBarrier;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	public void setID(int ID)
	{
		this.ID = ID;
	}
	public void setBI(BufferedImage BI)
	{
		this.BI = BI;
	}
	
	public void setOccurence(int occurence)
	{
		this.occurence = occurence;
	}
}

