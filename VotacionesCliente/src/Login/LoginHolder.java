package Login;

/**
* LoginHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from votaciones.idl
* martes 5 de junio de 2018 10:36:12 PM CDT
*/


// votaciones.idl
public final class LoginHolder implements org.omg.CORBA.portable.Streamable
{
  public Login value = null;

  public LoginHolder ()
  {
  }

  public LoginHolder (Login initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = LoginHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    LoginHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return LoginHelper.type ();
  }

}