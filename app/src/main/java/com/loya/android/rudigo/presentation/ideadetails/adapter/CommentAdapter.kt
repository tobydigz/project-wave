package com.loya.android.rudigo.presentation.ideadetails.adapter

import android.support.v4.util.SparseArrayCompat
import com.loya.android.rudigo.commons.adapter.AdapterConstants
import com.loya.android.rudigo.commons.adapter.BaseAdapter
import com.loya.android.rudigo.commons.adapter.ViewTypeDelegateAdapter
import com.loya.android.rudigo.data.model.Comment

class CommentAdapter(listener: CommentDelegateAdapter.onViewSelectedListener) : BaseAdapter() {
    private var delegateAdapters = SparseArrayCompat<ViewTypeDelegateAdapter>()

    init {
        delegateAdapters.put(AdapterConstants.COMMENT, CommentDelegateAdapter(listener))
        items = ArrayList()
    }

    fun addComment(comment: Comment) {
        val position = items.size
        items.add(comment)
        notifyItemInserted(position)
    }
}