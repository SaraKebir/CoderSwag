package com.sara.coderswag.Controller

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.sara.coderswag.Model.Product
import com.sara.coderswag.R
import com.sara.coderswag.Utilities.EXTRA_PRODUCT
import com.sara.coderswag.Utilities.EXTRA_PRODUCT_IMAGE
import com.sara.coderswag.Utilities.EXTRA_PRODUCT_PRICE
import com.sara.coderswag.Utilities.EXTRA_PRODUCT_TITLE
import kotlinx.android.synthetic.main.activity_product_detail.*

class ProductDetailActivity : AppCompatActivity() {

/*
    var productDetail=Product("","","")
    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putParcelable<Product>(EXTRA_PRODUCT,productDetail)
    }*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)
     /* var   productDetail=intent.getParcelableExtra<Product>(EXTRA_PRODUCT)*/
        var   titre=intent.getStringExtra(EXTRA_PRODUCT_TITLE)
    var   prix=intent.getStringExtra(EXTRA_PRODUCT_PRICE)
    var   image=intent.getStringExtra(EXTRA_PRODUCT_IMAGE)
        proName?.text=titre
        proPrice?.text=prix
    val resourceId=this.resources.getIdentifier(image, "drawable",this.packageName)
    proImage?.setImageResource(resourceId)
      /*  proPrice?.text=productDetail.price*/
       /* val resourceId=this.resources.getIdentifier(productDetail.image, "drawable",this.packageName)
        proImage?.setImageResource(resourceId)*/
    }

}
