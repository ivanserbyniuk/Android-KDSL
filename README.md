# Android-KDSL
Android-KDSL is the extra tiny Kotlin library. It provide some Dsl and utils for Android. 
# Alerts

The simple alert dialog: 
  
    private fun simpleAlert() = alert {
        title("alert title")
        message("alert message")
        okButton()
    }
 The complex alert dialog
 
      private fun moreComplexAlert() = alert {
                title("title")
                message("some message")
                iconVector(android.R.drawable.ic_delete)
                okButton("accept") { /*do something*/ }
                cancelButton("close")
                neutralButton("maybe") { /*do something*/ }
                cancelable()
            }
        
  Alert dialog with custom view
  
      private fun simpleCustomAlert() {
              val view = inflate(R.layout.view_info)
              val dialog = alertDialog { contentView(view) }
              view.findViewById(R.id.btnClose)?.setOnClickListener { dialog.dismiss() }
              //..and other listeners
              dialog.show()
          }
    
   Alerts in dialog fragment
    
       class AlertDialogFragment : DialogFragment() {
       
               override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
                   val view = context.inflate(R.layout.view_info)
                   view.findViewById(R.id.btnClose).setOnClickListener { dialog.dismiss() }
                   //..and other listeners
                   return alertDialog {
                       title(R.string.alert_title)
                       contentView(view)
                       setCancelable(false)
                   }
               }
           }
           
   Alert with Item List
   
   with varargs
   
           alert {
               title(R.string.alert_title)
               list("One", "Two", "Three") { index, value ->
                   Toast.makeText(context, "Selected value $value with index $index", Toast.LENGTH_SHORT).show()
               }
           }
   or with list
   
           val values = listOf ("One", "Two", "Three")
           alert {
               title(R.string.alert_title)
               list(values) { index  ->
                   Toast.makeText(context, "Selected value ${values[index]}", Toast.LENGTH_SHORT).show()
               }
           }
 # Preferences
 Use shared preferences in easy way. 
 BaseSettings provide pref[type] methods
 
      class UserSettings(context: Context) : BaseSettings(context) {
        var name by prefString()
        var age by prefInt()
        var ok by prefBoolean()
      }

pref[type] - returns the delegate which uses the setter of property for saving data in the shared prefference and uses the getter for restoring data. In this case name of property is the key for Prefference.Editor

create settings

        val settings = Settings(this)
        
save to storage
      
        settings.name = " Test"
        settings.age = 12
        settings.ok = true
restore from settings

        val name = settings.name
        val age = settings.age
        val ok = settings.ok
       
 # Fragments
 Find fragment by tag
 
        fragmentByTag<SupportMapFragment>("map")?.getMapAsync { map ->
            map.addMarker(makeMarkerOptions())
            //... other work with map
        }
Find fragment by id

        val currentFragment = fragmentById<SampleFragment>(R.id.fragmentContainer)
        
Fragment transaction
        
        supportFragmentTransaction { replace(R.id.fragmentContainer, SampleFragment.create()) }
        childFragmentTransaction { remove(testFragment)
                                   add(R.id.contentPanel, SampleFragment.create()) 
                                   }



