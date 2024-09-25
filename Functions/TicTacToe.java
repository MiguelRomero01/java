package Functions;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
        static Scanner playerInputs = new Scanner(System.in);

        // Tablero global
        static String[][] board = {
            {" ", " ", " "},
            {" ", " ", " "},
            {" ", " ", " "}
        };
    
        //turnos
        static int turnsplayed = 0;
        static int maxturns = 9;
    
        public static void main(String[] args) {
            printBoard();
            game();
            playerInputs.close(); //cerrar scanner al finalizar
        }
    
        public static void game() {
            // Inicializar simbolos
            String machine_Symbol = "O";
            String player_Symbol = "X";
    
            System.out.println("Simbolo del jugador: " + player_Symbol);
            System.out.println("Simbolo de la maquina: " + machine_Symbol);
    
            //evaluar quien puede jugar segun la cantidad de turnos restantes
            while(turnsplayed < maxturns){
                System.out.println("Turnos jugados: " + turnsplayed +"\n");
    
                player(player_Symbol);
                if(turnsplayed == maxturns){
                    System.out.println("Empate");
                    System.exit(0);
                }else{
                    machine(machine_Symbol);
                }
            }
        }
    
        // Imprimir tablero
        public static void printBoard() {
            for (String[] fila : board) {
                for (String elemento : fila) {
                    System.out.print("| " + elemento + " ");
                }
                System.out.println();
            }
        }
    
        // Turno del jugador
        public static void player(String player_Symbol) {
            while (true) {
                System.out.println("\nTu turno");
                // Pedir datos
                System.out.println("Inserte una fila: ");
                int row = playerInputs.nextInt();
                System.out.println("Inserte una columna: ");
                int column = playerInputs.nextInt();
    
                //verifica si los datos proporcionados son correctos
                try {
                    if (board[row - 1][column - 1].equals(" ")){
                        board[row - 1][column - 1] = player_Symbol;
                        printBoard();
                        turnsplayed++;
                        break;
                    } else {
                        System.out.println("Casilla ocupada, intente de nuevo.\n");
                    }
                } catch (Exception e) {
                    System.out.println("error: " + e);
                }
            }
            checkWin(player_Symbol);
        }
    
        // Turno de la maquina
        public static void machine(String machine_Symbol) {
            System.out.println("\nTurno de la maquina");
            Random random = new Random();
    
            while (true) {
                int row = random.nextInt(3);
                int column = random.nextInt(3);
    
                if (board[row][column].equals(" ")){
                    board[row][column] = machine_Symbol;
                    printBoard();
                    turnsplayed++;
                    break;
                }
            }
            checkWin(machine_Symbol);
        }
    
        //evaluar victoria
        public static void checkWin(String Symbol){
            if (board[0][0].equals(Symbol) && board[0][1].equals(Symbol) && board[0][2].equals(Symbol)|| //arriba
                board[2][0].equals(Symbol) && board[2][1].equals(Symbol) && board[2][2].equals(Symbol)|| //abajo
                board[0][0].equals(Symbol) && board[1][1].equals(Symbol) && board[2][2].equals(Symbol)|| //diagonal 1
                board[2][0].equals(Symbol) && board[1][1].equals(Symbol) && board[0][2].equals(Symbol)|| //diagonal 2
                board[0][0].equals(Symbol) && board[1][0].equals(Symbol) && board[2][0].equals(Symbol)|| //izquierda
                board[0][2].equals(Symbol) && board[1][2].equals(Symbol) && board[2][2].equals(Symbol)|| //derecha
                board[0][1].equals(Symbol) && board[1][1].equals(Symbol) && board[2][1].equals(Symbol)|| //centro vertical
                board[1][0].equals(Symbol) && board[1][1].equals(Symbol) && board[1][2].equals(Symbol)   //centro horizontal
                ){
                    System.out.println("\nEl simbolo " + Symbol + " Es el ganador!");
                    System.exit(0);
                }
        }
            
    }
    
