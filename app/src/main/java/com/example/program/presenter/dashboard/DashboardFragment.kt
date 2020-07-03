package com.example.program.presenter.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.program.R
import com.example.program.databinding.FragmentDashboardBinding
import com.example.program.databinding.FragmentHomeBinding
import com.example.program.presenter.common.BaseFragment
import com.example.program.presenter.home.HomeFragment
import com.example.program.presenter.home.HomeViewModel
import com.example.program.presenter.notifications.NotificationsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class DashboardFragment : BaseFragment() {

    private lateinit var binding: FragmentDashboardBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDashboardBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.navView.setOnNavigationItemSelectedListener {
            showFragment(it.itemId)
            true
        }
        showFragment(binding.navView.selectedItemId)
    }

    private fun showFragment(id: Int) {
        when (id) {
            R.id.navigation_home -> {
                childFragmentManager.beginTransaction()
                    .replace(R.id.contentVg, HomeFragment())
                    .commit()
            }
            R.id.navigation_notifications -> {
                childFragmentManager.beginTransaction()
                    .replace(R.id.contentVg, NotificationsFragment())
                    .commit()
            }
        }
    }
}