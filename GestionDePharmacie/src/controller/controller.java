package controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import model.CategorieDAO;
import model.CategorieModel;
import model.ClientDAO;
import model.EntreesSortiesDAO;
import model.EntreesSortiesModel;
import model.FactureDAO;
import model.FactureModel;
import model.FournisseurDAO;
import model.FournisseurModel;
import model.MedDAO;
import model.MedModel;
import model.PanierModel;
import model.PatientDAO;
import model.PatientModel;
import model.UtilisateurDAO;
import model.UtilisateurModel;
import model.clientModel;
import view.View;


/**
 * @author Aicha EL ATTAOUI    @date 19/03/2024
 * 
 * class controller
 * 
 * classe contrôleur avec appel aux différents objets créés pour le projet (un objet par table) :
 * 
 * utilisateur, client, medicament, patient, facture...
 * 
 */

public class controller {
	
	
	
	private UtilisateurModel unUtilisateur;
	private MedModel unMedicament;
	private clientModel unClient;
	private PatientModel unPatient;
	private FactureModel uneFacture;
	private PanierModel unPanier;
	private EntreesSortiesModel uneES;
	private FournisseurModel unFournisseur;
	private CategorieModel uneCategorie;
	private View View;
	private UtilisateurDAO utilisateurDao;
	private MedDAO medDao;
	private PatientDAO patientDao;
	private ClientDAO clientDao;
	private FactureDAO factureDao;
	private EntreesSortiesDAO entreesSortiesDao;
	private FournisseurDAO fournisseurDao;
	private CategorieDAO categorieDao;
	private ArrayList<clientModel> arrayRechercheCli=null;
	private ArrayList<clientModel>arrayClient=null;
	private ArrayList<PatientModel> arrayRecherchePatient=null;
	private ArrayList<PatientModel>arrayPatient=null;
	private ArrayList<UtilisateurModel> arrayRecherche=null;
	private ArrayList<UtilisateurModel> arrayUtilisateur=null;
	private ArrayList<MedModel>arrayRechercheMed=null;
	private ArrayList<MedModel>arrayPrixMed=null;
	private ArrayList<MedModel>arrayMed=null;
	private ArrayList<FactureModel>arrayRechercheFacture=null;
	private ArrayList<FactureModel>arrayFacture=null;
	private ArrayList<PanierModel> listePanier=null;
	private ArrayList<EntreesSortiesModel>arrayES=null;
	private ArrayList<EntreesSortiesModel>arrayRechercheES=null;
	private ArrayList<FournisseurModel>arrayFournisseur=null;
	private ArrayList<FournisseurModel>arrayRechercheFournisseur=null;
	
	/******************************************************/
	
	public controller(UtilisateurModel unUtilisateur, MedModel unMedicament, PatientModel unPatient, clientModel unClient, FactureModel uneFacture, PanierModel unPanier, EntreesSortiesModel uneES, CategorieModel uneCategorie, View View){
	    this.unUtilisateur=unUtilisateur;
	    this.View=View;
	    this.utilisateurDao=new UtilisateurDAO();
	    this.medDao=new MedDAO();
	    this.clientDao=new ClientDAO();
	    this.patientDao=new PatientDAO();
	    this.factureDao=new FactureDAO();
	    this.categorieDao=new CategorieDAO();
	    this.unMedicament=unMedicament;
	    this.unPatient=unPatient;
	    this.unClient=unClient;
	    this.uneFacture=uneFacture;
	    this.unPanier=unPanier;
	    this.uneES=uneES;
	    this.uneCategorie=uneCategorie;

	    // Initialisation des tableaux après avoir initialisé les DAOs
	    this.arrayUtilisateur = utilisateurDao.getAllUtilisateur();
	    this.arrayMed = medDao.getAllMed();
	    this.arrayES = entreesSortiesDao.getAllES();
	    this.arrayFournisseur = fournisseurDao.getAllFournisseur();
	    this.arrayFacture=factureDao.getAllFactures();
	    this.listePanier=new ArrayList<PanierModel>();
	    this.arrayClient=clientDao.getAllClient();
	    this.arrayPatient=patientDao.getAllPatient();

	    // Mettre à jour les éléments de la vue
	    View.getListUtilisateur().setListData(arrayUtilisateur.toArray());
	    View.getListES().setListData(arrayES.toArray());
	    View.getListCommandes().setListData(arrayFacture.toArray());
	    View.getListClient().setListData(arrayClient.toArray());
	    View.getListPatient().setListData(arrayPatient.toArray());
	    initControllerActions();
	}
	
	/********************************************************/
	
	public controller(view.View vue) {
		// TODO Auto-generated constructor stub
		this.View=vue;
		this.utilisateurDao=new UtilisateurDAO();
		this.medDao=new MedDAO();
		this.clientDao=new ClientDAO();
		this.patientDao=new PatientDAO();
		this.factureDao=new FactureDAO();
		this.entreesSortiesDao=new EntreesSortiesDAO();
		this.fournisseurDao=new FournisseurDAO();
		this.categorieDao=new CategorieDAO();
		this.unMedicament = new MedModel(); 
	    this.unPatient = new PatientModel();  
	    this.unClient = new clientModel(); 
	    this.uneFacture = new FactureModel();  
	    this.unPanier = new PanierModel();  
	    this.uneES = new EntreesSortiesModel();
	    this.uneCategorie= new CategorieModel();
	    
	    this.arrayUtilisateur = utilisateurDao.getAllUtilisateur();
	    this.arrayMed = medDao.getAllMed();
	    this.arrayES = entreesSortiesDao.getAllES();
	    this.arrayFournisseur = fournisseurDao.getAllFournisseur();
	    this.arrayFacture=factureDao.getAllFactures();
	    this.listePanier=new ArrayList<PanierModel>();
	    this.arrayClient=clientDao.getAllClient();
	    this.arrayPatient=patientDao.getAllPatient();
	    
	    View.getListUtilisateur().setListData(arrayUtilisateur.toArray());
	    View.getListES().setListData(arrayES.toArray());
	    View.getListCommandes().setListData(arrayFacture.toArray());
	    View.getListClient().setListData(arrayClient.toArray());
	    View.getListPatient().setListData(arrayPatient.toArray());
	    
	    //gérer interface
	    
	    View.getPanelLogin().setVisible(true);
	    View.getPanelAppli().setVisible(false);
	    View.getPanelAchat().setVisible(false);
	    View.getPanelClientPatient().setVisible(false);
	    View.getPanelGestionUtilisateurs().setVisible(false);
	    View.getPanelVente().setVisible(false);
	    View.getPanelAjoutFournisseurRef().setVisible(false);
	    
		initControllerActions();
	}

	/***************************************************/
	
	public void initControllerActions() {
		
		//actions liées au menu d'accueil
		View.getBtnLogin().addActionListener(e -> connecterUtilisateur());
		View.getBtnDeco().addActionListener(e -> deconnecterUtilisateur());
		View.getBtnAchats().addActionListener(e -> accederAchats());
		View.getBtnRetourAchat().addActionListener(e -> retourMenu());
		View.getBtnVente().addActionListener(e -> accederVente());
		View.getBtnRetourVente().addActionListener(e -> retourMenu());
		View.getBtnGestionUtilisateur().addActionListener(e -> accederGestionUtilisateurs());
		View.getBtnRetourGestionUtilisateurs().addActionListener(e -> retourMenu());
		View.getBtnClientPatient().addActionListener(e -> accederFichierClient());
		View.getBtnRetourMenuFichier().addActionListener(e -> retourMenu());
		View.getBtnGestionDesFournisseurs().addActionListener(e -> accederGestionFournisseurs());
		View.getBtnRetourMenuFournisseur().addActionListener(e -> retourMenu());
		
		//actions liées à la vente
		View.getBtnSupprimer().addActionListener(e -> supprimerPanier());
		View.getBtnAjouterPanier().addActionListener(e -> ajouterPanier());
		View.getBtnModifier().addActionListener(e -> modifierPanier());
		View.getBtnValiderClient().addActionListener(e -> validerClient());
		View.getBtnValiderOrdo().addActionListener(e ->  validerOrdonnance());
		View.getComboProduit().addActionListener(e -> selectionnerProduit());
		View.getListPanier().addListSelectionListener(ListSelectionEvent -> selectionnerItemPanier());
		View.getBtnValiderPanier().addActionListener(e -> validerPanier());
		View.getBtnRechercher().addActionListener(e -> rechercherClient());
		
		//actions liées à l'achat
		View.getBtnAjouterES().addActionListener(e -> ajouterEntreeSortie());
		View.getBtnModifierES().addActionListener(e -> modifierEntreeSortie());
		View.getBtnSupprimerES().addActionListener(e -> supprimerEntreeSortie());
		View.getListES().addListSelectionListener(ListSelectionEvent -> selectionnerEntreeSortie());
			
		
		//actions liées à la gestion des utilisateurs
		View.getBtnAjouterUtilisateur().addActionListener(e -> ajouterUtilisateur());
		View.getBtnModifierUtilisateur().addActionListener(e -> modifierUtilisateur());
		View.getBtnSupprimerUtilisateur().addActionListener(e -> supprimerUtilisateur());
		View.getListUtilisateur().addListSelectionListener(ListSelectionEvent -> selectionnerUtilisateur());
		
		//actions liées à l'ajout de fournisseurs, catégories et médicaments aux combobox
		View.getBtnAjouterFournisseur().addActionListener(e -> ajouterFournisseur());
		View.getBtnValiderCategorie().addActionListener(e -> ajouterCategorie());
		View.getBtnValiderMedicament().addActionListener(e -> ajouterMedicament());
	}
	
