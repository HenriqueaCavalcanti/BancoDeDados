package application;

import db.DB;
import db.DbException;
import db.DbIntegrityException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Banco_Dados {
    public static void main(String[] args) {

        Connection conn = null;
        Statement st = null;

        try {
            conn = DB.getConnection();

            conn.setAutoCommit(false);

            st = conn.createStatement();

            int linhas = st.executeUpdate("UPDATE seller SET BaseSalary = 2090 WHERE DepartmentId = 1");

            int x = 1;
//            if (x < 2) {
//                throw new SQLException("Fake error");
//            }

            int linhas2 = st.executeUpdate("UPDATE seller SET BaseSalary = 3090 WHERE DepartmentId = 2");

            conn.commit();

            System.out.println("Linha 1 " + linhas);
            System.out.println("Linha 2 " + linhas2);
        } catch (SQLException e) {
            try {
                conn.rollback();
                throw new DbException("Transação falhou! Erro: " + e.getMessage());
            } catch (SQLException ex) {
                throw new DbException("Erro enquanto tentava voltar a transação! Causa: " + ex.getMessage());
            }
        }
    }
}
