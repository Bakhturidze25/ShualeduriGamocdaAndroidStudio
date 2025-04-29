package com.example.myapplication

import android.graphics.Color
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {

    private lateinit var container1: LinearLayout
    private lateinit var container2: LinearLayout
    private lateinit var container3: LinearLayout
    private lateinit var container4: LinearLayout
    private lateinit var container5: LinearLayout

    private lateinit var button1: ImageView
    private lateinit var button2: ImageView
    private lateinit var button3: ImageView
    private lateinit var button4: ImageView
    private lateinit var button5: ImageView

    private lateinit var allContainers: List<LinearLayout>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // კონტეინერების დაკავშირება
        container1 = findViewById(R.id.button_container1)
        container2 = findViewById(R.id.button_container2)
        container3 = findViewById(R.id.button_container3)
        container4 = findViewById(R.id.button_container4)
        container5 = findViewById(R.id.button_container5)

        // ღილაკების დაკავშირება
        button1 = findViewById(R.id.image_button1)
        button2 = findViewById(R.id.image_button2)
        button3 = findViewById(R.id.image_button3)
        button4 = findViewById(R.id.image_button4)
        button5 = findViewById(R.id.image_button5)

        allContainers = listOf(container1, container2, container3, container4, container5)

        if (savedInstanceState == null) {
            replaceFragment(FirstFragment())
            highlightSelected(container1)
        }

        button1.setOnClickListener {
            replaceFragment(FirstFragment())
            highlightSelected(container1)
        }

        button2.setOnClickListener {
            replaceFragment(SecondFragment())
            highlightSelected(container2)
        }

        button3.setOnClickListener {
            replaceFragment(ThirdFragment())
            highlightSelected(container3)
        }

        button4.setOnClickListener {
            replaceFragment(FourthFragment())
            highlightSelected(container4)
        }

        button5.setOnClickListener {
            replaceFragment(FifthFragment())
            highlightSelected(container5)
        }
    }

    private fun highlightSelected(selectedContainer: LinearLayout) {
        for (container in allContainers) {
            container.setBackgroundColor(Color.TRANSPARENT)
        }
        // ღია იასამნისფერი
        selectedContainer.setBackgroundColor(Color.parseColor("#A78BFA"))
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }
}
