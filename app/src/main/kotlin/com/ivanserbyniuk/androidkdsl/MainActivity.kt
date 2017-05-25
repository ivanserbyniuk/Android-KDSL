package com.ivanserbyniuk.androidkdsl

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        alert {
            title("alert dsl")
            message("some message")
            okButton { /*do something*/ }
            cancelButton("close")
            neutralButton("maybe") { }
        }

    }
}
