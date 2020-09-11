package com.resume.adve

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import kotlinx.android.synthetic.main.activity_main.*

class Certificates : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_certificates)

        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        nav_view.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.miItem0 -> openMainActivity()
                R.id.miItem1 -> openPortfolioActivity()
                R.id.miItem2 -> Toast.makeText(applicationContext,
                    "Look at all these Certificates", Toast.LENGTH_SHORT).show()
                R.id.miItem3 -> openResumeActivity()
                R.id.miItem4 -> openContactActivity()
            }
            true
        }
        Toast.makeText(applicationContext,
            "Look at all these Certificates", Toast.LENGTH_SHORT).show()
    }
    fun openMainActivity(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
    fun openPortfolioActivity(){
        val intent = Intent(this, Portfolio::class.java)
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
