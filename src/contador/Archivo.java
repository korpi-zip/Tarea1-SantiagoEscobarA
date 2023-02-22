package contador;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Archivo {
	private String path;
	private String texto;

	public Archivo(String path) {
		this.path = path;
	}
		
	/**
	 * Lee el archivo ubicado en la ruta y lo guarda en texto
	 * @throws IOException
	 */
	public void leerArchivo() throws IOException {
        StringBuilder contenido = new StringBuilder();
        FileReader fr = new FileReader(this.path);
        
        BufferedReader br = new BufferedReader(fr);

        String linea;
        while ((linea = br.readLine()) != null) {
            contenido.append(linea).append("\n");
        }

        br.close();
        fr.close();

        this.texto=contenido.toString();
    }
	
	/**
	 * Cuenta cuantas veces se repite una palabra en el texto del archivo
	 * @param palabra
	 * @return int : numero de repeticiones
	 * @throws IOException 
	 */
	public int contarPalabra(String palabra) throws IOException {
	    this.leerArchivo();
		String[] palabras = this.texto.split("\\W+");
	    int contador = 0;
	    for (String p : palabras) {
	        if (p.equals(palabra)) {
	            contador++;
	        }
	    }
	    System.out.print(this.path +" "+ contador + " Veces \n");
	    return contador;
	}
	
	public Boolean esValido() {
		               	
        if (this.path.endsWith(".txt") || this.path.endsWith(".xml") ||
        	this.path.endsWith(".json") || this.path.endsWith(".csv")){
        	return true;
        }               
        return false;
	}
		
	
	
}
