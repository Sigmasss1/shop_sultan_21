package com.example.shop_sultan_21

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.NavController.OnDestinationChangedListener
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.shop_sultan_21.databinding.ActivityMainBinding
import com.google.android.filament.View

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private  lateinit var navView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.basketFragment
            )
        )

        navView.setupWithNavController(navController)


        navController.addOnDestinationChangedListener(
            object : OnDestinationChangedListener {
                override fun onDestinationChanged(
                    controller: NavController,
                    destination: NavDestination,
                    arguments: Bundle?
                ) {
                    val list = ArrayList<Int>()
                    list.add(R.id.notificationsFragment)

                    list.add(R.id.paymentFragment)
                    list.add(R.id.basketFragment)



                    if(list.contains(destination.id)){
                        navView.visibility = android.view.View.GONE

                    }else{
                        navView.visibility = android.view.View.VISIBLE
                    }
                }


            })

    }
}