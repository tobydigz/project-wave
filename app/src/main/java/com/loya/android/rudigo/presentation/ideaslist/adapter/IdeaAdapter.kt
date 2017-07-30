package com.loya.android.rudigo.presentation.ideaslist.adapter

import android.support.v4.util.SparseArrayCompat
import com.loya.android.rudigo.commons.adapter.AdapterConstants
import com.loya.android.rudigo.commons.adapter.BaseAdapter
import com.loya.android.rudigo.commons.adapter.ViewType
import com.loya.android.rudigo.commons.adapter.ViewTypeDelegateAdapter
import com.loya.android.rudigo.data.model.Idea

class IdeaAdapter(listener: IdeaDelegateAdapter.onViewSelectedListener) : BaseAdapter() {
    private var delegateAdapters = SparseArrayCompat<ViewTypeDelegateAdapter>()
    private val loadingItem = object : ViewType {
        override fun getViewType() = AdapterConstants.LOADING
    }

    init {
        delegateAdapters.put(AdapterConstants.LOADING, LoadingDelegateAdapter())
        delegateAdapters.put(AdapterConstants.IDEA, IdeaDelegateAdapter(listener))
        items = ArrayList()
        items.add(loadingItem)
    }

    fun addIdeas(ideas: List<Idea>) {
        val initPosition = items.size - 1
        items.removeAt(initPosition)
        items.addAll(ideas)
        notifyItemRangeChanged(initPosition, items.size)
    }
}