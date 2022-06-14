package com.example.facebookkotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.facebookkotlin.R
import com.example.facebookkotlin.model.Story
import com.google.android.material.imageview.ShapeableImageView


/**
 * Created by Eldor Turgunov on 14.06.2022.
 * Facebook kotlin
 * eldorturgunov777@gmail.com
 */
class StoryAdapter(var context: Context, var items: ArrayList<Story>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    val TYPE_ITEM_HEADER: Int = 0

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == TYPE_ITEM_HEADER) {
            val header: View =
                LayoutInflater.from(context).inflate(R.layout.item_first_story, parent, false)
            return FilterFirstViewHolder(header)
        }
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_story_view, parent, false)
        return StoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (isHeader(position)) return
        val story = items[position]

        if (holder is StoryViewHolder) {
            val iv_background = holder.iv_background
            val iv_profile = holder.iv_profile
            val tv_fullname = holder.tv_fullname

            iv_background.setImageResource(story.profile)
            iv_profile.setImageResource(story.profile)
            tv_fullname.text = story.fullname
        }
    }

    fun isHeader(position: Int): Boolean {
        return position == 0
    }

    override fun getItemViewType(position: Int): Int {
        return if (isHeader(position)) TYPE_ITEM_HEADER else position
    }


    private class FilterFirstViewHolder(view: View?) :
        RecyclerView.ViewHolder(view!!) {

    }

    class StoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var iv_background: ShapeableImageView
        var iv_profile: ShapeableImageView
        var tv_fullname: TextView

        init {
            iv_background = view.findViewById(R.id.iv_background)
            iv_profile = view.findViewById(R.id.iv_profile)
            tv_fullname = view.findViewById(R.id.tv_fullname)
        }
    }

}