
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;
import javax.swing.JFrame;


public class Ejecuta implements ActionListener {
        public static String nuevalinea = System.getProperty("line.separator");
	 public TablaVariables t = new TablaVariables();
         String texto="";
         graficos gra = new graficos();
         JFrame mainWindow=new JFrame("Menu sample");
         
	 String combercion="";
	 static PseudoLexer input;
	 static Token buscar;
	 String estado;
	 String estado1="";
	 SymbolTable symbols=new SymbolTable();
	 Pattern pCode = Pattern.compile("oscar");
	 String lista;
	 int pocicion=0;
	 int i=0;
	 ArrayList<Tuple> Tuplas = new ArrayList<Tuple>();
	 
	public Ejecuta(PseudoLexer input) {
		this.input = input;
		this.buscar = input.nextToken();
	}
	
	public void actionPerformed(ActionEvent e) { 
            

        }
	public static void consume() {
		buscar = input.nextToken();
	}
	
	public static void menosConsume() {
		buscar = input.menosToken();
	}
	   public void run(){
	gra.setVisible(true);
    
		gra.consola.setText("hola");
    }
	public void programa() {
	
	mainWindow.add(gra);
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setVisible(true);
        mainWindow.pack();
	//t.AgregarVariable(new Variables("variable2","entero","2"));
	//t.AgregarVariable(new Variables("variable2","entero","2"));
		CrearTuplas();
               
		System.out.println(Tuplas.toString());
		for(this.i=0;i<this.Tuplas.size()-1;i++) {
			ejecuta(this.Tuplas.get(i));
		}
	 System.out.println(this.Tuplas.toString());
                
        
                
                
	
		
		
		
		
		//t.ImprimeVariables();
	}

