package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FORMAPAGTO")
public class FormaPagamentoModel implements java.io.Serializable {

    @Id
    @Column(name = "FPG_CODIGO", nullable = false, precision = 10, scale = 0)
    private int FPG_CODIGO;

    @Column(name = "FPG_NOME", nullable = false, length = 50)
    private String FPG_NOME;
    
    @Column(name = "FPG_ATIVO", precision = 1)
    private String FPG_ATIVO;

    @Override
    public String toString() {
        return this.FPG_NOME;
    }
    
    public FormaPagamentoModel() {
        
    }

    public FormaPagamentoModel(int FPG_CODIGO, String FPG_NOME, String FPG_ATIVO) {
        this.FPG_CODIGO = FPG_CODIGO;
        this.FPG_NOME = FPG_NOME;
        this.FPG_ATIVO = FPG_ATIVO;
    }

    public int getFPG_CODIGO() {
        return FPG_CODIGO;
    }

    public void setFPG_CODIGO(int FPG_CODIGO) {
        this.FPG_CODIGO = FPG_CODIGO;
    }

    public String getFPG_NOME() {
        return FPG_NOME;
    }

    public void setFPG_NOME(String FPG_NOME) {
        this.FPG_NOME = FPG_NOME;
    }

    public String getFPG_ATIVO() {
        return FPG_ATIVO;
    }

    public void setFPG_ATIVO(String FPG_ATIVO) {
        this.FPG_ATIVO = FPG_ATIVO;
    }
}
