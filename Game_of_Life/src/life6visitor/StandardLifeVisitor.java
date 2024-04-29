package life6visitor;

import java.util.ArrayList;

public class StandardLifeVisitor extends LifeVisitor 
{

	public void visitLiveCell(Cell cell,ArrayList<LifeCommand> commandList){
		//		add the individual actions that it does for alive and dead state
		int n=cell.nbrAliveNeighbors();
		if (n == 2 || n == 3) {
			LifeCommand command = new AliveCommand(cell);
			commandList.add(command);
		} 
		else {
			//	                    	newGrid[i][j].dead();
			LifeCommand command = new DeadCommand(cell);
			commandList.add(command);
		}	
	}	
	//		visitor.visit(cell, n, commandList);
	//	}
	public void visitDeadCell(Cell cell,ArrayList<LifeCommand> commandList) {
		int n=cell.nbrAliveNeighbors();

		if (n == 3) {
			LifeCommand command = new AliveCommand(cell);
			commandList.add(command);
		} 
	}
}

