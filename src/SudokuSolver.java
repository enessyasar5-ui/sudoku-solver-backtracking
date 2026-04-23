public class SudokuSolver {
    boolean[][] usedRow;
    boolean[][] usedCol;
    boolean[][] usedBlock;

    public SudokuBoard Solve(SudokuBoard s1) {
        usedRow = new boolean[s1.getBoardsize()][s1.getBoardsize() + 1];
        usedCol = new boolean[s1.getBoardsize()][s1.getBoardsize() + 1];
        usedBlock = new boolean[s1.getBoardsize()][s1.getBoardsize() + 1];
        SudokuBoard sb = new SudokuBoard(s1);
        for (int r = 0; r < s1.getBoardsize(); r++) {
            for (int c = 0; c < s1.getBoardsize(); c++) {

                if (!sb.isEmpty(r, c)) {
                   int n=sb.board[r][c];
                   used(r,c,n,sb,0);
                }
            }
        }
        if (TrySolve(sb)) {
            return sb;
        }
        return null;
    }

    boolean TrySolve(SudokuBoard sb) {

        if (sb.isComp()) {
            return true;
        }

        CellPosition EmptyCell = firstEmptyCell(sb);

        for (int n = 1; n <= sb.getBoardsize(); n++) {

            if (!used(EmptyCell.row, EmptyCell.col, n, sb, 3)) {
                sb.setBoard(EmptyCell.row, EmptyCell.col, n);
                used(EmptyCell.row, EmptyCell.col, n, sb, 0);

                if (TrySolve(sb)) return true;
                used(EmptyCell.row, EmptyCell.col, n, sb, 1);
                sb.setBoard(EmptyCell.row, EmptyCell.col, 0);

            }
        }
        return false;
    }

    CellPosition firstEmptyCell(SudokuBoard s2) {
        for (int r = 0; r < s2.getBoardsize(); r++) {
            for (int c = 0; c < s2.getBoardsize(); c++) {
                if (s2.isEmpty(r, c)) {
                    return new CellPosition(r, c);
                }

            }
        }
        return null;
    }

    boolean used(int r, int c, int n, SudokuBoard sb, int d) {
        int k = (int) Math.sqrt(sb.getBoardsize());
        int block = (r / k) * k + (c / k); //bu kısmı hazır aldım
        if (d == 0) {
            usedCol[c][n] = true;
            usedRow[r][n] = true;
            usedBlock[block][n] = true;
        }
        if (d == 1) {
            usedCol[c][n] = false;
            usedRow[r][n] = false;
            usedBlock[block][n] = false;
        }
        return usedBlock[block][n] || usedRow[r][n] || usedCol[c][n];
    }
}
