import java.util.ArrayList;

public class Parser {
	protected ArrayList<Token> token;
	protected SymbolsTable symbolsTable;
	protected ArrayList<Tuple> = new ArrayList<Tuple>();
	protected int tokenIndex =0;
	protected boolean debug;
	
	abstract public boolean parse(ArrayList<Token> tokens, SymbolsTable symbolsTable, boolean debug);)

	public ArrayList<Token> getTokens(){
		return tokens;
	}
	public SymbolsTable getSymbolsTable() {
		return symbolsTable;
	}
	public ArrayList<Tuple> getTuples(){
		return tuples;
	}
	protected boolean match (String name) {
		if (tokens.get(tokenIndex).getType().getName().equels(name)) {
			tokenIndex++;
			
			if(debug) 
				System.out.println("Match: "+name);
				
			return true;
			
		}
		return false;
	}
}
