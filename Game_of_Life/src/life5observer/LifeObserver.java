package life5observer;

public abstract class LifeObserver 
{
protected GameOfLife gameOfLife;
	
	LifeObserver(GameOfLife gameOfLife){
		this.gameOfLife = gameOfLife;
	}
	
	public abstract void update();
}
