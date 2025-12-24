package com.lovecube.clinic.ui
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
class NewsFeedActivity : AppCompatActivity() { override fun onCreate(s: Bundle?) { super.onCreate(s); val t = TextView(this); t.text = "News: LoveCube IPO reaches $1B"; setContentView(t) } }