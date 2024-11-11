package viewsAccueil;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class FAccueilView extends JFrame {
    private static final long serialVersionUID = 1L;

    // Menu items and buttons
    private JMenuItem mntmQuitter, mntmClients, mntmArticles, mntmCommandes, mntmParametres;
    private JButton btnQuitter, btnClients, btnArticles, btnStats, btnCommandes, btnParametres;
    private JLabel lblInfos;

    public FAccueilView() {
        setTitle("Accueil");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 926, 686);
        setLocationRelativeTo(null);

        // Menu Bar
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu mnFichier = new JMenu("Fichier");
        menuBar.add(mnFichier);

        mntmParametres = new JMenuItem("Paramètres");
        mnFichier.add(mntmParametres);

        JSeparator separator = new JSeparator();
        mnFichier.add(separator);

        mntmQuitter = new JMenuItem("Quitter");
        mnFichier.add(mntmQuitter);

        JMenu mnVues = new JMenu("Vues");
        menuBar.add(mnVues);

        mntmClients = new JMenuItem("Clients");
        mnVues.add(mntmClients);

        mntmArticles = new JMenuItem("Articles");
        mnVues.add(mntmArticles);

        mntmCommandes = new JMenuItem("Commandes");
        mnVues.add(mntmCommandes);

        // Left Panel
        JPanel panel_menu = new JPanel();
        panel_menu.setBorder(new EmptyBorder(5, 5, 5, 5));
        panel_menu.setBackground(SystemColor.controlShadow);
        panel_menu.setBounds(0, 0, 100, 150);
        add(panel_menu, BorderLayout.WEST);

        JLabel lblTitre = new JLabel("SARL Gestion");
        lblTitre.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitre.setFont(lblTitre.getFont().deriveFont(33f));

        lblInfos = new JLabel("Affichage option");
        lblInfos.setForeground(SystemColor.control);
        lblInfos.setBackground(SystemColor.controlShadow);
        lblInfos.setOpaque(true);
        lblInfos.setHorizontalAlignment(SwingConstants.CENTER);
        lblInfos.setFont(lblInfos.getFont().deriveFont(21f));

        btnQuitter = new JButton("Quitter");

        GroupLayout gl_panel_menu = new GroupLayout(panel_menu);
        gl_panel_menu.setHorizontalGroup(
                gl_panel_menu.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(btnQuitter, GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                        .addComponent(lblTitre, GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                        .addComponent(lblInfos, GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
        );
        gl_panel_menu.setVerticalGroup(
                gl_panel_menu.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_panel_menu.createSequentialGroup()
                                .addGap(7)
                                .addComponent(lblTitre)
                                .addGap(30)
                                .addComponent(lblInfos)
                                .addGap(348)
                                .addComponent(btnQuitter)
                                .addContainerGap(81, Short.MAX_VALUE))
        );
        panel_menu.setLayout(gl_panel_menu);

        // Main Panel
        JPanel panel_principal = new JPanel();
        panel_principal.setBorder(new EmptyBorder(5, 0, 5, 5));
        add(panel_principal, BorderLayout.CENTER);

        // Define preferred button size
        Dimension buttonSize = new Dimension(100, 40);  // Set a smaller size

        // Set up main panel layout and add buttons with the preferred size
        panel_principal.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 15));

        btnArticles = new JButton("Articles");
        btnArticles.setPreferredSize(buttonSize);
        panel_principal.add(btnArticles);

        btnClients = new JButton("Clients");
        btnClients.setPreferredSize(buttonSize);
        panel_principal.add(btnClients);

        btnStats = new JButton("Statistiques");
        btnStats.setPreferredSize(buttonSize);
        panel_principal.add(btnStats);

        btnCommandes = new JButton("Commandes");
        btnCommandes.setPreferredSize(buttonSize);
        panel_principal.add(btnCommandes);

        btnParametres = new JButton("Paramètres");
        btnParametres.setPreferredSize(buttonSize);
        panel_principal.add(btnParametres);
    }

    public void addQuitterListener(ActionListener listener) {
        mntmQuitter.addActionListener(listener);
        btnQuitter.addActionListener(listener);
    }

    public void addArticlesListener(ActionListener listener) {
        mntmArticles.addActionListener(listener);
        btnArticles.addActionListener(listener);
    }

    public void addClientsListener(ActionListener listener) {
        mntmClients.addActionListener(listener);
        btnClients.addActionListener(listener);
    }

    public void addCommandesListener(ActionListener listener) {
        mntmCommandes.addActionListener(listener);
        btnCommandes.addActionListener(listener);
    }

    public void setInfoText(String text) {
        lblInfos.setText(text);
    }
}
