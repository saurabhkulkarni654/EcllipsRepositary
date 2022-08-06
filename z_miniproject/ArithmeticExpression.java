package z_miniproject;

/* PROJECT FOR TEAM 4 = "CODING SHARKS" */
/* 4.Write a Java program for evaluation of arithmetic expression using Stack.  */

import java.util.Stack;

public class ArithmeticExpression {

// HERE CREATING A METHOD FOR EVALUATION OF EXPRESSION
	public static double ExpressionEvaluation(String expr)
	{
		Stack<Double> operands = new Stack<Double>();				// Stack for the operands with Double Wrapper class.
  		Stack<Character> operator = new Stack<Character>();			//Stack for the operands with Character Wrapper class.
 
  		for (int i = 0; i < expr.length(); i++)						// Read the expression string left to right one by one character sequentially.
  		{				
  			char ch = expr.charAt(i);								// As here i is the index number of Expression check weather have the operands or operator.

  						//Condition 1 : if operand comes, push it into operands Stack.
      					//Condition 2 : if open bracket comes, push it into operators stack.
     
  			if (Character.isDigit(ch)) 								//checking here if it is number.
  			{
  				String value ="";								 	//Entry is Digit, it could be greater than one digit number.
  				while (i<expr.length()) 
  				{
  					if(Character.isDigit(expr.charAt(i)) || expr.charAt(i) == '.')
  					{
  					value += expr.charAt(i++);
  					} 
  					else 
  					{
  						break;
  					}
  				}
  				i--;
  				//push value into stack.
  				operands.push(Double.parseDouble(String.valueOf(value)));
  			}
  			else if (ch == '(') 
  			{
  				operator.push(ch);
  			}
  			else if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^') 
  			{
  				//IF OPERATORS COMES THEN CHECK HERE.
  				if(operator.isEmpty()) 
  				{
  					operator.push(ch);
  				}
  				else if (operator.peek() == '(') 
  				{
  				//push it to operators stack.
  					operator.push(ch);
  			}
  					/*
          			1. If current operator has higher precedence than operator on top of the stack,
      	   	 		   the current operator can be placed in stack.
          			2. else keep popping operator from stack and perform the operation in  numbers stack till
             		   either stack is not empty or current operator has higher precedence than operator on top of the stack.
  					*/
  			else if (getprecedence(operator.peek()) >= getprecedence(ch)) 
  			{
  				char op = operator.pop();
  				double num2 = operands.pop();
  				double num1 = operands.pop();
  				double value = calculate(num1, num2, op);
  				operands.push(value);
  				operator.push(ch);
  			}
  			else 
  			{
  				operator.push(ch);
  			}

  			}  															//Closed brace, evaluate the entire brace.
  			
  			else if (ch == ')') 
  			{
  				while (operator.peek() != '(') 
  				{
  					char op = operator.pop();
  					double num2 = operands.pop();
  					double num1 = operands.pop();
  					double value = calculate(num1, num2, op);

  					operands.push(value);
  				}
  				operator.pop();
  			}
  		}
  		
  		while (operator.size() != 0) 
  		{
  			char op = operator.pop();
  			double num2 = operands.pop();
  			double num1 = operands.pop();
  			double value = calculate(num1, num2, op);
  			operands.push(value);
  		}
  		return operands.pop();
	}

// Method for Calculating.
	private static double calculate(double num1, double num2, char operator) 
	{
		switch (operator)
		{
			case '+': return num1 + num2;
			case '-': return num1 - num2;
			case '*': return num1 * num2;
			case '/':	try
						{ 
							if (num2 == 0);
						} 
      					catch (Exception E)
      					{
      						System.out.println("");
      					}
					  return num1 / num2;
			case '^': return Math.pow(num1,num2);
			default : return 0;
		}
	}
	
// Method for Getting Precedence.
	private static int getprecedence(char ch) 
	{
		if (ch == '+' || ch == '-')
			return 1;
		if ((ch == '*' || ch == '/'))
			return 2;
		if ((ch == '^'))
			return 3;
		if (ch == '(' || ch == ')')
			return 4;
		else return 0;
	}
	
}





