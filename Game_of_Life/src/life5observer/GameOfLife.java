package life5observer;

import java.util.ArrayList;
import java.util.List;

import edu.du.dudraw.Draw;
public class GameOfLife {
//	second concrete observeer that does everything that UI doesnt do
	private List<LifeObserver> observers = new ArrayList<LifeObserver>();
	private int state;
	private ArrayList<LifeCommand> commandList;


	// rows and cols for the game
	private int rows;
	private int cols;
	private Cell[][] grid; 

	public GameOfLife(int rows, int cols) {
		commandList= new ArrayList<LifeCommand>();
		this.rows = rows;
		this.cols = cols;
		// Setup the grid
		//		Cell.setupGrid();
		this.grid = new Cell[rows][cols];
	}
	public void setupGrid(Cell[][] grid) 
	{
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				Cell cell = new Cell();
				grid[i][j] = cell;
			}
		}
		for (int i = 0; i < grid.length; i++) 
		{
			for (int j = 0; j < grid[i].length; j++) 
			{
				int n = 0;
				for (int k=0;k<3;k++)
				{
					for (int l=0;l<3;l++)
					{
						int x=i-1+l;
						int y=j-1+k;
						if ((x>=0 && y>=0)&&(x<grid[i].length && y<grid.length)&&(x!=i||y!=j))
						{
							n++;
							grid[i][j].addNeighbor(grid[x][y]);
						}
					}
				}
			}
		}
	}
	public void advance(Cell[][] grid) {		
		int rows = grid.length,cols = grid[0].length;
		int n = 0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				n = grid[i][j].nbrAliveNeighbors();
				if (grid[i][j].isAlive()) {
					if (n == 2 || n == 3) {
						LifeCommand command = new AliveCommand(grid[i][j]);
						commandList.add(command);
					} 
					else {
						//	                    	newGrid[i][j].dead();
						LifeCommand command = new DeadCommand(grid[i][j]);
						commandList.add(command);
					}
				} else {
					if (n == 3) {
						LifeCommand command = new AliveCommand(grid[i][j]);
						commandList.add(command);
					} else {
						LifeCommand command = new DeadCommand(grid[i][j]);
						commandList.add(command);
					}
				}
			}
		}
		//	        this.grid=newGrid;
		for (LifeCommand command: commandList) 
		{
			command.execute();
		}
	}
	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
      notifyAllObservers();
   }
 
   public void attach(LifeObserver observer){
      observers.add(observer);		
   }
 
   public void notifyAllObservers(){
      for (LifeObserver observer : observers) {
         observer.update();
      }
   } 		
   public int getRows() {
	   return this.rows;
   }
   public int getCols() {
	   return this.cols;
   }
   public Cell getCell(int row, int col) {
	   return grid[row][col];
   }
}

