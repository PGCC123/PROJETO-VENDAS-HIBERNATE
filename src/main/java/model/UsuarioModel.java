package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "USUARIO")
public class UsuarioModel implements java.io.Serializable {

    @Id
    @Column(name = "USU_CODIGO", nullable = false, precision = 10, scale = 0)
    private int USU_CODIGO;

    @Column(name = "USU_NOME", nullable = false, length = 30)
    private String USU_NOME;

    @Column(name = "USU_LOGIN", nullable = false, length = 10)
    private String USU_LOGIN;

    @Column(name = "USU_SENHA", nullable = false, length = 10)
    private String USU_SENHA;
    
    //@Temporal(TemporalType.DATE)
    //@Column(name = "USU_CADASTRO", nullable = false, length = 7)
   // private String USU_CADASTRO;

    @Column(name = "USU_ATIVO", precision = 1)
    private String USU_ATIVO;
    
    @Override
    public String toString() {
        return this.USU_NOME;
    }

    public UsuarioModel() {
    }

    public UsuarioModel(int USU_CODIGO, String USU_NOME, String USU_LOGIN, String USU_SENHA,  String USU_ATIVO) {
        this.USU_CODIGO = USU_CODIGO;
        this.USU_NOME = USU_NOME;
        this.USU_LOGIN = USU_LOGIN;
        this.USU_SENHA = USU_SENHA;
        //this.USU_CADASTRO = USU_CADASTRO;
        this.USU_ATIVO = USU_ATIVO;
    }

    public int getUSU_CODIGO() {
        return USU_CODIGO;
    }

    public void setUSU_CODIGO(int USU_CODIGO) {
        this.USU_CODIGO = USU_CODIGO;
    }

    public String getUSU_NOME() {
        return USU_NOME;
    }

    public void setUSU_NOME(String USU_NOME) {
        this.USU_NOME = USU_NOME;
    }

    public String getUSU_LOGIN() {
        return USU_LOGIN;
    }

    public void setUSU_LOGIN(String USU_LOGIN) {
        this.USU_LOGIN = USU_LOGIN;
    }

    public String getUSU_SENHA() {
        return USU_SENHA;
    }

    public void setUSU_SENHA(String USU_SENHA) {
        this.USU_SENHA = USU_SENHA;
    }

  /* public String getUSU_CADASTRO() {
        return USU_CADASTRO;
    }

    public void setUSU_CADASTRO(String USU_CADASTRO) {
        this.USU_CADASTRO = USU_CADASTRO;
    } */

    public String getUSU_ATIVO() {
        return USU_ATIVO;
    }

    public void setUSU_ATIVO(String USU_ATIVO) {
        this.USU_ATIVO = USU_ATIVO;
    }
}
