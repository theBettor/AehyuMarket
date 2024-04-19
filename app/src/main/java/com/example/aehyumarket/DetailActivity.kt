package com.example.aehyumarket

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.v4.os.IResultReceiver._Parcel
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.aehyumarket.databinding.ActivityDetailBinding
import java.text.DecimalFormat

class DetailActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDetailBinding

    val decimal = DecimalFormat("#,##0")

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)


        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backbtnImage.setOnClickListener {
            finish()
        }

        val items = intent.getParcelableExtra("A", DummyProduct::class.java)
        items?.let{ bindingItems(it) }

//        val bundle: Bundle? = intent.extras
////        val imageGet = bundle?.
//        val sellerGet = bundle?.getString("seller")
//        val addressGet = bundle?.getString("address")
//        val nameGet = bundle?.getString("name")
//        val descriptionGet = bundle?.getString("description")
//        val priceGet = bundle?.getString("price")



        //  name = intent.getStringExtra("name")
//        image = intent.getStringExtra("image")
//        seller =





    }
    fun bindingItems(items: DummyProduct) {

        val price = decimal.format(items.price) + "원"

        //TextView에 데이터 설정
        binding.detailImageView.setImageResource(items.image)
        binding.userView.text = items.seller
        binding.addressView.text = items.address
        binding.nameView.text = items.name
        binding.descriptionView.text = items.description
        binding.pricetextView.text = price
    }
}