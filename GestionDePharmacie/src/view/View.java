package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTabbedPane;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class View {

	private JFrame frameAppli;
	private JPanel panelLogin;
	private JTextField textField;
	private JButton btnLogin;
	private JTextField message;
	private JTextField motDePasse;
	private JPanel panelAppli;
	private JButton btnVente;
	private JButton btnAchats;
	private JButton btnGestionUtilisateur;
	private JPanel panelVente;
	private JComboBox comboFournisseur;
	private JComboBox comboBoxNomAchatMed;
	/**
	 * @wbp.nonvisual location=-48,404
	 */
	private final JTextPane liste = new JTextPane();
	private JButton btnDeco;
	private JTextField messageAccueil;
	private JButton btnRetourVente;
	private JPanel panelAchat;
	private JButton btnRetourAchat;
	private JPanel panelGestionUtilisateurs;
	private JButton btnRetourGestionUtilisateurs;
	private JTextArea textArea;
	private JTextField textDateOrdo;
	private JTextField textNss;
	private JTextField textNomPatient;
	private JTextField textPrenomPatient;
	private JButton btnValiderOrdo;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JScrollPane scrollPane_1;
	private JComboBox comboProduit;
	private JTextField textQteStock;
	private JTextField textQteDemande;
	private JTextField textPrixTotal;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;
	private JLabel lblNewLabel_11;
	private JButton btnAjouterPanier;
	private JButton btnModifier;
	private JButton btnSupprimer;
	private JTextField textNomCli;
	private JLabel lblNewLabel_12;
	private JTextField textPrenomCli;
	private JLabel lblNewLabel_13;
	private JLabel lblNewLabel_14;
	private JLabel lblNewLabel_15;
	private JTextField textNumCli;
	private JTextField textTelCli;
	private JButton btnValiderClient;
	private JTextField messageVente;
	private JScrollPane scrollPane;
	private JList listPanier;
	private JList listCommandes;
	private JTextField textRefAchatMed;
	private JTextField textDateFab;
	private JTextField textDateExp;
	private JTextField textQuantiteAchat;
	private JTextField textPrixUnitaire;
	private JList listES;
	private JPanel panel_1;
	private JTextField textGestNomUtilisateur;
	private JLabel lblNewLabel_24;
	private JTextField textGestPrenomUtilisateur;
	private JLabel lblNewLabel_25;
	private JTextField textGestIdUtilisateur;
	private JLabel lblNewLabel_26;
	private JTextField textGestMdpUtilisateur;
	private JLabel lblNewLabel_27;
	private JTextField textGestMailUtilisateur;
	private JLabel lblNewLabel_28;
	private JComboBox comboNiveauDroits;
	private JLabel lblNewLabel_29;
	private JButton btnAjouterUtilisateur;
	private JButton btnModifierUtilisateur;
	private JButton btnSupprimerUtilisateur;
	private JRadioButton rdbtnEntreeStock;
	private JRadioButton rdbtnSortieStock;
	private JButton btnAjouterES;
	private JButton btnModifierES;
	private JButton btnSupprimerES;
	private JList listUtilisateur;
	private JTextField textMessageGestionUtil;
	private JComboBox comboCategorie;
	private JLabel lblNewLabel_31;
	private JTextField textPrixVente;
	private JButton btnValiderPanier;
	private JTextField textAreaDescription;
	private JButton btnClientPatient;
	private JList listClient;
	private JList listPatient;
	private JPanel panelClientPatient;
	private JButton btnRetourMenuFichier;
	private JTextField textRechercherClient;
	private JButton btnRechercher;
	private JTextField textMessageAchat;
	private JButton btnRetourMenuFournisseur;
	private JTextField textNomFournisseurAjout;
	private JTextField textNomCategorieAjout;
	private JTextField textNomMedicamentAjout;
	private JButton btnValiderCategorie;
	private JButton btnValiderMedicament;
	private JButton btnGestionDesFournisseurs;
	private JPanel panelAjoutFournisseurRef;
	private JButton btnAjouterFournisseur;
	private JLabel lblNewLabel_36;
	private JTextField textAdresseFournisseur;
	private JLabel lblNewLabel_37;
	private JTextField textVilleFournisseur;
	private JLabel lblNewLabel_38;
	private JTextField textCPFournisseur;
	private JTextField textMessageGestionFour;
	private JLabel lblNewLabel_39;
	private JLabel lblNewLabel_40;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View window = new View();
					window.frameAppli.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public View() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameAppli = new JFrame();
		frameAppli.setBounds(100, 100, 924, 583);
		frameAppli.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameAppli.getContentPane().setLayout(null);
		
		panelAppli = new JPanel();
		panelAppli.setBounds(0, 0, 900, 536);
		panelAppli.setVisible(false);
		
		panelLogin = new JPanel();
		panelLogin.setBounds(0, 0, 900, 464);
		frameAppli.getContentPane().add(panelLogin);
		panelLogin.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(305, 163, 272, 19);
		panelLogin.add(textField);
		textField.setColumns(10);
		
		btnLogin = new JButton("Se connecter");
		btnLogin.setIcon(new ImageIcon("img\\connecter.png"));
		btnLogin.setBounds(495, 286, 158, 47);
		panelLogin.add(btnLogin);
		
		JLabel lblNewLabel = new JLabel("Identifiant :");
		lblNewLabel.setBounds(191, 166, 104, 13);
		panelLogin.add(lblNewLabel);
		
		JLabel lblMotDePasse = new JLabel("Mot de Passe :");
		lblMotDePasse.setBounds(191, 205, 104, 13);
		panelLogin.add(lblMotDePasse);
		
		JLabel lblNewLabel_1 = new JLabel("Bienvenue dans votre logiciel de gestion de Pharmacie");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(145, 41, 523, 36);
		panelLogin.add(lblNewLabel_1);
		
		message = new JTextField();
		message.setEditable(false);
		message.setBounds(10, 364, 746, 90);
		panelLogin.add(message);
		message.setColumns(10);
		
		motDePasse = new JTextField();
		motDePasse.setColumns(10);
		motDePasse.setBounds(305, 202, 272, 19);
		panelLogin.add(motDePasse);
		
		lblNewLabel_40 = new JLabel("New label");
		lblNewLabel_40.setIcon(new ImageIcon("img\\imageAccueil.png"));
		lblNewLabel_40.setBounds(733, 78, 100, 100);
		panelLogin.add(lblNewLabel_40);
		frameAppli.getContentPane().add(panelAppli);
		panelAppli.setLayout(null);
		
		btnDeco = new JButton("Se déconnecter");
		btnDeco.setIcon(new ImageIcon("img\\deconnecter.png"));
		btnDeco.setBounds(603, 10, 153, 30);
		panelAppli.add(btnDeco);
		
		JLabel lblNewLabel_4 = new JLabel("Bienvenue sur votre logiciel de gestion de pharmacie");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setBounds(93, 50, 542, 34);
		panelAppli.add(lblNewLabel_4);
		
		btnVente = new JButton("Vente Médicament");
		btnVente.setIcon(new ImageIcon("img\\achats.png"));
		btnVente.setBounds(93, 135, 228, 48);
		panelAppli.add(btnVente);
		
		btnAchats = new JButton("Achats Médicaments");
		btnAchats.setIcon(new ImageIcon("img\\stocks.png"));
		btnAchats.setBounds(473, 135, 228, 48);
		panelAppli.add(btnAchats);
		
		btnGestionUtilisateur = new JButton("Gestion des utilisateurs");
		btnGestionUtilisateur.setIcon(new ImageIcon("img\\recrutement-en-pharmacie.png"));
		btnGestionUtilisateur.setBounds(473, 230, 228, 48);
		panelAppli.add(btnGestionUtilisateur);
		
		messageAccueil = new JTextField();
		messageAccueil.setEditable(false);
		messageAccueil.setBounds(93, 360, 542, 80);
		panelAppli.add(messageAccueil);
		messageAccueil.setColumns(10);
		
		btnClientPatient = new JButton("Fichier client/patient");
		btnClientPatient.setIcon(new ImageIcon("img\\Fichier-client.png"));
		btnClientPatient.setBounds(93, 230, 228, 48);
		panelAppli.add(btnClientPatient);
		
		btnGestionDesFournisseurs = new JButton("Gestion des fournisseurs et références");
		btnGestionDesFournisseurs.setIcon(new ImageIcon("img\\fournisseur.png"));
		btnGestionDesFournisseurs.setBounds(250, 302, 250, 48);
		panelAppli.add(btnGestionDesFournisseurs);
		
		lblNewLabel_39 = new JLabel("New label");
		lblNewLabel_39.setIcon(new ImageIcon("img\\imageAccueil.png"));
		lblNewLabel_39.setBounds(775, 50, 100, 100);
		panelAppli.add(lblNewLabel_39);
		
		panelAchat = new JPanel();
		panelAchat.setLayout(null);
		panelAchat.setBounds(0, 0, 900, 536);
		frameAppli.getContentPane().add(panelAchat);
		
		btnRetourAchat = new JButton("Retour à l'accueil");
		btnRetourAchat.setIcon(new ImageIcon("img\\retourMenu.png"));
		btnRetourAchat.setBounds(716, 10, 174, 33);
		panelAchat.add(btnRetourAchat);
		
		textRefAchatMed = new JTextField();
		textRefAchatMed.setBounds(140, 51, 160, 19);
		panelAchat.add(textRefAchatMed);
		textRefAchatMed.setColumns(10);
		
		JLabel lblNewLabel_16 = new JLabel("Référence :");
		lblNewLabel_16.setBounds(10, 54, 120, 13);
		panelAchat.add(lblNewLabel_16);
		
		JLabel lblNewLabel_17 = new JLabel("Nom :");
		lblNewLabel_17.setBounds(10, 83, 120, 13);
		panelAchat.add(lblNewLabel_17);
		
		JLabel lblNewLabel_18 = new JLabel("Description :");
		lblNewLabel_18.setBounds(10, 139, 120, 13);
		panelAchat.add(lblNewLabel_18);
		
		textDateFab = new JTextField();
		textDateFab.setBounds(140, 183, 129, 19);
		panelAchat.add(textDateFab);
		textDateFab.setColumns(10);
		
		JLabel lblNewLabel_19 = new JLabel("Date de fabrication :");
		lblNewLabel_19.setBounds(10, 186, 120, 13);
		panelAchat.add(lblNewLabel_19);
		
		textDateExp = new JTextField();
		textDateExp.setBounds(140, 212, 129, 19);
		panelAchat.add(textDateExp);
		textDateExp.setColumns(10);
		
		JLabel lblNewLabel_20 = new JLabel("Date d'expiration :");
		lblNewLabel_20.setBounds(10, 215, 120, 13);
		panelAchat.add(lblNewLabel_20);
		
		textQuantiteAchat = new JTextField();
		textQuantiteAchat.setBounds(140, 258, 129, 19);
		panelAchat.add(textQuantiteAchat);
		textQuantiteAchat.setColumns(10);
		
		JLabel lblNewLabel_21 = new JLabel("Quantité :");
		lblNewLabel_21.setBounds(10, 261, 120, 13);
		panelAchat.add(lblNewLabel_21);
		
		textPrixUnitaire = new JTextField();
		textPrixUnitaire.setBounds(140, 287, 129, 19);
		panelAchat.add(textPrixUnitaire);
		textPrixUnitaire.setColumns(10);
		
		JLabel lblNewLabel_22 = new JLabel("Prix unitaire :");
		lblNewLabel_22.setBounds(10, 290, 120, 13);
		panelAchat.add(lblNewLabel_22);
		
		comboFournisseur = new JComboBox();
		comboFournisseur.setModel(new DefaultComboBoxModel(new String[] {"Sélectionnez un fournisseur", "Laboratoire Pzifer", "Laboratoire Chouquette", "Laboratoire Danielle", "Laboratoire Fukushima", "Laboratoire House", "Laboratoire Martin", "Laboratoire Nozman"}));
		comboFournisseur.setBounds(140, 234, 150, 21);
		panelAchat.add(comboFournisseur);
		
		JLabel lblNewLabel_23 = new JLabel("Fournisseur :");
		lblNewLabel_23.setBounds(10, 238, 129, 13);
		panelAchat.add(lblNewLabel_23);
		
		rdbtnEntreeStock = new JRadioButton("Entrée stock");
		rdbtnEntreeStock.setBounds(65, 340, 103, 21);
		panelAchat.add(rdbtnEntreeStock);
		
		rdbtnSortieStock = new JRadioButton("Sortie de stock");
		rdbtnSortieStock.setBounds(197, 340, 103, 21);
		panelAchat.add(rdbtnSortieStock);
		
		btnAjouterES = new JButton("Ajouter");
		btnAjouterES.setIcon(new ImageIcon("img\\ajouterProduit.png"));
		btnAjouterES.setBounds(10, 367, 105, 33);
		panelAchat.add(btnAjouterES);
		
		btnModifierES = new JButton("Modifier");
		btnModifierES.setIcon(new ImageIcon("img\\modifierProduit.png"));
		btnModifierES.setBounds(125, 367, 101, 33);
		panelAchat.add(btnModifierES);
		
		btnSupprimerES = new JButton("Supprimer");
		btnSupprimerES.setIcon(new ImageIcon("img\\supprimerProduit.png"));
		btnSupprimerES.setBounds(236, 367, 103, 33);
		panelAchat.add(btnSupprimerES);
		
		JPanel panel = new JPanel();
		panel.setBounds(364, 53, 510, 401);
		panelAchat.add(panel);
		panel.setLayout(null);
		
		listES = new JList();
		listES.setBounds(10, 10, 500, 381);
		panel.add(listES);
		
		JLabel lblNewLabel_30 = new JLabel("Catégorie :");
		lblNewLabel_30.setBounds(10, 109, 120, 13);
		panelAchat.add(lblNewLabel_30);
		
		comboCategorie = new JComboBox();
		comboCategorie.setModel(new DefaultComboBoxModel(new String[] {"Sélectionnez une catégorie", "Antalgique", "Antibiotique", "Anti-inflammatoire", "Antiemetique", "Antipyretique", "Anxiolytique", "Antispasmodique"}));
		comboCategorie.setSelectedIndex(0);
		comboCategorie.setBounds(140, 105, 160, 21);
		panelAchat.add(comboCategorie);
		
		lblNewLabel_31 = new JLabel("Prix de vente :");
		lblNewLabel_31.setBounds(10, 321, 120, 13);
		panelAchat.add(lblNewLabel_31);
		
		textPrixVente = new JTextField();
		textPrixVente.setColumns(10);
		textPrixVente.setBounds(140, 315, 129, 19);
		panelAchat.add(textPrixVente);
		
		textAreaDescription = new JTextField();
		textAreaDescription.setBounds(139, 136, 160, 40);
		panelAchat.add(textAreaDescription);
		textAreaDescription.setColumns(10);
		
		textMessageAchat = new JTextField();
		textMessageAchat.setEditable(false);
		textMessageAchat.setBounds(10, 420, 875, 50);
		panelAchat.add(textMessageAchat);
		textMessageAchat.setColumns(10);
		
		comboBoxNomAchatMed = new JComboBox();
		comboBoxNomAchatMed.setModel(new DefaultComboBoxModel(new String[] {"Sélectionnez un médicament", "Paracetamol", "Amoxicilline", "Ibuprofene", "Meteoclopramide", "Aspirine", "Diazepam", "Drotaverine"}));
		comboBoxNomAchatMed.setSelectedIndex(0);
		comboBoxNomAchatMed.setBounds(140, 75, 160, 21);
		panelAchat.add(comboBoxNomAchatMed);
		
		panelVente = new JPanel();
		panelVente.setBounds(0, 0, 900, 536);
		frameAppli.getContentPane().add(panelVente);
		panelVente.setLayout(null);
		
		btnRetourVente = new JButton("Retour à l'accueil");
		btnRetourVente.setIcon(new ImageIcon("img\\retourMenu.png"));
		btnRetourVente.setBounds(765, 10, 125, 33);
		panelVente.add(btnRetourVente);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 220, 746, 138);
		panelVente.add(tabbedPane);
		
		JPanel panelVenteOrdonnance = new JPanel();
		tabbedPane.addTab("Vente avec ordonnance", null, panelVenteOrdonnance, null);
		panelVenteOrdonnance.setLayout(null);
		
		textDateOrdo = new JTextField();
		textDateOrdo.setBounds(153, 10, 164, 19);
		panelVenteOrdonnance.add(textDateOrdo);
		textDateOrdo.setColumns(10);
		
		textNss = new JTextField();
		textNss.setColumns(10);
		textNss.setBounds(153, 39, 164, 19);
		panelVenteOrdonnance.add(textNss);
		
		textNomPatient = new JTextField();
		textNomPatient.setColumns(10);
		textNomPatient.setBounds(540, 10, 164, 19);
		panelVenteOrdonnance.add(textNomPatient);
		
		textPrenomPatient = new JTextField();
		textPrenomPatient.setColumns(10);
		textPrenomPatient.setBounds(540, 39, 164, 19);
		panelVenteOrdonnance.add(textPrenomPatient);
		
		btnValiderOrdo = new JButton("Valider ordonnance");
		btnValiderOrdo.setBounds(582, 68, 122, 21);
		panelVenteOrdonnance.add(btnValiderOrdo);
		
		lblNewLabel_5 = new JLabel("Date d'ordonnance :");
		lblNewLabel_5.setBounds(10, 10, 133, 13);
		panelVenteOrdonnance.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("Numéro sécurité sociale :");
		lblNewLabel_6.setBounds(10, 42, 133, 13);
		panelVenteOrdonnance.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("Nom patient :");
		lblNewLabel_7.setBounds(397, 13, 133, 13);
		panelVenteOrdonnance.add(lblNewLabel_7);
		
		lblNewLabel_8 = new JLabel("Prénom patient :");
		lblNewLabel_8.setBounds(397, 42, 133, 13);
		panelVenteOrdonnance.add(lblNewLabel_8);
		
		JPanel panelVenteSansOrdo = new JPanel();
		tabbedPane.addTab("Vente sans ordonnance", null, panelVenteSansOrdo, null);
		panelVenteSansOrdo.setLayout(null);
		
		textNomCli = new JTextField();
		textNomCli.setBounds(157, 10, 213, 19);
		panelVenteSansOrdo.add(textNomCli);
		textNomCli.setColumns(10);
		
		lblNewLabel_12 = new JLabel("Nom client :");
		lblNewLabel_12.setBounds(10, 13, 137, 13);
		panelVenteSansOrdo.add(lblNewLabel_12);
		
		textPrenomCli = new JTextField();
		textPrenomCli.setBounds(157, 39, 213, 19);
		panelVenteSansOrdo.add(textPrenomCli);
		textPrenomCli.setColumns(10);
		
		lblNewLabel_13 = new JLabel("Prénom client :");
		lblNewLabel_13.setBounds(10, 42, 137, 13);
		panelVenteSansOrdo.add(lblNewLabel_13);
		
		lblNewLabel_14 = new JLabel("Numéro client :");
		lblNewLabel_14.setBounds(380, 13, 137, 13);
		panelVenteSansOrdo.add(lblNewLabel_14);
		
		lblNewLabel_15 = new JLabel("Numéro téléphone client :");
		lblNewLabel_15.setBounds(380, 42, 137, 13);
		panelVenteSansOrdo.add(lblNewLabel_15);
		
		textNumCli = new JTextField();
		textNumCli.setColumns(10);
		textNumCli.setBounds(518, 10, 213, 19);
		panelVenteSansOrdo.add(textNumCli);
		
		textTelCli = new JTextField();
		textTelCli.setColumns(10);
		textTelCli.setBounds(518, 39, 213, 19);
		panelVenteSansOrdo.add(textTelCli);
		
		btnValiderClient = new JButton("Valider Client");
		btnValiderClient.setBounds(551, 80, 180, 21);
		panelVenteSansOrdo.add(btnValiderClient);
		
		JLabel lblNewLabel_13_1 = new JLabel("Rechercher client :");
		lblNewLabel_13_1.setBounds(10, 84, 137, 13);
		panelVenteSansOrdo.add(lblNewLabel_13_1);
		
		textRechercherClient = new JTextField();
		textRechercherClient.setColumns(10);
		textRechercherClient.setBounds(157, 81, 213, 19);
		panelVenteSansOrdo.add(textRechercherClient);
		
		btnRechercher = new JButton("Rechercher");
		btnRechercher.setBounds(380, 80, 85, 21);
		panelVenteSansOrdo.add(btnRechercher);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 359, 746, 95);
		panelVente.add(scrollPane_1);
		
		listCommandes = new JList();
		scrollPane_1.setViewportView(listCommandes);
		
		comboProduit = new JComboBox();
		comboProduit.setModel(new DefaultComboBoxModel(new String[] {"Sélectionnez un produit", "Paracetamol", "Amoxicilline", "Ibuprofene", "Meteoclopramide", "Aspirine", "Diazepam", "Drotaverine"}));
		comboProduit.setBounds(171, 47, 199, 21);
		panelVente.add(comboProduit);
		
		textQteStock = new JTextField();
		textQteStock.setEditable(false);
		textQteStock.setBounds(171, 78, 132, 19);
		panelVente.add(textQteStock);
		textQteStock.setColumns(10);
		
		textQteDemande = new JTextField();
		textQteDemande.setColumns(10);
		textQteDemande.setBounds(171, 107, 132, 19);
		panelVente.add(textQteDemande);
		
		textPrixTotal = new JTextField();
		textPrixTotal.setEditable(false);
		textPrixTotal.setColumns(10);
		textPrixTotal.setBounds(171, 136, 132, 19);
		panelVente.add(textPrixTotal);
		
		lblNewLabel_2 = new JLabel("Produit :");
		lblNewLabel_2.setBounds(10, 51, 151, 13);
		panelVente.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Quantité en stock :");
		lblNewLabel_3.setBounds(10, 81, 151, 13);
		panelVente.add(lblNewLabel_3);
		
		lblNewLabel_9 = new JLabel("Quantité demandée :");
		lblNewLabel_9.setBounds(10, 110, 151, 13);
		panelVente.add(lblNewLabel_9);
		
		lblNewLabel_10 = new JLabel("Prix total :");
		lblNewLabel_10.setBounds(10, 139, 151, 13);
		panelVente.add(lblNewLabel_10);
		
		lblNewLabel_11 = new JLabel("€");
		lblNewLabel_11.setBounds(313, 139, 73, 13);
		panelVente.add(lblNewLabel_11);
		
		btnAjouterPanier = new JButton("Ajouter au panier");
		btnAjouterPanier.setIcon(new ImageIcon("img\\panierAjout.png"));
		btnAjouterPanier.setBounds(31, 189, 149, 21);
		panelVente.add(btnAjouterPanier);
		
		btnModifier = new JButton("Modifier");
		btnModifier.setIcon(new ImageIcon("img\\modifierProduit.png"));
		btnModifier.setBounds(190, 189, 98, 21);
		panelVente.add(btnModifier);
		
		btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setIcon(new ImageIcon("img\\supprimerProduit.png"));
		btnSupprimer.setBounds(298, 189, 101, 21);
		panelVente.add(btnSupprimer);
		
		messageVente = new JTextField();
		messageVente.setEditable(false);
		messageVente.setBounds(10, 7, 621, 19);
		panelVente.add(messageVente);
		messageVente.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(403, 47, 353, 193);
		panelVente.add(scrollPane);
		
		listPanier = new JList();
		scrollPane.setViewportView(listPanier);
		
		btnValiderPanier = new JButton("Valider le panier");
		btnValiderPanier.setIcon(new ImageIcon("img\\validerPanier.png"));
		btnValiderPanier.setBounds(781, 222, 85, 21);
		panelVente.add(btnValiderPanier);
		
		panelGestionUtilisateurs = new JPanel();
		panelGestionUtilisateurs.setLayout(null);
		panelGestionUtilisateurs.setBounds(0, 0, 900, 536);
		frameAppli.getContentPane().add(panelGestionUtilisateurs);
		
		btnRetourGestionUtilisateurs = new JButton("Retour à l'accueil");
		btnRetourGestionUtilisateurs.setIcon(new ImageIcon("img\\retourMenu.png"));
		btnRetourGestionUtilisateurs.setBounds(765, 10, 125, 33);
		panelGestionUtilisateurs.add(btnRetourGestionUtilisateurs);
		
		panel_1 = new JPanel();
		panel_1.setBounds(363, 49, 393, 405);
		panelGestionUtilisateurs.add(panel_1);
		panel_1.setLayout(null);
		
		listUtilisateur = new JList();
		listUtilisateur.setBounds(0, 10, 393, 395);
		panel_1.add(listUtilisateur);
		
		textGestNomUtilisateur = new JTextField();
		textGestNomUtilisateur.setBounds(157, 49, 196, 19);
		panelGestionUtilisateurs.add(textGestNomUtilisateur);
		textGestNomUtilisateur.setColumns(10);
		
		lblNewLabel_24 = new JLabel("Nom de l'utilisateur :");
		lblNewLabel_24.setBounds(10, 52, 137, 13);
		panelGestionUtilisateurs.add(lblNewLabel_24);
		
		textGestPrenomUtilisateur = new JTextField();
		textGestPrenomUtilisateur.setBounds(157, 78, 196, 19);
		panelGestionUtilisateurs.add(textGestPrenomUtilisateur);
		textGestPrenomUtilisateur.setColumns(10);
		
		lblNewLabel_25 = new JLabel("Prénom de l'utilisateur :");
		lblNewLabel_25.setBounds(10, 81, 137, 13);
		panelGestionUtilisateurs.add(lblNewLabel_25);
		
		textGestIdUtilisateur = new JTextField();
		textGestIdUtilisateur.setBounds(157, 105, 196, 19);
		panelGestionUtilisateurs.add(textGestIdUtilisateur);
		textGestIdUtilisateur.setColumns(10);
		
		lblNewLabel_26 = new JLabel("Identifiant :");
		lblNewLabel_26.setBounds(10, 108, 137, 13);
		panelGestionUtilisateurs.add(lblNewLabel_26);
		
		textGestMdpUtilisateur = new JTextField();
		textGestMdpUtilisateur.setBounds(157, 133, 196, 19);
		panelGestionUtilisateurs.add(textGestMdpUtilisateur);
		textGestMdpUtilisateur.setColumns(10);
		
		lblNewLabel_27 = new JLabel("Mot de passe :");
		lblNewLabel_27.setBounds(10, 136, 137, 13);
		panelGestionUtilisateurs.add(lblNewLabel_27);
		
		textGestMailUtilisateur = new JTextField();
		textGestMailUtilisateur.setBounds(157, 162, 196, 19);
		panelGestionUtilisateurs.add(textGestMailUtilisateur);
		textGestMailUtilisateur.setColumns(10);
		
		lblNewLabel_28 = new JLabel("Adresse mail :");
		lblNewLabel_28.setBounds(10, 165, 137, 13);
		panelGestionUtilisateurs.add(lblNewLabel_28);
		
		comboNiveauDroits = new JComboBox();
		comboNiveauDroits.setModel(new DefaultComboBoxModel(new String[] {"Sélectionnez les droits.", "Vendeur", "Gestionnaire de Stock", "Administrateur"}));
		comboNiveauDroits.setBounds(157, 191, 196, 21);
		panelGestionUtilisateurs.add(comboNiveauDroits);
		
		lblNewLabel_29 = new JLabel("Niveau de droits d'accès :");
		lblNewLabel_29.setBounds(10, 195, 137, 13);
		panelGestionUtilisateurs.add(lblNewLabel_29);
		
		btnAjouterUtilisateur = new JButton("Ajouter");
		btnAjouterUtilisateur.setIcon(new ImageIcon("img\\ajouterUtilisateur.png"));
		btnAjouterUtilisateur.setBounds(10, 241, 105, 33);
		panelGestionUtilisateurs.add(btnAjouterUtilisateur);
		
		btnModifierUtilisateur = new JButton("Modifier");
		btnModifierUtilisateur.setIcon(new ImageIcon("img\\modifierUtilisateur.png"));
		btnModifierUtilisateur.setBounds(125, 241, 108, 33);
		panelGestionUtilisateurs.add(btnModifierUtilisateur);
		
		btnSupprimerUtilisateur = new JButton("Supprimer");
		btnSupprimerUtilisateur.setIcon(new ImageIcon("img\\supprimerUtilisateur.png"));
		btnSupprimerUtilisateur.setBounds(243, 241, 110, 33);
		panelGestionUtilisateurs.add(btnSupprimerUtilisateur);
		
		textMessageGestionUtil = new JTextField();
		textMessageGestionUtil.setBounds(10, 10, 745, 19);
		panelGestionUtilisateurs.add(textMessageGestionUtil);
		textMessageGestionUtil.setColumns(10);
		
		panelClientPatient = new JPanel();
		panelClientPatient.setBounds(0, 0, 910, 525);
		frameAppli.getContentPane().add(panelClientPatient);
		panelClientPatient.setLayout(null);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(24, 26, 850, 500);
		panelClientPatient.add(tabbedPane_1);
		
		listClient = new JList();
		tabbedPane_1.addTab("Fichier client", null, listClient, null);
		
		listPatient = new JList();
		tabbedPane_1.addTab("Fichier patient", null, listPatient, null);
		
		btnRetourMenuFichier = new JButton("Retour au menu");
		btnRetourMenuFichier.setIcon(new ImageIcon("img\\retourMenu.png"));
		btnRetourMenuFichier.setBounds(780, 10, 100, 30);
		panelClientPatient.add(btnRetourMenuFichier);
		
		panelAjoutFournisseurRef = new JPanel();
		panelAjoutFournisseurRef.setBounds(0, 0, 900, 536);
		frameAppli.getContentPane().add(panelAjoutFournisseurRef);
		panelAjoutFournisseurRef.setLayout(null);
		
		btnRetourMenuFournisseur = new JButton("Retour à l'accueil");
		btnRetourMenuFournisseur.setIcon(new ImageIcon("img\\retourMenu.png"));
		btnRetourMenuFournisseur.setBounds(700, 10, 175, 50);
		panelAjoutFournisseurRef.add(btnRetourMenuFournisseur);
		
		JLabel lblNewLabel_32 = new JLabel("Ajouter un fournisseur :");
		lblNewLabel_32.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_32.setBounds(36, 50, 171, 13);
		panelAjoutFournisseurRef.add(lblNewLabel_32);
		
		JLabel lblNewLabel_33 = new JLabel("Nom :");
		lblNewLabel_33.setBounds(25, 80, 45, 13);
		panelAjoutFournisseurRef.add(lblNewLabel_33);
		
		textNomFournisseurAjout = new JTextField();
		textNomFournisseurAjout.setBounds(100, 80, 150, 19);
		panelAjoutFournisseurRef.add(textNomFournisseurAjout);
		textNomFournisseurAjout.setColumns(10);
		
		JLabel lblNewLabel_34 = new JLabel("Ajouter une catégorie :");
		lblNewLabel_34.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_34.setBounds(335, 50, 136, 13);
		panelAjoutFournisseurRef.add(lblNewLabel_34);
		
		JLabel lblNewLabel_33_1 = new JLabel("Nom :");
		lblNewLabel_33_1.setBounds(335, 80, 45, 13);
		panelAjoutFournisseurRef.add(lblNewLabel_33_1);
		
		textNomCategorieAjout = new JTextField();
		textNomCategorieAjout.setBounds(410, 80, 150, 19);
		panelAjoutFournisseurRef.add(textNomCategorieAjout);
		textNomCategorieAjout.setColumns(10);
		
		btnValiderCategorie = new JButton("Valider");
		btnValiderCategorie.setIcon(new ImageIcon("img\\validerBis.png"));
		btnValiderCategorie.setBounds(440, 100, 120, 21);
		panelAjoutFournisseurRef.add(btnValiderCategorie);
		
		JLabel lblNewLabel_35 = new JLabel("Ajouter un médicament :");
		lblNewLabel_35.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_35.setBounds(36, 224, 171, 13);
		panelAjoutFournisseurRef.add(lblNewLabel_35);
		
		JLabel lblNewLabel_33_2 = new JLabel("Nom :");
		lblNewLabel_33_2.setBounds(36, 247, 45, 13);
		panelAjoutFournisseurRef.add(lblNewLabel_33_2);
		
		textNomMedicamentAjout = new JTextField();
		textNomMedicamentAjout.setBounds(100, 247, 150, 19);
		panelAjoutFournisseurRef.add(textNomMedicamentAjout);
		textNomMedicamentAjout.setColumns(10);
		
		btnValiderMedicament = new JButton("Valider");
		btnValiderMedicament.setIcon(new ImageIcon("img\\validerBis.png"));
		btnValiderMedicament.setBounds(138, 276, 120, 21);
		panelAjoutFournisseurRef.add(btnValiderMedicament);
		
		btnAjouterFournisseur = new JButton("Valider");
		btnAjouterFournisseur.setIcon(new ImageIcon("img\\validerBis.png"));
		btnAjouterFournisseur.setBounds(138, 170, 120, 21);
		panelAjoutFournisseurRef.add(btnAjouterFournisseur);
		
		lblNewLabel_36 = new JLabel("Adresse :");
		lblNewLabel_36.setBounds(25, 100, 80, 13);
		panelAjoutFournisseurRef.add(lblNewLabel_36);
		
		textAdresseFournisseur = new JTextField();
		textAdresseFournisseur.setColumns(10);
		textAdresseFournisseur.setBounds(100, 100, 150, 19);
		panelAjoutFournisseurRef.add(textAdresseFournisseur);
		
		lblNewLabel_37 = new JLabel("Ville :");
		lblNewLabel_37.setBounds(25, 120, 45, 13);
		panelAjoutFournisseurRef.add(lblNewLabel_37);
		
		textVilleFournisseur = new JTextField();
		textVilleFournisseur.setColumns(10);
		textVilleFournisseur.setBounds(100, 120, 150, 19);
		panelAjoutFournisseurRef.add(textVilleFournisseur);
		
		lblNewLabel_38 = new JLabel("CP :");
		lblNewLabel_38.setBounds(25, 141, 45, 13);
		panelAjoutFournisseurRef.add(lblNewLabel_38);
		
		textCPFournisseur = new JTextField();
		textCPFournisseur.setColumns(10);
		textCPFournisseur.setBounds(100, 141, 150, 19);
		panelAjoutFournisseurRef.add(textCPFournisseur);
		
		textMessageGestionFour = new JTextField();
		textMessageGestionFour.setEditable(false);
		textMessageGestionFour.setBounds(36, 333, 715, 57);
		panelAjoutFournisseurRef.add(textMessageGestionFour);
		textMessageGestionFour.setColumns(10);
		
		ButtonGroup entreeSortie = new ButtonGroup();
		
	}

	public JFrame getFrameAppli() {
		return frameAppli;
	}

	public void setFrameAppli(JFrame frameAppli) {
		this.frameAppli = frameAppli;
	}

	public JPanel getPanelLogin() {
		return panelLogin;
	}

	public void setPanelLogin(JPanel panelLogin) {
		this.panelLogin = panelLogin;
	}

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	public JTextField getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(JTextField motDePasse) {
		this.motDePasse = motDePasse;
	}

	public JButton getBtnLogin() {
		return btnLogin;
	}

	public void setBtnLogin(JButton btnLogin) {
		this.btnLogin = btnLogin;
	}

	public JTextField getMessage() {
		return message;
	}

	public void setMessage(JTextField message) {
		this.message = message;
	}

	public JPanel getPanelAppli() {
		return panelAppli;
	}

	public void setPanelAppli(JPanel panelAppli) {
		this.panelAppli = panelAppli;
	}

	public JTextPane getListe() {
		return liste;
	}

	public JButton getBtnDeco() {
		return btnDeco;
	}

	public void setBtnDeco(JButton btnDeco) {
		this.btnDeco = btnDeco;
	}

	public JButton getBtnVente() {
		return btnVente;
	}

	public void setBtnVente(JButton btnVente) {
		this.btnVente = btnVente;
	}

	public JButton getBtnAchats() {
		return btnAchats;
	}

	public void setBtnAchats(JButton btnAchats) {
		this.btnAchats = btnAchats;
	}

	public JButton getBtnGestionUtilisateur() {
		return btnGestionUtilisateur;
	}

	public void setBtnGestionUtilisateur(JButton btnGestionUtilisateur) {
		this.btnGestionUtilisateur = btnGestionUtilisateur;
	}

	public JTextField getMessageAccueil() {
		return messageAccueil;
	}

	public void setMessageAccueil(JTextField messageAccueil) {
		this.messageAccueil = messageAccueil;
	}

	public JPanel getPanelVente() {
		return panelVente;
	}

	public void setPanelVente(JPanel panelVente) {
		this.panelVente = panelVente;
	}

	public JButton getBtnRetourVente() {
		return btnRetourVente;
	}

	public void setBtnRetourVente(JButton btnRetourVente) {
		this.btnRetourVente = btnRetourVente;
	}

	public JButton getBtnRetourAchat() {
		return btnRetourAchat;
	}

	public void setBtnRetourAchat(JButton btnRetourAchat) {
		this.btnRetourAchat = btnRetourAchat;
	}

	public JPanel getPanelAchat() {
		return panelAchat;
	}

	public void setPanelAchat(JPanel panelAchat) {
		this.panelAchat = panelAchat;
	}

	public JPanel getPanelGestionUtilisateurs() {
		return panelGestionUtilisateurs;
	}

	public void setPanelGestionUtilisateurs(JPanel panelGestionUtilisateurs) {
		this.panelGestionUtilisateurs = panelGestionUtilisateurs;
	}

	public JButton getBtnRetourGestionUtilisateurs() {
		return btnRetourGestionUtilisateurs;
	}

	public void setBtnRetourGestionUtilisateurs(JButton btnRetourGestionUtilisateurs) {
		this.btnRetourGestionUtilisateurs = btnRetourGestionUtilisateurs;
	}

	public JTextField getTextDateOrdo() {
		return textDateOrdo;
	}

	public void setTextDateOrdo(JTextField textDateOrdo) {
		this.textDateOrdo = textDateOrdo;
	}

	public JTextField getTextNss() {
		return textNss;
	}

	public void setTextNss(JTextField textNss) {
		this.textNss = textNss;
	}

	public JTextField getTextNomPatient() {
		return textNomPatient;
	}

	public void setTextNomPatient(JTextField textNomPatient) {
		this.textNomPatient = textNomPatient;
	}

	public JTextField getTextPrenomPatient() {
		return textPrenomPatient;
	}

	public void setTextPrenomPatient(JTextField textPrenomPatient) {
		this.textPrenomPatient = textPrenomPatient;
	}

	public JButton getBtnValiderOrdo() {
		return btnValiderOrdo;
	}

	public void setBtnValiderOrdo(JButton btnValiderOrdo) {
		this.btnValiderOrdo = btnValiderOrdo;
	}

	public JComboBox getComboProduit() {
		return comboProduit;
	}

	public void setComboProduit(JComboBox comboProduit) {
		this.comboProduit = comboProduit;
	}

	public JTextField getTextQteStock() {
		return textQteStock;
	}

	public void setTextQteStock(JTextField textQteStock) {
		this.textQteStock = textQteStock;
	}

	public JTextField getTextQteDemande() {
		return textQteDemande;
	}

	public void setTextQteDemande(JTextField textQteDemande) {
		this.textQteDemande = textQteDemande;
	}

	public JTextField getTextPrixTotal() {
		return textPrixTotal;
	}

	public void setTextPrixTotal(JTextField textPrixTotal) {
		this.textPrixTotal = textPrixTotal;
	}

	public JButton getBtnAjouterPanier() {
		return btnAjouterPanier;
	}

	public void setBtnAjouterPanier(JButton btnAjouterPanier) {
		this.btnAjouterPanier = btnAjouterPanier;
	}

	public JButton getBtnModifier() {
		return btnModifier;
	}

	public void setBtnModifier(JButton btnModifier) {
		this.btnModifier = btnModifier;
	}

	public JButton getBtnSupprimer() {
		return btnSupprimer;
	}

	public void setBtnSupprimer(JButton btnSupprimer) {
		this.btnSupprimer = btnSupprimer;
	}

	public JButton getBtnValiderClient() {
		return btnValiderClient;
	}

	public void setBtnValiderClient(JButton btnValiderClient) {
		this.btnValiderClient = btnValiderClient;
	}

	public JTextField getMessageVente() {
		return messageVente;
	}

	public void setMessageVente(JTextField messageVente) {
		this.messageVente = messageVente;
	}

	public JList getListPanier() {
		return listPanier;
	}

	public void setListPanier(JList listPanier) {
		this.listPanier = listPanier;
	}

	public JList getListCommandes() {
		return listCommandes;
	}

	public void setListCommandes(JList listCommandes) {
		this.listCommandes = listCommandes;
	}

	public JTextField getTextNomCli() {
		return textNomCli;
	}

	public void setTextNomCli(JTextField textNomCli) {
		this.textNomCli = textNomCli;
	}

	public JTextField getTextPrenomCli() {
		return textPrenomCli;
	}

	public void setTextPrenomCli(JTextField textPrenomCli) {
		this.textPrenomCli = textPrenomCli;
	}

	public JTextField getTextNumCli() {
		return textNumCli;
	}

	public void setTextNumCli(JTextField textNumCli) {
		this.textNumCli = textNumCli;
	}

	public JTextField getTextTelCli() {
		return textTelCli;
	}

	public void setTextTelCli(JTextField textTelCli) {
		this.textTelCli = textTelCli;
	}

	public JTextField getTextGestNomUtilisateur() {
		return textGestNomUtilisateur;
	}

	public void setTextGestNomUtilisateur(JTextField textGestNomUtilisateur) {
		this.textGestNomUtilisateur = textGestNomUtilisateur;
	}

	public JTextField getTextGestPrenomUtilisateur() {
		return textGestPrenomUtilisateur;
	}

	public void setTextGestPrenomUtilisateur(JTextField textGestPrenomUtilisateur) {
		this.textGestPrenomUtilisateur = textGestPrenomUtilisateur;
	}

	public JTextField getTextGestIdUtilisateur() {
		return textGestIdUtilisateur;
	}

	public void setTextGestIdUtilisateur(JTextField textGestIdUtilisateur) {
		this.textGestIdUtilisateur = textGestIdUtilisateur;
	}

	public JTextField getTextGestMdpUtilisateur() {
		return textGestMdpUtilisateur;
	}

	public void setTextGestMdpUtilisateur(JTextField textGestMdpUtilisateur) {
		this.textGestMdpUtilisateur = textGestMdpUtilisateur;
	}

	public JTextField getTextGestMailUtilisateur() {
		return textGestMailUtilisateur;
	}

	public void setTextGestMailUtilisateur(JTextField textGestMailUtilisateur) {
		this.textGestMailUtilisateur = textGestMailUtilisateur;
	}

	public JComboBox getComboNiveauDroits() {
		return comboNiveauDroits;
	}

	public void setComboNiveauDroits(JComboBox comboNiveauDroits) {
		this.comboNiveauDroits = comboNiveauDroits;
	}

	public JButton getBtnAjouterUtilisateur() {
		return btnAjouterUtilisateur;
	}

	public void setBtnAjouterUtilisateur(JButton btnAjouterUtilisateur) {
		this.btnAjouterUtilisateur = btnAjouterUtilisateur;
	}

	public JButton getBtnModifierUtilisateur() {
		return btnModifierUtilisateur;
	}

	public void setBtnModifierUtilisateur(JButton btnModifierUtilisateur) {
		this.btnModifierUtilisateur = btnModifierUtilisateur;
	}

	public JButton getBtnSupprimerUtilisateur() {
		return btnSupprimerUtilisateur;
	}

	public void setBtnSupprimerUtilisateur(JButton btnSupprimerUtilisateur) {
		this.btnSupprimerUtilisateur = btnSupprimerUtilisateur;
	}

	public JList getListUtilisateur() {
		return listUtilisateur;
	}

	public void setListUtilisateur(JList listUtilisateur) {
		this.listUtilisateur = listUtilisateur;
	}

	public JTextField getTextMessageGestionUtil() {
		return textMessageGestionUtil;
	}

	public void setTextMessageGestionUtil(JTextField textMessageGestionUtil) {
		this.textMessageGestionUtil = textMessageGestionUtil;
	}

	public JComboBox getComboFournisseur() {
		return comboFournisseur;
	}

	public void setComboFournisseur(JComboBox comboFournisseur) {
		this.comboFournisseur = comboFournisseur;
	}

	public JTextArea getTextArea() {
		return textArea;
	}

	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}

	public JTextField getTextRefAchatMed() {
		return textRefAchatMed;
	}

	public void setTextRefAchatMed(JTextField textRefAchatMed) {
		this.textRefAchatMed = textRefAchatMed;
	}

	public void setTextDateFab(JTextField textDateFab) {
		this.textDateFab = textDateFab;
	}
	
	public JTextField getTextDateFab() {
		return textDateFab;
	}

	public JTextField getTextDateExp() {
		return textDateExp;
	}

	public void setTextDateExp(JTextField textDateExp) {
		this.textDateExp = textDateExp;
	}

	public JTextField getTextQuantiteAchat() {
		return textQuantiteAchat;
	}

	public void setTextQuantiteAchat(JTextField textQuantiteAchat) {
		this.textQuantiteAchat = textQuantiteAchat;
	}

	public JTextField getTextPrixUnitaire() {
		return textPrixUnitaire;
	}

	public void setTextPrixUnitaire(JTextField textPrixUnitaire) {
		this.textPrixUnitaire = textPrixUnitaire;
	}

	public JList getListES() {
		return listES;
	}

	public void setListES(JList listES) {
		this.listES = listES;
	}

	public JRadioButton getRdbtnEntreeStock() {
		return rdbtnEntreeStock;
	}

	public void setRdbtnEntreeStock(JRadioButton rdbtnEntreeStock) {
		this.rdbtnEntreeStock = rdbtnEntreeStock;
	}

	public JRadioButton getRdbtnSortieStock() {
		return rdbtnSortieStock;
	}

	public void setRdbtnSortieStock(JRadioButton rdbtnSortieStock) {
		this.rdbtnSortieStock = rdbtnSortieStock;
	}

	public JButton getBtnAjouterES() {
		return btnAjouterES;
	}

	public void setBtnAjouterES(JButton btnAjouterES) {
		this.btnAjouterES = btnAjouterES;
	}

	public JButton getBtnModifierES() {
		return btnModifierES;
	}

	public void setBtnModifierES(JButton btnModifierES) {
		this.btnModifierES = btnModifierES;
	}

	public JButton getBtnSupprimerES() {
		return btnSupprimerES;
	}

	public void setBtnSupprimerES(JButton btnSupprimerES) {
		this.btnSupprimerES = btnSupprimerES;
	}

	public JComboBox getComboCategorie() {
		return comboCategorie;
	}

	public void setComboCategorie(JComboBox comboCategorie) {
		this.comboCategorie = comboCategorie;
	}

	public JTextField getTextPrixVente() {
		return textPrixVente;
	}

	public void setTextPrixVente(JTextField textPrixVente) {
		this.textPrixVente = textPrixVente;
	}

	public JButton getBtnValiderPanier() {
		return btnValiderPanier;
	}

	public void setBtnValiderPanier(JButton btnValiderPanier) {
		this.btnValiderPanier = btnValiderPanier;
	}

	public JTextField getTextAreaDescription() {
		return textAreaDescription;
	}

	public void setTextAreaDescription(JTextField textAreaDescription) {
		this.textAreaDescription = textAreaDescription;
	}

	public JButton getBtnClientPatient() {
		return btnClientPatient;
	}

	public void setBtnClientPatient(JButton btnClientPatient) {
		this.btnClientPatient = btnClientPatient;
	}

	public JList getListClient() {
		return listClient;
	}

	public void setListClient(JList listClient) {
		this.listClient = listClient;
	}

	public JList getListPatient() {
		return listPatient;
	}

	public void setListPatient(JList listPatient) {
		this.listPatient = listPatient;
	}

	public JPanel getPanelClientPatient() {
		return panelClientPatient;
	}

	public void setPanelClientPatient(JPanel panelClientPatient) {
		this.panelClientPatient = panelClientPatient;
	}

	public JButton getBtnRetourMenuFichier() {
		return btnRetourMenuFichier;
	}

	public void setBtnRetourMenuFichier(JButton btnRetourMenuFichier) {
		this.btnRetourMenuFichier = btnRetourMenuFichier;
	}

	public JTextField getTextRechercherClient() {
		return textRechercherClient;
	}

	public void setTextRechercherClient(JTextField textRechercherClient) {
		this.textRechercherClient = textRechercherClient;
	}

	public JButton getBtnRechercher() {
		return btnRechercher;
	}

	public void setBtnRechercher(JButton btnRechercher) {
		this.btnRechercher = btnRechercher;
	}

	public JTextField getTextMessageAchat() {
		return textMessageAchat;
	}

	public void setTextMessageAchat(JTextField textMessageAchat) {
		this.textMessageAchat = textMessageAchat;
	}

	public JComboBox getComboBoxNomAchatMed() {
		return comboBoxNomAchatMed;
	}

	public void setComboBoxNomAchatMed(JComboBox comboBoxNomAchatMed) {
		this.comboBoxNomAchatMed = comboBoxNomAchatMed;
	}

	public JButton getBtnRetourMenuFournisseur() {
		return btnRetourMenuFournisseur;
	}

	public void setBtnRetourMenuFournisseur(JButton btnRetourMenuFournisseur) {
		this.btnRetourMenuFournisseur = btnRetourMenuFournisseur;
	}

	public JTextField getTextNomFournisseurAjout() {
		return textNomFournisseurAjout;
	}

	public void setTextNomFournisseurAjout(JTextField textNomFournisseurAjout) {
		this.textNomFournisseurAjout = textNomFournisseurAjout;
	}

	public JTextField getTextNomCategorieAjout() {
		return textNomCategorieAjout;
	}

	public void setTextNomCategorieAjout(JTextField textNomCategorieAjout) {
		this.textNomCategorieAjout = textNomCategorieAjout;
	}

	public JTextField getTextNomMedicamentAjout() {
		return textNomMedicamentAjout;
	}

	public void setTextNomMedicamentAjout(JTextField textNomMedicamentAjout) {
		this.textNomMedicamentAjout = textNomMedicamentAjout;
	}

	public JButton getBtnAjouterFournisseur() {
		return btnAjouterFournisseur;
	}

	public void setBtnAjouterFournisseur(JButton btnAjouterFournisseur) {
		this.btnAjouterFournisseur = btnAjouterFournisseur;
	}

	public JButton getBtnValiderCategorie() {
		return btnValiderCategorie;
	}

	public void setBtnValiderCategorie(JButton btnValiderCategorie) {
		this.btnValiderCategorie = btnValiderCategorie;
	}

	public JButton getBtnValiderMedicament() {
		return btnValiderMedicament;
	}

	public void setBtnValiderMedicament(JButton btnValiderMedicament) {
		this.btnValiderMedicament = btnValiderMedicament;
	}

	public JButton getBtnGestionDesFournisseurs() {
		return btnGestionDesFournisseurs;
	}

	public void setBtnGestionDesFournisseurs(JButton btnGestionDesFournisseurs) {
		this.btnGestionDesFournisseurs = btnGestionDesFournisseurs;
	}

	public JPanel getPanelAjoutFournisseurRef() {
		return panelAjoutFournisseurRef;
	}

	public void setPanelAjoutFournisseurRef(JPanel panelAjoutFournisseurRef) {
		this.panelAjoutFournisseurRef = panelAjoutFournisseurRef;
	}

	public JTextField getTextAdresseFournisseur() {
		return textAdresseFournisseur;
	}

	public void setTextAdresseFournisseur(JTextField textAdresseFournisseur) {
		this.textAdresseFournisseur = textAdresseFournisseur;
	}

	public JTextField getTextVilleFournisseur() {
		return textVilleFournisseur;
	}

	public void setTextVilleFournisseur(JTextField textVilleFournisseur) {
		this.textVilleFournisseur = textVilleFournisseur;
	}

	public JTextField getTextCPFournisseur() {
		return textCPFournisseur;
	}

	public void setTextCPFournisseur(JTextField textCPFournisseur) {
		this.textCPFournisseur = textCPFournisseur;
	}

	public JTextField getTextMessageGestionFour() {
		return textMessageGestionFour;
	}

	public void setTextMessageGestionFour(JTextField textMessageGestionFour) {
		this.textMessageGestionFour = textMessageGestionFour;
	}
	
	
}
