package gerenciamentoTarefas_db.service;

import java.util.List;

import org.springframework.stereotype.Service;

import gerenciamentoTarefas_db.dto.TarefasRequest;
import gerenciamentoTarefas_db.dto.TarefasResponse;
import gerenciamentoTarefas_db.exception.TarefaNaoEncontradaException;
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


    //Cadastrar
    public TarefasResponse cadastrar(TarefasRequest dto){

        Tarefa tarefa = new Tarefa();

        tarefa.setTitulo(dto.getTitulo());
        tarefa.setDescricao(dto.getDescricao());
        tarefa.setPrioridade(dto.getPrioridade());
        tarefa.setStatus(dto.getStatus());
        tarefa.setDataCriacao(dto.getDataCriacao());

        repository.save(tarefa);

        return new TarefasResponse(
                                tarefa.getId(),
                                tarefa.getTitulo(),
                                tarefa.getDescricao(),
                                tarefa.getPrioridade(),
                                tarefa.getStatus(),
                                tarefa.getDataCriacao());
    }

    //Buscar
    public TarefasResponse buscar(Long id){

        Tarefa tarefa = repository.findById(id)
                                    .orElseThrow(() -> new TarefaNaoEncontradaException("id não encontrado"));

        return new TarefasResponse(
                                tarefa.getId(),
                                tarefa.getTitulo(),
                                tarefa.getDescricao(),
                                tarefa.getPrioridade(),
                                tarefa.getStatus(),
                                tarefa.getDataCriacao());
    }

    //Atualizar
    public TarefasResponse atualizar(Long id, TarefasRequest dto){

        Tarefa tarefa = repository.findById(id)
                                    .orElseThrow(() -> new TarefaNaoEncontradaException("id não encontrado"));
                    
        tarefa.setTitulo(dto.getTitulo());
        tarefa.setDescricao(dto.getDescricao());
        tarefa.setPrioridade(dto.getPrioridade());
        tarefa.setStatus(dto.getStatus());
        tarefa.setDataCriacao(dto.getDataCriacao());

        return new TarefasResponse(
                                tarefa.getId(),
                                tarefa.getTitulo(),
                                tarefa.getDescricao(),
                                tarefa.getPrioridade(),
                                tarefa.getStatus(),
                                tarefa.getDataCriacao());
    }
    
}
