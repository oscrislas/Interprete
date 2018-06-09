import java.util.ArrayList;

public class TablaVariables {
	static ArrayList<Variables> var = new ArrayList<Variables>();
	int pos=0;


	public void AgregarVariable(Variables variable) {
		boolean existe = ExisteVariable(variable.getNombre());
		if(existe==true) {
			//System.out.println("La variable ya existe");
			//throw new Exception("La edad debe ser positiva.");
			
		}else {
			
			this.var.add(variable);
		
		}
	}
	
	public boolean ExisteVariable(String variable) {
		boolean existe=false;
		this.pos=0;
		int i=0;
		while(i<this.var.size()){
			if(this.var.get(i).getNombre().equals(variable)) {
				existe=true;
				//System.out.println("Existe la variable: "+variable);
				this.pos=i;
			}
			i++;
	
		}
		
		return existe;
	}
	public void CambiarValor(String nombre,String valor) {
	
		int i=0;
		int aux=0;
		
		boolean existe=false;
		if(valor!=null) {
			existe=ExisteVariable(nombre);
		
		}
		else {
			//System.out.println("valor no valido");
		}
		if(existe==true) {
			//System.out.println("Se ha cambiado la variable "+nombre+" por el valor "+valor +"y la posision es "+ aux);
			try {
				float auxx=Float.parseFloat(valor);
			}catch(ArrayIndexOutOfBoundsException excepcion){
				throw new Error("Error");
			}
			this.var.get(pos).setValor(valor);
		}else {
			//throw new Error("La variable no existe");
			//System.out.println("La variable "+nombre +" no existe");
		}
		
	}
	
	public String TomarValor(String nombre) {
		int i=0;
		int aux=0;
		boolean existe=false;
		while(i<this.var.size()) {
			if(this.var.get(i).getNombre().equals(nombre)) {
				existe=true;
				aux=i;
			
			}
		i++;
		}
		if(existe) {
			return this.var.get(aux).getValor();
		}else {
			return "Error la variable no existe";
		}
		
		
		
	}
	
	public Variables getVariable(String nombre) {
		int i=0;
		int aux=0;
		boolean existe=false;
		while(i<this.var.size()) {
			if(this.var.get(i).getNombre().equals(nombre)) {
				existe=true;
				aux=i;
			
			}
		i++;
		}
		if(existe) {
			return this.var.get(aux);
		}else {
			return null;
		}
	}
		
		
	
	
	public void ImprimeVariables() {
		int i=0;
		while(i<this.var.size()) {
			System.out.println("la variable es "+this.var.get(i).getNombre()+" de tipo "+this.var.get(i).getTipo()+" y su valor es : "+this.var.get(i).getValor());
			i++;
		}
	}

}