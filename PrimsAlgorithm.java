package question2;

//import java.lang.reflect.Array;
import java.util.*;

//import javax.imageio.ImageIO;

//import java.awt.image.BufferedImage;
import java.io.*; 

public class PrimsAlgorithm{
	private boolean[][] arr;
	private int row;
	private int col;
	
	public static char path = ' ';
	public static char wall = '|';
	public static boolean is_wall    = false;
	public static boolean is_passage = true;
	
	// Getters and Setters
	public boolean[][] getArr() { return arr; }
	public void setArr(boolean[][] arr) { this.arr = arr; }
	public int getRow() { return row; }
	public void setRow(int row) { this.row = row; }
	public int getCol() { return col; }
	public void setCol(int col) { this.col = col; }

	public PrimsAlgorithm() {}
	
	public PrimsAlgorithm(int row, int col) {
		setRow(row);
		setCol(col);
		
		arr = new boolean[row][col];
		setArr(arr);
		
		LinkedList<int[]> maze = new LinkedList<>();
	    Random random = new Random();

	    int[] maze_start = {0,0,0,0};
	    maze.add(maze_start);
	    
	    int[] lst;
	    int x, y;
	    arr[row-1][col-1] = is_passage;
	    arr[row-2][col-1] = is_passage;
	    arr[row-1][col-2] = is_passage;

        // Parsing through maze
	    while(!maze.isEmpty()){
	    	lst = maze.remove(random.nextInt(maze.size()));
	        x = lst[2];
	        y = lst[3];
	        
	        if (arr[x][y] == is_wall){
	        	arr[x][y] = is_passage;
	            arr[lst[0]][lst[1]] = arr[x][y];
	            
	            int[] a = {x-1,y,x-2,y};
	            int[] b = {x,y-1,x,y-2};
	            int[] c = {x+1,y,x+2,y};
	            int[] d = {x,y+1,x,y+2};
	            
	            if (x>=2 && arr[x-2][y] == is_wall) maze.add(a);
	            if (y>=2 && arr[x][y-2] == is_wall) maze.add(b);
	            if (x<row-2 && arr[x+2][y] == is_wall) maze.add(c);
	            if (y<col-2 && arr[x][y+2] == is_wall)maze.add(d);
	            }
	     }
	}
	
	public String output() {
		StringBuffer b = new StringBuffer();
		
	    for (int y=0; y<getCol(); y++){
	        for (int x=0; x<getRow(); x++) {
	        	if(getArr()[x][y] == is_wall) b.append(wall);
	        	else b.append(path);
	        }
	        b.append( '\n' );
	    }
	    
	    return b.toString();
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//PrimsAlgorithm prims = new PrimsAlgorithm(10, 10);
		PrimsAlgorithm prims = new PrimsAlgorithm(50, 50);
		
		System.out.println(prims.getRow());
		System.out.println(prims.getCol());
		System.out.println(prims.output());
		
	    /*
		File outputFile = new File("/Users/xtinejoy/Desktop/Doublearray.jpg");
		outputFile.getParentFile().mkdirs();
		ImageIO.write(b,"Doublearray", outputFile);
		System.out.println("end");
		*/
	}

}
