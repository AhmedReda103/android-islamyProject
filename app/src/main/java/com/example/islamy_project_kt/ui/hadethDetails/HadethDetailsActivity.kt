package com.example.islamy_project_kt.ui.hadethDetails

import android.os.Bundle
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.islamy_project_kt.R

class HadethDetailsActivity : AppCompatActivity() {

    lateinit var HadethTitle :TextView
    lateinit var recyclerHadethVerses :RecyclerView
    lateinit var adapter : VersesHadethAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activitiy_hadeth_details)
        HadethTitle=findViewById(R.id.title_text_view)
        val hadethName =  intent.getStringExtra("hadeth_name")
        val hadethPos = intent.getIntExtra("hadeth_pos",-1)
        HadethTitle.setText(hadethName)
        intitRecyclerView()
        readHadethFile(hadethPos)

        }
    private fun intitRecyclerView() {
        recyclerHadethVerses=findViewById(R.id.recycler_view_hadeth_verses)
        adapter= VersesHadethAdapter()
        recyclerHadethVerses.adapter=adapter
    }

    private fun readHadethFile(hadethPos: Int) {
        val fileName = "h${hadethPos+1}.txt"
        val fileContent = assets.open(fileName).bufferedReader().use { it.readText() }
        val verses: List<String> = fileContent.split("\n")
        //show verses in recyclerview
        adapter.changeData(verses)

    }

}


