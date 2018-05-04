package Model;
import java.io.Serializable;

public class Concessionaria implements Serializable {

    Endereco endereco = new Endereco();
    
    private String nome;
    private String cnpj;
    private float tarifa;

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public float getTarifa() {
        return tarifa;
    }

    public void setTarifa(float tarifa) {
        this.tarifa = tarifa;
    }

    public void setRua(String rua) {
        endereco.setRua(rua);
    }

    public void setNumero(int numero) {
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
}
