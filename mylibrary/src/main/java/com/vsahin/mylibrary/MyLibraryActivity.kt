package com.vsahin.mylibrary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MyLibraryActivity : AppCompatActivity() {
    lateinit var editText: EditText
    lateinit var textView: TextView
    lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_library)

        editText = findViewById(R.id.editText)
        textView = findViewById(R.id.textView)
        button = findViewById(R.id.button)

        button.setOnClickListener {
            textView.text = editText.text.toString()
        }
    }

    fun libraryUncoveredFunction() = 1
}