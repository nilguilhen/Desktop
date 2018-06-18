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
    private Statement stmt2 = null;

    private ResultSet rs2 = null;
    private ResultSet rs = null;

    private PreparedStatement pstmt = null;
    private PreparedStatement pstmt2 = null;

    int tipo = ResultSet.TYPE_SCROLL_SENSITIVE;
    int concorrencia = ResultSet.CONCUR_UPDATABLE;

    public boolean conectaBD() {

        try {
            String usuario = "postgres";
            String senha = "48691848";

            Class.forName("org.postgresql.Driver");
            String urlconexao = "jdbc:postgresql://127.0.0.1/Desktop";

            conn = DriverManager.getConnection(urlconexao, usuario, senha);
            conn.setAutoCommit(false);

            DatabaseMetaData dbmt = conn.getMetaData();

            System.out.println("Nome do Banco de Dados: " + dbmt.getDatabaseProductName());
            System.out.println("Versao do Banco de Dados: " + dbmt.getDatabaseProductVersion());
            System.out.println("URL: " + dbmt.getURL());
            System.out.println("Driver: " + dbmt.getDriverName());
            System.out.println("Versao Driver: " + dbmt.getDriverVersion());
            System.out.println("Usuario: " + dbmt.getUserName());

        } catch (ClassNotFoundException Erro) {
            System.out.println("Erro ao tentar carregar o driver JDBC/ODBC." + Erro);
            return false;

        } catch (SQLException Erro) {
            System.out.println("Falha na conexao" + Erro);
            return false;
        }
        return true;
    }

    public void cadastroCliente(Cliente cliente) {

        if (conectaBD()) {
            try {
                String SQL = "INSERT INTO Cliente (Cli_Nome,Cli_CPF,Cli_Idade) VALUES (?,?,?)";
                String SQL2 = "INSERT INTO Endereco (Cli_CPF,Conc_CNPJ,End_Pais,End_Estado,End_Cidade,"
                        + "End_Rua,End_Nume,End_Complemento,End_CEP)"
                        + "VALUES (?,?,?,?,?,?,?,?,?)";

                pstmt = conn.prepareStatement(SQL, tipo, concorrencia);
                pstmt2 = conn.prepareStatement(SQL2, tipo, concorrencia);

                pstmt.setString(1, cliente.getNome());
                pstmt.setString(2, cliente.getCpf());
                pstmt.setString(3, String.valueOf(cliente.getIdade()));
                pstmt.executeUpdate();
                conn.commit();

                pstmt2.setString(1, cliente.getCpf());
                //pstmt2.setString(2, "");
                pstmt2.setString(3, cliente.getEndereco().getPais());
                pstmt2.setString(4, cliente.getEndereco().getEstado());
                pstmt2.setString(5, cliente.getEndereco().getCidade());
                pstmt2.setString(6, cliente.getEndereco().getRua());
                pstmt2.setString(7, String.valueOf(cliente.getEndereco().getNumero()));
                pstmt2.setString(8, cliente.getEndereco().getComplemento());
                pstmt2.setString(9, cliente.getEndereco().getCep());
                pstmt2.executeUpdate();

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
        public ResultSet consultaEndereco() {
        if (conectaBD()) {
            try {
                String SQL2 = "SELECT * FROM Endereco e, Cliente cl WHERE cl.Cli_CPF = e.Cli_CPF";

                stmt2 = conn.createStatement(tipo, concorrencia);

                rs2 = stmt2.executeQuery(SQL2);

                conn.close();
                return rs2;
            } catch (SQLException Erro) {
                System.out.println("Erro na execução da Querry = " + Erro);
            }
        }
        return null;
    }

    public void excluiCliente(String CPF) {
        try {
            String SQL = "DELETE FROM Cliente WHERE Cli_CPF = (?)";
            
            stmt = conn.prepareStatement(SQL, tipo, concorrencia);

            pstmt.setInt(1, Integer.parseInt(CPF));
            pstmt.executeUpdate();
            conn.commit();

        } catch (SQLException Erro) {
            System.out.println("Erro ao Deletar = " + Erro);
        }
    }
    
    public void cadastroConce(Concessionaria conce) {

        if (conectaBD()) {
            try {
                String SQL = "INSERT INTO (Concessionaria Conc_Nome, Conc_CNPJ, Conc_Tarifa) VALUES (?,?,?)";
                String SQL2 = "INSERT INTO Endereco (Cli_CPF,Conc_CNPJ,End_Pais,End_Estado,End_Cidade,"
                        + "End_Rua,End_Nume,End_Complemento,End_CEP)"
                        + "VALUES (?,?,?,?,?,?,?,?,?)";

                pstmt = conn.prepareStatement(SQL, tipo, concorrencia);
                pstmt2 = conn.prepareStatement(SQL2, tipo, concorrencia);

                pstmt.setString(1, conce.getNome());
                pstmt.setString(2, conce.getCnpj());
                pstmt.setString(3, String.valueOf(conce.getTarifa()));
                pstmt.executeUpdate();
                conn.commit();

                pstmt2.setString(1, "");
                pstmt2.setString(2, conce.getCnpj());
                pstmt2.setString(3, conce.getEndereco().getPais());
                pstmt2.setString(4, conce.getEndereco().getEstado());
                pstmt2.setString(5, conce.getEndereco().getCidade());
                pstmt2.setString(6, conce.getEndereco().getRua());
                pstmt2.setString(7, String.valueOf(conce.getEndereco().getNumero()));
                pstmt2.setString(8, conce.getEndereco().getComplemento());
                pstmt2.setString(9, conce.getEndereco().getCep());

                pstmt2.executeUpdate();

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
                String SQL2 = "SELECT * "
                                + "FROM  Endereco e, Concessionaria c "
                                + "Where e.Conc_CNPJ = c.Conc_CNPJ";
           

                stmt = conn.createStatement(tipo, concorrencia);
                stmt2 = conn.createStatement(tipo, concorrencia);

                rs = stmt.executeQuery(SQL);
                rs2 = stmt2.executeQuery(SQL2);

                conn.close();
                return rs;
            } catch (SQLException Erro) {
                System.out.println("Erro na execução da Querry = " + Erro);
            }
        }
        return null;
    }
        
            public void excluiConce(String CNPJ) {
        try {
            String SQL = "DELETE FROM Concessionaria WHERE Conc_CNPJ = (?)";
            
            stmt = conn.prepareStatement(SQL, tipo, concorrencia);

            pstmt.setInt(1, Integer.parseInt(CNPJ));
            pstmt.executeUpdate();
            conn.commit();

        } catch (SQLException Erro) {
            System.out.println("Erro ao Deletar = " + Erro);
        }
    }

}
