import java.util.Scanner;
public class Bankaccount {
	String name;
	String username;
	String password;
	String accountno;
	float balance=100000f;
	int transactions=0;
	String transactionhistory="";
	
	public void register() {
		Scanner sc=new Scanner(System.in);
		System.out.println("\nEnter name:");
		this.name=sc.nextLine();
		System.out.println("\nEnter username:");
		this.username=sc.nextLine();
		System.out.println("\nEnter password:");
		this.password=sc.nextLine();
		System.out.println("\nEnter accountno:");
		this.accountno=sc.nextLine();
		System.out.println("\nRegistration completed...please login");
	
	}
	
	public boolean login() {
		boolean islogin=false;
		Scanner sc=new Scanner(System.in);
		while(!islogin) {
			System.out.println("\nEnter username:");
			String Username=sc.nextLine();
			if(Username.equals(username)) {
				while(!islogin) {
					System.out.println("\nEnter password:");
					String Password=sc.nextLine();
					if(Password.equals(password)) {
						System.out.println("\nLogin successful!!");
						islogin=true;
					}
					else {
						System.out.println("\nPassword incorrect");
					}
				}
			}
			else {
				System.out.println("\nEnter valid username");
			}
		}
		return islogin;
	}
	
	public void withdraw() {
		System.out.println("\nEnter the amount to withdraw:");
		Scanner sc=new Scanner(System.in);
		float amount=sc.nextFloat();
		try {
			if(balance>=amount) {
				transactions++;
				balance-=amount;
				System.out.println("\nWithdraw successful");
				String str=amount+"Rs withdrawed\n";
				transactionhistory=transactionhistory.concat(str);
			}
			else {
				System.out.println("\nInsufficient balance");
			}
		} catch(Exception e) {
			
		}
	}
		

    public void deposit() {
    	System.out.println("\nEnter the amount to be deposited:");
    	Scanner sc=new Scanner(System.in);
    	float amount=sc.nextFloat();
    	try {
    		if(amount<=100000f) {
    			transactions++;
    			balance+=amount;
    			System.out.println("\nDeposited successfully");
    			String str=amount+"Rs deposited\n";
    			transactionhistory=transactionhistory.concat(str);
    		}
    		else {
    			System.out.println("\nSorry....Limit is 100000.00");
    		}
    	}catch(Exception e) {
    		
    	}
    	
    }
    
    public void transfer() {
    	Scanner sc=new Scanner(System.in);
    	System.out.println("Enter recepient's name:");
    	String recepient=sc.nextLine();
    	System.out.println("Enter amount to be transferred:");
    	float amount=sc.nextFloat();
    	try {
    		if(balance>=amount) {
    			if(amount<=50000f) {
    				transactions++;
    				balance-=amount;
    				System.out.println("\nSuccessfully transferred to" +recepient);
    				String str=amount+"Rs transferred to"+recepient+"\n";
    			}
    			else {
    				System.out.println("\nSorry......limit is 50000.00");
    			}
    		}
    		else {
    			System.out.println("\nInsufficient balance");
    		}
    	}catch(Exception e) {
    		
    	}
    }
    
    public void checkbalance() {
    	System.out.println("\n"+balance+"Rs");
    }
    
    public void transhistory() {
    	if(transactions==0) {
    		System.out.println("\nEmpty");
    	}
    	else {
    		System.out.println("\n"+transactionhistory);
    	}
    }
}
import java.util.Scanner;
public class Atminterface {
	
	public static int takeIntegerInput(int limit) {
		int input=0;
		boolean flag=false;
		
		while(!flag) {
			try {
				Scanner sc=new Scanner(System.in);
				input=sc.nextInt();
				flag=true;
				
				if(flag && input>limit || input<1) {
					System.out.println("\nChoose the number between 1 to"+limit);
					flag=false;
				}
			}catch(Exception e) {
				System.out.println("\nEnter only integer value");
				flag=false;
			}
		};
		return input;
	}

	public static void main(String[] args) {
		System.out.println("\n********WELCOME TO SBI ATM SYSTEM********");
		System.out.println("\n1.Register 2.Exit");
		System.out.println("Enter your choice-");
		int choice=takeIntegerInput(2);
		if(choice==1) {
			Bankaccount b=new Bankaccount();
			b.register();
			while(true) {
				System.out.println("\n1.Login \n2.Exit");
				System.out.println("Enter your choice-");
				int ch=takeIntegerInput(2);
				if(ch==1) {
					if(b.login()) {
						System.out.println("\n\n********Welcome back"+b.name+"********\n");
						boolean isFinished=false;
						while(!isFinished) {
							System.out.println("\n1.Withdraw \n2.Deposit \n3.Transfer \n4.Check Balance \n5.Transaction History");
							System.out.println("Enter your choice-");
							int c=takeIntegerInput(6);
							switch(c) {
							case 1:
								b.withdraw();
								break;
							case 2:
								b.deposit();
								break;
							case 3:
								b.transfer();
								break;
							case 4:
								b.checkbalance();
								break;
							case 5:
								b.transhistory();
								break;
							case 6:
								isFinished=true;
								break;
							}
						}
						
					}
				}
				else {
					System.exit(0);					
				}
			}
		}
		else {
			System.exit(0);
		}
		
		
		

	}

}

    
    



    


	
