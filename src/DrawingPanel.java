import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
// All of your drawing components must go in here
// This is your canvas

public class DrawingPanel extends JPanel implements MouseListener { // making class that needs the listener implement
																	// the listener
	private Plane plane1, plane2;
	private MovingPlane plane;
	private AnimationTimer timer; // contains the actionListener and its actionPerfermoed method
	private MovementHolder holder;

	public DrawingPanel(MovementHolder holder) {
		super(); // initialize panel constructor
		this.holder = holder;
		this.setSize(1000, 800);
		this.setPreferredSize(new Dimension(1000, 800));
		this.setBackground(Color.white);
		plane = new MovingPlane(this.getWidth(), this.getHeight(), 330, 240, Color.green);
		plane1 = new Plane(this.getWidth(), this.getHeight(), 100, 70, Color.blue, plane);
		plane2 = new Plane(this.getWidth(), this.getHeight(), 100, 410, Color.blue, plane);
		// creates the timer, pass the drawing panel, pass the interval
		timer = new AnimationTimer(this);
		timer.start();
		this.addMouseListener(this); // this class implements this
	}

	// refreshing and redrawing the screen; only in the panel
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D brush = (Graphics2D) g;
		plane1.paint(brush);
		plane2.paint(brush);
		plane.paint(brush);
	}

	public void move() {
		plane.move(5, 0);
		plane1.move();
		plane2.move();
		// System.out.println("hello");
		repaint(); // call paintComponenet
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		Point point = e.getPoint();
		if (plane1.contains(point)) {
			plane1.setBehavior(holder.getBtnClicked());
		} else if (plane2.contains(point)) {
			plane2.setBehavior(holder.getBtnClicked());
		} else if (plane.contains(point)) {
			plane.setBehavior(holder.getBtnClicked());
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public Plane getPlane1() {
		return plane1;

	}

	public Plane getPlane2() {
		return plane2;

	}

	public MovingPlane getMovingPlane() {
		return plane;

	}
}
