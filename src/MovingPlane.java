import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

public class MovingPlane {
	private int _dpWidth, _dpHeight;
	private ColorEllipse body;
	private ColorEllipse topWing, bottomWing;
	private double _planeX, _planeY;
	private int _behavior;
	private int dx, dy;
	private int x, y;

	public MovingPlane(int dpWidth, int dpHeight, int x, int y, Color color) {
		this._dpWidth = dpWidth;
		this._dpHeight = dpHeight;
		
		topWing = new ColorEllipse(Color.green);
		bottomWing = new ColorEllipse(Color.green);
		body = new ColorEllipse(Color.green);
		
		body.setLocation(300, 150);
		topWing.setLocation(390, 120);
		bottomWing.setLocation(390, 180);
		
		topWing.setSize(40, 70);
		bottomWing.setSize(40, 70);
		body.setSize(220, 70);
		
		topWing.setRotation(-34);
		bottomWing.setRotation(34);
		
		this.setLocation(x, y);
	}
	
	public void move(int dx, int dy) {
		this.setLocation(_planeX + dx,_planeY + dy);
		this.dx = dx;
		this.dy = dy;
	}

	public void setLocation(double x, double y) {
		// TODO Auto-generated method stub
		double newX = (x) % _dpWidth;
		double newY = (y) % _dpHeight;
		body.setLocation(newX,newY);
		topWing.setLocation(newX + 75, newY - 25);
		bottomWing.setLocation(newX + 75, newY + 35);
		_planeX = newX;
		_planeY = newY;
	}
	
	public boolean contains(Point p) {
		return (body.contains(p) || topWing.contains(p) || bottomWing.contains(p));
	}
	
	public void paint(Graphics2D brush) {
		body.paint(brush);
		topWing.paint(brush);
		bottomWing.paint(brush);
	}

	
	public void setBehavior(int behavior) {
		this._behavior = behavior;
		
	}

	public int getDisplacementX() {
		// TODO Auto-generated method stub
		return dx;
	}
	
	public int getDisplacementY() {
		// TODO Auto-generated method stub
		return dy;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}

}
