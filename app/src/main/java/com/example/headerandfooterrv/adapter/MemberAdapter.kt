package com.example.headerandfooterrv.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.headerandfooterrv.R
import com.example.headerandfooterrv.model.Member

class MemberAdapter(val members: ArrayList<Member>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val TYPE_ITEM_HEADER = 0
    private val TYPE_ITEM_YES_VIEW = 1
    private val TYPE_ITEM_NOT_VIEW = 2
    private val TYPE_ITEM_FOOTER = 3


    override fun getItemViewType(position: Int): Int {
        if (isHeader(position)) return TYPE_ITEM_HEADER
        if (isFooter(position)) return TYPE_ITEM_FOOTER

        val member = members.get(position)
        if (member.available) return TYPE_ITEM_YES_VIEW
        return TYPE_ITEM_NOT_VIEW
    }

    private fun isHeader(position: Int): Boolean {
        return position == 0
    }

    private fun isFooter(position: Int): Boolean {
        return position == members.size - 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == TYPE_ITEM_HEADER) {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_member_layout_header, parent, false)
            return MemberViewHeaderHolder(view)
        } else if (viewType == TYPE_ITEM_FOOTER) {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_member_layout_footer, parent, false)
            return MemberViewFooterHolder(view)
        } else if (viewType == TYPE_ITEM_YES_VIEW) {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_member_layout_yes, parent, false)
            return MemberViewYesHolder(view)
        }

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_member_layout_not, parent, false)
        return MemberViewNotHolder(view)

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (isHeader(position) || isFooter(position)) return

        val member = members.get(position)
        if (holder is MemberViewYesHolder) {
            holder.apply {
                firstNameYes.setText(member.firstName)
                lastNameYes.setText(member.lastName)
                imageYes.setImageResource(member.image)
            }
        }

        if (holder is MemberViewNotHolder) {
            holder.apply {
                firstNameNot.setText(member.firstName)
                lastNameNot.setText(member.lastName)
                imageNot.setImageResource(member.image)
            }
        }
    }

    override fun getItemCount(): Int {
        return members.size
    }


    class MemberViewHeaderHolder(view: View) : RecyclerView.ViewHolder(view) {}


    class MemberViewFooterHolder(view: View) : RecyclerView.ViewHolder(view) {}


    class MemberViewYesHolder(view: View) : RecyclerView.ViewHolder(view) {
        // Add your UI Components here
        val firstNameYes = view.findViewById<TextView>(R.id.first_name_yes)
        val lastNameYes = view.findViewById<TextView>(R.id.last_name_yes)
        val imageYes = view.findViewById<ImageView>(R.id.image_view_yes)
    }


    class MemberViewNotHolder(view: View) : RecyclerView.ViewHolder(view) {
        // Add your UI Components here
        val firstNameNot = view.findViewById<TextView>(R.id.first_name_not)
        val lastNameNot = view.findViewById<TextView>(R.id.last_name_not)
        val imageNot = view.findViewById<ImageView>(R.id.image_view_not)
    }

}