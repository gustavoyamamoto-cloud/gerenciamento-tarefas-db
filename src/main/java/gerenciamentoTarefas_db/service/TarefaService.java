package gerenciamentoTarefas_db.service;

import org.springframework.stereotype.Service;

import gerenciamentoTarefas_db.repository.TarefaRepository;

@Service
public class TarefaService {
    
    public final TarefaRepository repository;

    public TarefaService(TarefaRepository repository) {
        this.repository = repository;
    }

    
}
