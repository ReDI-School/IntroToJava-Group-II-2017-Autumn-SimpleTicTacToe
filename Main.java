/**
 * Created on 2017-12-05
 * by marty [at] rosner [dot] io
 * and others visiting
 * https://www.redi-school.org/
 * as students or teachers
 * Introduction to JAVA Autumn 2017
 * from October to December 2017.
 */

class Main{
    public static void main(String [] args){
		TicTacToe ttt = new TicTacToe();
		ttt.draw();
		Player one = new Player("Sam", 'X');
		Player two = new Player("Bob", 'O');

		boolean play = true;
		while(play){
			ttt.set(one);
			ttt.draw();
			if(ttt.check_gameover() == true){
				clear_window();
				System.out.println("The player: " + one.getName() + " is the WINNER!");
				break;
			}
			ttt.set(two);
			ttt.draw();
			if(ttt.check_gameover() == true){
				clear_window();
				System.out.println("The player: " + two.getName() + " is the WINNER!");
			break;
			}
		}

  }
  // this will clear the window no matter which os..
  public static void clear_window(){
	  for(int clear = 0; clear < 100; clear++){
		System.out.println("\b") ;
	  }
  }
}
