package alura.thread2.servidor.thread.fila.comando;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;

import alura.thread2.servidor.thread.ResultadoFuturo;
import alura.thread2.servidor.thread.comando.Comando;

public class ConsomeComando implements Runnable{

	private BlockingQueue<Comando> filaComando;
	private ExecutorService threadpool;
	//private PrintStream saidaComando;
	
	public ConsomeComando(BlockingQueue<Comando> filaComando, ExecutorService threadPool) {
		super();
		this.filaComando = filaComando;
		this.threadpool = threadPool;
	}
	

	@Override
	public void run() {
		Comando comando;
		try {
			while((comando = filaComando.take())!= null){
				threadpool.submit(new ResultadoFuturo(threadpool,comando));
			}
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
