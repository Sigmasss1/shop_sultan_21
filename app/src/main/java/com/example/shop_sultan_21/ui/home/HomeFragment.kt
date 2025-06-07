package com.example.shop_sultan_21.ui.home
import com.example.shop_sultan_21.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.MenuItem.*
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.shop_sultan_21.databinding.FragmentHomeBinding
import com.example.shop_sultan_21.models.ProductItem
import com.example.shop_sultan_21.visibility


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!


    private lateinit var mainList: List<ProductItem>

    private lateinit var myAdaptor: ShooseAdaptor

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(homeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.progressBar.visibility(true)


        homeViewModel.getFetchLiveData().observe(

            viewLifecycleOwner, object : Observer<List<ProductItem>?> {

                override fun onChanged(value: List<ProductItem>?) {
                    binding.progressBar.visibility(false)
                    mainList = value as List<ProductItem>
                    myAdaptor = ShooseAdaptor(requireActivity(), mainList)
                    binding.rvMainList.adapter = myAdaptor
                }
            })




        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnToBasket.setOnClickListener { v ->
            var bundle2= Bundle()
            bundle2.putParcelableArrayList("key_selected_product", myAdaptor.selected_intoBasketList )

          findNavController().navigate(R.id.action_navigation_home_to_basketFragment, bundle2)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}