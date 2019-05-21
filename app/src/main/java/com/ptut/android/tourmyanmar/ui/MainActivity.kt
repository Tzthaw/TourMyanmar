package com.ptut.android.tourmyanmar.ui

import android.app.Dialog
import android.os.Bundle

import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import com.ptut.android.tourmyanmar.ui.home.HomeFragment
import com.ptut.android.tourmyanmar.R
import com.ptut.android.tourmyanmar.ui.notification.NotificationFragment
import com.ptut.android.tourmyanmar.ui.profile.SignInFragment
import com.ptut.android.tourmyanmar.ui.search.SearchFragment
import com.ptut.android.tourmyanmar.ui.profile.ToSignInFragment
import com.ptut.android.tourmyanmar.utils.FragmentChangeListener
import com.ptut.android.tourmyanmar.utils.SIGN_IN
import com.ptut.android.tourmyanmar.utils.TO_SIGN_IN

import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.content_main.*
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment


class MainActivity : AppCompatActivity(),
    NavigationView.OnNavigationItemSelectedListener,
    FragmentChangeListener{

    private var mySessionId: Int = 0

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                switchToHome()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_search -> {
                switchToSearch()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_profile -> {
                replaceFragment("")
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        setSupportActionBar(toolbar)
        toolbar.title=""

        supportActionBar?.elevation = 0F

        bottom_view.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_nav_toogle)

        navView.setNavigationItemSelectedListener(this)
        switchToHome()
    }


    private fun switchToHome() {
        val manager = supportFragmentManager
        manager.beginTransaction().replace(R.id.homeFragment, HomeFragment()).commit()
    }
    private fun switchToProfile() {
        val manager = supportFragmentManager
        manager.beginTransaction().replace(R.id.homeFragment, ToSignInFragment()).commit()
    }
    private fun switchToSearch() {
        val manager = supportFragmentManager
        manager.beginTransaction().replace(R.id.homeFragment,
            SearchFragment()
        ).commit()
    }

    override fun onBackPressed() {
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_notification -> {
                NotificationFragment.display(supportFragmentManager)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.action_home -> {
                // Handle the camera action
            }
            R.id.action_search -> {

            }
            R.id.action_profile -> {

            }
        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun replaceFragment(choosePref: String) {
        when {
            choosePref.trim() == SIGN_IN -> {
                val manager = supportFragmentManager
                manager.beginTransaction().replace(R.id.homeFragment, SignInFragment()).commit()
            }
            choosePref.trim()== TO_SIGN_IN -> {
                val manager = supportFragmentManager
                manager.beginTransaction().replace(R.id.homeFragment, ToSignInFragment()).commit()
            }
            choosePref == "" -> {
                val manager = supportFragmentManager
                manager.beginTransaction().replace(R.id.homeFragment, ToSignInFragment()).commit()
            }
        }
    }


}
