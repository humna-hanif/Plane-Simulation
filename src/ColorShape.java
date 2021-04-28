import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.RectangularShape;

public abstract class ColorShape {

	// geom data
	private RectangularShape shape;
	// color , rotation angle, etc
	private Color fillColor, borderColor;
	private double rotation;

	public ColorShape(RectangularShape shape) {
		this.shape = shape;
		rotation = 0;
	}

	// check if the point is inside the object
	public boolean contains(Point p) {
		return shape.contains(p); // if the point is inside the shape, return true, else return false
	}

	// setters
	public void setLocation(double x, double y) {
		shape.setFrame(x, y, shape.getWidth(), shape.getHeight());
	}

	public void setRotation(double rotation) {
		this.rotation = rotation * Math.PI / 180;
	}

	public void setSize(double w, double h) {
		shape.setFrame(shape.getX(), shape.getY(), w, h);
	}

	public void setFillColor(Color color) {
		this.fillColor = color;
	}

	public void setBorderColor(Color color) {
		this.fillColor = color;
	}

	public void setColor(Color color) {
		this.fillColor = color;
		this.borderColor = color;
	}

	// getters from the shape
	public double getX() {
		return shape.getX();
	}

	public double getY() {
		return shape.getY();
	}

	public double getRotation() {
		return rotation * 180 / Math.PI;
	}

	public Color getFillColor() {
		return fillColor;
	}

	public Color getBorderColor() {
		return borderColor;
	}

	public void draw(Graphics2D brush) {
		brush.setColor(borderColor);
		brush.draw(shape);
	}

	public void fill(Graphics2D brush) {
		brush.setColor(fillColor);
		brush.fill(shape);
	}

	public void paint(Graphics2D brush) {
		brush.setColor(borderColor);
		brush.rotate(this.rotation, shape.getCenterX(), shape.getCenterY());
		brush.draw(shape);
		brush.setColor(fillColor);
		brush.fill(shape);
		brush.rotate(-this.rotation, shape.getCenterX(), shape.getCenterY()); // unrotate

	}

}
