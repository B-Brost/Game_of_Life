package life4command;

public class AliveState implements CellState{

	private static AliveState instance;
	private AliveState() {}
	public static AliveState create()
	{
		
		if (instance== null)
		{
			instance = new AliveState();
		}
		return instance;
	}

	public boolean isAlive()
	{
		return true;
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