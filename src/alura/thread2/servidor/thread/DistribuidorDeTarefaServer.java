package alura.thread2.servidor.thread;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;

import alura.thread2.servidor.ServidorTarefa;
import alura.thread2.servidor.thread.comando.ComandoC1;
import alura.thread2.servidor.thread.comando.ComandoC2;
import alura.thread2.servidor.thread.comando.ComandoC3;

public class DistribuidorDeTarefaServer implements Runnable {

	private ServidorTarefa st;
	private Socket socketServer;
	private ExecutorService threadPool;
	
	public DistribuidorDeTarefaServer(ServidorTarefa st, Socket socketServer, ExecutorService threadPool) {
		this.st = st;
		this.socketServer = socketServer;
		this.threadPool = threadPool;
	}
	
	@Override
	public void run() {
		PrintStream saidaComando;
		Scanner entradaCliente = null;
		try {
			saidaComando = new PrintStream(socketServer.getOutputStream());
			entradaCliente = new Scanner(socketServer.getInputStream());
			System.out.println("To rodando: " + socketServer.getPort());
			while(entradaCliente.hasNextLine()){
				
//				try {
//				
//					assertEquals(true, c.isAssignableFrom(ComandoC1.class));
//					
//					
//					String comando = entradaCliente.nextLine();
//					Class<?> c =  Class.forName("alura.thread2.servidor.thread.comando.Comando"+comando);
//					c.con
//					Future<String > fuj= threadPool.submit(new ComandoC1(saidaCliente));
//
//				
//				
//				
//				
//				} catch (ClassNotFoundException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//				
//				
				//==================================================================================//
				
				
				switch (entradaCliente.nextLine()) {
				case "C1":
						threadPool.submit(new ResultadoFuturo(threadPool,saidaComando,new ComandoC1(saidaComando)));
					break;
				case "C2":
						threadPool.submit(new ResultadoFuturo(threadPool,saidaComando,new ComandoC2(saidaComando)));
					break;
				case "C3":
						threadPool.submit(new ResultadoFuturo(threadPool,saidaComando,new ComandoC3(saidaComando)));
					break;
				case "fim":
					st.stop();
					break;
				default:
					saidaComando.println("Comando não encontrado");					
					break;
				}
			}
			entradaCliente.close();
		} catch (IOException e) {
			System.out.println("erro:"+e.getMessage());
		} 
	}

}
