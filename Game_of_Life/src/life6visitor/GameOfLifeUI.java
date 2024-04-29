package life6visitor;


import java.awt.Color;
import java.util.ArrayList;

import edu.du.dudraw.Draw;
import edu.du.dudraw.DrawListener;

//Game of life main app using DuDraw
//Use mouse clicks to toggle cells
//Use spacebar to advance game

public class GameOfLifeUI extends LifeObserver implements DrawListener {
	// width and height in pixels
	private int width;
	private int height;
	private Draw window;

	// rows and cols for the game
	private int rows;
	private int cols;
	private Cell[][] grid; 

//	private ArrayList<LifeCommand> commandList;

	public GameOfLifeUI(GameOfLife gameOfLife,int width, int height) {
		super(gameOfLife);

		// Save the instance variables
		rows = gameOfLife.getRows();
		cols = gameOfLife.getCols();
		
		this.width = width;
		this.height = height;
		// Setup the grid
		//		Cell.setupGrid();
		this.grid = new Cell[rows][cols];
//		commandList= new ArrayList<LifeCommand>();
		// Setup the DuDraw board
		window = new Draw("Game of Life");
		window.setCanvasSize(width, height);
		window.setXscale(0, width);
		window.setYscale(0, height);

		// Add the mouse/key listeners
		window.addListener(this);

		gameOfLife.setupGrid(grid);
		// Draw the initial board
		update();
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
				if (this.grid[i][j].isAlive()) {
					// This is the center and half width/height
					window.filledRectangle((j * cellWidth)+(cellWidth/2), (i * cellHeight)+(cellHeight/2), cellWidth/2, cellHeight/2);
				}
			}
		}
	}

	// Below are the mouse/key listeners

	@Override
	public void keyPressed(int key) {
		// This is the advance button
		// Only advance for spacebar (ascii 32)
		if (key==32) {
			gameOfLife.advance(grid);
		}
		update();

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
		if (this.grid[cellLocRow][cellLocCol].isAlive())
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

