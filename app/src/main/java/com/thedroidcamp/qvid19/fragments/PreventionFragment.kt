package com.thedroidcamp.qvid19.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.thedroidcamp.qvid19.R
import com.thedroidcamp.qvid19.databinding.FragmentDashboardBinding
import com.thedroidcamp.qvid19.databinding.FragmentPreventionBinding
import com.thedroidcamp.qvid19.preventions
import kotlinx.android.synthetic.main.fragment_prevention.*

class PreventionFragment : Fragment() {


    private lateinit var binding: FragmentPreventionBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

         binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_prevention, container, false)

        prevention_fragment_text.text = preventions

        prevention_fragment_previous_btn.setOnClickListener(
            Navigation.createNavigateOnClickListener(
                R.id.action_preventionFragment_to_symptomsFragment)
        )

        prevention_fragment_next_btn.setOnClickListener(
            Navigation.createNavigateOnClickListener(
                R.id.action_preventionFragment_to_treatmentsFragment)
        )

        binding.preventionFragmentText.text = preventions

        return binding.root
    }
}
