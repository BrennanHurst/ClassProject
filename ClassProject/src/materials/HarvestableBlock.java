package materials;

import java.awt.image.BufferedImage;

public class HarvestableBlock extends Block{

	private boolean isHarvestable;
	private int harvestID;
	
	// 1 = pickaxe
	// 2 = axe
	// 3 = hands
	private int toolUsed;
	
	public HarvestableBlock()
	{
		super();
		this.isHarvestable = false;
		this.harvestID = Integer.MIN_VALUE;
		
	}
	public HarvestableBlock(int occurence, int ID, int harvestID, String name, BufferedImage BI)
	{
		super(occurence, ID, name, BI, false);
		isHarvestable = true;
		this.harvestID = harvestID;
	}
	
	public int getHarvestID()
	{
		return this.harvestID;
	}
	
	public boolean getHarvestable()
	{
		return this.isHarvestable;
	}
	
}
