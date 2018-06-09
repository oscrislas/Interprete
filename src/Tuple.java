
import java.util.ArrayList;

public class Tuple {
	private String type;                // tipo de tuple
	private ArrayList<Token> elements = new ArrayList<Token>();  // elementos 
	private int nextTrue, nextFalse;    //terminacion del tuplo
	int posToken=0;

	public Tuple(String type, ArrayList<Token> tokens, int nextTrue, int nextFalse) {//nombre de tuple, lista de elementos, siguiente T, siguiente F
		this.type = type;
		this.elements = tokens;
		this.nextTrue = nextTrue;
		this.nextFalse = nextFalse;
	}

	public String getType() {
		return type;
	}
	
	public void setType(String t) {
		type=t;
	}
	
	public Token getElement(int i) {
		if (i >= 0 && i < elements.size())
			return elements.get(i);
		
		return null;
	}
	public Token getToken() {
		return this.elements.get(posToken);
	}
	public void consume() {
		posToken++;
	}
	
	public ArrayList <Token> getElements() {
		
			return elements;
		
		
	}
	public int size() {
		if (elements != null)
			return elements.size();
		
		return 0;
	}

	public int getNextTrue() {
		return nextTrue;
	}
	
	public void setNextTrue(int nt) {
		nextTrue = nt;
	}

	public int getNextFalse() {
		return nextFalse;
	}

	public void setNextFalse(int nf) {
		nextFalse = nf;
	}

	public String toString() {
		return "\n"+type + ", " + elements + ", " + ", " + nextTrue + ", " + nextFalse;
	}
}
