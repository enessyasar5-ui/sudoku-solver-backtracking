public class CellPosition {
    int row;
    int col;
    CellPosition(int row,int col){
        this.col=col;
        this.row=row;
    }

    @Override
    public String toString() {
        return "CellPosition{" +
                "row=" + row +
                ", col=" + col +
                '}';
    }
}
