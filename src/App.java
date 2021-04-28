import java.awt.BorderLayout;

import javax.swing.JFrame;

public class App extends JFrame {
	private MovementHolder holder;

	public App() {
		super("Plane Simulation");
		this.setLayout(new BorderLayout());
		holder = new MovementHolder();
		this.setSize(1000, 800);
		DrawingPanel panel = new DrawingPanel(holder);
		this.add(panel, BorderLayout.CENTER);
		this.add(new ControlPanel(holder, panel.getPlane1(), panel.getPlane2(), panel.getMovingPlane()),
				BorderLayout.SOUTH);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		// create an instance of DrawingPanel and add it to the frame

		pack();

		this.setVisible(true);
	}

	public static void main(String[] args) {
		new App();
	}

}