package com.example.tablayout

import android.icu.text.Transliterator.Position
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class ControladorVentanasDeslizantes(supportFragmentManager:FragmentManager):
    FragmentStatePagerAdapter(supportFragmentManager) {

    //declarar una lista con los fragmentos y sus títulos
    private val listaFragmentos = ArrayList<Fragment>()
    private val listaTitulosFragmentos = ArrayList<String>()

    //FUNCIONES QUE DEBE TENER ESTE CONTROLADOR
    //agrega el fragmento y su titulo a la lista de fragmentos y lista de títulos
    fun addFragment(fragment: Fragment,title:String){
        listaFragmentos.add(fragment)
        listaTitulosFragmentos.add(title)
    }

    //retornar un item en una posicion determinada
    override fun getItem(position: Int): Fragment{

        return listaFragmentos[position]
    }

    //retorna el número de fragmentos
    override fun getCount() : Int{
        return listaFragmentos.size
    }

    //retorna el titulo de la pagina
    override fun getPageTitle(position: Int) : String{
        return listaTitulosFragmentos[position]
    }

}