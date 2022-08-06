package application;

import db.DB;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Banco_Dados {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Connection coon = null;
        PreparedStatement st = null;
        try {
            coon = DB.getConnection();
           /*
            st = coon.prepareStatement(
                    "INSERT INTO seller " +
                            "(Name, Email, BirthDate, BaseSalary, DepartmentId) "
                            + "VALUES "
                            + "(?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            st.setString(1, "Henrique Alves");
            st.setString(2, "henriquealves@gmail.com");
            st.setDate(3, new java.sql.Date(sdf.parse("22/04/1985").getTime()));
            st.setDouble(4, 3000.0);
            st.setInt(5, 4);
*/

            st = coon.prepareStatement(
                    "insert into department (Name) values ('D1'), ('D2')",
                    Statement.RETURN_GENERATED_KEYS);

            int linhasAlteradas = st.executeUpdate();

            if (linhasAlteradas > 0) {
                ResultSet rs = st.getGeneratedKeys();
                while (rs.next()) {
                    int id = rs.getInt(1);
                    System.out.println("Pronto Id = " + id);
                }
            } else {
                System.out.println("Nao houve alterações.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        catch (ParseException e) {
//            e.printStackTrace();
//        }
        finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }
}
