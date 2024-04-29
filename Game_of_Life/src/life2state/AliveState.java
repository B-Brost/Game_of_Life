package life2state;

public class AliveState extends CellState{
	Cell cell;
	public AliveState(Cell newCell) 
	{
		cell=newCell;
	}

	@Override
	public void dead() {
//		need to add if cell fits requirements to die or stay dead then isAlive is false and vice versa for the alive()
		cell.isAlive=false;
		cell.setCellState(cell.getDeadState());
	}

	@Override
	public void alive() {
		cell.isAlive=true;
		cell.setCellState(cell.getAliveState());
	}
}
