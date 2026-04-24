public class Main {
    public static void main(String[] args) {
        SudokuSolver ss = new SudokuSolver();

        SudokuBoard sb = new SudokuBoard(3);

        sb.setBoard(0, 7, 4);
        sb.setBoard(0, 8, 5);
        sb.setBoard(1, 2, 6);
        sb.setBoard(1, 5, 4);
        sb.setBoard(1, 8, 3);
        sb.setBoard(2, 2, 9);
        sb.setBoard(2, 3, 3);
        sb.setBoard(2, 6, 1);
        sb.setBoard(3, 6, 3);
        sb.setBoard(3, 0, 6);
        sb.setBoard(3, 4, 2);
        sb.setBoard(4, 2, 8);
        sb.setBoard(4, 3, 1);
        sb.setBoard(4, 6, 7);
        sb.setBoard(6, 0, 7);
        sb.setBoard(6, 3, 8);
        sb.setBoard(6, 6, 6);
        sb.setBoard(7, 0, 2);
        sb.setBoard(7, 5, 1);
        sb.setBoard(7, 6, 5);
        sb.setBoard(7, 7, 7);
        sb.setBoard(8, 0, 5);
        sb.setBoard(8, 3, 4);

        System.out.println(sb);

        SudokuBoard solution = ss.Solve(sb);

        System.out.println(solution);
    }
}
