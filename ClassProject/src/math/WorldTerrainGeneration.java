package math;

import java.util.ArrayList;

import materials.Block;
import materials.BlockHandler;
import materials.BlockList;
import utility.LoadImages;

public class WorldTerrainGeneration {

	
	private BlockHandler bh;
	private int worldSize;
	public WorldTerrainGeneration(int worldSize)
	{
		this.worldSize = worldSize;
		bh = new BlockHandler(worldSize);
		
	}
	
	
	/**
	 * returns the Blocks list
	 * @return
	 */
	public ArrayList<Block> getBlocks()
	{
		return this.bh.getBlockList().getBlocks();
	}
	
	public BlockHandler getBlockHandler()
	{
		return this.bh;
	}
	
	
	/**
	 * sets up the terrain for the map
	 * @return
	 */
	public int[][] createTerrain()
	{
		int[][] world = new int[worldSize][worldSize];
		
		for(int i = 1; i < bh.getBlockList().getBlocks().size(); i++)
		{
			for(int t = 0; t < bh.getBlockList().getBlocks().get(i).getOccurence(); t++)
			{
				int[] coords = getRandomMath(worldSize);
				world[coords[0]][coords[1]] = bh.getBlockList().getBlocks().get(i).getID();
			}
		}
		world = createGrass(world);
		return world;
		
	}
	
	/**
	 * finds a random number based on the world size
	 * @param worldSize
	 * @return
	 */
	public int[] getRandomMath(int worldSize)
	{
		int[] coords = new int[2];
		int x = (int) ((Math.random() * worldSize));
		int y = (int) ((Math.random() * worldSize));
		coords[0] = y;
		coords[1] = x;
		return coords;
		
	}
	
	/**
	 * fills in every 0 in the world array with grass (1)
	 * @param world
	 * @return
	 */
	public int[][] createGrass(int[][] world)
	{
		for(int y = 0; y < world.length; y++)
		{
			for(int x = 0; x < world.length; x++)
			{
				if(world[y][x] == 0)
				{
					world[y][x] = 1;
				}
			}
		}
		return world;
		
	}
}
