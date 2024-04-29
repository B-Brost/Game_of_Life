package life3singleton;

public interface CellState {
	public boolean isAlive();
	public CellState dead();
	public CellState alive();
	
}