	/**************************************************/
	
	/**
	 * @author Aicha EL ATTAOUI @date 21/03/2024
	 * 
	 * connecterUtilisateur()
	 * 
	 * Méthode void, sans paramètre.
	 * 
	 * on récupère dans des variables string le contenu des champs textes du login et du mot de passe.
	 * 
	 * on ajoute une variable boolean qui permet de controler si l'utilisateur existe dans la base à l'aide de la méthode de recherche de utilisateurDao.
	 * 
	 * si l'utilisateur existe et que le mot de passe correspond le panel correspondant à l'accueil devient visible et le panel correspondant au login devient invisible.
	 * 
	 * si l'utilisateur n'existe pas ou que l'identifiant et le mot de passe ne correpondent pas, on récupère le champ texte de message dans lequel on affiche un message d'erreur à destination de l'utilisateur.
	 * 
	 */
	
	public void connecterUtilisateur() {
		
		
		
		String identifiant = View.getTextField().getText();
		String motDePasse = View.getMotDePasse().getText();
		String derniereCo=recupererDateSysteme();
		boolean ok=false;
		
		arrayRecherche=utilisateurDao.rechercherUtilisateur(identifiant);		
	    
	    for (UtilisateurModel utilisateur : arrayRecherche) {
	        if (utilisateur.getMotDePasse().equals(motDePasse)) {
	            ok = true;
	            utilisateur.setDateDerniereConnexion(derniereCo);
	            break;
	        } 
	    }
	    
	    if (ok) {
	        View.getPanelLogin().setVisible(false);
	        View.getPanelAppli().setVisible(true);
		    View.getPanelAchat().setVisible(false);
		    View.getPanelClientPatient().setVisible(false);
		    View.getPanelGestionUtilisateurs().setVisible(false);
		    View.getPanelVente().setVisible(false);
		    View.getPanelAjoutFournisseurRef().setVisible(false);
	    } else {
	        View.getMessage().setText("L'identifiant et le mot de passe ne correspondent pas.");
			
		}
		
	}
	
	/*************************************************************/
	
	/**
	 * @author Aicha EL ATTAOUI @date 21/03/2024
	 * 
	 * deconnecterUtilisateur()
	 * 
	 * Méthode void sans paramètre.
	 * 
	 * les champs textes du login et du mot de passe sont vidés.
	 * 
	 * le panneau correspondant à l'accueil devient invisible et le login redevient visible.
	 * 
	 */
	
	public void deconnecterUtilisateur() {
		
		
		
		View.getMotDePasse().setText("");
		View.getTextField().setText("");
		
		viderAllChampsTextes();
		
		/***************************************************/
		//rendre panneau login visible et application invisible.
		
		View.getPanelLogin().setVisible(true);
		 View.getPanelAppli().setVisible(false);
		 View.getPanelAchat().setVisible(false);
		 View.getPanelClientPatient().setVisible(false);
		 View.getPanelGestionUtilisateurs().setVisible(false);
		 View.getPanelVente().setVisible(false);
		 View.getPanelAjoutFournisseurRef().setVisible(false);
	}
	/*************************************************************/
	

	// A partir de ce point, on trouve les accès aux différentes fonctions depuis l'accueil et les retours à l'accueil.
	
	/******************************************************************/
	
	/**
	 * @author Aicha EL ATTAOUI @date 21/03/2024
	 * 
	 * accederVente()
	 * 
	 * méthode void sans paramètre.
	 * 
	 * variables : 
	 *  
	 * string identifiant = récupère le contenu du champ texte correspondant à l'identifiant de l'utilisateur actuellement connecté.
	 * boolean ok= par défaut à false. vérifie si l'utilisateur a le bon niveau de droits d'accès (1 - pharmacien/vendeur, 2 - gestionnaire des stocks, 3 - administrateur)
	 * 
	 * recherche de l'utilisateur via la méthode de recherche de utilisateurDAO.
	 * 
	 * on vérifie si le niveau de droits d'accès vaut 3 :
	 * 	si oui -> ok devient true
	 * 
	 * si ok vaut true alors le panel de l'accueil devient invisible et le panel des achats devient visible.
	 * si ok vaut false alors on récupère le champ texte de message de l'accueil et on affiche un message d'erreur.
	 * 
	 */
	
	public void accederAchats() {
		
		
		
		String identifiant = View.getTextField().getText();
		boolean ok=false;
		
		arrayRecherche=utilisateurDao.rechercherUtilisateur(identifiant);		
	    
	    for (UtilisateurModel utilisateur : arrayRecherche) {
	        if (utilisateur.getIdDroitAcces()==3 || utilisateur.getIdDroitAcces()==2) {
	            ok = true;
	            break;
	        } 
	    }
	    
	    if (ok) {
	        View.getPanelAppli().setVisible(false);
	        View.getPanelAchat().setVisible(true);
		    View.getPanelClientPatient().setVisible(false);
		    View.getPanelGestionUtilisateurs().setVisible(false);
		    View.getPanelVente().setVisible(false);
		    View.getPanelAjoutFournisseurRef().setVisible(false);
	    } else {
	        View.getMessageAccueil().setText(identifiant +", vous ne disposez pas de droits d'accès suffisants pour accéder à cette fonction. Veuillez contacter l'administrateur.");
			
		}
	}
	
	/**************************************************************/
	
	/**
	 * @author Aicha EL ATTAOUI @date 21/03/2024
	 * 
	 * accederVente()
	 * 
	 *  méthode void sans paramètre
	 *  
	 *  pas de contrôle de niveau de droits d'accès car la vente peut être faite par tous.
	 *  
	 *  rend le panel d'accueil invisible et le panel des ventes visibles.
	 *  
	 */
	
	public void accederVente() {
		
		
		
		View.getPanelAppli().setVisible(false);
		View.getPanelVente().setVisible(true);
	    View.getPanelAchat().setVisible(false);
	    View.getPanelClientPatient().setVisible(false);
	    View.getPanelGestionUtilisateurs().setVisible(false);
	    View.getPanelAjoutFournisseurRef().setVisible(false);
	}
	
	/*************************************************************/
	
	
	

	/**************************************************************/
	
	/**
	 * @author Aicha EL ATTAOUI  @date 21/03/2024
	 * 
	 * accederGestionUtilisateurs()
	 * 
	 * méthode void sans paramètre.
	 * 
	 * variables : 
	 *  
	 * string identifiant = récupère le contenu du champ texte correspondant à l'identifiant de l'utilisateur actuellement connecté.
	 * boolean ok= par défaut à false. vérifie si l'utilisateur a le bon niveau de droits d'accès (1 - pharmacien/vendeur, 2 - gestionnaire des stocks, 3 - administrateur)
	 * 
	 * recherche de l'utilisateur via la méthode de recherche de utilisateurDAO.
	 * 
	 * on vérifie si le niveau de droits d'accès vaut 3 :
	 * 	si oui -> ok devient true
	 * 
	 * si ok vaut true alors le panel de l'accueil devient invisible et le panel des droits utilisateurs devient visible.
	 * si ok vaut false alors on récupère le champ texte de message de l'accueil et on affiche un message d'erreur.
	 */
	
	public void accederGestionUtilisateurs() {
		
		
		
		String identifiant = View.getTextField().getText();
		boolean ok=false;
		
		arrayRecherche=utilisateurDao.rechercherUtilisateur(identifiant);		
	    
	    for (UtilisateurModel utilisateur : arrayRecherche) {
	        if (utilisateur.getIdDroitAcces()==3) {
	            ok = true;
	            break;
	        } 
	    }
	    
	    if (ok) {
	        View.getPanelAppli().setVisible(false);
	        View.getPanelGestionUtilisateurs().setVisible(true);
		    View.getPanelAchat().setVisible(false);
		    View.getPanelClientPatient().setVisible(false);
		    View.getPanelVente().setVisible(false);
		    View.getPanelAjoutFournisseurRef().setVisible(false);
	    } else {
	        View.getMessageAccueil().setText(identifiant +", vous ne disposez pas de droits d'accès suffisants pour accéder à cette fonction. Veuillez contacter l'administrateur.");
			
		}
	}
	
	/**************************************************************/
	