	void ejecuta(Tuple tupla) {
		int i=0;
		//gra.entrada.append(texto + nuevalinea);
		if(tupla.getType().equals("Leer")){
			if(tupla.getElements().size()>2) {
                                texto+=tupla.getElement(1).data.replaceAll("\"", "")+nuevalinea;
                               
				System.out.println(tupla.getElement(1).data.replaceAll("\"", ""));
                                gra.consola.setText(texto);
				tupla.getToken();
				//Scanner leer=new Scanner(System.in); 
                                gra.cadena=null;
                               while(gra.cadena==null){
                                   System.out.println("s");
                               }
                               
                                System.out.print("paso");
				tupla.consume();
				tupla.consume();
				tupla.consume();
				
				String var=tupla.getToken().data;
				
				//String dato=leer.nextLine();
                                System.out.print(gra.entrada.getText());
				//System.out.println("el dato es "+var+"y se le envia "+dato);
				t.CambiarValor(var, gra.entrada.getText());
				texto+=t.getVariable((tupla.getToken().data)).getValor()+nuevalinea;
				System.out.println(t.getVariable((tupla.getToken().data)).getValor());
                                gra.consola.setText(texto);
                                gra.entrada.setText(null);
			}else {
                                texto+=tupla.getElement(1).data.replaceAll("\"", "")+nuevalinea;
				System.out.println(tupla.getElement(1).data.replaceAll("\"", " "));
				gra.consola.setText(texto);
			}
			
			
		}
		if(tupla.getType().equals("Escribir")){
			
			if(tupla.getElements().size()>2) {
                                texto+=tupla.getElement(1).data.replaceAll("\"", " ")+" ";
				System.out.print(tupla.getElement(1).data.replaceAll("\"", " ")+" ");
				gra.consola.setText(texto);
				tupla.consume();
	
				tupla.consume();
		
				tupla.consume();
				texto+=t.getVariable(tupla.getElement(3).data).getValor()+nuevalinea;
				System.out.println(t.getVariable(tupla.getElement(3).data).getValor());
				gra.consola.setText(texto);
				gra.entrada.setText(null);
				//System.out.println("ok");
			}else {
                                texto+=tupla.getElement(1).data.replaceAll("\"", " ")+nuevalinea;
				System.out.println(tupla.getElement(1).data.replaceAll("\"", " "));
				gra.consola.setText(texto);
                                gra.entrada.setText(null);
			}


		}
	if(tupla.getType().equals("operacion")){
			float datoflot1;
			float datoflot2;
			float datoflot3;
			float resultadoflot;
			int datoint1;
			int datoint2;
			int resultado;
			//System.out.println("paso");
			String uno=tupla.getElement(0).data;
		//	System.out.println(tupla.getToken().data);
			tupla.consume();
			tupla.consume();
			String dos=tupla.getElement(2).data;
			//System.out.println(tupla.getToken().data);
			tupla.consume();
			String operador=tupla.getElement(3).data;
			//System.out.println(tupla.getToken().data);
			tupla.consume();
			String tres=tupla.getElement(4).data;
			//System.out.println(tupla.getToken().data);
			//System.out.println(uno+"="+dos+operador+tres);
			switch(operador) {
			case "+":{
				if(this.t.getVariable(uno).getTipo().equals("entero")){
					
					 try {
						 datoint1=Integer.parseInt(this.t.getVariable(dos).getValor());
				        	//System.out.println("se pudo");
				        }
				        catch (Exception e) {
				        	datoint1=Integer.parseInt(dos);
				        	//System.out.println("no pudo");
				        } 
					 try {
						 datoint2=Integer.parseInt(this.t.getVariable(tres).getValor());
				        	//System.out.println("se pudo");
				        }
				        catch (Exception e) {
				        	datoint2=Integer.parseInt(tres);
				        	//System.out.println("no pudo");
				        } 
					

							resultado=datoint1+datoint2;
								t.CambiarValor(uno, String.valueOf(resultado));
							}
						else if(this.t.getVariable(uno).getTipo().equals("flotante")){

//							
							
							 try {
								 datoflot2=Float.parseFloat(this.t.getVariable(dos).getValor());
						        	//System.out.println("se pudo");
						        }
						        catch (Exception e) {
						        	datoflot2=Float.parseFloat(dos);
						        	//System.out.println("no pudo");
						        } 
							 try {
								 datoflot3=Float.parseFloat(this.t.getVariable(tres).getValor());
						        	//System.out.println("se pudo");
						        }
						        catch (Exception e) {
						        	datoflot3=Float.parseFloat(tres);
						        	//System.out.println("no pudo");
						        } 
							
							resultadoflot=datoflot2+datoflot3;
							t.CambiarValor(uno, String.valueOf(resultadoflot));
						
						
						}
			}break;
			case "_":{
				if(this.t.getVariable(uno).getTipo().equals("entero")){
					
					 try {
						 datoint1=Integer.parseInt(this.t.getVariable(dos).getValor());
				        	//System.out.println("se pudo");
				        }
				        catch (Exception e) {
				        	datoint1=Integer.parseInt(dos);
				        	//System.out.println("no pudo");
				        } 
					 try {
						 datoint2=Integer.parseInt(this.t.getVariable(tres).getValor());
				        	//System.out.println("se pudo");
				        }
				        catch (Exception e) {
				        	datoint2=Integer.parseInt(tres);
				        	//System.out.println("no pudo");
				        } 
					resultado=datoint1-datoint2;
						t.CambiarValor(uno, String.valueOf(resultado));
					}
				else if(this.t.getVariable(uno).getTipo().equals("flotante")){

//				
					 try {
						 datoflot2=Float.parseFloat(this.t.getVariable(dos).getValor());
				        	//System.out.println("se pudo");
				        }
				        catch (Exception e) {
				        	datoflot2=Float.parseFloat(dos);
				        	//System.out.println("no pudo");
				        } 
					 try {
						 datoflot3=Float.parseFloat(this.t.getVariable(tres).getValor());
				        	//System.out.println("se pudo");
				        }
				        catch (Exception e) {
				        	datoflot3=Float.parseFloat(tres);
				        	//System.out.println("no pudo");
				        }
					resultadoflot=datoflot2-datoflot3;
					t.CambiarValor(uno, String.valueOf(resultadoflot));
				
				
				}
			}break;
			case "*":{
				if(this.t.getVariable(uno).getTipo().equals("entero")){
					
					 try {
						 datoint1=Integer.parseInt(this.t.getVariable(dos).getValor());
				        	//System.out.println("se pudo");
				        }
				        catch (Exception e) {
				        	datoint1=Integer.parseInt(dos);
				        	//System.out.println("no pudo");
				        } 
					 try {
						 datoint2=Integer.parseInt(this.t.getVariable(tres).getValor());
				        	//System.out.println("se pudo");
				        }
				        catch (Exception e) {
				        	datoint2=Integer.parseInt(tres);
				        	//System.out.println("no pudo");
				        } 
					resultado=datoint1*datoint2;
						t.CambiarValor(uno, String.valueOf(resultado));
					}
				else if(this.t.getVariable(uno).getTipo().equals("flotante")){

//				
					 try {
						 datoflot2=Float.parseFloat(this.t.getVariable(dos).getValor());
				        	//System.out.println("se pudo");
				        }
				        catch (Exception e) {
				        	datoflot2=Float.parseFloat(dos);
				        	//System.out.println("no pudo");
				        } 
					 try {
						 datoflot3=Float.parseFloat(this.t.getVariable(tres).getValor());
				        	//System.out.println("se pudo");
				        }
				        catch (Exception e) {
				        	datoflot3=Float.parseFloat(tres);
				        	//System.out.println("no pudo");
				        }
					resultadoflot=datoflot2*datoflot3;
					t.CambiarValor(uno, String.valueOf(resultadoflot));
				
				
				}
			}break;
			case "/":{
				if(this.t.getVariable(uno).getTipo().equals("entero")){
					
					 try {
						 datoint1=Integer.parseInt(this.t.getVariable(dos).getValor());
				        	//System.out.println("se pudo");
				        }
				        catch (Exception e) {
				        	datoint1=Integer.parseInt(dos);
				        	//System.out.println("no pudo");
				        } 
					 try {
						 datoint2=Integer.parseInt(this.t.getVariable(tres).getValor());
				        	//System.out.println("se pudo");
				        }
				        catch (Exception e) {
				        	datoint2=Integer.parseInt(tres);
				        	//System.out.println("no pudo");
				        } 
					resultado=datoint1/datoint2;
						t.CambiarValor(uno, String.valueOf(resultado));
					}
				else if(this.t.getVariable(uno).getTipo().equals("flotante")){

//				
					 try {
						 datoflot2=Float.parseFloat(this.t.getVariable(dos).getValor());
				        	//System.out.println("se pudo");
				        }
				        catch (Exception e) {
				        	datoflot2=Float.parseFloat(dos);
				        	//System.out.println("no pudo");
				        } 
					 try {
						 datoflot3=Float.parseFloat(this.t.getVariable(tres).getValor());
				        	//System.out.println("se pudo");
				        }
				        catch (Exception e) {
				        	datoflot3=Float.parseFloat(tres);
				        	//System.out.println("no pudo");
				        }
					resultadoflot=datoflot2/datoflot3;
					t.CambiarValor(uno, String.valueOf(resultadoflot));
				
				
				}
			}break;
			}
		}
	if(tupla.getType().equals("si")) {
		//System.out.println("entro al if");
		float var1;
		float var2;
		tupla.consume();
		//System.out.println("es este "+tupla.getElement(4));
		tupla.consume();
		String uno=tupla.getElement(2).data;
		tupla.consume();
		String operador=tupla.getToken().data;
		//System.out.println(operador);
		tupla.consume();
		String dos=tupla.getElement(4).data;
		//System.out.println("los valores son uno "+uno+" dos "+dos);
		
        try {
        	var1=Float.parseFloat(this.t.getVariable(uno).getValor());
        }
        catch (Exception e) {
        	var1=Float.parseFloat(uno);
        } 
		
        try {
        	var2=Float.parseFloat(this.t.getVariable(dos).getValor());
        }
        catch (Exception e) {
        	var2=Float.parseFloat(dos);
        } 
		
		
		//System.out.println("el operador "+operador);
		switch (operador) {
		
		case "==":{
			if(var1==var2) {

		        try {
		        	var1=Float.parseFloat(this.t.getVariable(uno).getValor());
		        	//System.out.println("se pudo");
		        }
		        catch (Exception e) {
		        	var1=Float.parseFloat(uno);
		        	//System.out.println("no pudo");
		        } 
				
		        try {
		        	var2=Float.parseFloat(this.t.getVariable(dos).getValor());
		        	//System.out.println("se pudo");
		        }
		        catch (Exception e) {
		        	var2=Float.parseFloat(dos);
		        	//System.out.println("no pudo");
		        }
			}else {
				//this.i=i+0;
				//System.out.println("false");
				while(Tuplas.get(this.i).getType()!="fin-si") {
				
					//System.out.println(Tuplas.get(this.i).toString());
					this.i++;
				}
		        try {
		        	var1=Float.parseFloat(this.t.getVariable(uno).getValor());
		        	//System.out.println("se pudo");
		        }
		        catch (Exception e) {
		        	var1=Float.parseFloat(uno);
		        	//System.out.println("no pudo");
		        } 
				
		        try {
		        	var2=Float.parseFloat(this.t.getVariable(dos).getValor());
		        	//System.out.println("se pudo");
		        }
		        catch (Exception e) {
		        	var2=Float.parseFloat(dos);
		        	//System.out.println("no pudo");
		        } 
				
			}
		}break;
		case "<=":{
			if(var1<=var2) {
		        try {
		        	var1=Float.parseFloat(this.t.getVariable(uno).getValor());
		        	//System.out.println("se pudo");
		        }
		        catch (Exception e) {
		        	var1=Float.parseFloat(uno);
		        	//System.out.println("no pudo");
		        } 
				
		        try {
		        	var2=Float.parseFloat(this.t.getVariable(dos).getValor());
		        	//System.out.println("se pudo");
		        }
		        catch (Exception e) {
		        	var2=Float.parseFloat(dos);
		        	//System.out.println("no pudo");
		        } 
				
			}else {
				while(Tuplas.get(this.i).getType()!="fin-si") {
				
					Tuplas.remove(this.i);
				}
		        try {
		        	var1=Float.parseFloat(this.t.getVariable(uno).getValor());
		        	//System.out.println("se pudo");
		        }
		        catch (Exception e) {
		        	var1=Float.parseFloat(uno);
		        	//System.out.println("no pudo");
		        } 
				
		        try {
		        	var2=Float.parseFloat(this.t.getVariable(dos).getValor());
		        	//System.out.println("se pudo");
		        }
		        catch (Exception e) {
		        	var2=Float.parseFloat(dos);
		        	//System.out.println("no pudo");
		        } 
			}
		}
		break;
		case ">=":{
			if(var1>=var2) {
		        try {
		        	var1=Float.parseFloat(this.t.getVariable(uno).getValor());
		        	//System.out.println("se pudo");
		        }
		        catch (Exception e) {
		        	var1=Float.parseFloat(uno);
		        	//System.out.println("no pudo");
		        } 
				
		        try {
		        	var2=Float.parseFloat(this.t.getVariable(dos).getValor());
		        	//System.out.println("se pudo");
		        }
		        catch (Exception e) {
		        	var2=Float.parseFloat(dos);
		        	//System.out.println("no pudo");
		        } 
			}else {
				while(Tuplas.get(this.i).getType()!="fin-si") {
				
					Tuplas.remove(this.i);
				}
		        try {
		        	var1=Float.parseFloat(this.t.getVariable(uno).getValor());
		        	//System.out.println("se pudo");
		        }
		        catch (Exception e) {
		        	var1=Float.parseFloat(uno);
		        	//System.out.println("no pudo");
		        } 
				
		        try {
		        	var2=Float.parseFloat(this.t.getVariable(dos).getValor());
		        	//System.out.println("se pudo");
		        }
		        catch (Exception e) {
		        	var2=Float.parseFloat(dos);
		        	//System.out.println("no pudo");
		        } 
			}
		}break;
		case "<":{
			if(var1<var2) {
		        try {
		        	var1=Float.parseFloat(this.t.getVariable(uno).getValor());
		        	//System.out.println("se pudo");
		        }
		        catch (Exception e) {
		        	var1=Float.parseFloat(uno);
		        	//System.out.println("no pudo");
		        } 
				
		        try {
		        	var2=Float.parseFloat(this.t.getVariable(dos).getValor());
		        	//System.out.println("se pudo");
		        }
		        catch (Exception e) {
		        	var2=Float.parseFloat(dos);
		        	//System.out.println("no pudo");
		        } 
			}else {
				while(Tuplas.get(this.i).getType()!="fin-si") {
				
					Tuplas.remove(this.i);
				}
		        try {
		        	var1=Float.parseFloat(this.t.getVariable(uno).getValor());
		        	//System.out.println("se pudo");
		        }
		        catch (Exception e) {
		        	var1=Float.parseFloat(uno);
		        	//System.out.println("no pudo");
		        } 
				
		        try {
		        	var2=Float.parseFloat(this.t.getVariable(dos).getValor());
		        	//System.out.println("se pudo");
		        }
		        catch (Exception e) {
		        	var2=Float.parseFloat(dos);
		        	//System.out.println("no pudo");
		        } 
			}
		}break;
		case ">":{
			if(var1>var2) {
		        try {
		        	var1=Float.parseFloat(this.t.getVariable(uno).getValor());
		        	//System.out.println("se pudo");
		        }
		        catch (Exception e) {
		        	var1=Float.parseFloat(uno);
		        	//System.out.println("no pudo");
		        } 
				
		        try {
		        	var2=Float.parseFloat(this.t.getVariable(dos).getValor());
		        	//System.out.println("se pudo");
		        }
		        catch (Exception e) {
		        	var2=Float.parseFloat(dos);
		        	//System.out.println("no pudo");
		        } 
			}else {
				while(Tuplas.get(this.i).getType()!="fin-si") {
				
					Tuplas.remove(this.i);
				}
		        try {
		        	var1=Float.parseFloat(this.t.getVariable(uno).getValor());
		        	//System.out.println("se pudo");
		        }
		        catch (Exception e) {
		        	var1=Float.parseFloat(uno);
		        	//System.out.println("no pudo");
		        } 
				
		        try {
		        	var2=Float.parseFloat(this.t.getVariable(dos).getValor());
		        	//System.out.println("se pudo");
		        }
		        catch (Exception e) {
		        	var2=Float.parseFloat(dos);
		        	//System.out.println("no pudo");
		        } 
			}
		}break;
		}
	}/////////////////////////////////////////////////////////////////////////////while
	if(tupla.getType().equals("while")) {
		ArrayList<Tuple> Tupla = new ArrayList<Tuple>();
		float var1;
		float var2;
		tupla.consume();
		tupla.consume();
		//System.out.println("entro mientras");
		String uno=tupla.getElement(2).data;
		tupla.consume();
		String operador=tupla.getToken().data;
		tupla.consume();
		String dos=tupla.getElement(4).data;
		if(input.getToke().type==Token.TokenType.NUMERO) {
			
		}
        try {
        	var1=Float.parseFloat(this.t.getVariable(uno).getValor());
        	//System.out.println("se pudo");
        }
        catch (Exception e) {
        	var1=Float.parseFloat(uno);
        	//System.out.println("no pudo");
        } 
		
        try {
        	var2=Float.parseFloat(this.t.getVariable(dos).getValor());
        	//System.out.println("se pudo");
        }
        catch (Exception e) {
        	var2=Float.parseFloat(dos);
        	//System.out.println("no pudo");
        } 
       
		while(Tuplas.get(this.i).getType()!="fin-mientras") {
			
			Tupla.add(this.Tuplas.get(this.i));
			Tuplas.remove(this.i);
			
		}
		//System.out.println("paso while");
		//System.out.println(t.getVariable(uno).getValor()+operador+t.getVariable(dos).getValor());
		switch (operador) {
		case "==":{
			if(var1==var2) {
				//System.out.println(var1+var2);
				while(var1==var2) {
					
					for(int j=1;j<Tupla.size();j++) {
						
						ejecuta(Tupla.get(j));
						//System.out.println(Tupla.get(j).toString());
						
					}
			        try {
			        	var1=Float.parseFloat(this.t.getVariable(uno).getValor());
			        	//System.out.println("se pudo");
			        }
			        catch (Exception e) {
			        	var1=Float.parseFloat(uno);
			        	//System.out.println("no pudo");
			        } 
					
			        try {
			        	var2=Float.parseFloat(this.t.getVariable(dos).getValor());
			        	//System.out.println("se pudo");
			        }
			        catch (Exception e) {
			        	var2=Float.parseFloat(dos);
			        	//System.out.println("no pudo");
			        } 
				}
				
			}else {
				//this.i=i+0;
				while(Tuplas.get(this.i).getType()!="fin-mientras") {
				
					Tuplas.remove(this.i);
				}
				
			}
		}break;
		case "<=":{
			if(var1<=var2) {
				
				while(var1<=var2) {
					
					for(int j=1;j<Tupla.size();j++) {
						
						ejecuta(Tupla.get(j));
						//System.out.println(Tupla.get(j).toString());
						
					}
			        try {
			        	var1=Float.parseFloat(this.t.getVariable(uno).getValor());
			        	//System.out.println("se pudo");
			        }
			        catch (Exception e) {
			        	var1=Float.parseFloat(uno);
			        	//System.out.println("no pudo");
			        } 
					
			        try {
			        	var2=Float.parseFloat(this.t.getVariable(dos).getValor());
			        	//System.out.println("se pudo");
			        }
			        catch (Exception e) {
			        	var2=Float.parseFloat(dos);
			        	//System.out.println("no pudo");
			        } 
				}
				
			}else {
				//this.i=i+0;
				while(Tuplas.get(this.i).getType()!="fin-mientras") {
				
					Tuplas.remove(this.i);
				}
				
			}}
		break;
		case ">=":{
			if(var1>=var2) {
				
				while(var1>=var2) {
					
					for(int j=1;j<Tupla.size();j++) {
						
						ejecuta(Tupla.get(j));
						//System.out.println(Tupla.get(j).toString());
						
					}
			        try {
			        	var1=Float.parseFloat(this.t.getVariable(uno).getValor());
			        	//System.out.println("se pudo");
			        }
			        catch (Exception e) {
			        	var1=Float.parseFloat(uno);
			        	//System.out.println("no pudo");
			        } 
					
			        try {
			        	var2=Float.parseFloat(this.t.getVariable(dos).getValor());
			        	//System.out.println("se pudo");
			        }
			        catch (Exception e) {
			        	var2=Float.parseFloat(dos);
			        	//System.out.println("no pudo");
			        }
				}
				
			}else {
				//this.i=i+0;
				while(Tuplas.get(this.i).getType()!="fin-mientras") {
				
					Tuplas.remove(this.i);
				}
				
			}
		}break;
		case "<":{
			if(var1<var2) {
				//ArrayList<Tuple> ttt = new ArrayList<Tuple>();
				while(var1<var2) {
					//System.out.println(var1+" < " + var2);
					for(int j=1;j<Tupla.size();j++) {
						
						ejecuta(Tupla.get(j));
						//System.out.println(Tupla.get(j).toString());
			
					}
					 try {
				        	var1=Float.parseFloat(this.t.getVariable(uno).getValor());
				        	//System.out.println("se pudo");
				        }
				        catch (Exception e) {
				        	var1=Float.parseFloat(uno);
				        	//System.out.println("no pudo");
				        } 
						
				        try {
				        	var2=Float.parseFloat(this.t.getVariable(dos).getValor());
				        	//System.out.println("se pudo");
				        }
				        catch (Exception e) {
				        	var2=Float.parseFloat(dos);
				        	//System.out.println("no pudo");
				        }

				}
				
			}else {
				//this.i=i+0;
				while(Tuplas.get(this.i).getType()!="fin-mientras") {
				
					Tuplas.remove(this.i);
				}
				
			}
		}break;
		case ">":{
			if(var1>var2) {
				
				while(var1>var2) {
					int j=1;
					for(j=1;j<Tupla.size();j++) {
						
						ejecuta(Tupla.get(j));
						//System.out.println(Tupla.get(j).toString());
						
					}
			        try {
			        	var1=Float.parseFloat(this.t.getVariable(uno).getValor());
			        	//System.out.println("se pudo");
			        }
			        catch (Exception e) {
			        	var1=Float.parseFloat(uno);
			        	//System.out.println("no pudo");
			        } 
					
			        try {
			        	var2=Float.parseFloat(this.t.getVariable(dos).getValor());
			        	//System.out.println("se pudo");
			        }
			        catch (Exception e) {
			        	var2=Float.parseFloat(dos);
			        	//System.out.println("no pudo");
			        } 
				}
				
			}else {
				//this.i=i+0;
				while(Tuplas.get(this.i).getType()!="fin-mientras") {
				
					Tuplas.remove(this.i);
				}
				
			}
		}break;
		}
		
	}
	}
	
