package math;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;


public class GenerateWorld {

	private WorldTerrainGeneration wtg;
	private int[][] world;
	private int worldSize;
	
	private Image offscreen;
	
	public GenerateWorld(int size)
	{
		this.world = new int[size][size];
		this.worldSize = size;
		wtg = new WorldTerrainGeneration(worldSize);
		world = wtg.createTerrain();
	}
	
	
	
	/**
	 * returns the image of the world
	 * @return
	 */
	public Image getWorldImage()
	{
		return offscreen;
	}
	
	/**
	 * returns the grid representation of the world
	 * @return
	 */
	public int[][] getWorldGrid()
	{
		return this.world;
	}
	
	/**
	 * 
	 * @return
	 */
	public WorldTerrainGeneration getWTG()
	{
		return this.wtg;
	}
	
	
	
}
