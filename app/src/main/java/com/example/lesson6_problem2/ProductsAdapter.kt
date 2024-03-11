package com.example.lesson6_problem2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.lesson6_problem2.databinding.ProductViewBinding


class ProductsAdapter(private val dataSet: List<Product>,val  onAdd: (index:Int) -> Unit, val onTap: (index:Int)->Unit) :
    RecyclerView.Adapter<ProductsAdapter.ViewHolder>() {


    class ViewHolder(val binding: ProductViewBinding) : RecyclerView.ViewHolder(binding.root) {

        fun setUp(product : Product, onAdd: ()->Unit){
           binding.productImage.setImageResource(product.productImage)
           binding.productLogo.setImageResource(product.productLogo)
            binding.productName.text = product.productName
            binding.productDescription.text = product.productDescription
            binding.price.text = "$ ${product.price}"
            binding.addButton.setOnClickListener { onAdd() }


        }
    }


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {

        val productViewBinding  = ProductViewBinding.inflate(LayoutInflater.from(viewGroup.context))

        return ViewHolder(productViewBinding)
    }
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        viewHolder.setUp(dataSet[position]){
            onAdd(position)

        }
        viewHolder.binding.root.setOnClickListener {
            onTap(position)
        }

    }

    override fun getItemCount() = dataSet.size

}
