package references;

import java.util.Timer;
import java.util.TimerTask;

import start.Start;

public class GameTimes {

	Timer t = new Timer();
	public GameTimes()
	{
		//t.scheduleAtFixedRate(updateFPS, 1000, 1000);
		t.scheduleAtFixedRate(updateFrames, 10, 10);
	//	t.scheduleAtFixedRate(updateFrames, 1, 1);
	}
	
	TimerTask updateFPS = new TimerTask(){

		@Override
		public void run() {
			// TODO Auto-generated method stub
			
		}
		
	};
	
	TimerTask updateFrames = new TimerTask(){

		@Override
		public void run() {
			// TODO Auto-generated method stub
			Start.jf.getContentPane().getManager().getWorld().checkDirection();
		}
		
	};
	/*TimerTask updateFrames = new TimerTask(){

		@Override
		public void run() {
			// TODO Auto-generated method stub
			Start.jf.getContentPane().getManager().repaint();
		}
		
	};*/
	
}
