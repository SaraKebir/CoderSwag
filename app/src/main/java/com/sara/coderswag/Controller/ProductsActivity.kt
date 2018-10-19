package com.sara.coderswag.Controller

import android.content.Intent
import android.content.res.Configuration
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import com.sara.coderswag.Adapters.ProductsAdapter
import com.sara.coderswag.R
import com.sara.coderswag.Services.DataService
import com.sara.coderswag.Utilities.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_products.*

class ProductsActivity : AppCompatActivity() {

    lateinit var adapter: ProductsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        val categoryType= intent.getStringExtra(EXTRA_CATEGORY)
        adapter= ProductsAdapter(this,DataService.getProducts(categoryType)){product ->
            val productDetailIntent = Intent(this,ProductDetailActivity::class.java)
            productDetailIntent.putExtra(EXTRA_PRODUCT_TITLE,product.title)
            productDetailIntent.putExtra(EXTRA_PRODUCT_PRICE,product.price)
            productDetailIntent.putExtra(EXTRA_PRODUCT_IMAGE,product.image)
            startActivity(productDetailIntent)
        }
        var spanCount= 2
        val orientation= resources.configuration.orientation
        if (orientation==Configuration.ORIENTATION_LANDSCAPE){
            spanCount=3
        }
        val screenSize =resources.configuration.screenWidthDp
        if (screenSize> 720){
            spanCount= 3
        }
        productsListView.adapter=adapter
        val layoutManager=GridLayoutManager(this,spanCount)
        productsListView.layoutManager=layoutManager
        
    }
}
