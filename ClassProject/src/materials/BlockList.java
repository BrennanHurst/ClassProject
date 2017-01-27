package materials;

import java.util.ArrayList;

import utility.LoadImages;

public class BlockList {
	private ArrayList<Block> blocks = new ArrayList<Block>();
	//private ArrayList<HarvestableBlock> harvestableBlocks = new ArrayList<HarvestableBlock>();
	private LoadImages li = new LoadImages();

	public	BlockList(int worldSize)
	{
		blocks.add(new Block(0,1,"GRASS",li.getSubImg(1, 1),false));
		blocks.add(new Block(0, 2, "WALL", li.getSubImg(1, 2), true));
		blocks.add(new Block((int) (worldSize * worldSize / 8.3), 3, "TREE", li.getSubImg(1, 3), true));
		//blocks.add(new HarvestableBlock((int) (worldSize * worldSize / 8.3), 3, 3, "TREE", li.getSubImg(1, 3)));
		blocks.add(new HarvestableBlock(worldSize * worldSize / 40, 4, 3, "ROCK", li.getSubImg(1, 4)));
		blocks.add(new HarvestableBlock((int) (Math.random() * 80), 5, 3, "TESTORE", li.getSubImg(1, 5)));

	}
	public ArrayList<Block> getBlocks()
	{
		return this.blocks;
	}
	
	/*public ArrayList<HarvestableBlock> getHarvestableBlocks()
	{
		return this.harvestableBlocks;
	}*/
}
