package express;

import java.util.Comparator;

public class Token {

    // Token types

    public static enum TokenType {

        T_WHITESPACE(0),
        T_ID(1),
        T_DOUBLE(1),
        T_PLUS(2),
        T_MINUS(2),
        T_MULT(3),
        T_DIV(3),
        T_LEFT_PAREN(4),
        T_RIGHT_PAREN(4),
        T_EQUALS(5);

        private final Integer priority;

        TokenType(int priority) {
            this.priority = priority;
        }

        public int isHigherThan(TokenType other) {
            return this.priority - other.priority;
        }
    }

    // Variables
    public String lexedItem;
    public double value;
    public TokenType tokType;

    // Overriding the toString functionc
    @Override
    public String toString() {
        return String.format("%-20s\t%4s\t\t%.3f", this.tokType, this.lexedItem, this.value);
    }

    public String getText() {
        return this.lexedItem;
    }

    public TokenType getType() {
        return this.tokType;
    }

    public double getValue() {
        return this.value;
    }

    public Token(Double value) {
        this.lexedItem = value.toString();
        this.tokType = TokenType.T_DOUBLE;
        this.value = value;
    }

    public Token(String lexerInput, TokenType t) {
        this.lexedItem = lexerInput;
        this.tokType = t;
        this.value = 0.0;
    }
    public static Comparator<Token> tokenComparator = new Comparator<Token>() {
        @Override
        public int compare(Token t1, Token t2) {
            return t1.getType().isHigherThan(t2.getType());
        }
    };
}
