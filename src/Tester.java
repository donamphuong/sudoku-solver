/**
 * Created by donamphuong on 20/03/2016.
 */
public class Tester {
    public static void main(String[] args) {
        SudokuBoard board = new SudokuBoard();

        //EASY
        /*board.setSquare(0, 0, 2);
        board.setSquare(0, 1, 1);
        board.setSquare(0, 6, 9);
        board.setSquare(0, 8, 8);

        board.setSquare(1, 2, 6);
        board.setSquare(1, 5, 2);
        board.setSquare(1, 7, 7);

        board.setSquare(2, 1, 9);
        board.setSquare(2, 7, 5);

        board.setSquare(3, 0, 6);
        board.setSquare(3, 1, 7);
        board.setSquare(3, 3, 1);
        board.setSquare(3, 5, 8);
        board.setSquare(3, 6, 3);
        board.setSquare(3, 7, 4);

        board.setSquare(4, 2, 2);
        board.setSquare(4, 3, 9);
        board.setSquare(4, 5, 7);
        board.setSquare(4, 6, 8);

        board.setSquare(5, 1, 8);
        board.setSquare(5, 2, 1);
        board.setSquare(5, 3, 3);
        board.setSquare(5, 5, 4);
        board.setSquare(5, 7, 2);
        board.setSquare(5, 8, 7);

        board.setSquare(6, 1, 5);
        board.setSquare(6, 7, 9);

        board.setSquare(7, 1, 2);
        board.setSquare(7, 3, 4);
        board.setSquare(7, 6, 6);

        board.setSquare(8, 0, 3);
        board.setSquare(8, 2, 4);
        board.setSquare(8, 7, 8);
        board.setSquare(8, 8, 1);*/

        //EVIL
        board.setSquare(0, 2, 8);
        board.setSquare(0, 3, 5);
        board.setSquare(0, 8, 1);

        board.setSquare(1, 1, 1);
        board.setSquare(1, 5, 4);
        board.setSquare(1, 6, 8);
        board.setSquare(1, 7, 5);

        board.setSquare(2, 0, 3);
        board.setSquare(2, 4, 1);
        board.setSquare(2, 7, 2);

        board.setSquare(3, 0, 9);
        board.setSquare(3, 3, 7);
        board.setSquare(3, 7, 1);

        board.setSquare(4, 2, 1);
        board.setSquare(4, 4, 8);
        board.setSquare(4, 6, 5);

        board.setSquare(5, 1, 7);
        board.setSquare(5, 5, 1);
        board.setSquare(5, 8, 3);

        board.setSquare(6, 1, 2);
        board.setSquare(6, 4, 4);
        board.setSquare(6, 8, 6);

        board.setSquare(7, 1, 3);
        board.setSquare(7, 2, 4);
        board.setSquare(7, 3, 1);
        board.setSquare(7, 7, 7);

        board.setSquare(8, 0, 5);
        board.setSquare(8, 5, 3);
        board.setSquare(8, 6, 1);

        board.solve();
    }
}
