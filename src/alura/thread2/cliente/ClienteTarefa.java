package alura.thread2.cliente;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

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
		PrintStream saida = new PrintStream(clienteSocket.getOutputStream());
		saida.println("C1");
		
		Scanner teclado = new Scanner(System.in);

		teclado.close();
		saida.close();
		clienteSocket.close();		
	}

}
