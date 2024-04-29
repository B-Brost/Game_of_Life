package life6visitor;

import java.util.ArrayList;

public interface CellState {
	public boolean isAlive();
	public CellState dead();
	public CellState alive();

	void accept(LifeVisitor visitor, ArrayList<LifeCommand> commandList, Cell cell);
}
