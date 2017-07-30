package com.loya.android.rudigo.presentation.ideaslist.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.loya.android.rudigo.R
import com.loya.android.rudigo.commons.adapter.ViewType
import com.loya.android.rudigo.commons.adapter.ViewTypeDelegateAdapter
import com.loya.android.rudigo.commons.extension.inflate

class LoadingDelegateAdapter : ViewTypeDelegateAdapter {

    override fun onCreateViewHolder(parent: ViewGroup) = LoadingViewHolder(parent)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
    }

    class LoadingViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
            parent.inflate(R.layout.loading_item)) {
    }
}
