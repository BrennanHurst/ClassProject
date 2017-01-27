package math;


public class ChunkHandler {

	private Chunk[][] chunks;
	//private int worldX, worldY;
	private int chunkSize = 0;
	private int chunkX, chunkY;
	
	public ChunkHandler(int chunkSize)
	{
		chunkX = 1;
		chunkY = 1;
		this.chunkSize = chunkSize;
		chunks = new Chunk[chunkY][chunkX];
		Chunk basechunk = new Chunk(chunkSize);
		basechunk.setPlayerIsIn(true);
		chunks[0][0] = basechunk;
		
	}
	
	public void addNegX()
	{
		int[][] newChunks = new int[chunkY += 1][chunkX += 1];
	}
	
	public Chunk[][] getChunks()
	{
		return this.chunks;
	}
}