	public void accederGestionFournisseurs() {
		String identifiant = View.getTextField().getText();
		boolean ok=false;
		
		arrayRecherche=utilisateurDao.rechercherUtilisateur(identifiant);		
	    
	    for (UtilisateurModel utilisateur : arrayRecherche) {
	        if (utilisateur.getIdDroitAcces()==3) {
	            ok = true;
	            break;
	        } 
	    }
	    
	    if (ok) {
	        View.getPanelAppli().setVisible(false);
	        View.getPanelAchat().setVisible(false);
		    View.getPanelClientPatient().setVisible(false);
		    View.getPanelGestionUtilisateurs().setVisible(false);
		    View.getPanelVente().setVisible(false);
		    View.getPanelAjoutFournisseurRef().setVisible(true);
	    } else {
	        View.getMessageAccueil().setText(identifiant +", vous ne disposez pas de droits d'accès suffisants pour accéder à cette fonction. Veuillez contacter l'administrateur.");
			
		}
	}
	
	
	/***************************************************************/
	
	/**
	 * @author Aicha EL ATTAOUI  @date 21/03/2024
	 * 
	 * retourMenu()
	 * 
	 * méthode void sans paramètre
	 * 
	 * on récupère les panels de vente, d'achat, de gestion des stocks et de gestion utilisateur pour les rendre invisibles
	 * on récupère le panel d'accueil que l'on rend visible.
	 * 
	 */
	
	public void retourMenu() {
		
		
		
		View.getPanelAppli().setVisible(true);
		View.getPanelVente().setVisible(false);
		View.getPanelAchat().setVisible(false);
		View.getPanelClientPatient().setVisible(false);
		View.getPanelGestionUtilisateurs().setVisible(false);
		View.getPanelAjoutFournisseurRef().setVisible(false);
		
		viderAllChampsTextes();
	}
	
	/***************************************************************/
	
	public void accederFichierClient() {
		View.getPanelAppli().setVisible(false);
		View.getPanelClientPatient().setVisible(true);
		
	}
	
	/**************************************************************/
	
	public void viderAllChampsTextes() {
		String vide="";
		int indexDef=-1;
		
		//vider champs textes
		
		View.getTextAreaDescription().setText(vide);
		View.getTextDateExp().setText(vide);
		View.getTextDateFab().setText(vide);
		View.getTextDateOrdo().setText(vide);
		View.getTextGestIdUtilisateur().setText(vide);
		View.getTextGestMailUtilisateur().setText(vide);
		View.getTextGestMdpUtilisateur().setText(vide);
		View.getTextGestNomUtilisateur().setText(vide);
		View.getTextGestPrenomUtilisateur().setText(vide);
		View.getTextMessageGestionUtil().setText(vide);
		View.getComboBoxNomAchatMed().setSelectedIndex(indexDef);
		View.getTextNomCli().setText(vide);
		View.getTextNomPatient().setText(vide);
		View.getTextNss().setText(vide);
		View.getTextNumCli().setText(vide);
		View.getTextPrenomCli().setText(vide);
		View.getTextPrenomPatient().setText(vide);
		View.getTextPrixTotal().setText(vide);
		View.getTextPrixUnitaire().setText(vide);
		View.getTextPrixVente().setText(vide);
		View.getTextQteDemande().setText(vide);
		View.getTextQteStock().setText(vide);
		View.getTextQuantiteAchat().setText(vide);
		View.getTextRechercherClient().setText(vide);
		View.getTextRefAchatMed().setText(vide);
		View.getTextTelCli().setText(vide);
		
		/*//vider combobox
		
		View.getComboCategorie().setSelectedIndex(indexDef);
		View.getComboFournisseur().setSelectedIndex(indexDef);
		View.getComboNiveauDroits().setSelectedIndex(indexDef);
		View.getComboProduit().setSelectedIndex(indexDef);*/
	}
	
	
	/************************************************************/
	

	// A partir de ce point, on trouve les fonctions liées au menu des ventes
	
	/******************************************************************/
	
	/**
	 * @author Aicha EL ATTAOUI @date 21/03/2024
	 * 
	 * supprimerPanier()
	 * 
	 * s'utilise après sélection d'un item du panier par l'utilisateur (cf. selectionnerItemPanier() )
	 * 
	 * réinitialise la combobox de produits à sa valeur par défaut et vide le champ de quantité demandée.
	 * 
	 */
	
	public void supprimerPanier() {
		
		
		
		View.getComboProduit().setSelectedIndex(-1);
		View.getTextQteDemande().setText("");
		//ajouter prix
	}
	
	/*******************************************************************/
	
	public void rechercherClient() {
		
		String recherche=View.getTextRechercherClient().getText();
		
		arrayRechercheCli=clientDao.rechercherClient(recherche);
		
		if(arrayRechercheCli!=null) {
			for (clientModel client : arrayRechercheCli) {
				int numCli=client.getNum();
				String num=numCli+"";
				View.getTextNumCli().setText(num);
				View.getTextNomCli().setText(client.getNom());
				View.getTextPrenomCli().setText(client.getPrenom());
				View.getTextTelCli().setText(client.getTel());
				View.getMessageVente().setText("Client trouvé dans la base de données.");
			}
		} else {
			View.getMessageVente().setText("Nouveau client. Il sera enregistré dans la base après validation du client.");
		}
	}
	
	/******************************************************************/
	
	/**
	 * @author Aicha EL ATTAOUI @date 21/03/2024
	 * 
	 * validerOrdonnance()
	 * 
	 * méthode void sans paramètre
	 * 
	 * variables :
	 * 
	 * String dateOrdonnance1 -> récupère contenu champ texte correspondant
	 * String numSecu -> récupère contenu champ texte correspondant
	 * String nomPatient -> récupère contenu champ texte correspondant
	 * String prenomPatient -> récupère contenu champ texte correspondant
	 * boolean verifNumSecu -> vérifie le format du numéro de sécurité sociale. true si format ok et false si mauvais format.
	 * boolean verifDate ->  vérifie le format de la date (AAAA-MM-JJ). true si format ok et false si mauvais format.
	 * 
	 * int compteVerif et int ok (nombre de vérifications à passer).
	 * 
	 * on incrémente de 1 quand la vérification du numéro de sécurité sociale est ok, pareil si la vérification du format de la date est ok.
	 * 
	 * si on a le bon nombre de vérifications ok, on enregistre les informations dans la base de données, sinon on retourne un message d'erreur dans le champ texte dédié.
	 * 
	 */
	
	
	public void validerOrdonnance() {
		
		
		
		String dateOrdonnance1=View.getTextDateOrdo().getText();
		String numSecu=View.getTextNss().getText();
		String NomPatient=View.getTextNomPatient().getText();
		NomPatient=formatterChaine(NomPatient);
		String PrenomPatient=View.getTextPrenomPatient().getText();
		PrenomPatient=formatterChaine(PrenomPatient);
		boolean verifNumSecu=verifNumSecu(numSecu);
		boolean verifDate=false;
		
		// formatter date + vérifier format
		
		dateOrdonnance1=formatterDateSaisie(dateOrdonnance1);
		verifDate=verifDate(dateOrdonnance1);
		if (verifDate!=true) {
			View.getTextMessageAchat().setText("Il y a un problème dans la date de fabrication saisie.");
			}
		
		verifDate=verifDate(dateOrdonnance1);
		
		// formatter les chaines de caractères
		
		NomPatient=formatterChaine(NomPatient);
		PrenomPatient=formatterChaine(PrenomPatient);
		
		// ici je procède par un compteur pour vérifier si les conditions sont remplies car cela permet d'ajouter par la suite d'autres contrôles si nécessaire en ne changeant que le nombre affecté à ok.
		int compteVerif=0;
		int ok=1;
		
		// vérification du format du numéro de sécurité sociale
		
		  if (verifNumSecu==true) {
			compteVerif+=1;
		}
		
		// vérification du format de la date d'ordonnance
		
		//if (verifDate==true) {
			//compteVerif+=1;
		//}
		
		// si les vérifications sont bonnes on enregistre le patient dans la base
		
		if (compteVerif==ok) {
			unPatient.setNom(NomPatient);
			unPatient.setPrenom(PrenomPatient);
			unPatient.setNss(numSecu);
			unPatient.setDateOrdonnance(dateOrdonnance1);
			
			patientDao.ajouterPatient(unPatient);
			
			View.getMessageVente().setText("Patient enregistré.");
			arrayPatient=patientDao.getAllPatient();
			View.getListPatient().setListData(arrayPatient.toArray());
		} else {
			View.getMessageVente().setText("Il y a eu une erreur de saisie : le format du numéro de sécurité sociale saisi est incorrect.");
		}
		
		
		
		
	}
	
	/********************************************************************/
	
	/**
	 * @author Aicha EL ATTAOUI @date 21/03/2024
	 * 
	 * selectionnerItemPanier()
	 * 
	 * méthode void sans paramètre
	 * 
	 * variables :
	 * 
	 * int index : correspond à l'index sélectionné par l'utilisateur.
	 * String nomArticle : chaine vide à l'initialisation.
	 * 
	 * 1ère vérification : si l'index sélectionné vaut -1 ( pas d'index sélectionné par l'utilisateur) on ne retourne rien
	 * 
	 * on cree un modele de Panier dans lequel on récupère le contenu de l'index de l'ArrayList du panier (donc l'item sélectionné par l'utilisateur)
	 * 
	 * on remplit le champ texte correspondant à la quantité demandée grâche à l'information dans le modele
	 * on stocke dans nom article le nom de l'article dans le modele
	 * 
	 * on parcourt les items contenus dans la comboBox de produit jusqu'à retrouver le nom du produit enregistré dans le modele et on place l'index sélectionné à ce produit.
	 * 
	 * on recherche grâce à la méthode rechercherMed() de MedDAO l'article sélectionné
	 * on remplit, grâce au résultat de la recherche, les champs textes concernés.
	 * 
	 * enfin on supprime l'item du panier.
	 * 
	 */
	
