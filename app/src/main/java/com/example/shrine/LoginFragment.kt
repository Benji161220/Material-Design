package com.example.shrine

import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

/**
 * Fragment representing the login screen for Shrine.
 */
class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment.
        val view = inflater.inflate(R.layout.shr_login_fragment, container, false)
        val nextButton: Button = view.findViewById(R.id.next_button)
        val passwordEdit: TextInputEditText = view.findViewById(R.id.password_edit_text)
        val passwordInput: TextInputLayout = view.findViewById(R.id.password_text_input)
        // Set an error if the password is less than 8 characters.
        nextButton.setOnClickListener {
            val text = passwordEdit.text?.toString().orEmpty()
            if (!isPasswordValid(text)) {
                passwordInput.error = getString(R.string.shr_error_password)
            } else {
                passwordInput.error = null
            }
        }

        // Clear the error once more than 8 characters are typed.
        passwordEdit.addTextChangedListener { editable ->
            val text = editable?.toString().orEmpty()
            if (isPasswordValid(text)) {
                passwordInput.error = null
            }
        }

        return view
    }
    // "isPasswordValid" from "Navigate to the next Fragment" section method goes here
    private fun isPasswordValid(text: CharSequence?): Boolean {
        return (text?.length ?: 0) >= 8
    }
}