package td.banque;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.annotation.*;
import td.banque.model.*;
import td.banque.repository.*;
import java.sql.Date;

@SpringBootApplication
public class BanqueApplication {

    public static void main(String[] args) {
        SpringApplication.run(BanqueApplication.class, args);
    }
//    @Bean
//    CommandLineRunner ajouterConditionsGenerales(ConditionsGeneralesRepository conditionsGeneralesRepository)
//    {
//        return args -> {
//            // On vide la table pour ne pas créer de doublons
//            conditionsGeneralesRepository.deleteAll();
//            // On crée une liste de conditions générales que l'on insèrera d'un coup en base
//            ArrayList<ConditionsGenerales> listeCG = new ArrayList<ConditionsGenerales>();
//            // On crée quelques conditions générales
//            listeCG.add(new ConditionsGenerales(
//                    0,
//                    "Mastercard",
//                    15));
//            listeCG.add(new ConditionsGenerales(
//                    3.0f,
//                    "Livret épargne",
//                    0));
//            listeCG.add(new ConditionsGenerales(
//                    1.0f,
//                    "Compte rémunéré",
//                    0));
//            listeCG.add(new ConditionsGenerales(
//                    3.0f,
//                    "Prêt consommation",
//                    0));
//
//            // On insère la liste dans la table
//            conditionsGeneralesRepository.saveAll(listeCG);
//
//            // Testons maintenant les requetes par defaut
//            listeCG = new ArrayList<ConditionsGenerales>();
//            long nbConditionsGenerales;
//            // Nombre de conditions générales
//            nbConditionsGenerales=conditionsGeneralesRepository.count();
//            System.out.println("\n***************** test count");
//            System.out.println("\nil y a "+nbConditionsGenerales+" conditions generales dans la base");
//
//            // Rechercher Condition générale par id
//            long id=100;
//            Optional<ConditionsGenerales> cg=conditionsGeneralesRepository.findById(id);
//            System.out.println("\n***************** test findById");
//            if (cg.isPresent()) System.out.println("\nconditions générales avec l'id : "+id+cg);
//            else System.out.println("Pas de condition generale avec la clé : "+id);
//
//            // On récupère et on affiche les conditions générales en base
//            System.out.println("\n***************** Toutes les conditions générales non triees");
//            System.out.println(conditionsGeneralesRepository.findAll());
//
//            // On récupère les conditions générales en base triées par ordre alphabétique du typeProduit
//            System.out.println("\n***************** Toutes les conditions générales dans l'ordre alphabetique du typeProduit");
//            System.out.println(conditionsGeneralesRepository.findAll(Sort.by(Sort.Direction.ASC, "typeProduit")));
//
//            // Pagination
//            int numeroPage=3; // numéro de la page chargée. Attention, le numéro commence à 0. Ici, on récupère la quatrième page
//            int taillePage=1; // Nombre de conditions générales par page.
//            // L'instruction suivante récupère la 4ième page de données, chaque page contenant une seule donnée. Les données sont ici aussi triées par ordre alphabétique du type
//            Page<ConditionsGenerales> page= conditionsGeneralesRepository.findAll(PageRequest.of(3, 1,Sort.by(Sort.Direction.ASC, "typeProduit")));
//            System.out.println("\n***************** Test pagination");
//            System.out.println(page+"\n Contenu de la page"+page.getContent());
//        };
//    }
//
//    @Bean
//    CommandLineRunner testerRequetesAutomatiques(ConditionsGeneralesRepository conditionsGeneralesRepository) {
//        return args -> {
//            ArrayList<ConditionsGenerales> listeCG = new ArrayList<ConditionsGenerales>();
//            System.out.println("*******************************\nRechercher les conditions générales dont le type est Compte chèque");
//            listeCG=conditionsGeneralesRepository.findByTypeProduit("Compte chèque");
//            System.out.println(listeCG);
//            System.out.println("*******************************\nPremiere solution : Rechercher les conditions générales dont le type contient compte");
//            listeCG=conditionsGeneralesRepository.findByTypeProduitContains("compte");
//            System.out.println(listeCG);
//            System.out.println("*******************************\nDeuxieme solution : Rechercher les conditions générales dont le type contient compte");
//            listeCG=conditionsGeneralesRepository.findByTypeProduitLike("%compte%");
//            System.out.println(listeCG);
//            System.out.println("*******************************\nRechercher les 3 dernieres conditions générales saisies en base");
//            listeCG=conditionsGeneralesRepository.findFirst3ByOrderByIdDesc();
//            System.out.println(listeCG);
//            System.out.println("*******************************\nListe des produits dont la rentabilité est >=3 pour la banque");
//            listeCG=conditionsGeneralesRepository.findByTauxInteretAgiosGreaterThanEqualOrderByTauxInteretAgiosAsc(3);
//            System.out.println(listeCG);
//        };
//    }
//
//    @Bean
//    CommandLineRunner ajouterPersonnes(
//            PersonneRepository<PersonneMorale> personneMoraleRepository,
//            PersonneRepository<PersonnePhysique> personnePhysiqueRepository)
//    {
//        return args -> {
//            // Suppression des données créées par ce test lors d'une exécution précédente pour éviter les doublons
//            personneMoraleRepository.deleteAll();
//            personnePhysiqueRepository.deleteAll();
//
//             //Creation de type Personne moral
//            TypePersonneMorale type1 =  new TypePersonneMorale("Etat");
//            TypePersonneMorale type2 =  new TypePersonneMorale("Collectivite");
////
//            // Création de trois personnes morales
//            PersonneMorale pm1=new PersonneMorale("102bis rue du Vesuve","SIRET1", "Pizza Tonio", type1);
//            PersonneMorale pm2=new PersonneMorale("45 Boulevard du fleuve","SIRET2", "Meubles cosy", type1);
//            PersonneMorale pm3=new PersonneMorale("14 allee des platanes","SIRET3", "Espaces tres verts", type2);

//            // Enregistrement en base
//            // Enregistrement en base
//            personneMoraleRepository.save(pm1);
//            personneMoraleRepository.save(pm2);
//            personneMoraleRepository.save(pm3);
//
//            // Affichage du résultat
//            System.out.println(personneMoraleRepository.findAll());
//
//            // Ajout de personnes physiques
//            PersonnePhysique pp1=new PersonnePhysique("19 rue des fleurs, 80000 Amiens", "Dupont","Jean");
//            personnePhysiqueRepository.save(pp1);
//            PersonnePhysique pp2=new PersonnePhysique("143 boulevard des landes, 64200 Anglet", "Eche","Piou");
//            personnePhysiqueRepository.save(pp2);
//            PersonnePhysique pp3=new PersonnePhysique("56 avenue de Paris, 60000 Beauvais", "Tristan","Jacques");
//            personnePhysiqueRepository.save(pp3);
//            System.out.println(personnePhysiqueRepository.findAll());
//        };
//    }
//
//    @Bean
//    CommandLineRunner seedData(
//            ConditionsGeneralesRepository conditionsGeneralesRepository,
//            PersonneRepository personneMoraleRepository,
//            PersonneRepository personnePhysiqueRepository,
//            ProduitBancaireRepository produitBancaireRepository)
//    {
//        return args -> {
//            List<ConditionsGenerales> conditionsGeneraless;
//            List<ProduitBancaire> produitBancaires;
//            ConditionsGenerales cg1=new ConditionsGenerales((float)0.2,"cg1",0);
//            conditionsGeneralesRepository.save(cg1);
//            ConditionsGenerales cg2=new ConditionsGenerales(3,"cg2",0);
//            conditionsGeneralesRepository.save(cg2);
//            ConditionsGenerales cg3=new ConditionsGenerales(0,"cg3",15);
//            conditionsGeneralesRepository.save(cg3);
//
//            cg3= conditionsGeneralesRepository.findById(cg3.getId()).orElseThrow();
//            ProduitBancaire pb1 = new ProduitBancaire(1,"num1", cg3);
//            produitBancaireRepository.save(pb1);
//            cg2= conditionsGeneralesRepository.findById(cg2.getId()).orElseThrow();
//            ProduitBancaire pb2 = new ProduitBancaire(2,"num2",cg2);
//            produitBancaireRepository.save(pb2);
//            cg3= conditionsGeneralesRepository.findById(cg3.getId()).orElseThrow();
//            ProduitBancaire pb3 = new ProduitBancaire(3,"num3",cg3);
//            produitBancaireRepository.save(pb3);
//
//            conditionsGeneraless=conditionsGeneralesRepository.findAll();
//            produitBancaires=produitBancaireRepository.findAll();
//
//            pb1= (ProduitBancaire) produitBancaireRepository.findById(pb1.getId()).orElseThrow();
//            produitBancaireRepository.deleteById(pb1.getId());
//            if (conditionsGeneralesRepository.existsById(cg3.getId()))
//            {
//                System.out.println("cg3 est toujours dans la base");
//            }
//            else
//            {
//                System.out.println("cg3 n''existe plus");
//            }
//            if (produitBancaireRepository.existsById(pb1.getId())) {
//                System.out.println("pb1 est toujours dans la base");
//            }
//            else {
//                System.out.println("pb1 n''existe plus");
//            }
//            if (produitBancaireRepository.existsById(pb3.getId())) {
//                System.out.println("pb3 est toujours ans la base");
//            }
//            else {
//                System.out.println("pb3 n''existe plus");
//            }
//        };
//    }

