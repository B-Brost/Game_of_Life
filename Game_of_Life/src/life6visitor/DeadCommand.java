package life6visitor;

public class DeadCommand extends LifeCommand {

	DeadCommand(Cell cell) {
		super(cell);
	}

	@Override
	public void execute() {
		this.cell.dead();		
	}

}