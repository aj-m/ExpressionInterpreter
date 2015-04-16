package express;

public class Token{
	// Token types
	public static enum TokenType{T_ID, T_DOUBLE, T_PLUS, T_MINUS, T_MULT, T_DIV, T_EQUALS,
		T_LEFT_PAREN, T_RIGHT_PAREN}

	// Variables
	public String lexedItem;
	public double value;
	public TokenType tokType;

	// Overriding the toString functionc
	@Override
	public String toString(){
		return String.format("%-20s\t%4s\t\t%.3f", this.tokType, this.lexedItem, this.value);
	}

	public Token(String lexerInput, TokenType t){
		this.lexedItem = lexerInput;
		this.tokType = t;

		if(tokType.equals(TokenType.T_ID))
			value = 0.0;
		if(lexedItem.substring(0,1).matches("[0-9]")){
			this.tokType = TokenType.T_DOUBLE;
			value = Double.parseDouble(lexedItem);
		}

	}

	public Token(String lexerInput){
		this.lexedItem = lexerInput;
		if(lexedItem.equals("("))
			tokType = TokenType.T_LEFT_PAREN;
		else if(lexedItem.equals(")"))
			tokType = TokenType.T_RIGHT_PAREN;
		else if(lexedItem.equals("="))
			tokType = TokenType.T_EQUALS;
		else if(lexedItem.equals("-?[0-9]+"))
			tokType = TokenType.T_DOUBLE;
		else if(lexedItem.equals("+"))
			tokType = TokenType.T_PLUS;
		else if(lexedItem.equals("-"))
			tokType = TokenType.T_MINUS;
		else if(lexedItem.equals("*"))
			tokType = TokenType.T_MULT;
		else if(lexedItem.equals("/"))
			tokType = TokenType.T_DIV;
		else if(lexedItem.equals("^[^\\d\\W]\\w*\\Z"))
			tokType = TokenType.T_ID;
	}
}
