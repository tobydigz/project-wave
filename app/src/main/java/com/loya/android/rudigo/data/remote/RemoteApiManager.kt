package com.loya.android.rudigo.data.remote

import com.loya.android.rudigo.data.model.Comment
import com.loya.android.rudigo.data.model.Idea
import rx.Observable

interface RemoteApiManager {
    fun getIdeas(): Observable<List<Idea>>
    fun postIdea()
    fun getComments(): Observable<List<Comment>>
}