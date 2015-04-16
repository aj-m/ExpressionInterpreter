package express;
import express.Token.*;
import java.util.ArrayList;

public class Lexer{
	public static ArrayList<Token> lex(String input){
		//variable(s)
		String buffer = "";
		Token temp = null;
		ArrayList<Token> tokens = new ArrayList<>();
		for(char c : input.toCharArray()){
			switch (c){
			case '=':
			case '(':
			case ')':
			case '+':
			case '-':
			case '*':
			case '/':
				if(!buffer.equals("")){
					temp = new Token(buffer, TokenType.T_ID);
					tokens.add(temp);
				}
				tokens.add(new Token(Character.toString(c)));
				buffer = "";
				break;
			default:
				buffer+= c;
			}
		}
		tokens.add(new Token(buffer, TokenType.T_ID));
		return tokens;
	}

}
