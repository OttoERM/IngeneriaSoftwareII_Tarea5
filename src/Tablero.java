public class Tablero {
    private int[][] tablero;

    public Tablero(int ancho, int largo){
        if(ancho < 3 || largo < 3){
            System.out.println("Valores invalidos, seteando 3X3");
            ancho = 3;
            largo = 3;
        }
        tablero = new int[ancho][largo];
    }

    public void crearTablero(){
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

    private int obtenerAncho(){
        return tablero.length;
    }

    private int obtenerLargo(){
        return tablero[0].length;
    }

    public boolean filaInvalida(int fila){
        return fila >= 0 && fila < obtenerAncho();
    }

    public boolean columnaInvalida(int columna){
        return columna >= 0 && columna < obtenerLargo();
    }

    public void setMarkInGameBoard(int[] coordinates, int value){
        if (coordinates.length != 2)
            return;

        tablero[coordinates[0]][coordinates[1]] = value;
    }

    public boolean isGameFinish(){
        for (int i = 0; i < tablero.length; i++){
            for (int j = 0; j < tablero[i].length - 2; j++) {
                if(tablero[i][j] == tablero[i][j + 1] && tablero[i][j] == tablero[i][j + 2] && tablero[i][j] != 0)
                    return true;
            }
        }

        return false;
    }
}
