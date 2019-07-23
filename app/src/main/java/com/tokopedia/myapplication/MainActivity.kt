package com.tokopedia.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.logging.LogManager
import java.util.logging.Logger

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        LogManager.getLogManager().readConfiguration(this.resources.openRawResource(R.raw.logging_p1))
        val logger1 = Logger.getLogger("logger_1")
        LogManager.getLogManager().readConfiguration(this.resources.openRawResource(R.raw.logging_p2))
        val logger2 = Logger.getLogger("logger_2")
        button.setOnClickListener {
            GlobalScope.launch {
                logger1.warning("Test1")
            }
        }

        button2.setOnClickListener {
            GlobalScope.launch {
                logger2.warning("Test2")
            }
        }
    }
}
