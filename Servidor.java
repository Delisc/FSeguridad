import java.net.InetAddress;

import java.net.*;

import java.io.*;
import java.lang.management.*;
public class Servidor{
   
   public static void main(String args[]){
		InetAddress pc;

		try {

			int puerto = 5000;
			ServerSocket sock = new ServerSocket(puerto); //Abrir Socket
			String comandoSalir = "Exit";
			String entrada = "";
			System.out.println("Servidor iniciado en el puerto " + puerto + "...");
			while(true){
				Socket sock1 = sock.accept();       //Espera de la petición
				System.out.println("Aceptando conexion...");
				PrintWriter out = new PrintWriter(sock1.getOutputStream(), true);
				BufferedReader in = new BufferedReader(new InputStreamReader(sock1.getInputStream())); //permite leer entrada de datos
				pc = InetAddress.getLocalHost();  // Creación de objeto tipo InetAddress
				
				
				while ((entrada = in.readLine()) != null) {					
				    System.out.println(entrada);
			    	String pathDesktop = System.getProperty("user.home") + "\\Desktop\\";
				    out.println("Hola desde el  servidor! -> " + pathDesktop);
					
					//String direc = pc.getHostAddress();
					

				   pc = InetAddress.getLocalHost();  // Creación de objeto tipo InetAddress
				   
				   System.out.println("PC: "+pc);
				   System.out.println("Dirección IP : "+pc.getHostAddress());
				   System.out.println("Usuario: "+pc.getHostName());
				   System.out.println("Conexión de equipo: "+pc.getCanonicalHostName());
				  
				    if (entrada.trim().equals(comandoSalir))
				        return;
				} 
				sock1.close();
				   
			}

		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}


}