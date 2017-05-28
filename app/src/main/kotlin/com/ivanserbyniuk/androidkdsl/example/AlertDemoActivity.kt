package com.ivanserbyniuk.androidkdsl.example

import android.app.Dialog
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.ivanserbyniuk.androidkdsl.*

class AlertDemoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        simpleAlert()
        moreComplexAlert()
        simpleCustomAlert()
    }

    private fun simpleAlert() = alert {
        title("alert title")
        message("alert message")
        okButton()
    }

    private fun moreComplexAlert() {
        alert {
            title("title")
            message("some message")
            iconVector(android.R.drawable.ic_delete)
            okButton("accept") { /*do something*/ }
            cancelButton("close")
            neutralButton("maybe") { /*do something*/ }
            setCancelable(false)
        }
    }

    private fun simpleCustomAlert() {
        val view = LayoutInflater.from(this).inflate(R.layout.view_info, FrameLayout(this))
        val dialog = alertDialog { contentView(view) }
        view?.findViewById(R.id.btnClose)?.setOnClickListener { dialog.dismiss() }
        //..and other listeners
        dialog.show()
    }

    class AlertDialogFragment : DialogFragment() {
        override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
            val view = LayoutInflater.from(activity).inflate(R.layout.view_info, FrameLayout(activity))
            view?.findViewById(R.id.btnClose)?.setOnClickListener { dialog.dismiss() }
            //..and otheer listeners
            return alertDialog {
                title(R.string.alert_title)
                contentView(view)
                setCancelable(false)
            }
        }
    }

}