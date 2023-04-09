package com.example.fragments_dz

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class SecondFragment:Fragment(R.layout.second_fragment) {
   private lateinit var tvFirstName:TextView
   private lateinit var tvSecondName:TextView
   private lateinit var tvEmail:TextView
   private lateinit var btnClear:Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvFirstName = view.findViewById(R.id.tvFirstName)
        tvSecondName = view.findViewById(R.id.tvSecondName)
        tvEmail = view.findViewById(R.id.tvEmail)
        btnClear = view.findViewById(R.id.btnClear)

        tvFirstName.text = arguments?.getString(FIRST_NAME_KEY)
        tvSecondName.text = arguments?.getString(SECOND_NAME_KEY)
        tvEmail.text = arguments?.getString(EMAIL_KEY)

        btnClear.setOnClickListener {
            val bundle = Bundle().apply {
                putBoolean(CLEAR_BUTTON_PRESSED,true)
            }
            val mainFragment = MainFragment().apply { arguments = bundle }
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container_view, mainFragment).addToBackStack(null)
                .commit()
        }
    }

}