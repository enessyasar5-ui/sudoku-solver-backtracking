

public class SudokuBoard {
    private static final String ST_EMPTY = "*  ";
    public int block;
    private int boardsize;
    public int[][] board;

    public SudokuBoard(int block) {
        this.block = block;
        boardsize = block * block;
        board = new int[boardsize][boardsize];
    }

    public int getBoardsize() {
        return boardsize;
    }

    public void setBoard(int row, int colomn, int value) {
        board[row][colomn] = value;
    }

    SudokuBoard(SudokuBoard other) {
        this(other.block);

        for (int r = 0; r < boardsize; r++) {
            for (int c = 0; c < boardsize; c++)
                board[r][c] = other.board[r][c];
        }
    }


    public String toString() {
        String st = "";
        st += line() + "\n";
        for (int r = 0; r < boardsize; r++) {
            st += rowtostring(r) + "\n";
            if ((r + 1) % block == 0) {
                st += line() + "\n";
            }
        }
        return st;
    }


    private String line() {
        int lenght = (3 * boardsize) + (2 * block) + 1;
        StringBuilder st = new StringBuilder();
        for (int i = 0; i < lenght; i++) {
            st.append("-");
        }
        return st.toString();
    }

    private String rowtostring(int row) {
        String st = "| ";
        for (int i = 0; i < boardsize; i++) {
            st += celltostring(row, i);
            if ((i + 1) % block == 0) {
                st += "| ";
            }
        }
        return st;
    }

    String celltostring(int row, int c) {
        String st = "";
        if (isEmpty(row, c)) {
            st += ST_EMPTY;
        } else {
            st += board[row][c] + "  ";
        }
        return st;
    }

    boolean isEmpty(int row, int col) {
        return board[row][col] == 0;

    }

    boolean isComp() {
        int i = 0;
        if (!Rules()) {
            return false;
        }
        for (int r = 0; r < boardsize; r++) {
            for (int c = 0; c < boardsize; c++) {
                if (isEmpty(r, c)) {
                    return false;
                }
            }
        }
        return true;
    }

    boolean Rules() {
        for (int i = 0; i < boardsize; i++) {
            if (!cCol(i)) return false;
            if (!cRow(i)) return false;
        }

        for (int r = 0; r < boardsize; r += block) {
            for (int c = 0; c < boardsize; c += block) {

                if (!cblock(r, c)) {
                    return false;
                }
            }
        }
        return true;
    }

    boolean cCol(int col) {
        int[] arr = new int[boardsize + 1];
        for (int r = 0; r < boardsize; r++) {
            if (board[r][col] != 0) {
                arr[board[r][col]]++;
            }
            if (arr[board[r][col]] > 1) {
                return false;
            }
        }
        return true;
    }

    boolean cRow(int row) {
        int[] arr = new int[boardsize + 1];
        for (int r = 0; r < boardsize; r++) {
            if (board[row][r] != 0) {
                arr[board[row][r]]++;
            }
            if (arr[board[row][r]] > 1) {
                return false;
            }
        }
        return true;
    }

    boolean cblock(int StartRow, int Startcolomb) {
        int[] arr = new int[boardsize + 1];
        int i = 0;
        for (int r = StartRow; r < StartRow + block; r++) {
            for (int c = Startcolomb; c < Startcolomb + block; c++) {
                if (board[r][c] != 0) {
                    arr[board[r][c]]++;
                }
                if (arr[board[r][c]] > 1) {
                    return false;
                }
                i++;
            }
        }
        return true;
    }
}