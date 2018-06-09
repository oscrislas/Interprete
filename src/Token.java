

public class Token{
	public TokenType type;
	public String data;
	public enum TokenType{
		//No se puede usar el guion en el nombre
		NUMERO("-?[0-9]+(\\.([0-9]+))?"),
		//ENUNCIADO(),
		CADENA("\".*\""),
		OPARITMETICO("[*|/|+|_]"),
		OPRELACIONAL("<|>|==|<=|>=|!="),
		DOSPUNTOS(":"),
		IGUAL("="),
		INICIOPROGRAMA("inicio-programa"),
		FINPROGRAMA("fin-programa"),
		SI("si"),
		ENTONCES("entonces"),
		FINSI("fin-si"),
		MIENTRAS("mientras"),
		FINMIENTRAS("fin-mientras"),
		LEER("leer"),
		ESCRIBIR("escribir"),
		COMA(","),
		PARENTESISIZQ("\\("),
		PARENTESISDER("\\)"),
		ESPACIOS("[ \t\f\r\n]+"),
		TIPOS("entero|flotante"),
		VARIABLE("[a-zA-Z][a-zA-Z0-9]*"),
		
		ERROR(".+");
		
		public final String pattern;
		//private TokenType(String pattern){
			private TokenType(String pattern) {
				this.pattern = pattern;
			//}
		}
	}
		
		
		public Token() {
			this.type = null;
			this.data = null;
		}
		public Token(TokenType type, String data) {
			this.type = type;
			this.data = data;
		}
		
		@Override
		public String toString() {
			return String.format("(%s	\"%s\")",type.name(),data);
		}
		public void setToken(TokenType type, String data){
			this.type=type;
			this.data=data;
			
		}
		
	}

