import java.util.Random;
public class Game {
	int sysInput;
	int userInput;
	int noofguesses=0;
	Game(){
		Random r=new Random();
		this.sysInput=r.nextInt(100)+1;
	}
	public boolean takeUserInput() {
		if(noofguesses<5) {
			System.out.println("Guess the number:");
			this.userInput=GuessTheNumber.takeIntegerInput(100);
			noofguesses++;
			return false;
			
		}
		else {
			System.out.println("Number of attempts finished....Better luck next time\n");
			return true;
		}
	}
	public boolean isCorrectGuess() {
		if(sysInput==userInput) {
			System.out.println("Congratulations,you guess the number"+sysInput+"in"+noofguesses+"guesses");
			switch(noofguesses) {
			case 1:
				System.out.println("Your score is 100");
				break;
			case 2:
				System.out.println("Your score is 90");
				break;
			case 3:
				System.out.println("Your score is 80");
				break;
			case 4:
				System.out.println("Your score is 70");
				break;
			case 5:
				System.out.println("Your score is 60");
				break;
			case 6:
				System.out.println("Your score is 50");
				break;
			case 7:
				System.out.println("Your score is 40");
				break;
			case 8:
				System.out.println("Your score is 30");
				break;
			case 9:
				System.out.println("Your score is 20");
				break;
			case 10:
				System.out.println("Your score is 10");
				break;
			}
			System.out.println();
			return true;
		}
		else if(noofguesses < 5 && userInput>sysInput) {
			if(userInput-sysInput > 5) {
				System.out.println("Too high");
			}
			else {
				System.out.println("Little high");
			}
		}
		else if(noofguesses < 5 && userInput<sysInput) {
			if(sysInput-userInput > 5)
			{
				System.out.println("Too low");
			}
			else {
				System.out.println("Little low");
			}
		}
		return false;
	}
	

}
import java.util.*;
public class GuessTheNumber {
	public static int takeIntegerInput(int limit) {
		int input=0;
		boolean flag=false;
		
		while(!flag) {
			try {
				Scanner sc=new Scanner(System.in);
				input=sc.nextInt();
				flag=true;
				if(flag&&input>limit||input < 1) {
					System.out.println("Choose the number between 1 to"+limit);
					flag=false;
				}
			}catch(Exception e) {
				System.out.println("Enter only integer value:");
				flag=false;
			}
		};
		return input;
	}

	public static void main(String[] args) {
		System.out.println("1.Start the game \n2.Exit");
		System.out.println("Enter your choice:");
		int choice=takeIntegerInput(2);
		int nextRound=1;
		int noOfRound=0;
		if(choice==1) {
			while(nextRound==1) {
				Game game=new Game();
				boolean isMatched=false;
				boolean isLimitCross=false;
				System.out.println("\nRound"+ ++noOfRound +"starts...");
				while(!isMatched && !isLimitCross) {
					isLimitCross=game.takeUserInput();
					isMatched=game.isCorrectGuess();
				}
				System.out.println("1.Next round \n2.Exit");
				System.out.println("Enter your choice:");
				nextRound=takeIntegerInput(2);
				if(nextRound!=1) {
					System.exit(0);
				}
				
			}
		}
		
	}

}
