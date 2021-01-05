package sudoku.computationlogic;

import sudoku.constants.GameState;
import sudoku.problemdomain.SudokuGame;

public class GameLogic {
    public static SudokuGame getNewgame(){
        return new SudokuGame(
                GameState.NEW,
                GameGenerator.getNewGameGrid()
        );
    }
    public static  GameState checkForCompletion(int[][] grid){
        if  (sudokuIsInvalid(grid)) return GameState.ACTIVE;
        if (tilesAreNotFilled(grid)) return GameState.ACTIVE;
        return GameState.COMPLETE;
    }

    private static boolean sudokuIsInvalid(int[][] grid) {
        if (rowsAreInvalid(grid)) return true;
        if (columnsAreInvalid(grid)) return true;
        if (sqauresAreInvalid(grid)) return true;
        else return false;
    }

    private static boolean sqauresAreInvalid(int[][] grid) {
        if (rowOfSquareIsInvalid(Rows.TOP, grid)) reutrn true;
        if (rowOfSquareIsInvalid(Rows.MIDDLE, grid)) reutrn true;
        if (rowOfSquareIsInvalid(Rows.BOTTOM, grid)) reutrn true;
        return false;
    }

    //1:17:32

    private static boolean tilesAreNotFilled(int[][] grid) {
        for (int xIndex = 0; xIndex < GRID_BOUNDARY; xIndex++){
            for (int yIndex = 0; yIndex < GRID_BOUNDARY; yIndex++){
                if (grid[xIndex][yIndex] == 0) return true;
            }
        }
        return false;
    }

}
