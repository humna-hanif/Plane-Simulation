import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class AnimationTimer extends Timer { // put implementation with the timer// subclass of java time
	private DrawingPanel dp;

	public AnimationTimer(DrawingPanel dp) {
		super(100, null); // call to the superclass constructor; null for the listener because the
							// listener can't be created as an instance before calling the constructor
		this.addActionListener(new MoveListener());// makes the timer know about its action listener; register the
													// action
		this.dp = dp;

	}

	private class MoveListener implements ActionListener {

		// gets called each time the timer is clicked
		public void actionPerformed(ActionEvent e) {
			dp.move();
		}
	}
}
