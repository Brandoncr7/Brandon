

import java.util.Scanner;

public class ConnectFour {

    public static void printBoard(char[][] array) {

        for(int i=array.length-1;i>=0;i--){

            for(int j=0;j<array[0].length;j++){

                System.out.print(array[i][j]+" ");

            }

            System.out.println();

        }

    }
    // this method will print the board.

    public static void initializeBoard(char[][] array) {

        for(int i=0;i<array.length;i++){

            for(int j=0;j<array[0].length;j++){

                array[i][j] = '-';

            }

        }

    }
    // this will set each spot in the array to “-”.

    public static int insertChip(char[][] array,int col,char chipType) {

        for(int i=0;i<array.length;i++){

            if(array[i][col]=='-'){

                array[i][col] = chipType;

                return i;

            }

        }

        return -1;

    }
    // this places the token in the column that the user has chosen.
    // Then it will find the next available spot in that column if there are already tokens there.
    // The row that the token is placed in is returned.

    public static boolean checkIfWinner(char[][] array,int col,int row,char chipType) {

        int count=0;

        for(int i=0;i<array.length;i++){

            if(array[i][col]==chipType){

                count++;

                if(count==4){

                    return true;

                }

            }else{

                count = 0;

            }

        }

        count=0;

        for(int i=0;i<array[0].length;i++){

            if(array[row][i]==chipType){

                count++;

                if(count==4){

                    return true;

                }

            }else{

                count = 0;

            }

        }

        return false;

    }

    // after a token is added, it checks whether the token in this location, of the specified chip type, creates four in a row.
    // Thne it will return true if someone won, and false otherwise.
    public static void main(String[] args) {

        Scanner sc =new Scanner(System.in);

        int row,col;

        while(true){

            System.out.print("What would you like the height of the board to be ? ");

            row = sc.nextInt();

            if(row>=4){

                break;

            }else{

                System.out.println("Height should be at least 4. Please try again!");

            }

        }


        while(true){

            System.out.print("What would you like the length of the board to be ? ");

            col = sc.nextInt();

            if(col>=4){

                break;

            }else{

                System.out.println("Length should be at least 4. Please try again!");

            }

        }
        // this part of the code out asks the user what he or she wants the height and length of the board wants to be
        // and stores the imformation. It also makes sure it isnt more than 4.

        char board[][] = new char[row][col];

        initializeBoard(board);

        printBoard(board);

        System.out.println("Player 1 : x");

        System.out.println("Player 2 : o");

        boolean playerone = true;

        char user;

        int choiceCol=0;

        int result=0;

        boolean isGameDone =false;

        int totalPlay = 0;

        while(true){

            if(playerone){

                System.out.print("Player 1:");

                user = 'x';

            }else{

                System.out.print("Player 2:");

                user = 'o';

            }

            System.out.print("Which column would you like to choose ? ");

            choiceCol = sc.nextInt();

            if(choiceCol<0||choiceCol>=col){

                System.out.println("Please enter choice between 0 and "+(col-1));

            }else{

                result=insertChip(board,choiceCol,user);

                if(result==-1){

                    System.out.println("There is no room to insert.Please try again!!!");

                }else{

                    printBoard(board);
                    // this part of the code asks the user to choose a column and then insert a chip
                    // if the is no room for the chip, then the program will tell the user to put a chip somewhere else because it is full.

                    isGameDone =checkIfWinner(board,choiceCol,result,user);

                    if(isGameDone){

                        if(playerone){

                            System.out.print("Player 1 won the game!");

                        }else{

                            System.out.print("Player 2 won the game!");

                        }

                        break;

                    }

                    // this part of code tells user who won
                    playerone = !playerone;

                    totalPlay++;

                }

            }


            if(totalPlay==row*col){

                System.out.println("Draw. Nobody wins.");

                break;

            }

        }
        // this part of the code is here if it is draw.

        sc.close();

    }

}
//practing for lab 6