	public void Escribir() {
		//System.out.println("entro a escribir");
		ArrayList<Token> tokens = new ArrayList<Token>();
		if(input.getToke().type==Token.TokenType.ESCRIBIR) {
			tokens.add(input.getToke());
			//System.out.println(input.getToke().data);
			consume();
			if(input.getToke().type==Token.TokenType.CADENA) {
			//	System.out.println(input.getToke().type);
				tokens.add(input.getToke());
				consume();
				if(input.getToke().type==Token.TokenType.COMA) {
					tokens.add(input.getToke());
					
					//System.out.println("coma");
					consume();
					if(input.getToke().type==Token.TokenType.VARIABLE) {
						tokens.add(input.getToke());
						//System.out.println("Entro a variable escribir");
						
						Tuple t= new Tuple("Escribir",tokens,1,1);
						Tuplas.add(t);
						consume();
					}
					
				}else {
					
					Tuple t= new Tuple("Escribir",tokens, 1, 1);
					Tuplas.add(t);
					//System.out.println("guardo sin coma");
				}
			}
		}else {
			System.out.println("error");
		}
	}
	
	public void CrearTuplas() {
		InicioPrograma();
		ArrayList<Token> tokens1 = new ArrayList<Token>();
		ArrayList<Token> tokens3 = new ArrayList<Token>();
		//System.out.println(input.getToke().toString());
		switch(input.getToke().type.toString()) {
		case  "VARIABLE":{
			consume();
			if(input.getToke().type==Token.TokenType.DOSPUNTOS) {
				menosConsume();
				Declaraciones(tokens1,"null");
				CrearTuplas();
			}else if(input.getToke().type==Token.TokenType.IGUAL) {
				menosConsume();
				operacion();
			
				CrearTuplas();
			}
			
			}break;
		case "LEER":{
			Leer();
			CrearTuplas();
		}break;
		case "ESCRIBIR":{
			Escribir();
			CrearTuplas();
		}
		
		case "MIENTRAS":{
			CondicionWhile();
			CrearTuplas();
		}break;
		case "SI":{
			CodicionIf();
			CrearTuplas();
		}break;
		case "FINPROGRAMA":{
			FinPrograma();
		}
		}
			

		//System.out.println(Tuplas.toString());
	}

