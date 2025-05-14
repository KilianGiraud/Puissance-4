public class P4Modele {
    private final int[][] plateau = new int[6][7];
    private int joueur = 1;

    public int getJoueur() {
        return joueur;
    }

    public void changerPlayer() {
        joueur = (joueur == 1) ? 2 : 1;
    }

    public boolean colonnePossible(int col) {
        return plateau[0][col] == 0;
    }

    public boolean jouer(int col) {
        for (int i = 5; i >= 0; i--) {
            if (plateau[i][col] == 0) {
                plateau[i][col] = joueur;
                return true;
            }
        }
        return false;
    }

    public int[][] getPlateau() {
        return plateau;
    }

    public boolean win() {
        return checkLines() || checkColumns() || checkDiagonals();
    }

    private boolean checkLines() {
        for (int row = 0; row < 6; row++)
            for (int col = 0; col < 4; col++)
                if (checkFour(plateau[row][col], plateau[row][col + 1], plateau[row][col + 2], plateau[row][col + 3]))
                    return true;
        return false;
    }

    private boolean checkColumns() {
        for (int row = 0; row < 3; row++)
            for (int col = 0; col < 7; col++)
                if (checkFour(plateau[row][col], plateau[row + 1][col], plateau[row + 2][col], plateau[row + 3][col]))
                    return true;
        return false;
    }

    private boolean checkDiagonals() {
        for (int row = 0; row < 3; row++)
            for (int col = 0; col < 4; col++)
                if (checkFour(plateau[row][col], plateau[row + 1][col + 1], plateau[row + 2][col + 2], plateau[row + 3][col + 3])
                    || checkFour(plateau[row + 3][col], plateau[row + 2][col + 1], plateau[row + 1][col + 2], plateau[row][col + 3]))
                    return true;
        return false;
    }

    private boolean checkFour(int a, int b, int c, int d) {
        return a != 0 && a == b && b == c && c == d;
    }

    public boolean isFull() {
        for (int[] row : plateau)
            for (int cell : row)
                if (cell == 0)
                    return false;
        return true;
    }
}