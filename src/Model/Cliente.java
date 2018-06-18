package Model;
import java.io.Serializable;

public class Cliente implements Serializable {

    Endereco endereco = new Endereco();

    private String nome;
    private String cpf;
    private String idade;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public void setRua(String rua) {
        endereco.setRua(rua);
    }

    public void setNumero(String numero) {
        endereco.setNumero(numero);
    }

    public void setComplemento(String comp) {
        endereco.setComplemento(comp);
    }

    public void setCidade(String cidade) {
        endereco.setCidade(cidade);
    }

    public void setEstado(String estado) {
        endereco.setEstado(estado);
    }

    public void setPais(String pais) {
        endereco.setPais(pais);
    }

    public void setCep(String cep) {
        endereco.setCep(cep);
    }
    public Endereco getEndereco() {
        return endereco;
    }

}
