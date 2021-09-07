package main;

import model.EnemyField;
import view.View;

public class Main {
    public static void main(String[] args) {
        EnemyField enemyField = new EnemyField();
        View view = new View();
        view.drawField(enemyField.getField());
    }
}
