package com.solarwindsmsp.chess;

public class ChessBoard {

	public static int MAX_BOARD_WIDTH = 8;
	public static int MAX_BOARD_HEIGHT = 8;

	private Pawn[][] pieces;

	public ChessBoard() {
		pieces = new Pawn[MAX_BOARD_WIDTH][MAX_BOARD_HEIGHT];
	}

	public void addPiece(Pawn pawn, int xCoordinate, int yCoordinate, PieceColor pieceColor) {

		// Validation to Check if Pawn colour is matching the passed colour
		if (pawn.getPieceColor().equals(pieceColor)) {
			if (pieceColor.equals(PieceColor.BLACK)) {
				if (xCoordinate >= MAX_BOARD_HEIGHT - 1 || yCoordinate > MAX_BOARD_WIDTH - 1
						|| pieces[xCoordinate][yCoordinate] != null) {
					setNegativeCoords(pawn);
				} else {
					setCoordinates(pawn, xCoordinate, yCoordinate);
				}
			} else if (pieceColor.equals(PieceColor.WHITE)) {
				if (xCoordinate < 1 || yCoordinate > MAX_BOARD_WIDTH - 1 || pieces[xCoordinate][yCoordinate] != null) {
					setNegativeCoords(pawn);
				} else {
					setCoordinates(pawn, xCoordinate, yCoordinate);
				}
			}
		} else {
			setNegativeCoords(pawn);
		}
	}

	private void setNegativeCoords(Pawn pawn) {
		pawn.setXCoordinate(-1);
		pawn.setYCoordinate(-1);
	}

	private void setCoordinates(Pawn pawn, int xCoordinate, int yCoordinate) {
		pawn.setXCoordinate(xCoordinate);
		pawn.setYCoordinate(yCoordinate);
		pieces[xCoordinate][yCoordinate] = pawn;
	}

	public boolean isLegalBoardPosition(int xCoordinate, int yCoordinate) {
		return (xCoordinate >= 0 && xCoordinate <= 7 && yCoordinate >= 0 && yCoordinate <= 7);
	}
}
