package Cliente;

import Login.Login;
import Login.LoginHelper;
import java.io.*;
import java.util.*;
import org.omg.CORBA.*;
import javax.swing.*;
import static java.lang.System.*;

public class Client {

    private static JFrame frame;
    private static Login login;

    public static void main(String args[]) {
        try {
            Properties props = getProperties();
            ORB orb = ORB.init(args, props);
            String ref = null;
            org.omg.CORBA.Object obj = null;
            try {
                Scanner reader = new Scanner(new File("Login.ref"));
                ref = reader.nextLine();
            } catch (IOException ex) {
                out.println("File error: " + ex.getMessage());
                exit(2);
            }

            obj = orb.string_to_object(ref);
            if (obj == null) {
                out.println("Invalid IOR");
                exit(4);
            }

            login = null;
            try {
                login = LoginHelper.narrow(obj);
            } catch (BAD_PARAM ex) {
                out.println("Narrowing failed");
                exit(3);
            }

            iniciarInterfaz();

        } catch (Exception ex) {
            out.println("Exception: " + ex.getMessage());
            exit(1);
        }
    }

    public static void iniciarInterfaz() {
        
        InicioSesion inicio = new InicioSesion(login);
        
    }
    
    public void closeFramSSe(){
        frame.dispose();
    }

}
