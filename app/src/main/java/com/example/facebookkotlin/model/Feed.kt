package com.example.facebookkotlin.model


/**
 * Created by Eldor Turgunov on 14.06.2022.
 * Facebook kotlin
 * eldorturgunov777@gmail.com
 */
class Feed {
    var isHeader: Boolean = false
    var post: Post? = null
    var stories: ArrayList<Story> = ArrayList<Story>()

    constructor() {
        this.isHeader = true
    }

    constructor(post: Post) {
        this.post = post
        this.isHeader = false
    }

    constructor(stories: ArrayList<Story>) {
        this.stories = stories
        this.isHeader = false
    }
}