import java.net.InetAddress;
import java.net.*;
import java.io.*;
import java.util.*;
import javax.swing.filechooser.FileSystemView;
import java.lang.management.*;
public class Servidor{
   
   public static void main(String args[]){

		try {

			int puerto = 5000;
			ServerSocket socket= new ServerSocket(puerto); 
                        String cadena;
			System.out.println("Servidor iniciado en el puerto " + puerto + "...");
			Socket cliente = socket.accept();
                        System.out.println("conexion...");
                        BufferedReader entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
                        DataOutputStream respuesta = new DataOutputStream(cliente.getOutputStream());
                        do{
                        cadena = entrada.readLine();
                        System.out.println("Peticion:" + cadena);
                        if ((cadena.trim().toUpperCase()).equals("nombre")){

                         InetAddress direccionLocal = InetAddress.getLocalHost();
                                    String nombre = direccionLocal.getHostName();
                                    System.out.println("Nombre de máquina:" + nombre);
                                    respuesta.writeUTF(nombre);
                               
                                    } else if ((cadena.trim().toUpperCase()).equals("unidad")){
                                    File unidades[];
                                    unidades = File.listRoots();
                                    String Tunidades= "";

                                    for (int i=0;i<unidades.length;i++) {
                                         String unidad = FileSystemView.getFileSystemView().getSystemDisplayName (unidades[i]);
                                         String carac = FileSystemView.getFileSystemView().getSystemTypeDescription(unidades[i]);                                        
                                         System.out.println("["+unidad +" , " +carac+ "]");                                         
                                         Tunidades = Tunidades + "["+unidad +" , " +carac+ "]";
                                    }     
                                    respuesta.writeUTF(Tunidades); 

                                    } else if ((cadena.trim().toUpperCase()).equals("usuario")){
                                    String nombreU = System.getProperty("user.name");
                                    System.out.println(nombreU);
                                    respuesta.writeUTF(nombreU);                                                                        
                                }					
                                
   			        }while(!(cadena.trim().equals("salir")));
                             entrada.close();
   			     cliente.close();
   			     socket.close();
                             if (cadena.trim().equals("salir"))
                            return;
		            } catch (IOException e) {//Error
			    e.printStackTrace();
			    System.exit(-1);
		}
	}


}
                                  