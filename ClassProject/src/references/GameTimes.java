package references;

import java.util.Timer;
import java.util.TimerTask;

import start.Start;

public class GameTimes {

	Timer t = new Timer();
	public GameTimes()
	{
		t.scheduleAtFixedRate(updateFPS, 1000, 1000);
		t.scheduleAtFixedRate(updateMoves, 25, 25);
	}
	
	TimerTask updateFPS = new TimerTask(){

		@Override
		public void run() {
			// TODO Auto-generated method stub
			
		}
		
	};
	
	TimerTask updateMoves = new TimerTask(){

		@Override
		public void run() {
			// TODO Auto-generated method stub
			Start.jf.getContentPane().getBaseCanvas().checkDirection();
		}
		
	};
	
}
