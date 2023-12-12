package com.example.multipletasksinrecents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    var documentCounter = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.once).setOnClickListener {
            createNewDocument(it, false)
        }

        findViewById<Button>(R.id.always).setOnClickListener {
            createNewDocument(it, true)
        }
    }

    fun createNewDocument(view: View, useMultipleTasks: Boolean) {
        val newDocumentIntent = newDocumentIntent()
        if (useMultipleTasks) {
            newDocumentIntent.addFlags(Intent.FLAG_ACTIVITY_MULTIPLE_TASK)
        }
        startActivity(newDocumentIntent)
    }

    private fun newDocumentIntent(): Intent =
        Intent(this, DocumentActivity::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_DOCUMENT or
                             android.content.Intent.FLAG_ACTIVITY_RETAIN_IN_RECENTS)
            putExtra("counter", documentCounter++)
        }
}