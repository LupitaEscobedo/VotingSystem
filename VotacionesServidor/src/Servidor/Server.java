package Servidor;

import Conexion.fusuarios;
import Login.Login;
import java.io.*;
import java.util.Properties;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import static java.lang.System.*;

public class Server {

    public static void main(String args[]) {
        
        try {
            Properties props = getProperties();
            ORB orb = ORB.init(args, props);
            org.omg.CORBA.Object obj = null;
            POA rootPOA = null;

            try {
                obj = orb.resolve_initial_references("RootPOA");
                rootPOA = POAHelper.narrow(obj);
            } catch (org.omg.CORBA.ORBPackage.InvalidName e) {
            }

            LoginImpl l_impl = new LoginImpl();
            Login login = l_impl._this(orb);

            try {
                FileOutputStream file = new FileOutputStream("Login.ref");
                PrintWriter writer = new PrintWriter(file);
                String ref = orb.object_to_string(login);
                writer.println(ref);
                writer.flush();
                file.close();
                out.println("Server started." + " Stop: Ctrl-C");
            } catch (IOException ex) {
                out.println("File error: " + ex.getMessage());
                exit(2);
            }

            rootPOA.the_POAManager().activate();
            orb.run();
        } catch (Exception ex) {
            out.println("Exception: " + ex.getMessage());
            exit(1);
        }
    }
}
