package com.lovecube.clinic.ui
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
class GenesisActivity : AppCompatActivity() { override fun onCreate(s: Bundle?) { super.onCreate(s); val t = TextView(this); t.text = "Genesis AI: Image Generator Ready"; setContentView(t) } }