/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Funcionario;
import model.Obra;
import model.Pagamento;

/**
 *
 * @author mathe
 */
public class AcessaBD {

    private Connection connection = null;
    private Statement stdados = null;
    private ResultSet rsdados = null;
    private PreparedStatement pstdados = null;

    public AcessaBD() {
    }

    public boolean acessaBD() {
        try {
            String usuario = "postgres";
            String senha = "root";

            Class.forName("org.postgresql.Driver");  //para acesso ao banco de dados Postgre
            String urlconexao = "jdbc:postgresql://127.0.0.1/obras"; //para acesso ao banco de dados fabricio, usando o banco de dados Postgre.
            connection = DriverManager.getConnection(urlconexao, usuario, senha);
            connection.setAutoCommit(false);//configuracao necessaria para confirmacao ou nao de alteracoes no banco de dados.
            DatabaseMetaData dbmt = connection.getMetaData();
            System.out.println("Nome do BD: " + dbmt.getDatabaseProductName());
            System.out.println("Versao do BD: " + dbmt.getDatabaseProductVersion());
            System.out.println("URL: " + dbmt.getURL());
            System.out.println("Driver: " + dbmt.getDriverName());
            System.out.println("Versao Driver: " + dbmt.getDriverVersion());
            System.out.println("Usuario: " + dbmt.getUserName());
        } catch (ClassNotFoundException erro) {
            System.out.println("Falha ao carregar o driver JDBC/ODBC." + erro);
            return false;
        } catch (SQLException erro) {
            System.out.println("Falha na conexao, comando sql = " + erro);
            return false;
        }
        return true;
    }

    public void inserirFuncionario(Funcionario func) {
        if (acessaBD()) {
            try {
                String sqldml = "INSERT INTO funcionario(fun_nome,fun_cpf) VALUES (?,?)";
                int tipo = ResultSet.TYPE_SCROLL_SENSITIVE;//(c)
                int concorrencia = ResultSet.CONCUR_UPDATABLE;
                pstdados = connection.prepareStatement(sqldml, tipo, concorrencia);

                pstdados.setString(1, func.getNome());
                pstdados.setString(2, func.getCPF());

                pstdados.executeUpdate();
                connection.commit();
                connection.close();
            } catch (SQLException erro) {
                System.out.println("Erro Executa P-Update = " + erro);
            }
        }
    }

    public ResultSet consultaFuncionario() {
        if (acessaBD()) {
            try {
                String sqldql = "SELECT * FROM funcionario";
                int tipo = ResultSet.TYPE_SCROLL_SENSITIVE;//(c)
                int concorrencia = ResultSet.CONCUR_UPDATABLE;
                stdados = connection.createStatement(tipo, concorrencia);
                rsdados = stdados.executeQuery(sqldql);

                connection.close();
                return rsdados;
            } catch (SQLException erro) {
                System.out.println("Erro Executa Query = " + erro);
            }
        }
        return null;
    }

    public void excluiFuncionario(int fun_id) {
        try {
            String sqldml = "DELETE FROM funcionario WHERE fun_id=(?)";
            int tipo = ResultSet.TYPE_SCROLL_SENSITIVE;//(c)
            int concorrencia = ResultSet.CONCUR_UPDATABLE;
            pstdados = connection.prepareStatement(sqldml, tipo, concorrencia);

            pstdados.setInt(1, fun_id);
            pstdados.executeUpdate();
            connection.commit();

        } catch (SQLException erro) {
            System.out.println("Erro Executa P-Update = " + erro);
        }
    }

    public void inserirObra(Obra ob) {
        if (acessaBD()) {
            try {
                String sqldml = "INSERT INTO obra(obr_nome, obr_fone,obr_dia,obr_mes,obr_ano,obr_tempoest,"
                        + "obr_tempomed,obr_cpf,obr_endereco,obr_valortotal,funcionario_fun_id) "
                        + "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
                int tipo = ResultSet.TYPE_SCROLL_SENSITIVE;//(c)
                int concorrencia = ResultSet.CONCUR_UPDATABLE;
                pstdados = connection.prepareStatement(sqldml, tipo, concorrencia);

                pstdados.setString(1, ob.getNome());
                pstdados.setString(2, ob.getFone());
                pstdados.setInt(3, ob.getDia());
                pstdados.setInt(4, ob.getMes());
                pstdados.setInt(5, ob.getAno());
                pstdados.setInt(6, ob.getTempoEstimado());
                pstdados.setString(7, ob.getTempoMedida());
                pstdados.setString(8, ob.getCPF());
                pstdados.setString(9, ob.getEndereco());
                pstdados.setString(10, ob.getValorTotal());
                pstdados.setInt(11, ob.getFuncionario().getId());
                pstdados.executeUpdate();
                connection.commit();
                connection.close();
            } catch (SQLException erro) {
                System.out.println("Erro Executa P-Update = " + erro);
            }
        }
    }

    public ResultSet consultaObra() {
        if (acessaBD()) {
            try {
                String sqldql = "select * from obra,funcionario where funcionario_fun_id = fun_id;";
                //tring sqldql = "select * from obra";
                int tipo = ResultSet.TYPE_SCROLL_SENSITIVE;//(c)
                int concorrencia = ResultSet.CONCUR_UPDATABLE;
                stdados = connection.createStatement(tipo, concorrencia);
                rsdados = stdados.executeQuery(sqldql);
                
                connection.close();
                
                return rsdados;
            } catch (SQLException erro) {
                System.out.println("Erro Executa Query = " + erro);
            }
        }
        return null;

    }

    public void excluiObra(int obr_id) {
        if (acessaBD()) {
            try {
                String sqldml = "DELETE FROM obra WHERE obr_id=(?)";
                int tipo = ResultSet.TYPE_SCROLL_SENSITIVE;//(c)
                int concorrencia = ResultSet.CONCUR_UPDATABLE;
                pstdados = connection.prepareStatement(sqldml, tipo, concorrencia);

                pstdados.setInt(1, obr_id);
                pstdados.executeUpdate();
                connection.commit();
                connection.close();

            } catch (SQLException erro) {
                System.out.println("Erro Executa P-Update = " + erro);
            }
        }
    }

    
}