	public void CrearTuplasIf() {
		
		ArrayList<Token> tokens1 = new ArrayList<Token>();
		ArrayList<Token> tokens3 = new ArrayList<Token>();
		
		//System.out.println("el token es "+input.getToke().toString());

		switch(input.getToke().type.toString()) {
		case  "VARIABLE":{
			consume();
			if(input.getToke().type==Token.TokenType.DOSPUNTOS) {
				menosConsume();
				Declaraciones(tokens1,"null");
				CrearTuplasIf();
			}else if(input.getToke().type==Token.TokenType.IGUAL) {
				menosConsume();
				operacion();
			
				CrearTuplasIf();
			}
			
			}break;
		case "LEER":{
			Leer();
			CrearTuplasIf();
		}break;
		case "ESCRIBIR":{
			Escribir();
			CrearTuplasIf();
			
		}
		
		case "MIENTRAS":{
			CondicionWhile();
			CrearTuplasIf();
		}break;
		case "SI":{
			CodicionIf();
			CrearTuplasIf();
		}break;
		case "FINSI":{
			//System.out.println(input.getToke().toString());
			TuplafinSi();
		}
		}
			

		//System.out.println(Tuplas.toString());
	}
	
	public void CrearTuplasWhile() {
		
		ArrayList<Token> tokens1 = new ArrayList<Token>();
		ArrayList<Token> tokens3 = new ArrayList<Token>();
		
		System.out.println("el token es "+input.getToke().toString());
		
		switch(input.getToke().type.toString()) {
		case  "VARIABLE":{
			consume();
			if(input.getToke().type==Token.TokenType.DOSPUNTOS) {
				menosConsume();
				Declaraciones(tokens1,"null");
				CrearTuplasIf();
			}else if(input.getToke().type==Token.TokenType.IGUAL) {
				menosConsume();
				operacion();
			
				CrearTuplasWhile();
			}
			
			}break;
		case "LEER":{
			Leer();
			CrearTuplasWhile();
		}break;
		case "ESCRIBIR":{
			Escribir();
			CrearTuplasWhile();
			
		}
		
		case "MIENTRAS":{
			CondicionWhile();
			CrearTuplasWhile();
		}break;
		case "SI":{
			CodicionIf();
			CrearTuplasWhile();
		}break;
		case "FINMIENTRAS":{
			//System.out.println("es este "+input.getToke().toString());
			finwhile();
		}
		}
			

		//System.out.println(Tuplas.toString());
	}
	
