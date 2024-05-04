package ax.ha.tdd.chess.engine.pieces;

import ax.ha.tdd.chess.engine.Chessboard;
import ax.ha.tdd.chess.engine.Color;
import ax.ha.tdd.chess.engine.Square;

import java.util.ArrayList;
import java.util.List;

public class Bishop extends ChessPieceBase implements ChessPiece{
    public Bishop(Color player, Square location) {
        super(PieceType.BISHOP, player, location);
    }

    @Override
    public boolean canMove(Chessboard chessboard, Square destination) {

        int xDiff = Math.abs(location.getX() - destination.getX());
        int yDiff = Math.abs(location.getY() - destination.getY());

        if (xDiff == yDiff) {
            int xDirection = Integer.compare(destination.getX(), location.getX());
            int yDirection = Integer.compare(destination.getY(), location.getY());

            List<Square> passedSquares = new ArrayList<>();
            int currentX = location.getX() + xDirection;
            int currentY = location.getY() + yDirection;

            while (currentX != destination.getX() || currentY != destination.getY()) {
                passedSquares.add(new Square(currentX, currentY));
                currentX += xDirection;
                currentY += yDirection;
            }

            for (Square square : passedSquares) {
                if (!isEmpty(chessboard, square)) return false;
            }

            return true;
        }
        return false;
    }

    boolean isEmpty(Chessboard board, Square square){
        return board.getPieceAt(square) == null;
    }
}
