
public interface Scope{
	public String getScopeName();
	public Scope getEnclosinScope();
	public void define(Symbol sym);
	public Symbol resolve(String name);

}
