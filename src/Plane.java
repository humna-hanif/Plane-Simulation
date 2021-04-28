import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

public class Plane {
	private ColorEllipse body;
	private ColorEllipse topWing, bottomWing;
	private int _x, _y;
	private int _behavior; // 1: Nothing, 2: Follow, 3: Random
	private MovingPlane plane;
	private int _dpWidth, _dpHeight;

	public Plane(int dpWidth, int dpHeight, int xLoc, int yLoc, Color color, MovingPlane plane) {
		this.plane = plane;
		this._dpHeight = dpHeight;
		this._dpWidth = dpWidth;
		// set color
		topWing = new ColorEllipse(color);
		bottomWing = new ColorEllipse(color);
		body = new ColorEllipse(color);

		// set sizes
		topWing.setSize(40, 70);
		bottomWing.setSize(40, 70);
		body.setSize(220, 70);
		// set location
		body.setLocation(100, 70);
		topWing.setLocation(190, 40);
		bottomWing.setLocation(190, 100);
		// rotate wings
		topWing.setRotation(-34);
		bottomWing.setRotation(34);

		this._x = xLoc;
		this._y = yLoc;

		setLocation(_x, _y);
	}

	public void setLocation(int x, int y) {
		// TODO Auto-generated method stub
		double newX = (x) % _dpWidth;
		double newY = (y) % _dpHeight;
		body.setLocation(newX, newY);
		topWing.setLocation(newX + 75, newY - 30);
		bottomWing.setLocation(newX + 75, newY + 35);
		if (newX >= _dpWidth) {
			x = x - _dpWidth;
			y = y;
		} else if (newY >= _dpHeight) {
			x = x;
			y = y - _dpHeight;
		} else {
			newX = x;
			newY = y;
		}

		this._x = x;
		this._y = y;
	}

	public boolean contains(Point p) {
		return (body.contains(p) || topWing.contains(p) || bottomWing.contains(p));
	}

	public void move() {
		if (_behavior == 1) {

		} else if (_behavior == 2 && plane != null) {
			this.setLocation(_x + plane.getDisplacementX(), _y + plane.getDisplacementY());
		} else if (_behavior == 3) {
			this.setLocation(_x + (int) (10 * Math.random()), _y + (int) (10 * Math.random()));
		}
	}

	public void setBehavior(int behavior) {
		this._behavior = behavior;

	}

	public static void mouseClicked() {

	}

	public void paint(Graphics2D brush) {
		body.paint(brush);
		topWing.paint(brush);
		bottomWing.paint(brush);
	}
}
