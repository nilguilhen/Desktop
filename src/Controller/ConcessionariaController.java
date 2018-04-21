package Controller;

import Model.Concessionaria;
import java.util.HashSet;
import java.util.Set;

public class ConcessionariaController {
 
    
    private Set<Concessionaria> concessionariaDB;

    public ConcessionariaController() {

    this.concessionariaDB = new HashSet<>();
    }

    public void create(Concessionaria concessionaria) throws Exception {
        if (concessionariaDB.add(concessionaria) == false){
            throw new Exception("Concessionaria ja existente");
        }
    }
    
    public Concessionaria readByCnpj(String cnpj) {
        return concessionariaDB.stream().filter(concessionaria-> concessionaria.getCnpj().equalsIgnoreCase(cnpj)).findAny().get();
    }

    public Concessionaria readByName(String nome) {
        return concessionariaDB.stream().filter(concessionaria -> concessionaria.getNome().equalsIgnoreCase(nome)).findAny().get();
    }

    public Set<Concessionaria> readAll() {
        return concessionariaDB;
    }

    public void update (Concessionaria newConcessionaria, String nome) {
        Concessionaria concessionariaAtual = this.readByName(nome);

        if (concessionariaAtual != null) {
            concessionariaAtual.setNome(newConcessionaria.getNome());
            concessionariaAtual.setCnpj(newConcessionaria.getCnpj());
            concessionariaAtual.setTarifa(newConcessionaria.getTarifa());
        }
    }

    public void delete (String cnpj) {
        Concessionaria concessionariaAtual = this.readByCnpj(cnpj);

        if (concessionariaAtual != null) 
            concessionariaDB.removeIf(concessionaria -> concessionaria.equals(concessionariaAtual));
    }
    
    
   
}
