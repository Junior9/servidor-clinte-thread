package alura.thread2.servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

import alura.thread2.servidor.thread.DistribuidorDeTarefaServer;
import alura.thread2.servidor.thread.FabricaDeThread;

/**
* Servidor  
*
* @author  Francisco Carlos Moraes Junior* 
* @since   22/05/17 
*/

public class ServidorTarefa {

	private ServerSocket servidor;
	private ExecutorService threadPool;
	private AtomicBoolean isUpServer = new AtomicBoolean(true);
	
	public ServidorTarefa() throws IOException {
		this.servidor = new ServerSocket(12345);
		System.out.println("Iniciando Servidor ....");
		this.threadPool =  Executors.newCachedThreadPool(new FabricaDeThread());
	}
	
	public void run(){
		while(isUpServer.get()){
			Socket socketServer;
			try {
				socketServer = servidor.accept();
			
				System.out.println("Conectando o cliente na porta: "+ socketServer.getPort() );
				
				threadPool.execute(new DistribuidorDeTarefaServer(this, socketServer,threadPool));
			
			} catch (IOException e1) {
				if(!isUpServer.get())
					System.out.println("Deslligando o servidor ....");
				else
					System.out.println("Erro na execução: " + e1.getMessage());
			}
		}	
	}

	public void stop(){
		try {
			isUpServer.set(Boolean.FALSE);
			servidor.close();
			threadPool.shutdown();
		} catch (IOException e) {
			if(!isUpServer.get())
				System.out.println("Deslligando o servidor ....");
			else
				System.out.println("Erro ao desligar servidor: " + e.getMessage());
		}
	}
	
	public static void main(String[] args) throws IOException {
		ServidorTarefa st = new ServidorTarefa();
		st.run();
	}
}
