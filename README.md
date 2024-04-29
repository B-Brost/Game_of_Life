# Game_of_Life

The game of life is a two-dimensional cellular automaton game. The game begins with a grid filled with ‘dead’ cells. Using the mouse, you can select specific cells to ‘revive’ (these appear red in the screenshot below). The game then progresses through a series of evolutionary steps, where a set of rules is applied to each cell to determine its fate: whether it remains dead, remains alive, dies, or comes to life.

The classic rules are as follows:

1. A cell that is alive and has 2 or 3 living neighbors will stay alive.
2. A cell that is dead and has exactly 3 living neighbors will come to life.
3. In all other cases, the cell will die.

This repository contains multiple versions of this game, each demonstrating a different object-oriented design pattern:
1. State
2. Singleton
3. Command
4. Observer
5. Visitor

To play the game, open the main file of the design pattern you wish to explore and run the code. Click on the tiles to toggle their state from alive (red) to dead (white), and press space to advance the game. Depending on the state and surrounding conditions of each cell, the cells will either die or come to life! 
