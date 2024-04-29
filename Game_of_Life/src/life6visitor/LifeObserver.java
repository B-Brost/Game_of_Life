package life6visitor;

public abstract class LifeObserver 
{
protected GameOfLife gameOfLife;
	
	LifeObserver(GameOfLife gameOfLife){
		this.gameOfLife = gameOfLife;
	}
	
	public abstract void update();
}
