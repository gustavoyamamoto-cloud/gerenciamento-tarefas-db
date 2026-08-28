package gerenciamentoTarefas_db.exception;

public class TarefaNaoEncontradaException extends RuntimeException{
    
    public TarefaNaoEncontradaException(String msg){
        super(msg);
    }
}
