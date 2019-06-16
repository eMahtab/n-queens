package net.mahtabalam.exercise1;

public class NQueensProblem {

	private int[][] chessBoard;
	private int numOfQueens;

	public NQueensProblem(int numOfQueens) {
		this.chessBoard = new int[numOfQueens][numOfQueens];
		this.numOfQueens = numOfQueens;
	}

	public void solve() {
		if (placeQueen(0)) {
			printChessboard();
		} else {
			System.out.println("There is no solution...");
		}
	}

	private boolean placeQueen(int colIndex) {

		if (colIndex == numOfQueens) {
			return true;
		}

		for (int rowIndex = 0; rowIndex < numOfQueens; rowIndex++) {

			if (isPlaceValid(rowIndex, colIndex)) {

				chessBoard[rowIndex][colIndex] = 1;
				System.out.println("Placed at [" + rowIndex + " , " + colIndex + "]");

				if (placeQueen(colIndex + 1)) {
					return true;
				}

				// BACKTRACKING !!!
				System.out.println("__________Backtracking From_________[" + rowIndex + " , " + colIndex + "]");
				chessBoard[rowIndex][colIndex] = 0;
			}
		}

		return false;
	}

	private boolean isPlaceValid(int rowIndex, int colIndex) {

		for (int i = 0; i < colIndex; i++)
			if (chessBoard[rowIndex][i] == 1)
				return false;

		for (int i = rowIndex, j = colIndex; i >= 0 && j >= 0; i--, j--) {
			if (chessBoard[i][j] == 1)
				return false;
		}

		for (int i = rowIndex, j = colIndex; i < chessBoard.length && j >= 0; i++, j--) {
			if (chessBoard[i][j] == 1)
				return false;
		}

		return true;
	}

	private void printChessboard() {

		for (int i = 0; i < chessBoard.length; i++) {
			for (int j = 0; j < chessBoard.length; j++) {
				if (chessBoard[i][j] == 1) {
					System.out.print(" * ");
				} else {
					System.out.print(" - ");
				}
			}

			System.out.println();
		}
	}

	public static void main(String[] args) {
		NQueensProblem problem = new NQueensProblem(4);
		problem.solve();

	}
}
