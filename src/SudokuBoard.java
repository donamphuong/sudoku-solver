import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

/**
 * Created by donamphuong on 18/03/2016.
 */
public class SudokuBoard {
    private final int SUDOKU_LENGTH = 9;

    private Square[][] board;
    //private boolean firstComputation = true;
    private LinkedList<Square> oneValue = new LinkedList<>();
    private LinkedList<Square> noValue = new LinkedList<>();

    //the order of squares added
    private LinkedList<Square> lastSquares = new LinkedList<>();

    public SudokuBoard() {
        board = new Square[SUDOKU_LENGTH][SUDOKU_LENGTH];

        for(int row = 0; row < SUDOKU_LENGTH; row++) {
            for(int col = 0; col < SUDOKU_LENGTH; col++) {
                board[row][col] = new Square(0, Square.findPosition(row, col), this);
                noValue.add(board[row][col]);
            }
        }
    }

    /*
    Set the square at row and column to the value specified by the parameter value
     */
    public void setSquare(int row, int col, int value) {
        Pair<Integer, Integer> pos = new Pair<Integer, Integer>(row, col);
        Square s = getSquare(pos);
        s.update(value);
    }

    public void removeFromNoValue(Square s) {
        noValue.remove(s);
    }

    public void display() {
        System.out.println("   0 1 2   3 4 5   6 7 8");
        System.out.println("  - - - - - - - - - - - -");

        for(int i = 0; i < SUDOKU_LENGTH; i ++) {
            String row = i + "|";
            for(int j = 0; j < SUDOKU_LENGTH; j++) {
                row += " " + board[i][j].getValue();

                if((j+1) % 3 == 0) {
                    row += " |";
                }
            }
            System.out.println(row);

            if((i+1) % 3 == 0) {
                System.out.println("  - - - - - - - - - - - -");
            }
        }
    }

    public Square getSquare(int position) {
        Pair<Integer, Integer> newPair = new Pair<>(position/9, position%9);
        return getSquare(newPair);
    }

    public Square getSquare(Pair<Integer, Integer> pos) {
        int column = pos.getC(), row = pos.getR();
        return (column >= 0 && column <= 8 && row >= 0 && row <= 8) ? board[row][column] : null;
    }

    public void addToOneValue(Square s) {
        oneValue.add(s);
    }

    public void solve() {
        display();

        while(!oneValue.isEmpty()) {
            Square s = oneValue.remove();
            int nextValue = s.getNextPossibleValue();
            s.update(nextValue);
        }
        //display();

        while(!noValue.isEmpty()) {
            Square noValueSquare = noValue.remove();
            int possibleValue = noValueSquare.getPossibleValue();

            if(possibleValue == 0) {
                noValue.addFirst(noValueSquare);
                backTrack();
            } else {
                noValueSquare.update(noValueSquare.getPossibleValue());
                lastSquares.add(noValueSquare);
            }

            //display();
        }

        display();
        System.out.println("CONGRATULATIONS, YOU FOUND THE ANSWER TO THIS SUDOKU PUZZLE");
    }

    public void backTrack() {
        Square lastSquare = lastSquares.removeLast();
        int possibleValue = lastSquare.getPossibleValue();

        if(possibleValue == 0) {
            noValue.addFirst(lastSquare);
            lastSquare.removeValue();
            backTrack();
        } else {
            lastSquare.update(possibleValue);
            lastSquares.add(lastSquare);
        }
    }
}


