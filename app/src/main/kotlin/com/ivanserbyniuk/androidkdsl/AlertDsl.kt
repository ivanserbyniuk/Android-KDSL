package com.ivanserbyniuk.androidkdsl

import android.app.Activity
import android.graphics.drawable.Drawable
import android.support.annotation.DrawableRes
import android.support.annotation.IdRes
import android.support.annotation.StringRes
import android.support.graphics.drawable.VectorDrawableCompat
import android.support.v4.app.Fragment
import android.support.v7.app.AlertDialog
import android.view.View
import android.widget.ArrayAdapter


fun Activity.alert(init: AlertDialog.Builder.() -> Unit) {
    val builder = AlertDialog.Builder(this)
    builder.setCancelable(false)
    builder.init()
    return builder.create().show()
}

fun Activity.alertDialog(init: AlertDialog.Builder.() -> Unit): AlertDialog {
    val builder = AlertDialog.Builder(this)
    builder.setCancelable(false)
    builder.init()
    return builder.create()
}

fun Fragment.alertDialog(init: AlertDialog.Builder.() -> Unit) = activity.alertDialog(init)
fun Fragment.alert(init: AlertDialog.Builder.() -> Unit) = activity.alert(init)
fun android.app.Fragment.alert(init: AlertDialog.Builder.() -> Unit) = activity.alert(init)

fun AlertDialog.Builder.title(title: String) = setTitle(title)
fun AlertDialog.Builder.title(@StringRes title: Int) = setTitle(title)
fun AlertDialog.Builder.message(message: String) = setMessage(message)
fun AlertDialog.Builder.message(@StringRes message: Int) = setMessage(message)
fun AlertDialog.Builder.okButton(ok: String, action: (() -> Unit)? = null) = setPositiveButton(ok, { dialog, what -> action?.invoke() })
fun AlertDialog.Builder.okButton(@StringRes ok: Int = android.R.string.ok, action: (() -> Unit)? = null) = setPositiveButton(ok, { _, _ -> action?.invoke() })
fun AlertDialog.Builder.cancelButton(cancel: String, action: (() -> Unit)? = null) = setNegativeButton(cancel, { _, _ -> action?.invoke() })
fun AlertDialog.Builder.cancelButton(@StringRes cancel: Int = android.R.string.cancel, action: (() -> Unit)? = null) = setNegativeButton(cancel, { _, _ -> action?.invoke() })
fun AlertDialog.Builder.neutralButton(cancel: String, action: (() -> Unit)? = null) = setNeutralButton(cancel, { _, _ -> action?.invoke() })
fun AlertDialog.Builder.neutralButton(@StringRes cancel: Int = android.R.string.untitled, action: (() -> Unit)? = null) = setNeutralButton(cancel, { _, _ -> action?.invoke() })
fun AlertDialog.Builder.cancelable() = setCancelable(true)

fun AlertDialog.Builder.icon(@DrawableRes icon: Int) = setIcon(icon)
fun AlertDialog.Builder.icon(icon: Drawable) = setIcon(icon)
fun AlertDialog.Builder.iconVector(@DrawableRes icon: Int) = setIcon(VectorDrawableCompat.create(context.resources, icon, context.theme))
fun AlertDialog.Builder.contentView(view: View?) = apply { setView(view) }


fun AlertDialog.Builder.list(vararg items: String, @IdRes resId: Int = android.R.layout.select_dialog_item,
                             itemSelected: (Int, String) -> Unit) = apply {
    list(items.toList(), resId) { itemSelected(it, items[it]) }
}


fun AlertDialog.Builder.list(list: List<String>, resId: Int = android.R.layout.select_dialog_item,
                             itemSelected: (Int) -> Unit) = apply {
    val arrayAdapter = ArrayAdapter<String>(context, resId)
    arrayAdapter.addAll(list)
    setAdapter(arrayAdapter) { _, what -> itemSelected(what) }
}



