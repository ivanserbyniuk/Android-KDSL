package com.ivanserbyniuk.androidkdsl.example

import android.content.Context
import storage.BaseSettings


class Storage(context: Context) : BaseSettings(context) {
    var name by prefString()
    var age by prefInt()
    var ok by prefBoolean()
}