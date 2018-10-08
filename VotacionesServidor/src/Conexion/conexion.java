package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class conexion {

    private Connection conexion;
    public String db = "votaciones";
    public String server = "jdbc:mysql://db4free.net/";
    public String user = "estudillo";
    public String password = "itachi22";

    public void conexionprueba() {

        try {

            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection(server, user, password);
            System.out.println("conexión a BD perfecta");

        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showConfirmDialog(null, e);

        }
    }

    public Connection conectar() {
        Connection link = null;

        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            link = DriverManager.getConnection(server, user, password);
            System.out.println("conexion exitosa");

        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showConfirmDialog(null, e);

        }

        return link;
    }
}
