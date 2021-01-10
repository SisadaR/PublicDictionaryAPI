package com.jkhome.dicpublicapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jkhome.dicpublicapi.databinding.ActivityMainBinding
import com.jkhome.dicpublicapi.databinding.ActivityWordDefinitionBinding

class WordDefinitionActivity : AppCompatActivity() {

    private val binding: ActivityWordDefinitionBinding by lazy { ActivityWordDefinitionBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_word_definition)
    }
}