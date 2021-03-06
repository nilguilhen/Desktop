/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Model.Cliente;
import Model.Concessionaria;

/**
 *
 * @author Ian Fraga Bitar
 */
public class ConexaoBD {

    private Connection conn = null;

    private Statement stmt = null;
    // private Statement stmt2 = null;

    // private ResultSet rs2 = null;
    private ResultSet rs = null;

    private PreparedStatement pstmt = null;
    //  private PreparedStatement pstmt2 = null;

    int tipo = ResultSet.TYPE_SCROLL_SENSITIVE;
    int concorrencia = ResultSet.CONCUR_UPDATABLE;
    
    public boolean conectaBD() {

        try {
            
            conn = getConexao();
            conn.setAutoCommit(false);

            DatabaseMetaData dbmt = conn.getMetaData();

            System.out.println("Nome do Banco de Dados: " + dbmt.getDatabaseProductName());
            System.out.println("Versao do Banco de Dados: " + dbmt.getDatabaseProductVersion());
            System.out.println("URL: " + dbmt.getURL());
            System.out.println("Driver: " + dbmt.getDriverName());
            System.out.println("Versao Driver: " + dbmt.getDriverVersion());
            System.out.println("Usuario: " + dbmt.getUserName());
            
            return true;
        } catch (ClassNotFoundException Erro) {
            System.out.println("Erro ao tentar carregar o driver JDBC/ODBC." + Erro);
            return false;

        } catch (SQLException Erro) {
            System.out.println("Falha na conexao" + Erro);
            return false;
        }
    }
    
    public Connection getConexao() throws ClassNotFoundException, SQLException{
        String usuario = "postgres";
        //String senha = "48691848";
        String senha = "";

        Class.forName("org.postgresql.Driver");
        String urlconexao = "jdbc:postgresql://localhost:5432/Desktop";
        //String urlconexao = "jdbc:postgresql://127.0.0.1/Desktop";
        return DriverManager.getConnection(urlconexao, usuario, senha);
    }
    
    public void cadastroCliente(Cliente cliente) {

        if (conectaBD()) {
            try {
                String SQL = "INSERT INTO Cliente (Cli_Nome,Cli_CPF,Cli_Idade,Cli_Pais,Cli_Estado,Cli_Cidade,Cli_Rua,Cli_Nume,Cli_Complemento,Cli_CEP) VALUES (?,?,?,?,?,?,?,?,?,?)";

                pstmt = conn.prepareStatement(SQL, tipo, concorrencia);

                pstmt.setString(1, cliente.getNome());
                pstmt.setString(2, cliente.getCpf());
                pstmt.setString(3, cliente.getIdade());
                pstmt.setString(4, cliente.getPais());
                pstmt.setString(5, cliente.getEstado());
                pstmt.setString(6, cliente.getCidade());
                pstmt.setString(7, cliente.getRua());
                pstmt.setString(8, cliente.getNumero());
                pstmt.setString(9, cliente.getComplemento());
                pstmt.setString(10, cliente.getCep());

                pstmt.executeUpdate();
                conn.commit();

                conn.close();
            } catch (SQLException Erro) {
                System.out.println("Erro" + Erro);
            }
        }
    }

    public void alteraCliente(Cliente cliente) {

        if (conectaBD()) {
            try {
                String SQL = "UPDATE Cliente SET Cli_Nome =?, Cli_Idade =?, Cli_Pais =?, Cli_Estado =?, Cli_Cidade =?, Cli_Rua =?, Cli_Nume =? ,Cli_Complemento =?, Cli_CEP =? WHERE Cli_CPF = ?";

                pstmt = conn.prepareStatement(SQL, tipo, concorrencia);

                pstmt.setString(1, cliente.getNome());
                pstmt.setString(2, cliente.getIdade());
                pstmt.setString(3, cliente.getPais());
                pstmt.setString(4, cliente.getEstado());
                pstmt.setString(5, cliente.getCidade());
                pstmt.setString(6, cliente.getRua());
                pstmt.setString(7, cliente.getNumero());
                pstmt.setString(8, cliente.getComplemento());
                pstmt.setString(9, cliente.getCep());
                pstmt.setString(10, cliente.getCpf());

                pstmt.executeUpdate();
                conn.commit();

                conn.close();
            } catch (SQLException Erro) {
                System.out.println("Erro" + Erro);
            }
        }
    }

