package application;


import db.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Banco_Dados {
    public static void main(String[] args) {

        Connection conn = null;
        PreparedStatement st = null;

        try{
            conn = DB.getConnection();

            st = conn.prepareStatement("UPDATE seller "
            + "SET BaseSalary = BaseSalary + ? "
            + "WHERE "
            + "(DepartmentId = ?)");

            st.setDouble(1, 200);
            st.setInt(2, 2);

            int linhasAfetadas = st.executeUpdate();

            System.out.println("Pronto! Linhas afetadas: " + linhasAfetadas);
        }catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }
}
