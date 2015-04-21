package express;

import express.Token.TokenType;
import java.util.ArrayList;
import java.util.SortedSet;
//import java.util.Stack;
import java.util.TreeSet;

public class Parser {

    public static SortedSet<Token> parse(ArrayList<Token> tokens) {
        SortedSet<Token> ret = new TreeSet<>(Token.tokenComparator);
        for (Token current : tokens) {
            //Stack<Token> orderStack = new Stack<>();
            if (current.getType().equals(TokenType.T_WHITESPACE)) {
                continue;
            }
            ret.add(current);
        }
        return ret;
    }
}
