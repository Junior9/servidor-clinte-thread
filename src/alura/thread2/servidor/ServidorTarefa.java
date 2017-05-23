package alura.thread2.servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import alura.thread2.thread.DistribuirTarefas;


/**
* Servidor  
*
* @author  Francisco Carlos Moraes Junior* 
* @since   22/05/17 
*/

public class ServidorTarefa {

	private static ServerSocket servidor;
	
	public static void main(String[] args) throws IOException {
		servidor = new ServerSocket(12345);
		System.out.println("Iniciando Servidor ....");
		while(true){
			Socket socketServer = servidor.accept();
			System.out.println("Conectando o cliente na porta: "+ socketServer.getPort() );
			new Thread(new DistribuirTarefas(socketServer)).start();
		}	
	}
	
}
