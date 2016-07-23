import java.util.HashSet;
import java.util.Set;

public class Square {
    private final int MAX_VALUE = 9;

    private int value;
    private Pair<Integer, Integer> position;
    private SudokuBoard board;
    private Set<Integer> possibleValues;

    //squares represent position of squares that are in the same row, column or big square of this square
    private Set<Pair<Integer, Integer>> squares = new HashSet<>();

    public Square(int value, int position, SudokuBoard board) {
        this.value = value;
        this.position = new Pair<>(position/MAX_VALUE, position%MAX_VALUE);
        this.board = board;
        this.possibleValues = new HashSet<>();
        initialise();
    }

    private void initialise() {
        possibleValues.add(1);
        possibleValues.add(2);
        possibleValues.add(3);
        possibleValues.add(4);
        possibleValues.add(5);
        possibleValues.add(6);
        possibleValues.add(7);
        possibleValues.add(8);
        possibleValues.add(9);

        for(int i = 0; i < MAX_VALUE; i++) {
            Pair<Integer, Integer> sameRow = new Pair<>(position.getR(), i);
            Pair<Integer, Integer> sameColumn = new Pair<>(i, position.getC());
            if(i != position.getR()) {
                squares.add(sameColumn);
            }

            if(i!= position.getC()) {
                squares.add(sameRow);
            }
        }

        addSquare();
    }

    public void addSquare() {
        Pair<Integer, Integer> row = findStart(position.getR()), column = findStart(position.getC());

        for(int i = row.getR(); i <= row.getC(); i++) {
            for(int j = column.getR(); j <= column.getC(); j++) {
               if(i != 0 && j != 0) {
                   Pair<Integer, Integer> newPair = new Pair<>(position.getR() + i, position.getC() + j);
                   squares.add(newPair);
               }
            }
        }
    }

    public Pair<Integer, Integer> findStart(int num) {
        if(num%3 == 0) {
            return new Pair<Integer, Integer>(1, 2);
        } else if (num%3 == 1) {
            return new Pair<Integer, Integer>(-1, 1);
        } else {
            return new Pair<Integer, Integer>(-2 , -1);
        }
    }

    public boolean hasValue() {
       return value != 0;
    }

    public int getPosition(Pair<Integer, Integer> rowCol) {
        return rowCol.getR() * MAX_VALUE + rowCol.getC();
    }

    /*
    Return the first possible value of a square - provided the possibleValues is not empty
     */
    public int getPossibleValue() {
        Set<Integer> knownValues = new HashSet<>();

        for(Pair<Integer, Integer> s : squares) {
            int value = board.getSquare(s).getValue();

            if(!knownValues.contains(value) && value != 0) {
                knownValues.add(value);
            }
        }

        for(int i : possibleValues) {
            if(!knownValues.contains(i) && i > getValue()) {
                return i;
            }
        }

        return 0;
    }

    public int getNextPossibleValue() {
        return possibleValues.iterator().next();
    }

    public boolean hasPossibleValue() {
        return !possibleValues.isEmpty();
    }

    public void removeValue() {
        value = 0;
    }

    public int getValue() {
        return value;
    }

    public static int findPosition(int row, int column) {
        return row * 9 + column;
    }

  /*  public void removePossibleValue(int value) {
        if(possibleValues.contains(value)) {
            possibleValues.remove(value);
            if(possibleValues.size() == 1 && !hasValue()) {
                board.addToOneValue(this);
            }
        }
    }*/
     public Set<Integer> getPossibleValues() {
         return possibleValues;
     }

    public void update(int val) {
        value = val;

        board.removeFromNoValue(this);
        /*removePossibleValue(val);

        for(Pair<Integer, Integer> s : squares) {
            board.getSquare(s).removePossibleValue(val);
        }*/

        for(Pair<Integer, Integer> s : squares) {
           board.getSquare(s).oneValue();
        }
    }

    private void oneValue() {
        if(possibleValues.size() == 1) {
            board.addToOneValue(this);
        }
    }
}
