package Controller;

import Model.Concessionaria;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class ConcessionariaController {
 
    File arquivo = null;
    private ArrayList<Concessionaria> concessionariaDB;

    
    public ConcessionariaController(){}

     public ObjectOutputStream CriaEscritorBinario(File arquivo, boolean append) {
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new FileOutputStream(arquivo, append));
        } catch (IOException erro) {
            System.out.println("Erro ao criar arquivo. " + erro);
        }
        return out;
    }

    public ObjectInputStream CriaLeitorBinario(File arquivo) {
        ObjectInputStream ois = null;
        try {
            FileInputStream fis= new FileInputStream(arquivo);
            ois = new ObjectInputStream(fis);
        } catch (IOException erro) {
            System.out.println("Erro ao ler arquivo. " + erro);
        }
        return ois;
    }

    public void EscreveObjeto(ObjectOutputStream oos, Object obj, boolean flush) {
        try {
            oos.writeObject(obj);
            if (flush) {
                oos.flush();
            }
        } catch (IOException erro) {
            System.out.println("Erro na escrita. " + erro);
        }
    }

    public Object LeObjeto(ObjectInputStream ois) {
        Object objlido = null;
        try {
            objlido = ois.readObject();
        } catch (ClassNotFoundException erro) {
            System.out.println("Classe nao encontrada. "
                    + erro);
        } catch (java.io.EOFException erro) {
            System.out.println("Final de arquivo. "
                    + erro);
        } catch (IOException erro) {
            System.out.println("Erro na leitura do objeto. " + erro);
        } finally {
            return objlido;
        }
    }

    public File selecionaArquivo() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int resultado = fileChooser.showSaveDialog(null);
        if (resultado != JFileChooser.APPROVE_OPTION){
            return null;
        }
        arquivo = fileChooser.getSelectedFile();
        
        if (arquivo.getName().equals("")) {
            JOptionPane.showMessageDialog(null, "Nome de Arquivo Inválido", "Nome de Arquivo Inválido", JOptionPane.ERROR_MESSAGE);

        }
    return arquivo;    
    }    
    
    public void setArray(Concessionaria c){
        concessionariaDB.add(c);
    }
    public ArrayList<Concessionaria> getArray(){
        return concessionariaDB;
    }
    
    public ArrayList<Concessionaria> carregaConcessionarias(ObjectInputStream leitor){
        concessionariaDB = (ArrayList<Concessionaria>) LeObjeto(leitor);

        return concessionariaDB;
    }

}