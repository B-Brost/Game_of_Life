package life5observer;

public class DeadCommand extends LifeCommand {

	DeadCommand(Cell cell) {
		super(cell);
	}

	@Override
	public void execute() {
		this.cell.dead();		
	}

}