package storage

import android.content.SharedPreferences
import kotlin.reflect.KProperty

class PrefStringDelegate(private val preferences: SharedPreferences) {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return preferences.getString(property.name, "")
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        preferences.edit().putString(property.name, value).apply()
    }
}


class PrefLongDelegate(private val preferences: SharedPreferences) {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): Long {
        return preferences.getLong(property.name, -1)
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: Long) {
        preferences.edit().putLong(property.name, value).apply()
    }
}

class PrefIntDelegate(private val preferences: SharedPreferences, val defVal: Int = -1) {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): Int {
        return preferences.getInt(property.name, defVal)
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) {
        preferences.edit().putInt(property.name, value).apply()
    }
}

class PrefBooleanDelegate(private val preferences: SharedPreferences, private val defVal: Boolean = false) {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): Boolean {
        return preferences.getBoolean(property.name, defVal)
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: Boolean) {
        preferences.edit().putBoolean(property.name, value).apply()
    }
}


