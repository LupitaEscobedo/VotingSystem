package Cliente;

import Login.Login;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Oyente implements ActionListener{

    private Login login;
    private String user;
    private votacionesGUI votaciones;

    public Oyente(Login login, String user, votacionesGUI votaciones){
        this.login = login;
        this.user = user;
        this.votaciones = votaciones;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        JButton button = (JButton) ae.getSource();
        switch(button.getName()){
            case "verAmlo":
                new informacionAmlo().setVisible(true);
                break;
            case "votarAmlo":
                int input = JOptionPane.showOptionDialog(null, "¿Está seguro que desea votar por AMLO?", "", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
                if(input == JOptionPane.OK_OPTION){
                    login.vote(user, "Amlo");
                    JOptionPane.showMessageDialog(null, "¡Su voto ha sido registrado!");
                    votaciones.blockButtons();
                }
                break;
            case "verMeade":
                new informacionMeade().setVisible(true);
                break;
            case "votarMeade":
                input = JOptionPane.showOptionDialog(null, "¿Está seguro que desea votar por MEADE?", "", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
                if(input == JOptionPane.OK_OPTION){
                    login.vote(user, "Meade");
                    JOptionPane.showMessageDialog(null, "¡Su voto ha sido registrado!");
                    votaciones.blockButtons();
                }
                break;
            case "verAnaya":
                new informacionAnaya().setVisible(true);
                break;
            case "votarAnaya":
                input = JOptionPane.showOptionDialog(null, "¿Está seguro que desea votar por ANAYA?", "", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
                if(input == JOptionPane.OK_OPTION){
                    login.vote(user, "Anaya");
                    JOptionPane.showMessageDialog(null, "¡Su voto ha sido registrado!");
                    votaciones.blockButtons();
                }
                break;
            case "verBronco":
                new informacionBronco().setVisible(true);
                break;
            case "votarBronco":
                input = JOptionPane.showOptionDialog(null, "¿Está seguro que desea votar por BRONCO?", "", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
                if(input == JOptionPane.OK_OPTION){
                    login.vote(user, "Bronco");
                    JOptionPane.showMessageDialog(null, "¡Su voto ha sido registrado!");
                    votaciones.blockButtons();
                }
                break;
            case "cerrarSesion":
                InicioSesion inicio = new InicioSesion(login);
                votaciones.dispose();
                break;
        }
    }
    
}