    /*@Bean
    CommandLineRunner seedData(
            ConditionsGeneralesRepository conditionsGeneralesRepository,
            PersonneRepository personneMoraleRepository,
            PersonneRepository personnePhysiqueRepository,
            ProduitBancaireRepository produitBancaireRepository,
            TypePersonneMoraleRepository typePersonneMoraleRepository,
            ClientBancaireRepository clientBancaireRepository
    ) {
        return args -> {
            // Création de Conditions Générales
            ConditionsGenerales cg1 = new ConditionsGenerales((float) 0.2, "cg1", 0);
            conditionsGeneralesRepository.save(cg1);

            ConditionsGenerales cg2 = new ConditionsGenerales(3, "cg2", 0);
            conditionsGeneralesRepository.save(cg2);

            ConditionsGenerales cg3 = new ConditionsGenerales(0, "cg3", 15);
            conditionsGeneralesRepository.save(cg3);

            // Création de produits bancaires
            cg3 = conditionsGeneralesRepository.findById(cg3.getId()).orElseThrow();
            ProduitBancaire pb1 = new ProduitBancaire(1, "num1", cg3);
            produitBancaireRepository.save(pb1);

            cg2 = conditionsGeneralesRepository.findById(cg2.getId()).orElseThrow();
            ProduitBancaire pb2 = new ProduitBancaire(2, "num2", cg2);
            produitBancaireRepository.save(pb2);

            cg3 = conditionsGeneralesRepository.findById(cg3.getId()).orElseThrow();
            ProduitBancaire pb3 = new ProduitBancaire(3, "num3", cg3);
            produitBancaireRepository.save(pb3);

            // Création de personnes physiques
            PersonnePhysique pp1 = new PersonnePhysique("adresse_pp1", "nom_pp1", "prenom_pp1");
            personnePhysiqueRepository.save(pp1);

            PersonnePhysique pp2 = new PersonnePhysique("adresse_pp2", "nom_pp2", "prenom_pp2");
            personnePhysiqueRepository.save(pp2);

            PersonnePhysique pp3 = new PersonnePhysique("adresse_pp3", "nom_pp3", "prenom_pp3");
            personnePhysiqueRepository.save(pp3);

            // Création de types de personnes morales
            TypePersonneMorale tpm1 = new TypePersonneMorale("SA");
            typePersonneMoraleRepository.save(tpm1);

            TypePersonneMorale tpm2 = new TypePersonneMorale("SARL");
            typePersonneMoraleRepository.save(tpm2);

            TypePersonneMorale tpm3 = new TypePersonneMorale("Auto Entrepreneur");
            typePersonneMoraleRepository.save(tpm3);

            // Création de personnes morales
            PersonneMorale pm1 = new PersonneMorale("pm1", "SiRET pm1", "raisonsoc pm1", tpm1);
            personneMoraleRepository.save(pm1);

            PersonneMorale pm2 = new PersonneMorale("pm2", "SiRET pm2", "raisonsoc pm2", tpm2);
            personneMoraleRepository.save(pm2);

            PersonneMorale pm3 = new PersonneMorale("pm3", "SiRET pm3", "raisonsoc pm3", tpm1);
            personneMoraleRepository.save(pm3);

            // Création de clients bancaires
            ClientBancaire cb1 = new ClientBancaire();
            clientBancaireRepository.save(cb1);

            ClientBancaire cb2 = new ClientBancaire();
            clientBancaireRepository.save(cb2);

            ClientBancaire cb3 = new ClientBancaire();
            clientBancaireRepository.save(cb3);

            // Ajout des participants aux clients bancaires
            pm1 = (PersonneMorale) personneMoraleRepository.findById(pm1.getId()).orElseThrow();
            cb1.addPersonne(pm1);
            clientBancaireRepository.save(cb1);

            cb1 = clientBancaireRepository.findById(cb1.getId()).orElseThrow();
            pp2 = (PersonnePhysique) personnePhysiqueRepository.findById(pp2.getId()).orElseThrow();
            cb1.addPersonne(pp2);
            clientBancaireRepository.save(cb1);

            pp1 = (PersonnePhysique) personnePhysiqueRepository.findById(pp1.getId()).orElseThrow();
            cb2 = clientBancaireRepository.findById(cb2.getId()).orElseThrow();
            pp1.addClientBancaire(cb2);
            personnePhysiqueRepository.save(pp1);

            cb3 = clientBancaireRepository.findById(cb3.getId()).orElseThrow();
            pp3 = (PersonnePhysique) personnePhysiqueRepository.findById(pp3.getId()).orElseThrow();
            cb3.addPersonne(pp3);
            clientBancaireRepository.save(cb3);

            // Affichage des personnes physiques et morales
            System.out.println("***************************************************" +
                    "\nLes personnes physiques" +
                    "***********************************************************");
            System.out.println(personnePhysiqueRepository.findAll());

            System.out.println("***************************************************" +
                    "\nLes personnes morales" +
                    "***********************************************************");
            System.out.println(personneMoraleRepository.findAll());
        };
    }*/

