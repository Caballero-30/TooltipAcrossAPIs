package com.richardcaballero.tooltipacrossapis

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createTooltip(findViewById(R.id.btn), "This is a button")
        createTooltip(findViewById(R.id.fab), "This is a Floating Action Button")
    }

    private fun createTooltip(view: View, message: String) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {view.tooltipText = message}
        else {
            view.setOnLongClickListener {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
            true
            }
        }
    }
}