	public void selectionnerItemPanier() {
		
	    int indice = View.getListPanier().getSelectedIndex();
	    
	    System.out.println(indice);
	    System.out.println(listePanier.size());
	    
	    if (indice == -1) {

	    	View.getMessageVente().setText("aucun item sélectionné");
	        return;
	    } 
	    /*else if(index >= listePanier.size()) {
	    	View.getMessageVente().setText("Index supérieur à la longueur de la liste");
	    	System.out.println("Index supérieur à la longueur de la liste");
	    	return;
	    }*/ else {
	    	
	        System.out.println(listePanier.size());

	        // test remplissage de la liste
	        for(int i=0; i<listePanier.size(); i++) {
	        	PanierModel test = (PanierModel) listePanier.get(i);
	        	System.out.println(test.toString());
	        }
	        
	    PanierModel modele = (PanierModel) listePanier.get(indice);
	    	View.getTextQteDemande().setText(modele.getQteDemandee()+"");

	    	String nomArticle = modele.getNomMed();
	    	System.out.println(nomArticle);

	    // Recherche de l'élément correspondant dans la ComboBox
	    for (int i = 0; i < View.getComboProduit().getItemCount(); i++) {
	        String item = (String) View.getComboProduit().getItemAt(i);
	        if (item.equals(nomArticle)) {
	            // Sélectionner l'élément correspondant dans la ComboBox
	            View.getComboProduit().setSelectedIndex(i);
	            break;
	        }
	    }

	    // Suppression de l'élément de la liste
	    
	    listePanier.remove(indice);
	    View.getListPanier().setListData(listePanier.toArray());
	    
	    }
	}
	
	/********************************************************************/
	
	/**
	 * @author Aicha EL ATTAOUI  @date 21/03/2024
	 * 
	 * validerClient()
	 * 
	 * méthode void sans paramètre
	 * 
	 * variables :
	 * 
	 * String telCli
	 * Boolean existe initialisé à false
	 * 
	 * on récupère dans telCli le contenu du champ texte contenant le numéro de téléphone du client
	 * 
	 * on recherche le client dans la base de données à partir de son numéro de téléphone grace à la méthode rechercherClient() de clientDAO.
	 * 
	 * si le resultat est une ArrayList contenant null, alors on renvoie un message d'erreur dans le champ de message dédié
	 * si le resultat n'est pas null alors on change la valeur de existe pour la passer à true
	 * 
	 * si existe est true, alors on parcourt le tableau des résultats de façon à remplir les champs textes avec les informations du client et on renvoie un message disant que le client a été trouvé.
	 * 
	 */
	
	public void validerClient() {
		
		
		
		String telCli;
		String nomCli=View.getTextNomCli().getText();
		nomCli=formatterChaine(nomCli);
		String prenomCli=View.getTextPrenomCli().getText();
		prenomCli=formatterChaine(prenomCli);
		boolean existe=false;
		
		telCli=View.getTextTelCli().getText();
		
		
		arrayRechercheCli=clientDao.rechercherClient(telCli);
		
		if (arrayRechercheCli==null) {
			// formatter chaines avant enregistrement
			nomCli=formatterChaine(nomCli);
			prenomCli=formatterChaine(prenomCli);
			
			unClient=new clientModel();
			unClient.setNom(nomCli);
			unClient.setPrenom(prenomCli);
			unClient.setTel(View.getTextTelCli().getText());
			
			arrayClient.add(unClient);
			View.getListClient().setListData(arrayClient.toArray());
		}
		
		if (arrayRechercheCli!=null) {
			
			for (clientModel client : arrayRechercheCli) {
				int numCli=client.getNum();
				String num=numCli+"";
		        View.getTextNumCli().setText(num);
		        View.getTextNomCli().setText(client.getNom());
		        View.getTextPrenomCli().setText(client.getPrenom());
		        View.getMessageVente().setText("Client trouvé et enregistré pour cette vente.");
		   }
		}
	}
	
	/***************************************************************/
	
	/**
	 * @author Aicha EL ATTAOUI	@date 21/03/2024
	 * 
	 * ajouterPanier()
	 * 
	 * méthode  void sans paramètre
	 * 
	 * variables :
	 * 
	 * String produit -> récupère le nom du produit sélectionné par l'utilisateur au moment où il ajoute l'item au panier
	 * String qteDemandee -> récupère le contenu du champ texte correspondant à la quantité demandée par le client
	 * int qteDemande -> transforme qteDemandee (string) en int
	 * int idMed
	 * int numCat
	 * int desc
	 * int ref
	 * int qteStock
	 * String nomMed
	 * String quantiteStock
	 * String donneesPanier
	 * 
	 * on recherche le medicament à partir du nom du produit sélectionné par l'utilisateur avec la méthode rechercherMed() de MedDAO
	 * 
	 * on stocke dans des variables les informations concernant le medicament recherché
	 * 
	 * on met à jour la valeur de la variable qui correspond au stock dans la base de données et dans le champ texte si la quantité en stock est inférieure ou égale à la quantité demandée, sinon on renvoie un message d'erreur
	 * 
	 * on affiche ensuite dans le champ texte de message un message de confirmation
	 * 
	 */
	
	public void ajouterPanier() {
	    String produit = View.getComboProduit().getSelectedItem().toString();
	    String qteDemandee = View.getTextQteDemande().getText();
	    int qteDemande = Integer.parseInt(qteDemandee);
	    int idMed = 0;
	    int numCat = 0;
	    String desc = "";
	    int ref = 0;
	    int qteStock = 0;
	    String nomMed = "";
	    String quantiteStock = "";
	    float prixVente=0;
	    String total=View.getTextPrixTotal().getText();
	    float prixTotal=0;

	    // Recherche du médicament à partir du nom du produit sélectionné par l'utilisateur
	    arrayRechercheMed = medDao.rechercherMed(produit);
	    for (MedModel medicament : arrayRechercheMed) {
	        idMed = medicament.getId();
	        numCat = medicament.getCategorie();
	        desc = medicament.getDescription();
	        ref = medicament.getRef();
	        qteStock = medicament.getQuantiteStock();
	        nomMed = medicament.getNom();
	        prixVente=medicament.getPrixVenteU();
	    }
	    
	    if(total.equals("")) {
	    	prixTotal=0;
	    } else {
	    	prixTotal=Float.parseFloat(total);
	    }

	    // Mise à jour de la valeur de la variable correspondant au stock
	    qteStock -= qteDemande;

	    if (qteStock < 0) {
	        View.getMessageVente().setText("La quantité demandée dépasse la quantité disponible en stock.");
	        return;
	    } else {
	        // Mise à jour du stock à l'intérieur de la base
	        medDao.miseAJourStock(idMed, qteStock);
	        View.getMessageVente().setText("Le stock a été mis à jour.");
	        quantiteStock = "" + qteStock;
	        View.getTextQteStock().setText(quantiteStock);

	        unPanier=new PanierModel();
	        unPanier.setNomMed(nomMed);
	        unPanier.setQteDemandee(qteDemande);
	        unPanier.setPrixTotalArticle(prixVente*qteDemande);
	        
	        prixTotal=prixTotal+prixVente*qteDemande;
	        View.getTextPrixTotal().setText(""+prixTotal);

	        // Ajout de l'élément à la listePanier
	        listePanier.add(unPanier);

	        // Mise à jour de l'affichage de la listePanier
	        View.getListPanier().setListData(listePanier.toArray());

	        // Message de confirmation
	        View.getMessageVente().setText("Le produit a bien été ajouté au panier.");
	    }
	}
	
	/*******************************************************************/
	
	/**
	 * @author Aicha EL ATTAOUI  @date 21/03/2024
	 * 
	 * modifierPanier()
	 * 
	 * méthode void sans paramètre
	 * 
	 * variables :
	 * 
	 * String nomMed ->  récupère le nom du médicament depuis l'interface
	 * String qteDemande -> récupère contenu du champ texte concerné depuis l'interface
	 * int qteDemandee -> transforme le string qteDemande en int
	 * String prixTotal -> récupère contenu du champ texte concerné
	 * float total -> transforme le string prixTotal en float
	 * float prixVenteU
	 * 
	 * on recherche le médicament avec la méthode rechercherMed() de MedDAO
	 * 
	 * on récupère le prix de vente unitaire du produit que l'on stocke dans prixVenteU
	 * 
	 * on enregistre dans l'objet Panier unPanier le nomMed, QteDemandee et PrixTotalArticle
	 * 
	 * on ajoute un Panier à l'ArrayList contenant le reste du panier.
	 */
	
