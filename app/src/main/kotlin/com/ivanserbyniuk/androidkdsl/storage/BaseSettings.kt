package storage

import android.content.Context
import android.content.SharedPreferences

/**
 * Created by Ivan on 19.04.17.
 */
open class BaseSettings(val context: Context) {
    val preferences: SharedPreferences by lazy { context.getSharedPreferences("preferences", Context.MODE_PRIVATE); }
    fun prefString() = PrefStringDelegate(preferences)
    fun prefLong() = PrefLongDelegate(preferences)
    fun prefInt(defVal: Int = -1) = PrefIntDelegate(preferences, defVal)
    fun prefBoolean() = PrefBooleanDelegate(preferences)
    fun prefFloat() = PrefFloatDelegate(preferences)
    fun prefStringSet() = PrefStringDelegate(preferences)
}