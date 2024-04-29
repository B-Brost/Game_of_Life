package life6visitor;

public abstract class LifeCommand {
	protected Cell cell;
	
	LifeCommand(Cell cell) {
		this.cell = cell;
	}
	
	public abstract void execute();

}