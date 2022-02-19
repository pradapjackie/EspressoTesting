package com.example.espressotesting

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.erikriosetiawan.mylistviewkotlin.Hero
import com.erikriosetiawan.mylistviewkotlin.HeroAdapter
import com.example.espressotesting.screens.Textbox

class Dashboard : AppCompatActivity() {



    private lateinit var adapter: HeroAdapter
    private lateinit var dataName: Array<String>
    private lateinit var dataDescription: Array<String>
    private var heroes = arrayListOf<Hero>()

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activitymenu)

        val listView: ListView = findViewById(R.id.lv_list)
        adapter = HeroAdapter(this)

        listView.adapter = adapter

        prepare()
        addItem()

        listView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->

            if (position === 0) {
                val intent = Intent(this, Textbox::class.java)
                startActivity(intent)
            } else if (position === 1) {
                val intent = Intent(this, Textbox::class.java)
                startActivity(intent)
            } else if (position === 2) {
                val intent = Intent(this, Textbox::class.java)
                startActivity(intent)
            }


        }
    }

    private fun prepare() {
        dataName = resources.getStringArray(R.array.data_name)
        dataDescription = resources.getStringArray(R.array.data_description)
     }

    private fun addItem() {
        for (position in dataName.indices) {
            val hero = Hero(
                dataName[position],
                dataDescription[position]
            )
            heroes.add(hero)
        }
        adapter.heroes = heroes
    }
}
