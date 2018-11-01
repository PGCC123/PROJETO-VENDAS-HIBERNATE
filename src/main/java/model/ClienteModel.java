package model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CLIENTE")
public class ClienteModel implements Serializable {

    @Id
    @Column(name = "CLI_CODIGO", nullable = false, precision = 38, scale = 0)
    private int CLI_CODIGO;

    @Column(name = "CLI_LIMITECRED", precision = 10, scale = 2)
    private Double CLI_LIMITECRED;

    
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "PES_CODIGO", unique = true, nullable= false)
    private PessoaModel pessoamodel;

    public ClienteModel() {
    }

    public ClienteModel(int CLI_CODIGO, Double CLI_LIMITECRED) {
        this.CLI_CODIGO = CLI_CODIGO;
        this.CLI_LIMITECRED = CLI_LIMITECRED;
    }

    public int getCLI_CODIGO() {
        return CLI_CODIGO;
    }

    public void setCLI_CODIGO(int CLI_CODIGO) {
        this.CLI_CODIGO = CLI_CODIGO;
    }

    public Double getCLI_LIMITECRED() {
        return CLI_LIMITECRED;
    }

    public void setCLI_LIMITECRED(Double CLI_LIMITECRED) {
        this.CLI_LIMITECRED = CLI_LIMITECRED;
    }

    public PessoaModel getPessoamodel() {
        return pessoamodel;
    }

    public void setPessoamodel(PessoaModel pessoamodel) {
        this.pessoamodel = pessoamodel;
    }
}
