package com.example.learnrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class HeroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hero)

        val nameHero : TextView = findViewById(R.id.hero_name)
        val imageHero : ImageView = findViewById(R.id.hero_image)
        val descriptionHero : TextView = findViewById(R.id.hero_description)

        val bundle : Bundle?= intent.extras
        val name = bundle!!.getString("name")
        val image = bundle!!.getInt("image")
        val desc = bundle!!.getString("description")

        nameHero.text = name
        descriptionHero.text = desc
        imageHero.setImageResource(image)
    }
}