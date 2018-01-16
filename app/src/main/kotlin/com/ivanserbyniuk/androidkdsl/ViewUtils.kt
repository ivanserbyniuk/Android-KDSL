package com.ivanserbyniuk.androidkdsl

import android.content.Context
import android.support.annotation.IdRes
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout


fun Context.inflate(@IdRes id: Int): View {
    return LayoutInflater.from(this).inflate(R.layout.view_info, FrameLayout(this))

}