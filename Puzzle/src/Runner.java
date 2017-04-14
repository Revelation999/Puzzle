
public class Runner {
	static Hole[][] board;
	public static void main(String[]args)
	{
		generateSmallBoard();
		int[][] pos = {{0,0},{0,1},{0,2},{0,3},{1,0}};
		Piece longHoe = new Piece('P', pos);
		int[][] pos2 = {{0,0},{0,1},{1,1},{1,2},{2,2}};
		Piece zigzag = new Piece('O',pos2);
		searchSpot(longHoe);
		searchSpot(zigzag);
		printBoard();
		System.out.println(longHoe);
		System.out.println(zigzag);
	}
	public static void generateSmallBoard()
	{
		board = new Hole[10][10];
		for(int r = 0; r < 10; r++)
			for (int c = 0; c < 10; c++)
				board[r][c] = (r+c<10 && r>=3 && c >=3)? new Hole('x', false, Math.random()): new Hole('-', true, 0);
	}
	public static void printBoard()
	{
		for (int r = 0; r < board.length; r++)
		{
			for (int c = 0; c < board[0].length; c++)
				System.out.print(board[r][c]);
			System.out.println();
		}
	}
	public static boolean tryFit(Piece piece, int r, int c)
	{
		boolean canFit = true;
		int[][] list = piece.getPosition();
		for (int[] i : list)
			canFit = canFit && !board[r+i[0]][c+i[1]].isFilled();
		if (canFit)
			for (int[] i : list)
			{
				board[r+i[0]][c+i[1]].setColor(piece.getColor());
				board[r+i[0]][c+i[1]].setFilled(true);
			}
		return canFit;
	}
	public static void searchSpot(Piece piece)
	{
		boolean fitIn = false;
		int r = 0;
		while(!fitIn && r < board.length)
		{
			int c = 0;
			while(!fitIn && c < board[0].length)
			{
				int count = 0;
				while (!fitIn && count < 8)
				{
					if (!board[r][c].isFilled())
					{
					fitIn = tryFit(piece, r, c);
					if (fitIn) break;
					if (count==3) piece.flip();
					piece.rotate();
					}
					count++;
				}
				c++;
			}
			r++;
		}
	}
}
