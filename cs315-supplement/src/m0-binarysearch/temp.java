public interface Shape2D {
	public double getPerimeter();
	public double getArea();
}


public class Rectangle {
	private double length;
	private double width; 

	public Rectangle(int length, int width) {
		this.length = length;
		this.width = width;
	}
	public double getPerimeter() {
		return length*2 + width*2;
	}
	public double getArea() {
		return length * width;
	}
}


public interface Point {
	public String toString();
	public double distanceTo(Point p);
}

public class Point2D implements Point{
	private double x;
	private double y;

	public Point2D(x, y) {
		this.x = x;
		this.y = y;
	}

	public String toString() {
		return "Point(" + x + ", " + y + ")";
	}

	public double distanceTo(Point p) {
		return Math.sqrt((x-p.x)*(x-p.x) + (y-p.y)*(y-p.y));
	}
}


pbulic class
