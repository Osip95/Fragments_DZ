package com.example.fragments_dz

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.fragments_dz.R.string

class SecondFragment : Fragment(R.layout.second_fragment) {
    private lateinit var tvFirstName: TextView
    private lateinit var tvSecondName: TextView
    private lateinit var tvEmail: TextView
    private lateinit var btnClear: Button

    companion object {
        private const val FIRST_NAME_KEY = "FIRST_NAME_KEY"
        private const val SECOND_NAME_KEY = "SECOND_NAME_KEY"
        private const val EMAIL_KEY = "EMAIL"
        fun newInstance(firstName: String, secondName: String, email: String): SecondFragment {
            val bundle = Bundle().apply {
                putString(FIRST_NAME_KEY, firstName)
                putString(SECOND_NAME_KEY, secondName)
                putString(EMAIL_KEY, email)
            }
            return SecondFragment().apply { arguments = bundle }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvFirstName = view.findViewById(R.id.tvFirstName)
        tvSecondName = view.findViewById(R.id.tvSecondName)
        tvEmail = view.findViewById(R.id.tvEmail)
        btnClear = view.findViewById(R.id.btnClear)

        tvFirstName.text = getString(string.formatted_first_name, arguments?.getString(FIRST_NAME_KEY))
        tvSecondName.text = getString(string.formatted_second_name, arguments?.getString(SECOND_NAME_KEY))
        tvEmail.text = getString(string.formatted_email,arguments?.getString(EMAIL_KEY))

        btnClear.setOnClickListener {
            val fragmentManager = requireActivity().supportFragmentManager
            fragmentManager.popBackStack()
            fragmentManager.beginTransaction().replace(R.id.fragment_container_view, MainFragment())
                .commit()
        }
    }

}