package utility;

import java.awt.image.*;
import java.io.*;

import javax.imageio.ImageIO;

public class LoadImages {
	
	public BufferedImage readImg(String fileLocation) throws Exception
	{
		BufferedImage img;
		img = ImageIO.read(new File(getClass().getResource(fileLocation).toURI()));
		
		return img;
	}
	
	public BufferedImage getSubImg(int column, int row)
	{
		BufferedImage img;
		try{
		img = readImg("/textures.jpg").getSubimage((column * 32) - (32 - column), (row * 32) - (32 - row), 32, 32);
		}
		catch(Exception e)
		{
			return null;
		}
		return img;
		
	}
	
}
