package Login;

/**
* LoginOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from votaciones.idl
* martes 5 de junio de 2018 10:36:12 PM CDT
*/


// votaciones.idl
public interface LoginOperations 
{
  String login (String user, String password);
  String registrar (String nombre, String paterno, String materno, String user, String password);
  void vote (String user, String candidato);
} // interface LoginOperations
