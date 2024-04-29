package life5observer;

public abstract class LifeCommand {
	protected Cell cell;
	
	LifeCommand(Cell cell) {
		this.cell = cell;
	}
	
	public abstract void execute();

}