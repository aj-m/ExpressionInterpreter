/*
 *Author: W.W.Morehouse & A.J.Montenigro
 *Date: 04.05.2015 
 *Function: 
 * 
 */
package express;

import express.Token.TokenType;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.SortedSet;
//import java.util.regex.Pattern;
//import java.util.regex.Matcher;

public class Express {

    public static void main(String[] args) {
        //variable(s)
        Scanner in = new Scanner(System.in);
        String input = "";
        input = in.nextLine();
        //output
        System.out.println("The expression '" + input + "':");
        System.out.println("Token Type\t\tLexeme\t\tValue");
        System.out.println("=============================================");

        ArrayList<Token> tokens = Lexer.lex(input);
        for (Token token : tokens) {
            //if(token.getType() == TokenType.T_WHITESPACE) continue;
            if (token.getType().equals(TokenType.T_WHITESPACE)) {
                continue;
            }
            System.out.println(token);
        }
        System.out.printf("%n%nTesting parse output%n");

        SortedSet<Token> parseTree = Parser.parse(tokens);
        for (Token t : parseTree) {
            System.out.println(t);
        }
    }
}
