package express;

/**
 *
 * @author Andrew
 */
public class Token {
    
    private String lexedItem;
    private double value;
    private TokenType tokType;
    
    public Token(String lexerInput){
        this.lexedItem = lexerInput;
        if(lexedItem.equals("(")) tokType = T_LEFT_PAREN;
    }
}
