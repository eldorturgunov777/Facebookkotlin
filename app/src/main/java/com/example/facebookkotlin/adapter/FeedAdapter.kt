package com.example.facebookkotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.facebookkotlin.R
import com.example.facebookkotlin.model.Feed
import com.example.facebookkotlin.model.Story
import com.google.android.material.imageview.ShapeableImageView


/**
 * Created by Eldor Turgunov on 14.06.2022.
 * Facebook kotlin
 * eldorturgunov777@gmail.com
 */
class FeedAdapter(var context: Context, var items: ArrayList<Feed>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val TYPE_ITEM_HEAD = 0
    private val TYPE_ITEM_STORY = 1
    private val TYPE_ITEM_POST = 2
    val TYPE_ITEM_HEADER: Int = 3

    override fun getItemViewType(position: Int): Int {

        val feed = items[position]
        if (isHeader(position))
            return TYPE_ITEM_HEADER
        if (feed.isHeader)
            return TYPE_ITEM_HEAD
        else if (feed.stories.size > 0)
            return TYPE_ITEM_STORY
        return TYPE_ITEM_POST
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == TYPE_ITEM_HEAD) {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.item_feed_head, parent, false)
            return HeadViewHolder(context, view)
        } else if (viewType == TYPE_ITEM_STORY) {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.item_feed_story, parent, false)
            return StoryViewHolder(context, view)
        }
        if (viewType == TYPE_ITEM_HEADER) {
            val header: View =
                LayoutInflater.from(context).inflate(R.layout.item_feed_avatar, parent, false)
            return FeedAvatarViewHolder(header)
        }
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_feed_post, parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (isHeader(position)) return
        val feed = items[position]

        if (holder is HeadViewHolder) {

        }

        if (holder is StoryViewHolder) {
            val recyclerView = holder.recyclerView
            refreshAdapter(feed.stories, recyclerView)
        }

        if (holder is PostViewHolder) {
            val iv_profile = holder.iv_profile
            val iv_photo = holder.iv_photo
            val tv_fullname = holder.tv_fullname
            iv_profile.setImageResource(feed.post!!.profile)
            iv_photo.setImageResource(feed.post!!.photo)
            tv_fullname.text = feed.post!!.fullname
        }
    }


    fun isHeader(position: Int): Boolean {
        return position == 2
    }


    fun refreshAdapter(stories: ArrayList<Story>, recyclerView: RecyclerView) {
        val adapter = StoryAdapter(context, stories)
        recyclerView.adapter = adapter
    }

    class FeedAvatarViewHolder(view: View) : RecyclerView.ViewHolder(view)

    class HeadViewHolder(context: Context, view: View) : RecyclerView.ViewHolder(view)

    class StoryViewHolder(context: Context, view: View) : RecyclerView.ViewHolder(view) {
        var recyclerView: RecyclerView

        init {
            recyclerView = view.findViewById(R.id.recyclerView)
            val manager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            recyclerView.layoutManager = manager
        }
    }

    class PostViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var iv_profile: ShapeableImageView
        var iv_photo: ImageView
        var tv_fullname: TextView

        init {
            iv_profile = view.findViewById(R.id.iv_profile)
            iv_photo = view.findViewById(R.id.iv_photo)
            tv_fullname = view.findViewById(R.id.tv_fullname)
        }
    }

}