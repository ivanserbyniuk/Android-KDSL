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
  Alert dialog with custom view
  
      private fun simpleCustomAlert() {
        val view = LayoutInflater.from(this).inflate(R.layout.view_info, FrameLayout(this))
        val dialog = alertDialog { contentView(view) }
        view?.findViewById(R.id.btnClose)?.setOnClickListener { dialog.dismiss() }
        //..and other listeners
        dialog.show()
     }
    
    Alerts in dialog fragment
    
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
       
    

