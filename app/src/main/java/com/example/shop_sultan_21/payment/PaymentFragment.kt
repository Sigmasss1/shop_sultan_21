package com.example.shop_sultan_21.payment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.shop_sultan_21.R
import com.example.shop_sultan_21.databinding.FragmentPaymentBinding


class PaymentFragment : Fragment() {

    var _binding: FragmentPaymentBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentPaymentBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.cardVisa.setOnClickListener { v4 ->
            val myIntent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://visa.com/")
            )
            startActivity(myIntent)
            binding.cardPay.setOnClickListener { v3 ->
                val myIntent = Intent(
                    Intent.ACTION_VIEW, Uri.parse("https://paypal.com/"       )
                )
                startActivity(myIntent)
            }
            binding.cardM.setOnClickListener { v2 ->
                val myIntent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://mbank.kg/")
                )
                startActivity(myIntent)
            }
            binding.cardO.setOnClickListener { v1 ->
                val myIntent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://play.google.com/store/apps/details?id=kg.o.nurtelecom")
                )
                startActivity(myIntent)
            }

            binding.btnBack.setOnClickListener { v5 ->
                findNavController().navigate(R.id.action_paymentFragment_to_navigation_home)
            }

        }




    }
}

