package Controller;

import Model.Cliente;
import Model.Concessionaria;
import Model.ContaEnergia;
import UI.CadastrarCliente;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ContaController {

    private ArrayList<ContaEnergia> contaDB = new ArrayList();
    ClienteController cc = new ClienteController();
    Concessionaria con = new Concessionaria();
    //Cliente cli = new Cliente();

    public ContaController() {
    }

    public void create(ContaEnergia contaEnergia) throws Exception {
        contaDB.add(contaEnergia);
    }

    public float geraConta(String cpf, Float kwh) throws Exception {
        
        float resultado = 0;
        ArrayList<Cliente> arrayCliente = new ArrayList();
        ArrayList<Concessionaria> arrayConce = new ArrayList();
        
        try {
             arrayCliente = cc.getArray();
             if(arrayCliente.get(Integer.parseInt(cpf)).getEndereco().getEstado().equals(con.getEndereco().getEstado()) == true)

            return resultado =(con.getTarifa() * (kwh));
        }catch (NumberFormatException ex) {
             Logger.getLogger(CadastrarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
}
