package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.myapplication.databinding.ActivityMainBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {

    private lateinit var bind: ActivityMainBinding

    private var sheetBehavior: BottomSheetBehavior<*>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)

        //setUpReferences()
       // setOnClickListener()

        lifecycleScope.launch{
            delay(5000)
            sheetBehavior!!.state = BottomSheetBehavior.STATE_EXPANDED
           // f.show(supportFragmentManager,"")
           // bind.customKeypad.showAmountBar(false).apply()
            delay(3000)
          //  bind.customKeypad.showTopBarShadow(false).apply()
        }


       /* sheetBehavior!!.setBottomSheetCallback(object : BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                when (newState) {
                    BottomSheetBehavior.STATE_HIDDEN -> {}
                    BottomSheetBehavior.STATE_EXPANDED -> {
                        //bind.bottomSheet.bottomSheet.setText(R.string.close)
                    }

                    BottomSheetBehavior.STATE_COLLAPSED -> {
                       // btnBottomSheet.setText(R.string.expand)
                    }

                    BottomSheetBehavior.STATE_DRAGGING, BottomSheetBehavior.STATE_SETTLING -> sheetBehavior!!.setHideable(
                        true
                    )
                }
            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {}
        })*/

    }

   /* private fun setUpReferences() {
        sheetBehavior = BottomSheetBehavior.from<LinearLayout>(bind.bottomSheet.bottomSheet)
    }

    private fun setOnClickListener() = with(bind.bottomSheet) {
        bottomSheet.setOnClickListener(View.OnClickListener {
            if (sheetBehavior!!.getState() !== BottomSheetBehavior.STATE_EXPANDED) {
                sheetBehavior!!.setState(BottomSheetBehavior.STATE_EXPANDED)
               // bottomSheet.setText(R.string.close)
            } else {
                sheetBehavior!!.setState(BottomSheetBehavior.STATE_COLLAPSED)
             //   btnBottomSheet.setText(R.string.expand)
            }
        })
    }*/

}