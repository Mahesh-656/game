import java.util.Scanner;

public class Tic_Tok_Toe {
    public static void main(String[] args) {
        char[][] board=new char[3][3];
        for(int row=0;row<board.length;row++){
            for(int col=0;col<board[row].length;col++){
                board[row][col]=' ';
            }

        }
        char player='x';
        boolean gameOver=false;
        Scanner s=new Scanner(System.in);
        while(!gameOver){
            printBoard(board);
            System.out.println("player"+player+"enter:");
            int row=s.nextInt();
            int col=s.nextInt();
            if(board[row][col]==' '){
                board[row][col]=player;//place the element
                gameOver=haveWon(board,player);
                if(gameOver){
                    System.out.println("player " +player+" has won");
                }else{
                    if(player=='x'){
                        player='o';
                    }else{
                        player='x';
                    }
                }
            }else{
                System.out.println("Invalid move. Try again!");
            }
        }
        printBoard(board);
    }
    public static boolean haveWon(char[][] board,char player){
        //check rows
        for(int row=0;row<board.length;row++){
           if(board[row][0]==player&&board[row][1]==player&&board[row][2]==player){
               return true;
           }
        }
        for(int col=0;col<board[0].length;col++){
            if(board[0][col]==player&&board[1][col]==player&&board[2][col]==player){
                return true;
            }
        }
        //checks diagnol
        if(board[0][0]==player&&board[1][1]==player&&board[2][2]==player){
            return true;
        }
        if(board[0][2]==player&&board[1][1]==player&&board[2][0]==player){
            return true;
        }
        return false;
    }
    public static void printBoard(char[][] board){
        for(int row=0;row<board.length;row++){
            for(int col=0;col<board[row].length;col++){
                System.out.print(board[row][col]+"__|");
            }
            System.out.println();
        }
    }
}
