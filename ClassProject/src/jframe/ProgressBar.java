package jframe;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Timer;
import java.util.TimerTask;

public class ProgressBar{

	Timer t = new Timer();
	
	private int minValue;
	private int maxValue;
	private double currentValue;
	private int width, height;
	private int x,y;
	private double updateBy;
	private boolean isDone;
	//private boolean timerStarted = false;
	
	public ProgressBar(int x, int y, int width, int height, int maxValue)
	{
		minValue = 0;
		currentValue = 1;
		this.maxValue = maxValue;
		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y;
		//this.setBounds(x, y, width, height);
		//t.scheduleAtFixedRate(update, 20, 20);
		updateBy = (double) width / maxValue;
		//this.setBackground(Color.GREEN);
		
	}
	
	
	public void setX(int x)
	{
		this.x = x;
	}
	public int getX()
	{
		return x;
	}

	public void setY(int y)
	{
		this.y = y;
	}
	public int getY()
	{
		return y;
	}
	
	public void setProgressBar(int progress)
	{
		this.currentValue = progress;
	}
	public void setDone(boolean done)
	{
		this.isDone = done;
	}
	
	public boolean getDone()
	{
		return this.isDone;
	}
	public void stopTimer()
	{
		
	}
	public void getProgressBar(Graphics g)
	{
		
		g.setColor(Color.BLACK);
		g.fillRect(x - 1, y - 1, width + 2, height + 2);
		
		g.setColor(Color.GREEN);
		g.fillRect(x, y,(int)currentValue, height);
		currentValue = currentValue  + updateBy;
		System.out.println(currentValue);
		if(currentValue >= width)
		{
			this.isDone = true;
		}
	}
	
	/*TimerTask update = new TimerTask()
			{

				@Override
				public void run() {
					//repaint();
					
					if(currentValue >= width)
					{
						currentValue = 0;
						isDone = true;
					}
				}
		
			};
*/
}
