package com.example.fragments_dz

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment



class MainFragment: Fragment(R.layout.main_fragment) {
   private lateinit var etFirstName:EditText
   private lateinit var etSecondName:EditText
   private lateinit var etEmail:EditText
   private lateinit var btnGoToSecondActivity:Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        etFirstName = view.findViewById(R.id.TextInputEditTextFirstName)
        etSecondName = view.findViewById(R.id.textInputEditTextSecondName)
        etEmail = view.findViewById(R.id.textInputEditTextEmail)
        btnGoToSecondActivity = view.findViewById(R.id.btnGoToSecondFragment)

        btnGoToSecondActivity.setOnClickListener {
            val bundle = Bundle().apply {
                putString(FIRST_NAME_KEY,etFirstName.text.toString())
                putString(SECOND_NAME_KEY,etSecondName.text.toString())
                putString(EMAIL_KEY,etEmail.text.toString())

            }
            val secondFragment = SecondFragment().apply { arguments = bundle }
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container_view, secondFragment).addToBackStack(null)
                .commit()
        }
    }
}