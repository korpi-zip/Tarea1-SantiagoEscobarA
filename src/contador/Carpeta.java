package contador;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Carpeta {
	
	private String path;	
	private ArrayList<String> archivos;
	
	public Carpeta(String path) {
		this.path = path;
		archivos = new ArrayList<>();
	}
		
	/**
	 * Metodo que llena el array archivos con los nombres de los archivos de texto validos
	 * imprime mensajes si hay errores en el proceso.
	 */
	public Boolean obtenerNombresArchivos() {
        ArrayList<String> nombresArchivos = new ArrayList<String>(); //Donde se almacenan los nombres de los archivos
        Boolean flag = true; //valor de retorno booleano
        File carpeta = new File(this.path); //para listar archivos

        if (carpeta.isDirectory()) {
        	
            File[] archivos = carpeta.listFiles();
            if (archivos.length==0) {
            	System.out.println("No se encontraron archivos de texto en la carpeta");
            	flag=false;
            }
            else {
            	for (File archivo : archivos) {            	
                    if (archivo.isFile()) {                	
                    	if (archivo.getName().endsWith(".txt") || archivo.getName().endsWith(".xml") ||
                    	archivo.getName().endsWith(".json") || archivo.getName().endsWith(".csv")){
                    		nombresArchivos.add(archivo.getName());
                    	}               
                    }
                }
                if (nombresArchivos.isEmpty()) {
                	System.out.println("No se encontraron archivos de texto en la carpeta");
                	flag=false;
                }
            }
            
            
        }
        else {
        	System.out.println("No se encuentra la carpeta: "+this.path);
        	flag=false;
        }

        this.archivos= nombresArchivos;
        return flag;
    }
	
	/**
	 * Imprime el numero de veces que se repite una palabra
	 * @param Palabra a buscar
	 * @throws IOException 
	 */	
	public void contarPalabraCarpeta(String palabra) throws IOException {
		
		if (this.obtenerNombresArchivos()) {
			int contador=0;
			for (String archivo : this.archivos) {			
				Archivo documento = new Archivo(this.path+"/"+archivo);			
				contador = contador + documento.contarPalabra(palabra);
			}
			System.out.println(contador);
		}
		
		
	}
	
	
	//Setters and getters
	
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public ArrayList<String> getArchivos() {
		return archivos;
	}

	public void setArchivos(ArrayList<String> archivos) {
		this.archivos = archivos;
	}
	
	
	
}
