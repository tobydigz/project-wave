package com.loya.android.rudigo.presentation.ideadetails.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.loya.android.rudigo.R
import com.loya.android.rudigo.commons.adapter.ViewType
import com.loya.android.rudigo.commons.adapter.ViewTypeDelegateAdapter
import com.loya.android.rudigo.commons.extension.inflate
import com.loya.android.rudigo.data.model.Comment
import kotlinx.android.synthetic.main.comment_item.view.*


class CommentDelegateAdapter(val viewActions: onViewSelectedListener) : ViewTypeDelegateAdapter {

    interface onViewSelectedListener {
        fun onDownVoteClicked(commentId: Long, action:Boolean)
        fun onUpVoteClicked(commentId: Long, action:Boolean)
        fun onFavoriteClicked(commentId: Long, action:Boolean)
    }

    override fun onCreateViewHolder(parent: ViewGroup) = CommentViewHolder(parent)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
        holder as CommentViewHolder
        holder.bind(item as Comment)
    }

    inner class CommentViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
            parent.inflate(R.layout.comment_item)) {

        fun bind(item: Comment) = with(itemView) {
            text_downvote.text = item.rating.downvote.toString()
            text_upvote.text = item.rating.upvote.toString()
            text_favorite.text = item.rating.favorite.toString()
            //todo: Come back here and implement actions logic[extension function]
            btn_downvote.setOnClickListener { viewActions.onDownVoteClicked(item.id, false) }
            btn_upvote.setOnClickListener { viewActions.onUpVoteClicked(item.id, false) }
            btn_favorite.setOnClickListener { viewActions.onFavoriteClicked(item.id, false) }
        }
    }


}
