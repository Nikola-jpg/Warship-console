package view;

public class View {

    public void drawField(char[][] field){
        System.out.print(" ");//start margin
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if(field[i][j] == 'x'){
                    field[i][j] = '.'; //replace 'x' -> '.'
              }
                System.out.print(" " + field[i][j] + ' ');
            }
            System.out.println();
        }
    }
}
