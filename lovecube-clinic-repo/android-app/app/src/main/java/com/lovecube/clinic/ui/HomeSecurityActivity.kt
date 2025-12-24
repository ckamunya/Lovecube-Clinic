package com.lovecube.clinic.ui
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
class HomeSecurityActivity : AppCompatActivity() { override fun onCreate(s: Bundle?) { super.onCreate(s); val t = TextView(this); t.text = "Front Door: LOCKED\nCamera: RECORDING"; setContentView(t) } }