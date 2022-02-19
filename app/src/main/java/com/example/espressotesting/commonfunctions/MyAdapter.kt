package com.example.espressotesting.commonfunctions

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.espressotesting.R

class MyAdapter(private val context: Activity, private val arrayList:ArrayList<Data>) :
    ArrayAdapter<Data>(context, R.layout.list_item,arrayList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflator: LayoutInflater = LayoutInflater.from(context)
        val view:View = inflator.inflate(R.layout.list_item,null)

        val menuName : TextView = view.findViewById(R.id.list_name)
        val menuDescription : TextView = view.findViewById(R.id.list_sub_name)

        menuName.text =arrayList[position].menuItems
        menuDescription.text =arrayList[position].menuItemDescription
//        return super.getView(position, convertView, parent)

        return view
    }

}