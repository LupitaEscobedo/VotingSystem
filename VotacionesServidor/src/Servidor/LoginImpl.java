package Servidor;

import Conexion.fusuarios;
import Login.LoginPOA;

public class LoginImpl extends LoginPOA{

    private final fusuarios usuarios;
    
    public LoginImpl(){
        usuarios = new fusuarios();
    }
    
    @Override
    public String login(String user, String password) {
        
        boolean exist = usuarios.validarPass(user, password);
        if(!exist)
            return "Invalid";
        
        boolean vote = usuarios.validarVoto(user);
        if(vote)
            return "Voted";
        
        return "OK";
    }

    @Override
    public String registrar(String name, String paterno, String materno, String user, String password) {
        if(usuarios.existeUsuario(user))
            return "Exist";
        usuarios.registrarUsuario(name, paterno, materno, user, password);
        return "OK";
    }

    @Override
    public void vote(String user, String candidato) {
        switch(candidato){
            case "Amlo":
                usuarios.registrarVoto(101, user);
                break;
            case "Meade":
                usuarios.registrarVoto(102, user);
                break;
            case "Anaya":
                usuarios.registrarVoto(103, user);
                break;
            case "Bronco":
                usuarios.registrarVoto(104, user);
                break;
        }
    }
}