package com.loya.android.rudigo.data.model

import android.os.Parcel
import android.os.Parcelable
import com.loya.android.rudigo.commons.adapter.AdapterConstants
import com.loya.android.rudigo.commons.adapter.ViewType

data class Comment(val id: Long, val comment: String, val currentTime: String, val rating: Rating = Rating()) : ViewType {
    override fun getViewType() = AdapterConstants.COMMENT

}

data class Idea(val id: Long,
                val username: String,
                val idea: String,
                val rationale: String = "",
                val effect: String,
                val rating: Rating = Rating(),
                val time: Long) : ViewType, Parcelable {


    constructor(parcel: Parcel) : this(
            parcel.readLong(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readParcelable(Rating::class.java.classLoader),
            parcel.readLong()) {
    }

    override fun getViewType() = AdapterConstants.IDEA
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeLong(id)
        parcel.writeString(username)
        parcel.writeString(idea)
        parcel.writeString(rationale)
        parcel.writeString(effect)
        parcel.writeParcelable(rating, flags)
        parcel.writeLong(time)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Idea> {
        override fun createFromParcel(parcel: Parcel): Idea {
            return Idea(parcel)
        }

        override fun newArray(size: Int): Array<Idea?> {
            return arrayOfNulls(size)
        }
    }

}

data class User(val firstName: String, val lastName: String, val userName: String, val whatIDo: String, val phoneNumber: String)

data class Rating(val upvote: Int = 0, val downvote: Int = 0, val favorite: Int = 0, val upvoted: Boolean = false, val downVoted: Boolean = false, val favorited: Boolean = false) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readByte() != 0.toByte(),
            parcel.readByte() != 0.toByte(),
            parcel.readByte() != 0.toByte()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(upvote)
        parcel.writeInt(downvote)
        parcel.writeInt(favorite)
        parcel.writeByte(if (upvoted) 1 else 0)
        parcel.writeByte(if (downVoted) 1 else 0)
        parcel.writeByte(if (favorited) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Rating> {
        override fun createFromParcel(parcel: Parcel): Rating {
            return Rating(parcel)
        }

        override fun newArray(size: Int): Array<Rating?> {
            return arrayOfNulls(size)
        }
    }
}