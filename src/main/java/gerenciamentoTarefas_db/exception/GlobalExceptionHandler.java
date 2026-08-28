package gerenciamentoTarefas_db.exception;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<String>> tratarValidacoes(MethodArgumentNotValidException ex){

        List<String> erros = ex.getBindingResult()
                                .getFieldErrors()
                                .stream()
                                .map(e -> e.getDefaultMessage())
                                .toList();

        return ResponseEntity
                .badRequest()
                .body(erros);
    }


    @ExceptionHandler(TarefaNaoEncontradaException.class)
    public ResponseEntity<ErroResponse> tratarTarefaNaoEncontrada(TarefaNaoEncontradaException ex){

        ErroResponse erro = new ErroResponse(ex.getMessage(), 404);

        return ResponseEntity
                .status(404)
                .body(erro);
    }
}
