#include <stdio.h>
#include <unistd.h>
#include <errno.h>
#include <netdb.h>
#include <string.h>
#include <sys/types.h>
#include <sys/socket.h> //libreria para el uso de sockets
 
 
int main(int argc, char *argv[]) {                  
 
 
	int ident; //identificador del socket
	int conex; //identificador de la conexion   
	int contador = 1;  
	int puerto = 0;    
 
	struct sockaddr_in conexion; // estructura para almacenar los datos del socket
	conexion.sin_family = AF_INET; //sin tipo de ip especifico
	conexion.sin_addr.s_addr = inet_addr("127.0.0.1"); //dirección a la que se asigna el socket
	bzero(&(conexion.sin_zero), 8); //funcion que pone en ceros los valores de la estructura
 
	for (contador = 0; contador != 9000; contador++) { //recorrido de puertos
 	     ident = socket(AF_INET,SOCK_STREAM,0);  
             conexion.sin_port = htons(contador);
             conex = connect (ident, (struct sockaddr *)&conexion, sizeof(struct sockaddr));
 
	     if (conex != -1) { 
		printf("Puertos...%d \n", contador);
		puerto++;
		close(conex);
	     }
	close(ident);
           
	} 
    printf("Encontrados...%d\n",puerto);
}