    /*@Bean
    CommandLineRunner testClientBancaireProduitBancaire(
            ClientBancaireRepository clientBancaireRepository,
            ProduitBancaireRepository produitBancaireRepository,
            ConditionsGeneralesRepository conditionsGeneralesRepository
    ) {
        return args -> {
            // Création de Conditions Générales
            ConditionsGenerales cg1 = new ConditionsGenerales((float) 0.5, "CG1", 10);
            conditionsGeneralesRepository.save(cg1);

            ConditionsGenerales cg2 = new ConditionsGenerales((float) 1.0, "CG2", 20);
            conditionsGeneralesRepository.save(cg2);

            // Création de Clients Bancaires
            ClientBancaire cb1 = new ClientBancaire();
            ClientBancaire cb2 = new ClientBancaire();
            clientBancaireRepository.save(cb1);
            clientBancaireRepository.save(cb2);

            // Création de Produits Bancaires associés au Client Bancaire 1
            ProduitBancaire pb1 = new ProduitBancaire(1000, "123456789", cg1);
            ProduitBancaire pb2 = new ProduitBancaire(2000, "987654321", cg1);
            cb1.addProduitBancaire(pb1);
            cb1.addProduitBancaire(pb2);

            // Sauvegarder les produits bancaires (ils sont automatiquement associés au client)
            produitBancaireRepository.save(pb1);
            produitBancaireRepository.save(pb2);

            // Création d'un produit bancaire associé au Client Bancaire 2
            ProduitBancaire pb3 = new ProduitBancaire(5000, "564738291", cg2);
            cb2.addProduitBancaire(pb3);

            produitBancaireRepository.save(pb3);

            // Sauvegarder les clients bancaires (les produits associés sont également sauvegardés)
            clientBancaireRepository.save(cb1);
            clientBancaireRepository.save(cb2);

            // Affichage des résultats pour vérifier la relation
            System.out.println("Client Bancaire 1 - Produits Bancaires:");
            cb1.getProduitsBancaires().forEach(System.out::println);

            System.out.println("Client Bancaire 2 - Produits Bancaires:");
            cb2.getProduitsBancaires().forEach(System.out::println);
        };
    }*/

