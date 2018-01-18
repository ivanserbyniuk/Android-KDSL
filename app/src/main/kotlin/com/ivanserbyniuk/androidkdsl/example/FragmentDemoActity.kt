package com.ivanserbyniuk.androidkdsl.example

import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.MarkerOptions
import com.ivanserbyniuk.androidkdsl.R
import com.ivanserbyniuk.androidkdsl.fragmentById
import com.ivanserbyniuk.androidkdsl.fragmentByTag
import com.ivanserbyniuk.androidkdsl.supportFragmentTransaction

class FragmentDemoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragmentByTag<SupportMapFragment>("map")?.getMapAsync { map ->
            map.addMarker(makeMarkerOptions())
            //... other work with map
        }

        fragmentTransition()
    }

    fun fragmentTransition() {
        supportFragmentTransaction { replace(R.id.fragmentContainer, SampleFragment.create()) }
        supportFragmentTransaction {
            replace(R.id.fragmentContainer, SampleFragment.create())
        }
        //....
        val currentFragment = fragmentById<SampleFragment>(R.id.fragmentContainer)
    }

    /*   fun showAlertFragment(){
           showDialogFragment(SampleAlertFragment.create())
       }*/


    fun makeMarkerOptions(): MarkerOptions? {
        return MarkerOptions()
    }

    class SampleFragment : Fragment() {
        companion object {
            fun create() = SampleFragment()
        }
    }

    class SampleAlertFragment : DialogFragment() {
        companion object {
            fun create() = SampleAlertFragment()
        }
    }
}