
public class Hole {
	char color;
	boolean filled;
	double random;
	public Hole(char c, boolean f, double d)
	{
		color = c;
		filled = f;
		random = d;
	}
	public String toString()
	{
		return ""+color;
	}
	public char getColor() {
		return color;
	}
	public void setColor(char color) {
		this.color = color;
	}
	public boolean isFilled() {
		return filled;
	}
	public void setFilled(boolean filled) {
		this.filled = filled;
	}
}