    public ResultSet consultaCliente() {
        if (conectaBD()) {
            try {
                String SQL = "SELECT * FROM Cliente";

                stmt = conn.createStatement(tipo, concorrencia);

                rs = stmt.executeQuery(SQL);

                conn.close();
                return rs;
            } catch (SQLException Erro) {
                System.out.println("Erro na execução da Querry = " + Erro);
            }
        }
        return null;
    }

    public void excluiCliente(String CPF) {
        if (conectaBD()) {
            try {
                String SQL = "DELETE FROM Cliente WHERE Cli_CPF = (?)";

                pstmt = conn.prepareStatement(SQL, tipo, concorrencia);
                pstmt.setString(1, CPF);
                pstmt.executeUpdate();
                conn.commit();
            } catch (SQLException Erro) {
                System.out.println("Erro ao Deletar = " + Erro);
            }
        }
    }

    public void cadastroConce(Concessionaria conce) {

        if (conectaBD()) {
            try {
                String SQL = "INSERT INTO Concessionaria (Conc_Nome, Conc_CNPJ, Conc_Tarifa, Conc_Pais,Conc_Estado,Conc_Cidade,Conc_Rua,Conc_Nume,Conc_Complemento,Conc_CEP) VALUES (?,?,?,?,?,?,?,?,?,?)";

                pstmt = conn.prepareStatement(SQL, tipo, concorrencia);

                pstmt.setString(1, conce.getNome());
                pstmt.setString(2, conce.getCnpj());
                pstmt.setString(3, conce.getTarifa());
                pstmt.setString(4, conce.getPais());
                pstmt.setString(5, conce.getEstado());
                pstmt.setString(6, conce.getCidade());
                pstmt.setString(7, conce.getRua());
                pstmt.setString(8, conce.getNumero());
                pstmt.setString(9, conce.getComplemento());
                pstmt.setString(10, conce.getCep());

                pstmt.executeUpdate();
                conn.commit();

                conn.close();
            } catch (SQLException Erro) {
                System.out.println("Erro" + Erro);
            }
        }
    }

    public void alteraConce(Concessionaria conce) {

        if (conectaBD()) {
            try {
                String SQL = "UPDATE Concessionaria SET Conc_Nome =?, Conc_Tarifa =?, Conc_Pais =?, Conc_Estado =?, Conc_Cidade =?, Conc_Rua =?, Conc_Nume =? ,Conc_Complemento =?, Conc_CEP =? WHERE Conc_CNPJ = ?";

                pstmt = conn.prepareStatement(SQL, tipo, concorrencia);

                pstmt.setString(1, conce.getNome());
                pstmt.setString(2, conce.getTarifa());
                pstmt.setString(3, conce.getPais());
                pstmt.setString(4, conce.getEstado());
                pstmt.setString(5, conce.getCidade());
                pstmt.setString(6, conce.getRua());
                pstmt.setString(7, conce.getNumero());
                pstmt.setString(8, conce.getComplemento());
                pstmt.setString(9, conce.getCep());
                pstmt.setString(10, conce.getCnpj());

                pstmt.executeUpdate();
                conn.commit();

                conn.close();
            } catch (SQLException Erro) {
                System.out.println("Erro" + Erro);
            }
        }
    }

    public ResultSet consultaConce() {
        if (conectaBD()) {
            try {
                String SQL = "SELECT * FROM Concessionaria";

                stmt = conn.createStatement(tipo, concorrencia);

                rs = stmt.executeQuery(SQL);

                conn.close();
                return rs;
            } catch (SQLException Erro) {
                System.out.println("Erro na execução da Querry = " + Erro);
            }
        }
        return null;
    }

    public void excluiConce(String CNPJ) {
        if (conectaBD()) {
            try {
                String SQL = "DELETE FROM Concessionaria WHERE Conc_CNPJ = (?)";

                pstmt = conn.prepareStatement(SQL, tipo, concorrencia);
                pstmt.setString(1, CNPJ);
                pstmt.executeUpdate();
                conn.commit();

            } catch (SQLException Erro) {
                System.out.println("Erro ao Deletar = " + Erro);
            }
        }
    }

    public ResultSet pegaTarifa(String CPF) {
        if (conectaBD()) {
            try {
                String SQL = "SELECT Conc_Tarifa FROM Concessionaria co, Cliente cl WHERE cl.Cli_CPF = (?) and co.Conc_Estado = cl.Cli_Estado";

                stmt = conn.createStatement(tipo, concorrencia);
                pstmt.setString(1, CPF);

                rs = stmt.executeQuery(SQL);

                conn.close();
                return rs;
            } catch (SQLException Erro) {
                System.out.println("Erro ao pegar Tarifa = " + Erro);
            }
        }
        return null;
    }
}
