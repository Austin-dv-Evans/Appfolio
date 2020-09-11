package com.resume.adve

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_p_d_fview.*

class PDFviewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_p_d_fview)
    }

    fun showPdfFromAssets(pdfName: String){
        pdfView.fromAsset(pdfName)
            .password(null)
            .defaultPage(0)
            .onPageError { page, _ ->
                Toast.makeText(this@PDFviewActivity, "Error at page: $page", Toast.LENGTH_LONG).show()
            }
            .load()
    }
}