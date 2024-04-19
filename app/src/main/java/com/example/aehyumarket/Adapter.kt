package com.example.aehyumarket

import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.aehyumarket.databinding.RvItemsBinding
import java.text.DecimalFormat

class Adapter(val dProds: MutableList<DummyProduct>) : RecyclerView.Adapter<Adapter.Holder>() {

    // 이벤트 처리
    interface ItemClick {
        fun onClick(view : View, position : Int)
    }

    var itemClick : ItemClick? = null

    val decimal = DecimalFormat("#,##0")



    // viewHolder 생성
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = RvItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//        binding.editTextText.setOnClickListener {
//            itemClick?.onClick(it, binding.)
//
//        }

        return Holder(binding)
    }

    // ViewHolder를 바인드해서
    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.itemView.setOnClickListener {  //클릭이벤트추가부분
            itemClick?.onClick(it, position)
            // onCreateViewHolder로 옮겨주는게 좋다.
        }
//        holder.bind1.setImageResource(dProds[position].image)
//        holder.name.text = dProds[position].name
//        holder.bind1(position)
        holder.bind1(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemCount(): Int {
        return dProds.size
    }

    inner class Holder(val binding: RvItemsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind1(position: Int) {

            val price = decimal.format(dProds[position].price) + "원"

            binding.iconItem.clipToOutline = true
            binding.iconItem.setImageResource(dProds.get(position).image)
            binding.nameText.setText(dProds.get(position).name)
            binding.descriptionText.setText(dProds.get(position).description)
            binding.priceText.text = price
            binding.chatIntText.setText(dProds.get(position).chat.toString())
            binding.heartIntText.setText(dProds.get(position).like.toString())


        }
    }

}