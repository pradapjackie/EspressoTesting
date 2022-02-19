package com.erikriosetiawan.mylistviewkotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.espressotesting.R

class HeroAdapter internal constructor(private val context: Context) : BaseAdapter() {
    internal var heroes = arrayListOf<Hero>()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var itemView = convertView
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.item_hero, parent, false)
        }

        val viewHolder = ViewHolder(itemView as View)

        val hero = getItem(position) as Hero
        viewHolder.bind(hero)
        return itemView
    }

    override fun getItem(position: Int): Any = heroes[position]


    override fun getItemId(position: Int): Long = position.toLong()


    override fun getCount(): Int = heroes.size

    private inner class ViewHolder internal constructor(view: View) {
        private val tvName: TextView = view.findViewById(R.id.tv_name)
        private val tvColumnsDescription: TextView = view.findViewById(R.id.tv_description)

        fun bind(hero: Hero) {
            tvName.text = hero.name
            tvColumnsDescription.text = hero.description
         }
    }
}