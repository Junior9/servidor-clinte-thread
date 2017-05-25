package alura.thread2.servidor.thread;

import java.io.PrintStream;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import alura.thread2.servidor.thread.annotation.Nome;
import alura.thread2.servidor.thread.comando.Comando;

public class ResultadoFuturo implements Callable<Void> {

	private String resultado;
	private ExecutorService threadPool;
	private Comando comando;
	private PrintStream saidaComando;
	
	public ResultadoFuturo(ExecutorService threadPool,PrintStream saidaComando, Comando comando) {
		this.comando = comando;
		this.threadPool = threadPool;
		this.saidaComando = saidaComando;
	}

	@Override
	public Void call() throws InterruptedException, ExecutionException {
		
	/*	
	 * 
	 * 
		Class c = comando.getClass();
		if(c.isAnnotation()){
			String cd = c.getAnnotation(Nome.class).toString();
			System.out.println("Annotation "+cd);
		}
		*/
		
		System.out.println("Processando comando C1");
		Future<String> resultadoFuturo = threadPool.submit(comando);
		saidaComando.println("....");
		resultado = resultadoFuturo.get();
		//Thread.sleep(10000);
		saidaComando.println("Finalizando comando : " + resultado);
		return null;
	}

}
