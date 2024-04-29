package life4command;

public interface CellState {
	public boolean isAlive();
	public CellState dead();
	public CellState alive();
	
}
