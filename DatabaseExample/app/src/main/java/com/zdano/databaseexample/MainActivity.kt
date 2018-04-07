package com.zdano.databaseexample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun newProduct(v: View) {
        val dbHandler = MyDBHandler(this, null, null, 1)

        val quantity = Integer.parseInt(productQuantity.text.toString())

        val product = Product(productName.text.toString(), quantity)

        dbHandler.addProduct(product)
        productName.setText("")
        productQuantity.setText("")
    }

    fun lookupProduct(v: View) {
        val dbHandler = MyDBHandler(this, null, null, 1)

        val product = dbHandler.findProduct(productName.text.toString())

        if(product != null) {
            productID.text = product.id.toString()

            productQuantity.setText(product.quantity.toString())
        } else {
            productID.text = "Nie znaleziono"
        }
    }

    fun removeProduct(v: View) {
        val dbHandler = MyDBHandler(this, null, null, 1)

        val result = dbHandler.deleteProduct(productName.text.toString())

        if(result) {
            productID.text = "Product usuniety"
            productName.setText("")
            productQuantity.setText("")
        } else {
            productID.text = "Nie znaleziono"
        }
    }
}
