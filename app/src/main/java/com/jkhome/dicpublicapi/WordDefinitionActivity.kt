package com.jkhome.dicpublicapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jkhome.dicpublicapi.databinding.ActivityMainBinding

class WordDefinitionActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_word_definition)
    }
}