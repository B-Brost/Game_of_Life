package life6visitor;

import java.util.ArrayList;

// The main program used to invoke the game of life system.
 
public class Main {

    public static void main(String[] args) {

        // Create an instance of the game with a 20x20 life grid
    	//   shown in a 500x500 window
        GameOfLife life = new GameOfLife(20, 20);

    	GameOfLifeUI ui=new GameOfLifeUI(life,500,500);
    }
}

