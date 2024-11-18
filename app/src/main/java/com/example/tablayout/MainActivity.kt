package com.example.tablayout

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.Layout
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toolbar
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.registerForActivityResult
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.viewpager.widget.ViewPager
import com.example.tablayout.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabItem
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    private lateinit var ventanaDeslizante : ViewPager
    private lateinit var tabLayout: TabLayout
    private lateinit var txtTexto : TextView

    private lateinit var  barra : Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //obtiene las referencias de los objetos del layout
        ventanaDeslizante = findViewById(R.id.viewpager)
        tabLayout = findViewById(R.id.tabLayout)
        txtTexto = findViewById(R.id.txt_info_usuario)

        //inicia el controlador de deslizamiento de ventanas
        //que recibe como parametro un objeto llamado supportFragmentManager
        //que es el que gestiona los fragmentos en las Actividades
        //se llama así el objeto supportFragmentManager
        //sería el equivalente en Java a this.getSupportManager()
        val controlador = ControladorVentanasDeslizantes(supportFragmentManager)

        //agregamos los fragmentos de código al controlador
        controlador.addFragment(CorreosFragment(), "Correos")
        controlador.addFragment(ContactosFragment(), "Contactos")
        controlador.addFragment(SalesianosFragment(), "Salesianos")


        //Agrega el controlador el deslizador de vistas
        ventanaDeslizante.adapter = controlador
        // vincula el controlador al tabLayout
        tabLayout.setupWithViewPager(ventanaDeslizante)

        tabLayout.getTabAt(0)?.setIcon(R.drawable.email)
        tabLayout.getTabAt(1)?.setIcon(R.drawable.contactos)
        tabLayout.getTabAt(2)?.setIcon(R.drawable.logosalesianosweb)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            R.id.btnInformacionApp ->{
                lanzarInformacionDe()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun lanzarInformacionDe(view: View? = null){
       val i = Intent(this,InformacionLegalActivity::class.java)
       //startActivity(i)
       resultLauncher.launch(i)

    }


    //Aqui vamos a definir una variable que recoge el resultado que viene de otra activity
    //por el momento solo de la pantalla AcercaDe

    var resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        result: ActivityResult ->


        val cadena = result.data?.getStringExtra("Resultado")

        if(result.resultCode == Activity.RESULT_OK){
            //val intent = result.data
            txtTexto.setText(getString(R.string.ha_aceptado,cadena))

        }else{
            txtTexto.setText(getString(R.string.ha_rechazado,cadena))
        }

    }

}