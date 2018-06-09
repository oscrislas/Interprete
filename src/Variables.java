
public class Variables {
	
	private String tipo=null;
	private String Nombre=null;
	private String valor=null;
public Variables() {
	this.tipo=null;
	this.valor="";
	this.Nombre=null;
}
public Variables(String Nombre,String tipo,String valor) {
	this.tipo=tipo;
	this.setNombre(Nombre);
	this.valor=valor;
}

public Variables(String Nombre,String Tipo) {
	this.Nombre=Nombre;
	this.tipo=Tipo;
}

public String getTipo() {
	return tipo;
}
public void setTipo(String tipo2) {
	this.tipo = tipo2;
}

public String getNombre() {
	return Nombre;
}

public void setNombre(String nombre) {
	Nombre = nombre;
}
public String getValor() {
	return valor;
}
public void setValor(final String valor) {
	this.valor = valor;
}


}