import java.util.Scanner;

public class Main {
    public static int[][] tablero = new int[3][3];
    public static void main(String[] args) {
        iniciarJuego();
    }

    public static void iniciarJuego(){
        boolean terminarJuego = false;
        String mensajeFinal = "Gracias por jugar";
        Scanner sc = new Scanner(System.in);

        crearTablero();

        while (!terminarJuego){
            System.out.println("Turno del jugador A");
            consumirInput(sc.nextLine(), 1, 1);

            crearTablero();

            if(validarGanador())
                break;

            System.out.println("Turno del jugador B");
            consumirInput(sc.nextLine(), 2, 2);

            crearTablero();

            if (validarGanador())
                break;
        }
        System.out.println(mensajeFinal);
    }

    public static void crearTablero(){
        System.out.println("    1   2   3");
        for (int i = 0; i < tablero.length; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < tablero[i].length; j++){
                if(tablero[i][j] == 0)
                    System.out.print("|   ");
                else if(tablero[i][j] == 1)
                    System.out.print("| X ");
                else
                    System.out.print("| 0 ");
            }
            System.out.println("|");
        }
    }

    public static void consumirInput(String playerPosicionInput, int turnoJugador, int valor){
        try {
            if(turnoJugador == 1){
                tablero[Character.getNumericValue(playerPosicionInput.charAt(0)) - 1]
                    [Character.getNumericValue(playerPosicionInput.charAt(2)) - 1] = valor;
            } else {
                tablero[Character.getNumericValue(playerPosicionInput.charAt(0)) - 1]
                        [Character.getNumericValue(playerPosicionInput.charAt(2)) - 1] = valor;
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static boolean validarGanador(){
        if(tablero[0][0] == 1){
            if(tablero[0][1] == 1){
                if(tablero[0][2] == 1){
                    System.out.println("Jugador uno gano");
                    return true;
                }
            }
        }

        if(tablero[0][0] == 2){
            if(tablero[0][1] == 2){
                if(tablero[0][2] == 2){
                    System.out.println("Jugador dos gano");
                    return true;
                }
            }
        }

        return false;
    }
}