package math;

public class Chunk {

	private WorldTerrainGeneration wtg;
	private int[][] chunkTerrain;
	private int xStart, yStart;
	private boolean playerIsIn = false;
	public Chunk(int worldSize)
	{
		wtg = new WorldTerrainGeneration(worldSize);
		chunkTerrain = wtg.createTerrain();
		
	}
	
	public int[][] getChunk()
	{
		return this.chunkTerrain;
	}
	
	public boolean getPlayerIsIn()
	{
		return this.playerIsIn;
	}
	
	public int getxStart()
	{
	return this.xStart;
	}
	
	public int getyStart()
	{
		return this.yStart;
	}

	public void setPlayerIsIn(boolean playerIsIn)
	{
		this.playerIsIn = playerIsIn;
	}
	
	public void setChunkTile()
	{
		
	}
	public WorldTerrainGeneration getWTG()
	{
		return this.wtg;
	}
	
	 
	
}
