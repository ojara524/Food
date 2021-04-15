package com.example.listviews

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import com.example.facebook.R
import java.nio.file.Files.list
import java.util.Collections.list

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val t = ArrayList<Garage>()
        t.add(Garage(R.drawable.chicken,"Chicken","10000/="))
        t.add(Garage(R.drawable.fish,"Fish","10000/="))
        t.add(Garage(R.drawable.meat,"Meat","10000/="))

        t.add(Garage(R.drawable.greens,"Greens","5000/="))
        t.add(Garage(R.drawable.milktea,"Milk","4000/="))
        t.add(Garage(R.drawable.pizza,"Pizza","3000/="))
        t.add(Garage(R.drawable.snacks,"snacks","4000/="))
        t.add(Garage(R.drawable.rice,"Rice & chicken","10000/="))

        val r = RepareAdapter(this,t)
        val p = findViewById<ListView>(R.id.list)

        p.adapter=r
    }

    class RepareAdapter : BaseAdapter{

        var X:Context
        var Y: ArrayList<Garage>
        constructor(a:Context,b:ArrayList<Garage>):super(){
            this.X = a
            this.Y = b
        }




        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val oja = X.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val p = oja.inflate(R.layout.activity_main,null)
            //val p= oja.inflate(R.layout.activity_main.null)
            val image1 =  p.findViewById<ImageView>(R.id.image)
            val text =     p.findViewById<TextView>(R.id.text1)
            val text1 =     p.findViewById<TextView>(R.id.textView2)

            text.text = Y[position].name
            text1.text = Y[position].price
            image1.setImageResource(Y[position].image!!)

            return p
        }

        override fun getItem(position: Int): Any {
            return Y[position]!!
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()

        }

        override fun getCount(): Int {
            return Y.size
        }


    }
}