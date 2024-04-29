package life4command;

public class AliveCommand extends LifeCommand {

	AliveCommand(Cell cell) {
		super(cell);
	}
	@Override
	public void execute() {
		this.cell.alive();
	}

}