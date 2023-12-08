package com.example.lc2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.lc2.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = intent.getStringExtra("result")
        binding.tvTitle.text = intent

        Glide.with(binding.loveImg)
            .load("https://i.pinimg.com/originals/c6/a7/8e/c6a78ecd61e60eb23d000ff58d8bdd57.png")
            .into(binding.loveImg)
    }
}