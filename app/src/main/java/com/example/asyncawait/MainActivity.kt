package com.example.asyncawait

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.asyncawait.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
           GlobalScope.launch(Dispatchers.Main) {
               delay(1000)
               binding.textView.text = "Hello World delayed 1s!"
               delay(1000)
               Toast.makeText(applicationContext, "Hello World, delayed 2s!", Toast.LENGTH_SHORT).show()
            }
        }
    }


}