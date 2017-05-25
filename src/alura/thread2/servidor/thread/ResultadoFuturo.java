package alura.thread2.servidor.thread;

import java.io.PrintStream;
import java.lang.reflect.Constructor;
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
	
	public ResultadoFuturo(ExecutorService threadPool, Comando comando) {
		this.comando = comando;
		this.threadPool = threadPool;
	}

	@Override
	public Void call() throws InterruptedException, ExecutionException, NoSuchMethodException, SecurityException {
		
	  Class<?> classComando = comando.getClass();
		Constructor<?> construtor =  classComando.getConstructor(PrintStream.class); 
		Nome nomeAnnotation = null;
		if(construtor.isAnnotationPresent(Nome.class)){
		  nomeAnnotation = (Nome) construtor.getAnnotation(Nome.class);
		}
		
		if(nomeAnnotation != null){
		  comando.msgForUser(nomeAnnotation.nome());
		}else{
		  comando.msgForUser("Processando comando");
		}
	  
	  Future<String> resultadoFuturo = threadPool.submit(comando);
	    comando.msgForUser(".....");
		resultado = resultadoFuturo.get();
		//Fazer algo com o retorno do comando
		comando.msgForUser("Finalizando comando");
		return null;
	}

}
