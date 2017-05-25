package alura.thread2.cliente.thread;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class RecebeComando implements Runnable{

	private Socket clienteSocket;
	
	public RecebeComando(Socket clienteSocket) {
		super();
		this.clienteSocket = clienteSocket;
	}

	@Override
	public void run() {
		
		try {
			String linha = "";
			Scanner respotaServidor = new Scanner(clienteSocket.getInputStream());
			while(respotaServidor.hasNextLine()){
				linha = respotaServidor.nextLine();
				if(!"".equals(linha)){
					System.out.println(linha);
				}else{
					break;
				}
			}
			respotaServidor.close();
			//clienteSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}		
		
		
	}
	
}
