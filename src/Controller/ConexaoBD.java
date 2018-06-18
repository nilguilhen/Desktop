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
import Model.ContaEnergia;
import Model.Endereco;

/**
 *
 * @author Ian Fraga Bitar
 */
public class ConexaoBD {

    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    private PreparedStatement pstmt = null;

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
                String SQL = "INSERTO INTO Cliente(Cli_Nome,Cli_CPF,Cli_Idade) VALUES (?,?,?)";
                int tipo = ResultSet.TYPE_SCROLL_SENSITIVE;//(c)
                int concorrencia = ResultSet.CONCUR_UPDATABLE;
                pstmt = conn.prepareStatement(SQL, tipo, concorrencia);

                pstmt.setString(1, cliente.getNome());
                pstmt.setString(2, cliente.getCpf());
                pstmt.setString(3, String.valueOf(cliente.getIdade()));
                pstmt.executeUpdate();
                conn.commit();
                conn.close();
            } catch (SQLException erro) {
                System.out.println("Erro Executa P-Update = " + erro);
            }
        }
    }

    public ResultSet consultaCliente() {
        if (conectaBD()) {
            try {
                String SQL = "SELECT * FROM Cliente";
                int tipo = ResultSet.TYPE_SCROLL_SENSITIVE;//(c)
                int concorrencia = ResultSet.CONCUR_UPDATABLE;
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
        try {
            String SQL = "DELETE FROM Cliente WHERE Cli_CPF = (?)";
            int tipo = ResultSet.TYPE_SCROLL_SENSITIVE;//(c)
            int concorrencia = ResultSet.CONCUR_UPDATABLE;
            stmt = conn.prepareStatement(SQL, tipo, concorrencia);

            pstmt.setInt(1, Integer.parseInt(CPF));
            pstmt.executeUpdate();
            conn.commit();

        } catch (SQLException Erro) {
            System.out.println("Erro ao Deletar = " + Erro);
        }
    }

}
