package life2state;

import java.util.ArrayList;
import java.util.List;

public class Cell {
	CellState aliveState;
	CellState deadState;
	CellState cellState;
	boolean isAlive = false;
	private List<Cell> neighbors;
    
    public Cell() {
		deadState = new DeadState(this);
		aliveState = new AliveState(this);
		
		cellState = deadState;
		neighbors = new ArrayList<>(); 
    }
	
	public void dead() {
		cellState.dead();
	}
	public void alive() {
		cellState.alive();
	}
	public CellState getAliveState()
	{
		return aliveState;
	}
	public CellState getDeadState()
	{
		return deadState;
	}
	public void setCellState(CellState newCellState)
	{
		cellState=newCellState;
	}
	public boolean isAlive()
	{
		return isAlive;
	}
	public void addNeighbor(Cell neighborCell)
	{
//		adds all neighbors reqardless of live state
		neighbors.add(neighborCell);
	}

	public List<Cell> getNeighbors() {
		return neighbors;
	}

	public int nbrAliveNeighbors()
	{
		neighbors=getNeighbors();
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

