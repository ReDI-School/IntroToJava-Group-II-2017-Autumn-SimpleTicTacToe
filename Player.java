/**
 * Created on 2017-12-05
 * by marty [at] rosner [dot] io
 * and others visiting
 * https://www.redi-school.org/
 * as students or teachers
 * Introduction to JAVA Autumn 2017
 * from October to December 2017.
 */

class Player{
  // ATTRIBUTES
  private String name;
  private char symbol;

  // CONSTRUCTOR
  public Player(String name, char symbol){
    this.name = name;
    this.symbol = symbol;
  }
  // METHODS
  public String getName(){
    return this.name;
  }
  public char getSymbol(){
    return this.symbol;
  }

  public void setName(String name){
    this.name = name;
  }
  public void setSymbol(char symbol){
    this.symbol = symbol;
  }
}
