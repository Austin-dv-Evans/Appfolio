package com.resume.adve

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import kotlinx.android.synthetic.main.activity_main.*

class Contact : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)

        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        nav_view.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.miItem0 -> openMainActivity()
                R.id.miItem1 -> openPortfolioActivity()
                R.id.miItem2 -> openCertificateActivity()
                R.id.miItem3 -> openResumeActivity()
                R.id.miItem4 -> Toast.makeText(applicationContext,
                "Get in touch with Austin", Toast.LENGTH_SHORT).show()
            }
            true
        }
        Toast.makeText(applicationContext,
            "Get in touch with Austin", Toast.LENGTH_SHORT).show()
    }
    fun openMainActivity(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
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
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}