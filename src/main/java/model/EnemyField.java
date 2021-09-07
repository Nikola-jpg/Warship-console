package model;

public class EnemyField {
    private char[][] field;
    private char ship;//This symbol = ship in field

    public EnemyField(){
        this.field = createField();
        baseCreateShip();
    }
    //this method create start field with border symbols(0-9, A-J) and add '.' in empty section
    public char[][] createField() {
        char[][] field = new char[11][11];
        char symbol = 'A';
        int num = '0';
        for (int i = 1; i < 11; i++) {
            field[0][i] = symbol;
            symbol++;
            field[i][0] = (char) num;
            num++;
        }

        for (int i = 1; i < field.length; i++) {
            for (int j = 1; j < field.length; j++) {
                field[i][j] = '.';
            }
        }
        return field;
    }
    //You must refactor this method
    public void baseCreateShip(){
        createShip(4);

        createShip(3);
        createShip(3);

        createShip(2);
        createShip(2);
        createShip(2);

        createShip(1);
        createShip(1);
        createShip(1);
        createShip(1);
    }

    //this method create ships
    private void createShip(int shipSize) {
        while(true) {
            int direction = (int) (Math.random() * 2);//0 - horizontal, 1 - vertical

            int x = (int) (Math.random() * 10 + 1);
            int y = (int) (Math.random() * 10 + 1);

            if (field[x][y] != '.') {
                continue;
            }
            field[x][y] = 'H';//H - it is the ship

            for (int i = 1; i < shipSize; i++) {
                if (direction == 0) {
                    if (x + shipSize <= field.length && field[x + i][y] == '.') {
                        field[x + i][y] = 'H';
                    } else if (field[x - i][y] == '.') {
                        field[x - i][y] = 'H';
                    } else {
                        break;
                    }
                } else {
                    if (y + shipSize <= field[0].length && field[x][y + i] == '.') {
                        field[x][y + i] = 'H';
                    } else if (field[x][y - i] == '.') {
                        field[x][y - i] = 'H';
                    } else {
                        break;
                    }
                }
            }
            break;
        }
            analiseEmptySection();
    }

    //Find empty section = x
    public void analiseEmptySection(){
        for (int i = 1; i < field.length; i++) {
            for (int j = 1; j < field.length; j++) {
                if(field[i][j] == 'H'){

                    //find out vertical and horizontal sections
                    if(i + 1 < field.length && field[i + 1][j] == '.'){
                        field[i + 1][j] = 'x';
                    }
                    if(j + 1 < field.length && field[i][j + 1] == '.'){
                        field[i][j + 1] = 'x';
                    }
                    if(i - 1 > 0 && field[i - 1][j] == '.'){
                        field[i - 1][j] = 'x';
                    }
                    if(j - 1 > 0 && field[i][j - 1] == '.'){
                        field[i][j - 1] = 'x';
                    }

                    //find out diagonal sections
                    if(i - 1 > 0 && j - 1 > 0 && field[i - 1][j - 1] == '.'){
                        field[i - 1][j - 1] = 'x';
                    }
                    if(i + 1 < field.length && j - 1 > 0 && field[i + 1][j - 1] == '.'){
                        field[i + 1][j - 1] = 'x';
                    }
                    if(i - 1 > 0 && j + 1 < field.length && field[i - 1][j + 1] == '.'){
                        field[i - 1][j + 1] = 'x';
                    }
                    if(i + 1 < field.length && j + 1 < field.length && field[i + 1][j + 1] == '.'){
                        field[i + 1][j + 1] = 'x';
                    }
                }
            }
        }
    }

    public char[][] getField() {
        return field;
    }
}