	public void finwhile() {
		if(input.getToke().type==Token.TokenType.FINMIENTRAS) {
			ArrayList<Token> tokens = new ArrayList<Token>();
			tokens.add(input.getToke());
			Tuple t= new Tuple("fin-mientras",tokens, 1, 1);
			Tuplas.add(t);
			consume();
			
		}
	}
	
	public void operacion() {
		String Nombre;
		String ValorVar;
		int opera;
		float operaflotante;
		int resultado;
		float resultado2;
		ArrayList<Token> tokens = new ArrayList<Token>();
		if(input.getToke().type==Token.TokenType.VARIABLE) {
			String nombreVar=input.getToke().data;
			Nombre=input.getToke().data;
			tokens.add(input.getToke());
			consume();
			if(input.getToke().type==Token.TokenType.IGUAL) {
				tokens.add(input.getToke());
				consume();
				if((input.getToke().type==Token.TokenType.NUMERO)) {
				//		System.out.println("paso el numero");
						ValorVar=input.getToke().data.toString();
						
						t.CambiarValor(Nombre, ValorVar);
						tokens.add(input.getToke());
						consume();
						if(input.getToke().type==Token.TokenType.OPARITMETICO) {
					//		System.out.println("paso operaritmetico"+input.getToke().data);
							tokens.add(input.getToke());
							switch(input.getToke().data.toString()) {
							case "+":{
						//		System.out.println("paso +");
								if(this.t.getVariable(Nombre).getTipo().equals("entero")){
							//		System.out.println("paso entero");
									opera=Integer.parseInt(this.t.getVariable(Nombre).getValor());
									consume();
									if((input.getToke().type==Token.TokenType.NUMERO)) {
								//		System.out.println("paso numero");
									//	System.out.println(input.data);
										tokens.add(input.getToke());
										resultado=opera+Integer.parseInt(input.getToke().data);
										t.CambiarValor(nombreVar, String.valueOf(resultado));
									}else if((input.getToke().type==Token.TokenType.VARIABLE)) {
										
										resultado=opera+Integer.parseInt(t.TomarValor(input.getToke().data));
										//System.out.println("El resultado "+resultado);
										tokens.add(input.getToke());
										t.CambiarValor(nombreVar, String.valueOf(resultado));
									}
								}else if(this.t.getVariable(Nombre).getTipo().equals("flotante")){

//									System.out.println("paso Flotante");
									operaflotante=Float.parseFloat(this.t.getVariable(Nombre).getValor());
									consume();
									if((input.getToke().type==Token.TokenType.NUMERO)) {
	//									System.out.println("paso numero");
		//								System.out.println(input.data);
										tokens.add(input.getToke());
										resultado2=operaflotante+Float.parseFloat(input.getToke().data);
										t.CambiarValor(Nombre, String.valueOf(resultado2));
									}else if((input.getToke().type==Token.TokenType.VARIABLE)) {
										tokens.add(input.getToke());
										resultado2=operaflotante+Float.parseFloat(t.TomarValor(input.getToke().data));
										t.CambiarValor(Nombre, String.valueOf(resultado2));
									}
								
								}
								
								
							}break;
							case "_":{
			//					System.out.println("paso -");
								if(this.t.getVariable(Nombre).getTipo().equals("entero")){
				//					System.out.println("paso entero");
									opera=Integer.parseInt(this.t.getVariable(Nombre).getValor());
									consume();
									if((input.getToke().type==Token.TokenType.NUMERO)) {
					//					System.out.println("paso numero");
						//				System.out.println(input.data);
										tokens.add(input.getToke());
										resultado=opera-Integer.parseInt(input.getToke().data);
										t.CambiarValor(Nombre, String.valueOf(resultado));
									}else if((input.getToke().type==Token.TokenType.VARIABLE)) {
										tokens.add(input.getToke());
										resultado=opera-Integer.parseInt(t.TomarValor(input.getToke().data));
										t.CambiarValor(Nombre, String.valueOf(resultado));
									}
								}else if(this.t.getVariable(Nombre).getTipo().equals("flotante")){

//									System.out.println("paso Flotante");
									operaflotante=Float.parseFloat(this.t.getVariable(Nombre).getValor());
									consume();
									if((input.getToke().type==Token.TokenType.NUMERO)) {
	//									System.out.println("paso numero");
		//								System.out.println(input.data);
										tokens.add(input.getToke());
										resultado2=(operaflotante)-(Float.parseFloat(input.getToke().data));
										t.CambiarValor(Nombre, String.valueOf(resultado2));
									}else if((input.getToke().type==Token.TokenType.VARIABLE)) {
										tokens.add(input.getToke());
										resultado2=operaflotante-Float.parseFloat(t.TomarValor(input.getToke().data));
										t.CambiarValor(Nombre, String.valueOf(resultado2));
									}
								
								}
								
							}break;
							case "*":{
			//					System.out.println("paso *");
								if(this.t.getVariable(Nombre).getTipo().equals("entero")){
				//					System.out.println("paso entero");
									opera=Integer.parseInt(this.t.getVariable(Nombre).getValor());
									consume();
									if((input.getToke().type==Token.TokenType.NUMERO)) {
//										System.out.println("paso numero");
	//									System.out.println(input.data);
										tokens.add(input.getToke());
										resultado=opera*Integer.parseInt(input.getToke().data);
										t.CambiarValor(Nombre, String.valueOf(resultado));
									}else if((input.getToke().type==Token.TokenType.VARIABLE)) {
										tokens.add(input.getToke());
										resultado=opera*Integer.parseInt(t.TomarValor(input.getToke().data));
										t.CambiarValor(Nombre, String.valueOf(resultado));
									}
								}else if(this.t.getVariable(Nombre).getTipo().equals("flotante")){

		//							System.out.println("paso Flotante");
									operaflotante=Float.parseFloat(this.t.getVariable(Nombre).getValor());
									consume();
									if((input.getToke().type==Token.TokenType.NUMERO)) {
			//							System.out.println("paso numero");
				//						System.out.println(input.data);
										tokens.add(input.getToke());
										resultado2=operaflotante*Float.parseFloat(input.getToke().data);
										t.CambiarValor(Nombre, String.valueOf(resultado2));
									}else if((input.getToke().type==Token.TokenType.VARIABLE)) {
										tokens.add(input.getToke());
										resultado2=operaflotante*Float.parseFloat(t.TomarValor(input.getToke().data));
										t.CambiarValor(Nombre, String.valueOf(resultado2));
									}
								
								}
							}break;
							case "/":{
//								System.out.println("paso /");
								if(this.t.getVariable(Nombre).getTipo().equals("entero")){
	//								System.out.println("paso entero");
									opera=Integer.parseInt(this.t.getVariable(Nombre).getValor());
									consume();
									if((input.getToke().type==Token.TokenType.NUMERO)) {
		//								System.out.println("paso numero");
			//							System.out.println(input.data);
										tokens.add(input.getToke());
										resultado=opera/Integer.parseInt(input.getToke().data);
										t.CambiarValor(Nombre, String.valueOf(resultado));
									}else if((input.getToke().type==Token.TokenType.VARIABLE)) {
										tokens.add(input.getToke());
										resultado=opera/Integer.parseInt(t.TomarValor(input.getToke().data));
										t.CambiarValor(Nombre, String.valueOf(resultado));
									}
								}else if(this.t.getVariable(Nombre).getTipo().equals("flotante")){

	//								System.out.println("paso Flotante");
									operaflotante=Float.parseFloat(this.t.getVariable(Nombre).getValor());
									consume();
									if((input.getToke().type==Token.TokenType.NUMERO)) {
		//								System.out.println("paso numero");
			//							System.out.println(input.data);
										tokens.add(input.getToke());
										resultado2=operaflotante/Float.parseFloat(input.getToke().data);
										t.CambiarValor(Nombre, String.valueOf(resultado2));
									}else if((input.getToke().type==Token.TokenType.VARIABLE)) {
										tokens.add(input.getToke());
										resultado2=operaflotante+Float.parseFloat(t.TomarValor(input.getToke().data));
										t.CambiarValor(Nombre, String.valueOf(resultado2));
									}
								
								}
							}break;
							}Tuple t= new Tuple("operacion",tokens, 1, 1);
							Tuplas.add(t);	
							consume();
						}
						
				}else if((input.getToke().type==Token.TokenType.VARIABLE)) {
					///////////////////////////variables////////////////////////////////////////77
					/////////////////////////////////////////////////////////////////////////////7
//					System.out.println("paso el Variable");
					ValorVar=t.TomarValor(input.getToke().data);
//					System.out.println("el valor de variable es"+ValorVar);
					tokens.add(input.getToke());
					consume();
					if(input.getToke().type==Token.TokenType.OPARITMETICO) {
//						System.out.println("paso operaritmetico"+input.getToke().data);
						tokens.add(input.getToke());
						switch(input.getToke().data.toString()) {
						case "+":{
//							System.out.println("paso +");
							if(this.t.getVariable(Nombre).getTipo().equals("entero")){
//								System.out.println("paso entero");
								opera=Integer.parseInt(ValorVar);
								consume();
								if((input.getToke().type==Token.TokenType.NUMERO)) {
//									System.out.println("paso numero");
//									System.out.println(input.data);
									tokens.add(input.getToke());
									resultado=opera+Integer.parseInt(input.getToke().data);
									t.CambiarValor(Nombre, String.valueOf(resultado));
								}else if((input.getToke().type==Token.TokenType.VARIABLE)) {
									tokens.add(input.getToke());
									resultado=opera+Integer.parseInt(t.TomarValor(input.getToke().data));
									t.CambiarValor(Nombre, String.valueOf(resultado));
								}
							}else if(this.t.getVariable(Nombre).getTipo().equals("flotante")){

//								System.out.println("paso Flotante");
								operaflotante=Float.parseFloat(ValorVar);
								consume();
								if((input.getToke().type==Token.TokenType.NUMERO)) {
									tokens.add(input.getToke());
//									System.out.println("paso numero");
//									System.out.println(input.data);
									resultado2=operaflotante+Float.parseFloat(input.getToke().data);
									t.CambiarValor(Nombre, String.valueOf(resultado2));
								}else if((input.getToke().type==Token.TokenType.VARIABLE)) {
									tokens.add(input.getToke());
									resultado2=operaflotante+Float.parseFloat(t.TomarValor(input.getToke().data));
									t.CambiarValor(Nombre, String.valueOf(resultado2));
								}
							
							}
							
							
						}break;
						case "_":{
//							System.out.println("paso -");
							if(this.t.getVariable(Nombre).getTipo().equals("entero")){
//								System.out.println("paso entero");
								opera=Integer.parseInt(ValorVar);
								consume();
								if((input.getToke().type==Token.TokenType.NUMERO)) {
									tokens.add(input.getToke());
//									System.out.println("paso numero");
//									System.out.println(input.data);
									resultado=opera-Integer.parseInt(input.getToke().data);
									t.CambiarValor(Nombre, String.valueOf(resultado));
								}else if((input.getToke().type==Token.TokenType.VARIABLE)) {
									tokens.add(input.getToke());
									resultado=opera-Integer.parseInt(t.TomarValor(input.getToke().data));
									t.CambiarValor(Nombre, String.valueOf(resultado));
								}
							}else if(this.t.getVariable(Nombre).getTipo().equals("flotante")){

//								System.out.println("paso Flotante");
								operaflotante=Float.parseFloat(this.t.getVariable(Nombre).getValor());
								consume();
								if((input.getToke().type==Token.TokenType.NUMERO)) {
//									System.out.println("paso numero");
//									System.out.println(input.data);
									tokens.add(input.getToke());
									resultado2=(operaflotante)-(Float.parseFloat(input.getToke().data));
									t.CambiarValor(Nombre, String.valueOf(resultado2));
							}else if((input.getToke().type==Token.TokenType.VARIABLE)) {
								tokens.add(input.getToke());
								resultado2=operaflotante-Float.parseFloat(t.TomarValor(input.getToke().data));
								t.CambiarValor(Nombre, String.valueOf(resultado2));
							}
							
							}
							
						}break;
						case "*":{
//							System.out.println("paso *");
							if(this.t.getVariable(Nombre).getTipo().equals("entero")){
//								System.out.println("paso entero");
								opera=Integer.parseInt(ValorVar);
								consume();
								if((input.getToke().type==Token.TokenType.NUMERO)) {
//									System.out.println("paso numero");
//									System.out.println(input.data);
									tokens.add(input.getToke());
									resultado=opera*Integer.parseInt(input.getToke().data);
									t.CambiarValor(Nombre, String.valueOf(resultado));
								}else if((input.getToke().type==Token.TokenType.VARIABLE)) {
									tokens.add(input.getToke());
									resultado=opera*Integer.parseInt(t.TomarValor(input.getToke().data));
									t.CambiarValor(Nombre, String.valueOf(resultado));
								}
							}else if(this.t.getVariable(Nombre).getTipo().equals("flotante")){

//								System.out.println("paso Flotante");
								operaflotante=Float.parseFloat(this.t.getVariable(Nombre).getValor());
								consume();
								if((input.getToke().type==Token.TokenType.NUMERO)) {
//									System.out.println("paso numero");
//									System.out.println(input.data);
									tokens.add(input.getToke());
									resultado2=operaflotante*Float.parseFloat(input.getToke().data);
									t.CambiarValor(Nombre, String.valueOf(resultado2));
							}else if((input.getToke().type==Token.TokenType.VARIABLE)) {
								tokens.add(input.getToke());
								resultado2=operaflotante*Float.parseFloat(t.TomarValor(input.getToke().data));
								t.CambiarValor(Nombre, String.valueOf(resultado2));
							}
							
							}
						}break;
						case "/":{
//							System.out.println("paso /");
							if(this.t.getVariable(Nombre).getTipo().equals("entero")){
//								System.out.println("paso entero");
								opera=Integer.parseInt(ValorVar);
								consume();
								if((input.getToke().type==Token.TokenType.NUMERO)) {
//									System.out.println("paso numero");
//									System.out.println(input.data);
									tokens.add(input.getToke());
									resultado=opera/Integer.parseInt(input.getToke().data);
									t.CambiarValor(Nombre, String.valueOf(resultado));
								}else if((input.getToke().type==Token.TokenType.VARIABLE)) {
									tokens.add(input.getToke());
									resultado=opera/Integer.parseInt(t.TomarValor(input.getToke().data));
									t.CambiarValor(Nombre, String.valueOf(resultado));
								}
							}else if(this.t.getVariable(Nombre).getTipo().equals("flotante")){

//								System.out.println("paso Flotante");
								operaflotante=Float.parseFloat(this.t.getVariable(Nombre).getValor());
								consume();
								if((input.getToke().type==Token.TokenType.NUMERO)) {
//									System.out.println("paso numero");
//									System.out.println(input.data);
									tokens.add(input.getToke());
									resultado2=operaflotante/Float.parseFloat(input.getToke().data);
									t.CambiarValor(Nombre, String.valueOf(resultado2));
							}else if((input.getToke().type==Token.TokenType.VARIABLE)) {
								tokens.add(input.getToke());
								resultado2=operaflotante/Float.parseFloat(t.TomarValor(input.getToke().data));
								t.CambiarValor(Nombre, String.valueOf(resultado2));
							}
							
							}
						}break;
						}Tuple t= new Tuple("operacion",tokens, 1, 1);
						Tuplas.add(t);
						consume();
		
					}	
			}
			}
		}
	}
	
