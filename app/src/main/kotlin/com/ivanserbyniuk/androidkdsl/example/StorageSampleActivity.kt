package com.ivanserbyniuk.androidkdsl.example

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * Created by ivan on 1/5/18.
 */
class StorageSampleActivity :AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //create storage
        val storage = Storage(this)
        //save to storage
        storage.name = " Test"
        storage.age = 12
        storage.ok = true

        //restore from storage
        val name = storage.name
        val age = storage.age
        val ok = storage.ok
    }
}