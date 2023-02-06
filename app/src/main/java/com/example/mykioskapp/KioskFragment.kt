package com.example.mykioskapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.mykioskapp.databinding.FragmentKioskBinding
import com.example.mykioskapp.utils.isInLockTaskMode

class KioskFragment : Fragment() {

    private val viewModel: KioskViewModel by activityViewModels()

    private var _binding: FragmentKioskBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentKioskBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.showDialog.setOnClickListener {
            findNavController().navigate(R.id.action_nav_kiosk_to_nav_dialog)
        }

        binding.kioskSwitch.isChecked = requireContext().isInLockTaskMode()
        binding.kioskSwitch.setOnCheckedChangeListener { _, isChecked ->
            viewModel.handleKiosk(isChecked)
        }

        binding.immersiveSwitch.setOnCheckedChangeListener { _, isChecked ->
            viewModel.handleImmersive(isChecked)
        }

        binding.openLink.setOnClickListener {
            openLink()
        }

        binding.openActivity.setOnClickListener {
            startActivity(Intent(context, SecondActivity::class.java))
        }
    }

    private fun openLink(){
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com")))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}