package life5observer;

public interface CellState {
	public boolean isAlive();
	public CellState dead();
	public CellState alive();
	
}
