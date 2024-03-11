package com.example.lesson6_problem2

import android.content.Intent
import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lesson6_problem2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    val cart = mutableSetOf<Int>()

    val onAdd: (index: Int) -> Unit = { index ->

        cart.add(index);
    }

    val onTap: (index: Int) -> Unit = { index ->

        val  intent = Intent(this, ProductDetail::class.java)
        intent.putExtra("index", index)
        startActivity(intent)
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        binding.viewCartButton.setOnClickListener{
            val builder  = StringBuilder()

            cart.forEach {
               builder.append("${ Data.products[it].productName} ${ Data.products[it].productDescription}")
                builder.append("/n")

            }
            Toast.makeText(this, builder.toString(), Toast.LENGTH_LONG).show()
        }



        val productsAdapter = ProductsAdapter(Data.products, onAdd, onTap )

        binding.recyclerView.adapter = productsAdapter
        binding.recyclerView.addItemDecoration(object : RecyclerView.ItemDecoration(){
            override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
                super.getItemOffsets(outRect, view, parent, state)
                outRect.set(0, 0, 0, 120)
            }
        })
        binding.recyclerView.layoutManager = LinearLayoutManager(this)


        setContentView(binding.root)
    }
}