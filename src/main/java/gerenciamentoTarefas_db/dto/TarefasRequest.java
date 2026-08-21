package gerenciamentoTarefas_db.dto;

import java.time.LocalDate;

import gerenciamentoTarefas_db.model.Prioridade;
import gerenciamentoTarefas_db.model.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

public class TarefasRequest {
    
    @NotBlank(message = "Titulo obrigatorio")
    @Size(min = 3, max = 100)
    private String titulo;

    @NotBlank(message = "Descrição obrigatoria")
    @Size(min = 3, max = 150)
    private String descricao;

    @NotNull(message = "Prioridade obrigatoria")
    private Prioridade prioridade;

    @NotNull(message = "Status obrigatorio")
    private Status status;

    @NotNull(message = "Data obrigatoria")
    @PastOrPresent(message = "Data deve ser passada ou presente")
    private LocalDate dataCriacao;


    public TarefasRequest() {}
    
    public TarefasRequest(String titulo, String descricao, Prioridade prioridade, Status status, LocalDate dataCriacao){
        this.titulo = titulo;
        this.descricao = descricao;
        this.prioridade = prioridade;
        this.status = status;
        this.dataCriacao = dataCriacao;
    }



    /* Getters e Setters */
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    
}
