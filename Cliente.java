import java.io.*;
import java.net.*;

public class Cliente{
    public static void main(String[] args) {
      String servidor = "127.0.0.1";
      String cadena;
      int puerto = 5000;
      try{
        Socket socket1= new Socket (servidor,puerto);
        BufferedReader in = new BufferedReader (new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(socket1.getOutputStream(),true);
	    DataInputStream	respuesta = new DataInputStream(socket1.getInputStream());

        do{
            System.out.print("Petición: ");
            cadena = in.readLine();
            String cadena1 = "";
            out.println(cadena);
            if ((cadena.trim().toUpperCase()).equals("nombre")){
                cadena1 = "Nombre";                  
            } else if ((cadena.trim().toUpperCase()).equals("unidad")){
                cadena1 = "Unidades";                                                        
            } else if ((cadena.trim().toUpperCase()).equals("usuario")){
                cadena1 = "Nombre de usuario";
            }
            System.out.println(cadena1+" = "+respuesta.readUTF());            
   	}while(!(cadena.trim().equals("SALIR")));     
	socket1.close();
	out.close();
	in.close();
	respuesta.close();
      } catch (IOException e) {
       	        System.out.println("Error en conexión!!!");
      }
      
    }
}
