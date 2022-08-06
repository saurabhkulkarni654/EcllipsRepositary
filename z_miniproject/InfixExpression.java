package z_miniproject;

import java.util.Scanner;

public class InfixExpression {
	
	public static void main(String[] args) 
	{
		//String expr = "5.5^2+1+(5-3+6/0)";
		//System.out.println(ArithmeticExpression.ExpressionEvaluation(expr));
		boolean ch = true;
		do 
		{
			Scanner sc =new Scanner(System.in);
			System.out.println("\n____________________________________________________________________________________________");
			System.out.println("________________Infix Expression Evaluation________________");
			System.out.println("NOTE = 1. Permitted operators: +,-, *, /, ^(exponentiation)");
			System.out.println("          (Don't Use consecutive operator's.");
			System.out.println("       2. Blanks & Parenthesis are permitted in expression");
			System.out.println("       3. Any number Divided by 0 is INFINITY.");
			System.out.println("----------------------------------------------------------");
			System.out.println("Enter 1 : To evaluate the Expression.");
			System.out.println("Enter 2 : Check Sample Expression here.");
			System.out.println("Enter 3 : Exit from the system.");
			System.out.println("----------------------------------------------------------");
			System.out.print("			Enter Your Choice : ");
			int num = sc.nextInt();
			switch (num)
			{
				case 1 :
							System.out.print("Enter the Expression :		");
							Scanner sc2 = new Scanner(System.in);
							String expression = sc2.nextLine();
							System.out.println("Result with Expression : 	"+expression+" = "+ArithmeticExpression.ExpressionEvaluation(expression));
                   break;
                   
				case 2 :
							System.out.println("Check Sample Expression here.");
							System.out.println("Enter 1 : 2*(5 *(3+6))/15-2");
							System.out.println("Enter 2 : 1001/0");
							System.out.println("Enter 3 : 1001/2^3");
							System.out.println("Enter 4 : Go back to Main Menu");
							String a = "2*(5 *(3+6))/15-2";
							String b = "1001/0";
							String c = "1001/2^3";
							boolean flag = true;
					
							do 
							{
								System.out.print("			Enter Your Choice : ");
								int num1 = sc.nextInt();
								switch (num1) 
								{
									case 1:
											System.out.println("Result with Expression "+a+" = "+ArithmeticExpression.ExpressionEvaluation(a));
										break;
									case 2:
											System.out.println("Result with Expression "+b+" = "+ArithmeticExpression.ExpressionEvaluation(b));
										break;
									case 3:
											System.out.println("Result with Expression "+c+" = "+ArithmeticExpression.ExpressionEvaluation(c));
										break;
									case 4:
											flag = false;
										break;
									default:
											System.out.println("Invalid Entry..!!");
										break;
								}
							}
							while (flag);
							break;

               case 3:
            	   		System.out.println("Thanking You  !!! ");
            	   		sc.close();
            	   		ch= false;
            	   	break;

               default:
            	   		System.out.println("Invalid input !!");

			}
		}
		while (ch);
	}
	
}
