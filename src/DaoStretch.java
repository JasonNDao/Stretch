//Jason Dao ACSL #3
import java.util.Scanner;
import java.io.*;

public class DaoStretch {
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(new File("C:\\Users\\Jason Dao\\Documents\\Eclipse Workspace\\Dao's Stretch\\Input"));
		for (int th = 0; th < 5; th++) {
			int count4 = 0;
			int count = 1;
			int start = 0;
			int count2 = 0;
			int row = s.nextInt();
			int column = s.nextInt();
			int board[][] = new int[row][column];
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < column; j++) {
					board[i][j] = count;
					count++;
				}
			}
			int number3 = s.nextInt();
			int blocked = s.nextInt();
			int blockedlist[] = new int[blocked];
			for (int i = 0; i < blocked; i++) {
				blockedlist[i] = s.nextInt();
			}
			for (int i = 0; i < blocked; i++) {
				outerloop: for (int j = 0; j < row; j++) {
					for (int q = 0; q < column; q++) {
						if (board[j][q] == blockedlist[i]) {
							board[j][q] = -5;
							break outerloop;
						}
					}
				}
			}
			if (number3 % column == 0) {
				while (true) {
					if (count2 == 0) {
						int r = pieceAbackward(number3, board, row, column);
						if (r > 0) {
							number3 = r;
							if (number3 % column == 1) {
								System.out.print("A");
								break;
							}
							number3--;
							System.out.print("A");
							start++;
						}
						count2++;
					}
					if (count2 == 1 && start != 0) {
						int r = pieceBbackward(number3, board, row, column);
						if (r > 0) {
							number3 = r;
							number3--;
							System.out.print("B");
						}
					}
					count2++;
					if (count2 == 2) {
						int r = pieceCbackward(number3, board, row, column);
						if (r > 0) {
							number3 = r;
							number3--;
							System.out.print("C");
							start++;
						}
						count2++;
					}
					if (count2 == 3 && start != 0) {
						int r = pieceDbackward(number3, board, row, column);
						if (r > 0) {
							number3 = r;
							if (number3 % column == 1) {
								System.out.print("D");
								break;
							}
							number3--;
							System.out.print("D");
						}
					}
					count2++;
					if (count2 == 4) {
						int r = pieceEbackward(number3, board, row, column);
						if (r > 0) {
							number3 = r;
							if (number3 % column == 1) {
								System.out.print("E");
								break;
							}
							number3--;
							System.out.print("E");
							start++;
						}
						count2++;
					}
					count2 = 0;
					count4++;
					if (count4 == 25) {
						break;
					}
				}
			} else {
				while (true) {
					if (count2 == 0) {
						int r = pieceAforward(number3, board, row, column);
						if (r > 0) {
							number3 = r;
							if (number3 % column == 0) {
								System.out.print("A");
								break;
							}
							number3++;
							System.out.print("A");
							start++;
						}
						count2++;
					}
					if (count2 == 1 && start != 0) {
						int r = pieceBforward(number3, board, row, column);
						if (r > 0) {
							number3 = r;
							number3++;
							System.out.print("B");
						}
					}
					count2++;
					if (count2 == 2 && start != 0) {
						int r = pieceCforward(number3, board, row, column);
						if (r > 0) {
							number3 = r;
							if (number3 % column == 0) {
								System.out.print("C");
								break;
							}
							number3++;
							System.out.print("C");
						}
					}
					count2++;
					if (count2 == 3) {
						int r = pieceDforward(number3, board, row, column);
						if (r > 0) {
							number3 = r;
							number3++;
							System.out.print("D");
							start++;
						}
						count2++;
					}
					if (count2 == 4) {
						int r = pieceEforward(number3, board, row, column);
						if (r > 0) {
							number3 = r;
							if (number3 % column == 0) {
								System.out.print("E");
								break;
							}
							number3++;
							System.out.print("E");
							start++;
						}
						count2++;
					}
					count2 = 0;
					count4++;
					if (count4 == 25) {
						break;
					}
				}
			}
			System.out.println();
		}
	}

	public static int pieceAforward(int a, int[][] b, int c, int d) {
		boolean s = false;
		int count1 = 0;
		int record = 0;
		int record2 = 0;
		for (int i = 0; i < c; i++) {
			for (int j = 0; j < d; j++) {
				if (b[i][j] == a) {
					record = i;
					count1++;
					record2 = j;
				}
			}
		}
		if (record2 != d - 1 && b[record][record2 + 1] == a + 1) {
			if (record != 0 && b[record - 1][record2 + 1] == -2) {
				return -100;
			}
			if (record != c - 1 && b[record + 1][record2 + 1] == -2) {
				return -100;
			}
			count1++;
		}
		if (record2 != d - 1 && record2 != d - 2 && b[record][record2 + 2] == a + 2) {
			count1++;
		}
		if (count1 == 3) {
			s = true;
		} else {
			return -100;
		}
		if (s == true) {
			b[record][record2 + 2] = -2;
			b[record][record2 + 1] = -2;
			b[record][record2] = -2;
		}
		return a + 2;
	}

	public static int pieceAbackward(int a, int[][] b, int c, int d) {
		boolean s = false;
		int count1 = 0;
		int record = 0;
		int record2 = 0;
		for (int i = 0; i < c; i++) {
			for (int j = 0; j < d; j++) {
				if (b[i][j] == a - 2) {
					record = i;
					record2 = j;
					count1++;
				}
			}
		}
		if (record2 != d - 1 && b[record][record2 + 1] == a - 1) {
			if (record != 0 && b[record - 1][record2 + 1] == -2) {
				return -100;
			}
			if (record != c - 1 && b[record + 1][record2 + 1] == -2) {
				return -100;
			}
			count1++;
		}
		if (record2 != d - 1 && record2 != d - 2 && b[record][record2 + 2] == a) {
			count1++;
		}
		if (count1 == 3) {
			s = true;
		} else {
			return -100;
		}
		if (s == true) {
			b[record][record2 + 2] = -2;
			b[record][record2 + 1] = -2;
			b[record][record2] = -2;
		}
		return a - 2;
	}

	public static int pieceBforward(int a, int[][] b, int c, int d) {
		boolean s = false;
		boolean r = true;
		int count1 = 0;
		int record = 0;
		int record2 = 0;
		for (int i = 0; i < c; i++) {
			for (int j = 0; j < d; j++) {
				if (b[i][j] == a) {
					record = i;
					record2 = j;
					count1++;
				}
			}
		}
		if (record != c - 1 && b[record + 1][record2] == a + d) {
			count1++;
		}
		if (record != c - 1 && record != c - 2 && b[record + 2][record2] == a + (2 * d)) {
			count1++;
			r = false;
		}
		if (count1 == 3) {
			s = true;
		}
		if (s == true && r == false) {
			b[record][record2] = -2;
			b[record + 1][record2] = -2;
			b[record + 2][record2] = -2;
			return a + (2 * d);
		}
		count1 = 0;
		for (int i = 0; i < c; i++) {
			for (int j = 0; j < d; j++) {
				if (b[i][j] == a - (2 * d)) {
					record = i;
					record2 = j;
					count1++;
				}
			}
		}
		if ((record != c - 1) && (b[record + 1][record2] == a - d)) {
			count1++;
		}
		if (record != c - 1 && record != c - 2 && b[record + 2][record2] == a) {
			count1++;
			r = false;
		}
		if (count1 == 3) {
			s = true;
		}
		if (s == true && r == false) {
			b[record][record2] = -2;
			b[record + 1][record2] = -2;
			b[record + 2][record2] = -2;
			return a - (2 * d);
		}
		return -100;
	}

	public static int pieceBbackward(int a, int[][] b, int c, int d) {
		boolean s = false;
		boolean r = true;
		int record = 0;
		int record2 = 0;
		int count1 = 0;
		for (int i = 0; i < c; i++) {
			for (int j = 0; j < d; j++) {
				if (b[i][j] == a - (2 * d)) {
					record = i;
					record2 = j;
					count1++;
				}
			}
		}
		if (record != c - 1 && b[record + 1][record2] == a - d) {
			count1++;
		}
		if (record != c - 1 && record != c - 2 && b[record + 2][record2] == a) {
			count1++;
			r = false;
		}
		if (count1 == 3) {
			s = true;
		}
		if (s == true && r == false) {
			b[record][record2] = -2;
			b[record + 1][record2] = -2;
			b[record + 2][record2] = -2;
			return a - (2 * d);
		}
		count1 = 0;
		for (int i = 0; i < c; i++) {
			for (int j = 0; j < d; j++) {
				if (b[i][j] == a) {
					record = i;
					record2 = j;
					count1++;
				}
			}
		}
		if (record != c - 1 && b[record + 1][record2] == a + d) {
			count1++;
		}
		if (record != c - 1 && record != c - 2 && b[record + 2][record2] == a + (2 * d)) {
			count1++;
			r = false;
		}
		if (count1 == 3) {
			s = true;
		}
		if (s == true && r == false) {
			b[record][record2] = -2;
			b[record + 1][record2] = -2;
			b[record + 2][record2] = -2;
			return a + (2 * d);
		}
		return -100;
	}

	public static int pieceCforward(int a, int[][] b, int c, int d) {
		boolean s = false;
		int count1 = 0;
		int record = 0;
		int record2 = 0;
		for (int i = 0; i < c; i++) {
			for (int j = 0; j < d; j++) {
				if (b[i][j] == a) {
					record = i;
					record2 = j;
					count1++;
				}
			}
		}
		if (record != c - 1 && b[record + 1][record2] == a + d) {
			if (record2 != 0 && b[record + 1][record2 - 1] == -2) {
				return -100;
			}
			if (record != c - 1 && record != c - 2 && b[record + 2][record2] == -2) {
				return -100;
			}
			count1++;
		}
		if (record != c - 1 && record2 != d - 1 && b[record + 1][record2 + 1] == a + d + 1) {
			count1++;
		}
		if (count1 == 3) {
			s = true;
		} else {
			return -100;
		}
		if (s == true) {
			b[record][record2] = -2;
			b[record + 1][record2] = -2;
			b[record + 1][record2 + 1] = -2;
		}
		return a + d + 1;
	}

	public static int pieceCbackward(int a, int[][] b, int c, int d) {
		boolean s = false;
		int count1 = 0;
		int record = 0;
		int record2 = 0;
		for (int i = 0; i < c; i++) {
			for (int j = 0; j < d; j++) {
				if (b[i][j] == a - d - 1) {
					record = i;
					record2 = j;
					count1++;
				}
			}
		}
		if (record != c - 1 && b[record + 1][record2] == a - 1) {
			if (record2 != 0 && b[record + 1][record2 - 1] == -2) {
				return -100;
			}
			if (record != c - 1 && record != c - 2 && b[record + 2][record2] == -2) {
				return -100;
			}
			count1++;
		}
		if (record != c - 1 && record2 != d - 1 && b[record + 1][record2 + 1] == a) {
			count1++;
		}
		if (count1 == 3) {
			s = true;
		} else {
			return -100;
		}
		if (s == true) {
			b[record][record2] = -2;
			b[record + 1][record2] = -2;
			b[record + 1][record2 + 1] = -2;
		}
		return a - d - 1;
	}

	public static int pieceDforward(int a, int[][] b, int c, int d) {
		boolean s = false;
		int count1 = 0;
		int record = 0;
		int record2 = 0;
		for (int i = 0; i < c; i++) {
			for (int j = 0; j < d; j++) {
				if (b[i][j] == a) {
					record = i;
					record2 = j;
					count1++;
				}
			}
		}
		if (record2 != d - 1 && b[record][record2 + 1] == a + 1) {
			if (record2 != d - 2 && b[record][record2 + 2] == -2) {
				return -100;
			}
			if (record != 0 && b[record - 1][record2 + 1] == -2) {
				return -100;
			}
			count1++;
		}
		if (record != c - 1 && record2 != d - 1 && b[record + 1][record2 + 1] == a + d + 1) {
			if (record2 != d - 2 && b[record + 1][record2 + 2] == -2) {
				return -100;
			}
			if (b[record + 1][record2] == -2) {
				return -100;
			}
			count1++;
		}
		if (record != c - 1 && record != c - 2 && record2 != d - 1 && b[record + 2][record2 + 1] == a + (2 * d) + 1) {
			count1++;
		}
		if (count1 == 4) {
			s = true;
		} else {
			return -100;
		}
		if (s == true) {
			b[record][record2] = -2;
			b[record][record2 + 1] = -2;
			b[record + 1][record2 + 1] = -2;
			b[record + 2][record2 + 1] = -2;
		}
		return a + (2 * d) + 1;
	}

	public static int pieceDbackward(int a, int[][] b, int c, int d) {
		boolean s = false;
		int count1 = 0;
		int record = 0;
		int record2 = 0;
		for (int i = 0; i < c; i++) {
			for (int j = 0; j < d; j++) {
				if (b[i][j] == a) {
					record = i;
					record2 = j;
					count1++;
				}
			}
		}
		if (record != 0 && b[record - 1][record2] == a - d) {
			if (record2 != d - 1 && b[record - 1][record2 + 1] == -2) {
				return -100;
			}
			if (record2 != 0 && b[record - 1][record2 - 1] == -2) {
				return -100;
			}
			count1++;
		}
		if (record != 0 && record != 1 && b[record - 2][record2] == a - (2 * d)) {
			if (record2 != d - 1 && b[record - 2][record2 + 1] == -2) {
				return -100;
			}
			if (record != 2 && b[record - 3][record2] == -2) {
				return -100;
			}
			count1++;
		}
		if ((record != 0 && record != 1 && record2 != 0 && b[record - 2][record2 - 1] == a - (2 * d) - 1)) {
			count1++;
		}
		if (count1 == 4) {
			s = true;
		} else {
			return -100;
		}
		if (s == true) {
			b[record][record2] = -2;
			b[record - 1][record2] = -2;
			b[record - 2][record2] = -2;
			b[record - 2][record2 - 1] = -2;
		}
		return a - (2 * d) - 1;
	}

	public static int pieceEforward(int a, int[][] b, int c, int d) {
		boolean s = false;
		int count1 = 0;
		int record = 0;
		int record2 = 0;
		for (int i = 0; i < c; i++) {
			for (int j = 0; j < d; j++) {
				if (b[i][j] == a) {
					record = i;
					record2 = j;
					count1++;
				}
			}
		}
		if (record2 != d - 1 && b[record][record2 + 1] == a + 1) {
			if (record != 0 && b[record - 1][record2 + 1] == -2) {
				return -100;
			}
			if (record2 != d - 1 && record2 != d - 2 && b[record][record2 + 2] == -2) {
				return -100;
			}
			count1++;
		}
		if (record != c - 1 && record2 != d - 1 && b[record + 1][record2 + 1] == a + (d) + 1) {
			if (b[record + 1][record2] == -2) {
				return -100;
			}
			if (record != c - 1 && record != c - 2 && b[record + 2][record2 + 1] == -2) {
				return -100;
			}
			count1++;
		}
		if (record != c - 1 && record2 != d - 1 && record2 != d - 2 && b[record + 1][record2 + 2] == a + (d) + 2) {
			count1++;
		}
		if (count1 == 4) {
			s = true;
		} else {
			return -100;
		}
		if (s == true) {
			b[record][record2] = -2;
			b[record][record2 + 1] = -2;
			b[record + 1][record2 + 1] = -2;
			b[record + 1][record2 + 2] = -2;
		}
		return a + d + 2;
	}

	public static int pieceEbackward(int a, int[][] b, int c, int d) {
		boolean s = false;
		int count1 = 0;
		int record = 0;
		int record2 = 0;
		for (int i = 0; i < c; i++) {
			for (int j = 0; j < d; j++) {
				if (b[i][j] == a) {
					record = i;
					record2 = j;
					count1++;
				}
			}
		}
		if (record2 != 0 && b[record][record2 - 1] == a - 1) {
			if (record2 != 0 && record2 != -1 && b[record][record2 - 2] == -2) {
				return -100;
			}
			if (record != c - 1 && b[record + 1][record2 - 1] == -2) {
				return -100;
			}
			count1++;
		}
		if (record != 0 && record2 != 0 && b[record - 1][record2 - 1] == a - (d) - 1) {
			if (record != 1 && b[record - 2][record2 - 1] == -2) {
				return -100;
			}
			if (record != 0 && b[record - 1][record2] == -2) {
				return -100;
			}
			count1++;
		}
		if (record != 0 && record2 != 0 && record2 != 1 && b[record - 1][record2 - 2] == a - (d) - 2) {
			count1++;
		}
		if (count1 == 4) {
			s = true;
		} else {
			return -100;
		}
		if (s == true) {
			b[record][record2] = -2;
			b[record][record2 + 1] = -2;
			b[record + 1][record2 + 1] = -2;
			b[record + 1][record2 + 2] = -2;
		}
		return a - d - 2;
	}

}
