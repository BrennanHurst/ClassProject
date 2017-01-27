package materials;

public class BlockHandler {

	private BlockList BL;
	public BlockHandler(int worldSize)
	{
		BL = new BlockList(worldSize);
	}
	/**
	 * returns a Block associated with the ID
	 * @param ID
	 * @return
	 */
	public Block getBlockFromID(int ID)
	{
		Block m = new Block();
		for(int i = 0; i < BL.getBlocks().size(); i++)
		{
			if(BL.getBlocks().get(i).getID() == ID)
			{
				m = BL.getBlocks().get(i);
			}
		}
		return m;
	}
	
	public BlockList getBlockList()
	{
		return this.BL;
	}
	

}
