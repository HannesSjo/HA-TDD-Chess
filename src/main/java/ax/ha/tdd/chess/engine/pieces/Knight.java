package ax.ha.tdd.chess.engine.pieces;

import ax.ha.tdd.chess.engine.Chessboard;
import ax.ha.tdd.chess.engine.Color;
import ax.ha.tdd.chess.engine.Square;

import java.util.ArrayList;
import java.util.List;

public class Knight extends ChessPieceBase implements ChessPiece{
    public Knight(Color player, Square location) {
        super(PieceType.KNIGHT, player, location);
    }

    @Override
    public boolean canMove(Chessboard chessboard, Square destination) {

        int xDiff = Math.abs(location.getX() - destination.getX());
        int yDiff = Math.abs(location.getY() - destination.getY());

        return (xDiff == 1 && yDiff == 2) || (xDiff == 2 && yDiff == 1);
    }
}
