package com.loya.android.rudigo.presentation.ideaslist.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.loya.android.rudigo.R
import com.loya.android.rudigo.commons.adapter.ViewType
import com.loya.android.rudigo.commons.adapter.ViewTypeDelegateAdapter
import com.loya.android.rudigo.commons.extension.getFriendlyTime
import com.loya.android.rudigo.commons.extension.inflate
import com.loya.android.rudigo.data.model.Idea
import kotlinx.android.synthetic.main.idea_item.view.*

class IdeaDelegateAdapter(val viewActions: onViewSelectedListener) : ViewTypeDelegateAdapter {

    interface onViewSelectedListener {
        fun onItemSelected(idea: Idea)
        fun onDownVoteClicked(commentId: Long, action: Boolean)
        fun onUpVoteClicked(commentId: Long, action: Boolean)
        fun onFavoriteClicked(commentId: Long, action: Boolean)
    }

    override fun onCreateViewHolder(parent: ViewGroup) = IdeaViewHolder(parent)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
        holder as IdeaViewHolder
        holder.bind(item as Idea)
    }


    inner class IdeaViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
            parent.inflate(R.layout.idea_item)) {

        fun bind(item: Idea) = with(itemView) {
            userName.text = item.username
            userIdea.text = item.idea
            time.text = item.time.getFriendlyTime()
            text_downvote.text = item.rating.downvote.toString()
            text_upvote.text = item.rating.upvote.toString()
            text_favorite.text = item.rating.favorite.toString()
            //todo: Come back here and implement actions logic[extension function]
            btn_downvote.setOnClickListener { viewActions.onDownVoteClicked(item.id, false) }
            btn_upvote.setOnClickListener { viewActions.onUpVoteClicked(item.id, false) }
            btn_favorite.setOnClickListener { viewActions.onFavoriteClicked(item.id, false) }

            super.itemView.setOnClickListener { viewActions.onItemSelected(item)}
        }
    }

}