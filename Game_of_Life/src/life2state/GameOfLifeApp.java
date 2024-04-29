package life2state;

import java.awt.Color;
import edu.du.dudraw.Draw;
import edu.du.dudraw.DrawListener;

// Game of life main app using DuDraw
// Use mouse clicks to toggle cells
// Use spacebar to advance game

public class GameOfLifeApp implements DrawListener {
	// width and height in pixels
	private int width;
    private int height;
    private Draw window;
 
    // rows and cols for the game
    private int rows;
    private int cols;
    private Cell[][] grid; 
   
    
    public GameOfLifeApp(String title, int rows, int cols, int width, int height) {
        
    	// Save the instance variables
    	this.rows = rows;
		this.cols = cols;
		this.width = width;
		this.height = height;
		// Setup the grid
//		Cell.setupGrid();
	    this.grid = new Cell[rows][cols];

         
        // Setup the DuDraw board
        window = new Draw(title);
        window.setCanvasSize(width, height);
        window.setXscale(0, width);
		window.setYscale(0, height);

		// Add the mouse/key listeners
        window.addListener(this);
        setupGrid(this.grid);
        // Draw the initial board
	    update();
    }
    
	private void setupGrid(Cell[][] grid) 
	{
		for (int i = 0; i < rows; i++) {
        	for (int j = 0; j < cols; j++) {
        		Cell cell = new Cell();
        		cell.dead();
        		grid[i][j] = cell;
            }
        }
	}
    
    private void drawGrid() {
        
    	window.setPenColor(Color.black);
 		
        int cellWidth = width / cols;
        int cellHeight = height / rows;
     
        for (int i = 0; i <= rows; i++) {
        	window.line(0, i * cellHeight, this.width, i * cellHeight);
        }
        
        for (int i = 0; i <= cols; i++) {
        	window.line(i * cellWidth, 0, i * cellWidth, this.height);
        }
    }
     
    private void drawLives() {
    	int cellWidth = width / cols;
        int cellHeight = height / rows;
        
    	window.setPenColor(Color.red);
        for (int i = 0; i < rows; i++) {
        	for (int j = 0; j < cols; j++) {
        		if (this.grid[i][j].isAlive==true) {
        			// This is the center and half width/height
        			window.filledRectangle((j * cellWidth)+(cellWidth/2), (i * cellHeight)+(cellHeight/2), cellWidth/2, cellHeight/2);
                }
            }
        }
    }

    // This method implements the rules of the Game of Life. For each cell,
    //   we simple find the number of neighbors and then bring the cell to life
    //   if appropriate.
    public void advance() {
		for (int i = 0; i < this.rows; i++) 
		{
			for (int j = 0; j < this.cols; j++) 
			{
				int n = 0;
				for (int k=0;k<3;k++)
				{
					for (int l=0;l<3;l++)
					{
						int x=i-1+l;
						int y=j-1+k;
						if ((x>=0 && y>=0)&&(x<this.cols && y<this.rows)&&(x!=i||y!=j))
						{
							n++;
							grid[i][j].addNeighbor(this.grid[x][y]);
						}
						else if (x==21)
						{
							if (y==21)
							{
								y=1;
							}
							x=1;
							n++;
							grid[i][j].addNeighbor(this.grid[x][y]);
						}
						else if (y==21)
						{
							if (x==21)
							{
								x=1;
							}
							y=1;
							n++;
							grid[i][j].addNeighbor(this.grid[x][y]);
						}
					}
				}
			}
		}
    	int n = 0;
        Cell[][] newGrid = new Cell[rows][cols];
        setupGrid(newGrid);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                n = grid[i][j].nbrAliveNeighbors();
                if (this.grid[i][j].isAlive==true) {
                    if (n == 2 || n == 3) {
                        newGrid[i][j].alive();
                    } else {
                    	newGrid[i][j].dead();
                    }
                } else {
                    if (n == 3) {

                    	newGrid[i][j].alive();
                    } else {
                    	newGrid[i][j].dead();
                    }
                }
            }
        }
        this.grid=newGrid;
        update();
    }

    // Below are the mouse/key listeners
    
	@Override
	public void keyPressed(int key) {
		// This is the advance button
		// Only advance for spacebar (ascii 32)
		if (key==32) {
			advance();
		}
	}

	@Override
	public void keyReleased(int key) {
		// Do nothing
	}

	@Override
	public void keyTyped(char key) {
		// Do nothing
	}

	@Override
	public void mouseClicked(double arg0, double arg1) {
		// Do nothing
	}

	@Override
	public void mouseDragged(double x, double y) {
		// Do nothing
	}

	@Override
	public void mousePressed(double x, double y) {
		// This is the toggle of grid locations
		int cellWidth = width / cols;
        int cellHeight = height / rows;
        
        int cellLocRow = (int)(y / cellHeight);
        int cellLocCol = (int)(x / cellWidth);
        if (this.grid[cellLocRow][cellLocCol].isAlive==true)
        	{
        	this.grid[cellLocRow][cellLocCol].dead();
        	}
        else
        {
        	this.grid[cellLocRow][cellLocCol].alive();
        }
		update();        
	}

	@Override
	public void mouseReleased(double x, double y) {
		// Do nothing
	}

	@Override
	public void update() {
		// Redraw the entire board
		window.clear(Color.white);  // Clear in white
	 	drawGrid();
	 	drawLives();
	}
	
}

