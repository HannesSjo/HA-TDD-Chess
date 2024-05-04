package ax.ha.tdd.chess.engine.pieces;

import ax.ha.tdd.chess.engine.Chessboard;
import ax.ha.tdd.chess.engine.Color;
import ax.ha.tdd.chess.engine.Square;

import java.util.ArrayList;
import java.util.List;

public class Queen extends ChessPieceBase implements ChessPiece{
    public Queen(Color player, Square location) {
        super(PieceType.QUEEN, player, location);
    }

    @Override
    public boolean canMove(Chessboard chessboard, Square destination) {

        int xDiff = Math.abs(location.getX() - destination.getX());
        int yDiff = Math.abs(location.getY() - destination.getY());

        // Check for rook-like movement (along ranks or files)
        if ((xDiff == 0 && yDiff != 0) || (yDiff == 0 && xDiff != 0)) {
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

        // Check for bishop-like movement (diagonal)
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