	public void asignacion() {
		String Nombre;
		String ValorVar;
		if(input.getToke().type==Token.TokenType.VARIABLE) {
			
			Nombre=input.getToke().data.toString();
			
			consume();
			if(input.getToke().type==Token.TokenType.IGUAL) {
				consume();
				if((input.getToke().type==Token.TokenType.NUMERO)) {
					
						ValorVar=input.getToke().data.toString();
						
						t.CambiarValor(Nombre, ValorVar);
						consume();
						
				}else if((input.getToke().type==Token.TokenType.VARIABLE)) {
					
					ValorVar=t.TomarValor(input.getToke().data);
				
					t.CambiarValor(Nombre, ValorVar);
					consume();
					
			}
			}
		}
	}
	
	private void FinPrograma() {
		
		if(input.getToke().type==Token.TokenType.FINPROGRAMA) {
			ArrayList<Token> tokens = new ArrayList<Token>();
			tokens.add(input.getToke());
			Tuple t= new Tuple("fin-programa",tokens, 1, 1);
			Tuplas.add(t);
		
			
		}
		
	}
	
	public void Asignacion(String Nombre,String ValorVar) {
		
		if(input.getToke().type==Token.TokenType.VARIABLE) {
			
			Nombre=input.getToke().data.toString();
			
			consume();
			if(input.getToke().type==Token.TokenType.IGUAL) {
				consume();
				if((input.getToke().type==Token.TokenType.NUMERO)) {
					
						ValorVar=input.getToke().data.toString();
						
						t.CambiarValor(Nombre, ValorVar);
						consume();
						
				}else if((input.getToke().type==Token.TokenType.VARIABLE)) {
					
					ValorVar=t.TomarValor(input.getToke().data);
				
					t.CambiarValor(Nombre, ValorVar);
					consume();
					
			}
			}
		}
		
	}
	
