package alura.thread2.servidor.thread;

import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import alura.thread2.servidor.thread.comando.Comando;

public class DistribuidorDeTarefaServer implements Runnable {

	private Socket socketServer;
	private ExecutorService threadPool;
	private BlockingQueue<Comando> filaComando;
	
	public DistribuidorDeTarefaServer( Socket socketServer, ExecutorService threadPool,BlockingQueue<Comando> filaComando) {
		this.socketServer = socketServer;
		this.threadPool = threadPool;
		this.filaComando = filaComando;
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
				try {
					
    				String comandoRecebido = entradaCliente.nextLine();
    				Class<?> classComand =  Class.forName("alura.thread2.servidor.thread.comando.Comando"+comandoRecebido);
    				Constructor<?> contrutorDeComando =  classComand.getConstructor(PrintStream.class);
    				Comando comando = (Comando) contrutorDeComando.newInstance(saidaComando);
    				filaComando.put(comando);
    				
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (NoSuchMethodException e) {
		          e.printStackTrace();
		        } catch (SecurityException e) {
		          e.printStackTrace();
		        } catch (InstantiationException e) {
		          e.printStackTrace();
		        } catch (IllegalAccessException e) {
		          e.printStackTrace();
		        } catch (IllegalArgumentException e) {
		          e.printStackTrace();
		        } catch (InvocationTargetException e) {
		          e.printStackTrace();
		        } catch (InterruptedException e) {
		        	e.printStackTrace();
				}
			}
			entradaCliente.close();
		} catch (IOException e) {
			System.out.println("erro:"+e.getMessage());
		} 
	}

}
