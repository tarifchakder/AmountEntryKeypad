package com.example.myapplication

import android.content.Context
import android.content.res.Resources
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.RelativeLayout
import androidx.core.view.doOnLayout
import androidx.core.view.isVisible
import com.example.myapplication.databinding.KeyboardLayoutBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior

class KeyBoardLayout(context: Context, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : FrameLayout(context, attrs, defStyleAttr, defStyleRes) {

    @JvmOverloads
    constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : this(context, attrs, defStyleAttr, 0)

    private val bind by lazy { KeyboardLayoutBinding.inflate(LayoutInflater.from(context), this, false) }

    private var sheetBehavior: BottomSheetBehavior<*>? = null
    private var isOpenKeyboard = true
    private var isKeyboardDraggable = false
    private var showAmountBar = true
    private var buttonOkayText = "Submit"

    init {
        context.theme.obtainStyledAttributes(attrs, R.styleable.KeyBoardLayout, 0, 0).apply {
            try {
                isOpenKeyboard = getBoolean(R.styleable.KeyBoardLayout_show_keyboard, true)
                isKeyboardDraggable = getBoolean(R.styleable.KeyBoardLayout_keyboard_draggable, false)
                showAmountBar = getBoolean(R.styleable.KeyBoardLayout_show_amount_bar, true)
                buttonOkayText = getString(R.styleable.KeyBoardLayout_okay_btn_text) ?: buttonOkayText

            } finally {
                recycle()
            }
        }
        initView()
        addView(bind.root)
    }

    private fun initView() = with(bind.bottomSheet) {
        sheetBehavior = BottomSheetBehavior.from<LinearLayout>(bottomSheet)

        if (isOpenKeyboard)
            showKeyBoard()
        else
            hideKeyBoard()

        sheetBehavior?.isHideable = isKeyboardDraggable

        amount.isVisible = showAmountBar
        amountBarBorder.isVisible = showAmountBar
        btnOkayText.text = buttonOkayText
    }

    fun showKeyBoard() {
        sheetBehavior?.isHideable = false
        sheetBehavior?.state = BottomSheetBehavior.STATE_EXPANDED
    }

    fun hideKeyBoard() {
        sheetBehavior?.isHideable = true
        sheetBehavior?.state = BottomSheetBehavior.STATE_HIDDEN
    }

    fun isKeyboardDraggable(isDraggable: Boolean) {
        this.isKeyboardDraggable = isDraggable
        sheetBehavior?.isHideable = isKeyboardDraggable
    }

    fun toggleKeyBoard() {
        if (sheetBehavior?.state == BottomSheetBehavior.STATE_HIDDEN)
            showKeyBoard()
        else
            hideKeyBoard()

    }

    fun showAmountBar(isVisible: Boolean) {
        this.showAmountBar = isVisible
        apply()
    }

    fun btnOkayText(title: String){
        this.buttonOkayText = title
        apply()
    }

    private fun apply() {
        invalidate()
        initView()
        requestLayout()
    }
}