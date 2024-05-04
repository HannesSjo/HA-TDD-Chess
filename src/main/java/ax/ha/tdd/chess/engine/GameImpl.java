package ax.ha.tdd.chess.engine;

import ax.ha.tdd.chess.engine.pieces.ChessPiece;
import ax.ha.tdd.chess.engine.pieces.PieceType;

public class GameImpl implements Game{

    final ChessboardImpl board = ChessboardImpl.startingBoard();
    String moveResult = "Last move was successful (default reply, change this)";
    boolean isNewGame = true;
    Color playerToMove = Color.WHITE;
    @Override
    public Color getPlayerToMove() {
        return playerToMove;
    }

    @Override
    public Chessboard getBoard() {
        return board;
    }

    @Override
    public String getLastMoveResult() {
        //TODO this should be used to show the player what happened
        //Illegal move, correct move, e2 moved to e4 etc. up to you!
        if (isNewGame) {
            return "Game hasn't begun";
        }
        return moveResult;
    }

    @Override
    public void move(String move) {
        String[] moveSplit = move.split("-");
        try {
            if (moveSplit.length != 2) throw new IllegalArgumentException("Invalid input");
            String source = moveSplit[0];
            String destination = moveSplit[1];

            System.out.println("Player tried to perform move: " + move);
            if (!isValidMove(source, destination)) throw new IllegalArgumentException("Illegal move");
            updateBoard(getSquare(source), getSquare(destination));

            afterValidMove();
        } catch (Exception e){
            moveResult = e.getMessage();
            return;
        }


        System.out.println("Move was confirmed!");
        moveResult = "Last move was successful (default reply, change this)";
    }

    private boolean isValidMove(String source, String destination) {
        Square sourceSquare = getSquare(source);
        Square destinationSquare = getSquare(destination);

        ChessPiece piece = board.getPieceAt(sourceSquare);

        if (playerToMove != piece.getColor()) throw new IllegalArgumentException("Piece is wrong color!");
        ChessPiece targetPiece = board.getPieceAt(destinationSquare);
        if (targetPiece != null) {
            if (targetPiece.getColor() == piece.getColor()) return false;
            if (targetPiece.getType() == PieceType.KING) return false;
        }
        return piece.canMove(board, destinationSquare);
    }

    private void updateBoard(Square source, Square destination) {
        board.movePiece(source, destination);
    }
    private void afterValidMove() {


        if (playerToMove == Color.WHITE) playerToMove = Color.BLACK;
        else playerToMove = Color.WHITE;
        isNewGame = false;
    }

    private Square getSquare(String location) {
        char[] pos = location.toCharArray();
        int x = convertColumnToNumber(pos[0]);
        int y = pos[1] - '0';
        y = 9-y;

        return new Square(x -1, y-1);
    }

    public static int convertColumnToNumber(char column) {
        return column - 'a' + 1;
    }
}
