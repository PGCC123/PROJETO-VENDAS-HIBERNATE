package model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "FORNECEDOR")
public class FornecedorModel implements java.io.Serializable {

    @Id
    @Column(name = "FOR_CODIGO", nullable = false, precision = 10, scale = 0)
    private int FOR_CODIGO;

    @Column(name = "FOR_CONTATO", length = 80)
    private String FOR_CONTATO;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "PES_CODIGO", unique = true, nullable= false)
    private PessoaModel pessoamodel;

    public FornecedorModel() {
    }

    public FornecedorModel(int FOR_CODIGO, String FOR_CONTATO) {
        this.FOR_CODIGO = FOR_CODIGO;
        this.FOR_CONTATO = FOR_CONTATO;
    }
    
    public int getFOR_CODIGO() {
        return FOR_CODIGO;
    }

    public void setFOR_CODIGO(int FOR_CODIGO) {
        this.FOR_CODIGO = FOR_CODIGO;
    }

    public String getFOR_CONTATO() {
        return FOR_CONTATO;
    }

    public void setFOR_CONTATO(String FOR_CONTATO) {
        this.FOR_CONTATO = FOR_CONTATO;
    }

    public PessoaModel getPessoamodel() {
        return pessoamodel;
    }

    public void setPessoamodel(PessoaModel pessoamodel) {
        this.pessoamodel = pessoamodel;
    }
}
