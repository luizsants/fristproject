import java.util.Scanner;
import java.io.*;

public class JogoDaVelha {

    public static void main(String[] args) {
        char sa = 'X';
        Campo[][] velha = new Campo[2][2];
        Scanner scan = new Scanner(System.in);
        char vitoria = ' ';
        boolean game = true;

        iniciaJogo(velha);
       
        while (game) {
            desenhaJogo(velha);  
            vitoria = verificaVitoria(velha);

            if (vitoria == 'X') {
                System.out.printf("Jogador %c venceu\n", vitoria);
                break;
            }

            if (vitoria == 'O') {
                System.out.printf("Jogador %c venceu\n", vitoria);
            }

            try {
                // linha
                int p = jogar1(scan, sa);
                // coluna
                int j = jogar2(scan, sa);

                if (verificarJogada(velha, p, j, sa)) {
                    if (sa == 'X') {
                        sa = 'O';
                    } else {
                        sa = 'X';
                    }
                }
                limparTela();

            } catch (Exception e) {
                System.out.printf("Erro");
                break;
            }

        }

    }

    // public int getTamanhoLinhas() {
    // return (Campo.length);
        // }public class Campo {
   

    public static void desenhaJogo(Campo[][] velha) {
        System.out.print("     0   1   2");
        System.out.printf( "0 %c | %c | %c \n" + velha[0][0].getSimbolo() + velha[0][1].getSimbolo() + velha[0][2].getSimbolo());
        System.out.print(" ---------------");
        System.out.printf("1 %c | %c | %c \n" + velha[1][0].getSimbolo() + velha[1][1].getSimbolo() + velha[1][2].getSimbolo());
        System.out.print(" ---------------");
        System.out.printf("2 %c | %c | %c \n" + velha[2][0].getSimbolo() + velha[2][1].getSimbolo() + velha[2][2].getSimbolo());
        
    }


    public static void limparTela() {
        for (int cont = 0; cont < 100; cont++) {
            System.out.println(" ");
        }
    }

    // Linha é p[0]
    // Coluna é p[1]
    public static int jogar1(Scanner scan, char sa) {
        int p;
        System.out.printf("Quem joga: %c\n", sa);
        System.out.print("Informa a linha: ");
        p = scan.nextInt();
        return p;
    }

    public static int jogar2(Scanner scan, char sa) {
        int p;
        System.out.printf("Quem joga: %c\n", sa);
        System.out.print("Informe a coluna: ");
        p = scan.nextInt();
        return p;
    }
    // Como var p e j são primitivas, 
    public static Boolean verificarJogada(Campo[][] velha, int p, int j, char sa) {
        if (velha[p][j].getSimbolo() == ' ') {
            velha[p][j].setSimbolo(sa);
            return true;
        } else {
            return false;
        }
    }

    public static void iniciaJogo(Campo[][] velha) {
        for (int l = 0; l < 2; l++) {
            for (int c = 0; c < 2; c++) {
                velha[l][c] = new Campo();                
            }
        }

    }

    // desafio fazer o verifica vitoria

    public static char verificaVitoria(Campo[][] velha) {

        for (int i = 0; i < 2; i++) {
            if (velha[i][0].getSimbolo() == 'X') {
                if (velha[i][1].getSimbolo() == 'X') {
                    if (velha[i][2].getSimbolo() == 'X') {
                        return 'X';
                    }
                }
            }
        }
        // verificar colunas verticais - player X.
        for (int i = 0; i < 2; i++) {
            if (velha[0][i].getSimbolo() == 'X') {
                if (velha[0][i].getSimbolo() == 'X') {
                    if (velha[0][i].getSimbolo() == 'X') {
                        return 'X';
                    }
                }
            }
        }
        // verifica diagonal
        if (velha[0][0].getSimbolo() == 'X') {
            if (velha[1][1].getSimbolo() == 'X') {
                if (velha[2][2].getSimbolo() == 'X') {
                    return 'X';
                }
            }
        }
        if (velha[0][2].getSimbolo() == 'X') {
            if (velha[1][1].getSimbolo() == 'X') {
                if (velha[2][0].getSimbolo() == 'X') {
                    return 'X';
                }
            }
        }
        // -----------------------------------------------------------------------------------
        // -----------------------------------------------------------------------------------
        // -----------------------------------------------------------------------------------
        // -----------------------------------------------------------------------------------
        // verificar linhas horizontal - player O.
        for (int i = 0; i < 2; i++) {
            if (velha[i][0].getSimbolo() == 'O') {
                if (velha[i][1].getSimbolo() == 'O') {
                    if (velha[i][2].getSimbolo() == 'O') {
                        return 'O';
                    }
                }
            }
        }
        // verificar colunas verticais - player O.
        for (int i = 0; i < 2; i++) {
            if (velha[0][i].getSimbolo() == 'O') {
                if (velha[0][i].getSimbolo() == 'O') {
                    if (velha[0][i].getSimbolo() == 'O') {
                        return 'O';
                    }
                }
            }
        }
        // verifica diagonal
        if (velha[0][0].getSimbolo() == 'O') {
            if (velha[1][1].getSimbolo() == 'O') {
                if (velha[2][2].getSimbolo() == 'O') {
                    return 'O';
                }
            }
        }
        if (velha[0][2].getSimbolo() == 'O') {
            if (velha[1][1].getSimbolo() == 'O') {
                if (velha[2][0].getSimbolo() == 'O') {
                    return 'O';
                }
            }
        }
        return ' ';
    }

}
