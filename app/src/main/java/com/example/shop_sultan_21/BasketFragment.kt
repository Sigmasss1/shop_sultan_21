package com.example.shop_sultan_21

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.shop_sultan_21.databinding.FragmentBasketBinding
import com.example.shop_sultan_21.models.ProductItem
import com.example.shop_sultan_21.ui.home.ShooseAdaptor


class BasketFragment : Fragment() {

    private var _binding: FragmentBasketBinding? = null
    private val binding get() = _binding!!
    private var basket_products: ArrayList<ProductItem?> = ArrayList<ProductItem?>()
    var adapter: ShooseAdaptor? = null
    var total_sum: Double = 1.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val args: Bundle? = this.arguments

        if (args != null){
            basket_products = args.getParcelableArrayList<ProductItem>("key_selected_product") as ArrayList<ProductItem?>

        }else{
            showToast(requireActivity(),"Choose any product ! Basket is empty")
        }

    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBasketBinding.inflate(inflater,container,false)
        val root: View = binding.root
        binding.imageEmpty.visibility =View.VISIBLE

        try {
            if (basket_products == null){
                binding.imageEmpty.visibility =View.VISIBLE

            }else{
                binding.imageEmpty.visibility = View.GONE

                adapter = ShooseAdaptor(requireContext(), basket_products as ArrayList<ProductItem>)
                binding.rvBasket.setAdapter(adapter)
            }
        } catch (e: NullPointerException) {
            Log.e ("TAG_LOG" , "BUSKET IS EMPTY!!")
        }

        try {
            for (i in basket_products.indices) {
                total_sum += basket_products.get(i)!!.price

            }
            binding.basketTotalCount.setText((total_sum - 1.0).toString())

        } catch (ex: NullPointerException) {    binding.basketTotalCount.setText("0.00")
            binding.imageEmpty.visibility(true)
        }

       return  root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnPay.setOnClickListener {v ->
            findNavController().navigate(R.id.paymentFragment)

        }
        binding.btnBack.setOnClickListener { v1 ->
            findNavController().navigate(R.id.navigation_home)}
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


    }
