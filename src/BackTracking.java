abstract class BackTracking {
    public final boolean Solve(){
        if(isSolved()){
            return true;
        }
        for(int move: possibleMoves()){
            if(isValid(move)){
                getMove(move);
                if(Solve()){
                    return true;
                }
            }
            turnBack(move);
        }
       return false;
    }

    protected abstract boolean isSolved();
    protected abstract int[] possibleMoves();
    protected abstract void getMove(int move);
    protected abstract boolean  isValid(int move);
    protected abstract void turnBack(int move);

}
