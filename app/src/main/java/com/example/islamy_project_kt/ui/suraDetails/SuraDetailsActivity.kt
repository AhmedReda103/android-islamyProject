package com.example.islamy_project_kt.ui.suraDetails

import android.os.Bundle
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.islamy_project_kt.Constants

import com.example.islamy_project_kt.R

class SuraDetailsActivity : AppCompatActivity() {

    lateinit var title_tv: TextView
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: VersesAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sura_details)
        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        title_tv = findViewById(R.id.title_text_view)
        initRecyclerView()

        val suraName = intent.getStringExtra(Constants.Extra_SURA_NAME) as String
        val suraPos = intent.getIntExtra(Constants.Extra_SURA_POSITION, -1)
        title_tv.setText(suraName)

        readSuraFile(suraPos)
    }

    private fun initRecyclerView() {
        recyclerView = findViewById(R.id.recycler_view)
        adapter = VersesAdapter()
        recyclerView.adapter = adapter

    }

    private fun readSuraFile(suraPos: Int) {
        //pos+1.text
        val fileNmae = "${suraPos+1}.txt"
        val fileContent = assets.open(fileNmae).bufferedReader().use { it.readText() }
        val verses: List<String> = fileContent.split("\n")
        //show verses in recyclerview
        adapter.changeData(verses)
    }


}

