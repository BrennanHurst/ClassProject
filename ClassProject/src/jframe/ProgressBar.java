package jframe;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Timer;
import java.util.TimerTask;

public class ProgressBar extends Canvas{

	Timer t = new Timer();
	
	private int minValue;
	private int maxValue;
	private double currentValue;
	private int width, height;
	private int x,y;
	private double updateBy;
	
	public ProgressBar(int x, int y, int width, int height, int maxValue)
	{
		minValue = 0;
		currentValue = 1;
		this.maxValue = maxValue;
		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y;
		this.setBounds(x, y, width, height);
		t.scheduleAtFixedRate(update, 100, 100);
		updateBy = (double) 100 / maxValue;
		//this.setBackground(Color.GREEN);
		
	}
	
	public void paint(Graphics g)
	{
		g.setColor(Color.GREEN);
		g.fillRect(0, 0,(int)currentValue, height);
		//System.out.println(currentValue);

		//System.out.println("painted " + width / currentValue);
	}
	
	TimerTask update = new TimerTask()
			{

				@Override
				public void run() {
					currentValue = currentValue  + updateBy;
					repaint();
					
					if(currentValue >= maxValue)
					{
						currentValue = 1;
					}
				}
		
			};

}
