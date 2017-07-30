package com.loya.android.rudigo.data.remote

import com.loya.android.rudigo.data.model.Comment
import com.loya.android.rudigo.data.model.Idea
import rx.Observable

class MockRemoteApi : RemoteApiManager {
    override fun getIdeas(): Observable<List<Idea>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun postIdea() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getComments(): Observable<List<Comment>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun mockIdeas(): List<Idea> {
        val ideas = ArrayList<Idea>()
        for (i in 1..5) {
            val idea = Idea(id = i.toLong(),
                    username = userNames[i],
                    idea = userIdeas[i],
                    effect = effects[i],
                    time = times[i])
            ideas.add(idea)
        }
        return ideas
    }

    val userNames = listOf<String>("loya", "ben", "yanky", "duff", "dan")
    val userIdeas = listOf<String>("Expanding The PH city Tech Space", "Coders in every nook and cranny", "Challenges of the PH Tech space", "Life as a coder", "Becoming world class with Rudigo!")
    val effects = listOf<String>("Making today count", "Making today count", "Making today count", "Making today count", "Making today count")
    val times = listOf<Long>(54654L, 87478L, 846468486L, 556458486L, 751315153188L)
}