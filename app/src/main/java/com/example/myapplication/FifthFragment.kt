package com.example.myapplication

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment

class FifthFragment : Fragment() {

    private lateinit var reviewButton: Button
    private lateinit var approvedButton: Button
    private lateinit var rejectedButton: Button
    private lateinit var submitLeaveButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_fifth, container, false)

        reviewButton = view.findViewById(R.id.reviewButton)
        approvedButton = view.findViewById(R.id.approvedButton)
        rejectedButton = view.findViewById(R.id.rejectedButton)
        submitLeaveButton = view.findViewById(R.id.submitLeaveButton)

        // Default state — show ReviewFragment & highlight the button
        replaceChildFragment(ReviewFragment())
        highlightSelectedButton(reviewButton)

        reviewButton.setOnClickListener {
            replaceChildFragment(ReviewFragment())
            highlightSelectedButton(reviewButton)
        }

        approvedButton.setOnClickListener {
            replaceChildFragment(ApprovedFragment())
            highlightSelectedButton(approvedButton)
        }

        rejectedButton.setOnClickListener {
            replaceChildFragment(RejectedFragment())
            highlightSelectedButton(rejectedButton)
        }

        submitLeaveButton.setOnClickListener {
            val dialog = SubmitLeaveDialogFragment()
            dialog.show(childFragmentManager, "SubmitLeaveDialog")
        }

        return view
    }

    private fun replaceChildFragment(fragment: Fragment) {
        childFragmentManager.beginTransaction()
            .replace(R.id.childFragmentContainer, fragment)
            .commit()
    }

    private fun highlightSelectedButton(selectedButton: Button) {
        val activeColor = Color.parseColor("#795FFC")
        val inactiveColor = Color.WHITE
        val activeTextColor = Color.WHITE
        val inactiveTextColor = Color.BLACK

        listOf(reviewButton, approvedButton, rejectedButton).forEach { button ->
            if (button == selectedButton) {
                button.setBackgroundColor(activeColor)
                button.setTextColor(activeTextColor)
            } else {
                button.setBackgroundColor(inactiveColor)
                button.setTextColor(inactiveTextColor)
            }
        }
    }
}
