package com.example.lc2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.lc2.databinding.ActivityMainBinding
import retrofit2.Callback
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Glide.with(binding.imgHeart)
            .load("https://i.pinimg.com/564x/09/56/17/0956174ddd8e5d3e92df648d8d338d13.jpg")
            .into(binding.imgHeart)
        initClickers()
    }

    private fun initClickers() {
        with(binding) {
            btnCalculate.setOnClickListener {
                RetrofitService.api.getLove(etFname.text.toString(), etSname.text.toString())
                    .enqueue(object : Callback<LoveModel> {
                        override fun onResponse(
                            call: Call<LoveModel>,
                            response: Response<LoveModel>
                        ) {
                            val intent = Intent(this@MainActivity, SecondActivity::class.java)
                            intent.putExtra("result", response.body()?.percentage.toString())
                            startActivity(intent)
                        }

                        override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                            tvTitle.text = t.message
                        }

                    })
            }
        }
    }
}