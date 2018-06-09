import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class Test {
	private static final String FILENAME = "F:\\Descktop\\archivo.txt";
	
	
	public static String readFileAsString(String fileName)throws Exception
	  {
	    String data = null;
	    data = new String(Files.readAllBytes(Paths.get(fileName)));
	    return data;
	  }
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		String data = null;
		
		try {
			data = readFileAsString(FILENAME);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Token s;
		PseudoLexer lex1 = new PseudoLexer(data);
		PseudoLexer lex2 = new PseudoLexer(data);
		/*while((s=lex1.nextToken()) != null) {
			
			System.out.println(s);
		}*/
		
		lex1 = new PseudoLexer(data);
		Parser pp= new Parser(lex1);
		pp.programa();
		Ejecuta p = new Ejecuta(lex2);
		p.programa();
	
	
		
		
	}
	
}
