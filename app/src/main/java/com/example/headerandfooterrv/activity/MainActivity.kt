package com.example.headerandfooterrv.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.headerandfooterrv.R
import com.example.headerandfooterrv.adapter.MemberAdapter
import com.example.headerandfooterrv.model.Member

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()

        val members = prepareMemberList()
        refreshAdapter(members)

    }

    private fun initViews() {
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, 1)
    }


    private fun refreshAdapter(members: ArrayList<Member>) {
        val adapter = MemberAdapter(members)
        recyclerView.adapter = adapter
    }


    private fun prepareMemberList(): ArrayList<Member> {
        val members: ArrayList<Member> = ArrayList()
        members.add(Member("", "", 0, false))  // For Header
        for (i in 1..30) {
            if (i == 2 || i == 5 || i == 9 || i == 11 || i == 15 || i == 20 || i == 21 || i == 27) {
                members.add(Member("$i)Selena", "$i)Gomez", R.drawable.selena, false))
            } else {
                members.add(Member("$i)Michael", "$i)Jackson", R.drawable.michael, true))
            }
        }
        members.add(Member("", "", 0, false))  // For Footer
        return members
    }


}