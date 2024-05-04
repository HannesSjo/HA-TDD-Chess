package ax.ha.tdd.chess.engine.pieces;

import ax.ha.tdd.chess.engine.Chessboard;
import ax.ha.tdd.chess.engine.Color;
import ax.ha.tdd.chess.engine.Square;

import java.util.ArrayList;
import java.util.List;

public class King extends ChessPieceBase implements ChessPiece{
    public King(Color player, Square location) {
        super(PieceType.KING, player, location);
    }

    @Override
    public boolean canMove(Chessboard chessboard, Square destination) {
        int xDiff = Math.abs(location.getX() - destination.getX());
        int yDiff = Math.abs(location.getY() - destination.getY());
        if (xDiff <= 1 && yDiff <= 1) {
            return !inCheck(chessboard, destination);
        }
        return false;
    }

    boolean inCheck(Chessboard chessboard, Square destination){
        return (inCheckPawn(chessboard, destination) || inCheckRook(chessboard, destination) || inCheckBishop(chessboard, destination) || inCheckKnight(chessboard, destination) || inCheckQueen(chessboard, destination) || inCheckKing(chessboard, destination));
    }

    boolean inCheckPawn(Chessboard chessboard, Square target){
        int x = target.getX();
        int y = target.getY();
        List<Square> dangers = new ArrayList<>();
        if (color == Color.WHITE){
            dangers.add(createIfValid(x+1,y-1));
            dangers.add(createIfValid(x-1,y-1));
        }
        if (color == Color.BLACK){
            dangers.add(createIfValid(x+1,y+1));
            dangers.add(createIfValid(x-1,y+1));
        }

        for(Square danger : dangers) {
            if (danger == null) continue;

            ChessPiece piece = chessboard.getPieceAt(danger);
            if (piece != null){
                if (piece.getColor() == color) continue;
                if (piece.getType() == PieceType.PAWN) return true;
            }
        }
        return false;
    }
    boolean inCheckRook(Chessboard chessboard, Square target){
        for (int i = 1; i <= 8; i++) {
            Square square = createIfValid(target.getX(), target.getY() + i);
            if (square == null) continue;

            ChessPiece piece = chessboard.getPieceAt(square);
            if (piece == null) continue;
            if (piece.getColor() == color){
                if (piece.getType() == PieceType.KING) continue;
                else break;
            }
            if (piece.getType() == PieceType.ROOK) return true;
        }

        for (int i = 1; i <= 8; i++) {
            Square square = createIfValid(target.getX(), target.getY() - i);
            if (square == null) continue;

            ChessPiece piece = chessboard.getPieceAt(square);
            if (piece == null) continue;
            if (piece.getColor() == color){
                if (piece.getType() == PieceType.KING) continue;
                else break;
            }
            if (piece.getType() == PieceType.ROOK) return true;
        }

        for (int i = 1; i <= 8; i++) {
            Square square = createIfValid(target.getX()+i, target.getY());
            if (square == null) continue;

            ChessPiece piece = chessboard.getPieceAt(square);
            if (piece == null) continue;
            if (piece.getColor() == color){
                if (piece.getType() == PieceType.KING) continue;
                else break;
            }
            if (piece.getType() == PieceType.ROOK) return true;
        }

        for (int i = 1; i <= 8; i++) {
            Square square = createIfValid(target.getX()-i, target.getY());
            if (square == null) continue;

            ChessPiece piece = chessboard.getPieceAt(square);
            if (piece == null) continue;
            if (piece.getColor() == color){
                if (piece.getType() == PieceType.KING) continue;
                else break;
            }
            if (piece.getType() == PieceType.ROOK) return true;
        }

        return false;
    }
    boolean inCheckBishop(Chessboard chessboard, Square target){
        for (int i = 1; i <= 8; i++) {
            Square square = createIfValid(target.getX()+i, target.getY()+i);
            if (square == null) continue;

            ChessPiece piece = chessboard.getPieceAt(square);
            if (piece == null) continue;
            if (piece.getColor() == color){
                if (piece.getType() == PieceType.KING) continue;
                else break;
            }
            if (piece.getType() == PieceType.BISHOP) return true;
        }

        for (int i = 1; i <= 8; i++) {
            Square square = createIfValid(target.getX()-i, target.getY()+i);
            if (square == null) continue;

            ChessPiece piece = chessboard.getPieceAt(square);
            if (piece == null) continue;
            if (piece.getColor() == color){
                if (piece.getType() == PieceType.KING) continue;
                else break;
            }
            if (piece.getType() == PieceType.BISHOP) return true;
        }

        for (int i = 1; i <= 8; i++) {
            Square square = createIfValid(target.getX()+i, target.getY()-i);
            if (square == null) continue;

            ChessPiece piece = chessboard.getPieceAt(square);
            if (piece == null) continue;
            if (piece.getColor() == color){
                if (piece.getType() == PieceType.KING) continue;
                else break;
            }
            if (piece.getType() == PieceType.BISHOP) return true;
        }

        for (int i = 1; i <= 8; i++) {
            Square square = createIfValid(target.getX()-i, target.getY()-i);
            if (square == null) continue;

            ChessPiece piece = chessboard.getPieceAt(square);
            if (piece == null) continue;
            if (piece.getColor() == color){
                if (piece.getType() == PieceType.KING) continue;
                else break;
            }
            if (piece.getType() == PieceType.BISHOP) return true;
        }

        return false;
    }
    boolean inCheckKnight(Chessboard chessboard, Square target) {
        int x = target.getX();
        int y = target.getY();
        List<Square> dangers = new ArrayList<>();

        dangers.add(createIfValid(x+1,y+2));
        dangers.add(createIfValid(x+2,y+1));
        dangers.add(createIfValid(x+2,y-1));
        dangers.add(createIfValid(x+1,y-2));
        dangers.add(createIfValid(x-1,y-2));
        dangers.add(createIfValid(x-2,y-1));
        dangers.add(createIfValid(x-2,y+1));
        dangers.add(createIfValid(x-1,y+2));

        for(Square danger : dangers) {
            if (danger == null) continue;
            ChessPiece piece = chessboard.getPieceAt(danger);
            if (piece != null){
                if (piece.getColor() == color) continue;
                if (piece.getType() == PieceType.KNIGHT) return true;
            }
        }
        return false;
    }
    boolean inCheckQueen(Chessboard chessboard, Square target) {
        for (int i = 1; i <= 8; i++) {
            Square square = createIfValid(target.getX()+i, target.getY()+i);
            if (square == null) continue;

            ChessPiece piece = chessboard.getPieceAt(square);
            if (piece == null) continue;
            if (piece.getColor() == color){
                if (piece.getType() == PieceType.KING) continue;
                else break;
            }
            if (piece.getType() == PieceType.QUEEN) return true;
        }

        for (int i = 1; i <= 8; i++) {
            Square square = createIfValid(target.getX()-i, target.getY()+i);
            if (square == null) continue;

            ChessPiece piece = chessboard.getPieceAt(square);
            if (piece == null) continue;
            if (piece.getColor() == color){
                if (piece.getType() == PieceType.KING) continue;
                else break;
            }
            if (piece.getType() == PieceType.QUEEN) return true;
        }

        for (int i = 1; i <= 8; i++) {
            Square square = createIfValid(target.getX()+i, target.getY()-i);
            if (square == null) continue;

            ChessPiece piece = chessboard.getPieceAt(square);
            if (piece == null) continue;
            if (piece.getColor() == color){
                if (piece.getType() == PieceType.KING) continue;
                else break;
            }
            if (piece.getType() == PieceType.QUEEN) return true;
        }

        for (int i = 1; i <= 8; i++) {
            Square square = createIfValid(target.getX()-i, target.getY()-i);
            if (square == null) continue;

            ChessPiece piece = chessboard.getPieceAt(square);
            if (piece == null) continue;
            if (piece.getColor() == color){
                if (piece.getType() == PieceType.KING) continue;
                else break;
            }
            if (piece.getType() == PieceType.QUEEN) return true;
        }

        for (int i = 1; i <= 8; i++) {
            Square square = createIfValid(target.getX(), target.getY() + i);
            if (square == null) continue;

            ChessPiece piece = chessboard.getPieceAt(square);
            if (piece == null) continue;
            if (piece.getColor() == color){
                if (piece.getType() == PieceType.KING) continue;
                else break;
            }
            if (piece.getType() == PieceType.QUEEN) return true;
        }

        for (int i = 1; i <= 8; i++) {
            Square square = createIfValid(target.getX(), target.getY() - i);
            if (square == null) continue;

            ChessPiece piece = chessboard.getPieceAt(square);
            if (piece == null) continue;
            if (piece.getColor() == color){
                if (piece.getType() == PieceType.KING) continue;
                else break;
            }
            if (piece.getType() == PieceType.QUEEN) return true;
        }

        for (int i = 1; i <= 8; i++) {
            Square square = createIfValid(target.getX()+i, target.getY());
            if (square == null) continue;

            ChessPiece piece = chessboard.getPieceAt(square);
            if (piece == null) continue;
            if (piece.getColor() == color){
                if (piece.getType() == PieceType.KING) continue;
                else break;
            }
            if (piece.getType() == PieceType.QUEEN) return true;
        }

        for (int i = 1; i <= 8; i++) {
            Square square = createIfValid(target.getX()-i, target.getY());
            if (square == null) continue;

            ChessPiece piece = chessboard.getPieceAt(square);
            if (piece == null) continue;
            if (piece.getColor() == color){
                if (piece.getType() == PieceType.KING) continue;
                else break;
            }
            if (piece.getType() == PieceType.QUEEN) return true;
        }

        return false;
    }
    boolean inCheckKing(Chessboard chessboard, Square target) {
        for (int x = target.getX() - 1; x <= target.getX()+1; x++){
            for (int y = target.getY() - 1; y <= target.getY()+1; y++){
                Square square = createIfValid(x,y);
                if (square == null) continue;

                ChessPiece piece = chessboard.getPieceAt(square);
                if (piece == null) continue;
                if (piece.getType() == PieceType.KING && piece.getColor() != color)
                    return true;
            }
        }
        return false;
    }

    Square createIfValid(int x, int y) {
        if (x < 0 || x > 7) {
            return null;
        }
        if (y < 0 || y > 7) {
            return null;
        }
        return new Square(x,y);
    }
}
