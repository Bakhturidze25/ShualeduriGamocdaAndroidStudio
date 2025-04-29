package com.example.myapplication

import android.app.Dialog
import android.graphics.Color
import android.os.Bundle
import android.view.*
import android.widget.Button
import android.widget.TextView
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class SubmitLeaveDialogFragment : BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.dialog_submit_leave, container, false)

        // Title დაჭერით დიალოგის დახურვა (სურვილისამებრ)
        val title = view.findViewById<TextView>(R.id.submitLeaveTitle)
        title.setOnClickListener {
            dismiss()
        }

        // Yes ღილაკი — აპის გათიშვა
        val yesButton = view.findViewById<Button>(R.id.yesSubmitButton)
        yesButton.setOnClickListener {
            requireActivity().finish() // აპის გათიშვა
        }

        // No ღილაკი — დიალოგის დახურვა
        val noButton = view.findViewById<Button>(R.id.noButton)
        noButton.setOnClickListener {
            dismiss()
        }

        return view
    }

    override fun onStart() {
        super.onStart()
        val dialog = dialog ?: return
        val bottomSheet = dialog.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet)
        bottomSheet?.let {
            it.setBackgroundColor(Color.WHITE)
            val layoutParams = it.layoutParams
            layoutParams.height = (resources.displayMetrics.heightPixels * 0.4).toInt()
            it.layoutParams = layoutParams
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        dialog.window?.setDimAmount(0.5f) // ფონის ჩამუქება
        dialog.window?.addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
        return dialog
    }
}