	public void modifierPanier() {
	    String nomMed = View.getComboProduit().getSelectedItem().toString();
	    String qteDemande = View.getTextQteDemande().getText();
	    String prixTotal = View.getTextPrixTotal().getText();

	    // Vérifier si les champs ne sont pas vides
	    if (qteDemande.isEmpty() || prixTotal.isEmpty()) {
	        // Afficher un message d'erreur ou prendre une autre action appropriée
	    	View.getMessageVente().setText("La quantité demandée ou le prix total n'a pas été renseigné.");
	        return;
	    }

	    int qteDemandee = Integer.parseInt(qteDemande);
	    float total = Float.parseFloat(prixTotal);
	    float prixVenteU = 0;

	    arrayRechercheMed = medDao.rechercherMed(nomMed);

	    for (MedModel medicament : arrayRechercheMed) {
	        prixVenteU = medicament.getPrixVenteU();
	    }

	    unPanier.setNomMed(nomMed);
	    unPanier.setQteDemandee(qteDemandee);
	    unPanier.setPrixTotalArticle(prixVenteU * qteDemandee);

	    listePanier.add(unPanier);
	}
	
	/************************************************************/
	
	/**
	 * @author Aicha EL ATTAOUI @date 21/03/2024
	 * 
	 * selectionnerProduit() 
	 * 
	 * méthode void sans paramètre
	 * 
	 * variables :
	 * 
	 * String produitSelectionne
	 * int idMed initialisé à -1
	 * 
	 * on stocke dans produitSelectionne le nom de l'item selectionné par l'utilisateur dans la combobox de produit
	 * 
	 * si on récupère "Sélectionnez un produit" c'est-à-dire la valeur par défaut, alors on renvoie un message d'erreur dans le champ texte dédié
	 * 
	 * sinon on recherche le produit par son nom avec la méthode rechercherMed() de MedDAO
	 * 
	 * si le résultat est null on renvoie un message d'erreur
	 * sinon on récupère la quantité du médicament en stock que l'on rentre dans le champ texte dédié
	 * 
	 */
	
	public void selectionnerProduit() {
		
		
		
		String produitSelectionne;
		int idMed=-1;
		
		// récupérer l'item sélectionné
		produitSelectionne=View.getComboProduit().getSelectedItem().toString();
		System.out.println(produitSelectionne);
		
		if (produitSelectionne.equals("Sélectionnez un produit")) {
			View.getMessageVente().setText("Vous n'avez pas sélectionné de produit");
		} else {
			arrayRechercheMed=medDao.rechercherMed(produitSelectionne);
			
			if (arrayRechercheMed==null) {
				View.getMessageVente().setText("Le produit n'existe pas.");
			} else {
				for (MedModel medicament : arrayRechercheMed) {
					String qteStock=medicament.getQuantiteStock()+"";
					idMed=medicament.getId();
					String prixUnit=medicament.getPrixVenteU()+"";
					
			        View.getTextQteStock().setText(qteStock);
			    }
				
			    }
				
			}
			
			View.getComboProduit().setSelectedItem(produitSelectionne);
		
	}
	
	/************************************************************/
	
	/**
	 * @author Aicha EL ATTAOUI  @date 23/03/2023
	 * 
	 * validerPanier()
	 * 
	 * méthode void sans paramètre
	 * 
	 * enregistre dans une facture la date d'achat et le panier
	 * 
	 * 
	 */
	
	public void validerPanier() {
		
		
		
		// gérer histoire de date de facture + créer un bouton valider panier pour enregistrer la commande. 
		
		int numCli=0;
		int idPatient=0;
		String dateFacture=recupererDateSysteme();
		String nss;
		String numeroClient=View.getTextNumCli().getText();
		
		if(numeroClient.equals("")){
			numCli=21;
		} else {
			numCli=Integer.parseInt(numeroClient);
		}
		
		
		nss=View.getTextNss().getText();
		
		arrayRecherchePatient=patientDao.rechercherPatient(nss);
		
		for (PatientModel patient : arrayRecherchePatient) {
			idPatient=patient.getId();
		}
		
		uneFacture.setNumCli(numCli);
		uneFacture.setIdPatient(idPatient);
		uneFacture.setDateFacture(dateFacture);
		
		factureDao.ajouterFacture(uneFacture);
		
		arrayFacture.add(uneFacture);
		
		View.getListCommandes().setListData(arrayFacture.toArray());
		
	}
	
	/***********************************************************/

	// A partir de ce point, on trouve les vérifications de formats de différents champs (mail, téléphone, numéro de sécurité sociale...)
	
	/******************************************************************/
	
	/**
	 * @author Aicha EL ATTAOUI 	@date 14/12/2023
	 * 
	 * return boolean true si le format est bon et false si le format est faux.
	 * 
	 * paramètre : une chaine de caractère quelconque
	 * 
	 * vérifications effectuées :
	 * 
	 * - le mail contient un @
	 * - le mail se termine par .fr, .com, .net ou .org
	 * 
	 * 
	 */
	
	public static boolean verificationEmail(String chaine) {
		
		
		
		boolean trouve = false;
		
		if(chaine.charAt(0)=='@') {
			return trouve;
		}
		
		else {
		for(int i=0; i<chaine.length(); i++) {
			if(chaine.charAt(i)=='@') {
			
				if(chaine.endsWith(".fr")||chaine.endsWith(".com")|| chaine.endsWith(".net")|| chaine.endsWith(".org")) {
					trouve= true;
					break;
							}
				else {break;}
			}
		}
		}
		return trouve;
	
	
	}
	
	/************************************************************/
	
	/**
	 * @author Aicha EL ATTAOUI @date 21/03/2024
	 * 
	 *  verifTel()
	 *  
	 *  méthode avec return d'un boolean et en paramètre un string correspondant au numéro de téléphone à vérifier
	 *  
	 *  variable :
	 *  
	 *  boolean ok initialisé à false
	 *  
	 *  on vérifie la longueur de la chaine de caractères saisie qui doit être égale à 10
	 *  on vérifie si le numéro commence par 03, 06 ou 07
	 *  
	 *  si ces deux conditions sont remplies, alors on change la valeur de ok à true
	 *  
	 *  on retourne ok
	 *  
	 *  
	 */
	
	
	public static boolean verifTel(String tel) {
		
		
		boolean  ok= false;
		
		if(tel.length()!=10) {
			ok= false;
			return ok;
		}
		
		else if(tel.length()==10) {
			if(tel.charAt(0)=='0' && tel.charAt(1)=='3') {
				ok= true;
			}
			if(tel.charAt(0)=='0' && tel.charAt(1)=='6') {
				ok=true;
			}
			if(tel.charAt(0)=='0' && tel.charAt(1)=='7') {
				ok=true;
			}
		}
		
		return ok;
	}
	
	/*********************************************************/
	
	/**
	 * @author Aicha EL ATTAOUI  @date 21/03/2024
	 * 
	 * verifNumSecu()
	 * 
	 * méthode qui retourne un boolean et qui a en paramètre un String correspondant au numéro de sécurité sociale à vérifier
	 * 
	 * variable :
	 * 
	 * boolean ok initialisé à false
	 * 
	 * on vérifie que la longueur du numéro de sécurité sociale vaut bien 15
	 * on vérifie que le numéro commence par 1 ou 2
	 * 
	 * si les deux conditions sont remplies, la valeur de ok passe à true
	 * 
	 * on retourne ensuite ok
	 */
	
	public static boolean verifNumSecu(String numSecu) {
		
		
		
		boolean  ok= false;
		
		if(numSecu.length()>=16) {
			//ok= false;
			return ok;
		}
		
		else if(numSecu.length()<=15) {
			/*if(numSecu.charAt(0)=='1' || numSecu.charAt(0)=='2') {
				ok= true;
			}*/
			ok=true;
		}
		return ok;
	}
		
		/*****************************************************/
		
	public static boolean verifDate(String date) {
        try {
            LocalDate.parse(date);
            return true;
        } catch (Exception e) {
            System.out.println("Date refusée");
            return false;
        }
    }
		
			
			/*****************************************************/
		
		/**
		 * @author Aicha EL ATTAOUI @date 19/03/2024
		 * 
		 * paramètre : un String correspondant à l'identifiant à vérifier
		 * 
		 * sortie : un boolean
		 * 
		 * méthode de vérification de l'identifiant d'un utilisateur à appliquer avant enregistrement dans la base de données.
		 * 
		 * cette méthode fait une recherche par identifiant et retourne true si l'identifiant n'existe pas et false s'il existe.
		 * 
		 */
		
		public boolean verifIdentifiantUtilisateur(String identifiant) {
			
			
			
			boolean ok=false;
			
			arrayRecherche=utilisateurDao.rechercherUtilisateur(identifiant);
			
			if(arrayRecherche==null) {
				ok=true;
			} else {
				return ok;
			}
			
			return ok;
		}
			
