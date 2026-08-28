package gerenciamentoTarefas_db.exception;

public class ErroResponse {
    
    private String mensagen;
    private int status;


    public ErroResponse(String mensagen, int status) {
        this.mensagen = mensagen;
        this.status = status;
    }

    /* Getters e Setters */
    public String getMensagen() {
        return mensagen;
    }
    public void setMensagen(String mensagen) {
        this.mensagen = mensagen;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }

    
}
