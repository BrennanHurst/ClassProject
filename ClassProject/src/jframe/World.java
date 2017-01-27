package jframe;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import materials.Block;
import materials.HarvestableBlock;
import math.ChunkHandler;
import math.GenerateWorld;
import references.Reference;

public class World extends Canvas implements KeyListener, Runnable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BufferedImage background;
	
	//private GenerateWorld gw;
	private int maxBound;
	private int worldSize = 32;
	private Graphics offgc;
	private int x,y;
	private int playerX = 240, playerY = 240;
	private int movementSpeed = 1;
	private char currentChar;
	private Font paintFont;
	private boolean isRunning = false;
	private ProgressBar mineBar;
	private ChunkHandler ch;
	//private i
	
	public World()
	{
        this.addKeyListener(this);
		x = 0; y = 0;
		
		maxBound = 64 * worldSize - 1;
	//	gw = new GenerateWorld(worldSize);
		background = new BufferedImage(maxBound, maxBound, BufferedImage.TYPE_INT_RGB);
		paintFont = new Font("Arial", Font.PLAIN, 15);
        setFont(paintFont);
        getFontMetrics(paintFont);
        ch = new ChunkHandler(worldSize);
       this.createBackgroundRender();
    
       this.setBackground(Color.BLACK);
       mineBar = new ProgressBar(240, 270, 50, 5, 100);
      
	}
	
	public void Start()
	{
		this.isRunning = true;
		new Thread(this).start();
	}
	@Override
	public void run() {
		isRunning = true;
		while(isRunning)
		{
			this.checkDirection();

			this.render();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
	public void setCurrentChar(char currentChar)
	{
		this.currentChar = currentChar;
	}
	
	public char getCurrentChar()
	{
		return this.currentChar;
	}
	

	/*public void createBackgroundRender()
	{
		offgc = background.getGraphics();
		
		
		for(int y = 0; y < worldSize; y++)
		{
			for(int x = 0; x < worldSize; x++)
			{
				
				for(int i = 0; i < gw.getWTG().getBlocks().size(); i++)
				{
					if(gw.getWorldGrid()[y][x] == gw.getWTG().getBlocks().get(i).getID())
					{
						offgc.drawImage(gw.getWTG().getBlocks().get(i).getBI(), x * 64, y * 64, 64, 64, null);
					}
				}
			}
			
		}
	
	
	}*/
	
	
	public void createBackgroundRender()
	{
		offgc = background.getGraphics();
		
				
				for(int i = 0; i < ch.getChunks().length; i++)
				{
					for(int t = 0; t < ch.getChunks().length; t++)
					{
						for(int q = 0; q < ch.getChunks()[i][t].getWTG().getBlocks().size(); q++)
						{
							for(int y = 0; y < worldSize; y++)
							{
								for(int x = 0; x < worldSize; x++)
								{
									if(ch.getChunks()[i][t].getPlayerIsIn())
									{
										if(ch.getChunks()[i][t].getChunk()[y][x] == ch.getChunks()[i][t].getWTG().getBlocks().get(q).getID())
										{
											offgc.drawImage(ch.getChunks()[i][t].getWTG().getBlocks().get(q).getBI(), x * 64, y * 64, 64, 64, null);
										}
									}
								}
							}
						}
				/*for(int i = 0; i < gw.getWTG().getBlocks().size(); i++)
				{
					if(gw.getWorldGrid()[y][x] == gw.getWTG().getBlocks().get(i).getID())
					{
						offgc.drawImage(gw.getWTG().getBlocks().get(i).getBI(), x * 64, y * 64, 64, 64, null);
					}
				}*/
			}
			
		}
	
	
	}
	
	public void renderImageChange(int x, int y)
	{
		offgc = background.getGraphics();
		offgc.drawImage(this.ch.getChunks()[0][0].getWTG().getBlocks().get(0).getBI(), x * 64, y * 64, null);
	}
	
	public void render()
	{
		BufferStrategy bs = getBufferStrategy();
        Graphics g;
        if(bs == null){
            createBufferStrategy(3);
            requestFocus();
            return;
        }
        g = bs.getDrawGraphics();
        
        g.drawImage(background, 0 - x, 0 - y, null);
		g.setColor(Color.WHITE);
		g.fillRect(playerX, playerY, 10, 10);
		mineBlock(g);	
		g.dispose();
        bs.show();
    
    }

	
	public void mineBlock(Graphics g)
	{
		System.out.println((y + playerY) / 64);
		Block b = this.ch.getChunks()[0][0].getWTG().getBlockHandler().getBlockFromID(this.ch.getChunks()[0][0].getChunk()[( y + playerY) / 64 ][(x + (playerX)) / 64]);
		if(b.getClass() == HarvestableBlock.class)
		{
			b = (HarvestableBlock) b;
			
			g.drawString("[F]", 237, 270);
			if(this.currentChar == 'F')
			{
				mineBar.getProgressBar(g);
				if(mineBar.getDone())
				{
					this.ch.getChunks()[0][0].getChunk()[( y + playerY) / 64][(x + (playerX - 1)) / 64] = 0;
					this.renderImageChange((this.x + playerX) / 64, ((this.y + playerY) / 64));
					System.out.println("pixels x" + this.x);
					System.out.println("pixels Y" + this.y);

					System.out.println(playerY / 64);
					System.out.println(playerX / 64);
					mineBar.setDone(false);
				}
				
			}
			else mineBar.setProgressBar(0);
			}
	}
	
	/**
	 * Handles key inputs 
	 */
	public void checkDirection()
	{

		if(currentChar == 'A' && playerX > 0 && !this.ch.getChunks()[0][0].getWTG().getBlockHandler().getBlockFromID(this.ch.getChunks()[0][0].getChunk()[( y + playerY) / 64][(x + playerX - 1) / 64]).getBarrier() && !this.ch.getChunks()[0][0].getWTG().getBlockHandler().getBlockFromID(this.ch.getChunks()[0][0].getChunk()[( y + playerY + 10) / 64][(x + playerX - 1) / 64]).getBarrier()){
			
			System.out.println("ger");
			if(x > 0 && playerX == 240)
			{
				this.x -= movementSpeed; 
			}
			else if(playerX - 1 > 1 && playerX < Reference.JFRAMEWIDTH)
			{
				this.playerX -= movementSpeed;
			}
			
			

		}
		if(currentChar == 'D' && playerX + 10 < Reference.JFRAMEWIDTH && !this.ch.getChunks()[0][0].getWTG().getBlockHandler().getBlockFromID(this.ch.getChunks()[0][0].getChunk()[( y + playerY + 10) / 64][(x + playerX + 11) / 64]).getBarrier() && !this.ch.getChunks()[0][0].getWTG().getBlockHandler().getBlockFromID(this.ch.getChunks()[0][0].getChunk()[( y + playerY) / 64][(x + playerX + 11) / 64]).getBarrier()){
			if( x <= maxBound - 510 && playerX == 240)
			{
				this.x += movementSpeed; 
			}
			else if(playerX > 1 && playerX  + 10 < Reference.JFRAMEWIDTH)
			{
				System.out.println("PLAYERX" + playerX);
				this.playerX += movementSpeed;
			}
			

		}
		if(currentChar == 'W' &&  playerY > 0 && !this.ch.getChunks()[0][0].getWTG().getBlockHandler().getBlockFromID(this.ch.getChunks()[0][0].getChunk()[( y + playerY - 1) / 64][(x + playerX) / 64]).getBarrier() && !this.ch.getChunks()[0][0].getWTG().getBlockHandler().getBlockFromID(this.ch.getChunks()[0][0].getChunk()[( y + playerY + 10) / 64][(x + playerX + 10) / 64]).getBarrier()){
			if(y > 0 && playerY == 240)
			{
				this.y -= movementSpeed; 
			}
			else if(playerY - 1 > 1 && playerY < maxBound - movementSpeed)
			{
				this.playerY -= movementSpeed;
			}
		}
		
		if(currentChar == 'S'&& playerY < Reference.JFRAMEHEIGHT && !this.ch.getChunks()[0][0].getWTG().getBlockHandler().getBlockFromID(this.ch.getChunks()[0][0].getChunk()[( y + playerY + 11) / 64][(x + playerX + 10) / 64]).getBarrier() && !this.ch.getChunks()[0][0].getWTG().getBlockHandler().getBlockFromID(this.ch.getChunks()[0][0].getChunk()[( y + playerY + 11) / 64][(x + playerX) / 64]).getBarrier()){
			if(y < maxBound - 510 && playerY == 240)
			{
				this.y += movementSpeed; 
			}
			else if(playerY  > 1 && playerY + 10 < Reference.JFRAMEHEIGHT)
			{
				System.out.println("10 " + playerY + 10);
				this.playerY += movementSpeed;
			}
		}
	
	}
	/**
	 * returns the x coordinate
	 * @return
	 */
	public int getX()
	{
		return this.x;
	}
	
	/**
	 * returns the y coordinate
	 * @return
	 */
	public int getY()
	{
		return this.y;
	}
	
	/**
	 * sets the x coordinate
	 * @param x
	 */
	public void setX(int x)
	{
		this.x = x;
	}
	
	/**
	 * Sets the y coordinate
	 */
	public void setY(int y)
	{
		this.y = y;
	}
	
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	
		this.currentChar = Character.toString(e.getKeyChar()).toUpperCase().charAt(0);
	
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if(Character.toString(e.getKeyChar()).toUpperCase().charAt(0) == currentChar){
			this.currentChar = Character.MIN_VALUE;
			}
	}

	

	

}
