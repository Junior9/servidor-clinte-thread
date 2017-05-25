package alura.thread2.cliente;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import alura.thread2.cliente.thread.EnviaComando;
import alura.thread2.cliente.thread.RecebeComando;

/**
* Cliente  
*
* @author  Francisco Carlos Moraes Junior* 
* @since   22/05/17 
*/

public class ClienteTarefa {
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		Socket clienteSocket = new Socket("localhost",12345);
		System.out.println("Conexão estabelecida");
		
		Thread threadEnviaComando = new Thread(new EnviaComando(clienteSocket));
		Thread threadRecebeResposta = new Thread(new RecebeComando(clienteSocket));
		
		threadEnviaComando.start();
		threadRecebeResposta.start();
		try {
			threadEnviaComando.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
