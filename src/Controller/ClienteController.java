
package Controller;

import Model.Cliente;
import java.util.HashSet;
import java.util.Set;


public class ClienteController {
    
    private Set<Cliente> clienteDB;

    public ClienteController() {

    this.clienteDB = new HashSet<>();
    }

    public void create(Cliente cliente) throws Exception {
        if (clienteDB.add(cliente) == false){
            throw new Exception("Cliente ja existe");
        }
    }
    
    public Cliente readByCpf(String cpf) {
        return clienteDB.stream().filter(cliente-> cliente.getCpf().equalsIgnoreCase(cpf)).findAny().get();
    }

    public Cliente readByName(String nome) {
        return clienteDB.stream().filter(cliente -> cliente.getNome().equalsIgnoreCase(nome)).findAny().get();
    }

    public Set<Cliente> readAll() {
        return clienteDB;
    }

    public void update (Cliente newCliente, String nome) {
        Cliente clienteAtual = this.readByName(nome);

        if (clienteAtual != null) {
            clienteAtual.setNome(newCliente.getNome());
            clienteAtual.setCpf(newCliente.getCpf());
            clienteAtual.setIdade(newCliente.getIdade());
        }
    }

    public void delete (String cpf) {
        Cliente clienteAtual = this.readByCpf(cpf);

        if (clienteAtual != null) 
            clienteDB.removeIf(cliente -> cliente.equals(clienteAtual));
    }

}
