package gerenciamentoTarefas_db.controller;

import org.springframework.stereotype.Controller;

import gerenciamentoTarefas_db.service.TarefaService;

@Controller
public class TarefaController {
    
    public final TarefaService service;

    public TarefaController(TarefaService service) {
        this.service = service;
    }

    
}