	public void CodicionIf() {
		ArrayList<Token> tokens = new ArrayList<Token>();
		
		if(input.getToke().type==Token.TokenType.SI) {
			tokens.add(input.getToke());consume();
			if(input.getToke().type==Token.TokenType.PARENTESISIZQ){
				tokens.add(input.getToke());consume();
				if(input.getToke().type==Token.TokenType.VARIABLE) {
					tokens.add(input.getToke());consume();
					if(input.getToke().type==Token.TokenType.OPRELACIONAL) {
						tokens.add(input.getToke());consume();
						if(input.getToke().type==Token.TokenType.VARIABLE) {
							tokens.add(input.getToke());consume();
							if(input.getToke().type==Token.TokenType.PARENTESISDER) {
								tokens.add(input.getToke());consume();consume();
								
								/*
								while(input.getToke().type!=Token.TokenType.FINSI) {
								consume();
								}*/
								tokens.add(input.getToke());
								Tuple t= new Tuple("si",tokens,1,1);
								Tuplas.add(t);
								CrearTuplasIf();}
						}else if(input.getToke().type==Token.TokenType.NUMERO) {
							tokens.add(input.getToke());consume();
							if(input.getToke().type==Token.TokenType.PARENTESISDER) {
								tokens.add(input.getToke());consume();consume();
								
								/*
								while(input.getToke().type!=Token.TokenType.FINSI) {
								consume();
								}*/
								tokens.add(input.getToke());
								Tuple t= new Tuple("si",tokens,1,1);
								Tuplas.add(t);
								CrearTuplasIf();}
						}
						
						
					}
					
				}else if(input.getToke().type==Token.TokenType.NUMERO) {
					tokens.add(input.getToke());consume();
					if(input.getToke().type==Token.TokenType.OPRELACIONAL) {
						tokens.add(input.getToke());consume();
						if(input.getToke().type==Token.TokenType.VARIABLE) {
							tokens.add(input.getToke());consume();
							if(input.getToke().type==Token.TokenType.PARENTESISDER) {
								tokens.add(input.getToke());consume();consume();
								
								/*
								while(input.getToke().type!=Token.TokenType.FINSI) {
								consume();
								}*/
								tokens.add(input.getToke());
								Tuple t= new Tuple("si",tokens,1,1);
								Tuplas.add(t);
								CrearTuplasIf();}
						}else if(input.getToke().type==Token.TokenType.NUMERO) {
							tokens.add(input.getToke());consume();
							if(input.getToke().type==Token.TokenType.PARENTESISDER) {
								tokens.add(input.getToke());consume();consume();
								
								/*
								while(input.getToke().type!=Token.TokenType.FINSI) {
								consume();
								}*/
								tokens.add(input.getToke());
								Tuple t= new Tuple("si",tokens,1,1);
								Tuplas.add(t);
								CrearTuplasIf();}
						}
				}
				
			}
		}
	}
	}
	
