package contador;

import java.io.IOException;
import java.util.Scanner;

public class ControlCarpetas {

	public static void main(String[] args) {
		ControlCarpetas control = new ControlCarpetas();
		try {
			control.contarPalabraenCarpeta();
			//control.prueba1();
			//control.prueba2();
			//control.prueba3();
		}
		catch(IOException err) {
			System.out.println("Error abriendo carpeta:" +err.toString());
		}
	}
	
	public void contarPalabraenCarpeta(String path, String palabra) throws IOException {
		Carpeta carpeta = new Carpeta(path);
		carpeta.contarPalabraCarpeta(palabra);		
	}
	
	public void contarPalabraenCarpeta() throws IOException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingresa la ruta completa del archivo:");
        String path = scanner.nextLine();
        System.out.println("Ingresa la palabra a buscar:");
        String palabra = scanner.nextLine();
        scanner.close();
        Carpeta carpeta = new Carpeta(path);
		carpeta.contarPalabraCarpeta(palabra);
        
	}
		
	public void prueba1() throws IOException {	
		System.out.println("Resultado prueba 1:");
        this.contarPalabraenCarpeta("Pruebas/pruebas1", "arar");
	}
	
	public void prueba2() throws IOException {
		System.out.println("Resultado prueba 2:");
		this.contarPalabraenCarpeta("Pruebas/pruebas2", "foto");
	}
	
	public void prueba3() throws IOException {
		System.out.println("Resultado prueba 3:");
		this.contarPalabraenCarpeta("Pruebas/pruebas3", "ejemplo");
	}	
	
}
