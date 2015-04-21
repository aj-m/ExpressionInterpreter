package express;

import java.util.ArrayList;
import express.Token.*;

public class Lexer {

    private static ArrayList<Token> tokens = new ArrayList<>();

    public ArrayList<Token> getTokenList() {
        return tokens;
    }

    public static ArrayList<Token> lex(String input) {
        //variable(s)
        String buffer = "";
        TokenType currentType;
        for (char c : input.toCharArray()) {
            switch (c) {
                case ' ':
                    currentType = TokenType.T_WHITESPACE;
                    tokenizeItem(c, currentType, buffer);
                    buffer = "";
                    break;
                case '=':
                    currentType = TokenType.T_EQUALS;
                    tokenizeItem(c, currentType, buffer);
                    buffer = "";
                    break;
                case '(':
                    currentType = TokenType.T_LEFT_PAREN;
                    tokenizeItem(c, currentType, buffer);
                    buffer = "";
                    break;
                case ')':
                    currentType = TokenType.T_RIGHT_PAREN;
                    tokenizeItem(c, currentType, buffer);
                    buffer = "";
                    break;
                case '+':
                    currentType = TokenType.T_PLUS;
                    tokenizeItem(c, currentType, buffer);
                    buffer = "";
                    break;
                case '-':
                    currentType = TokenType.T_MINUS;
                    tokenizeItem(c, currentType, buffer);
                    buffer = "";
                    break;
                case '*':
                    currentType = TokenType.T_MULT;
                    tokenizeItem(c, currentType, buffer);
                    buffer = "";
                    break;
                case '/':
                    currentType = TokenType.T_DIV;
                    tokenizeItem(c, currentType, buffer);
                    buffer = "";
                    break;
                default:
                    buffer += c;
                    break;
            }
        }
        if (!buffer.equals("")) {
            try {
                double d = Double.parseDouble(buffer);
                tokens.add(new Token(d));
            } catch (NumberFormatException e) {
                //if(buffer.equals("([a-z]|[A-Z])+[0-9]*")){
                tokens.add(new Token(buffer, TokenType.T_ID));
                //}
            }
        }
        return tokens;
    } //lex

    private static void tokenizeItem(char item, TokenType type, String buf) {
        Token temp;
        String ch = Character.toString(item);
        temp = new Token(ch, type);
        if (!buf.equals("")) {
            try {
                double d = Double.parseDouble(buf);
                tokens.add(new Token(d));
            } catch (NumberFormatException e) {
                //if(buf.equals("([a-z]|[A-Z])+[0-9]*")){
                tokens.add(new Token(buf, TokenType.T_ID));
                //}
            }
        }
        tokens.add(temp);
    }
}
