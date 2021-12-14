package com.example.islamy_project_kt.ui.home.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.islamy_project_kt.R
import com.example.islamy_project_kt.ui.hadethDetails.HadethDetailsActivity
import com.example.islamy_project_kt.ui.home.fragments.adapter.HadethNamesAdapter

class HadethFragment : Fragment() {

    var hadethNames :MutableList<String> = mutableListOf()
    fun addHadeth()
    {
        for(i in 0..49)
        {
            hadethNames.add("الحديث رقم  ${i+1} ")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_hadeth , container , false )
    }

    lateinit var recyclerViewHadeth :RecyclerView
    lateinit var adapterHadeth : HadethNamesAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()


    }

    private fun initRecyclerView() {
        recyclerViewHadeth=requireView().findViewById(R.id.recycler_view_hadeth_names)
        addHadeth()
        adapterHadeth=HadethNamesAdapter(hadethNames)
        recyclerViewHadeth.adapter=adapterHadeth

        adapterHadeth.onItemClick=object : HadethNamesAdapter.onItemClickListener{
            override fun onItemClick(pos: Int, nameHadeth: String) {
               showHadethDetails(pos , nameHadeth)
            }
        }

    }

    private fun showHadethDetails(pos: Int, nameHadeth: String) {
        val intent = Intent(requireContext(),HadethDetailsActivity::class.java)
        intent.putExtra("hadeth_name",nameHadeth)
        intent.putExtra("hadeth_pos",pos)
        startActivity(intent)

    }


}