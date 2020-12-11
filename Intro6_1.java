import java.util.Scanner;
import java.util.Random;
class WrongInputException extends RuntimeException
{
	WrongInputException()
	{
		System.out.println("Please provide a single character only...!!");
	}
}
class MenuInputException extends RuntimeException
{
	MenuInputException()
	{
		System.out.println("Please provide a valid input(1-3)");
	}
}
public class Intro6_1
{
	public void showMenu()
	{
		int option=0;
		String ans;
		Scanner sc1=new Scanner(System.in);
		do
		{
			System.out.println("---------Menu---------");
			System.out.println("1. Play");
			System.out.println("2. Instructions");
			System.out.println("3. Exit");
			System.out.println("Choose the option:");
			try
			{
				option=sc1.nextInt();
			}
			catch(RuntimeException e)
			{
				System.out.println("Please provide a valid numeric input "+e);
				showMenu();
			}
			switch(option)
			{
				case 1: playGame();
					break;
				case 2: instructGame();
					break;
				case 3: exitGame();
					break;
				default: 
					try
					{
						throw new MenuInputException();
					}
					catch(MenuInputException e)
					{
						System.out.println(e);
						showMenu();
					}
			}
			System.out.println("Do you want to continue game?(y/n)");
			ans=sc1.next();
		}while(ans.equals("y")||ans.equals("Y"));
		System.exit(0);
	}
	public void playGame()
	{
		String word[]={"bhutan","bangladesh","australia","srilanka","america","india"};
		int len,count=0,rnd,flag=0;
		String ch,temp,choice;
		Random rd=new Random();
		Scanner sc=new Scanner(System.in);
		rnd=rd.nextInt(6); /*generates a random number from 0 to 5 and assigns the same to the variable rnd*/
		len=word[rnd].length();
		char newString[]=new char[len];
		StringBuffer wrgString=new StringBuffer();
		for(int j=0;j<len;j++)
		{
			System.out.print("_ ");
		}
		System.out.println();
		do
		{	
			flag=0;
			System.out.println("Enter your guess:");
			try
			{
				ch=sc.next().toLowerCase();
				if(ch.length()!=1)
				{
					count++;
					throw new WrongInputException();
				}
				count++;
				for(int i=0;i<len;i++)
				{
					if(word[rnd].charAt(i)==ch.charAt(0))
					{
						newString[i]=word[rnd].charAt(i);
						flag=1;
					}
				}
				if(flag==0)
				{
					flag=1;
					wrgString.append(ch+" , ");
					System.out.println("\nMisses: "+wrgString);
				}
				System.out.println();
				System.out.println(newString);
				temp=new String(newString);
				if(word[rnd].equals(temp))
				{
					System.out.println("\nCongratulation ! :) You have won !");
					System.out.println("Your number of attempts is: "+count);
					System.out.println("Do you want to play again?(Y/N)");
					choice=sc.next();
					if(choice.equalsIgnoreCase("y"))
					{
						playGame();
					}
					else
					{
						showMenu();
					}
				}
			}
			catch(WrongInputException e)
			{
				System.out.println(e);
				flag=1;
			}	
		}while(flag!=0);
	}
	public void instructGame()
	{
		System.out.println("instructGame method is invoked");
	}
	public void exitGame()
	{
		System.out.println("exitGame method is invoked");
		System.exit(0);
	}
	public static void main(String args[])
	{
		Intro6_1 obj=new Intro6_1();
		obj.showMenu();
	}
}

