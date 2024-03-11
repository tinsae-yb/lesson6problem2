package com.example.lesson6_problem2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lesson6_problem2.databinding.ActivityProductDetailBinding

class ProductDetail : AppCompatActivity() {

    lateinit var binding: ActivityProductDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityProductDetailBinding.inflate(layoutInflater)

       val index =  intent.getIntExtra("index", -1)
        if(index!=-1){
            val product = Data.products[index];
            binding.name.text = product.productName
            binding.description.text = product.productDescription
            binding.image.setImageResource(product.productImage)
            binding.detailPrice.text = "$ ${product.price}"

            binding.homeButton.setOnClickListener {
                finish()
            }


        }
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}