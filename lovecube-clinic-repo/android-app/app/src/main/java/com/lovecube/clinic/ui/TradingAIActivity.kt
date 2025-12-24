package com.lovecube.clinic.ui
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import okhttp3.*
import org.json.JSONObject
import java.util.concurrent.TimeUnit

class TradingAIActivity : AppCompatActivity() {
    private lateinit var chart: LineChart
    private lateinit var dataSet: LineDataSet
    private var time = 6f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        chart = LineChart(this) // Programmatic View
        setContentView(chart)

        val entries = ArrayList<Entry>()
        entries.add(Entry(1f, 150f))
        entries.add(Entry(2f, 155f))
        
        dataSet = LineDataSet(entries, "Live Stock Price")
        dataSet.color = android.graphics.Color.CYAN
        dataSet.valueTextColor = android.graphics.Color.WHITE
        
        chart.data = LineData(dataSet)
        chart.animateX(1500)
        
        // Start WebSocket Listener
        connectWebSocket()
    }

    private fun connectWebSocket() {
        val client = OkHttpClient.Builder().readTimeout(0, TimeUnit.MILLISECONDS).build()
        // Using a public echo server for testing. Replace with your NASA Assist URL later.
        val request = Request.Builder().url("wss://echo.websocket.org").build()
        
        val listener = object : WebSocketListener() {
            override fun onOpen(webSocket: WebSocket, response: Response) {
                 // Simulate incoming data for demo
                 webSocket.send("{\"price\": 165.50}") 
            }
            override fun onMessage(webSocket: WebSocket, text: String) {
                try {
                    // For demo purposes, we are generating random noise since we don't have a real server yet
                    val price = 150f + (Math.random() * 20).toFloat()
                    runOnUiThread {
                        dataSet.addEntry(Entry(time, price))
                        time += 1f
                        chart.data.notifyDataChanged()
                        chart.notifyDataSetChanged()
                        chart.invalidate()
                    }
                } catch (e: Exception) { e.printStackTrace() }
            }
        }
        client.newWebSocket(request, listener)
    }
}