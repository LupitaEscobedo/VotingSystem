package Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class fusuarios {

    private final conexion mysql = new conexion();
    private final Connection cn = mysql.conectar();
    private String sSQL = "USE votaciones";
    private String sSQL2 = "";

    public boolean validarPass(String user, String contraseña) {
        boolean res = false;
        sSQL = "USE votaciones";
        sSQL2 = "SELECT usuario, password FROM `users` WHERE usuario = '" + user + "' AND password = '" + contraseña + "'";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            ResultSet rs2 = st.executeQuery(sSQL2);
            while (rs2.next()) {
                if (rs2.getString("usuario").equals(user) && rs2.getString("password").equals(contraseña)) {
                    res = true;
                } else {
                    res = false;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(fusuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    public boolean validarVoto(String user) {
        boolean res = true;
        sSQL = "USE votaciones";
        sSQL2 = "SELECT voto FROM `users` WHERE usuario = '" + user + "'";
        try {

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            ResultSet rs2 = st.executeQuery(sSQL2);
            while (rs2.next()) {
                //System.out.println(rs2.getString("voto_candidato"));
                if (rs2.getString("voto").equals("100")) {
                    res = false;
                } else {
                    res = true;
                }
            }

        } catch (SQLException ex) {}
        return res;
    }

    public void registrarVoto(int voto, String user) {
        sSQL = "USE votaciones";
        sSQL2 = "UPDATE `users` set voto = ? WHERE usuario = ?";
        try {

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            PreparedStatement pst2 = cn.prepareStatement(sSQL2);
            pst2.setInt(1, voto);
            pst2.setString(2, user);
            pst2.execute();
            
            sSQL2 = "UPDATE `candidatos` set votos = votos + 1 WHERE id_candidato = ?";
            PreparedStatement pst = cn.prepareStatement(sSQL2);
            pst.setInt(1, voto);
            pst.execute();

        } catch (SQLException ex) {}
    }
    
    public boolean existeUsuario(String user){
        boolean res = false;
        sSQL = "USE votaciones";
        sSQL2 = "SELECT usuario FROM `users` WHERE usuario = '" + user + "'";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            ResultSet rs2 = st.executeQuery(sSQL2);
            while (rs2.next()) {
                return true;
            }
            return false;
        } catch (SQLException ex) {}
        return res;
    }

    public void registrarUsuario(String name, String paterno, String materno, String user, String password) {
        sSQL2 = "INSERT INTO `users`(`nombre`, `paterno`, `materno`, `usuario`, `password`, `voto`) VALUES (";
        sSQL2 += "'" + name + "', '" + paterno + "', '" + materno + "', '" + user + "', '" + password + "', 100)";
        System.out.println("Consulta: " + sSQL2);
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            PreparedStatement pst = cn.prepareStatement(sSQL2);
            pst.execute();
        } catch (SQLException ex) {}
    }

}
