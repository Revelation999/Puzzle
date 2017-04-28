import java.util.ArrayList;
public class Runner {
	static ArrayList<Piece> list = new ArrayList <Piece>();
	public static void main(String[]args)
	{
		Board board = new Board(4);
		generatePiece();
		int r = 0, c = 0, count = 0;
		while(!board.isFinished()&&!AllOnBoard())
			{
				if (!list.get(count).isOnBoard()&&board.searchSpot(list.get(count), r, c))
					count++;
			}
		board.printBoard();
	}
	public static void generatePiece()
	{
		int[][] ps = {{0,0},{0,1},{0,2},{0,3},{1,1}};
		Piece twig = new Piece('E',ps);
		int[][] va = {{0,0},{1,0},{2,0},{0,1},{1,1}};
		Piece van = new Piece('S',va);
//		int[][] pos = {{0,0},{0,1},{0,2},{0,3},{1,0}};
//		Piece longHoe = new Piece('P', pos);
//		int[][] pos2 = {{0,0},{0,1},{1,1},{1,2},{2,2}};
//		Piece zigzag = new Piece('O',pos2);
//		list.add(longHoe);
//		list.add(zigzag);
		list.add(van);
		list.add(twig);
	}
	
	public static boolean AllOnBoard()
	{
		for (Piece p: list)
			if (!p.isOnBoard())
				return false;
		return true;
	}
}
