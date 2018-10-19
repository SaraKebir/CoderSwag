package com.sara.coderswag.Controller

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.ArrayAdapter
import android.widget.Toast
import com.sara.coderswag.Adapters.CategoryAdapter
import com.sara.coderswag.Adapters.CategoryRecycleAdapter
import com.sara.coderswag.Model.Category
import com.sara.coderswag.R
import com.sara.coderswag.Services.DataService
import com.sara.coderswag.Utilities.EXTRA_CATEGORY
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var adapter: CategoryRecycleAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        adapter= CategoryRecycleAdapter(this, DataService.categories ){category ->
           val productIntent = Intent(this,ProductsActivity::class.java)
            productIntent.putExtra(EXTRA_CATEGORY,category.title)
            startActivity(productIntent)
        }
        categoryListView.adapter=adapter
        val layoutManager=LinearLayoutManager(this)
        categoryListView.layoutManager=layoutManager
        categoryListView.setHasFixedSize(true)

      /*  categoryListView.setOnItemClickListener { parent, view, position, id ->
            val category = DataService.categories[position]
            Toast.makeText(this,"You clicked on the ${category.title} cell",Toast.LENGTH_SHORT).show()
        }*/
    }
}
