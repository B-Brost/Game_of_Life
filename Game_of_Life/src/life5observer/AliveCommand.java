package life5observer;

public class AliveCommand extends LifeCommand {

	AliveCommand(Cell cell) {
		super(cell);
	}
	@Override
	public void execute() {
		this.cell.alive();
	}

}