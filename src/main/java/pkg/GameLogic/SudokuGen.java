package pkg.GameLogic;

import java.util.Random;

public class SudokuGen {
    private static SudokuGen instance;
    private Solver solver;

    Level difficulty;


    private SudokuGen() {
        this.solver = new Solver();
    }

    public static SudokuGen getInstance() {
        if (instance == null) {
            instance = new SudokuGen();
        }
        return instance;
    }

    public Grid generateGrid() {
        Grid grid = generate();
        int difficulty = setDifficulty();
        removeCells( grid, difficulty );
        return grid;
    }

    private void removeCells(Grid grid, int NoCells) {
        Random random = new Random();
        for (int i = 0; i < NoCells; ) {
            int randRow = random.nextInt( 9 );
            int randCol = random.nextInt( 9 );
            Cell cell = grid.getCell( randRow, randCol );
            if (!cell.isEmpty()) {
                cell.setValue( 0 );
                i++;
            }

        }

    }

    private Grid generate() {
        Grid grid = Grid.emptyGrid();
        solver.solve( grid );
        return grid;
    }

    public void setDifficulty(Level difficulty) {
        this.difficulty = difficulty;
    }

    private int setDifficulty() {
        switch (difficulty) {
            case LOW:
                return 30;
            case MEDIUM:
                return 50;
            case HIGH:
                return 70;
            default:
                throw new IllegalArgumentException( "Not a difficulty" );


        }
    }

}
