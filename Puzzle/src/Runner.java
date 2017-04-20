import java.util.ArrayList;
public class Runner {
	static ArrayList<Piece> list = new ArrayList <Piece>();
	public static void main(String[]args)
	{
		Board board = new Board(4);
		int[][] pos = {{0,0},{0,1},{0,2},{0,3},{1,0}};
		Piece longHoe = new Piece('P', pos);
		int[][] pos2 = {{0,0},{0,1},{1,1},{1,2},{2,2}};
		Piece zigzag = new Piece('O',pos2);
		list.add(longHoe);
		list.add(zigzag);
		board.searchSpot(longHoe, 0, 0);
		board.searchSpot(zigzag, 0, 0);
		board.printBoard();
		System.out.println(longHoe);
		System.out.println(zigzag);
	}
	
}
