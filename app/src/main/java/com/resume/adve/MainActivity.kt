package com.resume.adve

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        nav_view.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.miItem0 -> Toast.makeText(applicationContext,
                    "About Page", Toast.LENGTH_SHORT).show()
                R.id.miItem1 -> openPortfolioActivity()
                R.id.miItem2 -> openCertificateActivity()
                R.id.miItem3 -> openResumeActivity()
                R.id.miItem4 -> openContactActivity()
            }
            true
        }
        Toast.makeText(applicationContext,
            "Welcome, thanks for checking me out.", Toast.LENGTH_SHORT).show()

    }

    fun openPortfolioActivity(){
        val intent = Intent(this, Portfolio::class.java)
        startActivity(intent)
    }
    fun openCertificateActivity(){
        val intent = Intent(this, Certificates::class.java)
        startActivity(intent)
    }
    fun openResumeActivity(){
        val intent = Intent(this, Resume::class.java)
        startActivity(intent)
    }
    fun openContactActivity(){
        val intent = Intent(this, Contact::class.java)
        startActivity(intent)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}