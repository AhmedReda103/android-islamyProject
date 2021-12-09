package com.example.islamy_project_kt.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.example.islamy_project_kt.R
import com.example.islamy_project_kt.ui.home.fragments.HadethFragment
import com.example.islamy_project_kt.ui.home.fragments.QuranFragment
import com.example.islamy_project_kt.ui.home.fragments.RadioFragment
import com.example.islamy_project_kt.ui.home.fragments.TasbehFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView

class HomeActivity : AppCompatActivity() {

    lateinit var bottomNavigation :BottomNavigationView ;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        bottomNavigation = findViewById(R.id.bottom_navigation_bar)
        bottomNavigation.setOnItemSelectedListener(object :NavigationBarView.OnItemSelectedListener{

            override fun onNavigationItemSelected(item: MenuItem): Boolean {

                if (item.itemId == R.id.navigation_quran) {
                    pushFragment(QuranFragment())
                } else if (item.itemId == R.id.navigation_hadeth) {
                    pushFragment(HadethFragment())
                } else if (item.itemId == R.id.navigation_radio) {
                    pushFragment(RadioFragment())
                } else {
                    pushFragment(TasbehFragment())
                }
                return true ;
            }

            private fun pushFragment(fragment :Fragment) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, fragment).commit()            }
        })

        bottomNavigation.selectedItemId=R.id.navigation_quran

    }
}