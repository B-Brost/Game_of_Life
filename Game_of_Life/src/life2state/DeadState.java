package life2state;

public class DeadState extends CellState{

	Cell cell;
	public DeadState(Cell newCell) 
	{
		cell=newCell;
	}

	@Override
	public void dead() {
		cell.isAlive=false;
		cell.setCellState(cell.getDeadState());
	}

	@Override
	public void alive() {
		cell.isAlive=true;
		cell.setCellState(cell.getAliveState());
	}
	
}

