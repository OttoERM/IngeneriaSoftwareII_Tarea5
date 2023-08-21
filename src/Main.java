import javax.swing.*;
import java.util.Scanner;

public class Main {
    static Tablero tableroMain = new Tablero(3, 3);
    public static void main(String[] args) {
        tableroMain.crearTablero();

        while (true){
            System.out.println("Turno del jugador A");

            tableroMain.setMarkInGameBoard(consumirInput(), 1);
            tableroMain.crearTablero();

            if(tableroMain.isGameFinish())
                break;

            System.out.println("Turno del jugador B");
            tableroMain.setMarkInGameBoard(consumirInput(), 2);
            tableroMain.crearTablero();

            if (tableroMain.isGameFinish())
                break;
        }

        String mensajeFinal = "Gracias por jugar";
        System.out.println(mensajeFinal);
    }

    public static int[] consumirInput(){
        Scanner sc = new Scanner(System.in);
        boolean keepAskingPlayerInput = true;
        int fila = 0;
        int columna = 0;

        do {
            String playerInput = sc.nextLine();

            if(playerInput.length() == 3){
                fila = Character.getNumericValue(playerInput.charAt(0));
                columna = Character.getNumericValue(playerInput.charAt(2));

                if(tableroMain.filaInvalida(fila) || tableroMain.columnaInvalida(columna))
                    keepAskingPlayerInput = false;
            }

        } while(keepAskingPlayerInput);

        return new int[]{fila - 1, columna - 1};
    }
}