			/*****************************************************/
		public String formatterChaine(String chaine) {
			
			char a='*';
			
			for(int i=0; i<chaine.length(); i++) {
				a=chaine.charAt(i);
				switch (a) {
				case '\'':
					chaine=chaine.replace('\'', ' ');
					break;
				case 'é' :
					chaine=chaine.replace('é', 'e');
					break;
				case 'à':
					chaine=chaine.replace('à', 'a');
					break;
				case 'è':
					chaine=chaine.replace('è', 'e');
					break;
				case 'ù':
					chaine=chaine.replace('ù', 'u');
					break;
				case 'ç':
					chaine=chaine.replace('ç', 'c');
					break;
				case 'ê':
					chaine=chaine.replace('ê', 'e');
					break;
				case 'â':
					chaine=chaine.replace('ê', 'a');
					break;
				case 'î':
					chaine=chaine.replace('î', 'i');
					break;
				default:
					break;
				}
			}
			
			return chaine;
		}
		
		/**********************************************************/
		
		public String formatterDateSaisie(String chaine) {
			String chaineFormattee="";
			String []date = chaine.split("/");
			String annee="";
			String mois="";
			String jour="";
			
			//System.out.println("formatterDateSaisie s'est lancé");
			
			if (date!=null) {
				//System.out.println("le pattern a été reconnu");
				annee=date[2];
				mois=date[1];
				jour=date[0];
			
			chaineFormattee=annee+"-"+mois+"-"+jour;
			}
			else {
				//System.out.println("pattern non reconnu");
				chaineFormattee=chaine;
			}
			
			return chaineFormattee;
		}
		
				
		
		/************************************************/
		
		public String recupererDateSysteme() {
			
			// Obtenir la date système
	        LocalDate date = LocalDate.now();
	        
	        // Formatter pour le format AAAA-MM-JJ
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	        
	        // Convertir la date en chaîne au format désiré
	        String dateAuFormat = date.format(formatter);
	        
	        // Afficher la date au format AAAA-MM-JJ
	        System.out.println("Date système au format AAAA-MM-JJ : " + dateAuFormat);
	        
	        return dateAuFormat;
	    }
		
		/************************************************/
		
		// à partir de ce point, on trouve les fonctions liées à la gestion des utilisateurs
		
			/*****************************************************/
		
		/**
		 * @author Aicha EL ATTAOUI		@date 19/03/2024
		 * 
		 * méthode ajout d'utilisateur à partir d'une saisie utilisateur dans différents champs textes de l'application
		 * 
		 * pas de paramètres en entrée, on récupère les saisies dans les différents champs textes : nom, prenom, identifiant, mot de passe, mail.
		 * 
		 * on fait une vérification du format de l'email, puis une vérification de l'identifiant.
		 * 
		 * si les deux vérifications sont ok, on enregistre l'utilisateur dans la base.
		 * 
		 * sinon on retourne un message d'erreur sur le champ texte dédié.
		 * 
		 */
		
		public void ajouterUtilisateur() {
			
			
			
			String nomUtilisateur="";
			String prenomUtilisateur="";
			String identifiantUtilisateur="";
			String mdpUtilisateur="";
			String mailUtilisateur="";
			String derniereCo=recupererDateSysteme();
			int indexDroits=View.getComboNiveauDroits().getSelectedIndex();
			boolean verifMail=false;
			boolean verifIdentifiantUtilisateur=false;
			
			nomUtilisateur=View.getTextGestNomUtilisateur().getText();
			nomUtilisateur=formatterChaine(nomUtilisateur);
			prenomUtilisateur=View.getTextGestPrenomUtilisateur().getText();
			prenomUtilisateur=formatterChaine(prenomUtilisateur);
			identifiantUtilisateur=View.getTextGestIdUtilisateur().getText();
			identifiantUtilisateur=formatterChaine(identifiantUtilisateur);
			mdpUtilisateur=View.getTextGestMdpUtilisateur().getText();
			mdpUtilisateur=formatterChaine(mdpUtilisateur);
			mailUtilisateur=View.getTextGestMailUtilisateur().getText();
			mailUtilisateur=formatterChaine(mailUtilisateur);
			
			verifMail=verificationEmail(mailUtilisateur);
			verifIdentifiantUtilisateur=verifIdentifiantUtilisateur(identifiantUtilisateur);
			
			if (verifMail==true && verifIdentifiantUtilisateur==true) {
				unUtilisateur.setNomUtilisateur(nomUtilisateur);
				unUtilisateur.setPrenomUtilisateur(prenomUtilisateur);
				unUtilisateur.setIdentifiant(identifiantUtilisateur);
				unUtilisateur.setMotDePasse(mdpUtilisateur);
				unUtilisateur.setAdresseMail(mailUtilisateur);
				unUtilisateur.setDateDerniereConnexion(derniereCo);
				unUtilisateur.setIdDroitAcces(indexDroits);
				
				utilisateurDao.ajouterUtilisateur(unUtilisateur);
				
				View.getTextMessageGestionUtil().setText("L'utilisateur "+nomUtilisateur+" a bien été créé.");
				
			} else {
				View.getTextMessageGestionUtil().setText("La création de l'utilisateur "+nomUtilisateur+" est impossible. Cet utilisateur existe déjà.");
			}
		}
		
		/******************************************************/
		
		/**
		 * @author Aicha EL ATTAOUI @date 19/03/2022
		 * 
		 * méthode pour enregistrer les modifications apportées à un utilisateur après qu'il ait été sélectionné dans la liste. (cf. selectionnerUtilisateur() )
		 * 
		 * pas de paramètre d'entrée ni de sortie.
		 * 
		 * on récupère les informations saisies dans l'interface, que l'on stocke dans des variables.
		 * 
		 * on recherche ensuite l'utilisateur par son identifiant afin d'obtenir son id dans la base de données.
		 * 
		 * lance ensuite la méthode modifierUtilisateur() de UtilisateurDAO pour enregistrer les changements dans la base de données.
		 * 
		 * enfin on met à jour la liste des utilisateurs.
		 * 
		 */
		
		public void modifierUtilisateur() {
			
			
			
			String nomUtilisateur=View.getTextGestNomUtilisateur().getText();
			nomUtilisateur=formatterChaine(nomUtilisateur);
			String prenomUtilisateur=View.getTextGestPrenomUtilisateur().getText();
			prenomUtilisateur=formatterChaine(prenomUtilisateur);
			String identifiant=View.getTextGestIdUtilisateur().getText();
			identifiant=formatterChaine(identifiant);
			String mdp=View.getTextGestMdpUtilisateur().getText();
			mdp=formatterChaine(mdp);
			String mail=View.getTextGestMailUtilisateur().getText();
			mail=formatterChaine(mail);
			int indexDroits=View.getComboNiveauDroits().getSelectedIndex();
			int idUtilisateur=-1;
			
			arrayRecherche=utilisateurDao.rechercherUtilisateur(identifiant);
			
			
			UtilisateurModel modele = new UtilisateurModel();
				for (UtilisateurModel utilisateur : arrayRecherche) {
					idUtilisateur=utilisateur.getIdUtilisateur();
				}
				
			modele.setIdUtilisateur(idUtilisateur);
			
			utilisateurDao.modifierUtilisateur(modele);
			
			arrayUtilisateur = utilisateurDao.getAllUtilisateur();
			View.getListUtilisateur().setListData(arrayUtilisateur.toArray());
			
			View.getTextMessageGestionUtil().setText("L'utilisateur a bien été modifié.");
		}
		
		/******************************************************/
		
		/**
		 * @author Aicha EL ATTAOUI @date 19/03/2024
		 * 
		 * méthode pour remplir les champs textes de l'interface à partir de l'élément de la liste sélectionné par l'utilisateur.
		 * 
		 * pas de paramètre d'entrée ni de sortie.
		 * 
		 * on récupère l'index sélectionné par l'utilisateur.
		 * 
		 * si l'index vaut -1 (cas par défaut) alors on ne retourne rien, sinon on récupère, dans l'arrayList qui contient tous les utilisateurs, l'utilisateur correspondant à l'indice sélectionné.
		 * 
		 * on remplit les champs textes de l'interface avec les informations concernant l'utilisateur sélectionné.
		 * 
		 */
		
		public void selectionnerUtilisateur() {
			
			
			
			int index;
			int indexDroitUtil=-1;
			
			index=View.getListUtilisateur().getSelectedIndex();
			
			if(index==-1) {
				return;
			}
			
			UtilisateurModel modele = (UtilisateurModel) arrayUtilisateur.get(index);
			
			View.getTextGestNomUtilisateur().setText(modele.getNomUtilisateur());
			View.getTextGestPrenomUtilisateur().setText(modele.getPrenomUtilisateur());
			View.getTextGestIdUtilisateur().setText(modele.getIdentifiant());
			View.getTextGestMdpUtilisateur().setText(modele.getMotDePasse());
			View.getTextGestMailUtilisateur().setText(modele.getAdresseMail());
			View.getComboNiveauDroits().setSelectedIndex(modele.getIdDroitAcces());
			
		}
		
		/***************************************************/
		
