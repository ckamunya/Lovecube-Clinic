package com.lovecube.clinic.ui
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
class CarStatsActivity : AppCompatActivity() { override fun onCreate(s: Bundle?) { super.onCreate(s); val t = TextView(this); t.text = "Tesla Model S: 85% Charged"; setContentView(t) } }