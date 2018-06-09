import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PseudoLexer extends Token{
	ArrayList<Token> tokens = new ArrayList<Token>();
	
	int pos=-1;
	public PseudoLexer(String input){
		
		StringBuffer tokenPatternsBuffer = new StringBuffer();
		for(TokenType tokenType : TokenType.values())
			tokenPatternsBuffer.append(String.format("|(?<%s>%s)", tokenType.name(),tokenType.pattern));
		Pattern tokenPatterns = Pattern.compile(new String(tokenPatternsBuffer.substring(1)));
		Matcher matcher = tokenPatterns.matcher(input);
		
		while(matcher.find()) {
			for(TokenType t : TokenType.values()) {
				if(matcher.group(TokenType.ESPACIOS.name())!=null)
					continue;
				else if (matcher.group(t.name())!=null){
					setToken(t, matcher.group(t.name()));
					tokens.add(new Token(t, matcher.group(t.name())));
					break;
				}
			}
		}
	
		//nextToken();
	}
	
	//ArrayList<PseudoLexer.Token> tokens = lex1.lex(data);
	public Token getToke() {
		return tokens.get(pos);
	}

	public Token nextToken() {
		if(pos==-1){
			pos++;
			return tokens.get(0);
		}
		
		if(pos < tokens.size()){
			return tokens.get(pos++);
		}
		else
			return null;
	}
	
	public Token menosToken() {
				
		if(pos < tokens.size()&&pos !=0){
			return tokens.get(pos--);
		}
		else
			return null;
	}

}
