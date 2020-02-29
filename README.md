# N Queens Problem
## https://leetcode.com/problems/n-queens

The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

```
Example:

Input: 4
Output: [
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]

Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above.
```

![N Queens Solution](n-queens.PNG?raw=true "8 Queens on 8*8 Chessboard")


# Implementation :

```java
class Solution {
    public List<List<String>> solveNQueens(int n) {
         int[][] chessboard = new int[n][n];
         List<List<String>> result = new ArrayList<>();
         placeQueen(chessboard, 0, result);
         return result;
    }
    
    private void placeQueen(int[][] chessboard, int colIndex, List<List<String>> result) {
	 if (colIndex == chessboard.length) {
		addResult(chessboard, result);
	 } else {
              for (int rowIndex = 0; rowIndex < chessboard.length; rowIndex++) {
                if (isPlaceValid(chessboard, rowIndex, colIndex)) {
                    chessboard[rowIndex][colIndex] = 1;
                    placeQueen(chessboard, colIndex + 1, result);
                    chessboard[rowIndex][colIndex] = 0;
                 }    
	      }
         }
    }
    
    private boolean isPlaceValid(int[][] chessboard, int rowIndex, int colIndex) {
	 for (int i = 0; i < colIndex; i++) {
		if (chessboard[rowIndex][i] == 1)
			return false;
	 }			
	 for (int i = rowIndex, j = colIndex; i >= 0 && j >= 0; i--, j--) {
		if (chessboard[i][j] == 1)
			return false;
	 }
	 for (int i = rowIndex, j = colIndex; i < chessboard.length && j >= 0; i++, j--) {
		if (chessboard[i][j] == 1)
			return false;
	 }
	return true;
    }
    
    private void addResult(int[][] chessboard, List<List<String>> result) {
        List<String> list = new ArrayList<>();
	for (int i = 0; i < chessboard.length; i++) {
            String str = "";
	    for (int j = 0; j < chessboard.length; j++) {
		str += (chessboard[i][j] == 1) ? "Q" : ".";
	    }
            list.add(str);
	}
       result.add(list);	
    }
}
```

# References :
https://www.youtube.com/watch?v=FreUvSdLa_4
