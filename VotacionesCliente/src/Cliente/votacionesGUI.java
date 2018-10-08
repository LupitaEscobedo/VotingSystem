package Cliente;

import Login.Login;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.FileMetadata;
import com.dropbox.core.v2.users.FullAccount;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class votacionesGUI extends javax.swing.JFrame {

    private static final String ACCESS_TOKEN = "rIPi2pi4rtAAAAAAAAAAfYsdjkQZ5frlfOerARDaX-jFArXH1I1wR5qNgSttKS-0";
    private Login login;
    private String user;
    private DbxRequestConfig config = null;
    DbxClientV2 client = null;
    FullAccount account = null;

    public votacionesGUI() throws DbxException{
        initComponents();
        cargarImagenes();
    }
    
    public votacionesGUI(Login login, boolean block, String user) throws DbxException {
        this.login = login;
        this.user = user;
        initComponents();
        cargarImagenes();
        if(block)
             blockButtons();
        addEventos();
    }
    
    public void cargarImagenes() throws DbxException{
        config = new DbxRequestConfig("dropbox/java-tutorial");
        client = new DbxClientV2(config, ACCESS_TOKEN);
        String path = "/home/lupita/Candidatos/";
        try {
            FileOutputStream downloadFile1 = new FileOutputStream(path + "amlo.jpg");
            FileOutputStream downloadFile2 = new FileOutputStream(path + "meade.jpg");
            FileOutputStream downloadFile3 = new FileOutputStream(path + "anaya.jpg");
            FileOutputStream downloadFile4 = new FileOutputStream(path + "bronco.jpg");
            try {
                FileMetadata metadata = client.files().downloadBuilder("/Candidatos/amlo.jpg").download(downloadFile1);
                metadata = client.files().downloadBuilder("/Candidatos/meade.jpg").download(downloadFile2);
                metadata = client.files().downloadBuilder("/Candidatos/anaya.jpg").download(downloadFile3);
                metadata = client.files().downloadBuilder("/Candidatos/bronco.jpg").download(downloadFile4);
            } finally {
                downloadFile1.close();
                downloadFile2.close();
                downloadFile3.close();
                downloadFile4.close();
            }
        }
        catch (DbxException | IOException e) {}
        etiquetaFotoAmlo.setIcon(new javax.swing.ImageIcon(path + "amlo.jpg"));
        etiquetaFotoMeade.setIcon(new javax.swing.ImageIcon(path + "meade.jpg"));
        etiquetaFotoAnaya.setIcon(new javax.swing.ImageIcon(path + "anaya.jpg"));
        etiquetaFotoBronco.setIcon(new javax.swing.ImageIcon(path + "bronco.jpg"));
        
        //etiquetaFotoAmlo.setIcon(new javax.swing.ImageIcon("/home/lupita/Imágenes/Candidatos/anlo.jpg")); // NOI18N
    }
    
    public void addEventos(){
        Oyente oyente = new Oyente(login, user, this);
        verAmlo.addActionListener(oyente);
        seleccionarAmlo.addActionListener(oyente);
        verMeade.addActionListener(oyente);
        seleccionarMeade.addActionListener(oyente);
        verAnaya.addActionListener(oyente);
        seleccionarAnaya.addActionListener(oyente);
        verBronco.addActionListener(oyente);
        seleccionarBronco.addActionListener(oyente);
        botonCerrarSesion.addActionListener(oyente);
    }
    
    public void blockButtons(){
        this.seleccionarAmlo.setEnabled(false);
        this.seleccionarMeade.setEnabled(false);
        this.seleccionarAnaya.setEnabled(false);
        this.seleccionarBronco.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelAmlo = new javax.swing.JPanel();
        etiquetaFotoAmlo = new javax.swing.JLabel();
        panelNombre = new javax.swing.JPanel();
        nombreAmlo = new javax.swing.JLabel();
        nombreAmlo1 = new javax.swing.JLabel();
        panelPartido = new javax.swing.JPanel();
        PartidoAmlo = new javax.swing.JLabel();
        partidoAmlo2 = new javax.swing.JLabel();
        panelBotonesAmlo = new javax.swing.JPanel();
        verAmlo = new javax.swing.JButton();
        seleccionarAmlo = new javax.swing.JButton();
        panelMeade = new javax.swing.JPanel();
        etiquetaFotoMeade = new javax.swing.JLabel();
        panelNombre1 = new javax.swing.JPanel();
        nombreMeade = new javax.swing.JLabel();
        nombreMeade1 = new javax.swing.JLabel();
        panelPartido1 = new javax.swing.JPanel();
        PartidoMeade = new javax.swing.JLabel();
        partidoMeade1 = new javax.swing.JLabel();
        panelBotonesMeade = new javax.swing.JPanel();
        verMeade = new javax.swing.JButton();
        seleccionarMeade = new javax.swing.JButton();
        panelAnaya = new javax.swing.JPanel();
        etiquetaFotoAnaya = new javax.swing.JLabel();
        panelNombre2 = new javax.swing.JPanel();
        nombreAnaya = new javax.swing.JLabel();
        nombreAnaya2 = new javax.swing.JLabel();
        panelPartido2 = new javax.swing.JPanel();
        PartidoAnaya = new javax.swing.JLabel();
        partidoAnaya = new javax.swing.JLabel();
        panelBotonesAnaya = new javax.swing.JPanel();
        verAnaya = new javax.swing.JButton();
        seleccionarAnaya = new javax.swing.JButton();
        panelBronco = new javax.swing.JPanel();
        etiquetaFotoBronco = new javax.swing.JLabel();
        panelNombre3 = new javax.swing.JPanel();
        nombreMeade2 = new javax.swing.JLabel();
        nombreMeade3 = new javax.swing.JLabel();
        panelPartido3 = new javax.swing.JPanel();
        PartidoMeade1 = new javax.swing.JLabel();
        partidoMeade2 = new javax.swing.JLabel();
        panelBotonesBronco = new javax.swing.JPanel();
        verBronco = new javax.swing.JButton();
        seleccionarBronco = new javax.swing.JButton();
        botonCerrarSesion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1260, 640));
        getContentPane().setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 8));

        panelAmlo.setBackground(new java.awt.Color(184, 48, 14));
        panelAmlo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(1, 1, 1), 5, true));
        panelAmlo.setPreferredSize(new java.awt.Dimension(305, 550));
        panelAmlo.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 10));

        etiquetaFotoAmlo.setBackground(new java.awt.Color(23, 219, 219));
        etiquetaFotoAmlo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiquetaFotoAmlo.setIcon(new javax.swing.ImageIcon("/home/lupita/Imágenes/Candidatos/anlo.jpg")); // NOI18N
        etiquetaFotoAmlo.setLabelFor(etiquetaFotoAmlo);
        etiquetaFotoAmlo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        etiquetaFotoAmlo.setName("fotoAmlo"); // NOI18N
        etiquetaFotoAmlo.setOpaque(true);
        panelAmlo.add(etiquetaFotoAmlo);

        panelNombre.setBackground(panelAmlo.getBackground());
        panelNombre.setPreferredSize(new java.awt.Dimension(280, 70));

        nombreAmlo.setBackground(panelNombre.getBackground());
        nombreAmlo.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        nombreAmlo.setForeground(new java.awt.Color(254, 254, 254));
        nombreAmlo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nombreAmlo.setLabelFor(nombreAmlo);
        nombreAmlo.setText("Nombre:");
        nombreAmlo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        nombreAmlo.setOpaque(true);
        nombreAmlo.setPreferredSize(new java.awt.Dimension(200, 25));
        panelNombre.add(nombreAmlo);

        nombreAmlo1.setBackground(panelNombre.getBackground());
        nombreAmlo1.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        nombreAmlo1.setForeground(new java.awt.Color(254, 254, 254));
        nombreAmlo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nombreAmlo1.setLabelFor(nombreAmlo);
        nombreAmlo1.setText("Andrés Manuel López Obrador");
        nombreAmlo1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        nombreAmlo1.setOpaque(true);
        nombreAmlo1.setPreferredSize(new java.awt.Dimension(250, 25));
        panelNombre.add(nombreAmlo1);

        panelAmlo.add(panelNombre);

        panelPartido.setBackground(panelAmlo.getBackground());
        panelPartido.setPreferredSize(new java.awt.Dimension(280, 70));

        PartidoAmlo.setBackground(panelPartido.getBackground());
        PartidoAmlo.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        PartidoAmlo.setForeground(new java.awt.Color(254, 254, 254));
        PartidoAmlo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PartidoAmlo.setLabelFor(nombreAmlo);
        PartidoAmlo.setText("Partido Político:");
        PartidoAmlo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        PartidoAmlo.setOpaque(true);
        PartidoAmlo.setPreferredSize(new java.awt.Dimension(200, 25));
        panelPartido.add(PartidoAmlo);

        partidoAmlo2.setBackground(panelPartido.getBackground());
        partidoAmlo2.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        partidoAmlo2.setForeground(new java.awt.Color(254, 254, 254));
        partidoAmlo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        partidoAmlo2.setLabelFor(nombreAmlo);
        partidoAmlo2.setText("MORENA, PT, PES");
        partidoAmlo2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        partidoAmlo2.setOpaque(true);
        partidoAmlo2.setPreferredSize(new java.awt.Dimension(250, 25));
        panelPartido.add(partidoAmlo2);

        panelAmlo.add(panelPartido);

        panelBotonesAmlo.setBackground(panelAmlo.getBackground());
        panelBotonesAmlo.setPreferredSize(new java.awt.Dimension(250, 60));
        panelBotonesAmlo.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 10));

        verAmlo.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        verAmlo.setText("Ver más");
        verAmlo.setName("verAmlo"); // NOI18N
        verAmlo.setPreferredSize(new java.awt.Dimension(110, 40));
        panelBotonesAmlo.add(verAmlo);

        seleccionarAmlo.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        seleccionarAmlo.setText("Votar");
        seleccionarAmlo.setName("votarAmlo"); // NOI18N
        seleccionarAmlo.setPreferredSize(new java.awt.Dimension(110, 40));
        panelBotonesAmlo.add(seleccionarAmlo);

        panelAmlo.add(panelBotonesAmlo);

        getContentPane().add(panelAmlo);

        panelMeade.setBackground(new java.awt.Color(12, 148, 12));
        panelMeade.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(1, 1, 1), 5, true));
        panelMeade.setPreferredSize(new java.awt.Dimension(305, 550));
        panelMeade.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 10));

        etiquetaFotoMeade.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiquetaFotoMeade.setIcon(new javax.swing.ImageIcon("/home/lupita/Imágenes/Candidatos/meade.jpg")); // NOI18N
        etiquetaFotoMeade.setLabelFor(etiquetaFotoAmlo);
        etiquetaFotoMeade.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        etiquetaFotoMeade.setName("fotoAmlo"); // NOI18N
        etiquetaFotoMeade.setOpaque(true);
        panelMeade.add(etiquetaFotoMeade);

        panelNombre1.setBackground(panelMeade.getBackground());
        panelNombre1.setPreferredSize(new java.awt.Dimension(280, 70));

        nombreMeade.setBackground(panelNombre1.getBackground());
        nombreMeade.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        nombreMeade.setForeground(new java.awt.Color(254, 254, 254));
        nombreMeade.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nombreMeade.setLabelFor(nombreAmlo);
        nombreMeade.setText("Nombre:");
        nombreMeade.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        nombreMeade.setOpaque(true);
        nombreMeade.setPreferredSize(new java.awt.Dimension(200, 25));
        panelNombre1.add(nombreMeade);

        nombreMeade1.setBackground(panelNombre1.getBackground());
        nombreMeade1.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        nombreMeade1.setForeground(new java.awt.Color(254, 254, 254));
        nombreMeade1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nombreMeade1.setLabelFor(nombreAmlo);
        nombreMeade1.setText("José Antonio Meade Kuribreña");
        nombreMeade1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        nombreMeade1.setOpaque(true);
        nombreMeade1.setPreferredSize(new java.awt.Dimension(250, 25));
        panelNombre1.add(nombreMeade1);

        panelMeade.add(panelNombre1);

        panelPartido1.setBackground(panelMeade.getBackground());
        panelPartido1.setPreferredSize(new java.awt.Dimension(280, 70));

        PartidoMeade.setBackground(panelPartido1.getBackground());
        PartidoMeade.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        PartidoMeade.setForeground(new java.awt.Color(254, 254, 254));
        PartidoMeade.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PartidoMeade.setLabelFor(nombreAmlo);
        PartidoMeade.setText("Partido Político:");
        PartidoMeade.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        PartidoMeade.setOpaque(true);
        PartidoMeade.setPreferredSize(new java.awt.Dimension(200, 25));
        panelPartido1.add(PartidoMeade);

        partidoMeade1.setBackground(panelPartido1.getBackground());
        partidoMeade1.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        partidoMeade1.setForeground(new java.awt.Color(254, 254, 254));
        partidoMeade1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        partidoMeade1.setLabelFor(nombreAmlo);
        partidoMeade1.setText("PRI, PVEM, PANAL");
        partidoMeade1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        partidoMeade1.setOpaque(true);
        partidoMeade1.setPreferredSize(new java.awt.Dimension(250, 25));
        panelPartido1.add(partidoMeade1);

        panelMeade.add(panelPartido1);

        panelBotonesMeade.setBackground(panelMeade.getBackground());
        panelBotonesMeade.setPreferredSize(new java.awt.Dimension(250, 60));
        panelBotonesMeade.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 10));

        verMeade.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        verMeade.setText("Ver más");
        verMeade.setName("verMeade"); // NOI18N
        verMeade.setPreferredSize(new java.awt.Dimension(110, 40));
        panelBotonesMeade.add(verMeade);

        seleccionarMeade.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        seleccionarMeade.setText("Votar");
        seleccionarMeade.setName("votarMeade"); // NOI18N
        seleccionarMeade.setPreferredSize(new java.awt.Dimension(110, 40));
        panelBotonesMeade.add(seleccionarMeade);

        panelMeade.add(panelBotonesMeade);

        getContentPane().add(panelMeade);

        panelAnaya.setBackground(new java.awt.Color(9, 50, 209));
        panelAnaya.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(1, 1, 1), 5, true));
        panelAnaya.setPreferredSize(new java.awt.Dimension(305, 550));
        panelAnaya.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 10));

        etiquetaFotoAnaya.setBackground(new java.awt.Color(23, 219, 219));
        etiquetaFotoAnaya.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiquetaFotoAnaya.setIcon(new javax.swing.ImageIcon("/home/lupita/Imágenes/Candidatos/anaya.jpg")); // NOI18N
        etiquetaFotoAnaya.setLabelFor(etiquetaFotoAmlo);
        etiquetaFotoAnaya.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        etiquetaFotoAnaya.setName("fotoAmlo"); // NOI18N
        etiquetaFotoAnaya.setOpaque(true);
        panelAnaya.add(etiquetaFotoAnaya);

        panelNombre2.setBackground(panelAnaya.getBackground());
        panelNombre2.setPreferredSize(new java.awt.Dimension(290, 70));

        nombreAnaya.setBackground(panelAnaya.getBackground());
        nombreAnaya.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        nombreAnaya.setForeground(new java.awt.Color(254, 254, 254));
        nombreAnaya.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nombreAnaya.setLabelFor(nombreAmlo);
        nombreAnaya.setText("Nombre:");
        nombreAnaya.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        nombreAnaya.setOpaque(true);
        nombreAnaya.setPreferredSize(new java.awt.Dimension(200, 25));
        panelNombre2.add(nombreAnaya);

        nombreAnaya2.setBackground(panelAnaya.getBackground());
        nombreAnaya2.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        nombreAnaya2.setForeground(new java.awt.Color(254, 254, 254));
        nombreAnaya2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nombreAnaya2.setLabelFor(nombreAmlo);
        nombreAnaya2.setText("Ricardo Anaya Cortés");
        nombreAnaya2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        nombreAnaya2.setOpaque(true);
        nombreAnaya2.setPreferredSize(new java.awt.Dimension(280, 25));
        panelNombre2.add(nombreAnaya2);

        panelAnaya.add(panelNombre2);

        panelPartido2.setBackground(panelAnaya.getBackground());
        panelPartido2.setPreferredSize(new java.awt.Dimension(290, 70));

        PartidoAnaya.setBackground(panelAnaya.getBackground());
        PartidoAnaya.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        PartidoAnaya.setForeground(new java.awt.Color(254, 254, 254));
        PartidoAnaya.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PartidoAnaya.setLabelFor(nombreAmlo);
        PartidoAnaya.setText("Partido Político:");
        PartidoAnaya.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        PartidoAnaya.setOpaque(true);
        PartidoAnaya.setPreferredSize(new java.awt.Dimension(200, 25));
        panelPartido2.add(PartidoAnaya);

        partidoAnaya.setBackground(panelAnaya.getBackground());
        partidoAnaya.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        partidoAnaya.setForeground(new java.awt.Color(254, 254, 254));
        partidoAnaya.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        partidoAnaya.setLabelFor(nombreAmlo);
        partidoAnaya.setText("PAN, PRD, Movimiento Ciudadano");
        partidoAnaya.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        partidoAnaya.setOpaque(true);
        partidoAnaya.setPreferredSize(new java.awt.Dimension(280, 25));
        panelPartido2.add(partidoAnaya);

        panelAnaya.add(panelPartido2);

        panelBotonesAnaya.setBackground(panelAnaya.getBackground());
        panelBotonesAnaya.setPreferredSize(new java.awt.Dimension(250, 60));
        panelBotonesAnaya.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 10));

        verAnaya.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        verAnaya.setText("Ver más");
        verAnaya.setName("verAnaya"); // NOI18N
        verAnaya.setPreferredSize(new java.awt.Dimension(110, 40));
        panelBotonesAnaya.add(verAnaya);

        seleccionarAnaya.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        seleccionarAnaya.setText("Votar");
        seleccionarAnaya.setName("votarAnaya"); // NOI18N
        seleccionarAnaya.setPreferredSize(new java.awt.Dimension(110, 40));
        panelBotonesAnaya.add(seleccionarAnaya);

        panelAnaya.add(panelBotonesAnaya);

        getContentPane().add(panelAnaya);

        panelBronco.setBackground(new java.awt.Color(181, 183, 28));
        panelBronco.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(1, 1, 1), 5, true));
        panelBronco.setPreferredSize(new java.awt.Dimension(305, 550));
        panelBronco.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 10));

        etiquetaFotoBronco.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiquetaFotoBronco.setIcon(new javax.swing.ImageIcon("/home/lupita/Imágenes/Candidatos/bronco.jpg")); // NOI18N
        etiquetaFotoBronco.setLabelFor(etiquetaFotoAmlo);
        etiquetaFotoBronco.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        etiquetaFotoBronco.setName("fotoAmlo"); // NOI18N
        etiquetaFotoBronco.setOpaque(true);
        panelBronco.add(etiquetaFotoBronco);

        panelNombre3.setBackground(panelBronco.getBackground());
        panelNombre3.setPreferredSize(new java.awt.Dimension(290, 70));

        nombreMeade2.setBackground(panelBronco.getBackground());
        nombreMeade2.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        nombreMeade2.setForeground(new java.awt.Color(254, 254, 254));
        nombreMeade2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nombreMeade2.setLabelFor(nombreAmlo);
        nombreMeade2.setText("Nombre:");
        nombreMeade2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        nombreMeade2.setOpaque(true);
        nombreMeade2.setPreferredSize(new java.awt.Dimension(200, 25));
        panelNombre3.add(nombreMeade2);

        nombreMeade3.setBackground(panelBronco.getBackground());
        nombreMeade3.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        nombreMeade3.setForeground(new java.awt.Color(254, 254, 254));
        nombreMeade3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nombreMeade3.setLabelFor(nombreAmlo);
        nombreMeade3.setText("Jaime Heliodoro Rodríguez Calderón");
        nombreMeade3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        nombreMeade3.setOpaque(true);
        nombreMeade3.setPreferredSize(new java.awt.Dimension(280, 25));
        panelNombre3.add(nombreMeade3);

        panelBronco.add(panelNombre3);

        panelPartido3.setBackground(panelBronco.getBackground());
        panelPartido3.setPreferredSize(new java.awt.Dimension(280, 70));

        PartidoMeade1.setBackground(panelBronco.getBackground());
        PartidoMeade1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        PartidoMeade1.setForeground(new java.awt.Color(254, 254, 254));
        PartidoMeade1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PartidoMeade1.setLabelFor(nombreAmlo);
        PartidoMeade1.setText("Partido Político:");
        PartidoMeade1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        PartidoMeade1.setOpaque(true);
        PartidoMeade1.setPreferredSize(new java.awt.Dimension(200, 25));
        panelPartido3.add(PartidoMeade1);

        partidoMeade2.setBackground(panelBronco.getBackground());
        partidoMeade2.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        partidoMeade2.setForeground(new java.awt.Color(254, 254, 254));
        partidoMeade2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        partidoMeade2.setLabelFor(nombreAmlo);
        partidoMeade2.setText("PRI, PVEM, PANAL");
        partidoMeade2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        partidoMeade2.setOpaque(true);
        partidoMeade2.setPreferredSize(new java.awt.Dimension(250, 25));
        panelPartido3.add(partidoMeade2);

        panelBronco.add(panelPartido3);

        panelBotonesBronco.setBackground(panelBronco.getBackground());
        panelBotonesBronco.setPreferredSize(new java.awt.Dimension(250, 60));
        panelBotonesBronco.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 10));

        verBronco.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        verBronco.setText("Ver más");
        verBronco.setName("verBronco");
        verBronco.setPreferredSize(new java.awt.Dimension(110, 40));
        panelBotonesBronco.add(verBronco);

        seleccionarBronco.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        seleccionarBronco.setText("Votar");
        seleccionarBronco.setName("votarBronco");
        seleccionarBronco.setPreferredSize(new java.awt.Dimension(110, 40));
        panelBotonesBronco.add(seleccionarBronco);

        panelBronco.add(panelBotonesBronco);

        getContentPane().add(panelBronco);
        
        botonCerrarSesion.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        botonCerrarSesion.setText("Cerrar Sesión");
        botonCerrarSesion.setName("cerrarSesion");
        botonCerrarSesion.setPreferredSize(new java.awt.Dimension(200, 40));
        
        getContentPane().add(botonCerrarSesion);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel PartidoAmlo;
    private javax.swing.JLabel PartidoAnaya;
    private javax.swing.JLabel PartidoMeade;
    private javax.swing.JLabel PartidoMeade1;
    private javax.swing.JLabel etiquetaFotoAmlo;
    private javax.swing.JLabel etiquetaFotoAnaya;
    private javax.swing.JLabel etiquetaFotoBronco;
    private javax.swing.JLabel etiquetaFotoMeade;
    private javax.swing.JLabel nombreAmlo;
    private javax.swing.JLabel nombreAmlo1;
    private javax.swing.JLabel nombreAnaya;
    private javax.swing.JLabel nombreAnaya2;
    private javax.swing.JLabel nombreMeade;
    private javax.swing.JLabel nombreMeade1;
    private javax.swing.JLabel nombreMeade2;
    private javax.swing.JLabel nombreMeade3;
    private javax.swing.JPanel panelAmlo;
    private javax.swing.JPanel panelAnaya;
    private javax.swing.JPanel panelBotonesAmlo;
    private javax.swing.JPanel panelBotonesAnaya;
    private javax.swing.JPanel panelBotonesBronco;
    private javax.swing.JPanel panelBotonesMeade;
    private javax.swing.JPanel panelBronco;
    private javax.swing.JPanel panelMeade;
    private javax.swing.JPanel panelNombre;
    private javax.swing.JPanel panelNombre1;
    private javax.swing.JPanel panelNombre2;
    private javax.swing.JPanel panelNombre3;
    private javax.swing.JPanel panelPartido;
    private javax.swing.JPanel panelPartido1;
    private javax.swing.JPanel panelPartido2;
    private javax.swing.JPanel panelPartido3;
    private javax.swing.JLabel partidoAmlo2;
    private javax.swing.JLabel partidoAnaya;
    private javax.swing.JLabel partidoMeade1;
    private javax.swing.JLabel partidoMeade2;
    private javax.swing.JButton seleccionarAmlo;
    private javax.swing.JButton seleccionarAnaya;
    private javax.swing.JButton seleccionarMeade;
    private javax.swing.JButton seleccionarBronco;
    private javax.swing.JButton verAmlo;
    private javax.swing.JButton verAnaya;
    private javax.swing.JButton verMeade;
    private javax.swing.JButton verBronco;
    private javax.swing.JButton botonCerrarSesion;
    // End of variables declaration//GEN-END:variables
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(votacionesGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new votacionesGUI().setVisible(true);
                } catch (DbxException ex) {
                    Logger.getLogger(votacionesGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
}