package Controller;

import Model.Cliente;
import Model.Concessionaria;
import Model.ContaEnergia;
import UI.CadastrarCliente;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ContaController {

    private ArrayList<ContaEnergia> contaDB = new ArrayList();
    ArrayList<Cliente> arrayCliente = new ArrayList();
    ArrayList<Concessionaria> arrayConce = new ArrayList();
    ClienteController cc = new ClienteController();
    ConcessionariaController con = new ConcessionariaController();
    //Cliente cli = new Cliente();

    public ContaController() {
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

    public int achaEstado(ArrayList<Cliente> Cliente, ArrayList<Concessionaria> Concessionaria) {
        int i;
        for(i=0;i<=Concessionaria.size();i++){
            if (Cliente.get(i).getEndereco().getEstado().equals(Concessionaria.get(i).getEndereco().getEstado()))
            break;
        }
        return i;
    }
}
