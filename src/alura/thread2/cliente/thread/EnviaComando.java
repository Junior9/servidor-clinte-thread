package alura.thread2.cliente.thread;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class EnviaComando implements Runnable{

	private Socket clienteSocket;
	
	public EnviaComando(Socket clienteSocket){
		this.clienteSocket = clienteSocket;
	}
	
	@Override
	public void run() {
		try {
			PrintStream saida = new PrintStream(clienteSocket.getOutputStream());
			String comandoEnviado="";
			Scanner teclado = new Scanner(System.in);
			while(teclado.hasNext()){
			  comandoEnviado  = teclado.nextLine();
				if(!"fim".equals(comandoEnviado)){
					saida.println(comandoEnviado);
				}else{
				  System.out.println("Finalizando tarefas");
					break;				
				}
			}
			teclado.close();
			saida.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
