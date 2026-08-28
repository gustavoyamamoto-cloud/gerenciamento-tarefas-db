package gerenciamentoTarefas_db.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import gerenciamentoTarefas_db.dto.TarefasRequest;
import gerenciamentoTarefas_db.dto.TarefasResponse;
import gerenciamentoTarefas_db.service.TarefaService;
import jakarta.validation.Valid;

@Controller
public class TarefaController {
    
    public final TarefaService service;

    public TarefaController(TarefaService service) {
        this.service = service;
    }

    
    @GetMapping
    public List<TarefasResponse> listar(){
        return service.listar();
    }

    @PostMapping
    public TarefasResponse cadastrar(@Valid @RequestBody TarefasRequest dto){
        return service.cadastrar(dto);
    }

    @GetMapping("/{id}")
    public TarefasResponse buscar(@PathVariable Long id){
        return service.buscar(id);
    }
}
