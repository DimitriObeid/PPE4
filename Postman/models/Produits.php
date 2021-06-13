<?php
class Produits {
    // Connexion
    private $connexion;
    private $table = "identifiant";

    // object properties
    public $id;
    public $pseudo;
    public $pass;

    //public $created_at;

    /**
     * Constructeur avec $db pour la connexion à la base de données
     *
     * @param $db
     */
    public function __construct($db){
        $this->connexion = $db;
    }

    /**
     * Créer un produit
     *
     * @return void
     */
    public function creer(){

        // Ecriture de la requête SQL en y insérant le pseudo de la table
        $sql = "INSERT INTO " . $this->table . " SET pseudo=:pseudo, pass=:pass ";

        // Préparation de la requête
        $query = $this->connexion->prepare($sql);

        // Protection contre les injections
        $this->pseudo=htmlspecialchars(strip_tags($this->pseudo));
        $this->pass=htmlspecialchars(strip_tags($this->pass));
        //$this->created_at=htmlspecialchars(strip_tags($this->created_at));

        // Ajout des données protégées
        $query->bindParam(":pseudo", $this->pseudo);
        $query->bindParam(":pass", $this->pass);
        //$query->bindParam(":created_at", $this->created_at);

        // Exécution de la requête
        if($query->execute()){
            return true;
        }
        return false;
    }

    /**
     * Lecture des produits
     *
     * @return void
     */
    public function lire(){
        // On écrit la requête
        $sql = "SELECT id, pseudo, pass FROM " . $this->table;
        var_dump($sql);
        
        // On prépare la requête
        $query = $this->connexion->prepare($sql);
        if($query === false){
          echo "errors".__FILE__. " ".__LINE__;
        }
        // On exécute la requête
        $query->execute();

        // On retourne le résultat
        return $query;
    }

    /**
     * Lire un produit
     *
     * @return void
     */
    public function lireUn(){
        // On écrit la requête
        $sql = "SELECT id, pseudo, pass FROM " . $this->table. " WHERE id = ? LIMIT 0,1";
        // On prépare la requête

        $query = $this->connexion->prepare( $sql );

        // On attache l'id
        $query->bindParam(1, $this->id);

        // On exécute la requête
        $query->execute();

        // on récupère la ligne
        $row = $query->fetch(PDO::FETCH_ASSOC);

        if($row === false){
          $this->pseudo=null;
          $this->pass = null;
          return;
        }
        // On hydrate l'objet
        $this->pseudo = $row['pseudo'];
        $this->pass = $row['pass'];
    }

    /**
     * Mettre à jour un produit
     *
     * @return void
     */
    public function modifier(){
        // On écrit la requête
        $sql = "UPDATE " . $this->table . " SET pseudo = :pseudo, pass = :pass WHERE id = :id";

        // On prépare la requête
        $query = $this->connexion->prepare($sql);

        // On sécurise les données
        $this->pseudo=htmlspecialchars(strip_tags($this->pseudo));
        $this->pass=htmlspecialchars(strip_tags($this->pass));
        $this->id=htmlspecialchars(strip_tags($this->id));

        // On attache les variables
        $query->bindParam(':pseudo', $this->pseudo);
        $query->bindParam(':pass', $this->pass);
        $query->bindParam(':id', $this->id);

        // On exécute
        if($query->execute()){
            return true;
        }

        return false;
    }

    /**
     * Supprimer un produit
     *
     * @return void
     */
    public function supprimer(){
        // On écrit la requête
        $sql = "DELETE FROM " . $this->table . " WHERE id = ?";

        // On prépare la requête
        $query = $this->connexion->prepare( $sql );

        // On sécurise les données
        $this->id=htmlspecialchars(strip_tags($this->id));

        // On attache l'id
        $query->bindParam(1, $this->id);

        // On exécute la requête
        if($query->execute()){
            return true;
        }

        return false;
    }
}
