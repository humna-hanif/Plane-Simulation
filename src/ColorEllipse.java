import java.awt.Color;

public class ColorEllipse extends ColorShape {

	public ColorEllipse() {
		this(Color.red);
		this.setSize(100, 100);
		this.setLocation(100, 100);
	}

	public ColorEllipse(Color color) {
		super(new java.awt.geom.Ellipse2D.Double());
		this.setColor(color);
	}
}
