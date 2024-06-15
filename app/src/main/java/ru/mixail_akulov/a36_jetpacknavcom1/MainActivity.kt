package ru.mixail_akulov.a36_jetpacknavcom1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // Загружает активити майн, в которой запускается граф.
                                               // в соответствии с которым открывается первым рут фрагмент.
    }
}