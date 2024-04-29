package life6visitor;

public class AliveCommand extends LifeCommand {

	AliveCommand(Cell cell) {
		super(cell);
	}
	@Override
	public void execute() {
		this.cell.alive();
	}

}