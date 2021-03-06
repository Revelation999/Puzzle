import java.util.ArrayList;

public class Board
	{
		private static Hole[][] board;
		public Board(int length)
		{
			board = new Hole[length+6][length+6];
			for(int r = 0; r < board.length; r++)
				for (int c = 0; c < board[0].length; c++)
					board[r][c] = (r+c<board.length && r>=3 && c >=3)? new Hole('x', false, Math.random()): new Hole('-', true, 0);
		}
		public boolean tryFit(Piece piece, int r, int c)
			{
				boolean canFit = true;
				int[][] list = piece.getPosition();
				for (int[] i : list)
					canFit =canFit && !board[r+i[0]][c+i[1]].isFilled();
				if (canFit)
					{
					piece.putOn();
					for (int[] i : list)
					{
						board[r+i[0]][c+i[1]].setColor(piece.getColor());
						board[r+i[0]][c+i[1]].setFilled(true);
					}
					}
				return canFit;
			}
		public boolean searchSpot(Piece piece, int startRow, int startCol)
			{
				boolean fitIn = false;
				int r = startRow;
				while(!fitIn && r < board.length)
				{
					int c = startCol;
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
				return fitIn;
			}
		public void printBoard()
			{
				for (int r = 0; r < board.length; r++)
				{
					for (int c = 0; c < board[0].length; c++)
						System.out.print(board[r][c]);
					System.out.println();
				}
			}
		public void removePiece(Piece piece)
		{
			piece.takeAway();
			for(int r = 0; r < board.length; r++)
					for (int c = 0; c < board[0].length; c++)
							if (board[r][c].getColor()==piece.getColor())
								board[r][c] = new Hole('x', false, Math.random());
		}
		public boolean isFinished()
		{
			boolean rtn = true;
			for (Hole[] hole: board)
				for (Hole h: hole)
					rtn = rtn&&h.isFilled();
			return rtn;
		}
	}
