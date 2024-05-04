package ax.ha.tdd.chess.engine.pieces;

import ax.ha.tdd.chess.engine.Chessboard;
import ax.ha.tdd.chess.engine.Square;
import ax.ha.tdd.chess.engine.Color;

public class Pawn extends ChessPieceBase implements ChessPiece{

    boolean firstMove;

    public Pawn(Color player, Square location) {
        super(PieceType.PAWN, player, location);
        firstMove = true;
    }

    @Override
    public boolean canMove(Chessboard chessboard, Square destination) {
        boolean result = canMoveLogic(chessboard, destination);
        if (result) firstMove = false;
        return result;
    }

    public boolean canMoveLogic(Chessboard chessboard, Square destination) {
        if (chessboard.getPieceAt(destination) != null) {
            int xDiff = location.getX() - destination.getX();
            xDiff = Math.abs(xDiff);

            if (xDiff != 1) return false;
        } else {
            if (destination.getX() != location.getX()) return false;
        }

        int diff = location.getY() - destination.getY();

        if (color == Color.WHITE) {
            if (diff < 0) return false;
        } else if (color == Color.BLACK){
            if (diff > 0) return false;
        }

        diff = Math.abs(diff);

        if (diff == 0) return false;
        if (diff == 2 && firstMove) return true;
        if (diff == 1) return true;

        return false;
    }
}
