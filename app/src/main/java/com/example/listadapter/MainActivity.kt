package com.example.listadapter

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
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
        val p1 = ProgrammingItem(1, "G", "Gaddar")
        val p2 = ProgrammingItem(2, "P", "Pawan")
        val p3 = ProgrammingItem(3, "R", "Ravi")

        supportActionBar?.title = "Drawer"
        supportActionBar?.setIcon(R.drawable.ic_baseline_arrow_back_24)

        adapter.submitList(listOf(p1, p2, p3))
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter

        Handler(Looper.getMainLooper()).postDelayed(Runnable {
            val p4 = ProgrammingItem(5, "G", "Gaddar")
            val p5 = ProgrammingItem(6, "Y", "HSH")
            val p6 = ProgrammingItem(7, "RY", "Gad")
            val p7 = ProgrammingItem(8, "R", "Karan")

            adapter.submitList(listOf(p4,p5,p6,p7))

        },4000)
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