package com.aarappstudios.viewmodaldemo

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var viewModal: MainViewModal
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var coutertext:TextView=findViewById(R.id.counter_text)


        viewModal= ViewModelProvider(this).get(MainViewModal::class.java)


        coutertext.text = viewModal.counterInt.toString()
        increaseBtn.setOnClickListener {
            viewModal.counterInt=viewModal.counterInt+1
            coutertext.text = viewModal.counterInt.toString()
        }

        decreaseBtn.setOnClickListener {
            if (viewModal.counterInt!=0) {
                viewModal.counterInt = viewModal.counterInt - 1
                coutertext.text = viewModal.counterInt.toString()
            }else
            Toast.makeText(this, "cannot decrease", Toast.LENGTH_SHORT).show()
        }
    }
}