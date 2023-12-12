package com.example.multipletasksinrecents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class DocumentActivity : AppCompatActivity() {
    private var documentCount = 0
    lateinit var countText: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_document)

        countText = findViewById<TextView>(R.id.countText)
        documentCount = intent
            .getIntExtra("counter", 0)
        countText.text = documentCount.toString()
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        Log.w("DocumentActivity", "onNewIntent")
        countText.text = "Reused: $documentCount -> ${intent?.getIntExtra("counter", 0)}"
    }
}