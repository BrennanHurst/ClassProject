///*package math;
//
//import java.util.ArrayList;
//
//import materials.MaterialList;
//
//public class Chunk {
//
//	private ArrayList<Integer> chunk;
//	public Chunk()
//	{
//		chunk = new ArrayList<Integer>();
//	}
//	
//	public ArrayList<Integer> generateChunk()
//	{
//		ArrayList<Integer> chunk = baseGeneration();
//		
//		for(int i = 1; i < MaterialList.materials.size(); i++)
//		{
//			for(int t = 0; t < MaterialList.materials.get(i).getOccurance(); t++)
//			{
//				int index = getRandomMath(81);
//				chunk.set(index, MaterialList.materials.get(i).getID());
//			}
//		}
//		
//		return chunk;
//		
//	
//	}
//	
//	public ArrayList<Integer> baseGeneration()
//	{
//		ArrayList<Integer> chunk = new ArrayList<Integer>();
//		for(int i = 0; i < 81; i++)
//		{
//			chunk.add(0);
//		}
//		return chunk;
//	}
//	
//	
//	
//	public ArrayList<Integer> getChunk()
//	{
//		return this.chunk;
//	}
//	
//	/**
//	 * finds a random number based on the world size
//	 * @param worldSize
//	 * @return
//	 */
//	public int getRandomMath(int chunkSize)
//	{
//
//		int r = (int) ((Math.random() * chunkSize));
//		
//		/*if(currentWorld[y][x] != 0)
//		{
//			coords = getRandomMath(worldX, worldY, currentWorld);
//		}*/
//		return r;
//		
//	}
//	
//	/**
//	 * fills in every 0 in the world array with grass (1)
//	 * @param world
//	 * @return
//	 */
//	public ArrayList<Integer> generateGrass(ArrayList<Integer> chunk)
//	{
//		ArrayList<Integer> newchunk = chunk;
//		for(int index = 0; index < 81; index++)
//		{
//			
//			if(newchunk.get(index) == 0)
//			{
//					newchunk.set(index, 1);
//			}
//			
//		}
//		return newchunk;
//		
//	}
//}*/
