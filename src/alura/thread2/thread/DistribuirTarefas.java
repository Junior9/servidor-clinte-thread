package alura.thread2.thread;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class DistribuirTarefas implements Runnable{
	private Socket socketServer;

	public DistribuirTarefas(Socket socketServer) {
		this.socketServer = socketServer;
	}

	@Override
	public void run() {
		try {
			System.out.println("To rodando: " + socketServer.getPort());
			Scanner entradaCliente = new Scanner(socketServer.getInputStream());
			
			while(entradaCliente.hasNextLine())
				System.out.println(entradaCliente.nextLine());
			
			
			Thread.sleep(2000);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
