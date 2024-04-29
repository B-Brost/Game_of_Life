package life4command;

import java.util.ArrayList;
import java.util.List;

public class Cell {

	private CellState cellState;
	boolean isAlive = false;
	private List<Cell> neighbors;
    
    public Cell() {
		this.cellState = DeadState.create();
		neighbors = new ArrayList<Cell>(); 
    }
	
	public void dead() {
		this.cellState = DeadState.create();

//		cellState = cellState.dead();
	}
	public void alive() {
		this.cellState = AliveState.create();

//		cellState = cellState.alive();
	}
	public void setCellState(CellState newCellState)
	{
		cellState=newCellState;
	}
	public boolean isAlive()
	{
		return cellState.isAlive();
	}
	public void addNeighbor(Cell neighborCell)
	{
//		adds all neighbors reqardless of live state
		neighbors.add(neighborCell);
	}


	public int nbrAliveNeighbors()
	{
		int aliveNeighborCount=0;
		for (Cell neighbor : neighbors) 
		{
	        if (neighbor.isAlive()) 
	        {
	            aliveNeighborCount++;
	        }
	    }
	    return aliveNeighborCount;
	}
}