package pkg.GameLogic;

import java.util.Optional;
import java.util.Random;

public class Solver {
    private static final int Empty = 0;
    private final int[] values;

    public Solver() {
        this.values = shuffle();
    }

    private int[] shuffle() {
        int[] vals = {Empty, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        Random rand = new Random();
        for (int i = vals.length - 1; i > 0; i--) {
            int randTemp = rand.nextInt( i );
            int temp = vals[randTemp];
            vals[randTemp] = vals[i];
            vals[i] = temp;


        }
        return vals;
    }

    private boolean solve(Grid grid, Optional<Cell> cell) {
        if (!cell.isPresent()) {
            return true;
        }
        for (int val : values) {
            if (grid.isValidValueForCell( cell.get(), val )) {
                cell.get().setValue( val );
            }
            if (solve( grid, grid.getNextEmpty( cell.get() ) )) {
                return true;
            }
            cell.get().setValue( Empty );
        }
        return false;

    }

    public void solve(Grid grid) {
        boolean solvabel = solve( grid, grid.getFirstEmpty() );

        if (!solvabel)
            throw new IllegalStateException( "Grid not solvable" );
    }
}
