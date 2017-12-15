/**
 * Created on 2017-12-05
 * by marty [at] rosner [dot] io
 * and others visiting
 * https://www.redi-school.org/
 * as students or teachers
 * Introduction to JAVA Autumn 2017
 * from October to December 2017.
 */

import java.util.Scanner;

class TicTacToe{
  // ATTRIBUTES
  char [][] board;
  int length;
  boolean gameover;

  // CONSTRUCTOR
  public TicTacToe(){
    this.length = 3;
    board = new char[this.length][this.length];
    for(int i = 0; i < this.length; i++){
      for(int j = 0; j < this.length; j++){
        board[i][j] = ' ';
      }
    }
    gameover = false;
  }

  // METHODS
  // printing the board
  public void draw(){
    for(int i = 0; i < this.length; i++){
      for(int j = 0; j < this.length; j++){
        System.out.print("[");
        System.out.print(this.board[i][j]);
        System.out.print("]");
      }
      System.out.print("\n");
    }

  }
  // setting a symbol for a field
  public void set(Player some){
    int row = this.length + 1;
    int col = this.length + 1;
    while(row > this.length || col > this.length){
      Scanner scanner = new Scanner(System.in);
      System.out.print(some.getName()  + " row: ");
      row = scanner.nextInt();
      System.out.print(some.getName()  + " col: ");
      col = scanner.nextInt();
    }
    char symbol = some.getSymbol();
    if(this.board[row-1][col-1] == ' '){
      this.board[row-1][col-1] = symbol;
    }
    else{
      System.out.println(some.getName() + "! This field is already take - try again please.." );
      this.set(some);
    }

  }
  // checks for a full column
  public void checkcol(int col){
    char symbol = this.board[0][col];
    int count_sym_col;
    if (symbol != ' '){
      count_sym_col = 0;
      for(int row = 0; row < this.length; row++){
          if(symbol == this.board[row][col]){
            count_sym_col = count_sym_col + 1;
          }
        }

      if(count_sym_col == this.length){
        this.gameover = true;
      }
    }

  }
  // checks for full row
  public void checkrow(int row){
    char symbol = this.board[row][0];
    int count_sym_row;
    if (symbol != ' '){
      count_sym_row = 0;
      for(int col = 0; col < this.length; col++){
          if(symbol == this.board[row][col]){
            count_sym_row = count_sym_row + 1;
          }
      }

      if(count_sym_row == this.length){
        this.gameover = true;
      }
    }
  }

  public void checkdia_top_down(){
	char symbol_pos1 = this.board[0][0];
    if (symbol != ' '){
	  char symbol_pos2 = board[1][1];
	  char symbol_pos3 = board[2][2];
	  if(symbol_pos1 == symbol_pos2 && symbol_pos2 == symbol_pos3){
		this.gameover = true;
	  }
    }
  }

  public void checkdia_down_top(){
	char symbol_pos1 = this.board[2][0];
    if (symbol != ' '){
		char symbol_pos2 = board[1][1];
		char symbol_pos3 = board[0][2];
	  if(symbol_pos1 == symbol_pos2 && symbol_pos2 == symbol_pos3){
		this.gameover = true;
	  }
    }
  }

  public boolean check_gameover(){
    // calling method and checking each column
    for(int i = 0; i < this.length; i++){
      this.checkcol(i);
    }
    // calling method and checking each row
    for(int j = 0; j < this.length; j++){
      this.checkrow(j);
    }
    // calling method and checking up left to bottom right
    this.checkdia_top_down();
    // calling method and checking down left to up right
    this.checkdia_down_top();
    return this.gameover;
  }
}
