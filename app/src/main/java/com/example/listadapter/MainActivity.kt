package com.example.listadapter

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_View)
        val adapter = ProgrammingAdapter()
        val p1 = ProgrammingItem(1, "Gaddar", "Kumar")
        val p2 = ProgrammingItem(2, "Khajan", "Pawan")
        val p3 = ProgrammingItem(3, "Lakhan", "Ravi")

        adapter.submitList(listOf(p1, p2, p3))
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_share, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.share -> {
                val sharingIntent = Intent(Intent.ACTION_SEND)
                sharingIntent.type = "text/plain"
                val shareBody = "Application Link : https://play.google.com/store/apps/details?id="
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "App link")
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody)
                startActivity(Intent.createChooser(sharingIntent, "Share App Link Via :"))
            }
        }
        return super.onOptionsItemSelected(item)
    }
}