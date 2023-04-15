package com.example.fragments_dz

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment


class MainFragment : Fragment(R.layout.main_fragment) {
    private lateinit var etFirstName: EditText
    private lateinit var etSecondName: EditText
    private lateinit var etEmail: EditText
    private lateinit var btnGoToSecondScreen: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        etFirstName = view.findViewById(R.id.TextInputEditTextFirstName)
        etSecondName = view.findViewById(R.id.textInputEditTextSecondName)
        etEmail = view.findViewById(R.id.textInputEditTextEmail)
        btnGoToSecondScreen = view.findViewById(R.id.btnGoToSecondFragment)

        btnGoToSecondScreen.setOnClickListener {
            val secondFragment = SecondFragment.newInstance(
                etFirstName.text.toString(),
                etSecondName.text.toString(),
                etEmail.text.toString()
            )
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container_view, secondFragment)
                .addToBackStack("main_to_second").commit()

        }
    }
}