	public void CondicionWhile() {
	ArrayList<Token> tokens = new ArrayList<Token>();
	System.out.print(input.getToke().toString());
	if(input.getToke().type==Token.TokenType.MIENTRAS) {
			tokens.add(input.getToke());consume();
			if(input.getToke().type==Token.TokenType.PARENTESISIZQ){
				tokens.add(input.getToke());consume();
				if(input.getToke().type==Token.TokenType.VARIABLE) {
					tokens.add(input.getToke());consume();
					if(input.getToke().type==Token.TokenType.OPRELACIONAL) {
						tokens.add(input.getToke());consume();
						if(input.getToke().type==Token.TokenType.VARIABLE) {
							tokens.add(input.getToke());consume();
							if(input.getToke().type==Token.TokenType.PARENTESISDER) {
								tokens.add(input.getToke());//consume();
								
								/*while(input.getToke().type!=Token.TokenType.FINMIENTRAS) {
									tokens.add(input.getToke());consume();
								}*/
								
								consume();
								Tuple t= new Tuple("while",tokens,1,1);
								Tuplas.add(t);
								CrearTuplasWhile();
								}
						}else if(input.getToke().type==Token.TokenType.NUMERO) {
							tokens.add(input.getToke());consume();
							if(input.getToke().type==Token.TokenType.PARENTESISDER) {
								tokens.add(input.getToke());consume();
								
								/*while(input.getToke().type!=Token.TokenType.FINMIENTRAS) {
									tokens.add(input.getToke());consume();
								}*/
								tokens.add(input.getToke());//consume();
								Tuple t= new Tuple("while",tokens,1,1);
								Tuplas.add(t);
								CrearTuplasWhile();
								}
						}
						
						
					}
					
				}else if(input.getToke().type==Token.TokenType.NUMERO) {
					tokens.add(input.getToke());consume();
					if(input.getToke().type==Token.TokenType.OPRELACIONAL) {
						tokens.add(input.getToke());consume();
						if(input.getToke().type==Token.TokenType.VARIABLE) {
							tokens.add(input.getToke());consume();
							if(input.getToke().type==Token.TokenType.PARENTESISDER) {
								tokens.add(input.getToke());consume();
								Tuple t= new Tuple("while",tokens,1,1);
								Tuplas.add(t);
								CrearTuplasWhile();}
						}else if(input.getToke().type==Token.TokenType.NUMERO) {
							tokens.add(input.getToke());consume();
							if(input.getToke().type==Token.TokenType.PARENTESISDER) {
								tokens.add(input.getToke());consume();
								Tuple t= new Tuple("while",tokens,1,1);
								Tuplas.add(t);
								CrearTuplasWhile();}
						}
				}
				
			}
		}
	}
}
		
	public void TuplafinSi() {
	if(input.getToke().type==Token.TokenType.FINSI) {
		ArrayList<Token> tokens = new ArrayList<Token>();
		tokens.add(input.getToke());
		Tuple t= new Tuple("fin-si",tokens, 1, 1);
		Tuplas.add(t);
		consume();	
	}
}

	public void Leer() {
		ArrayList<Token> tokens = new ArrayList<Token>();
		if(input.getToke().type==Token.TokenType.LEER) {
			tokens.add(input.getToke());
			//System.out.println(input.getToke().data);
			consume();
			if(input.getToke().type==Token.TokenType.CADENA) {
				tokens.add(input.getToke());
				consume();
				if(input.getToke().type==Token.TokenType.COMA) {
					tokens.add(input.getToke());
					consume();
					if(input.getToke().type==Token.TokenType.VARIABLE) {
						tokens.add(input.getToke());
						consume();
						Tuple t= new Tuple("Leer",tokens,1,1);
						Tuplas.add(t);
					}
					
				}else {
					Tuple t= new Tuple("Leer",tokens, 1, 1);
					Tuplas.add(t);
				}
			}
		}else {
			System.out.println("error");
		}
	}
	
	public void Declaraciones(ArrayList<Token> tokens,String var) {
		String Tipo="";
		String Valor="1";
		String Nombre="";
		
		if(input.getToke().type==Token.TokenType.VARIABLE) {
			tokens.add(input.getToke());
			Nombre=input.getToke().data;
			consume();
			if(input.getToke().type==Token.TokenType.COMA) {
				tokens.add(input.getToke());
				this.t.AgregarVariable(new Variables(Nombre,var,Valor));
				consume();
				Declaraciones(tokens,var);
			}else if(input.getToke().type==Token.TokenType.DOSPUNTOS) {
				tokens.add(input.getToke());
				consume();
				if(input.getToke().type==Token.TokenType.TIPOS) {
					tokens.add(input.getToke());
					Declaraciones(tokens,input.getToke().data);
					Tipo=input.getToke().data.toString();
					consume();
					this.t.AgregarVariable(new Variables(Nombre,Tipo,Valor));
				}
			}
			
		}else {
			//Tuple t= new Tuple("Declaraciones",tokens, 1, 1);
			//Tuplas.add(t);
		}
		
	}

	public void InicioPrograma() {
		
		if(input.getToke().type==Token.TokenType.INICIOPROGRAMA) {
			ArrayList<Token> tokens = new ArrayList<Token>();
			tokens.add(input.getToke());
			Tuple t= new Tuple("inicio-programa",tokens, 1, 1);
			Tuplas.add(t);
			consume();
			
		}

		}

 
 
	
}