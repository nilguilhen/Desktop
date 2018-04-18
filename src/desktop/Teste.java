package desktop;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Teste {

    private File arquivo = null;
    private BufferedReader entrada = null;
    private BufferedWriter escritorbuffer = null;

    public File getArquivo() {
        return this.arquivo;
    }

    public BufferedReader abrirarquivo() {

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.CANCEL_OPTION) {
            return null;
        }
        arquivo = fileChooser.getSelectedFile();
        System.out.println(arquivo);

        if (arquivo == null || arquivo.getName().equals("")) {
            JOptionPane.showMessageDialog(null, "Nome de Arquivo InvÃ¡lido", "Nome de Arquivo InvÃ¡lido", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                return new BufferedReader(new FileReader(arquivo));
            } catch (IOException ioException) {
                JOptionPane.showMessageDialog(null, "Error ao Abrir Arquivo", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
        return null;
    }

    public String Le() {
        StringBuilder str = new StringBuilder();
        try {
            while (entrada.ready()) {
                str.append(entrada.readLine()).append("\n");
            }
            entrada.close();
            return str.toString();
        } catch (IOException erro) {
            System.err.println("Erro na leitura de arquivo: " + erro);
        }
        return null;
    }

    public void selecionaArquivo() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int resultado = fileChooser.showSaveDialog(null);
        if (resultado != JFileChooser.APPROVE_OPTION) {
            return;
        }
        arquivo = fileChooser.getSelectedFile();

        if (arquivo.getName().equals("")) {
            JOptionPane.showMessageDialog(null, "Nome de Arquivo Inválido", "Nome de Arquivo Inválido", JOptionPane.ERROR_MESSAGE);

        }
  
    }

    public boolean Salvar(String aux, boolean append, File arquivo) {
        try {
            escritorbuffer = new BufferedWriter(new FileWriter(arquivo, append));
            escritorbuffer.write(aux);
            escritorbuffer.close();
            return true;
        } catch (IOException erro) {
            System.err.println("Erro na escrita de arquivo: " + erro);
        }
        return false;
    }
        public boolean escreveComo(String aux, boolean append) {
        try {
            selecionaArquivo();
            if(!arquivo.getName().equals(null)){
            escritorbuffer = new BufferedWriter(new FileWriter(arquivo, append));            
            escritorbuffer.write(aux);    
            escritorbuffer.close();
            return true;
            }else{
                JOptionPane.showMessageDialog(null, "Selecione o arquivo antes");
                return false;
            }
        } catch (IOException erro) {
            System.err.println("Erro na escrita de arquivo: " + erro);
        }
        return false;
    }

    public BufferedReader getEntrada() {
        return entrada;
    }

    public void setEntrada(BufferedReader entrada) {
        this.entrada = entrada;
    }

    public BufferedWriter getEscritorbuffer() {
        return escritorbuffer;
    }

    public void setEscritorbuffer(BufferedWriter escritorbuffer) {
        this.escritorbuffer = escritorbuffer;
    }

  

}
