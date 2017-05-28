package com.ivanserbyniuk.androidkdsl

import android.support.v4.app.DialogFragment
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity

fun Fragment.childFragmentTransaction(init: FragmentTransaction.() -> Unit) {
    if (!activity.isFinishing) {
        val transaction = childFragmentManager.beginTransaction()
        transaction.init()
        transaction.commitAllowingStateLoss()
    }
}

fun AppCompatActivity.supportFragmentTransaction(init: FragmentTransaction.() -> Unit) {
    if (!isFinishing) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.init()
        transaction.commit()
    }
}

@Experimental
fun AppCompatActivity.showDialogFragment(dialogFragment: DialogFragment) {
    if (!isFinishing) {
        dialogFragment.show(supportFragmentManager, dialogFragment.tag)
    }
}

@Experimental
fun Fragment.showDialogFragment(dialogFragment: DialogFragment) {
    if (!activity.isFinishing) {
        dialogFragment.show(childFragmentManager, dialogFragment.tag)
    }
}

inline fun <reified T : Fragment> AppCompatActivity.fragmentById(id: Int): T? = supportFragmentManager?.findFragmentById(id) as? T
inline fun <reified T : Fragment> Fragment.fragmentById(id: Int): T? = childFragmentManager?.findFragmentById(id) as? T

inline fun <reified T : Fragment> AppCompatActivity.fragmentByTag(tag: String): T? = supportFragmentManager?.findFragmentByTag(tag) as? T
inline fun <reified T : Fragment> Fragment.fragmentByTag(tag: String): T? = childFragmentManager?.findFragmentByTag(tag) as? T