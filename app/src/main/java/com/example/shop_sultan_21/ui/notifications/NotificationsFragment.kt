package com.example.shop_sultan_21.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.shop_sultan_21.R
import com.example.shop_sultan_21.databinding.FragmentNotificationsBinding
import com.example.shop_sultan_21.loadImage
import com.example.shop_sultan_21.models.ProductItem

class NotificationsFragment : Fragment() {

    private var _binding: FragmentNotificationsBinding? = null



    private val binding get() = _binding!!
    private var comingId: Int = 0
    private var product: ProductItem? = null

    override fun onCreate(savedInstanceState: Bundle?){

        super.onCreate(savedInstanceState)
        val args: Bundle? = this.arguments

        if (args!= null){
            product = args.getSerializable("key_as") as ProductItem
        }else{
            comingId=1
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        _binding=FragmentNotificationsBinding.inflate(inflater,container,false)
        val root: View = binding.root

        binding.cardDescTitle.text = product?.title
        binding.cardDescPrice.text = product?.price.toString()
        binding.cardDescDescription.text = product?.description

        binding.cardDescImage1.loadImage(product?.image.toString())


        setUpOnBackPressed()

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnBack.setOnClickListener{v ->
            findNavController().navigate(R.id.action_notificationsFragment_to_navigation_home)
        }

        binding.btnToPay.setOnClickListener { v1 ->
            findNavController().navigate(R.id.action_notificationsFragment_to_paymentFragment)
        }

    }
    fun setUpOnBackPressed() {
        requireActivity().onBackPressedDispatcher
            .addCallback(object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed(){
                if (isEnabled) {
                requireActivity()
                    .finish()
            }            }
        })
    }






    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }}
