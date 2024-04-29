package life4command;

public class DeadState implements CellState{

	private static DeadState instance;
	private DeadState() {}
	public static DeadState create()
	{
		
		if (instance== null)
		{
			instance = new DeadState();
		}
		return instance;
	}

	public boolean isAlive()
	{
		return false;
	}
	
	@Override
	public CellState dead() {
		return this;
	}

	@Override
	public CellState alive() {
		return this;
	}
	
}

