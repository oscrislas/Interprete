import java.util.HashMap;
import java.util.Map;

public class SymbolTable implements Scope{

		Map<String, Symbol> symbols = new HashMap<String,Symbol>();
		public SymbolTable() {initTypeSystem();}
		protected void initTypeSystem() {
		//	define(new BuiltInTypeSymbol("int"));
		//	define(new BuiltInTypeSymbol("float"));
		}
		
		//satisfy scope interface
		
		public String getScopeName() {return "global";}
	
		public void define(Symbol sym) {symbols.put(sym.name, sym);}
		public Symbol resolve(String name) {return symbols.get(name);}
		
		public String toString() {return getScopeName()+":"+symbols;}
		@Override
		public Scope getEnclosinScope() {
			// TODO Auto-generated method stub
			return null;
		}
		
}