		/**
		 * @author Aicha EL ATTAOUI @date 19/03/2024
		 * 
		 * méthode void qui permet de supprimer un utilisateur après l'avoir sélectionné dans la liste de l'interface.
		 * 
		 * pas de paramètre d'entrée ni de sortie.
		 * 
		 * on recherche l'utilisateur à supprimer à partir de son identifiant afin de récupérer son id dans la base de données.
		 * 
		 * avec l'id, on peut lancer la méthode de suppression de UtilisateurDAO.
		 * 
		 */
		
		public void supprimerUtilisateur() {
			
			
			
			int id=-1;
			String identifiant=View.getTextGestIdUtilisateur().getText();
			
			arrayRecherche=utilisateurDao.rechercherUtilisateur(identifiant);
			
			
				UtilisateurModel modele = new UtilisateurModel();
					for (UtilisateurModel utilisateur : arrayRecherche) {
						id=utilisateur.getIdUtilisateur();
					}
					
				if(id==-1) {
					return;
				} else {
					utilisateurDao.supprimerUtilisateur(id);
					
					// vider les champs textes
					
					View.getTextGestNomUtilisateur().setText("");
					View.getTextGestPrenomUtilisateur().setText("");
					View.getTextGestIdUtilisateur().setText("");
					View.getTextGestMdpUtilisateur().setText("");
					View.getTextGestMailUtilisateur().setText("");
					View.getComboNiveauDroits().setSelectedIndex(0);
					
					// message de validation
					
					View.getTextMessageGestionUtil().setText("L'utilisateur portant l'identifiant "+identifiant+" a bien été supprimé.");
				}
			
		}
		
		
		/*********************************************************/
		// à partir de ce point, toutes les méthodes liées au panel des achats
		
		/*********************************************************/
		
		/**
		 * @author Aicha EL ATTAOUI  @date 21/03/2024
		 * 
		 * ajouterEntreeSortie()
		 * 
		 * méthode void sans paramètre
		 * 
		 * variables :
		 * 
		 * récupèrent les saisies dans les champs textes de l'interface
		 * 
		 * si le bouton d'entrée est coché : la quantité reste positive
		 * si le bouton de sortie est coché : la quantité devient négative
		 * 
		 * on recherche le médicament d'entrée : si on le trouve on met la quantité à jour, sinon on ajoute une entrée dans la base
		 * on récupère l'id du médicament au passage
		 * 
		 * on enregistre ensuite l'entrée dans la base.
		 * 
		 * 
		 */
		
		public void ajouterEntreeSortie() {
			
			
			String refMed=View.getTextRefAchatMed().getText();
			String nomMed=View.getComboBoxNomAchatMed().getSelectedItem().toString();
			int numCat=View.getComboCategorie().getSelectedIndex();
			String desc=View.getTextAreaDescription().getText();
			String dateFab=View.getTextDateFab().getText();
			boolean okDateFab=false;
			String dateExp=View.getTextDateExp().getText();
			boolean okDateExp=false;
			String qteAchat=View.getTextQuantiteAchat().getText();
			String prixUnitaire=View.getTextPrixUnitaire().getText();
			String prixVente=View.getTextPrixVente().getText();
			int fournisseur=View.getComboFournisseur().getSelectedIndex();
			int qteAchetee=Integer.parseInt(qteAchat);
			float prixUnit=Float.parseFloat(prixUnitaire);
			float prixVente1=Float.parseFloat(prixVente);
			int refMed1=Integer.parseInt(refMed);
			int idMed=View.getComboBoxNomAchatMed().getSelectedIndex();
			int newStock=0;
			String entreeSortie="A";
			String dateEntreeSortie=recupererDateSysteme();
			
			desc=formatterChaine(desc);
			
			System.out.println(nomMed);
			
			//String patternDate="^\\d{2}/\\d{2}/\\d{4}$";
			
			//if (dateExp.matches(patternDate)) {
				dateExp=formatterDateSaisie(dateExp);
				okDateExp=verifDate(dateExp);
				if (okDateExp!=true) {
				View.getTextMessageAchat().setText("Il y a un problème dans la date d'expiration saisie.");
				}
				
			//}
			
			//if (dateFab.matches(patternDate)) {
				dateFab=formatterDateSaisie(dateFab);
				okDateFab=verifDate(dateFab);
				if (okDateFab!=true) {
					View.getTextMessageAchat().setText("Il y a un problème dans la date de fabrication saisie.");
					}
			//}
				
			if (okDateExp==true&&okDateFab==true) {
			
				if (View.getRdbtnSortieStock().isSelected()) {
					entreeSortie="E";
				}
				else if (View.getRdbtnSortieStock().isSelected()) {
					entreeSortie="S";
				}
			
				arrayRechercheMed=medDao.rechercherMed(nomMed);
			
				if(arrayRechercheMed==null) {
					unMedicament.setNom(nomMed);
					unMedicament.setRef(refMed1);
					unMedicament.setCategorie(numCat);
					unMedicament.setDescription(desc);
					unMedicament.setPrixVenteU(prixVente1);
					unMedicament.setQuantiteStock(qteAchetee);
				
					medDao.ajouterMed(unMedicament);
				
				}
			
				else if (arrayRechercheMed!=null) {
					MedModel modele = new MedModel();
					for (MedModel medicament : arrayRechercheMed) {
						idMed=medicament.getId();
						if (entreeSortie.equals("E")) {
							newStock=medicament.getQuantiteStock()+qteAchetee;
						}
						else if (entreeSortie.equals("S")) {
							newStock=medicament.getQuantiteStock()-qteAchetee;
						}
						medDao.miseAJourStock(idMed, newStock);
					}
				}
			
				MedModel modele2 = new MedModel();
				for (MedModel medicament : arrayRechercheMed) {
					idMed=medicament.getId();
				}
			
			/*if(View.getRdbtnEntreeStock().isSelected()) {
				qteAchetee=-qteAchetee;
			}*/
			
				uneES.setIdMed(idMed);
				uneES.setIdFour(fournisseur);
				uneES.setQuantite(qteAchetee);
				uneES.setDateFabrication(dateFab);
				uneES.setDateExpiration(dateExp);
				uneES.setDateEntreesSorties(dateEntreeSortie);
				uneES.setPrixUnitaire(prixUnit);
			
			
				entreesSortiesDao.ajouterES(uneES);
				arrayES.add(uneES);
				View.getListES().setListData(arrayES.toArray());
				
			}
		}
		
		/*********************************************************/
		
		/**
		 * @author Aicha EL ATTAOUI @date 21/03/2024
		 * 
		 * selectionnerEntreeSortie()
		 * 
		 * variable :
		 * 
		 * int index -> récupère indice sélectionné dans la liste des entrées sorties
		 * les autres variables servent à stocker les informations concernant le produit contenu dans l'entrée ou la sortie sélectionnée
		 * 
		 * on remplit les champs textes de l'interface avec les informations stockées dans les variables.
		 * 
		 * on efface ensuite l'entrée ou la sortie concernée de la liste.
		 * 
		 * on applique cette méthode avant d'appliquer le modifierEntreeSortie() ou supprimerEntreeSortie()
		 * 
		 */
		
		public void selectionnerEntreeSortie() {
			
			
			
			int index;
			String nomMed;
			int idMed;
			int idFour;
			int qte;
			String dateFab;
			String dateExp;
			String dateES;
			int qteAchat;
			double prixAchat;
			double prixVente;
			String desc;
			int ref;
			int numCat;
			int qteStock;
			String entreeSortie;
			
			index=View.getListES().getSelectedIndex();
			
			if(index==-1) {
				return;
			}
			
			// récupération des information depuis les listes concernées.
			
			EntreesSortiesModel modele = (EntreesSortiesModel) arrayES.get(index);
			idMed=modele.getIdMed();
			idFour=modele.getIdFour();
			qte=modele.getQuantite();
			dateFab=modele.getDateFabrication();
			dateExp=modele.getDateExpiration();
			dateES=modele.getDateEntreesSorties();
			prixAchat=modele.getPrixUnitaire();
			entreeSortie=modele.getEntreeSortie();
			
			MedModel modele2 = (MedModel) arrayMed.get(index);
			nomMed=modele2.getNom();
			desc=modele2.getDescription();
			ref=modele2.getRef();
			numCat=modele2.getCategorie();
			prixVente=modele2.getPrixVenteU();
			qteStock=modele2.getQuantiteStock();
			
			// remplissage des champs texte à partir des informations  récupérées
			
			View.getComboBoxNomAchatMed().setSelectedIndex(idMed);
			View.getTextRefAchatMed().setText(ref+"");
			View.getComboFournisseur().setSelectedIndex(idFour);
			View.getTextQuantiteAchat().setText(qte+"");
			View.getTextDateFab().setText(dateFab);
			View.getTextDateExp().setText(dateExp);
			View.getTextPrixUnitaire().setText(prixAchat+"");
			View.getTextAreaDescription().setText(desc);
			View.getComboCategorie().setSelectedIndex(numCat);
			View.getTextPrixVente().setText(prixVente+"");
			
			//System.out.println(entreeSortie);
			
			if (entreeSortie.equals("E")) {
				View.getRdbtnEntreeStock().setSelected(true);
				View.getRdbtnSortieStock().setSelected(false);
			}
			else if (entreeSortie.equals("S")) {
				View.getRdbtnEntreeStock().setSelected(false);
				View.getRdbtnSortieStock().setSelected(true);
			}
			
			// suppression de l'item de la liste des EntreesSorties
			
			//arrayES.remove(index);
			//View.getListES().setListData(arrayES.toArray());
			
			// mise à jour du stock
			
			//qteStock=qteStock-qte;
			
			//medDao.miseAJourStock(idMed, qteStock);
		}
		