    @Bean
    CommandLineRunner testProduitBancaireOperation(
            ProduitBancaireRepository produitBancaireRepository,
            OperationRepository operationRepository,
            ConditionsGeneralesRepository conditionsGeneralesRepository
    ) {
        return args -> {
            // Création de Conditions Générales
            ConditionsGenerales cg1 = new ConditionsGenerales((float) 0.5, "CG1", 10);
            conditionsGeneralesRepository.save(cg1);

            // Création d'un Produit Bancaire
            ProduitBancaire pb1 = new ProduitBancaire(1000, "123456789", cg1);
            produitBancaireRepository.save(pb1);

            // Création d'Opérations avec java.sql.Date
            Date dateOp1 = new Date(System.currentTimeMillis());  // Utilisation correcte de java.sql.Date

            // Création des opérations
            Operation op1 = new Operation(dateOp1, 500, "Retrait", "ATM", pb1);
            Operation op2 = new Operation(dateOp1, 200, "Dépôt", "Agence", pb1);

            // Ajouter les opérations au produit bancaire
            pb1.addOperation(op1);
            pb1.addOperation(op2);

            // Sauvegarder les opérations
            operationRepository.save(op1);
            operationRepository.save(op2);

            // Affichage des opérations liées au produit bancaire
            System.out.println("Opérations liées au Produit Bancaire:");
            pb1.getOperations().forEach(System.out::println);
        };
    }
}

