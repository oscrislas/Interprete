import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.regex.Pattern;


public class Parser {
	String combercion="";
	 static PseudoLexer input;
	 static Token buscar;
	 String estado;
	 String estado1="";
	 SymbolTable symbols=new SymbolTable();
	 Pattern pCode = Pattern.compile("oscar");
	 String lista;
	 int pocicion=0;
	public Parser(PseudoLexer input) {
		this.input = input;
		this.buscar = input.nextToken();
	}
	
	public static void match(String x) {
		if(buscar.data.equals(x)){
			System.out.println("match :" + x );
			
			consume();
		}
		else
			throw new Error("Error");
                        
	}
	
	public static void consume() {
		buscar = input.nextToken();
	}
	
	public static void menosConsume() {
		buscar = input.menosToken();
	}
	
	public void programa() throws IOException {
		
		match("inicio-programa");
		
		consume();
		declarations();
		Enunciados();
		match("fin-programa");
		
	
		
		System.out.println("Lectura exitosa");
		System.out.println("\n\n\n"+symbols.toString());
	}
	
	public void Enunciados() throws IOException{   /**/
		while(EsEnunciado()) {
			Asignacion();
		}
	}
	
	public boolean EsEnunciado() {
		switch (buscar.type){
		case VARIABLE:
		case LEER:
		case ESCRIBIR:
		case SI:
		case MIENTRAS:
			return true;
		default:
			return false;
		}
		
	}
	
	public void mientras() throws IOException {
		
		compara();
		Enunciados();
		match("fin-mientras");
	
	}
	
	public void si() throws IOException {
		
		compara();
		match("entonces");
		
		
		Enunciados();
		match("fin-si");
		
		
	}
	
	public void compara() throws IOException {
		match("(");
		
		valor();
		Operacion();
		valor();
		match(")");
		
	
	}
	
	public void Operacion() throws IOException {
		switch(buscar.type) {
		case OPRELACIONAL:
			
			
			consume();
			break;
	
		}
	}
	
	public void Asignacion() throws IOException {
		
      switch(buscar.type) {
      
      case VARIABLE: 
    	  System.out.println("prueba varable "+buscar.data);
			 if(symbols.resolve(buscar.data)==null) {
 		  throw new Error("Error de Asiganacion"); 
 	  }else {
 		System.out.println("ASIGNACION "+buscar.data);
        
          consume();
          asignar();
 	  }
    	  
          break;
      case LEER:   
    	
         
          consume();

          read();
                  
        break;
      
      case ESCRIBIR:  
    	 
          
          consume();
          write();
        break;
      
      case SI:   
    	 
        
        
          consume();
          si();
        break;
        
      case MIENTRAS:  
    	
          System.out.println("MIENTRAS "+buscar.data );
       
          consume();
          mientras();
        break;
      case ENTONCES:
    	  
    	  break;
    		  
      default:
        
        throw new Error("Error");
      }
		    

	}
	
	public String cadena() throws IOException {
		switch (buscar.type) {
			case CADENA:
				
				break;
			default:
				throw new Error("Error");
		}
		consume();
		return buscar.data;
		
	}
	
	public void asignar() throws IOException {
		switch (buscar.type) {
		case IGUAL:
	
		break;
		}
		consume();
		operation();
		
	}
	
	public void operation() throws IOException {
		valor();
		isOperator();
	}
	
	public void isOperator() throws IOException {
		switch (buscar.type) {
			case OPARITMETICO:
				
				consume();
				valor();
				break;
				
		}
		
		
	}
	
	public void valor() throws IOException {
		switch (buscar.type) {
		case VARIABLE:{
				 	  
			 
			//symbols.define(new VariableSymnol(buscar.data,(Type)(new BuiltInTypeSymbol("int"))));
		}
			break;
		case NUMERO:
			
			
	    
						
			break;
		default:
			throw new Error("Error de gramatica");
	}
		consume();
		
	}
	
	public void read() throws IOException {
		cadena();
		
		switch (buscar.type) {
		case COMA:
		
		
		break;
		}
		
		consume();
		valor();
	}
	
	public void write() throws IOException {
	String cad = cadena();
		
		
		switch (buscar.type) {
		case COMA:
			
			consume();
			valor();
			
			break;
		default:
			
		}
		
	}
	
	public void declarations() throws IOException
	{	
	
		int cuenta=0;
		
		if(buscar.type==PseudoLexer.TokenType.VARIABLE)
		{
			
			lista=buscar.data;
			pocicion++;
			System.out.println(buscar.data);
			consume();
			
					if(buscar.type==PseudoLexer.TokenType.COMA)
					{
						while(buscar.type!=Token.TokenType.TIPOS) {
							consume();
							cuenta++;
						}
						symbols.define(new VariableSymnol(lista,(Type)(new BuiltInTypeSymbol((buscar.data.equals("entero"))?"entero":"flotante"))));
						
						
						while(cuenta!=0)
						{
							menosConsume();
							cuenta--;
						}
						consume();
						
						declarations();
					}
					else if(buscar.type==PseudoLexer.TokenType.DOSPUNTOS)
					{	
						System.out.println(buscar.data);
						consume();
						if(buscar.type==PseudoLexer.TokenType.TIPOS)
						{
						System.out.println(buscar.data);
						symbols.define(new VariableSymnol(lista,(Type)(new BuiltInTypeSymbol((buscar.data.equals("entero"))?"entero":"flotante"))));
					
						 	consume();
							declarations();
						}
					}
				}
	}
	
	

	
	
}