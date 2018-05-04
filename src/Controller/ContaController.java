package Controller;

import Model.Cliente;
import Model.Concessionaria;
import Model.ContaEnergia;
import UI.CadastrarCliente;
<<<<<<< HEAD

=======
import java.util.ArrayList;
>>>>>>> 8f405771ccdd6e3989b204c445dc92442f5a66bb
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ContaController {

<<<<<<< HEAD
=======
    private ArrayList<ContaEnergia> contaDB = new ArrayList();
    ArrayList<Cliente> arrayCliente = new ArrayList();
    ArrayList<Concessionaria> arrayConce = new ArrayList();
>>>>>>> 8f405771ccdd6e3989b204c445dc92442f5a66bb
    ClienteController cc = new ClienteController();
    ConcessionariaController con = new ConcessionariaController();
    //Cliente cli = new Cliente();

    public ContaController() {
<<<<<<< HEAD

=======
>>>>>>> 8f405771ccdd6e3989b204c445dc92442f5a66bb
    }

    public void create(ContaEnergia contaEnergia) throws Exception {
        
    }

/*    public float geraConta(String cpf, Float kwh) throws Exception {}

        float resultado = 0;
        arrayCliente = cc.getArray();
        arrayConce = con.getArray();

        try {
            resultado = ((arrayConce.get(Integer.parseInt(cpf)).getTarifa()) * (kwh));
            JOptionPane.showMessageDialog(null, resultado);
        } catch (NumberFormatException ex) {
            Logger.getLogger(CadastrarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
*/
    
}
