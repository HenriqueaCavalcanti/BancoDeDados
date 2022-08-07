package application;

import db.DB;
import db.DbIntegrityException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Banco_Dados {
    public static void main(String[] args) {

        Connection conn = null;
        PreparedStatement st = null;

        try{
            conn = DB.getConnection();

            st = conn.prepareStatement("DELETE FROM department "
                    + "WHERE "
                    + "Id = ?");

            st.setInt(1, 7);



            int linhasAlteradas = st.executeUpdate();

            System.out.println("Linhas afetadas: " + linhasAlteradas);

        }catch (SQLException e){
          throw new DbIntegrityException(e.getMessage());
        }
    }
}
