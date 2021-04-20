package com.example.ppe4

import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.android.material.textfield.TextInputEditText
import org.w3c.dom.Text
import java.lang.reflect.Array

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow), drawerLayout)
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

/*
    private fun AddCompTarifTotal() {

    }

    private fun AddEntrainTarifTotal() {

    }

    private fun AddLoisirTarifTotal() {

    }
*/

    private fun adhesionTable() {
        // Prix
        val prixComp = 10
        val prixEntrain = 8
        val prixLoisir = 5

        // Prix total
        var prixTotalComp = 0
        var prixTotalEntrain = 0
        var prixTotalLoisir = 0

        // Colonne de vérification d'abonnement (avant-dernière colonne). Si abonné, alors
        val aboBaseballCol = findViewById<TextView>(R.id.AdhesionBaseball)
        val aboBasketballCol = findViewById<TextView>(R.id.AdhesionBasketball)
        val aboFootballCol = findViewById<TextView>(R.id.AdhesionFootball)

        val textViewGetAboBaseballCol: TextView = findViewById(R.id.AdhesionBaseball)
        val textViewGetAboBasketballCol: TextView = findViewById(R.id.AdhesionBasketball)
        val textViewGetAboFootballCol: TextView = findViewById(R.id.AdhesionFootball)

        val strTextViewGetAboBaseballCol: String = textViewGetAboBaseballCol.text.toString()
        val strTextViewGetAboBasketballCol: String = textViewGetAboBasketballCol.text.toString()
        val strTextViewGetAboFootballCol: String = textViewGetAboFootballCol.text.toString()


        // Colonne de vérification de type d'abonnement (avant-dernière colonne). Si abonné
        val typeAboBasketball = findViewById<TextView>(R.id.typeAdhesionBaseball)
        val typeAboBaseball = findViewById<TextView>(R.id.typeAdhesionBasketball)
        val typeAboFootball = findViewById<TextView>(R.id.typeAdhesionFootball)

        val textViewGetTypeAboBaseballCol: TextView = findViewById(R.id.typeAdhesionBaseball)
        val textViewGetTypeAboBasketballCol: TextView = findViewById(R.id.typeAdhesionBasketball)
        val textViewGetTypeAboFootballCol: TextView = findViewById(R.id.typeAdhesionFootball)

        val strTextViewGetTypeAboBaseballCol: String = textViewGetTypeAboBaseballCol.text.toString()
        val strTextViewGetTypeAboBasketballCol: String = textViewGetTypeAboBasketballCol.text.toString()
        val strTextViewGetTypeAboFootballCol: String = textViewGetTypeAboFootballCol.text.toString()


        // Colonne prix total compétition
        var editTextPrixTotalComp = findViewById<EditText>(R.id.editTextTarifCatComp) as EditText

        // Colonne prix total entraînement
        var editTextPrixTotalEntrain = findViewById<EditText>(R.id.editTextTarifCatEntrain) as EditText

        // Colonne prix total loisir
        var editTextPrixTotalLoisir = findViewById<EditText>(R.id.editTextTarifCatLoisir) as EditText

        // Colonne prix total
        var editTextPrixTotal = findViewById<EditText>(R.id.editTextPrixTotal) as EditText

        // Assignation d'une valeur à la colonne d'adhérence au sport
        aboBaseballCol.setText("non").toString()
        aboBasketballCol.setText("oui").toString()
        aboFootballCol.setText("oui").toString()

        // Assignation d'une valeur à la colonne d'adhérence à une catégorie
        typeAboBaseball.setText("Loisir").toString()
        typeAboBasketball.setText("Entrain").toString()
        typeAboFootball.setText("Compétition").toString()


        // Additioner le tarif pour chaque catégorie, puis ajouter la somme au tarif total
        if (strTextViewGetTypeAboBaseballCol == "Compétition")
            prixTotalComp += prixComp

        else if (strTextViewGetTypeAboBaseballCol == "Entrain")
            prixTotalEntrain += prixEntrain

        else if (strTextViewGetTypeAboBaseballCol == "Loisir")
            prixTotalLoisir += prixLoisir

        if (strTextViewGetTypeAboBasketballCol == "Compétition")
            prixTotalComp += prixComp

        else if (strTextViewGetTypeAboBasketballCol == "Entrain")
            prixTotalEntrain += prixEntrain

        else if (strTextViewGetTypeAboBasketballCol == "Loisir")
            prixTotalLoisir += prixLoisir

        if (strTextViewGetTypeAboFootballCol == "Compétition")
            prixTotalComp += prixComp

        else if (strTextViewGetTypeAboFootballCol == "Entrain")
            prixTotalEntrain += prixEntrain

        else if (strTextViewGetTypeAboFootballCol == "Loisir")
            prixTotalLoisir += prixLoisir

        var prixTotal = prixTotalComp + prixTotalEntrain + prixTotalLoisir

        var strPrixTotalComp = prixTotalComp.toString()
        var strPrixTotalEntrain = prixTotalEntrain.toString()
        var strPrixTotalLoisir = prixTotalLoisir.toString()

        Toast.makeText(this, r, Toast.LENGTH_SHORT).show()
        Toast.makeText(this, strPrixTotalEntrain, Toast.LENGTH_SHORT).show()
        Toast.makeText(this, strPrixTotalLoisir, Toast.LENGTH_SHORT).show()
    }

  //  private fun afficherMenuConnexion() {
    //     connexion_menu.vibility=View.VISIBLE
  //  }
}