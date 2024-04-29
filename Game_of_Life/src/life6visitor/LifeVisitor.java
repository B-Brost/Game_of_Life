package life6visitor;

import java.util.ArrayList;

public abstract class LifeVisitor 
{
	public void visit(Cell cell,ArrayList<LifeCommand> commandList) {
		cell.accept(this, commandList);
	}
	public abstract void visitLiveCell(Cell cell, ArrayList<LifeCommand> commandList);
	public abstract void visitDeadCell(Cell cell, ArrayList<LifeCommand> commandList);
}
