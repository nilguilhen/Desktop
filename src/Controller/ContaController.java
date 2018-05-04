package Controller;

import Model.Cliente;
import Model.Concessionaria;
import Model.ContaEnergia;
import UI.CadastrarCliente;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ContaController {

    ClienteController cc = new ClienteController();
    Concessionaria con = new Concessionaria();
    Cliente cli = new Cliente();

    public ContaController() {

    }

    public void create(ContaEnergia contaEnergia) throws Exception {
        
    }

/*    public float geraConta(String cpf, Float kwh) throws Exception {}

        float resultado = 0;
        try {
             if(cc.readByCpf(cpf).getEndereco().getEstado().equals(con.getEndereco().getEstado()))

            return resultado =(con.getTarifa() * (kwh));
        }catch (NumberFormatException ex) {
             Logger.getLogger(CadastrarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
*/
    
}
