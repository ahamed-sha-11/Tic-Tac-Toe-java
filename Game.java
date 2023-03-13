package firstproject;
import java.util.*;
public class Game{
	static Scanner sc = new Scanner(System.in);
	void drawBoard (char[] spaces) {
		System.out.println("     |     |     " );
		System.out.println("   "+spaces[0]+" |  "+spaces[1]+"  |  "+spaces[2]+"   ");
		System.out.println("_____|_____|_____");
		System.out.println("     |     |     " );
		System.out.println("   "+spaces[3]+" |  "+spaces[4]+"  |  "+spaces[5]+"   ");
		System.out.println("_____|_____|_____");
		System.out.println("     |     |     " );
		System.out.println("   "+spaces[6]+" |  "+spaces[7]+"  |  "+spaces[8]+"   ");
		System.out.println("     |     |     " );
		System.out.println();
		System.out.println();
		System.out.println();
	}
	void playerMove(char[] spaces ,char player) {
	
		int position;
		do
		{
			System.out.print("Enter the position (1-9) : ");
			position = sc.nextInt();
			position-=1;
			System.out.println();
			if(spaces[position]==' ')
			{
				
				spaces[position]=player;
				break;
			}
			else
				playerMove(spaces, player);
		}while(!(position>0) && !(position<8));
		
	}
	void computerMove(char[] spaces,char computer)
	{
		int position;
		Random r = new Random();
		while(true)
		{
			position = r.nextInt(9);
			if(spaces[position]==' ')
			{
			
				spaces[position]=computer;
				break;
			}
		}
		
	}
	boolean checkWinner(char[] spaces,char player/*,char computer*/)
	{
		if ((spaces[0] != ' ') && spaces[0] == spaces[1] && spaces[1] == spaces[2])
	    {
	        
	       if( spaces[0]==player)
	       {
	    	   System.out.println("You win :) ")   ;
	       }
	       else
	    	   System.out.println("You lost :("); 

	        		
	    }
	    else if ((spaces[3] != ' ') && spaces[3] == spaces[4] && spaces[4] == spaces[5])
	    {

	    	 if( spaces[3] == player )
		       {
		    	   System.out.println("You win :) ")   ;
		       }
		       else
		    	   System.out.println("You lost :("); 
	    }
	    else if ((spaces[6] != ' ') && spaces[6] == spaces[7] && spaces[7] == spaces[8])
	    {

	    	 if( spaces[6] == player )
		       {
		    	   System.out.println("You win :) ")   ;
		       }
		       else
		    	   System.out.println("You lost :("); 
	    }
	    else if ((spaces[0] != ' ') && spaces[0] == spaces[3] && spaces[3] == spaces[6])
	    {

	    	 if( spaces[0] == player )
		       {
		    	   System.out.println("You win :) ")   ;
		       }
		       else
		    	   System.out.println("You lost :(");  
	    }
	    else if ((spaces[1] != ' ') && spaces[1] == spaces[4] && spaces[4] == spaces[7])
	    {

	    	 if( spaces[1] == player )
		       {
		    	   System.out.println("You win :) ")   ;
		       }
		       else
		    	   System.out.println("You lost :("); 
	    }
	    else if ((spaces[2] != ' ') && spaces[2] == spaces[5] && spaces[5] == spaces[8])
	    {
	       
	    	 if( spaces[2] == player )
		       {
		    	   System.out.println("You win :) ")   ;
		       }
		       else
		    	   System.out.println("You lost :("); 
	    }
	    else if ((spaces[0] != ' ') && spaces[0] == spaces[4] && spaces[4] == spaces[8])
	    {

	    	 if( spaces[0] == player )
		       {
		    	   System.out.println("You win :) ")   ;
		       }
		       else
		    	   System.out.println("You lost :("); 
	    }
	    else if ((spaces[2] != ' ') && spaces[2] == spaces[4] && spaces[4] == spaces[6])
	    {

	    	 if( spaces[2] == player )
		       {
		    	   System.out.println("You win :) ")   ;
		       }
		       else
		    	   System.out.println("You lost :(");  
	    }
	    else
	    {
	        return false;
	    }
		drawBoard(spaces);
		return true;
		
	}
	boolean checkTie(char[] spaces) {
		
		for(char i:spaces)
		{
			if(i==' ') {
				return false;
				
			}
		}
		System.out.println("The match ended in Tie !");
		return true;
		
	}
	public static void main(String args[])
	{
		
		Game Start = new Game();
		
		char[] spaces= {' ',' ',' ',' ',' ',' ',' ',' ',' '};
		char player,computer;
		player='X';
		computer='O';
		Start.drawBoard(spaces);
		boolean running = true;
		while(running)
		{	
			Start.playerMove(spaces,player);
			
			if(Start.checkWinner(spaces, player))
			{
				break;
			}
			if(Start.checkTie(spaces))
			{
				break;
			}
			Start.computerMove(spaces,computer);
			Start.drawBoard(spaces);
			if(Start.checkWinner(spaces, player))
			{
				break;
			}
		}
		
	}
}
