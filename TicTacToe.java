import java.util.*;
public class TicTacToe{
    public static void printBoard(char[][] b){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.print(b[i][j]+" | ");
            }
            System.out.println();
            System.out.println("____________");
        }
    }

    public static boolean checkWon(char[][] b,char p){
        for(int i=0;i<3;i++){
            if(b[i][0]==p&&b[i][1]==p&&b[i][2]==p) return true;
        }

        for(int i=0;i<3;i++){
            if(b[0][i]==p&&b[1][i]==p&&b[2][i]==p) return true;
        }

        if(b[0][0]==p&&b[1][1]==p&&b[2][2]==p) return true;

        if(b[0][2]==p&&b[1][1]==p&&b[2][0]==p) return true;


        return false;

    }

    public static void play(){
        Scanner sc=new Scanner(System.in);
        char[][] board=new char[3][3];

        //initalization of board
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                board[i][j]='-';
            }
        }

        boolean over=false;
        System.out.print("Enter a player:");
        char player=sc.next().charAt(0);
        boolean tie=true;
        int cnt=0;

        while(!over){
            if(cnt==9) break;
            printBoard(board);
            System.out.print("select cell:");
            int x=sc.nextInt();
            int y=sc.nextInt();

            if(board[x][y]!='-'){
                System.out.println("Invalid cell..! try again");
            }else{
                cnt++;
                board[x][y]=player;
                over=checkWon(board,player);
                if(over){
                    tie=false;
                    printBoard(board);
                    System.out.println("Congo...! ' "+player+" ' you are won");
                }else{
                    player=(player=='x')?'o':'x';
                }
            }

        }

        if(tie){
            System.out.println("Moves over GAME tie....!");
        }


    }



    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        do{
            System.out.print("you want to play ?");
            int x=sc.nextInt();
            if(x==0) {
                break;
            }
            play();
        }while(true);


    }
}

