
public class Piece {
	private char color;
	private int[][] position;
	public Piece(char c, int [][] pos)
	{
		color = c;
		position = pos;
	}
	public char getColor() {
		return color;
	}
	public int[][] getPosition() {
		return position;
	}
	public void rotate()
	{
		for (int[] i: position)
		{
			int temp = -i[0];
			i[0] = i[1];
			i[1] = temp;
		}
	}
	public void flip()
	{
		for (int[] i : position)
			i[0] = -i[0];
	}
	public String toString()
	{
		char[][] list = new char[7][7];
		for (int r = 0; r < 7; r++)
		{
			for (int c = 0; c < 7; c++)
			{
				boolean onIt = false;
				for (int[] i: position)
				{
					onIt = onIt || (r-3==i[0]&&c-3==i[1]);
				}
				if (onIt) list[r][c] = color;
				else list[r][c] = ' ';
			}
		}
		String rtn = "";
		for (char[] r: list)
		{
			for (char c: r)
				rtn+=c;
			rtn+="\n";
		}
		return rtn;
	}
}
