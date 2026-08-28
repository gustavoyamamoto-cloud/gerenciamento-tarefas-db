package gerenciamentoTarefas_db.service;

import java.util.List;

import org.springframework.stereotype.Service;

import gerenciamentoTarefas_db.dto.TarefasResponse;
import gerenciamentoTarefas_db.model.Tarefa;
import gerenciamentoTarefas_db.repository.TarefaRepository;

@Service
public class TarefaService {
    
    public final TarefaRepository repository;

    public TarefaService(TarefaRepository repository) {
        this.repository = repository;
    }


    //Listar
    public List<TarefasResponse> listar(){
        
        return repository.findAll()
                            .stream()
                            .map(t -> new TarefasResponse(
                                t.getId(),
                                t.getTitulo(),
                                t.getDescricao(),
                                t.getPrioridade(),
                                t.getStatus(),
                                t.getDataCriacao()))
                            .toList();
    }
    
}
