package com.example.facebookkotlin.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.facebookkotlin.R
import com.example.facebookkotlin.adapter.FeedAdapter
import com.example.facebookkotlin.model.Feed
import com.example.facebookkotlin.model.Post
import com.example.facebookkotlin.model.Story

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, 1)
        refreshAdapter(getAllFeeds())
    }

    private fun refreshAdapter(feeds: ArrayList<Feed>) {
        val adapter = FeedAdapter(this, feeds)
        recyclerView.adapter = adapter
    }

    private fun getAllFeeds(): ArrayList<Feed> {
        val stories: ArrayList<Story> = ArrayList<Story>()
        stories.add(Story(R.drawable.im_user_1, "Barney Martyn"))
        stories.add(Story(R.drawable.im_user_2, "Jayden Petaccio"))
        stories.add(Story(R.drawable.im_user_3, "Linwood Ramin"))
        stories.add(Story(R.drawable.im_user_1, "Nikko Verastequi"))
        stories.add(Story(R.drawable.im_user_2, "Tevin Winett"))
        stories.add(Story(R.drawable.im_user_3, "Aleeyah Buckless"))
        stories.add(Story(R.drawable.im_user_1, "Giovanni Ottaway"))
        stories.add(Story(R.drawable.im_user_2, "Jason Storton"))
        stories.add(Story(R.drawable.im_user_3, "Sasha Wiegmann"))

        val feeds: ArrayList<Feed> = ArrayList<Feed>()
        //Head
        feeds.add(Feed())
        //Story
        feeds.add(Feed(stories))
        //Post
        feeds.add(Feed(Post(R.drawable.im_user_3, "Barney", R.drawable.im_post_5)))
        feeds.add(Feed(Post(R.drawable.im_user_2, "Jayden", R.drawable.im_post_4)))
        feeds.add(Feed(Post(R.drawable.im_user_1, "Linwood", R.drawable.im_post_3)))
        feeds.add(Feed(Post(R.drawable.im_user_3, "Nikko", R.drawable.im_post_2)))
        feeds.add(Feed(Post(R.drawable.im_user_1, "Tevin", R.drawable.im_post_1)))
        feeds.add(Feed(Post(R.drawable.im_user_3, "Aleeyah", R.drawable.im_post_5)))
        feeds.add(Feed(Post(R.drawable.im_user_2, "Giovanni", R.drawable.im_post_4)))
        feeds.add(Feed(Post(R.drawable.im_user_1, "Jason", R.drawable.im_post_3)))
        feeds.add(Feed(Post(R.drawable.im_user_3, "Sasha", R.drawable.im_post_2)))
        feeds.add(Feed(Post(R.drawable.im_user_1, "Barney", R.drawable.im_post_1)))
        return feeds
    }
}