		/*********************************************************/
		
		/**
		 * @author Aicha EL ATTAOUI  @date 23/03/2024
		 * 
		 * modifierEntreeSortie()
		 * 
		 * méthode void sans paramètre.
		 * 
		 * variables :
		 * 
		 * liste de variables pour stocker les informations récupérées depuis l'interface.
		 * 
		 * sert à enregistrer les informations saisies dans une nouvelle entree/sortie et à la stocker dans la liste des entrées sorties.
		 * 
		 */
		
		public void modifierEntreeSortie() {
			
			
			
			// variables
			
			String nomMed="";
			int idMed=-1;
			int idFour;
			int qte=0;
			String dateFab;
			String dateExp;
			String dateES;
			int qteAchat=0;
			double prixAchat;
			double prixVente;
			String desc;
			int ref;
			int numCat;
			String entreeSortie="A";
			String message="";
			
			
			// récupération des informations saisies par l'utilisateur dans l'interface
			
			idMed=View.getComboBoxNomAchatMed().getSelectedIndex();
			idFour=View.getComboFournisseur().getSelectedIndex();
			qteAchat=Integer.parseInt(View.getTextQuantiteAchat().getText());
			dateFab=View.getTextDateFab().getText();
			boolean okDateFab=false;
			dateExp=View.getTextDateExp().getText();
			boolean okDateExp=false;
			dateES=recupererDateSysteme();
			prixAchat=Double.parseDouble(View.getTextPrixUnitaire().getText());
			desc=View.getTextAreaDescription().getText();
			ref=Integer.parseInt(View.getTextRefAchatMed().getText());
			numCat=View.getComboCategorie().getSelectedIndex();
			
			switch (idMed) {
			case 1:
				nomMed="Paracetamol";
				break;
			case 2:
				nomMed="Amoxicilline";
				break;
			case 3:
				nomMed="Ibuprofene";
				break;
			case 4:
				nomMed="Meteoclopramide";
				break;
			case 5:
				nomMed="Aspirine";
				break;
			case 6:
				nomMed="Diazepam";
				break;
			case 7:
				nomMed="Drotaverine";
				break;
			default:
				break;
			}
			
			System.out.println(nomMed);
			
			if (View.getRdbtnEntreeStock().isSelected()==true) {
				entreeSortie="E";
			}
			else if (View.getRdbtnSortieStock().isSelected()==true) {
				entreeSortie="S";
			}
			
			// vérification si entrée ou sortie
			
			/*if (View.getRdbtnSortieStock().isSelected()==true) {
				qteAchat=-qteAchat;
			}*/
			
			// vérification format des dates
			
			//String patternDate="^\\d{2}/\\d{2}/\\d{4}$";
			
			//if (dateExp.matches(patternDate)) {
				dateExp=formatterDateSaisie(dateExp);
				okDateExp=verifDate(dateExp);
				if (okDateExp!=true) {
					View.getTextMessageAchat().setText("Il y a un problème dans la date d'expiration saisie.");
					}
			//}
			
			//if (dateFab.matches(patternDate)) {
				dateFab=formatterDateSaisie(dateFab);
				okDateFab=verifDate(dateFab);
				if (okDateFab!=true) {
					View.getTextMessageAchat().setText("Il y a un problème dans la date de Fabrication saisie.");
					}
			//}
			
			if (okDateExp==true && okDateFab==true) {
			
				//recherche des informations sur le médicament
			
				arrayRechercheMed=medDao.rechercherMed(nomMed);
			
				MedModel modele = new MedModel();
				for (MedModel medicament : arrayRechercheMed) {
					qte=medicament.getQuantiteStock();
				
				}
			
			
				// enregistrement des informations dans historique des entrées/sorties
			
				uneES.setIdMed(idMed);
				uneES.setIdFour(idFour);
				uneES.setDateFabrication(dateFab);
				uneES.setDateExpiration(dateExp);
				uneES.setPrixUnitaire(prixAchat);
				uneES.setQuantite(qteAchat);
				uneES.setEntreeSortie(entreeSortie);
				uneES.setDateEntreesSorties(dateES);
			
				arrayES.add(uneES);
			
				// mise à jour du stock de médicaments
							
					qte=qte+qteAchat;
				
					medDao.miseAJourStock(idMed, qte);
			}
			
		}
		
		/*********************************************************/
		
		/**
		 * @author Aicha EL ATTAOUI  @date 22/03/2024
		 * 
		 * supprimerEntreeSortie()
		 * 
		 * méthode void sans paramètre
		 * 
		 * s'utilise après sélectionnerEntreeSortie()
		 * 
		 * vide l'ensemble des champs textes.
		 */
		
		public void supprimerEntreeSortie() {
			
			int index=View.getListES().getSelectedIndex();
			
			if(index==-1) {
				return;
			}
			
			arrayES.remove(index);
			View.getListES().setListData(arrayES.toArray());
			
			
			View.getComboBoxNomAchatMed().setSelectedIndex(-1);
			View.getTextRefAchatMed().setText("");
			View.getComboFournisseur().setSelectedIndex(-1);
			View.getTextQuantiteAchat().setText("");
			View.getTextDateFab().setText("");
			View.getTextDateExp().setText("");
			View.getTextPrixUnitaire().setText("");
			View.getTextAreaDescription().setText("");
			View.getRdbtnEntreeStock().setSelected(false);
			View.getRdbtnSortieStock().setSelected(false);
			
		}
		
		/**********************************************/
		// à partir de ce point, les fonctions qui concernent l'ajout des fournisseurs, catégories et médicaments
		/**********************************************/
		
		public void ajouterFournisseur() {
			String nomFournisseur="";
			String adresseFournisseur="";
			String villeFournisseur="";
			int cpFournisseur=-1;
			
			nomFournisseur=View.getTextNomFournisseurAjout().getText();
			nomFournisseur=formatterChaine(nomFournisseur);
			adresseFournisseur=View.getTextAdresseFournisseur().getText();
			adresseFournisseur=formatterChaine(adresseFournisseur);
			villeFournisseur=View.getTextVilleFournisseur().getText();
			villeFournisseur=formatterChaine(villeFournisseur);
			cpFournisseur=Integer.parseInt(View.getTextCPFournisseur().getText());
			
			if(nomFournisseur.equals("")) {
				View.getTextMessageGestionFour().setText("Veuillez saisir au moins un nom pour le fournisseur");
			}
			
			else {
				
				if(adresseFournisseur.equals("")) {
					adresseFournisseur="inconnu";
				}
				if(villeFournisseur.equals("")) {
					villeFournisseur="inconnu";
				}
			
			unFournisseur=new FournisseurModel();
			unFournisseur.setNomFournisseur(nomFournisseur);
			unFournisseur.setAdresseFournisseur(adresseFournisseur);
			unFournisseur.setVilleFournisseur(villeFournisseur);
			unFournisseur.setCpFournisseur(cpFournisseur);
			
			
			//ajout du nom du fournisseur à la bdd
			fournisseurDao.ajouterFournisseur(unFournisseur);
			
			
			//ajout du nom du fournisseur à la combobox de gestion des stocks
			View.getComboFournisseur().addItem(nomFournisseur);
			
			//message de confirmation
			View.getTextMessageGestionFour().setText("Le fournisseur a bien été ajouté.");
			
			}
		}
		
		/***************************************************/
		
		public void ajouterCategorie() {
			String nomCategorie="";
			
			nomCategorie=View.getTextNomCategorieAjout().getText();
			nomCategorie=formatterChaine(nomCategorie);
			
			if(nomCategorie.equals("")) {
				View.getTextMessageGestionFour().setText("Veuillez entrer un nom de catégorie avant de valider la saisie.");
			}
			else {
				
				// ajouter une categorie à la bdd
				
				uneCategorie=new CategorieModel();
				uneCategorie.setNomCategorie(nomCategorie);
				
				categorieDao.ajouterCategorie(uneCategorie);
				
				// ajouter une categorie à la combo box
				
				View.getComboCategorie().addItem(nomCategorie);
				
				// message de confirmation
				View.getTextMessageGestionFour().setText("La catégorie a bien été ajoutée.");
				
			}
		}
		
		/**********************************************/
		
		public void ajouterMedicament() {
			// cette fonction sert uniquement à ajouter un médicament à la combobox d'achat
			
			String nomMedicament="";
			
			nomMedicament=View.getTextNomMedicamentAjout().getText();
			nomMedicament=formatterChaine(nomMedicament);
			
			if(nomMedicament.equals("")) {
				View.getTextMessageGestionFour().setText("Veuillez saisir un nom de médicament.");
			}
			else {
				View.getComboBoxNomAchatMed().addItem(nomMedicament);
			}
		}
		
}
