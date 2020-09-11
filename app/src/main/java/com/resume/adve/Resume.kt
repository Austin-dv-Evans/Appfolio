package com.resume.adve

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.FileUtils
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import com.resume.adve.utils.FileUtils.getPdfNameFromAssets
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.drawerLayout
import kotlinx.android.synthetic.main.activity_main.nav_view
import kotlinx.android.synthetic.main.activity_p_d_fview.*
import kotlinx.android.synthetic.main.activity_resume.*

class Resume : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resume)


        setUpOnClickListener()
        checkPdfAction(intent)


        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        nav_view.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.miItem0 -> openMainActivity()
                R.id.miItem1 -> openPortfolioActivity()
                R.id.miItem2 -> openCertificateActivity()
                R.id.miItem3 -> Toast.makeText(applicationContext,
                    "Look at that Resume", Toast.LENGTH_SHORT).show()
                R.id.miItem4 -> openContactActivity()
            }
            true
        }
        Toast.makeText(applicationContext,
            "Look at that Resume", Toast.LENGTH_SHORT).show()
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

    private fun setUpOnClickListener() {
        button_resume_asset.setOnClickListener {
            val intent = Intent(this, PDFviewActivity::class.java)
            intent.putExtra("ViewType", "assets")
            startActivity(intent)
        }
    }
    fun getPdfNameFromAssets(): String {
        return "AustinEvansSoftwareEngineer.pdf"
    }

    fun showPdfFromAssets(pdfName: String){
        pdfView.fromAsset(pdfName)
            .password(null)
            .defaultPage(0)
            .onPageError { page, _ ->
                Toast.makeText(this, "Error at page: $page", Toast.LENGTH_LONG).show()
            }
            .load()
    }
    private fun checkPdfAction(intent: Intent) {
        when (intent.getStringExtra("ViewType")) {
            "assets" -> {
                showPdfFromAssets(getPdfNameFromAssets())
            }
        }
    }
}
