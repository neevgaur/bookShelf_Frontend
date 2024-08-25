package com.example.bookstore.auth.signUp

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.bookstore.R
import com.example.bookstore.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {

    private val binding: FragmentDetailBinding by lazy {
        FragmentDetailBinding.inflate(layoutInflater)
    }

    private lateinit var getContentLauncher: ActivityResultLauncher<String>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment

        binding.btnLoginHere.setOnClickListener {
            findNavController().navigate(R.id.action_detailFragment_to_loginFragment)
        }

        getContentLauncher = registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
            if (uri != null) {
                binding.imageViewSelected.setImageURI(uri)
            }
        }

        binding.btnAddImage.setOnClickListener {
            getContentLauncher.launch("image/*")
        }

        return binding.root
    }
}