package Controller;

import Model.Cliente;
import Model.Concessionaria;
import Model.ContaEnergia;
import UI.CadastrarCliente;
<<<<<<< HEAD
<<<<<<< HEAD

=======
import java.util.ArrayList;
>>>>>>> 8f405771ccdd6e3989b204c445dc92442f5a66bb
=======
import java.util.HashSet;
import java.util.Set;
>>>>>>> parent of f94de6e... gerar conta
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ContaController {

<<<<<<< HEAD
<<<<<<< HEAD
=======
    private ArrayList<ContaEnergia> contaDB = new ArrayList();
    ArrayList<Cliente> arrayCliente = new ArrayList();
    ArrayList<Concessionaria> arrayConce = new ArrayList();
>>>>>>> 8f405771ccdd6e3989b204c445dc92442f5a66bb
=======
    private Set<ContaEnergia> contaDB;
>>>>>>> parent of f94de6e... gerar conta
    ClienteController cc = new ClienteController();
    ConcessionariaController con = new ConcessionariaController();
    //Cliente cli = new Cliente();

    public ContaController() {
<<<<<<< HEAD

<<<<<<< HEAD
=======
>>>>>>> 8f405771ccdd6e3989b204c445dc92442f5a66bb
=======
        this.contaDB = new HashSet<>();
>>>>>>> parent of f94de6e... gerar conta
    }

    public void create(ContaEnergia contaEnergia) throws Exception {
        contaDB.add(contaEnergia);
    }

    public float geraConta(String cpf, Float kwh) throws Exception {

        float resultado = 0;
        arrayCliente = cc.getArray();
        arrayConce = con.getArray();
        int i = achaEstado(arrayCliente, arrayConce);
        
        try {
            resultado = ((arrayConce.get(i).getTarifa()) * (kwh));
            JOptionPane.showMessageDialog(null, resultado);
        } catch (NumberFormatException ex) {
            Logger.getLogger(CadastrarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
<<<<<<< HEAD
<<<<<<< HEAD
*/
    
=======

    public int achaEstado(ArrayList<Cliente> Cliente, ArrayList<Concessionaria> Concessionaria) {
        int i;
        for(i=0;i<=Concessionaria.size();i++){
            if (Cliente.get(i).getEndereco().getEstado().equals(Concessionaria.get(i).getEndereco().getEstado()))
            break;
        }
        return i;
    }
>>>>>>> 2214c36858b8c6b66b244a55e90787b90d4e6023
=======
>>>>>>> parent of f94de6e... gerar conta
}
