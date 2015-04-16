/*
 *Author: W.W.Morehouse & A.J.Montenigro
 *Date: 04.05.2015 
 *Function: 
 * 
 */

package express;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Express{		
	public static void main(String[] args){
		//variable(s)
		Scanner in = new Scanner(System.in);
		String input = "";

		input = in.nextLine();
		//output
		System.out.println("The expression '"+ input +"':");
		System.out.println("Token Type\t\tLexeme\t\tValue");
		System.out.println("=============================================");

		ArrayList<Token> tokens = Lexer.lex(input.replaceAll(" ", ""));
		for (Token token : tokens)
			System.out.println(token);
	}
}
